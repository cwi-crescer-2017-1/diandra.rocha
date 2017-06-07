using LocadoraCrescer.Dominio.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class FuncionarioRepositorio
    {
        Contexto contexto = new Contexto();

        static FuncionarioRepositorio()
        {
            var FuncionarioAtendente = new Funcionario("Arianne Martell", "atendente@atendente.com.br", "123456");
            FuncionarioAtendente.AtribuirPermissoes("Atendente");

            var FuncionarioGerente = new Funcionario("Elia Martell", "gerente@gerente.com.br", "123456");
            FuncionarioGerente.AtribuirPermissoes("Gerente");
        }

        public FuncionarioRepositorio()
        {

        }

        public void Criar(Funcionario funcionario)
        {
            contexto.Funcionarios.Add(funcionario);
            
        }

        public void Excluir(Funcionario funcionario)
        {
            contexto.Funcionarios.Remove(funcionario);
        }

        public IList<Funcionario> Listar()
        {
            return contexto.Funcionarios.ToList();
        }

        public Funcionario Obter(string email)
        {
            return contexto.Funcionarios.SingleOrDefault(x => x.Email == email);
        }
    }
}