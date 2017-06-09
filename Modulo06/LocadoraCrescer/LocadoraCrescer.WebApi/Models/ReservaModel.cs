using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraCrescer.WebApi.Models
{
    public class ReservaModel
    {
        public DateTime Devolucao { get; set; }
        public string Cliente { get; set; }
        public int Produto { get; set; }
        public int Pacote { get; set; }
        public List<int> Opcionais { get; set; }

        public ReservaModel(string cliente, DateTime devolucao, int produto, int pacote, List<int> opcionais)
        {
            Cliente = cliente;
            Devolucao = devolucao;
            Produto = produto;
            Pacote = pacote;
            Opcionais = opcionais;
        }
    }
}