using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public RevisorRepositorio()
        {

        }

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor ObterPorId(int id)
        {
            return contexto.Revisores.SingleOrDefault(x => x.Id == id);
        }

        public bool VerificarRevisor(Revisor revisor)
        {
            return contexto.Revisores.Count(x => x.Id == revisor.Id) != 0;
        }

        public void Adicionar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public Revisor Atualizar(int id, Revisor revisor)
        {

            contexto.Entry(revisor).State = System.Data.Entity.EntityState.Modified;

            contexto.SaveChanges();
            return revisor;
        }

        public void Deletar(int Id)
        {
            var itemToRemove = contexto.Revisores.SingleOrDefault(x => x.Id == Id);
            if (itemToRemove != null)
            {
                contexto.Revisores.Remove(itemToRemove);
                contexto.SaveChanges();
            }

        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
