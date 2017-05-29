using Demo1.Dominio.Entidades;
using System.Collections.Generic;

namespace Demo1.Infraestrutura.Repositorios
{
    namespace Demo1.Infraestrutura.Entidades
    {
        public interface IPedidoRepositorio
        {
            void Alterar(Pedido pedido);
            void Criar(Pedido pedido);
            void Excluir(int id);
            IEnumerable<Pedido> Listar();
            Pedido Obter(int id);
        }
    }
}
