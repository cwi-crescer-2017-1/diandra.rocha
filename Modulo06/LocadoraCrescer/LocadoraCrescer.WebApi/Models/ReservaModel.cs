using System;
using System.Collections.Generic;

namespace LocadoraCrescer.WebApi.Models
{
    public class ReservaModel
    {
        public DateTime Devolucao { get; set; }
        public DateTime Reserva { get; set; }
        public string Cliente { get; set; }
        public int Produto { get; set; }
        public int Pacote { get; set; }
        public List<int> Opcionais { get; set; }

        public ReservaModel(DateTime devolucao,DateTime reserva, string cliente, int produto, int pacote, List<int> opcionais)
        {     
            Devolucao = devolucao;
            Reserva = reserva;
            Cliente = cliente;
            Produto = produto;
            Pacote = pacote;
            Opcionais = opcionais;
        }

        public ReservaModel()
        {
        }
    }
}