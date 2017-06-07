using LocadoraCrescer.Dominio.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.repoClientesitorios
{
    public class OpcionalrepoClientesitorio
    {
        Contexto contexto = new Contexto();

        public OpcionalrepoClientesitorio()
        {

        }

        public List<Opcional> Obter()
        {
            return contexto.Opcionais.ToList();
        }

        public Opcional ObterPorId(int id)
        {
            return contexto.Opcionais.FirstOrDefault(x => x.Id == id);
        }
    }
}
