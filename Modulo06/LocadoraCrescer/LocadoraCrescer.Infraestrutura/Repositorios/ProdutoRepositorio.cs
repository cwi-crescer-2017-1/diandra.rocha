using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio
    {
        Contexto contexto = new Contexto();
        public ProdutoRepositorio()
        {

        }

        public List<Produto> ObterTodos()
        {
            return contexto.Produtos.ToList();
        }

        public Produto ObterPorId(int id)
        {
            return contexto.Produtos.FirstOrDefault(x => x.Id == id);
        }
    }
}
