using LocadoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {

            ToTable("Cliente");

            HasKey(x => x.Id);

            Property(p => p.Nome).HasMaxLength(300).IsRequired();
            Property(p => p.Sobrenome).HasMaxLength(300).IsRequired();
            Property(p => p.CPF).HasMaxLength(15).IsRequired();
            Property(p => p.DataNascimento).IsRequired();
            Property(p => p.Genero).IsRequired();

        }
    }
}
