/* a) Analisar a evolução das vendas mensais por tipo de cultura e hub? */
SELECT mesTempo Mês, anoTempo Ano, SUM(vendasEmMilharesEuros) VendasMensal
FROM DadosNegocio BD
JOIN Cultura C ON C.idCultura = BD.idCultura AND C.tipoCultura = 'T'
WHERE hubId = 1
GROUP BY mesTempo, anoTempo
ORDER BY anoTempo, mesTempo;
