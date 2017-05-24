using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo01
{
    public class Pessoa
    {
        //private : escopo da classe
        //protected : escopo da classe e herança
        //internal: apenas dentro do namespace - projeto
        //public: todos

        const double PI = 3.14; //static, nunca muda, 
        readonly double pi = 3.1416; // pode mudar, gera nova referencia, pode ser setada no construtor, mas não em método

        public Pessoa() // aceita sobrecarga de construtores
        {
            pi = 12; //this é opcional

        }

        public string Nome { get; set; }
        public int? Id { get; set; } //pode aceitar nulo
        public DateTime Nascimento { get; set; }

    }
}
