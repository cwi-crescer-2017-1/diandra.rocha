using Aula05.Infraestrutura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace Aula05.Infraestrutura.Mappings
{
    class LivroMap : EntityTypeConfiguration<Livro>
    {
        public LivroMap()
        {
            ToTable("Livros");

            HasKey(x => x.Isbn);

            HasRequired(x => x.Autor)
                .WithMany()
                .HasForeignKey(x => x.IdAutor);
        }
       
    }
}
