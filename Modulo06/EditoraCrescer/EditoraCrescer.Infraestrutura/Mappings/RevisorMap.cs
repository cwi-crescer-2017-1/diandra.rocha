using EditoraCrescer.Infraestrutura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraestrutura.Mappings
{
    public class RevisorMap : EntityTypeConfiguration<Revisor>
    {
        public RevisorMap()
        {
            ToTable("Revisores");

            HasKey(x => x.Id);

        } 
    }
}
