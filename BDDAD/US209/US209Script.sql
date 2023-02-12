-- The following code has the instructions to be run in order to satisfy the requisits of US209

/*1. Um utilizador pode registar pedidos de um determinado cliente (encomendas), solicitando que
a entrega seja efetuada em determinado endereço que será a morada de entrega do cliente, por
defeito, podendo, no entanto, ser indicada uma morada específica para cada encomenda, em
determinada data. Verificar plafond do cliente.*/

CREATE OR REPLACE PROCEDURE proc_register_package (
  cod_client IN Encomenda.codigoInternoCliente%type,
  data_Encomenda IN Encomenda.dataEncomenda%type,
  price IN Encomenda.valorTotal%type) IS

  p_codigo_postal_def Encomenda.codigoPostalMorada%type;
  p_nr_porta_def Encomenda.numeroPortaMorada%type;
  p_plafond_cliente Cliente.plafond%type;
BEGIN
SELECT plafond INTO p_plafond_cliente
  FROM Cliente c
  WHERE c.codigoInterno = cod_client;

  IF price <= p_plafond_cliente THEN

    SELECT codigoPostal INTO p_codigo_postal_def
    FROM Morada
    WHERE codigoInternoCliente = cod_client AND tipoMorada = 'E';

    SELECT numeroPorta INTO p_nr_porta_def
    FROM Morada
    WHERE codigoInternoCliente = cod_client AND tipoMorada = 'E';

    INSERT INTO Encomenda (codigoInternoCliente, codigoPostalMorada, numeroPortaMorada, dataEncomenda, estado)
    VALUES (cod_client, p_codigo_postal_def, p_nr_porta_def, data_Encomenda, 'R');
    dbms_output.put_line('Package registered for user: ' || cod_client); 
  ELSE
    dbms_output.put_line('### Client plafond does not allow registration of package ###'); 
  END IF;
END;
/




/*2. Um utilizador pode registar a entrega de uma encomenda numa determinada data. Presume-se
que a encomenda seja entregue na totalidade; não há suporte para entregas parciais.*/

CREATE OR REPLACE PROCEDURE proc_update_delivery_date ( 
    date_delivered IN Encomenda.dataEntrega%type, 
    package_number IN Encomenda.numeroEncomenda%type) IS 

    p_date_registry Encomenda.dataEncomenda%type;
BEGIN 
  SELECT dataEncomenda INTO p_date_registry
  FROM Encomenda
  WHERE numeroEncomenda = package_number;
    IF date_delivered <= SYSDATE AND date_delivered >= p_date_registry THEN 
        UPDATE Encomenda 
        SET dataEntrega = date_delivered
        WHERE numeroEncomenda = package_number; 
    dbms_output.put_line('### Delivery Date has been updated ###'); 
  ELSE 
    dbms_output.put_line('### Invalid delivery date ###'); 
  END IF; 
END; 
/


/*3. Um utilizador pode registar o pagamento de uma encomenda numa determinada data.*/

CREATE OR REPLACE PROCEDURE proc_update_payment_date ( 
    date_paid IN Encomenda.dataPagamento%type, 
    package_number IN Encomenda.numeroEncomenda%type) IS 

    p_date_registry Encomenda.dataEncomenda%type;
BEGIN 
  SELECT dataEncomenda INTO p_date_registry
  FROM Encomenda
  WHERE numeroEncomenda = package_number;

    IF date_paid <= SYSDATE AND  date_paid >= p_date_registry THEN 
        UPDATE Encomenda 
        SET dataPagamento = date_paid 
        WHERE numeroEncomenda = package_number; 
    dbms_output.put_line('### Payment Date has been updated ###'); 
  ELSE 
    dbms_output.put_line('### Invalid payment date ###'); 
  END IF; 
END; 
/


/*4. Posso listar encomendas por estado (registada, entregue, paga) – data de registo da encomenda,
cliente, número da encomenda, valor total e estado.*/

--listagem por estado
CREATE OR REPLACE PROCEDURE proc_list_package_by_state (
    state IN Encomenda.estado%type) IS

p_date_registry Encomenda.dataEncomenda%type;
p_package_number Encomenda.numeroEncomenda%type;
p_cod_client Encomenda.codigoInternoCliente%type;
p_valor_total Encomenda.valorTotal%type;

  CURSOR n_encomendas IS 
  SELECT numeroEncomenda
  FROM Encomenda
  WHERE estado = state;

BEGIN
dbms_output.put_line('LISTAGEM DE ENCOMENDAS POR ESTADO: ' || state);
OPEN n_encomendas;
  LOOP
    FETCH n_encomendas INTO p_package_number;
    EXIT WHEN n_encomendas%notfound;
    SELECT dataEncomenda INTO p_date_registry
    FROM Encomenda
    WHERE Encomenda.numeroEncomenda = p_package_number;
    SELECT codigoInternoCliente INTO p_cod_client
    FROM Encomenda
    WHERE Encomenda.numeroEncomenda = p_package_number;
    SELECT valorTotal INTO p_valor_total
    FROM Encomenda
    WHERE Encomenda.numeroEncomenda = p_package_number;
        dbms_output.put_line('-----------------------------------------');
        dbms_output.put_line('Data de registo da Encomenda -->' || p_date_registry);
        dbms_output.put_line('Número de Cliente ------------->' || p_cod_client);
        dbms_output.put_line('Número da Encomenda ----------->' || p_package_number);
        dbms_output.put_line('Valor Total da Encomenda ------>' || p_valor_total);
        dbms_output.put_line('-----------------------------------------');
  END LOOP;
  CLOSE n_encomendas;
END;
/

