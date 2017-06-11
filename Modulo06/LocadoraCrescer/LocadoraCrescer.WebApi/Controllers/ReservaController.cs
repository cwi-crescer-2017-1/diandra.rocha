using LocadoraCrescer.Infraestrutura.Repositorios;
using LocadoraCrescer.WebApi.Models;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.WebApi.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/reserva")]
    public class ReservaController : ControllerBasico
    {
        readonly ReservaRepositorio repo;
        public ReservaModel modelo;

        public ReservaController()
        {
            modelo = new ReservaModel();
            repo = new ReservaRepositorio();
        }

        [HttpPost, Route("")]
        public HttpResponseMessage Criar(ReservaModel modelo)
        {
            var reserva = repo.Criar(modelo.Devolucao, modelo.Reserva, modelo.Cliente, modelo.Produto, modelo.Pacote, modelo.Opcionais);

            if (!reserva.IsValid())
            {
                return ResponderErro(reserva.Mensagens);
            } 
            return ResponderOK(reserva);
        }

        [HttpPut, Route("{idreserva}")]
        public HttpResponseMessage Devolver(int idreserva)
        {
            if (idreserva<0)
            {
                return ResponderErro("Id de reserva inválida!");
            }

            repo.RealizarDevolucao(idreserva);

            return ResponderOK();

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

        protected override void Dispose(bool disposing)
        {
            repo.Dispose();
        }
    }
}
