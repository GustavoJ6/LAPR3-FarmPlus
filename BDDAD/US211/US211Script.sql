/* FUNÇÃO QUE PERMITE CANCELAR UMA OPERAÇÃO QUE AINDA NÃO TENHA SIDO REALIZADA */
CREATE OR REPLACE FUNCTION func_CancelOperation(
    idOperacaoAgricola_param IN OPERACAOAGRICOLA.idOperacaoAgricola%TYPE
) RETURN VARCHAR IS
    state CHAR(1);
BEGIN
    /* GUARDAR NA VARIÁVEL O ESTADO DA OPERAÇÃO */
SELECT estadoOperacao INTO state FROM OPERACAOAGRICOLA WHERE idOperacaoAgricola = idOperacaoAgricola_param;
/* SE O ESTADO FOR DIFERENTE 'R' (REALIZADO) E NÃO TIVER SIDO JÁ CANCELADA, ENTÃO O ESTADO PASSA PARA CANCELADO. 'C'.  */
IF state != 'R' AND state != 'C' THEN
UPDATE OPERACAOAGRICOLA SET estadoOperacao = 'C' WHERE idOperacaoAgricola = idOperacaoAgricola_param;
RETURN 'Operação Cancelada.';
/* NO CASO DE A OPERAÇÃO JÁ TER SIDO REALIZADA OU CANCELADA, APARECE A SEGUINTE MENSAGEM. */
ELSE
        RETURN 'Não é Possível Cancelar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.';
END IF;
END;
/

/* FUNÇÃO QUE PERMITE ATUALIZAR A DATA AGENDADA DE UMA OPERAÇÃO QUE AINDA NÃO TENHA SIDO REALIZADA */
CREATE OR REPLACE FUNCTION func_UpdateOperationDate(
    idOperacaoAgricola_param IN OPERACAOAGRICOLA.idOperacaoAgricola%TYPE,
    dataAgendada_param IN OPERACAOAGRICOLA.dataAgendada%TYPE

) RETURN VARCHAR IS
    state CHAR(1);
BEGIN
    /* GUARDAR NA VARIÁVEL O ESTADO DA OPERAÇÃO */
SELECT estadoOperacao INTO state FROM OPERACAOAGRICOLA WHERE idOperacaoAgricola = idOperacaoAgricola_param;
/* SE O ESTADO FOR DIFERENTE DE 'R' E DE 'C', ENTÃO ATUALIZAR OS PARÂMETROS DA OPERAÇÃO. */
IF state != 'R' AND state != 'C' THEN
        /* ATUALIZAR A OPERAÇÃO EM QUALQUER UM DOS SEUS PARÂMETROS */
UPDATE OPERACAOAGRICOLA SET dataAgendada = dataAgendada_param, estadoOperacao = 'A' WHERE idOperacaoAgricola = idOperacaoAgricola_param;
RETURN 'Data da Operação Atualizada.';
/* NO CASO DE A OPERAÇÃO JÁ TER SIDO REALIZADA, APARECE A SEGUINTE MENSAGEM. */
ELSE
        RETURN 'Não é Possível Atualizar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.';
END IF;
END;
/


/* FUNÇÃO QUE PERMITE ATUALIZAR O TIPO DE UMA OPERAÇÃO QUE AINDA NÃO TENHA SIDO REALIZADA */
CREATE OR REPLACE FUNCTION func_UpdateOperationType(
    idOperacaoAgricola_param IN OPERACAOAGRICOLA.idOperacaoAgricola%TYPE,
    tipoOperacao_param IN OPERACAOAGRICOLA.tipo%TYPE
) RETURN VARCHAR IS
    state CHAR(1);
BEGIN
    /* GUARDAR NA VARIÁVEL O ESTADO DA OPERAÇÃO */
SELECT estadoOperacao INTO state FROM OPERACAOAGRICOLA WHERE idOperacaoAgricola = idOperacaoAgricola_param;
/* SE O ESTADO FOR DIFERENTE DE 'R' E DE 'C', ENTÃO ATUALIZAR OS PARÂMETROS DA OPERAÇÃO. */
IF state != 'R' AND state != 'C' THEN
        /* ATUALIZAR A OPERAÇÃO EM QUALQUER UM DOS SEUS PARÂMETROS */
UPDATE OPERACAOAGRICOLA SET tipo = tipoOperacao_param, estadoOperacao = 'A' WHERE idOperacaoAgricola = idOperacaoAgricola_param;
RETURN 'Tipo de Operação Atualizado.';
/* NO CASO DE A OPERAÇÃO JÁ TER SIDO REALIZADA, APARECE A SEGUINTE MENSAGEM. */
ELSE
        RETURN 'Não é Possível Atualizar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.';
END IF;
END;
/

/* FUNÇÃO QUE PERMITE ATUALIZAR A QUANTIDADEAPLICADA A UMA OPERAÇÃO QUE AINDA NÃO TENHA SIDO REALIZADA */
CREATE OR REPLACE FUNCTION func_UpdateOperationAppliedQuantity(
    idOperacaoAgricola_param IN OPERACAOAGRICOLA.idOperacaoAgricola%TYPE,
    nomeComercialFatorProducao_param IN FatoresAplicados.nomeComercialFatorProducao%TYPE,
    quantidadeAplicada_param IN FATORESAPLICADOS.quantidadeAplicada%TYPE
) RETURN VARCHAR IS
    state CHAR(1);
BEGIN
    /* GUARDAR NA VARIÁVEL O ESTADO DA OPERAÇÃO */
SELECT estadoOperacao INTO state FROM OPERACAOAGRICOLA WHERE idOperacaoAgricola = idOperacaoAgricola_param;
/* SE O ESTADO FOR DIFERENTE DE 'R' E DE 'C', ENTÃO ATUALIZAR OS PARÂMETROS DA OPERAÇÃO. */
IF state != 'R' AND state != 'C' THEN
        /* ATUALIZAR A OPERAÇÃO EM QUALQUER UM DOS SEUS PARÂMETROS */
UPDATE FATORESAPLICADOS SET quantidadeAplicada = quantidadeAplicada_param WHERE idOperacaoAgricola = idOperacaoAgricola_param AND nomeComercialFatorProducao = nomeComercialFatorProducao_param;
UPDATE OPERACAOAGRICOLA SET estadoOperacao = 'A' WHERE idOperacaoAgricola = idOperacaoAgricola_param;
RETURN 'Quantidade Aplicada à Operação Agrícola Atualizada.';
/* NO CASO DE A OPERAÇÃO JÁ TER SIDO REALIZADA, APARECE A SEGUINTE MENSAGEM. */
ELSE
        RETURN 'Não é Possível Atualizar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.';
END IF;
END;
/

/* FUNÇÃO QUE PERMITE ATUALIZAR A FORMA DE APLICAÇÃO A UMA OPERAÇÃO QUE AINDA NÃO TENHA SIDO REALIZADA */
CREATE OR REPLACE FUNCTION func_UpdateOperationApplicationForm(
    idOperacaoAgricola_param IN OPERACAOAGRICOLA.idOperacaoAgricola%TYPE,
    nomeComercialFatorProducao_param IN FatoresAplicados.nomeComercialFatorProducao%TYPE,
    formaAplicacao_param IN FATORESAPLICADOS.formaAplicacao%TYPE
) RETURN VARCHAR IS
    state CHAR(1);
BEGIN
    /* GUARDAR NA VARIÁVEL O ESTADO DA OPERAÇÃO */
SELECT estadoOperacao INTO state FROM OPERACAOAGRICOLA WHERE idOperacaoAgricola = idOperacaoAgricola_param;
/* SE O ESTADO FOR DIFERENTE DE 'R' E DE 'C', ENTÃO ATUALIZAR OS PARÂMETROS DA OPERAÇÃO. */
IF state != 'R' AND state != 'C' THEN
        /* ATUALIZAR A OPERAÇÃO EM QUALQUER UM DOS SEUS PARÂMETROS */
UPDATE FATORESAPLICADOS SET formaAplicacao = formaAplicacao_param WHERE idOperacaoAgricola = idOperacaoAgricola_param AND nomeComercialFatorProducao = nomeComercialFatorProducao_param;
UPDATE OPERACAOAGRICOLA SET estadoOperacao = 'A' WHERE idOperacaoAgricola = idOperacaoAgricola_param;
RETURN 'Forma de Aplicação à Operação Agrícola Atualizada.';
/* NO CASO DE A OPERAÇÃO JÁ TER SIDO REALIZADA, APARECE A SEGUINTE MENSAGEM. */
ELSE
        RETURN 'Não é Possível Atualizar a Operação Agrícola, uma vez que já foi Realizada ou Cancelada.';
END IF;
END;
/

/* FUNÇÃO QUE PERMITE CRIAR UM FATOR APLICADO A UMA OPERAÇÃO */
CREATE OR REPLACE FUNCTION func_createFatorAplicado (
    idOperacaoAgricola_param IN FatoresAplicados.idOperacaoAgricola%TYPE,
    nomeComercialFatorProducao_param IN FatoresAplicados.nomeComercialFatorProducao%TYPE,
    quantidadeAplicada_param IN FatoresAplicados.quantidadeAplicada%TYPE,
    formaAplicacao_param IN FatoresAplicados.formaAplicacao%TYPE
)

    RETURN VARCHAR
    IS
    designacao_setor Setor.designacao%TYPE;
    id_exploracao_agricola Setor.idExploracaoAgricola%TYPE;
    id_restricao Restricao.idRestricao%TYPE;
    data_inicial Restricao.dataInicial%TYPE;
    data_final Restricao.dataFinal%TYPE;
    nome_comercial_fator_producao FatoresAplicados.nomeComercialFatorProducao%TYPE;
    estado_operacao OperacaoAgricola.estadoOperacao%TYPE;
    checker INTEGER;

CURSOR idRestricaoNomeComercial_cursor IS
SELECT R.idRestricao, R.nomeComercialFatorProducao, R.dataInicial, R.dataFinal
FROM Restricao R
         INNER JOIN RestricaoSetor RS
                    ON r.idRestricao = RS.idRestricao
         INNER JOIN Setor S
                    ON S.designacao = RS.designacaoSetor AND S.idExploracaoAgricola = RS.idExploracaoAgricola
         INNER JOIN OperacaoAgricola O
                    ON O.designacaoSetor = S.designacao AND O.idExploracaoAgricola = S.idExploracaoAgricola
WHERE O.idOperacaoAgricola = idOperacaoAgricola_param;

BEGIN
OPEN idRestricaoNomeComercial_cursor;
LOOP
FETCH idRestricaoNomeComercial_cursor INTO id_restricao, nome_comercial_fator_producao, data_inicial, data_final;
        EXIT WHEN idRestricaoNomeComercial_cursor%NotFound;
        IF nome_comercial_fator_producao = nomeComercialFatorProducao_param AND SYSDATE > data_inicial AND SYSDATE < data_final THEN
            CLOSE idRestricaoNomeComercial_cursor;
RETURN 'Fator producao ' || nomeComercialFatorProducao_param || ' is present in Restricao with id ' || id_restricao;
END IF;
END LOOP;
CLOSE idRestricaoNomeComercial_cursor;
/* VERIFICAR SE A COMBINAÇÃO ENTRE A DESIGNAÇÃO DO SETOR E O ID DA OPERAÇÃO AGRÍCOLA EXISTE NA TABELA SETOR */
SELECT COUNT(*) INTO checker
FROM FatoresAplicados FA
WHERE FA.idOperacaoAgricola = idOperacaoAgricola_param AND FA.nomeComercialFatorProducao = nomeComercialFatorProducao_param;

IF checker > 0 THEN
        RETURN 'Já existe um Fator de Produção com esse Nome Comercial para a mesma Operação Agrícola.';

ELSE
SELECT estadoOperacao INTO estado_operacao FROM OperacaoAgricola WHERE idOperacaoAgricola = idOperacaoAgricola_param;
IF estado_operacao != 'R' AND estado_operacao != 'C' THEN
            INSERT INTO FatoresAplicados (idOperacaoAgricola, nomeComercialFatorProducao, quantidadeAplicada, formaAplicacao)
            VALUES (idOperacaoAgricola_param, nomeComercialFatorProducao_param, quantidadeAplicada_param, formaAplicacao_param);
RETURN 'Fator de Produção Introduzido com Sucesso na Operação Agrícola.';
ELSE
            RETURN 'Operação foi Cancelada ou já estava Realizada.';
END IF;
END IF;
END;
/

/* FUNÇÃO QUE PERMITE REMOVER UM FATOR APLICADO A UMA OPERAÇÃO */
CREATE OR REPLACE FUNCTION func_removeFatorAplicado(
    idOperacaoAgricola_param IN FatoresAplicados.idOperacaoAgricola%TYPE,
    nomeComercialFatorProducao_param IN FatoresAplicados.nomeComercialFatorProducao%TYPE
)
    RETURN VARCHAR
    IS
    estado_operacao OperacaoAgricola.estadoOperacao%TYPE;
    checker INTEGER;

BEGIN
    /* VERIFICAR SE A COMBINAÇÃO ENTRE A DESIGNAÇÃO DO SETOR E O ID DA OPERAÇÃO AGRÍCOLA EXISTE NA TABELA SETOR */
SELECT COUNT(*) INTO checker
FROM FatoresAplicados F
WHERE F.idOperacaoAgricola = idOperacaoAgricola_param AND F.nomeComercialFatorProducao = nomeComercialFatorProducao_param;

IF checker = 0 THEN
        RETURN 'Não Existe um Fator Aplicado com esse Nome Comercial para a Operação Agrícola Especificada.';

ELSE
SELECT estadoOperacao INTO estado_operacao FROM OperacaoAgricola WHERE idOperacaoAgricola = idOperacaoAgricola_param;
IF estado_operacao != 'R' AND estado_operacao != 'C' THEN
DELETE FROM FatoresAplicados
WHERE idOperacaoAgricola = idOperacaoAgricola_param AND nomeComercialFatorProducao = nomeComercialFatorProducao_param;
RETURN 'Fator de Produção removido com sucesso, desta Operação Agrícola.';
ELSE
            RETURN 'Operação já foi Cancelada ou Realizada.';
END IF;
END IF;
END;
/