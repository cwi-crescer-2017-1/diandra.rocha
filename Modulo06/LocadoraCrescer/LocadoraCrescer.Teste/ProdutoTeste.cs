using LocadoraCrescer.Dominio.Entidades;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LocadoraCrescer.Teste
{
    [TestClass]
    public class ProdutoTeste
    {
        [TestMethod]
        public void DiminuirEstoqueFuncionaCorretamente()
        {
            Produto produto = new Produto("Teste", "Teste testando", "Teste.png", 129, 5);
            produto.DiminuirEstoque();

            Assert.AreEqual(4, produto.QuantidadeDisponivel);
        }

        [TestMethod]
        public void AumentarEstoqueFuncionaCorretamente()
        {
            Produto produto = new Produto("Teste", "Teste testando", "Teste.png", 129, 5);
            produto.AumentarEstoque();

            Assert.AreEqual(6, produto.QuantidadeDisponivel);
        }

        [TestMethod]
        public void ProdutoValidacaoDeEstoqueComEstoqueZero()
        {
            Produto produto = new Produto("Teste", "Teste testando", "Teste.png", 129, 0);
            var resultado = produto.EstaDisponivel();

            Assert.IsFalse(resultado);
        }

        [TestMethod]
        public void ProdutoValidacaoDeEstoqueComEstoqueMaiorDoQueZero()
        {
            Produto produto = new Produto("Teste", "Teste testando", "Teste.png", 129, 5);
            var resultado = produto.EstaDisponivel();

            Assert.IsTrue(resultado);
        }
    }
}
