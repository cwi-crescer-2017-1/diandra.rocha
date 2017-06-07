using AutDemo.WebApi.Controllers;
using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/cliente")]
    public class ClienteController : ControllerBasica
    {
        readonly ClienteRespositorio repoCliente;
        readonly EnderecoRepositorio repoEndereco;

        public ClienteController()
        {
            repoCliente = new ClienteRespositorio();
        }

        [HttpPost, Route("")]
        public HttpResponseMessage Criar(Cliente cliente)
        {
            if (cliente == null)
            {
                return ResponderErro("Cliente nulo!");
            }

            repoCliente.Criar(cliente);
            return ResponderOK(cliente);
        }

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

        [HttpPost, Route("endereco")]
        public HttpResponseMessage CriarEndereco(Endereco endereco)
        {
            if (endereco == null)
            {
                return ResponderErro("Endereço nulo!");
            }

            repoEndereco.Criar(endereco);
            return ResponderOK(endereco);

        }
    }
}
