-- The following code has the instructions to be run in order to satisfy the requisits of US212

/* 1. Function that returns the nth tuple of table input_sensor */

CREATE OR REPLACE FUNCTION func_get_nth_element (input IN input_sensor.input_string%type, n IN NUMBER)
    RETURN VARCHAR
    IS
    f_return VARCHAR(25);
BEGIN
    f_return:= null;
    CASE n
    WHEN 1 THEN f_return:= SUBSTR(input,0,5);
    WHEN 2 THEN f_return:= SUBSTR(input,6,2);
    WHEN 3 THEN f_return:= SUBSTR(input,8,3);
    WHEN 4 THEN f_return:= SUBSTR(input,11,10);
    WHEN 5 THEN f_return:= SUBSTR(input,21,5);
    ELSE return null;
    END CASE;

    return f_return;
END;
/

/*2 - Procedure that makes the transfer between table input_sensor and
  table Sensor with all verifications and constraints mentioned in the
  assignment*/

CREATE OR REPLACE PROCEDURE proc_transfer_sensor_inputs
IS
p_input INPUT_SENSOR.INPUT_STRING%type;
p_sensor_id SENSORLEITURAS.IDENTIFICADORSENSOR%type;
p_sensor_type SENSORLEITURAS.TIPOTIPOSENSOR%type;
p_read_value SENSORLEITURAS.VALORLIDO%type;
p_reference_value SENSORLEITURAS.REFERENCIA%type;
p_time_of_reading SENSORLEITURAS.INSTANTELEITURA%type;

p_total_read NUMBER;
p_total_transfered NUMBER;
p_total_error NUMBER;

p_unique_checker NUMBER;
p_unique_checker2 NUMBER;

    CURSOR input_list IS
    SELECT INPUT_STRING
    FROM INPUT_SENSOR;

BEGIN
    SELECT COUNT(*) INTO p_total_read
    FROM INPUT_SENSOR;

    p_total_error:=0;
    p_total_transfered:=0;

    OPEN input_list;
    LOOP
        FETCH input_list INTO p_input;
        EXIT WHEN input_list%notfound;
        p_sensor_id:= to_number(func_get_nth_element(p_input,1));
        p_sensor_type:= func_get_nth_element(p_input,2);
        p_read_value:= to_number(func_get_nth_element(p_input,3));
        p_reference_value:= to_number(func_get_nth_element(p_input,4));
        p_time_of_reading:= func_get_nth_element(p_input,5);

        SELECT COUNT(*) INTO p_unique_checker
        FROM SENSORLEITURAS sl
        WHERE sl.referencia = p_reference_value;

        SELECT COUNT(*) INTO p_unique_checker2
        FROM SENSOR s
        WHERE s.identificador = p_sensor_id;

        IF p_sensor_type NOT IN ('HS', 'Pl', 'TS', 'VV', 'TA', 'HA', 'PA') OR p_unique_checker != 0 OR p_unique_checker2 = 0 OR p_read_value > 100 THEN
            p_total_error:= p_total_error + 1;
        ELSE
            INSERT INTO SensorLeituras (identificadorSensor, tipoTipoSensor, valorLido, referencia, instanteLeitura) VALUES (p_sensor_id, p_sensor_type, p_read_value, p_reference_value, p_time_of_reading);
            p_total_transfered:= p_total_transfered + 1;

            DELETE FROM INPUT_SENSOR
            WHERE INPUT_STRING = p_input;

        END IF;
    END LOOP;
    INSERT INTO LOGLEITURASINPUT (dataleitura, registoslidos, registosinseridos, registoscomerro) VALUES (SYSDATE, p_total_read, p_total_transfered, p_total_error);
    DBMS_OUTPUT.PUT_LINE('------------------------------------');
    DBMS_OUTPUT.PUT_LINE('### SENSOR INPUT TRANSFER REPORT ###');
    DBMS_OUTPUT.PUT_LINE('Number of inputs read ----------> ' || p_total_read);
    DBMS_OUTPUT.PUT_LINE('Number of inputs transferred ---> ' || p_total_transfered);
    DBMS_OUTPUT.PUT_LINE('Number of inputs with errors ---> ' || p_total_error);
    DBMS_OUTPUT.PUT_LINE('------------------------------------');
END;
/
-- this procedure's output can be ignored in an aplicational situation, the database persists all the output information on a table made for it LogLeiturasInput



