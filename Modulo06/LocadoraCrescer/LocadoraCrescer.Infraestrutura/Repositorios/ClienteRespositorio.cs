using LocadoraCrescer.Dominio.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ClienteRespositorio
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

        public void Excluir(Cliente cliente)
        {
            contexto.Clientes.Remove(cliente);
            contexto.SaveChanges();
        }

        public IList<Cliente> Listar()
        {
            return contexto.Clientes.ToList();
        }

        public Cliente ObterPorCPF(string cpf)
        {
            return contexto.Clientes.SingleOrDefault(x => x.CPF == cpf);
        }

    }
}
