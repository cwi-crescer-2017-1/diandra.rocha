using Dia04Exercício.Infraestrutura.Repositorios;
using Dia04Exercícios.Dominio.Entidades;
using Dia04Exercícios.Infraestrutura.Repositorios;
using System.Linq;

namespace Dia04Exercício.WebApi.Models
{
    public class PedidoServico

    {
        private ProdutoRepositorio produtoRep;

        public PedidoServico(ProdutoRepositorio produtoRep)
        {
            this.produtoRep = produtoRep;
        }

        public bool ValidarPedido(Pedido pedido)
        {
            var Resultado = false;
            var ItensPedido = pedido.Itens;
            var produtos = produtoRep.Listar();

            var produtosVerificar = produtos.Where(p => ItensPedido.Any(pi => pi.Id == pi.Id)).ToList(); ;

            foreach (Produto produto in produtosVerificar)
            {
                Resultado = produto.Estoque <= 0;
            }
            return !Resultado;
        }
    }
}
