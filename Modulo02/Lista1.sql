
BEGIN TRANSACTION

--1
SELECT * INTO CidadeAux FROM Cidade;

--2
TRUNCATE TABLE CidadeAux;

INSERT INTO CidadeAux (IDCidade, Nome, UF) (SELECT IDCidade, Nome, UF FROM Cidade WHERE Cidade.UF = 'RS');

--3
CREATE TABLE produtos(
idProdutos INT IDENTITY NOT NULL,
nome VARCHAR(50) NOT NULL,
descricao VARCHAR(255),
dataCriacao DATE NOT NULL, 
localEstoque VARCHAR(255) NOT NULL,
quantidade INT NOT NULL,
valor INT NOT NULL,
CONSTRAINT PK_idProduto PRIMARY KEY (idProdutos)
);

--4

ALTER TABLE produtos ALTER COLUMN quantidade decimal(7,3);
ALTER TABLE produtos ALTER COLUMN valor decimal(9,2);

INSERT INTO produtos(nome, descricao, dataCriacao, localEstoque, quantidade, valor)
VALUES ('Celular', 'MotoG3 Motorola', GETDATE(), 'Prateleira 2', 3, 999.99);
INSERT INTO produtos(nome, descricao, dataCriacao, localEstoque, quantidade, valor)
VALUES ('Celular', 'MotoG5', GETDATE(), 'Prateleira 5', 5, 1999.99);
INSERT INTO produtos(nome, descricao, dataCriacao, localEstoque, quantidade, valor)
VALUES ('Limpador de Tela', 'Limpeza geral de telas', GETDATE(), 'Prateleira 8', 8.5, 29.99);

SELECT * FROM produtos;

SELECT GETDATE();

SELECT CONVERT(DATE, '13/05/2017', 103);

COMMIT;