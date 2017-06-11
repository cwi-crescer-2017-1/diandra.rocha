namespace LocadoraCrescer.Dominio.Entidades
{
    public class Opcional
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Descricao { get; private set; }
        public decimal ValorDiaria { get; private set; }
        public int QuantidadeDisponivel { get; private set; }

        protected Opcional()
        {

        }

        public Opcional(string nome, string descricao, decimal valordiaria, int quantidadedisponivel)
        {
            Nome = nome;
            Descricao = descricao;
            ValorDiaria = valordiaria;
            QuantidadeDisponivel = quantidadedisponivel;
        }

        public void DiminuirEstoque()
        {
            if (!Nome.Equals("Seguro"))
            {
                QuantidadeDisponivel = QuantidadeDisponivel - 1;
            }  
        }

        public void AumentarEstoque()
        {
            if (!Nome.Equals("Seguro"))
            {
                QuantidadeDisponivel = QuantidadeDisponivel + 1;
            }
        }

        public bool VerificarDisponibilidade()
        {
            return QuantidadeDisponivel > 0;
        }
    }
}
