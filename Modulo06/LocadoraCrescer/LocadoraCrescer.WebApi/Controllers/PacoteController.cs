using LocadoraCrescer.Infraestrutura.Repositorios;
using System.Linq;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("pacote")]
    public class PacoteController : ControllerBasico
    {
        readonly PacoteRepositorio repo;

        public PacoteController()
        {
            repo = new PacoteRepositorio();
        }


        [HttpGet, Route("")]
        public HttpResponseMessage ObterTodos()
        {
            var pacotes = repo.ObterTodos();
            if (pacotes.Count == 0)
            {
                return ResponderErro("Lista de pacotes vazia!");
            }

            return ResponderOK(pacotes);
        }

        [HttpGet, Route("{id}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            var produto = repo.ObterPorId(id);
            if (produto == null)
            {
                return ResponderErro("Produto Inexistente!");
            }

            return ResponderOK(produto);
        }
    }
}
