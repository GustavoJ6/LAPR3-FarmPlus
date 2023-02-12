/* a) Qual é a evolução da produção de uma determinada cultura num determinado setor ao longo dos últimos cinco anos? */
SELECT TO_CHAR(anoTempo, 'YYYY') Ano, SUM(producaoEmToneladas) ProducaoTotal,
       SUM(producaoEmToneladas) - LAG( SUM(producaoEmToneladas)) OVER (ORDER BY anoTempo) Diferença
FROM DadosNegocio BD
         JOIN Setor S ON S.designacao = 'A' AND S.idExploracaoAgricola = 100
WHERE idCultura = 10
GROUP BY anoTempo;


/* b) Comparar as vendas de um ano com outro? */
SELECT TO_CHAR(anoTempo, 'YYYY') Ano, SUM(vendasEmMilharesEuros) VendasTotal
FROM DadosNegocio
WHERE anoTempo IN (TO_DATE('2020', 'YYYY'), TO_DATE('2021', 'YYYY'))
GROUP BY anoTempo
ORDER BY anoTempo;


/* c) Analisar a evolução das vendas mensais por tipo de cultura? */
SELECT TO_CHAR(mesTempo, 'MM') Mês, TO_CHAR(anoTempo, 'YYYY') Ano, SUM(vendasEmMilharesEuros) VendasMensais
FROM DadosNegocio BD
JOIN Cultura C ON C.idCultura = BD.idCultura AND C.tipoCultura = 'T'
GROUP BY mesTempo, anoTempo
ORDER BY anoTempo, mesTempo;
