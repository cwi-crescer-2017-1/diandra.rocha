using Aula05.Infraestrutura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace Aula05.Infraestrutura.Mappings
{
    public class AutorMap: EntityTypeConfiguration<Autor>
    {

        public AutorMap()
        {
            ToTable("Autores");

            HasKey(x => x.Id);


        }


    }
}
