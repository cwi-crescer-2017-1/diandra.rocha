using AutDemo.WebApi;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using EditoraCrescer.WebApi.Model;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/acessos")]
    public class UsuarioController : BasicaController
    {
        UsuarioRepositorio repo = new UsuarioRepositorio();
        public UsuarioController()
        {
        }

        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar([FromBody]RegistrarUsuarioModel model)
        {
            if (repo.ObterPorEmail(model.Email) == null)
            {
                var usuario = new Usuario(model.Nome, model.Email, model.Senha);

                if (usuario.Validar())
                {
                    repo.Adicionar(usuario);
                }
                else
                {
                    return ResponderErro(usuario.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Usuário já existe.");
            }

            return ResponderOK();
        }

        [HttpPost, Route("resetarsenha")]
        public HttpResponseMessage ResetarSenha(string email)
        {
            var usuario = repo.ObterPorEmail(email);
            if (usuario == null)
                return ResponderErro(new string[] { "Usuário não encontrado." });

            var novaSenha = usuario.ResetarSenha();

            if (usuario.Validar())
            {
                repo.Atualizar(usuario.Id, usuario);
                // EmailService.Enviar(usuario.Email, "Crescer 2017-1", $"Olá! sua senha foi alterada para: {novaSenha}");
            }
            else
                return ResponderErro(usuario.Mensagens);

            return ResponderOK();
        }

        [BasicAuthorization]
        [Route("usuario")]
        public HttpResponseMessage Obter()
        {
            var usuario = repo.ObterPorEmail(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
                return ResponderErro("Usuário não encontrado.");

            return ResponderOK(new { usuario.Nome, usuario.Permissoes, usuario.Email });
        }
    }
}

