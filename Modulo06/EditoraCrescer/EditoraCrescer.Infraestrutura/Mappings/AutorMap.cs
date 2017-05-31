using EditoraCrescer.Infraestrutura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraestrutura.Mappings
{
    public class AutorMap : EntityTypeConfiguration<Autor>
    {

        public AutorMap()
        {
            ToTable("Autores");

            HasKey(x => x.Id);
        }
    }
}
