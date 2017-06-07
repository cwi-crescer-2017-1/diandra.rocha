namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Tudo : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        Sobrenome = c.String(nullable: false, maxLength: 300),
                        CPF = c.String(nullable: false, maxLength: 15),
                        DataNascimento = c.DateTime(nullable: false),
                        Genero = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
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
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .Index(t => t.IdCliente);
            
            CreateTable(
                "dbo.Funcionario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        Email = c.String(nullable: false, maxLength: 300),
                        Senha = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissaos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Funcionario_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Funcionario", t => t.Funcionario_Id)
                .Index(t => t.Funcionario_Id);
            
            CreateTable(
                "dbo.Opcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        Descricao = c.String(nullable: false, maxLength: 300),
                        ValorDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                        QuantidadeDisponivel = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        Descricao = c.String(nullable: false, maxLength: 300),
                        ValorDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 300),
                        Descricao = c.String(nullable: false, maxLength: 300),
                        URLFoto = c.String(nullable: false),
                        ValorDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                        QuantidadeDisponivel = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ReservaOpcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        QuantidadeOpcionais = c.Int(nullable: false),
                        IdOpcional = c.Int(),
                        Reserva_Id = c.Int(),
                        IdReserva = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Opcional", t => t.IdOpcional)
                .ForeignKey("dbo.Reserva", t => t.Reserva_Id)
                .ForeignKey("dbo.Reserva", t => t.IdReserva)
                .Index(t => t.IdOpcional)
                .Index(t => t.Reserva_Id)
                .Index(t => t.IdReserva);
            
            CreateTable(
                "dbo.Reserva",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataReserva = c.DateTime(nullable: false),
                        DataDevolucaoPrevista = c.DateTime(nullable: false),
                        DataDevolucaoReal = c.DateTime(),
                        ValorPrevisto = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorFinal = c.Decimal(precision: 18, scale: 2),
                        Status = c.String(nullable: false),
                        IdCliente = c.Int(),
                        IdPacote = c.Int(),
                        IdProduto = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .ForeignKey("dbo.Produto", t => t.IdProduto)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote)
                .Index(t => t.IdProduto);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.ReservaOpcional", "IdReserva", "dbo.Reserva");
            DropForeignKey("dbo.Reserva", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Reserva", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.ReservaOpcional", "Reserva_Id", "dbo.Reserva");
            DropForeignKey("dbo.Reserva", "IdCliente", "dbo.Cliente");
            DropForeignKey("dbo.ReservaOpcional", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.Permissaos", "Funcionario_Id", "dbo.Funcionario");
            DropForeignKey("dbo.Endereco", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.Reserva", new[] { "IdProduto" });
            DropIndex("dbo.Reserva", new[] { "IdPacote" });
            DropIndex("dbo.Reserva", new[] { "IdCliente" });
            DropIndex("dbo.ReservaOpcional", new[] { "IdReserva" });
            DropIndex("dbo.ReservaOpcional", new[] { "Reserva_Id" });
            DropIndex("dbo.ReservaOpcional", new[] { "IdOpcional" });
            DropIndex("dbo.Permissaos", new[] { "Funcionario_Id" });
            DropIndex("dbo.Endereco", new[] { "IdCliente" });
            DropTable("dbo.Reserva");
            DropTable("dbo.ReservaOpcional");
            DropTable("dbo.Produto");
            DropTable("dbo.Pacote");
            DropTable("dbo.Opcional");
            DropTable("dbo.Permissaos");
            DropTable("dbo.Funcionario");
            DropTable("dbo.Endereco");
            DropTable("dbo.Cliente");
        }
    }
}
