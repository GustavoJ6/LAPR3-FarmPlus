BEGIN
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('*                 US206 - Demonstration                    *');
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Inserting a new sector and its characteristics into the database|********');
END;
/

-- *******************************************************************************
-- *  Procedure : proc_CreateSector
-- *  Description: Procedure that inserts a sectors in an agricultural exploration
-- *******************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Create a sector in an agricultural exploration|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/
DECLARE
numberOfSectorsExpected NUMBER;
numberOfSectorsActual NUMBER;
BEGIN
SELECT COUNT(*) INTO numberOfSectorsExpected FROM Setor;
numberOfSectorsExpected := numberOfSectorsExpected + 1;
    proc_CreateSector('J', 100, 185.0);
SELECT COUNT(*) INTO numberOfSectorsActual FROM Setor;

dbms_output.put_line('Number of sectors expected: ' || numberOfSectorsExpected);
    dbms_output.put_line('Number of sectors actual: ' || numberOfSectorsActual);

END;
/
-- *******************************************************************************************
-- *  Procedure : proc_CreateCulture
-- *  Description: Procedure that inserts a culture in a sector of an agricultural exploration
-- *******************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Create a culture|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/
DECLARE
numberOfCulturesExpected NUMBER;
    numberOfCulturesActual NUMBER;
BEGIN
SELECT COUNT(*) INTO numberOfCulturesExpected FROM Cultura;
numberOfCulturesExpected := numberOfCulturesExpected + 1;
    proc_CreateCulture('J', 100, 185.0, 'P', 'Batata');
SELECT COUNT(*) INTO numberOfCulturesActual FROM Cultura;
dbms_output.put_line('Number of cultures expected: ' || numberOfCulturesExpected);
    dbms_output.put_line('Number of cultures actual: ' || numberOfCulturesActual);
END;
/
-- ********************************************************************
-- *  Procedure : proc_CreateCharacteristic
-- *  Description: Procedure that inserts a characteristic in a culture
-- ********************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Create a characteristic|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/
DECLARE
numberOfCharacteristicsExpected NUMBER;
    numberOfCharacteristicsActual NUMBER;
BEGIN
SELECT COUNT(*) INTO numberOfCharacteristicsExpected FROM Caracteristica;
numberOfCharacteristicsExpected := numberOfCharacteristicsExpected + 1;
    proc_CreateCharacteristic(1, 'Cultivo');
SELECT COUNT(*) INTO numberOfCharacteristicsActual FROM Caracteristica;
dbms_output.put_line('Number of characteristics expected: ' || numberOfCharacteristicsExpected);
    dbms_output.put_line('Number of characteristics actual: ' || numberOfCharacteristicsActual);
END;
/
-- ***********************************************************************
-- *  Procedure : proc_CreateParameter
-- *  Description: Procedure that inserts a parameter in of characteristic
-- ***********************************************************************
BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Create a parameter|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/
DECLARE
numberOfParametersExpected NUMBER;
    numberOfParametersActual NUMBER;
BEGIN
SELECT COUNT(*) INTO numberOfParametersExpected FROM Parametro;
numberOfParametersExpected := numberOfParametersExpected + 1;
    proc_CreateParameter(1, 1, 'Batata');
SELECT COUNT(*) INTO numberOfParametersActual FROM Parametro;
dbms_output.put_line('Number of parameters expected: ' || numberOfParametersExpected);
    dbms_output.put_line('Number of parameters actual: ' || numberOfParametersActual);
END;
/

-- **********************************************************************************************
-- *  Procedure : proc_ListSectorsAlphabetically
-- *  Description: Procedure that lists all sectors of an agricultural exploration alphabetically
-- **********************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|List all sectors of an agricultural exploration alphabetically|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/
--EXECUÇÃO DA LISTAGEM DE SETORES POR ORDEM ALFABÉTICA
BEGIN
    proc_ListSectorsAlphabetically(100);
END;
/
-- **************************************************************************************************
-- *  Procedure : proc_ListSectorsByAreaAsc
-- *  Description: Procedure that lists all sectors of an agricultural exploration by ascending order
-- **************************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|List all sectors of an agricultural exploration by ascending order|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/
BEGIN
    proc_ListSectorByAreaAsc(100);
END;
/
-- ***************************************************************************************************
-- *  Procedure : proc_ListSectorsByAreaDesc
-- *  Description: Procedure that lists all sectors of an agricultural exploration by descending order
-- ***************************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|List all sectors of an agricultural exploration by descending order|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/
BEGIN
    proc_ListSectorsByAreaDesc(100);
END;
/
-- **********************************************************************************************************
-- *  Procedure : proc_ListSectorsByCultureOrCultureType
-- *  Description: Procedure that lists all sectors of an agricultural exploration by culture or culture type
-- **********************************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|List all sectors of an agricultural exploration by culture or culture type|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    proc_ListSectorsByCultureOrCultureType(100);
END;
/
--DELETE DE UM PARÂMETRO
DECLARE
    erase NUMBER;
BEGIN
    SELECT COUNT(*) INTO erase FROM Parametro;
    DELETE FROM Parametro WHERE idParametro = erase;
END;
/

--DELETE DE UMA CARACTERÍSTICA
DECLARE
   erase NUMBER;
BEGIN
    SELECT COUNT(*) INTO ERASE FROM Caracteristica;
DELETE FROM Caracteristica WHERE idCaracteristica = erase;
END;
/

--DELETE DE UMA CULTURA
DECLARE
    erase NUMBER;
BEGIN
    SELECT COUNT(*) INTO erase FROM Cultura;
    DELETE FROM Safra WHERE idCultura = erase;
    DELETE FROM Cultura WHERE idCultura = erase;
END;
/

--DELETE DE UM SETOR
DELETE FROM Cultura WHERE designacaoSetor = 'J';
DELETE FROM Setor WHERE designacao = 'J' AND idExploracaoAgricola = 100;