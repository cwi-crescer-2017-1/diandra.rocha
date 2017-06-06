namespace LocadoraCrescer.Dominio.Entidades
{
    public class Pacote
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Descricao { get; private set; }
        public decimal ValorDiaria { get; private set; }  

        protected Pacote()
        {

        }
    }
}
