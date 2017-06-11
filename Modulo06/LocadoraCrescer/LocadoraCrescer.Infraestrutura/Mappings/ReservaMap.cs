using LocadoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class ReservaMap : EntityTypeConfiguration<Reserva>
    {
        public ReservaMap()
        {

            ToTable("Reserva");

            HasKey(x => x.Id);

            Property(p => p.DataReserva).IsRequired();
            Property(p => p.DataDevolucaoPrevista).IsRequired();
            Property(p => p.DataDevolucaoReal);
            Property(p => p.ValorPrevisto).IsRequired();
            Property(p => p.ValorFinal);
            Property(p => p.DiasDeReserva);
            Property(p => p.Status).IsRequired();

            HasOptional(x => x.Cliente)
               .WithMany()
               .Map(x => x.MapKey("IdCliente"));

            HasOptional(x => x.Pacote)
               .WithMany()
               .Map(x => x.MapKey("IdPacote"));

            HasOptional(x => x.Produto)
               .WithMany()
               .Map(x => x.MapKey("IdProduto"));

        }
    }
}
