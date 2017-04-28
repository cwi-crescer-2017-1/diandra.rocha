--1
SELECT IDEmpregado, NomeEmpregado FROM Empregado ORDER BY DataAdmissao;

--2
SELECT * FROM Empregado WHERE comissao IS NULL OR comissao = 0 ORDER BY salario;

--3
SELECT IDEmpregado AS Código,
NomeEmpregado AS Nome, 
(salario*13) AS [Salário Anual],
(comissao * 12) AS [Comissão Anual],
(salario*13 + (COALESCE (comissao * 12, 0))) AS [Renda Anual]
FROM Empregado;

--4
SELECT IDEmpregado AS Código,
NomeEmpregado AS Nome, 
Cargo AS [Cargo Funcionário],
Salario AS [Salário Mensal]
FROM Empregado WHERE (salario*12)<=18.500 OR Cargo = 'Atendente';


