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

        protected Produto()
        {

        }

        public Produto(string nome, string descricao,string urlfoto, decimal valordiaria, int quantidadedisponivel)
        {
            Nome = nome;
            Descricao = descricao;
            URLFoto = urlfoto;
            ValorDiaria = valordiaria;
            QuantidadeDisponivel = quantidadedisponivel;
        }

        public void DiminuirEstoque()
        {
            QuantidadeDisponivel = QuantidadeDisponivel - 1;
        }

        public void AumentarEstoque()
        {
            QuantidadeDisponivel = QuantidadeDisponivel +1;
        }

        public bool EstaDisponivel()
        {
            return QuantidadeDisponivel > 0;
        }
    }
}
