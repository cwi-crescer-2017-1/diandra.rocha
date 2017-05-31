using System.Linq;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Web.Http;
using EditoraCrescer.Infraestrutura.Entidades;

namespace EditoraCrescer.WebApi.Controllers
{

    namespace EditoraCrescer.Api.Controllers
    {
        public class LivrosController : ApiController
        {
            LivroRepositorio repositorio = new LivroRepositorio();

            public IHttpActionResult Get()
            {
                var livros = repositorio.Obter().ToList();

                return Ok(livros);
            }

            public IHttpActionResult Post(Livro livro)
            {
                if(livro == null)
                {
                    return BadRequest("Livro nulo");
                }

                repositorio.Adicionar(livro);
                
                return Ok(livro);
            }

            public IHttpActionResult Delete(int Isbn)
            { 
                repositorio.Deletar(Isbn);

                return Ok();
            }

        }
    }
}
