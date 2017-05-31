using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Mappings;
using System.Data.Entity;

namespace EditoraCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=MyString") { }

        public DbSet<Autor> Autores { get; set; }
        public DbSet<Livro> Livros { get; set; }
        public DbSet<Revisor> Revisores { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new LivroMap());
            modelBuilder.Configurations.Add(new RevisorMap());
        }
    }
}
