using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var revisores = repositorio.Obter().ToList();

            return Ok(new { dados = revisores });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var revisor = repositorio.ObterPorId(id);

            return Ok(new { dados = revisor });
        }

        [HttpPost]
        public HttpResponseMessage Incluir(Revisor revisor)
        {
            if (repositorio.VerificarRevisor(revisor))
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Revisor já existente" } });
            }

            repositorio.Adicionar(revisor);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [HttpDelete]
        [Route("{id:int}")]
        public HttpResponseMessage Remover(int id)
        {
            var revisor = repositorio.ObterPorId(id);
            if (revisor == null)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Revisor não encontrado" } });
            }

            repositorio.Deletar(id);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [HttpPut]
        [Route("{id:int}")]
        public HttpResponseMessage Alterar(int id, Revisor revisor)
        {

            if (id != revisor.Id)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Ids não conferem" } });

            }
            repositorio.Atualizar(id, revisor);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
        }

    }
}
