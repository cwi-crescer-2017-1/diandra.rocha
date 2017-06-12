namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class MigracaoUpdate : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Cliente", "Genero", c => c.Byte(nullable: false));
            AlterColumn("dbo.Reserva", "Status", c => c.Byte(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Reserva", "Status", c => c.Int(nullable: false));
            AlterColumn("dbo.Cliente", "Genero", c => c.Int(nullable: false));
        }
    }
}
