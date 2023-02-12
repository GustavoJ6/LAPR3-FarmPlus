CREATE OR REPLACE PROCEDURE proc_get_sector_rentability_exploration_profit (
IDEXPLORACAOAGRICOLA_CHECK IN Setor.IDEXPLORACAOAGRICOLA%Type,
CULTIVO_CHECK IN Cultura.CULTIVO%Type
)

IS

CURSOR sector_cursor IS 
SELECT DESIGNACAO, AREACULTURA, IDSAFRA
    FROM Setor s
INNER JOIN Cultura c
    ON s.designacao = c.designacaosetor
INNER JOIN Safra saf
    ON c.IDCULTURA = saf.IDCULTURA
WHERE c.cultivo = CULTIVO_CHECK
AND s.IDEXPLORACAOAGRICOLA = IDEXPLORACAOAGRICOLA_CHECK
ORDER BY (saf.LUCRO/c.AREACULTURA) DESC;

p_sector_designacao Setor.designacao%Type;
p_cultura_area Cultura.AREACULTURA%Type;
p_safra_id Safra.IDSAFRA%Type;

BEGIN
    OPEN sector_cursor;
  LOOP
    FETCH sector_cursor INTO p_sector_designacao, p_cultura_area, p_safra_id;
    EXIT WHEN sector_cursor%NotFound;
        dbms_output.put_line('-----------------------------------------');
        dbms_output.put_line('Designação Setor --> ' ||  p_sector_designacao);
        dbms_output.put_line('Área Cultura --> ' ||  p_cultura_area);
        dbms_output.put_line('ID Safra --> ' ||  p_safra_id);
        dbms_output.put_line('-----------------------------------------');
  END LOOP;
    CLOSE sector_cursor;
END;
/

-- The next procedure is used to replace the profit with the quantity

CREATE OR REPLACE PROCEDURE proc_get_sector_rentability_exploration_quantity (
IDEXPLORACAOAGRICOLA_CHECK IN Setor.IDEXPLORACAOAGRICOLA%Type,
CULTIVO_CHECK IN Cultura.CULTIVO%Type
)

IS

CURSOR sector_cursor IS
SELECT DESIGNACAO, AREACULTURA, IDSAFRA
FROM Setor s
         INNER JOIN Cultura c
                    ON s.designacao = c.designacaosetor
         INNER JOIN Safra saf
                    ON c.IDCULTURA = saf.IDCULTURA
WHERE c.cultivo = CULTIVO_CHECK
  AND s.IDEXPLORACAOAGRICOLA = IDEXPLORACAOAGRICOLA_CHECK
ORDER BY (saf.QUANTIDADEPRODUCAO/c.AREACULTURA) DESC;

p_sector_designacao Setor.designacao%Type;
p_cultura_area Cultura.AREACULTURA%Type;
p_safra_id Safra.IDSAFRA%Type;
p_setor_lucro_safra NUMBER;

BEGIN
OPEN sector_cursor;
LOOP
FETCH sector_cursor INTO p_sector_designacao, p_cultura_area, p_safra_id;
    EXIT WHEN sector_cursor%NotFound;
        dbms_output.put_line('-----------------------------------------');
        dbms_output.put_line('Designação Setor --> ' ||  p_sector_designacao);
        dbms_output.put_line('ID Safra --> ' ||  p_safra_id);
        dbms_output.put_line('Área Cultura --> ' ||  p_cultura_area);
        dbms_output.put_line('-----------------------------------------');
END LOOP;
CLOSE sector_cursor;
END;
/

-- After executing the procedure, the output should be taken this:
EXECUTE proc_get_sector_rentability_exploration_quantity(100, 'Chuchu');

-- After executing the procedure, the output should be taken this:
EXECUTE proc_get_sector_rentability_exploration_profit(100, 'Chuchu');