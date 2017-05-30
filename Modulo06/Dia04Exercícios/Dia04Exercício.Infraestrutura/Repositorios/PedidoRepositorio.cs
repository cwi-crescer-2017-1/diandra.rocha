using Dia04Exercícios.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;

namespace Dia04Exercício.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao = @"Server=13.65.101.67; User Id=diandra.rocha;Password=123456;Database=aluno24db";

        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"UPDATE Pedido SET NomeCliente = @NomeCliente WHERE Id = @id";

                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@Id", pedido.Id);

                    comando.ExecuteNonQuery();
                }

                List<ItemPedido> adicionar = pedido.Itens;


                foreach (ItemPedido item in adicionar)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                        @"INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) 
                                VALUES (@PedidoId, @ProdutoId, @Quantidade)";

                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@ProdutoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                    }
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"INSERT INTO Pedido (NomeCliente) 
                                VALUES (@NomeCliente)";

                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }

                List<ItemPedido> adicionar = pedido.Itens;


                foreach (ItemPedido item in adicionar)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                        @"INSERT INTO ITemPedido (PedidoId, ProdutoId, Quantidade) 
                                VALUES (@PedidoId, @ProdutoId, @Quantidade)";

                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@ProdutoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();

                        using (var comando2 = conexao.CreateCommand())
                        {
                            comando2.CommandText = "SELECT @@IDENTITY";

                            var result = (decimal)comando2.ExecuteScalar();
                            item.Id = (int)result;
                        }
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, NomeCliente FROM Pedido";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        Pedido pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = (List<ItemPedido>)dataReader["Itens"];

                        pedidos.Add(pedido);
                    }
                }
            }

            return pedidos;
        }


        public Pedido Obter(int id)
        {
            Pedido pedido = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, NomeCliente FROM Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = (List<ItemPedido>)dataReader["Itens"];
                        return pedido;
                    }
                }
            }

            return pedido;
        }
    }
}
