namespace LocadoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlterarRelacionamento : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.ReservaOpcional", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.ReservaOpcional", "IdReserva", "dbo.Reserva");
            DropIndex("dbo.ReservaOpcional", new[] { "IdOpcional" });
            DropIndex("dbo.ReservaOpcional", new[] { "Reserva_Id" });
            DropIndex("dbo.ReservaOpcional", new[] { "IdReserva" });
            AddColumn("dbo.Opcional", "Reserva_Id", c => c.Int());
            AddColumn("dbo.Reserva", "DiasDeReserva", c => c.Int(nullable: false));
            AlterColumn("dbo.Reserva", "Status", c => c.Int(nullable: false));
            CreateIndex("dbo.Opcional", "Reserva_Id");
            DropTable("dbo.ReservaOpcional");
        }
        
        public override void Down()
        {
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
                .PrimaryKey(t => t.Id);
            
            DropIndex("dbo.Opcional", new[] { "Reserva_Id" });
            AlterColumn("dbo.Reserva", "Status", c => c.String(nullable: false));
            DropColumn("dbo.Reserva", "DiasDeReserva");
            DropColumn("dbo.Opcional", "Reserva_Id");
            CreateIndex("dbo.ReservaOpcional", "IdReserva");
            CreateIndex("dbo.ReservaOpcional", "Reserva_Id");
            CreateIndex("dbo.ReservaOpcional", "IdOpcional");
            AddForeignKey("dbo.ReservaOpcional", "IdReserva", "dbo.Reserva", "Id");
            AddForeignKey("dbo.ReservaOpcional", "IdOpcional", "dbo.Opcional", "Id");
        }
    }
}
