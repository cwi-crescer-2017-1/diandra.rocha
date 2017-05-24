using System;



namespace Demo01
{
    class Program
    {
        static void Main(string[] args)
        {

            Pessoa pessoa = new Pessoa();
            var pessoa2 = new Pessoa();

            pessoa.Id = 1;
            pessoa.Nascimento = new DateTime(2000, 02, 19);
            pessoa.Nome = "Diandra" + "Rocha"; // string: aspas duplas
            pessoa.Nome = $"Diandra {pessoa.Id}"; // interpolate
            char c = 'c'; //char: aspas simples

            if (pessoa.Id.HasValue)
            {
                Console.WriteLine(pessoa.Id.Value);

            }
            else
            {
                Console.WriteLine("Não tem valor");
            }


            //,miliar .decimal
            Console.WriteLine("Informe seu peso");
            var pesoEntrada = Console.ReadLine();

            Console.WriteLine("Informe sua altura");
            var alturaEntrada = Console.ReadLine(); // retorno de função trás tudo em string

            //var peso = double.Parse(pesoEntrada);
            double peso = 0D; //tranforma em double

            if (!double.TryParse(pesoEntrada, out peso)) //não estoura erro
            {
                Console.WriteLine("Não conseguiu");
            }


            var Altura = double.Parse(alturaEntrada);

            var CalculoIMC = new CalculoIMC(Altura, peso);
            var imc = CalculoIMC.CalcularIMC();

            Console.WriteLine($"Seu IMC: {imc}");


            Console.WriteLine(pessoa.Nome);
            Console.WriteLine(byte.MaxValue);
            Console.ReadKey();
        }
    }
}
