namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlterarTabelaPermissoes : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Permissaos", newName: "Permissao");
            AlterColumn("dbo.Permissao", "Nome", c => c.String(nullable: false, maxLength: 100));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Permissao", "Nome", c => c.String());
            RenameTable(name: "dbo.Permissao", newName: "Permissaos");
        }
    }
}
