namespace EditoraCrescer.Infraestrutura.Migrations
{
    using EditoraCrescer.Infraestrutura.Entidades;
    using System;
    using System.Collections.Generic;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<EditoraCrescer.Infraestrutura.Contexto>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(EditoraCrescer.Infraestrutura.Contexto context)
        {
            var permissao1 = new Permissao("Colaborador");
            var permissao2 = new Permissao("Revisor");
            var permissao3 = new Permissao("Publicador");

            context.Permissoes.AddOrUpdate(a => a.Nome, permissao1, permissao2, permissao3);

            var usuario1 = new Usuario("Mateus Teixeira", "mateusbpt1@gmail.com", "teste123", new List<Permissao>() { permissao1, permissao2 });
            var usuario2 = new Usuario("Tais Jaques", "tais.silva@cwi.com.br", "teste123", new List<Permissao>() { permissao1, permissao3 });
            var usuario3 = new Usuario("Diandra Rocha", "diandra.rocha@cwi.com.br", "teste123", new List<Permissao>() { permissao1, permissao2, permissao3 });
            var usuario4 = new Usuario("Deordines Tomazi", "deordines.tomazi@cwi.com.br", "teste123", new List<Permissao>() { permissao1 });

            context.Usuarios.AddOrUpdate(a => a.Nome, usuario1, usuario2, usuario3, usuario4);

            var autor1 = new Autor("Ludwig Von Mises");
            var autor2 = new Autor("Augusto Comte");
            var autor3 = new Autor("George R. R. Martin");
            var autor4 = new Autor("Rodrigo Constantino");
            var autor5 = new Autor("Jennifer L. Armentrout");

            context.Autores.AddOrUpdate(a => a.Nome, autor1, autor2, autor3, autor4, autor5);

            var livro1 = new Livro()
            {
                Titulo = "Libertarianismo",
                Descricao = "Livro sobre economia e fliosofia liberal",
                Genero = "Economia e Filosofia",
                DataPublicacao = new DateTime(1964, 10, 04),
                IdAutor = autor1.Id,
                Autor = autor1,
                UsuarioRevisor = usuario1,
                IdUsuarioRevisor = usuario1.Id,
                DataRevisao = new DateTime(2010, 10, 10),
                Capa = "http://cdn.mises.org.br/images/ebooks_thumbs/44.png",

            };
            var livro2 = new Livro()
            {
                Titulo = "Os Pensadores",
                Descricao = "Livro sobre filosofia positiva",
                Genero = "Filosofia",
                DataPublicacao = new DateTime(1974, 11, 04),
                IdAutor = autor2.Id,
                Autor = autor2,
                UsuarioRevisor = usuario1,
                IdUsuarioRevisor = usuario1.Id,
                DataRevisao = new DateTime(2012, 12, 01),
                Capa = "http://lelivros.love/wp-content/uploads/2017/05/Baixar-Livro-Auguste-Comte-Os-Pensadores-em-Pdf-ePub-e-Mobi-ou-ler-online-370x470.jpg"


            };
            var livro3 = new Livro()
            {
                Titulo = "A mão do homem morto",
                Descricao = "Os super-heróis mais poderosos e os vilões mais bizarros estão de volta nos novos volumes da saga de ficção científica de George R.R. Martin",
                Genero = "Ficção",
                IdAutor = autor3.Id,
                Autor = autor3,
                UsuarioRevisor = usuario3,
                IdUsuarioRevisor = usuario3.Id,
                DataRevisao = new DateTime(2011, 01, 10),
                DataPublicacao = new DateTime(2015, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/04/Baixar-Livro-A-Mao-do-Homem-Morto-Wild-Cards-Vol-07-George-R.-R.-Martin-em-Pdf-Epub-e-Mobi-Ou-Ler-Onine-370x509.jpg"


            };
            var livro4 = new Livro()
            {
                Titulo = "Economia do indivíduo",
                Descricao = "São 223 páginas que sintetizam anos e anos de estudos e análises do comportamento humano, da economia e das relações entre os indivíduos.",
                Genero = "Economia",
                DataPublicacao = new DateTime(1975, 10, 04),
                IdAutor = autor4.Id,
                Autor = autor4,
                UsuarioRevisor = usuario1,
                IdUsuarioRevisor = usuario1.Id,
                DataRevisao = new DateTime(2010, 07, 15),
                Capa = "http://lelivros.love/wp-content/uploads/2014/02/Download-Economia-do-Individuo-Rodrigo-Constantino-em-epub-mobi-e-pdf-370x552.jpg"
            };
            var livro5 = new Livro()
            {
                Titulo = "Espero por você",
                Descricao = "Algumas coisas valem a pena esperar. Algumas coisas valem a pena experimentar. Algumas coisas não devem ser mantidas em silêncio. E, por algumas coisas, vale a pena lutar. Avery Morgansten precisa fugir. Ir para uma faculdade a centenas de quilômetros de casa foi a única forma que encontrou para esquecer o acontecimento fatídico que, cinco anos antes, mudara a sua vida para sempre. ",
                Genero = "Romance",
                DataPublicacao = new DateTime(2010, 10, 04),
                IdAutor = autor5.Id,
                Autor = autor5,
                UsuarioRevisor = usuario3,
                IdUsuarioRevisor = usuario3.Id,
                DataRevisao = new DateTime(2014, 10, 05),
                Capa = "http://lelivros.love/wp-content/uploads/2017/03/Baixar-Livro-Espero-por-Voce-Jennifer-L.-Armentrout-em-PDF-ePub-e-Mobi-ou-ler-online-370x532.jpg"
            };

            context.Livros.AddOrUpdate(a => a.Titulo, livro1, livro2, livro3, livro4, livro5);
        }
    }
}
