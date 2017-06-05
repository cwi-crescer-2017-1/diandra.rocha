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

        public List<dynamic> Obter()
        {
            var livros = contexto.Livros.ToList();

            return contexto.Livros.Select(x =>
            new { Isbn = x.Isbn, Titulo = x.Titulo, Capa = x.Capa, NomeAutor = x.Autor.Nome, Genero = x.Genero })
            .ToList<dynamic>();
        }

        public Livro ObterPorIsbn(int isbn)
        {
            return contexto.Livros.SingleOrDefault(x => x.Isbn == isbn);
        }

        public List<dynamic> ObterPorGenero(string genero)
        {
            var lista =  contexto.Livros.Where(x => x.Genero.Contains(genero)).ToList();

            return lista.Select(x =>
            new { Isbn = x.Isbn, Titulo = x.Titulo, Capa = x.Capa, NomeAutor = x.Autor.Nome, Genero = x.Genero })
            .ToList<dynamic>();
        }

        public List<dynamic> ObterPorData()
        {
            var livros = contexto.Livros.ToList();

            var data7DiasAtras = DateTime.Now.AddDays(-7);

            return livros.Where(x => x.DataPublicacao > data7DiasAtras).Select(x =>
            new { Isbn = x.Isbn, Titulo = x.Titulo, Capa = x.Capa, NomeAutor = x.Autor.Nome, Genero = x.Genero })
            .ToList<dynamic>();
        }

        public List<dynamic> ObterParaPaginação(int qtdTrazer, int qtdPular)
        {
            return contexto.Livros.Select(x =>
            new { Titulo = x.Titulo, Capa = x.Capa, Genero = x.Genero, NomeAutor = x.Autor.Nome })
            .OrderBy(p => p.Titulo)
            .Take(qtdTrazer)
            .Skip(qtdPular)
            .ToList<dynamic>();

        }

        public int ContadorTodosLivros()
        {
            return contexto.Livros.Count();
        }

        public Livro publicar(Livro livro)
        {
            livro.DataPublicacao = DateTime.Now;
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;

            contexto.SaveChanges();
            return livro;
        }

        public bool VerificarLivro(Livro livro)
        {
            return contexto.Livros.Count(x => x.Isbn == livro.Isbn) != 0;
        }


        public void Adicionar(Livro livro)
        {
            livro.Autor = contexto.Autores.FirstOrDefault(x => x.Id == livro.Autor.Id);
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }
        public bool VerificarAdicionarLivro(Livro livro)
        {
            return livro.Autor == null;
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