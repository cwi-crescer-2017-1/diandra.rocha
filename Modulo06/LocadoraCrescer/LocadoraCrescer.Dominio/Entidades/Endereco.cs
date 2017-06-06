namespace LocadoraCrescer.Dominio.Entidades
{
    public class Endereco
    {
        public int Id { get; private set; }
        public string Cep { get; private set; }
        public string Rua { get; private set; }
        public int Numero { get; private set; }
        public string Cidade { get; private set; }
        public string Uf { get; private set; }
        public Cliente Cliente { get; private set; }

        protected Endereco()
        {

        }
    }
}
