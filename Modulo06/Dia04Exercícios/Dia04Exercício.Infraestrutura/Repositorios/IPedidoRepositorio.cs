using Dia04Exercícios.Dominio.Entidades;
using System.Collections.Generic;

namespace Dia04Exercício.Infraestrutura.Repositorios
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
