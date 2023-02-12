/* 1- It is possible to execute a procedure for the table hub to be updated whenever table input_hub is updated */

CREATE OR REPLACE PROCEDURE proc_UpdateHub
IS
    /* VARIÁVEIS DE APOIO À EXECUÇÃO DO PROCEDIMENTO */
    cursorToInsert SYS_REFCURSOR;
    idHubVar  Hub.idHub%TYPE;
    latitudeVar Hub.latitude%TYPE;
    longitudeVar Hub.longitude%TYPE;
    idParticipanteVar Hub.idParticipante%TYPE;
    stringVar        Input_Hub.input_string%TYPE;
    alreadyExists    NUMBER;
BEGIN
    /* CURSOR QUE PERMITE EXECUTAR O PROCEDIMENTO PARA TODOS OS INPUTS */
    OPEN cursorToInsert FOR
    SELECT input_string FROM Input_Hub;
    LOOP
    FETCH cursorToInsert Into stringVar;
    EXIT WHEN cursorToInsert%NOTFOUND;

    /* AS LINHAS QUE SE SEGUEM ATÉ À INSTRUÇÃO DE SELECT PERMITEM DIVIDIR A STRING POR ";" E GUARDAR CADA VALOR NA RESPETIVA VARIÁVEL */
    idHubVar := TO_CHAR(REGEXP_SUBSTR(stringVar, '[^;]+', 1, 1));
    latitudeVar := TO_NUMBER(REGEXP_SUBSTR(stringVar, '[^;]+', 1, 2));
    longitudeVar := TO_NUMBER(REGEXP_SUBSTR(stringVar, '[^;]+', 1, 3));
    idParticipanteVar := TO_CHAR(REGEXP_SUBSTR(stringVar, '[^;]+', 1, 4));
    /* ATRIBUIÇÃO QUE PERMITE VERIFICAR SE UM DADO HUB JÁ SE ENCONTRA REGISTADO NA BASE DE DADOS */
    SELECT COUNT(*) INTO alreadyExists FROM Hub WHERE idHub = idHubVar;

    /* SE O HUB NÃO SE ENCONTRAR REGISTADO E NÃO FOR DO TIPO 'C' NO PARÂMETRO IDPARTICIPANTE, EXECUTAR O CÓDIGO QUE SE SEGUE */
IF alreadyExists = 0 AND idParticipanteVar NOT LIKE 'C%' THEN
        INSERT INTO Hub VALUES (idHubVar, TO_NUMBER(latitudeVar), TO_NUMBER(longitudeVar), idParticipanteVar);
        dbms_output.put_line('Hub ' || idHubVar || ' inserido com sucesso.');
    /* SE O HUB JÁ SE ENCONTRAR REGISTADO, IMPRIMIR A SEGUINTE MENSAGEM. */
ELSE IF alreadyExists <> 0 THEN
        dbms_output.put_line('O Hub com o id ' || idHubVar || ' já existe .');
    /* SE O HUB FOR DO TIPO 'C', IMPRIMIR A SEGUINTE MENSAGEM. */
ELSE IF idParticipanteVar LIKE 'C%' THEN
        dbms_output.put_line('O Hub com o id ' || idHubVar || ' não pode ser inserido por se tratar de um Cliente.');
END IF;
END IF;
END IF;
END LOOP;
    /* EXCEÇÃO PARA QUANDO NÃO EXISTE INFORMAÇÃO A DAR */
EXCEPTION WHEN NO_DATA_FOUND THEN
    dbms_output.put_line('Não há dados para inserir.');
END;
/


/* 2- I can run a procedure that updates the default hub of a client */

CREATE OR REPLACE PROCEDURE proc_UpdateDefaultHub (
    cod_client IN Cliente.codigoInterno%type,
    cod_hub IN Hub.idHub%type) IS

    validation NUMBER;
    validation2 NUMBER;

BEGIN
        SELECT count(*) INTO validation
        FROM CLIENTE
        WHERE CODIGOINTERNO = cod_client;

        SELECT count(*) INTO validation2
        FROM Hub
        WHERE idHub = cod_hub;

        IF validation = 1 AND validation2 = 1 THEN
            UPDATE CLIENTE
            SET idHub = cod_hub
            WHERE codigoInterno = cod_client;
            dbms_output.put_line('### Default hub for client has been updated ###');
        ELSE
            dbms_output.put_line('### Client or Hub has not been found ###');
        END IF;
END;
/


/* 3- When an Order (Encomenda) is placed, a hub different than the default one may be indicated as a pick up place.
        This hub should be valid (present in table HUB) */

/* This procedure is very similar to the one in US209, as far as registering a package is concerned;
   In this case, we will not use the values of "Morada" in the package registration, rather, we will use the hubs as a
   reference place for pickup*/

CREATE OR REPLACE PROCEDURE proc_RegisterPackageWithHub (
    cod_client IN Encomenda.codigoInternoCliente%type,
    data_Encomenda IN Encomenda.dataEncomenda%type,
    price IN Encomenda.valorTotal%type,
    cod_hub IN Hub.idHub%type) IS

    p_plafond_cliente Cliente.plafond%type;
    validation NUMBER;

BEGIN

    SELECT plafond INTO p_plafond_cliente
    FROM Cliente c
    WHERE c.codigoInterno = cod_client;

    SELECT COUNT(*) INTO validation
    FROM Hub h
    WHERE h.idHub = cod_hub;


    IF price <= p_plafond_cliente AND validation = 1 THEN

        INSERT INTO Encomenda (codigoInternoCliente, dataEncomenda, estado, idHub)
        VALUES (cod_client, data_Encomenda, 'R', cod_hub);
        dbms_output.put_line('Package registered for user: ' || cod_client);
        dbms_output.put_line('Pick-up registered for hub: ' || cod_hub);
    ELSE
        dbms_output.put_line('### An error occurred, package could not be  ');
    END IF;

END;
/
