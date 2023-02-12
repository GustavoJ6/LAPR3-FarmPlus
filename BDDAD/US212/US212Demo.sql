-- CLEANUP
DELETE FROM INPUT_SENSOR;


DELETE FROM SENSORLEITURAS;



DELETE FROM LOGLEITURASINPUT;
-- END CLEANUP

--BOOTSTRAP
INSERT INTO INPUT_SENSOR VALUES ('00012HS078783897642310:35');
INSERT INTO INPUT_SENSOR VALUES ('00013HS079123456789010:36');
INSERT INTO INPUT_SENSOR VALUES ('00014HS111483897642310:37');
--END BOOTSTRAP

--This demo has the purpose to test the procedures in US212 (all demos have results according to our bootstrap)
BEGIN
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('*                 US212 - Demonstration                    *');
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('*| Reading, testing and transferring data from two tables |*');
end;
/

-- ************************************************************
-- *  Function: func_get_nth_element
-- *  Description: Gets the nth element of input_string from input_sensor
-- ************************************************************

-- call func_get_nth_element for sensor id

BEGIN
    dbms_output.put_line('Expected: 62943');
    dbms_output.put_line('Actual: ' || FUNC_GET_NTH_ELEMENT('62943HS078783897642310:35',1));

END;

/

-- call func_get_nth_element for sensor type

BEGIN
    dbms_output.put_line('Expected: HS');
    dbms_output.put_line('Actual: ' || FUNC_GET_NTH_ELEMENT('62943HS078783897642310:35',2));

END;

/

-- call func_get_nth_element for reading value

BEGIN
    dbms_output.put_line('Expected: 078');
    dbms_output.put_line('Actual: ' || FUNC_GET_NTH_ELEMENT('62943HS078783897642310:35',3));

END;
/

-- call func_get_nth_element for reference value

BEGIN
    dbms_output.put_line('Expected: 7838976423');
    dbms_output.put_line('Actual: ' || FUNC_GET_NTH_ELEMENT('62943HS078783897642310:35',4));

END;
/

-- call func_get_nth_element for time of reading

BEGIN
    dbms_output.put_line('Expected: 10:35');
    dbms_output.put_line('Actual: ' || FUNC_GET_NTH_ELEMENT('62943HS078783897642310:35',5));

END;
/

-- ************************************************************
-- *  Procedure: proc_transfer_sensor_inputs
-- *  Description: Gets all tuples from input_sensor and after doing checks, inserts it or rejects it
-- ************************************************************

-- call proc_transfer_sensor_inputs
BEGIN
    DBMS_OUTPUT.PUT_LINE('EXPECTED:');
    DBMS_OUTPUT.PUT_LINE('------------------------------------');
    DBMS_OUTPUT.PUT_LINE('### SENSOR INPUT TRANSFER REPORT ###');
    DBMS_OUTPUT.PUT_LINE('Number of inputs read ----------> 3');
    DBMS_OUTPUT.PUT_LINE('Number of inputs transferred ---> 2');
    DBMS_OUTPUT.PUT_LINE('Number of inputs with errors ---> 1');
    DBMS_OUTPUT.PUT_LINE('------------------------------------');
    DBMS_OUTPUT.PUT_LINE('ACTUAL:');
    proc_transfer_sensor_inputs();
END;
/

--This shows that the transferred values appear on the sensor table
SELECT * FROM SENSORLEITURAS
WHERE REFERENCIA = 7838976423
   OR REFERENCIA = 1234567890;

--This shows that process execution has been registered on the LogLeiturasInput table
SELECT * FROM LOGLEITURASINPUT;

--This shows that only the inputs with mistakes are left in input_sensor table
SELECT * FROM INPUT_SENSOR;