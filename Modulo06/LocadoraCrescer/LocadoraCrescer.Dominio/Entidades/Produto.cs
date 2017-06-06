namespace LocadoraCrescer.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Descricao { get; private set; }
        public string URLFoto { get; private set; }
        public decimal ValorDiaria { get; private set; }
        public int QuantidadeDisponivel { get; private set; }
    }
}
