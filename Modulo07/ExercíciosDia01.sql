
CREATE VIEW PRODUTOS4MESES AS
SELECT PRODUTO.IDPRODUTO, PRODUTO.NOME FROM PRODUTO WHERE IDPRODUTO NOT IN (SELECT PRODUTO.IDPRODUTO FROM PRODUTO INNER JOIN PEDIDOITEM 
ON PEDIDOITEM.IDPRODUTO = PRODUTO.IDPRODUTO INNER JOIN PEDIDO ON PEDIDO.IDPEDIDO = PEDIDOITEM.IDPEDIDO
WHERE TO_DATE(PEDIDO.DATAPEDIDO) >= TO_DATE(ADD_MONTHS(sysdate, -4)));


UPDATE PRODUTO SET SITUACAO = 'I' WHERE IDPRODUTO IN (SELECT IDPRODUTO FROM PRODUTOS4MESES); 

SELECT SUM(PEDIDOITEM.QUANTIDADE) FROM PEDIDOITEM INNER JOIN PEDIDO 
ON PEDIDOITEM.IDPEDIDO = PEDIDO.IDPEDIDO WHERE PEDIDOITEM.IDPRODUTO = (:IDPRODUTO) AND
PEDIDO.DATAPEDIDO >= TRUNC(SYSDATE, 'YYYY');


SELECT * FROM USER_TABLES;

EXEC dbms_stats.gather_schema_stats( USER);
