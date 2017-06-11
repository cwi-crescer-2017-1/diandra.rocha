using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class FuncionarioRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public FuncionarioRepositorio()
        {
        }

        public void Criar(Funcionario funcionario)
        {
            contexto.Funcionarios.Add(funcionario);
            contexto.SaveChanges();
        }

        public IList<Funcionario> Listar()
        {
            return contexto.Funcionarios.ToList();
        }

        public Funcionario Obter(string email)
        {
            var funcionario =  contexto.Funcionarios.SingleOrDefault(x => x.Email == email);

            string[] roles = contexto.Funcionarios
                .Where(x => x.Email == funcionario.Email)
                .SelectMany(x => x.Permissoes)
                .Select(x => x.Nome).ToArray();

            funcionario.AtribuirPermissoes(roles);

            return funcionario;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}