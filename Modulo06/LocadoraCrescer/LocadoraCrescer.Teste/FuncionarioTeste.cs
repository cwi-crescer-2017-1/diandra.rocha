using LocadoraCrescer.Dominio.Entidades;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LocadoraCrescer.Teste
{
    [TestClass]
    public class FuncionarioTeste
    {
        [TestMethod]
        public void AtribuirPermissoesAdicionaCorretamente()
        {
            Funcionario func = new Funcionario();
            Permissao permissao = new Permissao("Teste");

            string[] array = new string[1];
            array[0] = "Teste";
            func.AtribuirPermissoes(array);

            var ArrayPerm = func.Permissoes.ToArray();

            Assert.AreEqual(permissao.Nome, ArrayPerm[0].Nome);
        }

    }
}
