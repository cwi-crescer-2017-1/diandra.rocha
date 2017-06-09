using LocadoraCrescer.Dominio.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class PacoteRepositorio
    {
        Contexto contexto = new Contexto();

        public PacoteRepositorio()
        {

        }

        public List<Pacote> ObterTodos()
        {
            return contexto.Pacotes.ToList();
        }

        public Pacote ObterPorId(int id)
        {
            return contexto.Pacotes.FirstOrDefault(x => x.Id == id);
        }
    }
}
