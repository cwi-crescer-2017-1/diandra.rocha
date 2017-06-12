using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ReservaRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public ReservaRepositorio()
        {
        }

        public dynamic GerarRelatorioGeral(DateTime data)
        {
            decimal valor = 0;
            var dataMenos30Dias = data.AddDays(-30);

            var lista = contexto.Reservas
                .Include("Cliente")
                .Include("Produto")
                .Include("Pacote")
                .Include("Opcionais")
                .Where(r => r.DataDevolucaoReal > dataMenos30Dias && r.DataDevolucaoReal < data 
                && r.Status == Status.Finalizado).ToList();

            valor = lista.Sum(a => a.ValorFinal.Value);

            var retorno = new
            {
                Lista = lista,
                Resultado = valor,
                QuantidadeTotal = lista.Count()
            };
            return retorno;

        }

        public List<Reserva> GerarRelatorioAtrasos()
        {
            return contexto.Reservas.Where(x => x.Status == Status.Em_Atraso).ToList();
        }

        public Reserva Criar(DateTime dataDevolucao, DateTime dataReserva, string cpf, int IdProduto, int IdPacote, List<int> opcionais)
        {
            Reserva reserva = new Reserva();

            reserva.AtribuirDataDevolucaoPrevista(dataDevolucao);
            reserva.AtribuirDataReserva(dataReserva);

            var cliente = contexto.Clientes.SingleOrDefault(x => x.CPF.Equals(cpf));
            reserva.AtribuirCliente(cliente);

            var pacote = contexto.Pacotes.SingleOrDefault(x => x.Id == IdPacote);
            reserva.AtribuirPacote(pacote);

            if (opcionais.Count >= 0)
            {
                List<Opcional> lista = new List<Opcional>();

                foreach (int op in opcionais)
                {
                    var opcional = contexto.Opcionais.SingleOrDefault(x => x.Id == op);
                    lista.Add(opcional);
                }

                reserva.AtribuirOpcionais(lista);

            }

            var produto = contexto.Produtos.SingleOrDefault(x => x.Id == IdProduto);
            reserva.AtribuirProduto(produto);

            reserva.CalcularDiasDeLocacao();
            reserva.CalcularValorPrevisto();

            if (reserva.IsValid())
            {
                contexto.Reservas.Add(reserva);
                contexto.SaveChanges();

            }

            return reserva;
        }

        public void RealizarDevolucao(int idreserva)
        {
            var Reserva = contexto.Reservas.Include("Cliente").Include("Produto").Include("Pacote")
                .Include("Opcionais").SingleOrDefault(x => x.Id == idreserva);

            Reserva.Produto.AumentarEstoque();

            foreach (Opcional op in Reserva.Opcionais)
            {
                op.AumentarEstoque();
                contexto.Entry(op).State = System.Data.Entity.EntityState.Modified;
            }

            contexto.Entry(Reserva).State = System.Data.Entity.EntityState.Modified;
            contexto.Entry(Reserva.Produto).State = System.Data.Entity.EntityState.Modified;

            Reserva.RealizarDevolucao();
            contexto.SaveChanges();
        }

        public List<Reserva> ObterTodos()
        {
            return contexto.Reservas.ToList();
        }

        public Reserva ObterPorId(int id)
        {
            return contexto.Reservas
                .Include("Cliente")
                .Include("Produto")
                .Include("Pacote")
                .Include("Opcionais")
                .SingleOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
