CREATE OR REPLACE PACKAGE BODY PCK_AULA03 AS

PROCEDURE ATUALIZAR_CIDADES IS

BEGIN

 procedure SELECIONAR_REPETIDOS as
 BEGIN
       select Nome, UF
       from   Cidade
       group  by Nome, UF
       having count(1) >1;
       
    end SELECIONAR_REPETIDOS;
    
    
PROCEDURE SELECIONAR_CLIENTES(pNome in varchar2,
                     pUF   in varchar2) as
                     BEGIN
     select cli.IDCliente,
            cli.Nome as Nome_Cliente,
            cid.Nome as Nome_Cidade,
            cid.UF
     from   Cliente cli
      inner join Cidade cid on cid.IDCidade = cli.IDCidade
     where  cid.Nome = pNome
     and    cid.UF   = pUF;
     END SELECIONAR_CIDADES;

end SELECIONAR_CIDADES;

END;