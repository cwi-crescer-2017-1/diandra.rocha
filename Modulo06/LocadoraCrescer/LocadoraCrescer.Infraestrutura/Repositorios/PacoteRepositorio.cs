using LocadoraCrescer.Dominio.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.repoClientesitorios
{
    public class PacoterepoClientesitorio
    {
        Contexto contexto = new Contexto();

        public PacoterepoClientesitorio()
        {

        }

        public List<Pacote> Obter()
        {
            return contexto.Pacotes.ToList();
        }

        public Pacote ObterPorId(int id)
        {
            return contexto.Pacotes.FirstOrDefault(x => x.Id == id);
        }
    }
}
