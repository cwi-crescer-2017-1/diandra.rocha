using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraCrescer.Dominio.Entidades;
using System.Collections.Generic;

namespace LocadoraCrescer.Teste
{
    [TestClass]
    public class ReservaTeste
    {
        [TestMethod]
        public void ReservaCriadaAtribuiProdutoClientePacoteCorretamente()
        {
            Produto produto = new Produto("Teste", "Teste testando", "Teste.png", 129, 5);
            Pacote pacote = new Pacote("TestePacote", "Teste testando pacote", 148);
            DateTime data = new DateTime(2000, 12, 19);
            Cliente cliente = new Cliente("TesteCliente", "ClienteTeste", "999999-9", data, Genero.FEMININO, "93290-490");

            Reserva reserva = new Reserva();

            reserva.AtribuirCliente(cliente);
            reserva.AtribuirPacote(pacote);
            reserva.AtribuirProduto(produto);

            Assert.AreEqual(cliente, reserva.Cliente);
            Assert.AreEqual(pacote, reserva.Pacote);
            Assert.AreEqual(produto, reserva.Produto);
        }

        [TestMethod]
        public void ReservaCriadaAtribuiDatasCorretamente()
        {
            DateTime dataReserva = new DateTime(2017, 06, 10, 20, 52, 53);
            DateTime dataDevolucao = new DateTime(2017, 06, 15, 20, 52, 53);
            int diasTotais = 5;

            Reserva reserva = new Reserva();

            reserva.AtribuirDataReserva(dataReserva);
            reserva.AtribuirDataDevolucaoPrevista(dataDevolucao);
            reserva.CalcularDiasDeLocacao();

            Assert.AreEqual(dataReserva, reserva.DataReserva);
            Assert.AreEqual(dataDevolucao, reserva.DataDevolucaoPrevista);
            Assert.AreEqual(diasTotais, reserva.DiasDeReserva);
        }

        [TestMethod]
        public void ReservaCriadaAtribuiOpcionaisCorretamente()
        {
            Opcional op = new Opcional("TesteOpcional", "TesteOpcional testando1", 59, 8);
            Opcional op1 = new Opcional("TesteOpcional1", "TesteOpcional testando2", 59, 8);
            Opcional op2 = new Opcional("TesteOpcional2", "TesteOpcional testando3", 59, 8);
            Reserva reserva = new Reserva();

            List<Opcional> lista = new List<Opcional>();
            lista.Add(op);
            lista.Add(op1);
            lista.Add(op2);

            reserva.AtribuirOpcionais(lista);

            var listaArray = lista.ToArray();

            Assert.AreEqual(op, listaArray[0]);
            Assert.AreEqual(op1, listaArray[1]);
            Assert.AreEqual(op2, listaArray[2]);
        }

        [TestMethod]
        public void ReservaCriadaAtribuiValorPrevistoCorretamente()
        {
            Reserva Reserva = new Reserva();
            Produto Produto = new Produto("Teste", "Teste testando", "Teste.png", 129, 5);
            Pacote Pacote = new Pacote("TestePacote", "Teste testando pacote", 148);
            DateTime Data = new DateTime(2000, 12, 19);
            Cliente Cliente = new Cliente("TesteCliente", "ClienteTeste", "999999-9", Data, Genero.FEMININO, "93290-490");
            DateTime dataReserva = new DateTime(2017, 06, 10, 20, 52, 53);
            DateTime dataDevolucao = new DateTime(2017, 06, 15, 20, 52, 53);

            Reserva.AtribuirDataReserva(dataReserva);
            Reserva.AtribuirDataDevolucaoPrevista(dataDevolucao);
            Reserva.AtribuirCliente(Cliente);
            Reserva.AtribuirPacote(Pacote);
            Reserva.AtribuirProduto(Produto);

            Reserva.CalcularDiasDeLocacao();
            Reserva.CalcularValorPrevisto();


            var ValorPrevisto = (129 + 148) * Reserva.DiasDeReserva;

            Assert.AreEqual(ValorPrevisto, Reserva.ValorPrevisto);
            Assert.AreEqual(Status.Em_Andamento,
                Reserva.Status);
        }

        [TestMethod]
        public void ReservaCriadaValidaCorretamente()
        {
            Reserva Reserva = new Reserva();

            var resultado1 = Reserva.Validar();
            var resultado = Reserva.IsValid();

            Assert.IsFalse(resultado);
            Assert.IsFalse(resultado1);
        }

        [TestMethod]
        public void ReservaCriadaAtribuiValorFinalCorretamente()
        {
            Reserva Reserva = new Reserva();
            Produto Produto = new Produto("Teste", "Teste testando", "Teste.png", 129, 5);
            Pacote Pacote = new Pacote("TestePacote", "Teste testando pacote", 148);
            DateTime Data = new DateTime(2000, 12, 19);
            Cliente Cliente = new Cliente("TesteCliente", "ClienteTeste", "999999-9", Data, Genero.FEMININO, "93290-490");
            DateTime dataReserva = new DateTime(2017, 06, 11, 20, 52, 53);
            DateTime dataDevolucao = new DateTime(2017, 06, 19, 20, 52, 53);

            Reserva.AtribuirDataReserva(dataReserva);
            Reserva.AtribuirDataDevolucaoPrevista(dataDevolucao);
            Reserva.AtribuirCliente(Cliente);
            Reserva.AtribuirPacote(Pacote);
            Reserva.AtribuirProduto(Produto);

            Reserva.CalcularDiasDeLocacao();
            Reserva.CalcularValorPrevisto();

            Reserva.RealizarDevolucao();

            var ValorPrevisto = (129 + 148) * Reserva.DiasDeReserva;
            var StatusEsperado = Status.Finalizado;

            Assert.AreEqual(ValorPrevisto, Reserva.ValorFinal);
            Assert.AreEqual(StatusEsperado, Reserva.Status);
        }

        [TestMethod]
        public void ReservaCriadaAtribuiComDataInvalidaRetornaDataDeAgora()
        {
            Reserva Reserva = new Reserva();
            DateTime dataReserva = new DateTime(2017, 06, 11, 20, 52, 53);
            DateTime dataDevolucao = new DateTime(2017, 06, 8, 20, 52, 53);

            Reserva.AtribuirDataReserva(dataReserva);
            Reserva.AtribuirDataDevolucaoPrevista(dataDevolucao);

            var resultado = DateTime.UtcNow.Date;

            Assert.AreEqual(resultado, Reserva.DataDevolucaoPrevista);
        }

        [TestMethod]
        public void ReservaCriadaDiminuiEstoque()
        {
            Reserva Reserva = new Reserva();
            Produto Produto = new Produto("Teste", "Teste testando", "Teste.png", 129, 5);
            Pacote Pacote = new Pacote("TestePacote", "Teste testando pacote", 148);

            Opcional op = new Opcional("TesteOpcional", "TesteOpcional testando1", 59, 8);
            Opcional op1 = new Opcional("TesteOpcional1", "TesteOpcional testando2", 59, 8);
            Opcional op2 = new Opcional("TesteOpcional2", "TesteOpcional testando3", 59, 8);

            List<Opcional> Lista = new List<Opcional>();
            Lista.Add(op);
            Lista.Add(op1);
            Lista.Add(op2);

            Reserva.AtribuirProduto(Produto);
            Reserva.AtribuirOpcionais(Lista);

            Assert.AreEqual(4, Produto.QuantidadeDisponivel);
            Assert.AreEqual(7, op.QuantidadeDisponivel);
            Assert.AreEqual(7, op1.QuantidadeDisponivel);
            Assert.AreEqual(7, op2.QuantidadeDisponivel);

        }
    }
}
