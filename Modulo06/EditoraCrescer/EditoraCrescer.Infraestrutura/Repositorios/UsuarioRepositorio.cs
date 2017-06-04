using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Infraestrutura.Repositorios
{

    public class UsuarioRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public UsuarioRepositorio()
        {

        }

        public List<Usuario> Obter()
        {
            return contexto.Usuarios.ToList();
        }
        
        public Usuario ObterPorEmail(string login)
        {
            return contexto.Usuarios.SingleOrDefault(x => x.Email.Equals(login));
        }

        public Usuario ObterPorId(int id)
        {
            return contexto.Usuarios.SingleOrDefault(x => x.Id == id);
        }

        public bool VerificarUsuario(Usuario usuario)
        {
            return contexto.Usuarios.Count(x => x.Id == usuario.Id) != 0;
        }

        public void Adicionar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public Usuario Atualizar(int id, Usuario usuario)
        {

            contexto.Entry(usuario).State = System.Data.Entity.EntityState.Modified;

            contexto.SaveChanges();
            return usuario;
        }

        public void Deletar(int Id)
        {
            var itemToRemove = contexto.Usuarios.SingleOrDefault(x => x.Id == Id);
            if (itemToRemove != null)
            {
                contexto.Usuarios.Remove(itemToRemove);
                contexto.SaveChanges();
            }

        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
