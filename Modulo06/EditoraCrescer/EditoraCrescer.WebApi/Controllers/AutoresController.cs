using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Linq;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    public class AutoresController : ApiController
    {
        AutorRepositorio repositorio = new AutorRepositorio();

        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter().ToList();

            return Ok(autores);
        }

        public IHttpActionResult Post(Autor autor)
        {
            if (autor == null)
            {
                return BadRequest("Autor nulo");
            }

            repositorio.Adicionar(autor);

            return Ok(autor);
        }

        public IHttpActionResult Delete(int Id)
        {
            repositorio.Deletar(Id);

            return Ok();
        }

    }
}