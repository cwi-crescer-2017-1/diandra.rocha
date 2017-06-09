using LocadoraCrescer.Infraestrutura.Repositorios;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [RoutePrefix("opcional")]
    public class OpcionalController : ControllerBasico
    {
        readonly OpcionalRepositorio repo;

        public OpcionalController()
        {
            repo = new OpcionalRepositorio();
        }


        [HttpGet, Route("")]
        public HttpResponseMessage ObterTodos()
        {
            var opcionais = repo.ObterTodos();
            if (opcionais.Count == 0)
            {
                return ResponderErro("Lista de produtos vazia!");
            }

            return ResponderOK(opcionais);
        }

        [HttpGet, Route("{id}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            var opcional = repo.ObterPorId(id);
            if (opcional == null)
            {
                return ResponderErro("Opcional Inexistente!");
            }

            return ResponderOK(opcional);
        }
    }
}
