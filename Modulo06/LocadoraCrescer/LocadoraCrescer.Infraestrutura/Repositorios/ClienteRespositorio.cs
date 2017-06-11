using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ClienteRespositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public ClienteRespositorio()
        {
        }

        public void Criar(Cliente cliente)
        {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
        }

        public List<Cliente> ObterTodos()
        {
            return contexto.Clientes.ToList();
        }

        public Cliente ObterPorCPF(string cpf)
        {
            return contexto.Clientes.SingleOrDefault(x => x.CPF == cpf);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
