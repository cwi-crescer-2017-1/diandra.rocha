using LocadoraCrescer.Dominio.Entidades;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LocadoraCrescer.Teste
{
    [TestClass]
    public class OpcionalTeste
    {
        [TestMethod]
        public void DiminuirEstoqueFuncionaCorretamente()
        {
            Opcional op = new Opcional("TesteOpcional", "TesteOpcional testando1", 59, 8);
            op.DiminuirEstoque();

            Assert.AreEqual(7, op.QuantidadeDisponivel);
        }

        [TestMethod]
        public void AumentarEstoqueFuncionaCorretamente()
        {
            Opcional op = new Opcional("TesteOpcional", "TesteOpcional testando1", 59, 8);
            op.AumentarEstoque();

            Assert.AreEqual(9, op.QuantidadeDisponivel);
        }

        [TestMethod]
        public void OpcionalValidacaoDeEstoqueComEstoqueZero()
        {
            Opcional op = new Opcional("TesteOpcional", "TesteOpcional testando1", 59, 0);
            var resultado = op.EstaDisponivel();

            Assert.IsFalse(resultado);
        }

        [TestMethod]
        public void OpcionalValidacaoDeEstoqueComEstoqueMaiorDoQueZero()
        {
            Opcional op = new Opcional("TesteOpcional", "TesteOpcional testando1", 59, 8);
            var resultado = op.EstaDisponivel();

            Assert.IsTrue(resultado);
        }
    }
}
