using Aula05.Infraestrutura.Entidades;
using Aula05.Infraestrutura.Mappings;
using System.Data.Entity;

namespace Aula05.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEFSP"){ }

        public DbSet<Autor> Autores { get; set; }
        public DbSet<Livro> Livros { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new LivroMap());
        }
    }
}
