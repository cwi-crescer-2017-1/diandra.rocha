using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public AutorRepositorio()
        {

        }

        public List<Autor> Obter()
        {
           return contexto.Autores.ToList();

        }

        public Autor ObterPorId(int id)
        {
            return contexto.Autores.SingleOrDefault(x => x.Id == id);
        }

        public bool VerificarAutor(Autor autor)
        {
            return contexto.Autores.Count(x => x.Id == autor.Id) != 0;
        }

        public void Adicionar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public Autor Atualizar(int id, Autor autor)
        {

            contexto.Entry(autor).State = System.Data.Entity.EntityState.Modified;

            contexto.SaveChanges();
            return autor;
        }

        public void Deletar(int Id)
        {
            var itemToRemove = contexto.Autores.SingleOrDefault(x => x.Id == Id);
            if (itemToRemove != null)
            {
                contexto.Autores.Remove(itemToRemove);
                contexto.SaveChanges();
            }

        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
