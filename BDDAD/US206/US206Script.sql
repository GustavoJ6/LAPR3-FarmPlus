--INSERTS(CRIAÇÃO DE DADOS)
--PROCEDURE PARA CRIAR UM SETOR
CREATE OR REPLACE PROCEDURE proc_CreateSector(
    designacao_parameter IN Setor.designacao%TYPE,
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE,
    areaTotal_parameter IN Setor.AreaTotal%TYPE
)
AS
BEGIN
INSERT INTO Setor (designacao, idExploracaoAgricola, AreaTotal)
VALUES (designacao_parameter, idExploracaoAgricola_parameter, areaTotal_parameter);
END;
/

--PROCEDURE PARA CRIAR UMA CULTURA
CREATE OR REPLACE PROCEDURE proc_CreateCulture(
    designacaoSetor_parameter IN Cultura.designacaoSetor%TYPE,
    idExploracaoAgricola_parameter IN Cultura.idExploracaoAgricola%TYPE,
    areaCultura_parameter IN Cultura.AreaCultura%TYPE,
    tipo_parameter IN Cultura.tipo%TYPE,
    cultivo_parameter IN Cultura.cultivo%TYPE
)
AS
BEGIN
INSERT INTO Cultura ( designacaoSetor, idExploracaoAgricola, AreaCultura, tipo, cultivo)
VALUES ( designacaoSetor_parameter, idExploracaoAgricola_parameter, areaCultura_parameter, tipo_parameter, cultivo_parameter);
END;
/

--PROCEDURE PARA CRIAR UMA CARACTERÍSTICA
CREATE OR REPLACE PROCEDURE proc_CreateCharacteristic(
    idCultura_parameter IN Caracteristica.idCultura%TYPE,
    nome_parameter IN  Caracteristica.nome%TYPE
)
AS
BEGIN
INSERT INTO Caracteristica (idCultura, nome)
VALUES ( idCultura_parameter, nome_parameter);
END;
/

--PROCEDURE PARA CRIAR UM PARÂMETRO
CREATE OR REPLACE PROCEDURE proc_CreateParameter(
    idCaracteristica_parameter IN Parametro.idCaracteristica%TYPE,
    idCultura_parameter IN Parametro.idCultura%TYPE,
    nome_parameter IN Parametro.nome%TYPE
)
AS
BEGIN
INSERT INTO Parametro (idCaracteristica, idCultura, nome)
VALUES (idCaracteristica_parameter, idCultura_parameter, nome_parameter);
END;
/

--SELECTS (LISTAGEM DE DADOS PELAS ORDENS PEDIDAS)
--FUNÇÃO PARA RECEBER OS SETORES POR ORDEM ALFABÉTICA
CREATE OR REPLACE FUNCTION func_GetSectorAlphabetically(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
RETURN SYS_REFCURSOR
IS sector_cursor SYS_REFCURSOR;

BEGIN
OPEN sector_cursor FOR
SELECT *
FROM Setor
WHERE idExploracaoAgricola = idExploracaoAgricola_parameter
ORDER BY designacao;

RETURN sector_cursor;
END;
/

--PROCEDURE PARA LISTAR OS SETORES POR ORDEM ALFABÉTICA
CREATE OR REPLACE PROCEDURE proc_ListSectorsAlphabetically(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
IS
    sector_cursor SYS_REFCURSOR;
    designacao Setor.designacao%TYPE;
    idExploracaoAgricola Setor.idExploracaoAgricola%TYPE;
    areaTotal Setor.AreaTotal%TYPE;
BEGIN
    sector_cursor := func_GetSectorAlphabetically(idExploracaoAgricola_parameter);
    LOOP
FETCH sector_cursor INTO designacao, idExploracaoAgricola, areaTotal;
        EXIT WHEN sector_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Designação: ' || designacao || ' | ID da Exploração Agrícola- ' || idExploracaoAgricola || ' | Área Total- ' || areaTotal);
END LOOP;
CLOSE sector_cursor;
END;
/

--FUNÇÃO PARA RECEBER OS SETORES POR ORDEM CRESCENTE DE ÁREA
CREATE OR REPLACE FUNCTION func_GetSectorByAreaAsc(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
RETURN SYS_REFCURSOR
IS sector_cursor SYS_REFCURSOR;
BEGIN
OPEN sector_cursor FOR
SELECT *
FROM Setor
WHERE idExploracaoAgricola = idExploracaoAgricola_parameter
ORDER BY areaTotal;

RETURN sector_cursor;
END;
/

--PROCEDURE PARA LISTAR OS SETORES POR ORDEM CRESCENTE DE ÁREA
CREATE OR REPLACE PROCEDURE proc_ListSectorByAreaAsc(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
IS
    sector_cursor SYS_REFCURSOR;
    designacao Setor.designacao%TYPE;
    idExploracaoAgricola Setor.idExploracaoAgricola%TYPE;
    areaTotal Setor.AreaTotal%TYPE;
BEGIN
    sector_cursor := func_GetSectorByAreaAsc(idExploracaoAgricola_parameter);
    LOOP
FETCH sector_cursor INTO designacao, idExploracaoAgricola, areaTotal;
        EXIT WHEN sector_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Designação: ' ||designacao || ' | ID da Exploração Agrícola- ' || idExploracaoAgricola || ' | Área Total- ' || areaTotal);
END LOOP;
CLOSE sector_cursor;
END;
/

--FUNÇÃO PARA RECEBER OS SETORES POR ORDEM DECRESCENTE DE ÁREA
CREATE OR REPLACE FUNCTION func_GetSectorByAreaDesc(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
RETURN SYS_REFCURSOR
IS sector_cursor SYS_REFCURSOR;
BEGIN
OPEN sector_cursor FOR
SELECT *
FROM Setor
WHERE idExploracaoAgricola = idExploracaoAgricola_parameter
ORDER BY areaTotal DESC;

RETURN sector_cursor;
END;
/
--PROCEDURE PARA LISTAR OS SETORES POR ORDEM DECRESCENTE DE ÁREA
CREATE OR REPLACE PROCEDURE proc_ListSectorsByAreaDesc(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
    IS
    sector_cursor SYS_REFCURSOR;
    designacao Setor.designacao%TYPE;
    idExploracaoAgricola Setor.idExploracaoAgricola%TYPE;
    areaTotal Setor.AreaTotal%TYPE;
BEGIN
    sector_cursor := func_GetSectorByAreaDesc(idExploracaoAgricola_parameter);
    LOOP
FETCH sector_cursor INTO designacao, idExploracaoAgricola, areaTotal;
        EXIT WHEN sector_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Designação: ' ||designacao || ' | ID da Exploração Agrícola- ' || idExploracaoAgricola || ' | Área Total- ' || areaTotal);
END LOOP;
CLOSE sector_cursor;
END;
/

--PROCEDURE PARA LISTAR OS SETORES POR ORDEM DECRESCENTE DE ÁREA
CREATE OR REPLACE PROCEDURE proc_ListSectorsByAreaDesc(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
    IS
    sector_cursor SYS_REFCURSOR;
    designacao Setor.designacao%TYPE;
    idExploracaoAgricola Setor.idExploracaoAgricola%TYPE;
    areaTotal Setor.AreaTotal%TYPE;
BEGIN
    sector_cursor := func_GetSectorByAreaDesc(idExploracaoAgricola_parameter);
    LOOP
FETCH sector_cursor INTO designacao, idExploracaoAgricola, areaTotal;
        EXIT WHEN sector_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Designação: ' ||designacao || ' | ID da Exploração Agrícola- ' || idExploracaoAgricola || ' | Área Total- ' || areaTotal);
END LOOP;
CLOSE sector_cursor;
END;
/

--FUNÇÃO PARA RECEBER OS SETORES ORDENADOS POR CULTURA OU TIPO DE CULTURA
CREATE OR REPLACE FUNCTION func_GetSectorByCultureOrCultureType(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
RETURN SYS_REFCURSOR
IS sectorCulture_cursor SYS_REFCURSOR;

BEGIN
OPEN sectorCulture_cursor FOR
SELECT
    c.idCultura, c.designacaoSetor, c.idExploracaoAgricola, c.areaCultura, c.tipo, c.cultivo FROM Cultura c
                                                                                                      INNER JOIN Setor s ON c.designacaoSetor = s.designacao
WHERE s.idExploracaoAgricola = idExploracaoAgricola_parameter
ORDER BY c.tipo, c.cultivo;
RETURN sectorCulture_cursor;
END;
/
--PROCEDURE PARA LISTAR OS SETORES ORDENADOS POR CULTURA OU TIPO DE CULTURA
CREATE OR REPLACE PROCEDURE proc_ListSectorsByCultureOrCultureType(
    idExploracaoAgricola_parameter IN Setor.idExploracaoAgricola%TYPE
)
IS
    sectorCulture_cursor SYS_REFCURSOR;
    idCultura Cultura.idCultura%TYPE;
    designacaoSetor Cultura.designacaoSetor%TYPE;
    idExploracaoAgricola Cultura.idExploracaoAgricola%TYPE;
    areaCultura Cultura.areaCultura%TYPE;
    tipo Cultura.tipo%TYPE;
    cultivo Cultura.cultivo%TYPE;
BEGIN
    sectorCulture_cursor := func_GetSectorByCultureOrCultureType(idExploracaoAgricola_parameter);
    LOOP
FETCH sectorCulture_cursor INTO idCultura, designacaoSetor, idExploracaoAgricola, areaCultura, tipo, cultivo;
        EXIT WHEN sectorCulture_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID Cultura- ' || idCultura || ' | Designação do Setor- ' || designacaoSetor || ' | ID da Exploração Agrícola- ' || idExploracaoAgricola || ' | Área da Cultura- ' || areaCultura || ' | Tipo de Cultura- ' || tipo || ' | Cultura- ' || cultivo);
END LOOP;
CLOSE sectorCulture_cursor;
END;
/
