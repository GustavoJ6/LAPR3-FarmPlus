CREATE TABLE Setor (
                       designacao              VARCHAR(50),
                       idExploracaoAgricola     INTEGER,

                       CONSTRAINT pk_Setor_designacao_idExploracaoAgricola PRIMARY KEY (designacao, idExploracaoAgricola)
);

CREATE TABLE Cultura (
                         idCultura               INTEGER               CONSTRAINT pk_Cultura_idCultura PRIMARY KEY,
                         designacaoSetor         VARCHAR(50),
                         idExploracaoAgricola    INTEGER,
                         tipoCultura             CHAR(1),
                         CONSTRAINT ck_Cultura_tipoCultura CHECK (tipoCultura IN ('P', 'T')), /* Permanente / temporário */

                         cultivo                 VARCHAR(40),

                         CONSTRAINT fk_Cultura_designacaoSetor_idEploracaoAgricola FOREIGN KEY (designacaoSetor, idExploracaoAgricola) REFERENCES Setor (designacao, idExploracaoAgricola)
);

CREATE TABLE Cliente (
    codigoInterno INTEGER           CONSTRAINT pk_Cliente_codigoInterno PRIMARY KEY
);

CREATE TABLE Tempo (
                       ano DATE,
                       mes DATE,

                       CONSTRAINT pk_Tempo_anoMes PRIMARY KEY (ano, mes)
);


CREATE TABLE Produto (
                         idProduto           INTEGER         CONSTRAINT pk_Produto_idProduto PRIMARY KEY,
                         nome                VARCHAR(30)
);

CREATE TABLE CulturaProduto (
                                idCultura           INTEGER,
                                idProduto           INTEGER,

                                CONSTRAINT pk_CulturaProduto_idCultura_idProduto PRIMARY KEY (idCultura, idProduto),
                                CONSTRAINT fk_CulturaProduto_idCultura FOREIGN KEY (idCultura) REFERENCES Cultura (idCultura),
                                CONSTRAINT fk_CulturaProduto_idProduto FOREIGN KEY (idProduto) REFERENCES Produto (idProduto)
);

CREATE TABLE DadosNegocio (
                              idBusinessRow           INTEGER             GENERATED ALWAYS AS IDENTITY CONSTRAINT pk_Sensor_identificador PRIMARY KEY,
                              producaoEmToneladas     NUMBER(8, 2)        CONSTRAINT ck_BusinessDate_producaoEmToneladas CHECK (producaoEmToneladas >= 0),
                              vendasEmMilharesEuros   NUMBER(8, 2)        CONSTRAINT ck_BusinessDate_vendasEmMilharesEuros CHECK (vendasEmMilharesEuros >= 0),
                              idCultura               INTEGER,
                              idProduto               INTEGER,
                              anoTempo                DATE,
                              mesTempo                DATE,
                              codigoInternoCliente    INTEGER,

                              CONSTRAINT fk_BusinessData_idCultura_idProduto FOREIGN KEY (idCultura) REFERENCES Cultura (idCultura),
                              CONSTRAINT fk_BusinessDate_idProduto_Produto            FOREIGN KEY (idProduto)                 REFERENCES Produto(idProduto),
                              CONSTRAINT fk_BusinessDate_ano_Tempo                    FOREIGN KEY (anoTempo, mesTempo)        REFERENCES Tempo(ano, mes),
                              CONSTRAINT fk_BusinessDate_codigoInterno_Cliente        FOREIGN KEY (codigoInternoCliente)      REFERENCES Cliente(codigoInterno)
);
