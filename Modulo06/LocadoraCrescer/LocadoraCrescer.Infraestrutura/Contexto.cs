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
        public DbSet<Endereco> Enderecos { get; set; }
        public DbSet<Funcionario> Funcionarios { get; set; }
        public DbSet<Opcional> Opcionais { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Produto> Produtos { get; set; }
        public DbSet<Reserva> Reservas { get; set; }
        public DbSet<ReservaOpcional> ReservaOpcionais { get; set; }
        public DbSet<Permissao> Permissoes { get; set; }


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
            modelBuilder.Configurations.Add(new PermissaoMap());

        }
    }

}

