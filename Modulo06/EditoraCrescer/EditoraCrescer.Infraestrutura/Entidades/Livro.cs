using System;

namespace EditoraCrescer.Infraestrutura.Entidades
{
    public class Livro
    {
        public int Isbn { get; private set; }
        public string Titulo { get; private set; }
        public string Descricao { get; private set; }
        public string Genero { get; private set; }
        public DateTime DataPublicacao { get; private set; }
        public int IdAutor { get; private set; }
        public Autor Autor { get; set; }
        public Usuario UsuarioRevisor { get; set; }
        public int IdUsuarioRevisor { get; private set; }
        public DateTime DataRevisao { get; private set; }
        public string Capa { get; private set; }

    }

}