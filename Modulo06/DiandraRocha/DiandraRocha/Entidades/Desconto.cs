using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiandraRocha.Entidades
{
    public class Desconto : Calculo
    {
        public Desconto(double valor, double aliquota)
        {
            Valor = valor;
            Aliquota = aliquota;
            
        }

        public Desconto()
        {

        }

        public double CalculoTotal()
        {
            var resultado = (Valor / 100) * Aliquota;
            return Math.Round(resultado, 2);
        }

        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }
}
