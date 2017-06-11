using LocadoraCrescer.Infraestrutura.Repositorios;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/produto")]
    public class ProdutoController : ControllerBasico
    {
        readonly ProdutoRepositorio repo;

        public ProdutoController()
        {
            repo = new ProdutoRepositorio();
        }


        [HttpGet, Route("")]
        public HttpResponseMessage ObterTodos()
        {
            var produtos = repo.ObterTodos();
            if (produtos.Count == 0)
            {
                return ResponderErro("Lista de produtos vazia!");
            }

            return ResponderOK(produtos);
        }

        [HttpGet, Route("{id}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            var pacote = repo.ObterPorId(id);
            if (pacote == null)
            {
                return ResponderErro("Pacote Inexistente!");
            }

            return ResponderOK(pacote);
        }

        protected override void Dispose(bool disposing)
        {
            repo.Dispose();
        }
    }
}
