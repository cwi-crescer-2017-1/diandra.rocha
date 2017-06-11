using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ReservaRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public ReservaRepositorio()
        {
        }

        public void Criar(DateTime dataDevolucao, DateTime dataReserva, string cpf, int IdProduto, int IdPacote, List<int> opcionais)
        {
            Reserva reserva = new Reserva();

            reserva.AtribuirDataDevolucaoPrevista(dataDevolucao);
            reserva.AtribuirDataReserva(dataReserva);

            var cliente = contexto.Clientes.SingleOrDefault(x => x.CPF.Equals(cpf));
            reserva.AtribuirCliente(cliente);

            var produto = contexto.Produtos.SingleOrDefault(x => x.Id == IdProduto);
            reserva.AtribuirProduto(produto);

            var pacote = contexto.Pacotes.SingleOrDefault(x => x.Id == IdPacote);
            reserva.AtribuirPacote(pacote);
       
            if (opcionais.Count >= 0)
            {
                List<Opcional> lista = new List<Opcional>();

                foreach (int op in opcionais)
                {
                    var opcional = contexto.Opcionais.SingleOrDefault(x => x.Id == op);
                    lista.Add(opcional);
                }

                reserva.AtribuirOpcionais(lista);

            }

            reserva.CalcularDiasDeLocacao();
            reserva.CalcularValorPrevisto();

            contexto.Reservas.Add(reserva);
            contexto.SaveChanges();
        }

        public void RealizarDevolucao(int idreserva)
        {
            var Reserva = contexto.Reservas.SingleOrDefault(x => x.Id == idreserva);
            Reserva.Produto.AumentarEstoque();

            foreach(Opcional op in Reserva.Opcionais)
            {
                op.AumentarEstoque();
            }

            contexto.Entry(Reserva).State = System.Data.Entity.EntityState.Modified;
            contexto.Entry(Reserva.Produto).State = System.Data.Entity.EntityState.Modified;
            contexto.Entry(Reserva.Opcionais).State = System.Data.Entity.EntityState.Modified;

            Reserva.RealizarDevolucao();
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

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
