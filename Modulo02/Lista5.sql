--1
SELECT emp.NomeEmpregado AS Empregado, ger.NomeEmpregado AS Gerente, Dep.NomeDepartamento
FROM Empregado emp LEFT JOIN Empregado ger
ON emp.IDGerente = ger.IDEmpregado INNER JOIN Departamento dep ON emp.IDDepartamento = dep.IDDepartamento
ORDER BY emp.NomeEmpregado;

--2
SELECT TOP(1) Emp.NomeEmpregado, Emp.Salario, Dep.NomeDepartamento 
FROM Empregado emp INNER JOIN Departamento dep 
on Emp.IDDepartamento = Dep.IDDepartamento ORDER BY Emp.salario DESC;


--3
BEGIN TRANSACTION
UPDATE Empregado SET Empregado.salario = Empregado.salario + (Empregado.salario * 0.173)
WHERE Empregado.IDEmpregado IN 
(SELECT Emp.IDEmpregado FROM Empregado emp 
INNER JOIN Departamento dep ON Emp.IDDepartamento = dep.IDDepartamento WHERE dep.Localizacao = 'Sao Paulo');
COMMIT

--4
SELECT a.IDCidade, a.Nome, a.UF FROM Cidade a WHERE EXISTS
(SELECT b.Nome , b.UF FROM Cidade b WHERE b.Nome = a.Nome AND b.UF = a.UF GROUP BY Nome, UF HAVING COUNT(*) > 1)
ORDER BY a.IDCidade;

--5
BEGIN TRANSACTION
UPDATE Cidade SET Nome = Nome + '*'  WHERE Nome+UF IN (SELECT Nome+UF FROM Cidade GROUP BY Nome , UF HAVING COUNT(*) > 1) AND IDCidade IN
(SELECT MAX(IDCidade) FROM Cidade GROUP BY Nome, UF HAVING COUNT(*) > 1);
COMMIT
