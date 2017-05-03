--1
SELECT projeto,
DATEDIFF(DAYOFYEAR, Data_Inicio_Prev, Data_Inicio_Real) AS [Atraso Em Dias],
DATEPART(MONTH, Data_Inicio_Prev) AS [Previsão em meses],
DATEPART(MONTH, Data_Inicio_Real) AS [Realização em meses]
FROM Licitacao WHERE DATEDIFF(DAYOFYEAR, Data_Inicio_Prev, Data_Inicio_Real) > 0
ORDER BY [Atraso Em Dias] DESC;

--2
SELECT TOP(10) WITH TIES Empresa_Licitante,
SUM (Faturamento_1Ano_Anterior + Faturamento_2Ano_Anterior) AS Total,
SUM(Valor_Realizado) / SUM(Profissionais) AS Média
FROM Licitacao
GROUP BY Empresa_Licitante
ORDER BY Total DESC;

--3
SELECT TOP(10) WITH TIES Municipio,
SUM(Imposto_Federal + Imposto_Estadual + Imposto_Municipal) AS Total
FROM Licitacao
GROUP BY Municipio
ORDER BY Total DESC;

--4
SELECT projeto, Data_Inicio_Real FROM Licitacao WHERE DATEPART(DW, Data_Inicio_Real) IN (1,2);

--5
SELECT Empresa_Licitante FROM Licitacao WHERE Valor_Previsto > (Faturamento_1Ano_Anterior / 2);

--6
SELECT projeto AS 'Nome do Projeto', 
    valor_realizado, CASE
        WHEN Esfera = 'Federal' THEN Valor_Realizado - Imposto_Federal
        WHEN Esfera = 'Estadual' THEN Valor_Realizado - Imposto_Estadual
        WHEN Esfera = 'Municipal' THEN Valor_Realizado - Imposto_Municipal
        END AS 'Valor final'
            FROM Licitacao 

--7
SELECT Identificador, Empresa_Licitante, Valor_Realizado, Imposto_Federal, Imposto_Estadual, Imposto_Municipal, Profissionais
FROM Licitacao WHERE Identificador = 17255 OR Identificador = 17120 ;