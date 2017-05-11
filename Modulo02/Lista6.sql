--1
SELECT TOP(1) PrimeiroNome, COUNT(*) AS Contagem FROM
(SELECT SUBSTRING(Cliente.Nome, 1, CHARINDEX(' ', Cliente.Nome)) AS PrimeiroNome FROM Cliente) AS Resultado
GROUP BY Resultado.PrimeiroNome ORDER BY Contagem DESC; 

--2
SELECT COUNT(Pe.IDPedido) AS Quantidade, SUM(Pe.ValorPedido) AS Total FROM Pedido Pe WHERE Pe.IDPedido IN 
(SELECT Pe.IDPedido FROM Pedido Pe WHERE MONTH(Pe.DataPedido) = 04 AND YEAR(Pe.DataPedido) = 2017);

--3
SELECT TOP(1) temp.Contagem, temp.CidadeUF FROM 
(SELECT COUNT(Cliente.IDCliente) AS Contagem, Cidade.UF AS CidadeUF FROM Cliente 
INNER JOIN Cidade ON Cliente.IDCidade = Cidade.IDCidade GROUP BY Cidade.UF)
AS temp ORDER BY Contagem;

SELECT TOP(1) temp.Contagem, temp.CidadeUF FROM 
(SELECT COUNT(Cliente.IDCliente) AS Contagem, Cidade.UF AS CidadeUF FROM Cliente 
INNER JOIN Cidade ON Cliente.IDCidade = Cidade.IDCidade GROUP BY Cidade.UF )
AS temp ORDER BY Contagem DESC;

--4
BEGIN TRANSACTION
INSERT INTO Produto(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao) VALUES ('Galocha Maragato', GETDATE(), 37.65, 77.95, 'A');
COMMIT

--5
SELECT * FROM Produto pro WHERE NOT EXISTS (SELECT * FROM PedidoItem pedit WHERE pro.IDProduto = pedit.IDProduto);

--6
SELECT TOP(30) temp.Total, temp.Código FROM 
(SELECT ((pro.PrecoVenda - pro.PrecoCusto)* pedit.Quantidade) AS Total, pro.IDProduto AS Código
FROM PedidoItem pedit INNER JOIN Produto pro ON pedit.IDProduto = pro.IDProduto INNER JOIN 
Pedido ped ON pedit.IDPedido = ped.IDPedido WHERE YEAR(ped.DataPedido) = 2016) AS temp
ORDER BY temp.Total DESC;

