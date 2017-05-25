using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiandraRocha.Entidades
{
    public class Demonstrativo
    {
        public Demonstrativo(
            double salarioBase,
            double hrsConvencao,
            HorasCalculadas horasExtras,
            HorasCalculadas horasDescontadas,
            double totalProventos,
            Desconto inss,
            Desconto irrf,
            double totalDescontos,
            double totalLiquido,
            Desconto fgts)
        {
            SalarioBase = salarioBase;
            HrsConvencao = hrsConvencao;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = totalProventos;
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = totalDescontos;
            TotalLiquido = totalLiquido;
            Fgts = fgts;
        }

        public void printarDemo()
        {
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-DEMONSTRATIVO DE FOLHA DE PAGAMENTO(CONTRA - CHEQUE)");
            Console.WriteLine("+---------------------------------------------------+"); 
            Console.WriteLine("Salário mensalista: (" + HrsConvencao + ")" + "        " + SalarioBase);
            Console.WriteLine("Horas extra: (" + HorasExtras.QtdHoras + ")" + "        " + HorasExtras.CalculoTotalHoras());
            Console.WriteLine("Horas extra: (" + HorasDescontadas.QtdHoras + ")" + "        " + HorasDescontadas.CalculoTotalHoras());
            Console.WriteLine("Total de proventos: " + "        " + TotalProventos);
            Console.WriteLine("INSS: (" + Inss.Aliquota + "%)"+ "        " + Inss.CalculoTotal());
            Console.WriteLine("IRRF: (" + Irrf.Aliquota + "%)" + "        " + Irrf.CalculoTotal());
            Console.WriteLine("Total de Descontos: " + "        " + TotalDescontos);
            Console.WriteLine("Salário Liquído:" + "        " + TotalLiquido);
            Console.WriteLine("FGTS: (" + Fgts.Aliquota + "%)" + "        " + Fgts.CalculoTotal());
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-----------------------FIM---------------------------");
            Console.WriteLine("+---------------------------------------------------+");

            Console.ReadKey();
        }

        public double SalarioBase { get; private set; }
        public double HrsConvencao { get; private set; }
        public HorasCalculadas HorasExtras { get; private set; }
        public HorasCalculadas HorasDescontadas { get; private set; }
        public double TotalProventos { get; private set; }
        public Desconto Inss { get; private set; }
        public Desconto Irrf { get; private set; }
        public double TotalDescontos { get; private set; }
        public double TotalLiquido { get; private set; }
        public Desconto Fgts { get; private set; }
    }
}
