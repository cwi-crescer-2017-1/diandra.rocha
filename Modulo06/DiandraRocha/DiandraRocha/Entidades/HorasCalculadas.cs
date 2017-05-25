using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiandraRocha.Entidades
{
    public class HorasCalculadas
    {
        public HorasCalculadas(double qtdHoras, double valorTotalHoras)
        {
            QtdHoras = qtdHoras;
            ValorTotalHoras = valorTotalHoras;
        }

        public double CalculoTotalHoras()
        {
            if(QtdHoras!=0 && ValorTotalHoras != 0)
            {
                var resultado = QtdHoras * ValorTotalHoras;
                return Math.Round(resultado, 2);
            }
            return 0;
        }

        public double QtdHoras { get; private set; }
        public double ValorTotalHoras { get; private set; }
    }
}
