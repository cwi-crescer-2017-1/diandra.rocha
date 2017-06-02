using EditoraCrescer.WebApi.App_Start;
using System;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace EditoraCrescer.WebApi.Controllers
{
    [MeuAtributoAutorizacao]
    public class UsuariosController : ApiController
    {
        public HttpResponseMessage Get()
        {
            return Request.CreateResponse(System.Net.HttpStatusCode.OK);
        }
    }
}
