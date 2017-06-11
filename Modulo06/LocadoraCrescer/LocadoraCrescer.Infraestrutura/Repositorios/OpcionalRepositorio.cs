using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class OpcionalRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public OpcionalRepositorio()
        {

        }

        public List<Opcional> ObterTodos()
        {
            return contexto.Opcionais.ToList();
        }

        public Opcional ObterPorId(int id)
        {
            return contexto.Opcionais.FirstOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
