using System;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Sobrenome { get; private set; }
        public string CPF { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public Genero Genero { get; private set; }
        public Endereco Endereco { get; private set; }

        protected Cliente()
        {

        }

        public Cliente(string nome, string sobrenome, string cpf, DateTime datanascimento, Genero genero)
        {
            Nome = nome;
            Sobrenome = sobrenome;
            CPF = cpf;
            DataNascimento = datanascimento;
            Genero = Genero;
        }

        public void AtribuirEndereco(Endereco endereco)
        {
            Endereco = endereco;
        }
    }
}
