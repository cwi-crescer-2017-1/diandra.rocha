CREATE OR REPLACE package pck_megasena is

  -- Author  : ANDRENUNES
  -- Purpose : Manipulação na base de dados da Loteria mais conhecida do Brasil
  
  -- Variáveis Globais - definidas em procedimento específico
  gPremio_sena          number(12,2) := 0;
  gPremio_quina         number(12,2) := 0;
  gPremio_quadra        number(12,2) := 0;
  gAcumulado_proximo_05 number(12,2) := 0;
  gAcumulado_final_ano  number(12,2) := 0;
  
  -- Public type declarations
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number);
  function buscaPercentual(pIdentificador in varchar2) return number;
  procedure atualizaAcertadores (pConcurso in integer);
  procedure geraProximoConcurso;
  
end pck_megasena;
/


CREATE OR REPLACE package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
  PROCEDURE GERAPROXIMOCONCURSO AS
  ID_ULTIMO_CONCURSO CONCURSO.IDCONCURSO%TYPE;
  VALOR_ARRECADADO APOSTA.VALOR%TYPE;
  VALOR_FINAL NUMBER;
  CONCURSO_ACUMULOU  CONCURSO.ACUMULOU%TYPE;
  PREMIO_SENA CONCURSO.PREMIO_SENA%TYPE;
   BEGIN
      
      SELECT MAX(CONCURSO.IDCONCURSO) INTO ID_ULTIMO_CONCURSO FROM CONCURSO;
      SELECT SUM(VALOR) INTO VALOR_ARRECADADO FROM APOSTA WHERE IDCONCURSO = ID_ULTIMO_CONCURSO;
      SELECT CONCURSO.ACUMULOU INTO CONCURSO_ACUMULOU FROM CONCURSO WHERE IDCONCURSO = ID_ULTIMO_CONCURSO;
      SELECT CONCURSO.PREMIO_SENA INTO PREMIO_SENA FROM CONCURSO WHERE IDCONCURSO = ID_ULTIMO_CONCURSO;
      
      IF(CONCURSO_ACUMULOU = 1) THEN
      VALOR_ARRECADADO := VALOR_ARRECADADO + PREMIO_SENA;
      END IF;
      
      VALOR_FINAL := (VALOR_ARRECADADO / 100) * 45.3;
      
      SALVACONCURSO(ID_ULTIMO_CONCURSO+1, SYSDATE, VALOR_FINAL);
   END GERAPROXIMOCONCURSO;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
PROCEDURE ATUALIZAACERTADORES (PCONCURSO IN INTEGER) AS
  
        CURSOR APOSTAS_CONCURSO(PCONCURSO IN INTEGER) IS
            SELECT IDAPOSTA
            FROM APOSTA
            WHERE IDCONCURSO = PCONCURSO;   
        
         CURSOR NUMERO_APOSTA (PIDAPOSTA IN INTEGER) IS
            SELECT IDNUMERO_APOSTA, NUMERO 
            FROM NUMERO_APOSTA
            WHERE IDAPOSTA = PIDAPOSTA;
            
        CURSOR QUANTIDADE_PREMIADOS (PCONCURSO IN NUMBER) IS
            SELECT APOSTA_PREMIADA.ACERTOS AS TIPOACERTO, COUNT(1) AS QUANTIDADE
            FROM APOSTA_PREMIADA
            INNER JOIN APOSTA ON APOSTA_PREMIADA.IDAPOSTA = APOSTA.IDAPOSTA
            WHERE APOSTA.IDCONCURSO = PCONCURSO
            GROUP BY APOSTA_PREMIADA.ACERTOS ORDER BY APOSTA_PREMIADA.ACERTOS;
        
        CURSOR PREMIADOS (PCONCURSO IN NUMBER) IS
            SELECT ap.IDAPOSTA, ap.ACERTOS
            FROM APOSTA_PREMIADA ap
            INNER JOIN APOSTA a ON ap.IDAPOSTA = a.IDAPOSTA
            WHERE a.IDCONCURSO = PCONCURSO;   
            
            CONTADOR NUMBER;
            IDAPOSTA_PREMIADA NUMBER;
            VALOR_FINAL_QUADRA NUMBER;
            VALOR_FINAL_QUINA NUMBER;
            VALOR_FINAL_SENA NUMBER;
            PREMIADO_PRIMEIRO NUMBER;
            PREMIADO_SEGUNDO NUMBER;
            PREMIADO_TERCEIRO NUMBER;
            PREMIADO_QUARTO NUMBER;
            PREMIADO_QUINTO NUMBER;
            PREMIADO_SEXTO NUMBER;
            VALOR_UNITARIO NUMBER;
            
   BEGIN
   
   SELECT PREMIO_QUADRA INTO VALOR_FINAL_QUADRA FROM CONCURSO WHERE IDCONCURSO = PCONCURSO;
   SELECT PREMIO_QUINA INTO VALOR_FINAL_QUINA FROM CONCURSO WHERE IDCONCURSO = PCONCURSO;
   SELECT PREMIO_SENA INTO VALOR_FINAL_SENA FROM CONCURSO WHERE IDCONCURSO = PCONCURSO;
   SELECT PRIMEIRA_DEZENA, SEGUNDA_DEZENA, TERCEIRA_DEZENA, QUARTA_DEZENA, QUINTA_DEZENA, SEXTA_DEZENA
        INTO PREMIADO_PRIMEIRO, PREMIADO_SEGUNDO, PREMIADO_TERCEIRO, PREMIADO_QUARTO, PREMIADO_QUINTO, PREMIADO_SEXTO FROM CONCURSO
        WHERE IDCONCURSO = PCONCURSO;
   
   FOR AUX IN APOSTAS_CONCURSO(PCONCURSO) LOOP
   CONTADOR := 0;
        FOR AUX2 IN NUMERO_APOSTA(AUX.IDAPOSTA) LOOP
            IF(AUX2.NUMERO = PREMIADO_PRIMEIRO) THEN
                CONTADOR := CONTADOR +1;
            ELSIF(AUX2.NUMERO = PREMIADO_SEGUNDO) THEN
                CONTADOR := CONTADOR +1; 
            ELSIF(AUX2.NUMERO = PREMIADO_TERCEIRO) THEN
                CONTADOR := CONTADOR +1;
            ELSIF(AUX2.NUMERO = PREMIADO_QUARTO) THEN
                CONTADOR := CONTADOR +1;
            ELSIF(AUX2.NUMERO = PREMIADO_QUINTO) THEN
                CONTADOR := CONTADOR +1;
            ELSIF(AUX2.NUMERO = PREMIADO_SEXTO) THEN
                CONTADOR := CONTADOR +1;
            END IF;
        END LOOP;
   
    IF (CONTADOR = 4) THEN 
    INSERT INTO APOSTA_PREMIADA(IDAPOSTA, ACERTOS, VALOR) VALUES (AUX.IDAPOSTA, 4, 0.0);
    ELSIF (CONTADOR = 5) THEN
    INSERT INTO APOSTA_PREMIADA(IDAPOSTA, ACERTOS, VALOR) VALUES (AUX.IDAPOSTA, 5, 0.0);
    ELSIF(CONTADOR = 6) THEN 
    INSERT INTO APOSTA_PREMIADA(IDAPOSTA, ACERTOS, VALOR) VALUES (AUX.IDAPOSTA, 6, 0.0);  
    END IF;
END LOOP;

FOR AUX3 IN QUANTIDADE_PREMIADOS(PCONCURSO) LOOP           
        IF(AUX3.TIPOACERTO = 6) THEN 
            VALOR_FINAL_SENA :=VALOR_FINAL_SENA/AUX3.QUANTIDADE;
        ELSIF(AUX3.TIPOACERTO = 5) THEN
            VALOR_FINAL_QUINA :=VALOR_FINAL_QUINA/AUX3.QUANTIDADE;
        ELSIF(AUX3.TIPOACERTO = 4) THEN
            VALOR_FINAL_QUADRA :=VALOR_FINAL_QUADRA/AUX3.QUANTIDADE;
        END IF;         
END LOOP;

FOR AUX4 in PREMIADOS(PCONCURSO) LOOP        
    VALOR_UNITARIO := 0;
    
    IF(AUX4.ACERTOS = 4) THEN
    VALOR_UNITARIO := VALOR_FINAL_QUADRA; 
    ELSIF(AUX4.ACERTOS = 5) THEN
    VALOR_UNITARIO := VALOR_FINAL_QUINA;
    ELSIF(AUX4.ACERTOS = 6) THEN
    VALOR_UNITARIO := VALOR_FINAL_SENA;
    END IF;
    
    UPDATE APOSTA_PREMIADA
    SET VALOR = VALOR_UNITARIO
    WHERE IDAPOSTA = AUX4.IDAPOSTA;
END LOOP;

   
   END ATUALIZAACERTADORES;
   
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;
/
