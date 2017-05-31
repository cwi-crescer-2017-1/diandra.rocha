namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlteracaoTabelaRevisores : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Revisors", newName: "Revisores");
        }
        
        public override void Down()
        {
            RenameTable(name: "dbo.Revisores", newName: "Revisors");
        }
    }
}
