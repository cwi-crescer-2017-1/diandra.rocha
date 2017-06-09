using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ReservaRepositorio
    {
        Contexto contexto = new Contexto();

        public ReservaRepositorio()
        {
        }


        public void Criar(Reserva reserva, int IdProduto, int IdPacote, List<int> opcionais)
        {
            var produto = contexto.Produtos.FirstOrDefault(x => x.Id == IdProduto);
            produto.DiminuirEstoque(produto);

            reserva.AtribuirProduto(reserva, produto);
            if (IdPacote >= 0)
            {
                var pacote = contexto.Pacotes.FirstOrDefault(x => x.Id == IdPacote);
                reserva.AtribuirPacote(reserva, pacote);

            }
            if (opcionais.Count > 0)
            {
                List<Opcional> lista = new List<Opcional>();

                foreach (int op in opcionais)
                {
                    var opcional = contexto.Opcionais.SingleOrDefault(x => x.Id == op);
                    opcional.DiminuirEstoque(opcional);
                    lista.Add(opcional);
                }

                reserva.AtribuirOpcionais(reserva, lista);

            }
            reserva.CalcularDiasDeLocacao(reserva);
            reserva.CalcularValorPrevisto(reserva);
            reserva.CalcularValorFinal(reserva);

            contexto.Reservas.Add(reserva);
            contexto.SaveChanges();
        }

        public List<Reserva> ObterTodos()
        {
            return contexto.Reservas.ToList();
        }

        public Reserva ObterPorId(int id)
        {
            return contexto.Reservas.SingleOrDefault(x => x.Id == id);
        }
    }
}
