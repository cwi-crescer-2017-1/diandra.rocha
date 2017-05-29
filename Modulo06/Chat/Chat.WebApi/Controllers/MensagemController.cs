using Chat.Models;
using System.Collections.Generic;
using System.Web.Http;

namespace Chat.Controllers
{
    public class MensagemController : ApiController
    {

        private static List<Mensagem> mensagens = new List<Mensagem>();
        private static object @lock = new object();

        public IEnumerable<Mensagem> Get()
        {
            return mensagens;
            
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    mensagens.Add(mensagem);
                }

                return Ok(mensagem);
            }
        }

    }
}