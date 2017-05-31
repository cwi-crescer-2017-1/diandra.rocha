﻿using System;

namespace Aula05.Infraestrutura.Entidades
{
    public class Livro
    {
        public int Isbn { get; set; }
        public string Titulo { get; set; }
        public string Descricao { get; set; }
        public string Genero { get; set; }
        public DateTime DataPublicacao { get; set; }
        public int IdAutor { get; set; }
        public Autor Autor { get; set; }
    }

}
