using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Security.Principal;
using System.Text;
using System.Threading;
using System.Web;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace AutDemo.WebApi
{
    public class BasicAuthorization : AuthorizeAttribute
    {
        UsuarioRepositorio repo = new UsuarioRepositorio();

        public BasicAuthorization()
        {
        }

        public override void OnAuthorization(HttpActionContext actionContext)
        {

            if (actionContext.Request.Headers.Authorization == null)
            {
                var dnsHost = actionContext.Request.RequestUri.DnsSafeHost;
                actionContext.Response = actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized);
                actionContext.Response.Headers.Add("WWW-Authenticate", string.Format("Basic realm=\"{0}\"", dnsHost));
                return;
            }
            else
            {

                string tokenAutenticacao =
                    actionContext.Request.Headers.Authorization.Parameter;

                string decodedTokenAutenticacao =
                    Encoding.Default.GetString(Convert.FromBase64String(tokenAutenticacao));

                string[] userNameAndPassword = decodedTokenAutenticacao.Split(':');

                Usuario usuario = null;
                if (ValidarUsuario(userNameAndPassword[0], userNameAndPassword[1], out usuario))
                {
                    string[] papeis = usuario.Permissoes.Select(papel => papel.Nome).ToArray();
                    var identidade = new GenericIdentity(usuario.Email);
                    var genericUser = new GenericPrincipal(identidade, papeis);

                    if (string.IsNullOrEmpty(Roles))
                    {
                        Thread.CurrentPrincipal = genericUser;
                        if (HttpContext.Current != null)
                            HttpContext.Current.User = genericUser;

                        return;
                    }
                    else
                    {
                        var currentRoles = Roles.Split(',');
                        foreach (var currentRole in currentRoles)
                        {
                            if (genericUser.IsInRole(currentRole))
                            {
                                Thread.CurrentPrincipal = genericUser;
                                if (HttpContext.Current != null)
                                    HttpContext.Current.User = genericUser;

                                return;
                            }
                        }
                    }
                }
            }

            actionContext.Response =
                actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized, new { mensagens = new string[] { "Usuário ou senha inválidos." } });
        }

        private bool ValidarUsuario(string login, string senha, out Usuario usuarioRetorno)
        {
            usuarioRetorno = null;

            var usuario = repo.ObterPorEmail(login);

            if (usuario != null && usuario.ValidarSenha(senha))
                usuarioRetorno = usuario;
            else
                usuario = null;

            return usuario != null;
        }
    }
}