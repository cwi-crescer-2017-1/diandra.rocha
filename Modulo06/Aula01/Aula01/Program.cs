using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aula1
{
    class Program
    {
        static void Main(string[] args)
        {
            var entradas = new int[] { };
            List<int> aux = new List<int>();
            //array imútavel, apenas se copia e adiciona

            Console.WriteLine("Digite números e exit para sair:");

            while (true)
            {
                Console.WriteLine("Digite Um Valor:");
                var entrada = Console.ReadLine();

                if (entrada == "exit")
                    break;

                var EntradaAdicionar = int.Parse(entrada);

                aux.Add(EntradaAdicionar);

            }
            entradas = aux.ToArray();

            Console.WriteLine("Array:");
            foreach (var i in entradas)
            {
                Console.WriteLine(i);
            }
            Console.WriteLine("Final");
            Console.ReadKey();
        }
    }
}