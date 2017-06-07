using LocadoraCrescer.WebApi;
using LocadoraCrescer.WebApi.Controllers;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/acessos")]
    public class UsuarioController : ControllerBasico
    {
        readonly FuncionarioRepositorio repo;

        public UsuarioController()
        {
            repo = new FuncionarioRepositorio();
        }

        [HttpPost]
        [Route("")]
        public HttpResponseMessage Criar(Funcionario funcionario)
        {
            if(funcionario == null)
            {
                return ResponderErro("Funcionário inválido!");
            }

            repo.Criar(funcionario);
            return ResponderOK(funcionario);
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