BEGIN
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('*                 US208 - Demonstration                    *');
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('*******|Registering, Listing and Altering package data|*****');
END;
/

-- ************************************************************
-- *  Procedure: prc_create_fatorProducao
-- *  Description: Inserts a new fatorProducao into the database
-- ************************************************************

-- call prc_create_fatorProducao with correct values

BEGIN
    dbms_output.put_line('Expected: O Fator de Produção, - ... - foi criado com sucesso!');
    dbms_output.put_line('Actual: ');
    procCreateFatorProducao(
            'FatorProducao',
            'FE',
        'Fornecedor'
        );
END;
/

-- ************************************************************
-- *  Procedure: prc_create_constituinte
-- *  Description: Inserts a new constituinte into the database
-- ************************************************************

-- call prc_create_constituinte with correct values

BEGIN
    dbms_output.put_line('Expected: O Constituinte - ... - foi criado com sucesso!');
    dbms_output.put_line('Actual: ');
    procCreateConstituinte('Constituinte', 30, '%', 'E');
END;
/

-- call prc_create_constituinte with incorrect values

BEGIN
    dbms_output.put_line('Expected: Não foi possível adicionar o Constituinte, -...');
    dbms_output.put_line('Actual: ');
    procCreateConstituinte('Constituinte', -1, '%', 'E');
END;
/

-- call prc_create_fatorProducao with wrong values

BEGIN
    dbms_output.put_line('Expected: Não foi possível adicionar o Fator de Produção, - ...');
    dbms_output.put_line('Actual: ');
    procCreateFatorProducao(
            'FatorProducao',
            'OA',
        'Fornecedor'
        );
END;
/

-- ************************************************************
-- *  Procedure: prc_create_FatorProducaoConstituinte
-- *  Description: Inserts a new FatorProducaoConstituinte into the database
-- ************************************************************

-- call prc_create_FatorProducaoConstituinte with correct values

BEGIN
    dbms_output.put_line('Expected: A Ficha Técnica - ... - foi criada com sucesso!');
    dbms_output.put_line('Actual: ');
    procCreateFatorProducaoConstituinte('FatorProducao', 'Constituinte');
END;
/
