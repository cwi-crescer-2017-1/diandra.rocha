using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController
    {
        AutorRepositorio repositorio = new AutorRepositorio();

        [HttpGet]
        public IHttpActionResult Obter()
        {
            var autores = repositorio.Obter().ToList();

            return Ok(new { dados = autores });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult ObterPorId(int id)
        {
            var autor = repositorio.ObterPorId(id);

            return Ok(new { dados = autor });
        }

        [HttpGet]
        [Route("{id:int}/Livros")]
        public IHttpActionResult ObterPorIdComTodosOsLivros(int id)
        {
            var livros = repositorio.ObterPorIdComTodosOsLivros(id);

            return Ok(new { dados = livros });
        }


        [HttpPost]
        public HttpResponseMessage Incluir(Autor autor)
        {
            if (repositorio.VerificarAutor(autor))
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Autor já existente" } });
            }

            repositorio.Adicionar(autor);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [HttpDelete]
        [Route("{id:int}")]
        public HttpResponseMessage Remover(int id)
        {
            var autor = repositorio.ObterPorId(id);
            if (autor== null)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Autor não encontrado" } });
            }

            repositorio.Deletar(id);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [HttpPut]
        [Route("{id:int}")]
        public HttpResponseMessage Alterar(int id, Autor autor)
        {

            if (id != autor.Id)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = new string[] { "Ids não conferem" } });

            }
            repositorio.Atualizar(id, autor);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
        }
    }
}