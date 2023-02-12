-- Procedure to check if the email is valid
CREATE
OR REPLACE PROCEDURE proc_checkEmail(email_param IN CLIENTE.EMAIL%type)
    IS
    emailAlreadyExists CLIENTE.EMAIL%TYPE;
BEGIN
    -- Check if the email already is in the database
SELECT C.EMAIL
INTO emailAlreadyExists
FROM CLIENTE C
WHERE C.EMAIL = email_param;

-- If the email already exists, raise an exception
RAISE_APPLICATION_ERROR
(-20001, 'A client with this email already exists');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        NULL;
END;
/

-- Procedure to check if the nif is valid
CREATE
OR REPLACE PROCEDURE proc_checkNif(nifIn IN CLIENTE.NIF%type)
    IS
    nifAlreadyExists CLIENTE.NIF%TYPE;
BEGIN
    -- Check if the nif already is in the database
SELECT C.NIF
INTO nifAlreadyExists
FROM CLIENTE C
WHERE C.NIF = nifIn;

-- If the nif already exists, raise an exception
RAISE_APPLICATION_ERROR
(-20002, 'A client with this nif already exists');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        NULL;
END;
/

-- Function to insert a new Codigo Postal
CREATE
OR REPLACE FUNCTION func_InsertCodigoPostal(codigoPostal CODIGOPOSTAL.CODIGOPOSTAL%type,
                                              localidade CODIGOPOSTAL.LOCALIDADE%type)
    RETURN NUMBER
IS
BEGIN
INSERT INTO CODIGOPOSTAL (CODIGOPOSTAL, LOCALIDADE)
VALUES (codigoPostal, localidade);
RETURN 1;

EXCEPTION
    WHEN OTHERS THEN
        RETURN 0;
END;
/

-- Function to insert a new address
CREATE
OR REPLACE FUNCTION func_InsertAddress(codigoPostal CODIGOPOSTAL.CODIGOPOSTAL%type,
                                              localidade CODIGOPOSTAL.LOCALIDADE%type,
                                              numeroPorta MORADA.NUMEROPORTA%type,
                                              codigoInternoCliente MORADA.CODIGOINTERNOCLIENTE%type,
                                              tipoMorada MORADA.TIPOMORADA%type)
    RETURN NUMBER
IS
    result number;
BEGIN

    -- Insert the new Codigo Postal
    result := func_InsertCodigoPostal(codigoPostal, localidade);

    INSERT INTO MORADA(CODIGOPOSTAL, NUMEROPORTA, CODIGOINTERNOCLIENTE, TIPOMORADA)
    VALUES (codigoPostal, numeroPorta, codigoInternoCliente, tipoMorada);
    RETURN 1;

EXCEPTION
    WHEN OTHERS THEN
        RETURN 0;
END;
/


-- Procedure to insert a new client
CREATE
OR REPLACE PROCEDURE proc_InsertClient(email CLIENTE.EMAIL%TYPE,
                                              tipo CLIENTE.TIPO%TYPE,
                                              plafond CLIENTE.PLAFOND%TYPE,
                                              nivelNegocio CLIENTE.NIVELNEGOCIO%TYPE,
                                              nome CLIENTE.NOME%TYPE,
                                              nif CLIENTE.NIF%TYPE)
    IS
BEGIN
INSERT INTO CLIENTE(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES (email, tipo, plafond, nivelNegocio, nome, nif);
END;
/


-- Function to add a new client with verifications
CREATE
OR REPLACE FUNCTION func_InsertClientData(email CLIENTE.EMAIL% TYPE,
                                                 tipo CLIENTE.TIPO% TYPE,
                                                 plafond CLIENTE.PLAFOND% TYPE,
                                                 nivelNegocio CLIENTE.NIVELNEGOCIO% TYPE,
                                                 nome CLIENTE.NOME% TYPE,
                                                 nif CLIENTE.NIF% TYPE,
                                                 codigoPostalCorrespondencia CODIGOPOSTAL.CODIGOPOSTAL% TYPE,
                                                 localidadeCorrespondencia CODIGOPOSTAL.LOCALIDADE% TYPE,
                                                 numeroPortaCorrespondencia MORADA.NUMEROPORTA% TYPE,
                                                 codigoPostalEntrega CODIGOPOSTAL.CODIGOPOSTAL% TYPE,
                                                 localidadeEntrega CODIGOPOSTAL.LOCALIDADE% TYPE,
                                                 numeroPortaEntrega MORADA.NUMEROPORTA% TYPE) RETURN VARCHAR
    IS
    -- Variable to store the clientID
    clientID NUMBER;
-- Variable to store the result of the function
    result
NUMBER;
BEGIN

    -- Check if the email is valid
    proc_checkEmail
(email);
    -- Check if the nif is valid
    proc_checkNif
(nif);

    -- Insert the new client
    proc_InsertClient
(email, tipo, plafond, nivelNegocio, nome, nif);

    -- Insert the new client id in the variable
SELECT MAX(CODIGOINTERNO)
INTO clientID
FROM CLIENTE;

-- Insert the correspondence address and store the value returned by the function
result := func_InsertAddress(codigoPostalCorrespondencia, localidadeCorrespondencia, numeroPortaCorrespondencia, clientID, 'C');
    IF
        result = 1 THEN

        -- Insert the delivery address and store the value returned by the function
        result := func_InsertAddress(codigoPostalEntrega, localidadeEntrega, numeroPortaEntrega, clientID, 'E');
        IF
            result = 1 THEN
            RETURN CONCAT('Client inserted successfully - ClientID: ', TO_CHAR(clientID));
         ELSE

            -- If the delivery address was not inserted, delete the client and the correspondence address
            DELETE
            FROM MORADA
            WHERE CODIGOINTERNOCLIENTE = clientID
              AND TIPOMORADA = 'C';
            DELETE
            FROM CLIENTE
            WHERE CODIGOINTERNO = clientID;
            RETURN 'Error inserting the delivery address';
         END IF;

    ELSE
        -- If the correspondence address was not inserted, delete the client
        DELETE
        FROM CLIENTE
        WHERE CODIGOINTERNO = clientID;
        RETURN 'Error inserting the correspondence address';
     END IF;

EXCEPTION
    WHEN OTHERS THEN
        RETURN SQLERRM;

END;
/

-- Procedure to insert a new order of a client
CREATE
OR REPLACE PROCEDURE proc_InsertOrder(
    id_cliente ENCOMENDA.CODIGOINTERNOCLIENTE%TYPE,
    codigoPostalMorada ENCOMENDA.CODIGOPOSTALMORADA%TYPE,
    numeroPortaMorada ENCOMENDA.NUMEROPORTAMORADA%TYPE,
    data_encomenda ENCOMENDA.DATAENCOMENDA%TYPE,
    estado_encomenda ENCOMENDA.ESTADO%TYPE,
    data_entrega ENCOMENDA.DATAENTREGA%TYPE,
    data_pagamento ENCOMENDA.DATAPAGAMENTO%TYPE,
    valor_total ENCOMENDA.VALORTOTAL%TYPE
)
    IS
BEGIN

    -- check if data_encomenda is in the last year
    IF
data_encomenda < (SYSDATE - 365) THEN
        RAISE_APPLICATION_ERROR(-20003, 'The order date is not in the last year');
END IF;

INSERT INTO Encomenda (CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA,
                       DATAPAGAMENTO, VALORTOTAL)
VALUES (id_cliente, codigoPostalMorada,
        numeroPortaMorada, data_encomenda, estado_encomenda,
        data_entrega, data_pagamento, valor_total);

EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line(SQLERRM);
END;
/


-- Function to get the last incident date of a client
CREATE
OR REPLACE FUNCTION func_getLastIncidentDate(client_id CLIENTE.CODIGOINTERNO%TYPE)
    RETURN VARCHAR
    IS
    LAST_INCIDENT_DATE VARCHAR(30);
BEGIN
SELECT TO_CHAR(MAX(DATAOCORRENCIA), 'DD/MM/YYYY')
INTO LAST_INCIDENT_DATE
FROM INCIDENTE
WHERE CODIGOINTERNOCLIENTE = client_id;
IF
LAST_INCIDENT_DATE IS NULL THEN
        LAST_INCIDENT_DATE := 'Sem incidentes à data';
END IF;
RETURN LAST_INCIDENT_DATE;
END;
/

-- Function to get the total payed orders of a client
CREATE
OR REPLACE FUNCTION func_getTotalPayedOrders(client_id CLIENTE.CODIGOINTERNO%TYPE)
    RETURN NUMBER
    IS
    TOTAL_PAYED_ORDERS NUMBER;
BEGIN
SELECT SUM(VALORTOTAL)
INTO TOTAL_PAYED_ORDERS
FROM ENCOMENDA
WHERE CODIGOINTERNOCLIENTE = client_id
  AND ESTADO = 'P';
RETURN TOTAL_PAYED_ORDERS;
END;
/

-- Function to get the delivered orders with pendent payment of a client
CREATE
OR REPLACE FUNCTION func_getDeliveredOrdersPendentPayment(client_id CLIENTE.CODIGOINTERNO%TYPE)
    RETURN NUMBER
    IS
    TOTAL_DELIVERED_ORDERS NUMBER;
BEGIN
SELECT SUM(VALORTOTAL)
INTO TOTAL_DELIVERED_ORDERS
FROM ENCOMENDA
WHERE CODIGOINTERNOCLIENTE = client_id
  AND DATAENTREGA IS NOT NULL
  AND ESTADO != 'P';
RETURN TOTAL_DELIVERED_ORDERS;
END;
/

-- Client view
CREATE
OR REPLACE VIEW CLIENTS_VIEW AS
SELECT C.CODIGOINTERNO                                        AS ClientID,
       C.NIVELNEGOCIO                                         AS Nível,
       func_getLastIncidentDate(C.CODIGOINTERNO)              AS ÚltimoIncidente,
       func_getTotalPayedOrders(C.CODIGOINTERNO)              AS TotalVendas,
       func_getDeliveredOrdersPendentPayment(C.CODIGOINTERNO) AS EntregasComPagamentoPendente
FROM CLIENTE C
;

-- Function that calculates the risk factor of a client
CREATE
OR REPLACE FUNCTION func_calculateRiskFactorOfAClient(clientID CLIENTE.CODIGOINTERNO%TYPE)
    RETURN NUMBER
    IS
    -- Variable that stores the total value of the incidents of the client
    totalValueOfIncidents NUMBER;
    -- Variable that stores the number of orders of the client after the last incident
    numberOfOrders
NUMBER;
    -- Variable that stores the risk factor of the client
    riskFactor
NUMBER;
BEGIN
    -- Get the total value of the incidents of the client
SELECT SUM(VALORDIVIDA)
INTO totalValueOfIncidents
FROM INCIDENTE
WHERE CODIGOINTERNOCLIENTE = clientID;

-- Get the number of orders of the client after the last incident
SELECT COUNT(*)
INTO numberOfOrders
FROM ENCOMENDA
WHERE CODIGOINTERNOCLIENTE = clientID
  AND DATAENCOMENDA > (SELECT MAX(DATAOCORRENCIA) FROM INCIDENTE WHERE ENCOMENDA.CODIGOINTERNOCLIENTE = clientID);

-- Calculate the risk factor of the client
riskFactor
:= totalValueOfIncidents / numberOfOrders;

    IF
riskFactor IS NULL THEN
        riskFactor := 0;
END IF;

    -- Return the risk factor of the client
RETURN riskFactor;

EXCEPTION
    WHEN OTHERS
        THEN
            RETURN 0;
END;
/



