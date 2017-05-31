namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlteracaoDoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Autores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Livros",
                c => new
                    {
                        Isbn = c.Int(nullable: false, identity: true),
                        Titulo = c.String(),
                        Descricao = c.String(),
                        Genero = c.String(),
                        DataPublicacao = c.DateTime(nullable: false),
                        IdAutor = c.Int(nullable: false),
                        IdRevisor = c.Int(nullable: false),
                        DataRevisao = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Isbn)
                .ForeignKey("dbo.Autores", t => t.IdAutor, cascadeDelete: true)
                .ForeignKey("dbo.Revisors", t => t.IdRevisor, cascadeDelete: true)
                .Index(t => t.IdAutor)
                .Index(t => t.IdRevisor);
            
            CreateTable(
                "dbo.Revisors",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisors");
            DropForeignKey("dbo.Livros", "IdAutor", "dbo.Autores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            DropIndex("dbo.Livros", new[] { "IdAutor" });
            DropTable("dbo.Revisors");
            DropTable("dbo.Livros");
            DropTable("dbo.Autores");
        }
    }
}
