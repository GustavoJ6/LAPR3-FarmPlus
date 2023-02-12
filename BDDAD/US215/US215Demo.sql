-- CLEANUP
DELETE FROM Encomenda e
WHERE e.codigoInternoCliente = 70;

DELETE FROM Cliente c
WHERE c.codigoInterno = 70;

DELETE FROM Hub h
WHERE h.idHub = 'CT10' OR h.idHub = 'CT11' OR h.idHub = 'CT14';
-- END CLEANUP


/* Esta demo tem o objetivo de testar os procedimentos da US215 (todas as demos têm resultados de acordo com o bootstrap) */
BEGIN
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('*                 US215 - Demonstration                    *');
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**| Atualizar tabelas, hubs por defeito e inserir encomendas |**');
end;
/

-- **************************************************************************************************
-- *  Procedure: proc_UpdateHub
-- *  Descrição: Procedure que permite atualizar a tabela Hub quando a tabela input_hub é atualizada.
-- **************************************************************************************************


BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza a tabela Hub quando a tabela Input_Hub é atualizada|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

/* PARA O CORRETO FUNCIONAMENTO DESTA EXECUÇÃO NO SQL DEVELOPER, DEVE SER ALTERADO O SEPARADOR DECIMAL DE "," para "." EM TOOLS > PREFERENCES > DATABASE > NLS > DECIMAL SEPARATOR */

BEGIN
   proc_UpdateHub;
END;
/

-- **********************************************************************************
-- *  Procedure: proc_UpdateDefaultHub
-- *  Descrição: Atualizar ou se não existente, inserir um hub id na tabela Cliente
-- **********************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza Ou Insere caso não exista, um hub id na Tabela Cliente|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

INSERT INTO Cliente(codigoInterno, EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF, idHub) VALUES(70, 'abc@abc.com', 'E', 1250.50, 'C', 'abc', 247677979, 'CT10');

-- call proc_update_default_hub for a client

--should show CT10
SELECT idHub FROM Cliente
WHERE email = 'abc@abc.com';

BEGIN
    DBMS_OUTPUT.PUT_LINE('Expected: ### Default hub for client has been updated ###');
    DBMS_OUTPUT.PUT_LINE('Actual:');

    proc_UpdateDefaultHub(70, 'CT11');
END;
/

--should show CT11
SELECT idHub FROM Cliente
WHERE email = 'abc@abc.com';

-- **********************************************************************************
-- *  Procedure: proc_RegisterPackageWithHub
-- *  Descrição: Regista uma encomenda com um hub como sítio de entrega e sem morada
-- **********************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Registar uma encomenda com um hub como sítio de entrega|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/


-- call proc_register_package_with_hub

BEGIN
    dbms_output.put_line('Expected: ');
    dbms_output.put_line('Package registered for user: 70' );
    dbms_output.put_line('Pick-up registered for hub: CT10' );
    dbms_output.put_line('Actual: ');
    proc_RegisterPackageWithHub(70,TO_DATE('19-04-2005', 'DD-MM-YYYY'),10,'CT10');
END;
/

--should show a tuple of Encomenda where the hub is CT10 and the client who ordered it having default hub CT11
SELECT * FROM Encomenda e
WHERE e.codigoInternoCliente = 70;
SELECT * FROM Cliente c
WHERE c.codigoInterno = 70;