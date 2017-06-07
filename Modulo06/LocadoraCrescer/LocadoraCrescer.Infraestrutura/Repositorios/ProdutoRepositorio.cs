using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.repoClientesitorios
{
    public class ProdutorepoClientesitorio
    {
        Contexto contexto = new Contexto();
        public ProdutorepoClientesitorio()
        {

        }

        public List<Produto> Obter()
        {
            return contexto.Produtos.ToList();
        }

        public Produto ObterPorId(int id)
        {
            return contexto.Produtos.FirstOrDefault(x => x.Id == id);
        }
    }
}
