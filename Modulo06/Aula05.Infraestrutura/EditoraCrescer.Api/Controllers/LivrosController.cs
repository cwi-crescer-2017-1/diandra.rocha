using System.Linq;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            var livros = repositorio.Livros.ToList();

            return Ok(livros);
        }
    }
}
