using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("produto")]
    public class ProdutoController : ControllerBasico
    {
        [HttpGet, Route("")]
        public HttpResponseMessage Obter()
        {
            var clientes = repoCliente.ObterTodos();
            if (clientes.Count == 0)
            {
                return ResponderErro("Lista de clientes vazia!");
            }

            return ResponderOK(clientes);
        }

        [HttpGet, Route("{cpf}")]
        public HttpResponseMessage ObterPorCPF(string cpf)
        {
            var cliente = repoCliente.ObterPorCPF(cpf);
            if (cliente == null)
            {
                return ResponderErro("Cliente Inexistente!");
            }

            return ResponderOK(cliente);
        }
    }
}
