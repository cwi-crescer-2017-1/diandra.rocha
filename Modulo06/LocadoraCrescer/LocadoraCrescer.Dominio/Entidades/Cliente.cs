using System;
using System.ComponentModel;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Cliente : EntidadeBasica
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Sobrenome { get; private set; }
        public string CPF { get; private set; }
        public DateTime DataNascimento { get; private set; }
        [DefaultValue(Genero.NAO_INFORMADO)]
        public Genero Genero { get; private set; }
        public string Cep { get; private set; }

        protected Cliente()
        {

        }

        public Cliente(string nome, string sobrenome, string cpf, DateTime datanascimento, int genero, string cep)
        {
            Nome = nome;
            Sobrenome = sobrenome;
            CPF = cpf;
            DataNascimento = datanascimento;
            Genero = Genero;
            Cep = cep;
        }

        public override bool Validar()
        {
            Mensagens.Clear();
            if (string.IsNullOrWhiteSpace(CPF))
            {
                Mensagens.Add("CPF nulo!");
                return false;
            }
            if (string.IsNullOrWhiteSpace(Nome))
            {
                Mensagens.Add("Nome nulo!");
                return false;
            }
            if (string.IsNullOrWhiteSpace(Sobrenome))
            {
                Mensagens.Add("Sobrenome nulo!");
                return false;
            }
            if (string.IsNullOrWhiteSpace(Cep))
            {
                Mensagens.Add("Cep nulo!");
                return false;
            }

            return true;
        }
    }
}
