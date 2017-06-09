using System;
using System.Collections.Generic;
using System.ComponentModel;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Reserva
    {
        public int Id { get; private set; }
        public DateTime DataReserva { get; private set; }
        public DateTime DataDevolucaoPrevista { get; private set; }
        public DateTime? DataDevolucaoReal { get; private set; }
        public decimal ValorPrevisto { get; private set; }
        public decimal? ValorFinal { get; private set; }
        public int DiasDeReserva { get; private set; }
        [DefaultValue(Status.Em_Andamento)]
        public Status Status { get; private set; }
        public Cliente Cliente { get; private set; }
        public Pacote Pacote { get; private set; }
        public Produto Produto { get; private set; }
        public List<Opcional> Opcionais { get; private set; }

        protected Reserva()
        {

        }

        public void AtribuirProduto(Produto produto)
        {
            Produto = produto;
        }

        public void AtribuitPacote(Pacote pacote)
        {
            Pacote = pacote;
        }
        public void AtribuirOpcionais(List<Opcional> opcionais)
        {
            Opcionais = opcionais;
        }

        public void AtribuirStatus(Status status)
        {
            Status = status;
        }

        public Reserva(DateTime datareserva, DateTime datadevolucaoprevista, decimal valorprevisto, int idCliente)
        {
            DataReserva = datareserva;
            DataDevolucaoPrevista = datadevolucaoprevista;
            ValorPrevisto = valorprevisto;
        }

        public void ValidarDataDevolucao(DateTime datadevolucao)
        {
            var resultado = Nullable.Compare(DataDevolucaoReal, DataDevolucaoPrevista);

            if (resultado > 0)
            {

            }
        }

        public void RealizarDevolucao()
        {
            DataDevolucaoReal = DateTime.UtcNow;
            Status = Status.Finalizado;
        }

        public void CalcularValorPrevisto(Reserva Reserva)
        {
            decimal ValorTotal = 0;

            ValorTotal = Reserva.Produto.ValorDiaria + ValorTotal;

            if (Reserva.Pacote !=null)
            {
                ValorTotal = ValorTotal + Reserva.Pacote.ValorDiaria;
            }

        }
    }
}
