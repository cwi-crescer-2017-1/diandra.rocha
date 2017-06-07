using LocadoraCrescer.Dominio.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class EnderecoRepositorio
    {
        Contexto contexto = new Contexto();

        public EnderecoRepositorio()
        {
        }

        public void Criar(Endereco endereco)
        {
            contexto.Enderecos.Add(endereco);
            contexto.SaveChanges();
        }

        public List<Endereco> ObterTodos()
        {
            return contexto.Enderecos.ToList();
        }

        public Endereco ObterPorCep(string cep)
        {
            return contexto.Enderecos.FirstOrDefault(x => x.Cep == cep);
        }
    }
}
