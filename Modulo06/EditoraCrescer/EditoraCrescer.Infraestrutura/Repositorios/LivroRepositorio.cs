using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public LivroRepositorio()
        {

        }
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public Livro ObterPorIsbn(int isbn)
        {
            return contexto.Livros.SingleOrDefault(x => x.Isbn == isbn);
        }

        public List<Livro> ObterPorGenero(string genero)
        {
            return contexto.Livros.Where(x => x.Genero.Contains(genero)).ToList();
        }

        public void Adicionar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }
        public void Deletar(int Isbn)
        {
            var itemToRemove = contexto.Livros.SingleOrDefault(x => x.Isbn == Isbn);
            if (itemToRemove != null)
            {
                contexto.Livros.Remove(itemToRemove);
                contexto.SaveChanges();
            }

        }
        public Livro Atualizar(int isbn, Livro livro)
        {

            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;

            contexto.SaveChanges();
            return livro;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}