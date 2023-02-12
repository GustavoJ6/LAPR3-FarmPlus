CREATE OR REPLACE PROCEDURE procCreateConstituinte (
    nome_param IN Constituinte.nome%TYPE,
    quantidade_param IN Constituinte.quantidade%TYPE,
    unidade_param IN Constituinte.unidade%TYPE,
    categoria_param IN Constituinte.categoria%TYPE
)
    IS


BEGIN
    /* INSERT Constituinte */
INSERT INTO Constituinte values (nome_param, quantidade_param, unidade_param, categoria_param);

dbms_output.put_line('O Constituinte - ' || nome_param || ' - foi criado com sucesso!');

EXCEPTION

    WHEN others THEN
        dbms_output.put_line('Não foi possível adicionar o Constituinte, - ' || nome_param);
END;
/

-- Other Procedure

CREATE OR REPLACE PROCEDURE procCreateFatorProducao (
    nomeComercial_param IN FatorProducao.nomeComercial%TYPE,
    tipo_param IN FatorProducao.tipo%TYPE,
    fornecedor_param IN FatorProducao.fornecedor%TYPE
)
IS

    is_inserted FatorProducao.nomeComercial%TYPE;

BEGIN
INSERT INTO FatorProducao values (nomeComercial_param, tipo_param, fornecedor_param) returning NomeComercial into is_inserted;

dbms_output.put_line('O Fator de Produção, - ' || is_inserted || ' - foi criado com sucesso!');

EXCEPTION

    WHEN others THEN
        dbms_output.put_line('Não foi possível adicionar o Fator de Produção - ' || nomeComercial_param);
END;
/

-- Other Procedure

CREATE OR REPLACE PROCEDURE procCreateFatorProducaoConstituinte (
    nomeComercial_param IN FatorProducao.nomeComercial%TYPE,
    nomeConstituinte_param IN Constituinte.nome%TYPE
)
    IS
BEGIN
    /* INSERT FatorProducaoConstituinte */
INSERT INTO FatorProducaoConstituinte values (nomeComercial_param, nomeConstituinte_param);

dbms_output.put_line('A ficha Ténica foi criada com sucesso');

EXCEPTION

    WHEN others THEN
        dbms_output.put_line('Não foi possível criar a ficha tecnica');
END;
/