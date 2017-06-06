using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class ReservaOpcional
    {
        public Opcional Opcional  { get; set; }
        public int IdOpcional { get; set; }
        public Reserva Reserva { get; set; }
        public int IdReserva { get; set; }
        public int QuantidadeOpcionais { get; set; }

    }
}
