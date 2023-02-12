CREATE OR REPLACE PROCEDURE proc_salesMonthlyEvolution (
    tipoCultura_param Cultura.tipoCultura%TYPE,
    hubId_param Hub.hubId%TYPE
)
IS

CURSOR result_cursor IS
SELECT mesTempo Mês, anoTempo Ano, SUM(vendasEmMilharesEuros) VendasMensal
FROM DadosNegocio BD
         JOIN Cultura C ON C.idCultura = BD.idCultura AND C.tipoCultura = tipoCultura_param
WHERE hubId = hubId_param
GROUP BY mesTempo, anoTempo
ORDER BY anoTempo, mesTempo;

p_mes Tempo.mes%TYPE;
p_ano Tempo.ano%TYPE;
p_vendaMensal DadosNegocio.vendasEmMilharesEuros%TYPE;


BEGIN

OPEN result_cursor;
LOOP
FETCH result_cursor INTO p_mes, p_ano, p_vendaMensal;
        EXIT WHEN result_cursor%NOTFOUND;
            dbms_output.put_line('------------------------------');
            dbms_output.put_line('Mês --> ' || TO_CHAR(p_mes, 'MM'));
            dbms_output.put_line('Ano --> ' || TO_CHAR(p_ano, 'YYYY'));
            dbms_output.put_line('Venda Total --> ' || p_vendaMensal);
            dbms_output.put_line('------------------------------');
            dbms_output.put_line('');
END LOOP;
CLOSE result_cursor;
END;
/

BEGIN
proc_salesMonthlyEvolution('T',1);
END;