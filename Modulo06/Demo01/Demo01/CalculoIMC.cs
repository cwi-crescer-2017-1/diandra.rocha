using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo01
{
    class CalculoIMC
    {
        public double Altura { get; set; }

        public double Peso { get; set; }

        public CalculoIMC(double altura, double peso)
        {
            Altura = altura;
            Peso = peso;
        }

        public double CalcularIMC()
        {
            return Peso / (Math.Pow(Altura, 2));
        }
        //prop : cria propriedade
        //propg: get public, set private
        //ctor: cria o construtor
    }
}
