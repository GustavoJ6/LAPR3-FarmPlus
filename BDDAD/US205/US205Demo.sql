BEGIN
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('*                 US205 - Demonstration                    *');
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Inserting a new client into the database|********');
end;
/

-- ************************************************************
-- *  Function: func_InsertClientData
-- *  Description: Inserts a new client into the database
-- ************************************************************

-- call func_InsertClientData with correct parameters
DECLARE
output varchar(100);
BEGIN
output := func_InsertClientData('user205@gmail.com', 'P', 10000.0, 'B',
                                    'User 205 ', '174539823', '4465-089', 'Porto',
                                    '25', '4465-089', 'Porto', '26');

    dbms_output.put_line('Expected: Client inserted successfully');
    dbms_output.put_line(CONCAT('Actual: ', output));
END;
/

-- call func_InsertClientData with an already existing email
DECLARE
output varchar(100);
BEGIN
output := func_InsertClientData('user205@gmail.com', 'P', 10000.0, 'B',
                                    'User 205 ', '174539824', '4465-089', 'Maia',
                                    '12', '4465-089', 'Maia', '13');

    dbms_output.put_line('Expected: ORA-20001: A client with this email already exists');
    dbms_output.put_line(CONCAT('Actual: ', output));
END;
/

-- call func_InsertClientData with an already existing NIF
DECLARE
output varchar(100);
BEGIN
output := func_InsertClientData('nn@gmail.com', 'P', 10000.0, 'B',
                                    'User 205 ', '174539823', '4465-089', 'Maia',
                                    '10', '4465-089','Maia', '11');

    dbms_output.put_line('Expected: ORA-20002: A client with this nif already exists');
    dbms_output.put_line(CONCAT('Actual: ', output));
END;
/

-- call func_InsertClientData with another valid user
DECLARE
output varchar(100);
BEGIN
output := func_InsertClientData('user2052@gmail.com', 'P', 10000.0, 'B',
                                    'User 205 ', '174539821', '4475-089','Maia',
                                    '25', '4475-089','Maia', '26');

    dbms_output.put_line('Expected: Client inserted successfully');
    dbms_output.put_line(CONCAT('Actual: ', output));
END;
/


-- *******************************************************************
-- *  Function: func_InsertOrder
-- *  Description: Inserts a new order for a client into the database
-- ********************************************************************


BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Inserting a new order into the database|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/


-- call the procedure to insert a new order
DECLARE
actualNumberOfOrders   NUMBER;
    expectedNumberOfOrders NUMBER;
    actualTotalValue       NUMBER;
    expectedTotalValue     NUMBER;
    codigoClienteI         CLIENTE.CODIGOINTERNO%TYPE;
    codigoPostalI          MORADA.CODIGOPOSTAL%TYPE;
    numeroPortaI           MORADA.NUMEROPORTA%TYPE;
BEGIN

SELECT MAX(codigoInterno) INTO codigoClienteI FROM CLIENTE;
SELECT codigoPostal INTO codigoPostalI FROM MORADA WHERE codigoInternoCliente = codigoClienteI AND TIPOMORADA = 'E';
SELECT numeroPorta INTO numeroPortaI FROM MORADA WHERE codigoInternoCliente = codigoClienteI AND TIPOMORADA = 'E';

-- Get expected values
SELECT COUNT(*) INTO expectedNumberOfOrders FROM ENCOMENDA WHERE CODIGOINTERNOCLIENTE = codigoClienteI;
expectedNumberOfOrders := expectedNumberOfOrders + 1;
SELECT SUM(VALORTOTAL) INTO expectedTotalValue FROM ENCOMENDA WHERE CODIGOINTERNOCLIENTE = codigoClienteI;
expectedTotalValue := expectedTotalValue + 500.0;


-- Insert the order
proc_InsertOrder(codigoClienteI, codigoPostalI,
                     numeroPortaI, TO_DATE('19-04-2022', 'DD-MM-YYYY'),
                     'P', TO_DATE('30-04-2022', 'DD-MM-YYYY'),
                     TO_DATE('30-04-2022', 'DD-MM-YYYY'), 500.00);


    -- Get actual values
SELECT COUNT(*) INTO actualNumberOfOrders FROM ENCOMENDA WHERE CODIGOINTERNOCLIENTE = codigoClienteI;
SELECT SUM(VALORTOTAL) INTO actualTotalValue FROM ENCOMENDA WHERE CODIGOINTERNOCLIENTE = codigoClienteI;

-- Print results
dbms_output.put_line('Inserting an order:');
    dbms_output.put_line(CONCAT('Expected number of orders: ', expectedNumberOfOrders));
    dbms_output.put_line(CONCAT('Actual number of orders: ', actualNumberOfOrders));
    dbms_output.put_line(CONCAT('Expected total value: ', expectedTotalValue));
    dbms_output.put_line(CONCAT('Actual total value: ', actualTotalValue));
END;
/

-- call the procedure to insert a new order that is not in the last year
DECLARE
orderDate ENCOMENDA.DATAENCOMENDA%TYPE;
    codigoClienteI         CLIENTE.CODIGOINTERNO%TYPE;
    codigoPostalI          MORADA.CODIGOPOSTAL%TYPE;
    numeroPortaI           MORADA.NUMEROPORTA%TYPE;
BEGIN
    orderDate := TO_DATE('19-04-2020', 'DD-MM-YYYY');
SELECT MAX(codigoInterno) INTO codigoClienteI FROM CLIENTE;
SELECT codigoPostal INTO codigoPostalI FROM MORADA WHERE codigoInternoCliente = codigoClienteI AND TIPOMORADA = 'E';
SELECT numeroPorta INTO numeroPortaI FROM MORADA WHERE codigoInternoCliente = codigoClienteI AND TIPOMORADA = 'E';

-- Print results
dbms_output.put_line('Inserting an order that is not in the last year:');
    dbms_output.put_line('Expected: ORA-20003: The order date is not in the last year');
    dbms_output.put('Actual: ');
    -- Insert the order
    proc_InsertOrder(codigoClienteI, codigoPostalI,
                     numeroPortaI, orderDate,
                     'P', TO_DATE('30-04-2020', 'DD-MM-YYYY'),
                     TO_DATE('30-04-2020', 'DD-MM-YYYY'), 500.00);

END;
/

-- ******************************************************************************
-- *  View: Clients_view
-- *  Description: View that shows all the clients with some of their attributes
-- *******************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Opening Clients View|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

-- Open the view
SELECT * FROM CLIENTS_VIEW;


-- ******************************************************************************
-- *  Function : func_calculateRiskFactorOfAClient
-- *  Description: Function that calculates the risk factor of a client
-- *******************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Calculate the risk factor of a Client|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

-- call the function that calculates the risk factor for a specific client
DECLARE
riskFactor NUMBER;
codigoClienteI CLIENTE.CODIGOINTERNO%TYPE;
BEGIN

SELECT MAX(codigoInterno) INTO codigoClienteI FROM CLIENTE;

riskFactor := func_calculateRiskFactorOfAClient(codigoClienteI);
    riskFactor := ROUND(riskFactor, 2);
    DBMS_OUTPUT.PUT_LINE('Risk factor of the client: ' || riskFactor);
END;
/

--CLEANUP
DELETE
FROM ENCOMENDA
WHERE NUMEROENCOMENDA = ( SELECT MAX(NUMEROENCOMENDA) FROM ENCOMENDA );

DELETE FROM MORADA
WHERE CODIGOINTERNOCLIENTE IN (SELECT CODIGOINTERNO FROM CLIENTE WHERE NIF = '174539823');
DELETE FROM CLIENTE WHERE NIF = '174539823';

DELETE FROM MORADA
WHERE CODIGOINTERNOCLIENTE IN (SELECT CODIGOINTERNO FROM CLIENTE WHERE NIF = '174539821');
DELETE FROM CLIENTE WHERE NIF = '174539821';
-- END CLEANUP
