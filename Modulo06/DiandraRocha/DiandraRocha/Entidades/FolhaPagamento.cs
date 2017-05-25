using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiandraRocha.Entidades
{

    public class FolhaPagamento : IFolhaPagamento
    {

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {

            HorasCalculadas HorasDescontadas = new HorasCalculadas(horasDescontadas, (salarioBase/horasCategoria));
            HorasCalculadas HorasExtra = new HorasCalculadas(horasExtras, (salarioBase / horasCategoria));

            var HorasDescontadasValor = HorasDescontadas.CalculoTotal();
            var HorasExtrasValor = HorasExtra.CalculoTotal();

            double TotalProventos = salarioBase + HorasExtrasValor - HorasDescontadasValor;

            Desconto inss = new Desconto();
            if(salarioBase <= 1000.00)
                inss = new Desconto(TotalProventos, 8);
            if (salarioBase > 1000.00 && salarioBase <= 1500.00)
                inss = new Desconto(TotalProventos, 9);
            if (salarioBase > 1500.00)
                inss = new Desconto(TotalProventos, 10);

            var DescontoInss = inss.CalculoTotal();

           var  TotalProventosSemInss = TotalProventos - DescontoInss;

            Desconto irrf = new Desconto();
            if (TotalProventosSemInss >= 4271.59)
                irrf = new Desconto(TotalProventosSemInss, 27.5);
            if (TotalProventosSemInss > 3418.59 && TotalProventosSemInss <= 4271.59)
                irrf = new Desconto(TotalProventosSemInss, 22.5);
            if(TotalProventosSemInss > 2563.91 && TotalProventosSemInss <= 3418.59)
                irrf = new Desconto(TotalProventosSemInss, 15);
            if (TotalProventosSemInss > 1710.78 && TotalProventosSemInss <= 2563.91)
                irrf = new Desconto(TotalProventosSemInss, 7.5);

            var DescontoIrrf = irrf.CalculoTotal();

            var TotalDescontos = DescontoInss + DescontoIrrf;
            var SalarioLiquido = TotalProventos - TotalDescontos;

            Desconto Fgts = new Desconto (salarioBase , 11);
            Fgts.CalculoTotal();

            salarioBase = Math.Round(salarioBase, 2);
            TotalProventos = Math.Round(TotalProventos, 2);
            TotalDescontos = Math.Round(TotalDescontos, 2);
            SalarioLiquido = Math.Round(SalarioLiquido, 2);

            Demonstrativo demo = new Demonstrativo(salarioBase, horasCategoria, HorasExtra, HorasDescontadas, TotalProventos
                , inss, irrf, TotalDescontos, SalarioLiquido, Fgts);

            return demo;
        }
    }

}
