using System;
using System.Collections.Generic;

namespace Dia04Exercícios.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

 

        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>(); ;
            mensagens.Add("AAAAH");
            return true;
        }
    }    
}