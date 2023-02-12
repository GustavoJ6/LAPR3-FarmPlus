/Inserir Operações Agrícolas, de forma inválida/

/* Id da exploração inválido */
DECLARE
output VARCHAR(100);

BEGIN
output := func_inserirOperacaoAgricola('C', 250, TO_DATE('08-07-2023','DD-MM-YYYY'), 'Aplicação Fator de Produção');

    dbms_output.put_line('Esperado - Erro: Combinação Inválida da Designação do Setor e do ID da Exploração Agrícola.');
    dbms_output.put_line(CONCAT('Real     - ', output));
END;
/

/* Data Agendada Inválida */
DECLARE
output VARCHAR(100);

BEGIN
output := func_inserirOperacaoAgricola('C', 200, TO_DATE('08-07-2021','DD-MM-YYYY'), 'Aplicação Fator de Produção');

    dbms_output.put_line('Esperado - Erro: Data Agendada Inválida (Data Agendada deve ser maior do que a data no momento da criação).');
    dbms_output.put_line(CONCAT('Real     - ', output));
END;
/

/* Inserir Operação Agrícola, de forma válida */
DECLARE
output VARCHAR(100);
    before INTEGER;
    after INTEGER;

BEGIN
SELECT COUNT(*) INTO before FROM OperacaoAgricola;

output := func_inserirOperacaoAgricola('C', 200, TO_DATE('08-07-2023','DD-MM-YYYY'), 'Aplicação Fator de Produção');

    dbms_output.put_line('Esperado - Inserção da Operação Agrícola com Sucesso.');
    dbms_output.put_line(CONCAT('Real     - ', output));

SELECT COUNT(*) INTO after FROM OperacaoAgricola;

dbms_output.put_line('Número de Operações Esperado: 1');
    dbms_output.put_line(CONCAT('Número de Operações Real    : ', after - before));
END;
/

/* Inserir Fatores Aplicados, de forma inválida */

/* Fator de Produção restringido */
DECLARE
output VARCHAR(100);

BEGIN
output := func_inserirFatorAplicado(1, 'Ametoctradina', 123.45, 'Fertirrega');

    dbms_output.put_line('Esperado - Fator producao Ametoctradina está presente na restrição com id 1.');
    dbms_output.put_line(CONCAT('Real     - ', output));
END;
/

/* Fator Aplicado já se encontra associado à Operação Agrícola */
INSERT INTO FatoresAplicados VALUES(18, 'Ametoctradina', 123.45, 'Fertirrega');
DECLARE
output VARCHAR(100);

BEGIN
output := func_inserirFatorAplicado(18, 'Ametoctradina', 123.45, 'Fertirrega');

    dbms_output.put_line('Esperado - Já existe um fator produção com esse nome na operação.');
    dbms_output.put_line(CONCAT('Real     - ', output));
END;
DELETE FROM FatoresAplicados WHERE idOperacaoAgricola = 18 AND nomeComercialFatorProducao = 'Ametoctradina';
/

/* Operação já foi cancelada ou realizada */
DECLARE
output VARCHAR(100);

BEGIN
output := func_inserirFatorAplicado(17, 'Ametoctradina', 123.45, 'Fertirrega');

    dbms_output.put_line('Esperado - Operação já foi realizada ou cancelada.');
    dbms_output.put_line(CONCAT('Real     - ', output));
END;
/

/* Inserir Fator Aplicado, de forma válida */
DECLARE
output VARCHAR(100);
    before INTEGER;
    after INTEGER;

BEGIN
SELECT COUNT(*) INTO before FROM FatoresAplicados;

output := func_inserirFatorAplicado(18, 'Ametoctradina', 123.45, 'Fertirrega');

    dbms_output.put_line('Esperado - Fator de producao adicionado com sucesso.');
    dbms_output.put_line(CONCAT('Real     - ', output));

SELECT COUNT(*) INTO after FROM FatoresAplicados;

dbms_output.put_line('Número de Fatores Aplicados Esperado: 1');
    dbms_output.put_line(CONCAT('Número de Fatores Aplicados Real    : ', after - before));
END;
DELETE FROM FatoresAplicados WHERE idOperacaoAgricola = 18 AND nomeComercialFatorProducao = 'Ametoctradina';
/

/* Listar Operações Restringidas no Momento */
BEGIN
    dbms_output.put_line('Esperado:');
    dbms_output.put_line('OperacaoAgricola ID: 6, DesignacaoSetor: Q, EstadoOperacao: A, NomeComercialFator: Ametoctradina');

    dbms_output.put_line('Real:');
    proc_listarOperacoesRestringidas();
END;
/

/* Listar Restrições Ativas para determinado Setor no Momento */
BEGIN
    dbms_output.put_line('Esperado:');
    dbms_output.put_line('Lista de Restrições Ativas
-----------------------------------------
ID     --> 1
Nome   --> Ametoctradina
Data I --> 20.10.09
Data F --> 23.04.09
-----------------------------------------
-----------------------------------------
ID     --> 2
Nome   --> Bentazona
Data I --> 14.10.13
Data F --> 23.04.07
-----------------------------------------');
    dbms_output.put_line('');
    dbms_output.put_line('Real:');
    proc_listarRestricoesAtivas('A', 100, TO_DATE('06-10-2022','DD-MM-YYYY'));
END;
/

/* Listar Operações Planeadas para determinado Setor */
BEGIN
    dbms_output.put_line('Esperado:');
    dbms_output.put_line('Lista de Operações Planeadas por Setor: 
-----------------------------------------
Designacao Setor --> H
Data Agendada    --> 99.10.13
Tipo             --> Irrigação e adubação
-----------------------------------------
-----------------------------------------
Designacao Setor --> H
Data Agendada    --> 08.03.26
Tipo             --> Irrigação e adubação
-----------------------------------------');

    dbms_output.put_line('');
    dbms_output.put_line('Real:');
    proc_listarOperacoesPlaneadas(300);
END;
/