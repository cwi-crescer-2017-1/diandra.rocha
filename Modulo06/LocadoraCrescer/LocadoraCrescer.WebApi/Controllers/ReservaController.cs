using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System.Collections.Generic;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/reserva")]
    public class ReservaController : ControllerBasico
    {
        readonly ReservaRepositorio repo;

        public ReservaController()
        {
            repo = new ReservaRepositorio();
        }

        [HttpPost, Route("")]
        public HttpResponseMessage Criar(Reserva reserva, int produto, int pacote, List<int> opcionais)
        {
            if (reserva == null || produto>=0)
            {
                return ResponderErro("Reserva inválida!");
            }

            repo.Criar(reserva, produto, pacote, opcionais);
            return ResponderOK(reserva);
        }

        [HttpGet, Route("")]
        public HttpResponseMessage Obter()
        {
            var reservas = repo.ObterTodos();
            if(reservas.Count == 0)
            {
                return ResponderErro("Lista de reservas vazia!");
            }

            return ResponderOK(reservas);
        }

        [HttpGet, Route("{id}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            var reserva = repo.ObterPorId(id);
            if(reserva == null)
            {
                return ResponderErro("Reserva Inexistente!");
            }

            return ResponderOK(reserva);
        }
    }
}
