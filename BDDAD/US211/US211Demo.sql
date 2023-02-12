BEGIN
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE('*                 US211 - Demonstration                    *');
    DBMS_OUTPUT.PUT_LINE('************************************************************');
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualizar ou Cancelar uma Operação que ainda não foi Realizada|********');
END;
/


-- ***********************************************************************************
-- *  Function : func_CancelOperation
-- *  Descrição: Função que permite cancelar uma operação que ainda não foi realizada.
-- *  Execução Válida.
-- ***********************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Cancela uma operação não realizada|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

DECLARE
    stateOfOperationExpected CHAR(1);
    stateOfOperationActual CHAR(1);
BEGIN
    stateOfOperationExpected := 'C';
    dbms_output.put_line(func_cancelOperation(2));
    SELECT estadoOperacao INTO stateOfOperationActual FROM OperacaoAgricola WHERE idOperacaoAgricola = 2;
    dbms_output.put_line('Estado da Operação Esperado: ' || stateOfOperationExpected);
    dbms_output.put_line('Estado da Operacao Obtido: ' || stateOfOperationActual);
END;
/

/* VOLTAR A COLOCAR O ESTADO COM O SEU VALOR INICIAL */
UPDATE OperacaoAgricola SET estadoOperacao = 'A' WHERE idOperacaoAgricola = 2;


-- **************************************************************************************
-- *  Function : func_UpdateOperationDate
-- *  Descrição: Função que atualiza a data agendada de uma operação agrícola não realizada.Function that updates the scheduled date of a non-performed operation.
-- *  Execução Válida.
-- **************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza a data agendada de uma operação não realizada|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

DECLARE
    stateOfOperationExpected CHAR(1);
    stateOfOperationActual CHAR(1);
    dataExpected DATE;
    dataActual DATE;
BEGIN
    stateOfOperationExpected := 'A';
    dataExpected := TO_DATE('2020-12-12', 'YYYY-MM-DD');
    dbms_output.put_line(func_UpdateOperationDate(1, TO_DATE('2020-12-12', 'YYYY-MM-DD')));
    SELECT estadoOperacao INTO stateOfOperationActual FROM OperacaoAgricola WHERE idOperacaoAgricola = 1;
    SELECT dataAgendada INTO dataActual FROM OperacaoAgricola WHERE idOperacaoAgricola = 1;

    dbms_output.put_line('Estado da Operação Esperado: ' || stateOfOperationExpected || ' | Estado da Operação Atual: ' || stateOfOperationActual);
    dbms_output.put_line('Data Agendada Esperada: ' || dataExpected || ' | Data Agendada Atual: ' || dataActual);
END;
/

-- *****************************************************************************************
-- *  Function : func_UpdateOperationDate
-- *  Descrição: Função que atualiza a data agendada de uma operação agrícola não realizada.
-- *  Execução Inválida.
-- *****************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza a data agendada de uma operação não realizada (Inválido)|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    dbms_output.put_line('Mensagem Esperada: Não é Possível Atualizar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.');
    dbms_output.put_line('Mensagem Obtida: ' || func_UpdateOperationDate(3, TO_DATE('2020-12-12', 'YYYY-MM-DD')));
END;
/

-- *********************************************************************************
-- *  Function : func_UpdateOperationType
-- *  Descrição: Função que atualiza o tipo de uma operação agrícola não realizada.
-- *  Execução Válida.
-- *********************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza o tipo de uma operação não realizada|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

DECLARE
    stateOfOperationExpected CHAR(1);
    stateOfOperationActual CHAR(1);
    tipoExpected VARCHAR(40);
    tipoActual VARCHAR(40);
BEGIN
    stateOfOperationExpected := 'A';
    tipoExpected := 'Aplicação Fator de Produção';
    dbms_output.put_line(func_UpdateOperationType(1,  'Aplicação Fator de Produção'));
    SELECT estadoOperacao INTO stateOfOperationActual FROM OperacaoAgricola WHERE idOperacaoAgricola = 1;
    SELECT tipo INTO tipoActual FROM OperacaoAgricola WHERE idOperacaoAgricola = 1;
    dbms_output.put_line('Estado da Operação Esperado: ' || stateOfOperationExpected || ' | Estado da Operação Atual: ' || stateOfOperationActual);
    dbms_output.put_line('Tipo de Operação Esperado: ' || tipoExpected || ' | Tipo de Operação Atual: ' || tipoActual);
END;
/

-- ***********************************************************************
-- *  Function : func_UpdateOperationType
-- *  Descrição: Função que atualiza o tipo de uma operação não realizada.
-- *  Execução Inválida.
-- ***********************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza o tipo de uma operação não realizada (Inválido)|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    dbms_output.put_line('Mensagem Esperada: Não é Possível Atualizar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.');
    dbms_output.put_line('Mensagem Obtida: ' || func_UpdateOperationType(3,  'Aplicação Fator de Produção'));
END;
/

-- *************************************************************************************
-- *  Function : func_UpdateOperationAppliedQuantity
-- *  Descrição: Função que atualiza a quantidade aplicada a uma operação não realizada.
-- *  Execução Válida.
-- *************************************************************************************


BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza a quantidade aplicada a uma operação não realizada|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

DECLARE
    stateOfOperationExpected CHAR(1);
    stateOfOperationActual CHAR(1);
    quantityExpected NUMBER(5,2);
    quantityActual NUMBER(5,2);
BEGIN
    stateOfOperationExpected := 'A';
    quantityExpected := 150.0;
    dbms_output.put_line(func_updateOperationAppliedQuantity(1, 'Imazamox' ,150.0));
    SELECT estadoOperacao INTO stateOfOperationActual FROM OperacaoAgricola WHERE idOperacaoAgricola = 1;
    SELECT quantidadeAplicada INTO quantityActual FROM FatoresAplicados WHERE idOperacaoAgricola = 1 AND nomeComercialFatorProducao = 'Imazamox';
    dbms_output.put_line('Estado da Operação Esperado: ' || stateOfOperationExpected || ' | Estado da Operação Atual: ' || stateOfOperationActual);
    dbms_output.put_line('Quantidade Aplicada Esperada: ' || quantityExpected || ' | Quantidade Aplicada Atual: ' || quantityActual);
END;
/

-- *************************************************************************************
-- *  Function : func_UpdateOperationAppliedQuantity
-- *  Descrição: Função que atualiza a quantidade aplicada a uma operação não realizada.
-- *  Execução Inválida.
-- *************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza a quantidade aplicada a uma operação não realizada (Inválido)|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    dbms_output.put_line('Mensagem Esperada: Não é Possível Atualizar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.');
    dbms_output.put_line('Mensagem Obtida: ' || func_updateOperationAppliedQuantity(3, 'Boscalide' ,150.0));
END;
/

-- ******************************************************************************************************************
-- *  Function : func_UpdateOperationApplicationForm
-- *  Descrição: Função que atualiza a forma de aplicação de um fator aplicado a uma operação agrícola não realizada.
-- *  Execução Válida.
-- ******************************************************************************************************************


BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza a forma de aplicação de um fator aplicado a uma operação agrícola não realizada|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

DECLARE
    stateOfOperationExpected CHAR(1);
    stateOfOperationActual CHAR(1);
    formOfApplicationExpected VARCHAR(10);
    formOfApplicationActual VARCHAR(10);
BEGIN
    stateOfOperationExpected := 'A';
    formOfApplicationExpected := 'Solo';
    dbms_output.put_line(func_UpdateOperationApplicationForm(1, 'Imazamox' , 'Solo'));
    SELECT estadoOperacao INTO stateOfOperationActual FROM OperacaoAgricola WHERE idOperacaoAgricola = 1;
    SELECT formaAplicacao INTO formOfApplicationActual FROM FatoresAplicados WHERE idOperacaoAgricola = 1 AND nomeComercialFatorProducao = 'Imazamox';
    dbms_output.put_line('Estado da Operação Esperado: ' || stateOfOperationExpected || ' | Estado da Operação Atual: ' || stateOfOperationActual);
    dbms_output.put_line('Forma de Aplicação Esperada: ' || formOfApplicationExpected || ' | Forma de Aplicação Atual: ' || formOfApplicationActual);
END;
/

-- ****************************************************************************************
-- *  Function : func_UpdateOperationApplicationForm
-- *  Descrição: Função que atualiza a forma de aplicação de um fator aplicado a uma operação agrícola não realizada.
-- *  Execução Inválida.
-- ****************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Atualiza a forma de aplicação de um fator aplicado a uma operação agrícola não realizada (Inválido)|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    dbms_output.put_line('Mensagem Esperada: Não é Possível Atualizar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.');
    dbms_output.put_line('Mensagem Obtida: ' || func_UpdateOperationApplicationForm(3, 'Boscalide' ,'Solo'));
END;
/


-- *********************************************************************************************************
-- *  Function : func_createFatorAplicado
-- *  Descrição: Função que adiciona um fator aplicado sem restrições a uma operação agrícola não realizada.
-- *  Execução Válida.
-- *********************************************************************************************************
BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Adiciona um fator aplicado sem restrições a uma operação agrícola não realizada|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

DECLARE
    numberOfAppliedFactorsExpected NUMBER;
    numberOfAppliedFactorsActual NUMBER;
BEGIN
    SELECT COUNT(*) INTO numberOfAppliedFactorsExpected FROM FatoresAplicados WHERE idOperacaoAgricola = 18;
    numberOfAppliedFactorsExpected := numberOfAppliedFactorsExpected + 1;
    dbms_output.put_line(func_createFatorAplicado(18, 'Ametoctradina', 123.45, 'Fertirrega'));
    SELECT COUNT(*) INTO numberOfAppliedFactorsActual FROM FatoresAplicados WHERE idOperacaoAgricola = 18;
    dbms_output.put_line('Número de Fatores Aplicados Esperado: ' || numberOfAppliedFactorsExpected || ' | Número de Fatores Aplicados Atual: ' || numberOfAppliedFactorsActual);
END;
/

-- *********************************************************************************************************
-- *  Function : func_createFatorAplicado
-- *  Descrição: Função que adiciona um fator aplicado sem restrições a uma operação agrícola não realizada.
-- *  Execução Inválida.
-- *********************************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Adiciona um fator aplicado sem restrições a uma operação agrícola não realizada (Inválido)|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    dbms_output.put_line('Mensagem Esperada: Já existe um Fator de Produção com esse Nome Comercial para a mesma Operação Agrícola.');
    dbms_output.put_line('Mensagem Obtida: ' || func_createFatorAplicado(18, 'Ametoctradina', 123.45, 'Fertirrega'));
END;
/

-- *********************************************************************************************************
-- *  Function : func_createFatorAplicado
-- *  Descrição: Função que adiciona um fator aplicado sem restrições a uma operação agrícola não realizada.
-- *  Execução Inválida.
-- *********************************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Adiciona um fator aplicado sem restrições a uma operação agrícola não realizada (Inválido)|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    dbms_output.put_line('Mensagem Esperada: Operação foi Cancelada ou já estava Realizada.');
    dbms_output.put_line('Mensagem Obtida: ' || func_createFatorAplicado(4, 'Inválido', 81.0, 'Solo'));
END;
/




-- ****************************************************************************************
-- *  Function : func_removeFatorAplicado
-- *  Descrição: Função que remove um fator aplicado a uma operação agrícola não realizada.
-- *  Execução Válida.
-- ****************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Remover um fator aplicado sem restrições a uma operação não realizada|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

DECLARE
    numberOfAppliedFactorsExpected NUMBER;
    numberOfAppliedFactorsActual NUMBER;
BEGIN
    SELECT COUNT(*) INTO numberOfAppliedFactorsExpected FROM FatoresAplicados WHERE idOperacaoAgricola = 18;
    numberOfAppliedFactorsExpected := numberOfAppliedFactorsExpected - 1;
    dbms_output.put_line(func_removeFatorAplicado(18, 'Ametoctradina'));
    SELECT COUNT(*) INTO numberOfAppliedFactorsActual FROM FatoresAplicados WHERE idOperacaoAgricola = 18;
    dbms_output.put_line('Número de Fatores Aplicados Esperado: ' || numberOfAppliedFactorsExpected || ' | Número de Fatores Aplicados Obtido: ' || numberOfAppliedFactorsActual);
END;
/

-- ****************************************************************************************
-- *  Function : func_removeFatorAplicado
-- *  Descrição: Função que remove um fator aplicado a uma operação agrícola não realizada.
-- *  Execução Inválida.
-- ****************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Remover um fator aplicado sem restrições a uma operação não realizada (Inválido)|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    dbms_output.put_line('Mensagem Esperada: Não Existe um Fator Aplicado com esse Nome Comercial para a Operação Agrícola Especificada.');
    dbms_output.put_line('Mensagem Obtida: '||func_removeFatorAplicado(18, 'Nome Não Existente.'));
END;
/

-- ****************************************************************************************
-- *  Function : func_removeFatorAplicado
-- *  Descrição: Função que remove um fator aplicado a uma operação agrícola não realizada.
-- *  Execução Inválida.
-- ****************************************************************************************

BEGIN
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('**********|Remover um fator aplicado sem restrições a uma operação não realizada (Inválido)|********');
    DBMS_OUTPUT.PUT_LINE(' ');
END;
/

BEGIN
    dbms_output.put_line('Mensagem Esperada: Operação já foi Cancelada ou Realizada.');
    dbms_output.put_line('Mensagem Obtida: ' || func_removeFatorAplicado(4, 'Imazamox'));
END;
/
