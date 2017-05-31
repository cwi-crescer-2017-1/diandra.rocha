using EditoraCrescer.Infraestrutura.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    class LivroRepositorio
    {
        private Contexto contexto = new Contexto();
        public LivroRepositorio()
        {

        }
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }
    }
}