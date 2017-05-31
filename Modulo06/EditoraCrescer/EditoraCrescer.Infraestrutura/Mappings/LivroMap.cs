using EditoraCrescer.Infraestrutura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraestrutura.Mappings
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
