using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ReservaRepositorio
    {
        Contexto contexto = new Contexto();

        public ReservaRepositorio()
        {
        }

        public void CalcularValorFinal(Reserva reserva)
        {
            decimal ValorFinal = 0;
            var resultado = Nullable.Compare(reserva.DataDevolucaoReal, reserva.DataDevolucaoPrevista);
            double dias = reserva.DataDevolucaoReal.Value.Subtract(reserva.DataDevolucaoPrevista).TotalDays;

            if (resultado > 0)
            {
                reserva.AtribuirStatus(Status.Em_Atraso);
                ValorFinal = reserva.ValorPrevisto * (decimal)dias;
            }
            else
            {
                ValorFinal = reserva.ValorPrevisto;
            }
        }

        public int CalcularDiasDeLocacao(Reserva reserva)
        {
            return (int)(reserva.DataDevolucaoReal.Value - reserva.DataReserva).TotalDays;
        }

        public void Criar(Reserva reserva, Produto produto, Pacote pacote, List<Opcional> opcionais)
        {
            reserva.AtribuirProduto(produto);

            if(pacote !=null)
            reserva.AtribuitPacote(pacote);

            if (opcionais.Count > 0)
                reserva.AtribuirOpcionais(opcionais);

            

            contexto.Reservas.Add(reserva);
            contexto.SaveChanges();
        }

        public void AtribuirAdicionais()
        {

        }

        public List<Reserva> ObterTodos()
        {
            return contexto.Reservas.ToList();
        }

        public Reserva ObterPorId(int id)
        {
            return contexto.Reservas.SingleOrDefault(x => x.Id == id);
        }
    }
}
