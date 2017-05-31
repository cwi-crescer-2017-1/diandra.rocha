using System.Linq;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Web.Http;
using EditoraCrescer.Infraestrutura.Entidades;

namespace EditoraCrescer.WebApi.Controllers
{

    namespace EditoraCrescer.Api.Controllers
    {
        [RoutePrefix("api/Livros")]
        public class LivrosController : ApiController
        {
            LivroRepositorio repositorio = new LivroRepositorio();

            [HttpGet]
            [Route("{isbn:int}")]
            public IHttpActionResult ObterPorId(int isbn)
            {
                    var livro = repositorio.ObterPorIsbn(isbn);
             
                return Ok(livro);
            }

            [HttpGet]
            [Route("{genero}")]
            public IHttpActionResult ObterPorGenero(string genero)
            {
                var livro = repositorio.ObterPorGenero(genero);

                return Ok(livro);
            }

            [HttpGet]
            public IHttpActionResult ObterTodos()
            {
                var livros = repositorio.Obter().ToList();

                return Ok(livros);
            }

            [HttpPost]
            public IHttpActionResult Incluir(Livro livro)
            {
                if (livro == null)
                {
                    return BadRequest("Livro nulo");
                }

                repositorio.Adicionar(livro);

                return Ok(livro);
            }

            [HttpDelete]
            [Route("{isbn:int}")]
            public IHttpActionResult Remover(int Isbn)
            {
                repositorio.Deletar(Isbn);

                return Ok();
            }

            [HttpPut]
            [Route("{isbn:int}")]
            public IHttpActionResult Alterar(int isbn, Livro livro)
            {
                
                repositorio.Atualizar(isbn, livro);

                return Ok(livro);
            }

            protected override void Dispose(bool disposing)
            {
                repositorio.Dispose();
            }

        }

    }
}
