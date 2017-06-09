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

        public void AtribuirProduto(Reserva reserva, Produto produto)
        {
            reserva.Produto = produto;
        }

        public void AtribuirPacote(Reserva reserva,Pacote pacote)
        {
            reserva.Pacote = pacote;
        }
        public void AtribuirOpcionais(Reserva reserva, List<Opcional> opcionais)
        {
            reserva.Opcionais = opcionais;
        }

        public void AtribuirStatus(Reserva reserva, Status status)
        {
            reserva.Status = status;
        }

        public Reserva(DateTime datareserva, DateTime datadevolucaoprevista, decimal valorprevisto)
        {
            DataReserva = datareserva;
            DataDevolucaoPrevista = datadevolucaoprevista;
            ValorPrevisto = valorprevisto;
        }

        public void RealizarDevolucao(Reserva reserva)
        {
            reserva.DataDevolucaoReal = DateTime.UtcNow;
            reserva.Status = Status.Finalizado;
        }

        public decimal CalcularValorPrevisto(Reserva reserva)
        {
            decimal ValorTotal = 0;

            ValorTotal = (reserva.Produto.ValorDiaria* reserva.DiasDeReserva) + ValorTotal;

            if (reserva.Pacote !=null)
            {
                ValorTotal = ValorTotal + (reserva.Pacote.ValorDiaria * reserva.DiasDeReserva);
            }
            if (reserva.Opcionais.Count > 0)
            {
                foreach(Opcional op in Opcionais)
                {
                    ValorTotal = (op.ValorDiaria * reserva.DiasDeReserva) + ValorTotal;
                }
            }

            return ValorTotal;

        }

        public decimal CalcularValorFinal(Reserva reserva)
        {
            decimal ValorFinal = 0;

            var resultado = Nullable.Compare(reserva.DataDevolucaoReal, reserva.DataDevolucaoPrevista);
            double dias = reserva.DataDevolucaoReal.Value.Subtract(reserva.DataDevolucaoPrevista).TotalDays;

            if (resultado > 0)
            {
                reserva.AtribuirStatus(reserva, Status.Em_Atraso);
                ValorFinal = reserva.ValorPrevisto * (decimal)dias;
            }
            else
            {
                ValorFinal = reserva.ValorPrevisto;
            }

            return ValorFinal;
        }


        public int CalcularDiasDeLocacao(Reserva reserva)
        {
            return (int)(reserva.DataDevolucaoReal.Value - reserva.DataReserva).TotalDays;
        }
    }
}
