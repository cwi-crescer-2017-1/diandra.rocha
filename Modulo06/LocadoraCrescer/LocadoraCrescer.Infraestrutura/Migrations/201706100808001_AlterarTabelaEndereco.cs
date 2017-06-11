namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlterarTabelaEndereco : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Endereco", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.Endereco", new[] { "IdCliente" });
            AddColumn("dbo.Cliente", "Cep", c => c.String(nullable: false));
            DropTable("dbo.Endereco");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.Endereco",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Cep = c.String(nullable: false, maxLength: 15),
                        Rua = c.String(nullable: false, maxLength: 300),
                        Numero = c.Int(nullable: false),
                        Cidade = c.String(nullable: false, maxLength: 300),
                        Uf = c.String(nullable: false, maxLength: 2),
                        IdCliente = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            DropColumn("dbo.Cliente", "Cep");
            CreateIndex("dbo.Endereco", "IdCliente");
            AddForeignKey("dbo.Endereco", "IdCliente", "dbo.Cliente", "Id", cascadeDelete: true);
        }
    }
}
