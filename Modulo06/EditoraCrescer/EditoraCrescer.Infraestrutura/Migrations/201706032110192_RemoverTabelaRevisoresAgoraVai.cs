namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RemoverTabelaRevisoresAgoraVai : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Revisores", newName: "Revisors");
        }
        
        public override void Down()
        {
            RenameTable(name: "dbo.Revisors", newName: "Revisores");
        }
    }
}
