using LocadoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class OpcionalMap : EntityTypeConfiguration<Opcional>
    {
        public OpcionalMap()
        {
            ToTable("Opcional");

            HasKey(x => x.Id);

            Property(p => p.Nome).HasMaxLength(300).IsRequired();
            Property(p => p.Descricao).HasMaxLength(300).IsRequired();
            Property(p => p.ValorDiaria).IsRequired();
            Property(p => p.QuantidadeDisponivel).IsRequired();
        }
    }
}
