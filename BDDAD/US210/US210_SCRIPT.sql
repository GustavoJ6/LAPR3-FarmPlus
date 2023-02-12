/* Critério de Aceitação 1 */

CREATE OR REPLACE FUNCTION func_inserirOperacaoAgricola (
  p_designacaoSetor IN OperacaoAgricola.designacaoSetor%TYPE,
  p_idExploracaoAgricola IN OperacaoAgricola.idExploracaoAgricola%TYPE,
  p_dataAgendada IN OperacaoAgricola.dataAgendada%TYPE,
  p_tipo IN OperacaoAgricola.tipo%TYPE
) RETURN VARCHAR

IS

valido INTEGER;

BEGIN
  /* Verificar se existe a combinação do setor e exploração inseridos por parâmetro */
  SELECT COUNT(*) INTO valido
  FROM SETOR s
  WHERE s.designacao = p_designacaoSetor AND s.idExploracaoAgricola = p_idExploracaoAgricola;

  IF valido = 0 THEN
    RETURN 'Erro: Combinação Inválida da Designação do Setor e do ID da Exploração Agrícola.';
    ELSE 
    
    /* Verificar se a data para a qual a operação foi agendada, é superior à data no momento da criação */
    IF p_dataAgendada < SYSDATE THEN 
        RETURN 'Erro: Data Agendada Inválida (Data Agendada deve ser maior do que a data no momento da criação).';

    /* Se tudo estiver ok, podemos adicionar a operação agrícola */
    ELSE 
        INSERT INTO OperacaoAgricola (designacaoSetor, idExploracaoAgricola, dataAgendada, tipo, estadoOperacao)
        VALUES (p_designacaoSetor, p_idExploracaoAgricola, p_dataAgendada, p_tipo, 'P');
        RETURN 'Inserção da Operação Agrícola com Sucesso.';
    END IF;
  END IF;
END;
/

/* Critério de Aceitação 2 */

CREATE OR REPLACE FUNCTION func_inserirFatorAplicado (
  p_id_operacao_agricola IN FatoresAplicados.idOperacaoAgricola%TYPE,
  p_nome_comercial_fator_producao IN FatoresAplicados.nomeComercialFatorProducao%TYPE,
  p_quantidade_aplicada IN FatoresAplicados.quantidadeAplicada%TYPE,
  p_forma_aplicacao IN FatoresAplicados.formaAplicacao%TYPE
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
  valido INTEGER;
  
CURSOR id_restricao_nome_comercial_cursor IS 
    SELECT r.idRestricao, r.nomeComercialFatorProducao, r.dataInicial, r.dataFinal
        FROM Restricao r
        INNER JOIN RestricaoSetor rs
            ON r.idRestricao = rs.idRestricao
        INNER JOIN Setor s
            ON s.designacao = rs.designacaoSetor AND s.idExploracaoAgricola = rs.idExploracaoAgricola
        INNER JOIN OperacaoAgricola oa
            ON oa.designacaoSetor = s.designacao AND oa.idExploracaoAgricola = s.idExploracaoAgricola
        WHERE oa.idOperacaoAgricola = p_id_operacao_agricola;
        
BEGIN
    OPEN id_restricao_nome_comercial_cursor;
LOOP
    FETCH id_restricao_nome_comercial_cursor INTO id_restricao, nome_comercial_fator_producao, data_inicial, data_final;
    EXIT WHEN id_restricao_nome_comercial_cursor%NotFound;

        /* Se encontrarmos uma restrição a decorrer, cujo produto restringido, seja o mesmo que pretendemos adicionar, não o permitir */
        IF nome_comercial_fator_producao = p_nome_comercial_fator_producao AND SYSDATE > data_inicial AND SYSDATE < data_final THEN
            CLOSE id_restricao_nome_comercial_cursor;
            RETURN 'Fator producao ' || p_nome_comercial_fator_producao || ' está presente na restrição com id ' || id_restricao || '.';
        END IF;
END LOOP;
    CLOSE id_restricao_nome_comercial_cursor;
      /* Verificar se aquele fator não se encontra já adicionado à operação */
    SELECT COUNT(*) INTO valido
        FROM FatoresAplicados fa
        WHERE fa.idOperacaoAgricola = p_id_operacao_agricola AND fa.nomeComercialFatorProducao = p_nome_comercial_fator_producao;
    
    IF valido > 0 THEN 
    RETURN 'Já existe um fator produção com esse nome na operação.';
    
    /* Garantir que o estado da operação não é cancelado ou realizado */
    ELSE  
        SELECT estadoOperacao INTO estado_operacao FROM OperacaoAgricola WHERE idOperacaoAgricola = p_id_operacao_agricola;
        IF estado_operacao = 'P' OR estado_operacao = 'A' THEN 
            INSERT INTO FatoresAplicados (idOperacaoAgricola, nomeComercialFatorProducao, quantidadeAplicada, formaAplicacao)
            VALUES (p_id_operacao_agricola, p_nome_comercial_fator_producao, p_quantidade_aplicada, p_forma_aplicacao);
            RETURN 'Fator de producao adicionado com sucesso.';
        ELSE 
        RETURN 'Operação já foi realizada ou cancelada.';
        END IF;
    END IF;
END;
/

/* Critério de Aceitação 3 */

CREATE OR REPLACE PROCEDURE proc_listarOperacoesRestringidas

AS

/* Contém todas as explorações agrícolas */
  CURSOR exploracao_cursor IS
    SELECT idExploracaoAgricola
      FROM ExploracaoAgricola;

  /* Contém todas as operações que se realizam na próxima semana, e além disso se essas contém algum fator restringido */
  CURSOR operacao_cursor (p_id_exploracao_agricola IN ExploracaoAgricola.idExploracaoAgricola%TYPE) IS
    SELECT oa.idOperacaoAgricola, oa.designacaoSetor, oa.estadoOperacao, fa.nomeComercialFatorProducao
        FROM OperacaoAgricola oa
        INNER JOIN Setor s
            ON s.designacao = oa.designacaoSetor AND s.idExploracaoAgricola = oa.idExploracaoAgricola
        INNER JOIN FatoresAplicados fa
            ON fa.idOperacaoAgricola = oa.idOperacaoAgricola
        INNER JOIN RestricaoSetor rs
            ON rs.designacaoSetor = s.designacao
        INNER JOIN Restricao r
            ON r.idRestricao = rs.idRestricao AND r.nomeComercialFatorProducao = fa.nomeComercialFatorProducao
        WHERE oa.idExploracaoAgricola = p_id_exploracao_agricola AND (oa.estadoOperacao = 'A' OR oa.estadoOperacao = 'P') AND oa.dataAgendada BETWEEN SYSDATE AND SYSDATE + 7;
  
  v_id_operacao OperacaoAgricola.idOperacaoAgricola%TYPE;
  v_designacao_setor OperacaoAgricola.designacaoSetor%TYPE;
  v_estado_operacao OperacaoAgricola.estadoOperacao%TYPE;
  v_nome_comercial_fator FatoresAplicados.nomeComercialFatorProducao%TYPE;
  
BEGIN
    FOR exploracao_record IN exploracao_cursor
    LOOP
      OPEN operacao_cursor (exploracao_record.idExploracaoAgricola);
      LOOP
        FETCH operacao_cursor INTO v_id_operacao, v_designacao_setor, v_estado_operacao, v_nome_comercial_fator;
        EXIT WHEN operacao_cursor%NotFound;

        /* Apresentar todas as operações restringidas e os fatores que o causam */
        dbms_output.put_line('OperacaoAgricola ID: ' || v_id_operacao || ', DesignacaoSetor: ' || v_designacao_setor || ', EstadoOperacao: ' || v_estado_operacao || ', NomeComercialFator: ' || v_nome_comercial_fator);
      END LOOP;
      CLOSE operacao_cursor;
    END LOOP;
END;
/

/* Critério de Aceitação 4 */

CREATE OR REPLACE PROCEDURE proc_listarRestricoesAtivas (
  p_designacao_setor IN Setor.designacao%TYPE,
  p_id_exploracao_agricola IN Setor.idExploracaoAgricola%TYPE,
  p_data_verificar DATE
)

IS
  id_restricao Restricao.idRestricao%TYPE;
  data_inicial Restricao.dataInicial%TYPE;
  data_final Restricao.dataFinal%TYPE;
  nome_comercial_fator_producao FatoresAplicados.nomeComercialFatorProducao%TYPE;
  valido INTEGER;
  
/* Obter todas as restrições ativas para aquele setor naquela exploração */
CURSOR id_restricao_nome_comercial_cursor IS 
    SELECT r.idRestricao, r.nomeComercialFatorProducao, r.dataInicial, r.dataFinal
        FROM Restricao r
        INNER JOIN RestricaoSetor rs
            ON r.idRestricao = rs.idRestricao
        INNER JOIN Setor s
            ON s.designacao = rs.designacaoSetor AND s.idExploracaoAgricola = rs.idExploracaoAgricola
        WHERE rs.designacaoSetor = p_designacao_setor AND rs.idExploracaoAgricola = p_id_exploracao_agricola;
        
BEGIN
    
    /* Verificar que a junção da designação e do ID da exploração, existem */
    SELECT COUNT(*) INTO valido
        FROM SETOR s
            WHERE s.designacao = p_designacao_setor AND s.idExploracaoAgricola = p_id_exploracao_agricola;

    IF valido = 0 THEN
    dbms_output.put_line('Erro: Designação do Setor e ID da Exploração Agrícola não existem');
    
    ELSE
    dbms_output.put_line('Lista de Restrições Ativas');
    OPEN id_restricao_nome_comercial_cursor;
LOOP
    FETCH id_restricao_nome_comercial_cursor INTO id_restricao, nome_comercial_fator_producao, data_inicial, data_final;
    EXIT WHEN id_restricao_nome_comercial_cursor%NotFound;

    /* Garantir que a data parametrizada encaixa nos limites da restrição */
        IF p_data_verificar > data_inicial AND p_data_verificar < data_final THEN
            dbms_output.put_line('-----------------------------------------');
            dbms_output.put_line('ID     --> ' ||  id_restricao);
            dbms_output.put_line('Nome   --> ' ||  nome_comercial_fator_producao);
            dbms_output.put_line('Data I --> ' ||  data_inicial);
            dbms_output.put_line('Data F --> ' ||  data_final);
            dbms_output.put_line('-----------------------------------------');
        END IF;
END LOOP;
    CLOSE id_restricao_nome_comercial_cursor;
    END IF;
END;
/

/* Critério de Aceitação 5 */

CREATE OR REPLACE PROCEDURE listar_OperacoesPlaneadas (
  p_id_exploracao_agricola IN Setor.idExploracaoAgricola%TYPE
)

IS
  designacao_setor Setor.designacao%TYPE;
  data_agendada OperacaoAgricola.dataAgendada%TYPE;
  tipo_operacao OperacaoAgricola.tipo%TYPE;
  valid INTEGER;
  
  /* Todas as operações planeadas ou atualizadas por setor */
CURSOR operacoes_exploracao_cursor IS 
    SELECT oa.dataAgendada, oa.designacaoSetor, oa.tipo
        FROM Setor s
        INNER JOIN OperacaoAgricola oa
            ON s.designacao = oa.designacaoSetor
        WHERE oa.idExploracaoAgricola = p_id_exploracao_agricola AND (oa.estadoOperacao = 'P' OR oa.estadoOperacao = 'A')
        ORDER BY (oa.dataAgendada) ASC;

BEGIN
    /* Garantir que aquela exploração existe */
    SELECT COUNT(*) INTO valid
        FROM ExploracaoAgricola ea
            WHERE ea.idExploracaoAgricola = p_id_exploracao_agricola;  

    IF valid = 0 THEN
    dbms_output.put_line('Id da Exploração Agrícola Inválido.');
    ELSE
    dbms_output.put_line('Lista de Operações Planeadas por Setor: ');
    OPEN operacoes_exploracao_cursor;
LOOP
    FETCH operacoes_exploracao_cursor INTO data_agendada, designacao_setor, tipo_operacao;
    EXIT WHEN operacoes_exploracao_cursor%NotFound;
            dbms_output.put_line('-----------------------------------------');
            dbms_output.put_line('Designacao Setor --> ' ||  designacao_setor);
            dbms_output.put_line('Data Agendada    --> ' ||  data_agendada);
            dbms_output.put_line('Tipo             --> ' ||  tipo_operacao);
            dbms_output.put_line('-----------------------------------------');
END LOOP;
    CLOSE operacoes_exploracao_cursor;
    END IF;
END;
/