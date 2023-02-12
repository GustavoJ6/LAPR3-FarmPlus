CREATE OR REPLACE TRIGGER trig_registOperationOnOperacaoAgricola
AFTER INSERT OR UPDATE OR DELETE ON operacaoagricola
    FOR EACH ROW
DECLARE
operationType AUDITORIA.OPERACAOESCRITA%TYPE;
	designacaoSetorV OPERACAOAGRICOLA.DESIGNACAOSETOR%TYPE;
	idExploracaoAgricolaV OPERACAOAGRICOLA.IDEXPLORACAOAGRICOLA%TYPE;
BEGIN

	operationType :=
	CASE
		WHEN INSERTING THEN 'INSERT'
		WHEN UPDATING THEN 'UPDATE'
		ELSE 'DELETE'
END;

	IF INSERTING OR UPDATING THEN
		designacaoSetorV := :NEW.designacaosetor;
	   idExploracaoAgricolaV := :NEW.idExploracaoAgricola;
ELSE
		designacaoSetorV := :OLD.designacaosetor;
	    idExploracaoAgricolaV := :OLD.idExploracaoAgricola;
END IF;

INSERT INTO auditoria (designacaoSetor, idExploracaoAgricola, dataHora, username, operacaoEscrita)
VALUES (designacaoSetorV, idExploracaoAgricolaV, SYSDATE, USER, operationType);
END;
/

CREATE OR REPLACE PROCEDURE PROC_CHECKAUDITLOG(designacaoSetor_in IN AUDITORIA.DESIGNACAOSETOR%TYPE,
                                                    idExploracaoAgricola_in IN AUDITORIA.IDEXPLORACAOAGRICOLA%TYPE)
IS
    auditLog_cursor          SYS_REFCURSOR;
    designacaoSetor_out      AUDITORIA.DESIGNACAOSETOR%TYPE;
    idExploracaoAgricola_out AUDITORIA.IDEXPLORACAOAGRICOLA%TYPE;
    idregisto_out            AUDITORIA.IDAUDITORIA%TYPE;
    dataHora_out             AUDITORIA.DATAHORA%TYPE;
    username_out             AUDITORIA.USERNAME%TYPE;
    operecao_out             AUDITORIA.OPERACAOESCRITA%TYPE;


BEGIN

OPEN auditLog_cursor FOR
SELECT IDAUDITORIA, DESIGNACAOSETOR, IDEXPLORACAOAGRICOLA, DATAHORA, USERNAME, OPERACAOESCRITA
FROM Auditoria
WHERE designacaoSetor = designacaoSetor_in
  AND idExploracaoAgricola = idExploracaoAgricola_in
 ORDER BY dataHora DESC;


LOOP
FETCH auditLog_cursor INTO idregisto_out, designacaoSetor_out, idExploracaoAgricola_out, dataHora_out, username_out, operecao_out;
        EXIT WHEN auditLog_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Registo ID: ' || idregisto_out ||
                             ' | ID da Exploração Agrícola: ' || idExploracaoAgricola_out ||
                             ' | Setor: ' || designacaoSetor_out ||
                             ' | User: ' || username_out ||
                             ' | Data: ' || TO_CHAR(dataHora_out, 'DD-MON-YYYY HH24:MI:SS') ||
                             ' | Operacao: ' || operecao_out);
END LOOP;
CLOSE auditLog_cursor;
END;
/
