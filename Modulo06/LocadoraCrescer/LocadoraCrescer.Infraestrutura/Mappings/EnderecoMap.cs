using LocadoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class EnderecoMap : EntityTypeConfiguration<Endereco>
    {
        public EnderecoMap()
        {
            ToTable("Endereco");

            HasKey(x => x.Id);

            Property(p => p.Cep).HasMaxLength(15).IsRequired();
            Property(p => p.Rua).HasMaxLength(300).IsRequired();
            Property(p => p.Numero).IsRequired();
            Property(p => p.Cidade).HasMaxLength(300).IsRequired();
            Property(p => p.Uf).HasMaxLength(2).IsRequired();

            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));
        }
    }
}
