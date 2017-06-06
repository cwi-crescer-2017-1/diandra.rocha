using LocadoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class ReservaOpcionalMap : EntityTypeConfiguration<ReservaOpcional>
    {
        public ReservaOpcionalMap()
        {
            ToTable("ReservaOpcional");

            HasKey(x => x.Id);

            Property(p => p.QuantidadeOpcionais).IsRequired();

            HasOptional(x => x.Opcional)
              .WithMany()
              .Map(x => x.MapKey("IdOpcional"));
            HasOptional(x => x.Reserva)
               .WithMany()
               .Map(x => x.MapKey("IdReserva"));

        }
    }
}
