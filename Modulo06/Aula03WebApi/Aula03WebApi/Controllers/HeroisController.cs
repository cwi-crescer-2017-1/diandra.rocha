using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace Aula03WebApi.Controllers
{
    public class HeroisController : ApiController
    {
        static List<Heroi> herois = new List<Heroi>();
        static int id = 0;
        static object @lock = new object();
        public IEnumerable<Heroi> Get(string nome = null, int? id = null)
        {
            herois.Add(

                new Heroi()
                {
                    id = 1,
                    nome = "Monkey D. Luffy",
                    poder = new Poder()
                    {
                        nome = "Gear Fourth",
                        dano = 5000
                    }
                });
            herois.Add(
                new Heroi()
                {
                    id = 2,
                    nome = "Roronoa Zoro",
                    poder = new Poder()
                    {
                        nome = "Santoryu",
                        dano = 3000
                    }
                });
            herois.Add(
                new Heroi()
                {
                    id = 3,
                    nome = "Robin",
                    poder = new Poder()
                    {
                        nome = "Hana Hana no Mi",
                        dano = 3000
                    }
                });
            herois.Add(
                new Heroi()
                {
                    id = 4,
                    nome = "Portgas D. Ace",
                    poder = new Poder()
                    {
                        nome = "Mera Mera no Mi",
                        dano = 3000
                    }
                    

                });

            /*return herois.Where(x =>
            (id == null || x.id == id) &&
            (nome == null || x.nome == nome)
            );*/
            herois = null;
            if (id == null)
                return herois;
            else
                return herois.Where(heroi => heroi.id == id);
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi == null)
            {
                return BadRequest();

            }
            else
            {
                lock (@lock)
                {
                    heroi.id = id++;
                    herois.Add(heroi);
                    return Ok(heroi);
                }
            }
        }
    }
}