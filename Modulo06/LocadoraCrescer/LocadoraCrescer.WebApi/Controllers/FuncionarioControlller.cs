using AutDemo.WebApi;
using AutDemo.WebApi.Controllers;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/acessos")]
    public class UsuarioController : ControllerBasica
    {
        readonly FuncionarioRepositorio repo;

        public UsuarioController()
        {
            repo = new FuncionarioRepositorio();
        }

        [BasicAuthorization]
        [HttpGet, Route("login")]
        public HttpResponseMessage Obter()
        {
            var funcionario = repo.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (funcionario == null)
                return ResponderErro("Funcionário não encontrado.");

            return ResponderOK(new { funcionario.Nome, funcionario.Permissoes, funcionario.Email });
        }
    }
}