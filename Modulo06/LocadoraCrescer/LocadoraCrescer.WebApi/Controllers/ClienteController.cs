using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/cliente")]
    public class ClienteController : ControllerBasico
    {
        readonly ClienteRespositorio repo;

        public ClienteController()
        {
            repo = new ClienteRespositorio();
        }

        [HttpPost, Route("")]
        public HttpResponseMessage Criar(Cliente cliente)
        {
            if (!cliente.IsValid())
            {
                cliente.Mensagens.Add("Cliente Nulo");
                return ResponderErro(cliente.Mensagens);
            }

            repo.Criar(cliente);
            return ResponderOK(cliente);
        }

        [HttpGet, Route("")]
        public HttpResponseMessage Obter()
        {
            var clientes = repo.ObterTodos();
            if (clientes.Count == 0 )
            {
                return ResponderErro("Lista de clientes vazia!");
            }

            return ResponderOK(clientes);
        }

        [HttpGet, Route("{cpf}")]
        public HttpResponseMessage ObterPorCPF(string cpf)
        {
            var cliente = repo.ObterPorCPF(cpf);

            if (cliente == null)
            {
                return ResponderErro("Cliente Inexistente!");
            }

            return ResponderOK(cliente);
        }

        protected override void Dispose(bool disposing)
        {
            repo.Dispose();
        }
    }
}
