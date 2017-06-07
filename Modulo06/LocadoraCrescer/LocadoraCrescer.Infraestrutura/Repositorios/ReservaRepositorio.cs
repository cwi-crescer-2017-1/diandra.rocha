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

        public void Criar(Reserva reserva)
        {
            contexto.Reservas.Add(reserva);
            contexto.SaveChanges();
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
