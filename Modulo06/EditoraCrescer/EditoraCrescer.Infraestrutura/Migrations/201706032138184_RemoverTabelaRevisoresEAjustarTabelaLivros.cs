namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RemoverTabelaRevisoresEAjustarTabelaLivros : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisors");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            AddColumn("dbo.Livros", "IdUsuarioRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "IdUsuarioRevisor");
            AddForeignKey("dbo.Livros", "IdUsuarioRevisor", "dbo.Usuarios", "Id", cascadeDelete: true);
            DropColumn("dbo.Livros", "IdRevisor");
            DropTable("dbo.Revisors");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.Revisors",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            DropForeignKey("dbo.Livros", "IdUsuarioRevisor", "dbo.Usuarios");
            DropIndex("dbo.Livros", new[] { "IdUsuarioRevisor" });
            DropColumn("dbo.Livros", "IdUsuarioRevisor");
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisors", "Id", cascadeDelete: true);
        }
    }
}
