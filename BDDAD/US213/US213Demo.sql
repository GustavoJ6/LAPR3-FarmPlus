-- *********************************************************************************
-- *  DISCLAIMER: IT IS NEEDED TO RUN THE BOOTSTRAP IN ORDER FOR THIS TO WORK!!!   *
-- *********************************************************************************


BEGIN
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('*                 US213 - Demonstration                    *');
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('    ');
    DBMS_OUTPUT.PUT_LINE('**********|Making changes in the OperacaoAgricola Table|********');
end;
/

-- ************************************************************
-- *  Function: trig_registOperationOnOperacaoAgricola
-- *  Description: Inserts a new row for each change made
-- *  in the OperacaoAgricola table
-- ************************************************************

-- making 10 changes to the OperacaoAgricola table
DECLARE
auxiliarID INTEGER;
BEGIN

INSERT INTO OperacaoAgricola(DESIGNACAOSETOR,IDEXPLORACAOAGRICOLA,DATAAGENDADA,DATAREALIZACAO,TIPO,ESTADOOPERACAO)  VALUES('A', 100, TO_DATE('07-03-2023','DD-MM-YYYY'), TO_DATE('17-03-2023','DD-MM-YYYY'), 'Irrigação e adubação', 'R');
INSERT INTO OperacaoAgricola(DESIGNACAOSETOR,IDEXPLORACAOAGRICOLA,DATAAGENDADA,DATAREALIZACAO,TIPO,ESTADOOPERACAO) VALUES('A', 100, TO_DATE('06-03-2023','DD-MM-YYYY'), TO_DATE('03-04-2023','DD-MM-YYYY'), 'Aplicação Fator de Produção', 'R');
INSERT INTO OperacaoAgricola(DESIGNACAOSETOR,IDEXPLORACAOAGRICOLA,DATAAGENDADA,DATAREALIZACAO,TIPO,ESTADOOPERACAO) VALUES('A', 100, TO_DATE('09-01-2023','DD-MM-YYYY'), TO_DATE('15-02-2023','DD-MM-YYYY'), 'Irrigação e adubação', 'R');
DELETE FROM OperacaoAgricola WHERE DATAAGENDADA = TO_DATE('09-01-2023','DD-MM-YYYY');
UPDATE OperacaoAgricola SET DATAAGENDADA = TO_DATE('09-03-2023','DD-MM-YYYY') where DATAAGENDADA = TO_DATE('07-03-2023','DD-MM-YYYY');
UPDATE OperacaoAgricola SET DATAAGENDADA = TO_DATE('07-02-2023','DD-MM-YYYY') where DATAAGENDADA = TO_DATE('06-03-2023','DD-MM-YYYY');
INSERT INTO OperacaoAgricola(DESIGNACAOSETOR,IDEXPLORACAOAGRICOLA,DATAAGENDADA,DATAREALIZACAO,TIPO,ESTADOOPERACAO) VALUES('A', 100, TO_DATE('18-03-2023','DD-MM-YYYY'), TO_DATE('19-03-2023','DD-MM-YYYY'), 'Irrigação e adubação', 'R');
INSERT INTO OperacaoAgricola(DESIGNACAOSETOR,IDEXPLORACAOAGRICOLA,DATAAGENDADA,DATAREALIZACAO,TIPO,ESTADOOPERACAO) VALUES('A', 100, TO_DATE('06-02-2023','DD-MM-YYYY'), TO_DATE('04-04-2023','DD-MM-YYYY'), 'Aplicação Fator de Produção', 'R');
UPDATE OperacaoAgricola SET DATAREALIZACAO = TO_DATE('20-03-2023','DD-MM-YYYY') where DATAREALIZACAO = TO_DATE('19-03-2023','DD-MM-YYYY');
DELETE FROM FatoresAplicados WHERE idOperacaoAgricola = 1;
DELETE FROM OperacaoAgricola WHERE DATAREALIZACAO = TO_DATE('04-04-2023','DD-MM-YYYY');


END;
/

-- ************************************************************
-- *  Function: proc_checkAuditlog
-- *  Description: Visualizes the audit log for a given sector
-- ************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Visualizing the Audit log|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

CALL PROC_CHECKAUDITLOG('A', 100);


-- CLEANUP
--delete from Auditoria where designacaoSetor = 'A' and idExploracaoAgricola = 100;
DELETE FROM AUDITORIA WHERE IDAUDITORIA IN (
    SELECT IDAUDITORIA FROM
        ( SELECT * FROM AUDITORIA
          ORDER BY IDAUDITORIA DESC) WHERE ROWNUM <= 10);

DELETE FROM OPERACAOAGRICOLA WHERE IDOPERACAOAGRICOLA IN (
    SELECT IDOPERACAOAGRICOLA FROM
        ( SELECT * FROM OPERACAOAGRICOLA
          ORDER BY IDOPERACAOAGRICOLA DESC) WHERE ROWNUM <= 3);
-- END CLEANUP