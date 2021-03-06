﻿using EditoraCrescer.Infraestrutura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraestrutura.Mappings
{
    public class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");
            HasMany(x => x.Permissoes).WithMany().Map(x =>
            {
                x.MapLeftKey("IdUsuario");
                x.MapRightKey("IdPermissao");
                x.ToTable("UsuarioPermissao");
            });
        }
    }
}
