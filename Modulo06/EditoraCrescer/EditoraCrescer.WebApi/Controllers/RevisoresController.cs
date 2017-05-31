using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Linq;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    public class RevisoresController : ApiController
    {
        RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter().ToList();

            return Ok(revisores);
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            if (revisor == null)
            {
                return BadRequest("Revisor nulo");
            }

            repositorio.Adicionar(revisor);

            return Ok(revisor);
        }

        public IHttpActionResult Delete(int Id)
        {
            repositorio.Deletar(Id);

            return Ok();
        }
    }
}
