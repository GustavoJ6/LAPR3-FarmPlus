CREATE OR REPLACE NONEDITIONABLE PROCEDURE proc_productionEvolutionOver5Years (
    designacao_param IN Setor.designacao%TYPE,
    idExploracaoAgricola_param IN Setor.idExploracaoAgricola%TYPE,
    idCultura_param IN Cultura.idCultura%TYPE
)
IS

CURSOR result_cursor IS
SELECT anoTempo Ano, SUM(producaoEmToneladas) ProducaoTotal,
       SUM(producaoEmToneladas) - LAG( SUM(producaoEmToneladas)) OVER (ORDER BY anoTempo) Diferença
FROM DadosNegocio BD
JOIN Setor S ON S.designacao = designacao_param AND S.idExploracaoAgricola = idExploracaoAgricola_param
WHERE idCultura = idCultura_param
GROUP BY anoTempo;

p_ano Tempo.ano%TYPE;
p_producaoTotal DadosNegocio.producaoEmToneladas%TYPE;
p_diferenca DadosNegocio.producaoEmToneladas%TYPE;


BEGIN

OPEN result_cursor;
LOOP
FETCH result_cursor INTO p_ano, p_producaoTotal, p_diferenca;
        EXIT WHEN result_cursor%NOTFOUND;
            dbms_output.put_line('-----------------------------------------');
            dbms_output.put_line('Ano --> ' ||  TO_CHAR(p_ano, 'YYYY'));
            dbms_output.put_line('Produção Total --> ' ||  p_producaoTotal);
            dbms_output.put_line('Diferença --> ' ||  p_diferenca);
            dbms_output.put_line('-----------------------------------------');
            dbms_output.put_line('');
END LOOP;
CLOSE result_cursor;
END;
/




CREATE OR REPLACE NONEDITIONABLE PROCEDURE proc_comparisonBetweenTwoYears (
    ano1_param Tempo.ano%TYPE,
    ano2_param Tempo.ano%TYPE
)
IS

CURSOR result_cursor IS
SELECT anoTempo Ano, SUM(vendasEmMilharesEuros) VendasTotal
FROM DadosNegocio
WHERE anoTempo IN (ano1_param, ano2_param)
GROUP BY anoTempo
ORDER BY anoTempo;

p_ano Tempo.ano%TYPE;
p_vendasTotal DadosNegocio.vendasEmMilharesEuros%TYPE;


BEGIN

OPEN result_cursor;
LOOP
FETCH result_cursor INTO p_ano, p_vendasTotal;
        EXIT WHEN result_cursor%NOTFOUND;
            dbms_output.put_line('------------------------------');
            dbms_output.put_line('Ano --> ' || TO_CHAR(p_ano, 'YYYY'));
            dbms_output.put_line('Venda Total --> ' || p_vendasTotal);
            dbms_output.put_line('------------------------------');
            dbms_output.put_line('');
END LOOP;
CLOSE result_cursor;
END;
/


CREATE OR REPLACE NONEDITIONABLE PROCEDURE proc_salesMonthlyEvolution (
    tipoCultura_param Cultura.tipoCultura%TYPE
)
IS

CURSOR result_cursor IS
SELECT mesTempo Mês, anoTempo Ano, SUM(vendasEmMilharesEuros) VendasMensal
FROM DadosNegocio BD
JOIN Cultura C ON C.idCultura = BD.idCultura AND C.tipoCultura = tipoCultura_param
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
DBMS_OUTPUT.PUT_LINE('a)');
proc_productionEvolutionOver5Years('A', 100, 10);
DBMS_OUTPUT.PUT_LINE('b)');
proc_comparisonBetweenTwoYears(TO_DATE('2020', 'YYYY'), TO_DATE('2021', 'YYYY'));
DBMS_OUTPUT.PUT_LINE('c)');
proc_salesMonthlyEvolution('T');
END;