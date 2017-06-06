using LocadoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class ProdutoMap : EntityTypeConfiguration<Produto>
    {
        public ProdutoMap()
        {
            ToTable("Produto");

            HasKey(x => x.Id);

            Property(p => p.Nome).HasMaxLength(300).IsRequired();
            Property(p => p.Descricao).HasMaxLength(300).IsRequired();
            Property(p => p.ValorDiaria).IsRequired();
            Property(p => p.URLFoto).IsRequired();
            Property(p => p.QuantidadeDisponivel).IsRequired();
        }
    }
}
