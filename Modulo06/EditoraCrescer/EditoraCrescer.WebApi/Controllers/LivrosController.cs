using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult ObterPorIsbn(int isbn)
        {
            var livro = repositorio.ObterPorIsbn(isbn);

            return Ok(new { dados = livro });
        }

        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult ObterPorGenero(string genero)
        {
            var livro = repositorio.ObterPorGenero(genero);

            return Ok(new { dados = livro });
        }

        [HttpGet]
        [Route("Lancamento")]
        public IHttpActionResult ObterPorData()
        {
            var livros = repositorio.ObterPorData();

            return Ok(new { dados = livros });
        }

        [HttpGet]
        public IHttpActionResult ObterTodos()
        {
            var livros = repositorio.Obter().ToList();

            return Ok(new { dados = livros });
        }

        [HttpPost]
        public HttpResponseMessage Incluir(Livro livro)
        {
            if (repositorio.VerificarLivro(livro))
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Livro já existente" } });
            }

            repositorio.Adicionar(livro);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [HttpDelete]
        [Route("{isbn:int}")]
        public HttpResponseMessage Remover(int Isbn)
        {
            var livro = repositorio.ObterPorIsbn(Isbn);
            if (livro == null)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Livro não encontrado" } });
            }

            repositorio.Deletar(Isbn);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [HttpPut]
        [Route("{isbn:int}")]
        public HttpResponseMessage Alterar(int isbn, Livro livro)
        {

            if (isbn != livro.Isbn)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Ids não conferem" } });

            }
            repositorio.Atualizar(isbn, livro);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
        }

    }
}
