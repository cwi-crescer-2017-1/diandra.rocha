using System;
using System.Collections.Generic;

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
        public string Status { get; private set; }
        public Cliente Cliente { get; private set; }
        public Pacote Pacote { get; private set; }
        public Produto Produto { get; private set; }
        public List<ReservaOpcional> Opcionais { get; private set; }

        protected Reserva()
        {

        }

        public Reserva(DateTime datareserva, DateTime datadevolucaoprevista, decimal valorprevisto, string status, Cliente cliente, Produto produto)
        {
            DataReserva = datareserva;
            DataDevolucaoPrevista = datadevolucaoprevista;
            ValorPrevisto = valorprevisto;
            Status = status;
            Cliente = cliente;
            Produto = produto;
        }
    }
}
