-- CLEANUP
DELETE
FROM Encomenda e
WHERE CodigoInternoCliente = 1
  AND e.dataEncomenda = TO_DATE('15-02-2022', 'DD-MM-YYYY');

DELETE
FROM Encomenda e
WHERE CodigoInternoCliente = 1
  AND e.dataEncomenda = TO_DATE('15-02-2022', 'DD-MM-YYYY');


-- END CLEANUP



--This demo has the purpose to test the procedures in US209 (all demos have results according to our bootstrap)
BEGIN
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('*                 US209 - Demonstration                    *');
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('*******|Registering, Listing and Altering package data|*****');
end;
/


-- ************************************************************
-- *  Procedure: proc_register_package
-- *  Description: Inserts a new package into the database
-- ************************************************************

-- call proc_register_package with a package total value over client's plafond

BEGIN
    dbms_output.put_line('Expected: ### Client plafond does not allow registration of package ###');
    dbms_output.put_line('Actual: ');
    proc_register_package(1,TO_DATE('15-02-2022', 'DD-MM-YYYY'), 1500);
END;
/

-- call proc_register_package with correct values

BEGIN
    dbms_output.put_line('Expected: Package registered for user: 1');
    dbms_output.put_line('Actual: ');
    proc_register_package(1,TO_DATE('15-02-2022', 'DD-MM-YYYY'), 1000);     --Success
END;
/

SELECT * FROM Encomenda e
WHERE CodigoInternoCliente = 1; --if successful, your package should appear here

-- ************************************************************
-- *  Procedure: proc_update_delivery_date
-- *  Description: Updates the delivery date of a package
-- ************************************************************

-- call proc_update_delivery_date with an invalid delivery date
DECLARE
package_number INTEGER;

BEGIN
SELECT numeroEncomenda INTO package_number
FROM Encomenda
WHERE CodigoInternoCliente = 1
  AND DataEncomenda = TO_DATE('15-02-2022', 'DD-MM-YYYY');
dbms_output.put_line('Expected: ### Invalid delivery date ###');
    dbms_output.put_line('Actual: ');
    proc_update_delivery_date(TO_DATE('15-07-2122', 'DD-MM-YYYY'), package_number);     --Invalid Date
END;
/

-- call proc_update_delivery_date with a valid delivery date

DECLARE
package_number INTEGER;

BEGIN
SELECT numeroEncomenda INTO package_number
FROM Encomenda
WHERE CodigoInternoCliente = 1
  AND DataEncomenda = TO_DATE('15-02-2022', 'DD-MM-YYYY');
dbms_output.put_line('Expected: ### Delivery Date has been updated ###');
    dbms_output.put_line('Actual: ');
    proc_update_delivery_date(TO_DATE('15-07-2022', 'DD-MM-YYYY'), package_number);     --Success
END;
/

-----------------------------------------------------------------------------

SELECT * FROM Encomenda e
WHERE e.numeroEncomenda = (SELECT numeroEncomenda
                           FROM Encomenda
                           WHERE CodigoInternoCliente = 1
                             AND DataEncomenda = TO_DATE('15-02-2022', 'DD-MM-YYYY')); --if successful, your delivery date update should appear here

-- ************************************************************
-- *  Procedure: proc_update_payment_date
-- *  Description: Updates the payment date of a package
-- ************************************************************

-- call proc_update_payment_date with an invalid payment date

DECLARE
package_number INTEGER;

BEGIN
SELECT numeroEncomenda INTO package_number
FROM Encomenda
WHERE CodigoInternoCliente = 1
  AND DataEncomenda = TO_DATE('15-02-2022', 'DD-MM-YYYY');
dbms_output.put_line('Expected: ### Invalid payment date ###');
    dbms_output.put_line('Actual: ');
    proc_update_payment_date(TO_DATE('15-08-2122', 'DD-MM-YYYY'), package_number);     --Invalid Date
END;
/
-- call proc_update_payment_date with an valid payment date


DECLARE
package_number INTEGER;

BEGIN
SELECT numeroEncomenda INTO package_number
FROM Encomenda
WHERE CodigoInternoCliente = 1
  AND DataEncomenda = TO_DATE('15-02-2022', 'DD-MM-YYYY');
dbms_output.put_line('Expected: ### Payment Date has been updated ###');
    dbms_output.put_line('Actual: ');
    proc_update_payment_date(TO_DATE('15-08-2022', 'DD-MM-YYYY'), package_number);     --Success
END;
/

-----------------------------------------------------------------------------


SELECT * FROM Encomenda e
WHERE e.numeroEncomenda = (SELECT numeroEncomenda
                           FROM Encomenda
                           WHERE CodigoInternoCliente = 1
                             AND DataEncomenda = TO_DATE('15-02-2022', 'DD-MM-YYYY')); --if successful, your payment date update should appear here


-- ************************************************************
-- *  Procedure: proc_list_package_by_state
-- *  Description: Shows the packages info of a given state
-- ************************************************************

-- call proc_list_package_by_state for registered packages

BEGIN

    proc_list_package_by_state('R');     --For registered packages
END;
/

SELECT count(*) AS registered_packages
FROM Encomenda e
WHERE e.estado = 'R';

-- call proc_list_package_by_state for delivered packages

BEGIN
    proc_list_package_by_state('E');     --For delivered packages
END;
/

SELECT count(*)  AS delivered_packages
FROM Encomenda e
WHERE e.estado = 'E';

-- call proc_list_package_by_state for paid packages

BEGIN
    proc_list_package_by_state('P');     --For paid packages
END;
/

SELECT count(*) AS paid_packages
FROM Encomenda e
WHERE e.estado = 'P';


--The desired output will be built by the procedure itself

