using LocadoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
        {
            ToTable("Pacote");

            HasKey(x => x.Id);

            Property(p => p.Nome).HasMaxLength(300).IsRequired();
            Property(p => p.Descricao).HasMaxLength(300).IsRequired();
            Property(p => p.ValorDiaria).IsRequired();
        }
    }
}
