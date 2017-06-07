using LocadoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class FuncionarioMap : EntityTypeConfiguration<Funcionario>
    {
        public FuncionarioMap()
        {
            ToTable("Funcionario");

            HasKey(x => x.Id);

            Property(p => p.Nome).HasMaxLength(300).IsRequired();
            Property(p => p.Email).HasMaxLength(300).IsRequired();
            Property(p => p.Senha).IsRequired();
        }

    }
}
