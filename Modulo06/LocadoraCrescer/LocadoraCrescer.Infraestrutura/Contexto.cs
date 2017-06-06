using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Mappings;
using System.Data.Entity;

namespace LocadoraCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=MyString")
        { }

        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Cliente> Enderecos { get; set; }
        public DbSet<Cliente> Funcionarios { get; set; }
        public DbSet<Cliente> Opcionais { get; set; }
        public DbSet<Cliente> Pacotes { get; set; }
        public DbSet<Cliente> Produtos { get; set; }
        public DbSet<Cliente> Reservas { get; set; }
        public DbSet<Cliente> ReservaOpcionais { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new EnderecoMap());
            modelBuilder.Configurations.Add(new FuncionarioMap());
            modelBuilder.Configurations.Add(new OpcionalMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new ProdutoMap());
            modelBuilder.Configurations.Add(new ReservaMap());
            modelBuilder.Configurations.Add(new ReservaOpcionalMap());

        }
    }

}

