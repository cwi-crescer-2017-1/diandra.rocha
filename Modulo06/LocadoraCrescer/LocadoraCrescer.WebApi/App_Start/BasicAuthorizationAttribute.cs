using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Principal;
using System.Text;
using System.Threading;
using System.Web;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace LocadoraCrescer.WebApi
{
    public class BasicAuthorization : AuthorizeAttribute
    {
        readonly FuncionarioRepositorio repo;

        public BasicAuthorization()
        {
            repo = new FuncionarioRepositorio();
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

                Funcionario funcionario = null;
                if (ValidarFuncionario(userNameAndPassword[0], userNameAndPassword[1], out funcionario))
                {
                    string[] papeis = funcionario.Permissoes.Select(papel => papel.Nome).ToArray();
                    var identidade = new GenericIdentity(funcionario.Email);
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

        private bool ValidarFuncionario(string email, string senha, out Funcionario FuncionarioRetorno)
        {
            FuncionarioRetorno = null;

            var funcionario = repo.Obter(email);

            if (funcionario != null && funcionario.ValidarSenha(senha))
                FuncionarioRetorno = funcionario;
            else
                funcionario = null;

            return funcionario != null;
        }
    }
}