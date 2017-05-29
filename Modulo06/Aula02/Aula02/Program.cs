using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aula02
{
    class Program
    {
        static void Main(string[] args)
        {
            const string arquivo = @"C:\Users\diandra.rocha\Documents\diandra.rocha\Modulo06\Aula02";

            var linhas = File.ReadAllText(arquivo);


            File.AppendAllText(arquivo, "Hello world");

            Console.ReadKey();
        }
    }
}
