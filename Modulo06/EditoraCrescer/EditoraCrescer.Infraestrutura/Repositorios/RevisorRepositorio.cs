using EditoraCrescer.Infraestrutura.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public RevisorRepositorio()
        {

        }
        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }
        public void Adicionar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
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
    }
}
