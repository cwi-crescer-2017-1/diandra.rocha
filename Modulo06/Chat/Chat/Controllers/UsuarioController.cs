using Chat.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace Chat.Controllers
{
    public class UsuarioController : ApiController
    {
        private static List<Usuario> users = new List<Usuario>();
        private static int contador = 1;
        private static object @lock = new object();

        public IEnumerable<Usuario> Get()
        {
            return users;

        }

        public IHttpActionResult Post(Usuario user)
        {
            if (user == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    users.Add(user);
                    user.Id = contador++;
                }

                return Ok(user);
            }
        }

    }
}