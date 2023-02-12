/* Gestor Agrícola */
/* Requer um integer(8) */
INSERT INTO GestorAgricola VALUES(1);          /* Aprovado - Todos os campos são válidos */


/* Exploração Agrícola */
/* Requer um integer e uma foreign key do gestor agrícola */
INSERT INTO ExploracaoAgricola VALUES(100, 1);          /* Aprovado - Todos os campos são válidos */

INSERT INTO ExploracaoAgricola VALUES(100, 24);        /* Reprovado - A foreign key não existe */


/* Cliente */
/* Requer um VARCHAR(50) email, CHAR(1) tipo,  number(8, 2) plafond, CHAR(1) nivelNegócio, VARCHAR(50) nome e INTEGER(9) nif */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('ampedro2003@gmail.com', 'E', 1250.50, 'C', 'Pedro Monteiro', 247677979); /* Aprovado - todos os campos são válidos */

INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('ampedro2003@gmail.com', 'E', 1250.50, 'C', 'Pedro Monteiro', 247677979); /* Reprovado - O campo 'Email' apresenta um valor inválido. Este campo deve apresentar um valor único. Restrição de Chave */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('emailGiganteGaraQuebrarOLimiteDeEspacosDisponivies@gmail.com', 'E', 1250.50, 'C', 'Pedro Monteiro', 247677979); /* Reprovado - O campo 'Email' apresenta um valor demasiado grande. VARCHAR(50). Restrição de Domínio */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('emailQueNaoApresentaOCaracterNecessario', 'E', 1250.50, 'C', 'Pedro Monteiro', 247677979); /* Reprovado - O campo 'Email' apresenta um valor inválido. Todos os elementos neste campo devem apresentam o caracter '@'. Restrição de Integridade de Coluna */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('1@gmail.com2003', 'N', 1250.50, 'C', 'Pedro Monteiro', 247677979); /* Reprovado - O campo 'Tipo' apresenta um valor inválido. Apenas são válidos 'E' e 'P'. Restrição de Domínio */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('2@gmail.com2003', 'E', 999999999.501, 'C', 'Pedro Monteiro', 247677979); /* Reprovado - O campo 'Plafond' apresenta um valor demasiado grande. number (8, 2). Restrição de Integridade de Coluna */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('3@gmail.com2003', 'E',-5004, 'C', 'Pedro Monteiro', 247677979); /* Reprovado - O campo 'Plafond' apresenta um valor invalido. O valor do plafond não pode ser negativo. Restrição de Integridade de Coluna  */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('4@gmail.com2003', 'E', 1250.50, 'Q', 'Pedro Monteiro', 247677979); /* Reprovado - O campo 'NivelNegocio' apresenta um valor inválido. Apenas são válidos 'A', 'B' e 'C'. Restrição de Domínio */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('5@gmail.com2003', 'E', 1250.50, 'A', 'Nome Enorme Para Quebrar o Limite Establecido/ Rejeitado', 247677979); /* Reprovado - O campo 'Nome' apresenta um valor demasiado grande. VARCHAR(50). Restrição de Integridade de Coluna */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('6@gmail.com2003', 'E', 1250.50, 'C', 'Pedro Monteiro', 247677); /* Reprovado - O campo 'Nif' apresenta um valor inválido. O valor deve apresentar 9 digitos. Restrição de Domínio */
INSERT INTO Cliente(EMAIL, TIPO, PLAFOND, NIVELNEGOCIO, NOME, NIF)
VALUES('7@gmail.com2003', 'E', 1250.50, 'C', 'Pedro Monteiro', 2476779792); /* Reprovado - O campo 'Nif' apresenta um valor demasiado grande. INTEGER(9). Restrição de Integridade de Coluna */


/* Cliente - Exploração Agrícola */
/* Requer um INTEGER codigoInterno, INTEGER(8) idExploracaoAgricola */
INSERT INTO ClienteExploracaoAgricola VALUES(100, 1);           /* Aprovado - Todos os campos são válidos */

INSERT INTO ClienteExploracaoAgricola VALUES(200, 24);          /* Reprovado - O campo 'CodigoInterno' apresnta um valor inválido. Chave pai não encontrada. Restrição de Integridade Referencial */

/* Código Postal */
/* Requer um CHAR(8) codigoPostal, VARCHAR(100) localidade */
INSERT INTO CodigoPostal VALUES('4440-687', 'Valongo');

INSERT INTO CodigoPostal VALUES('4440-687', 'Valongo');         /* Reprovado - O campo 'CodigoPostal' apresenta um valor inválido. Este campo deve apresentar um valor único. Restrição de Chave */
INSERT INTO CodigoPostal VALUES('123', 'Valongo');              /* Reprovado - O campo 'CodigoPostal' apresenta um valor inválido. Este campo deve apresentar a seguinte formatação: ____-___. Restrição de Integridade de Coluna */
INSERT INTO CodigoPostal VALUES('4440-687', 'Nome Enorme Para Quebrar o Limite Establecido/ Rejeitado e para ultrapassar ' ||
                                            'iremos repetir, Nome Enorme Para Quebrar o Limite Establecido/ Rejeitado'); /* Reprovado - O campo 'Localidade' apresenta um valor demasiado grande. VARCHAR(50). Restrição de Integridade de Coluna */

/* Morada */
/* Requer CHAR(8) codigoPostal, INTEGER numeroPorta, codigo interno do cliente, CHAR(1) tipo de morada */
INSERT INTO Morada VALUES ('4440-687', 244, 1, 'C');       /* Aprovado - Todos os campos são válidos */

INSERT INTO Morada VALUES ('444-687', 244, 1, 'C');        /* Reprovado - O campo 'CodigoPostal' apresenta um valor invalido. O codigo postal deve apresentar a seguinte formatação: ____-___. Restrição de Integridade de Coluna */
INSERT INTO Morada VALUES ('4450-687', -34, 1, 'C');       /* Reprovado - O campo 'NumeroPorta' apresenta um valor invalido. O numero da porta não pode ser negativo. Restrição de Integridade de Coluna */
INSERT INTO Morada VALUES ('4460-687', 244, 24, 'C');      /* Reprovado - O campo 'CodigoInterno' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Morada VALUES ('4470-687', 244, 1, 'D');       /* Reprovado - O campo 'TipoMorada' apresenta um valor invalido. Apenas são válidos 'C' e 'E'. Restrição de Domínio */

/* Encomenda */
/* Requer INTEGER numero da encomenda, INTEGER codigo interno do cliente, CHAR(8) codigo postal, INTEGER numero da porta, DATE data de encomenda, estado CHAR(1), DATE data de entrega, DATE data de pagamento, NUMBER(8, 2) valorTotal */
INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(1, '4440-687', 244, TO_DATE('19-04-2005', 'DD-MM-YYYY'), 'P', TO_DATE('30-04-2005', 'DD-MM-YYYY'), TO_DATE('30-04-2005', 'DD-MM-YYYY'), 548.50);
/* Aprovado - Todos os campos são válidos */

INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(24, '4440-687', 244, TO_DATE('19-04-2005', 'DD-MM-YYYY'), 'P', TO_DATE('30-04-2005', 'DD-MM-YYYY'), TO_DATE('30-04-2005', 'DD-MM-YYYY'), 548.50);
/* Reprovado - O campo 'CodigoInterno' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */

INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(24, '4450-687', 244, TO_DATE('19-04-2005', 'DD-MM-YYYY'), 'P', TO_DATE('30-04-2005', 'DD-MM-YYYY'), TO_DATE('30-04-2005', 'DD-MM-YYYY'), 548.50);
/* Reprovado - O campo 'CodigoPostal + NumeroPorta' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */

INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(24, '4450-687', 244, null, 'P', TO_DATE('30-04-2005', 'DD-MM-YYYY'), TO_DATE('30-04-2005', 'DD-MM-YYYY'), 548.50);
/* Reprovado - O campo 'DataEncomenda' apresenta um valor invalido. Data de encomenda não pode ser null. Restrição de Vazios */

INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(1, '4440-687', 244, TO_DATE('19-04-2005', 'DD-MM-YYYY'), 'J', TO_DATE('30-04-2005', 'DD-MM-YYYY'), TO_DATE('30-04-2005', 'DD-MM-YYYY'), 548.50);
/* Reprovado - O campo 'estado' apresenta um valor invalido. Este campo apenas pode pode conter 'P', 'E' ou 'R'. Restrição de Domínio */

INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(1, '4440-687', 244, TO_DATE('19-04-2005', 'DD-MM-YYYY'), 'P', TO_DATE('30-04-2004', 'DD-MM-YYYY'), TO_DATE('30-04-2005', 'DD-MM-YYYY'), 548.50);
/* Reprovado - O campo 'DateEntrega' apresenta um valor invalido. A data de entrega não pode ser inferior à data de encomenda. Restrição de Integridade de Coluna */

INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(1, '4440-687', 244, TO_DATE('19-04-2005', 'DD-MM-YYYY'), 'P', TO_DATE('30-04-2005', 'DD-MM-YYYY'), TO_DATE('30-04-2004', 'DD-MM-YYYY'), 548.50);
/* Reprovado - O campo 'DataPagamento' apresenta um valor invalido. A data de pagamento não pode ser inferior à data de encomenda. Restrição de Integridade de Coluna */

INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(1, '4440-687', 244, TO_DATE('19-04-2005', 'DD-MM-YYYY'), 'P', TO_DATE('30-04-2005', 'DD-MM-YYYY'), TO_DATE('30-04-2005', 'DD-MM-YYYY'), 548465798.50);
/* Reprovado - O campo 'ValorTotal' apresenta um valor demasiado grande. NUMBER (8, 2). Restrição de Integridade de Coluna */

INSERT INTO Encomenda(CODIGOINTERNOCLIENTE, CODIGOPOSTALMORADA, NUMEROPORTAMORADA, DATAENCOMENDA, ESTADO, DATAENTREGA, DATAPAGAMENTO, VALORTOTAL)
VALUES(1, '4440-687', 244, TO_DATE('19-04-2005', 'DD-MM-YYYY'), 'P', TO_DATE('30-04-2005', 'DD-MM-YYYY'), TO_DATE('30-04-2005', 'DD-MM-YYYY'), -123.50);
/* Reprovado - O campo 'ValorTotal' apresenta um valor inválido. O valor de pagamento não pode ser negativo. Restrição de Integridade de Coluna */


/* Incidente */
/* Requer um INTEGER idIncidente, INTEGER numero da encomenda, NUMBER(8, 2) valor da divida, DATE data sanado, DATE data de ocorrência */
INSERT INTO Incidente(numeroEncomenda, valorDivida, dataSanado, dataOcorrencia) VALUES(1, 145.30, TO_DATE('12-12-2020', 'DD-MM-YYYY'), TO_DATE('12-12-1975', 'DD-MM-YYYY'));        /* Aprovado - Todos os campos são válidos */

INSERT INTO Incidente(numeroEncomenda, valorDivida, dataSanado, dataOcorrencia) VALUES(24, 145.30, TO_DATE('12-12-2020', 'DD-MM-YYYY'), TO_DATE('12-12-1975', 'DD-MM-YYYY'));       /* Reprovado - O campo 'numeroEncomenda' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Incidente(numeroEncomenda, valorDivida, dataSanado, dataOcorrencia) VALUES(1, 145465798.30, TO_DATE('12-12-2020', 'DD-MM-YYYY'), TO_DATE('12-12-1975', 'DD-MM-YYYY'));  /* Reprovado - O campo 'ValorDivida' apresenta um valor demasiado grande. number (8, 2). Restrição de Integridade de Coluna */
INSERT INTO Incidente(numeroEncomenda, valorDivida, dataSanado, dataOcorrencia) VALUES(1, -10.50, TO_DATE('12-12-2020', 'DD-MM-YYYY'), TO_DATE('12-12-1975', 'DD-MM-YYYY'));        /* Reprovado - O campo 'ValorDivida' apresenta um valor invalido. O valor da dívida não pode ser negativo. Restrição de Integridade de Coluna  */
INSERT INTO Incidente(numeroEncomenda, valorDivida, dataSanado, dataOcorrencia) VALUES(1, 145.30, TO_DATE('12-12-2020', 'DD-MM-YYYY'), TO_DATE('12-12-2021', 'DD-MM-YYYY'));        /* Reprovado - O campo 'DataSanado' apresenta um valor invalido. Data sanado deve ser igual ou depois à data de occorência. Restrição de Integridade de Coluna */
INSERT INTO Incidente(numeroEncomenda, valorDivida, dataSanado, dataOcorrencia) VALUES(1, 145.30, TO_DATE('12-12-2020', 'DD-MM-YYYY'), null);                                       /* Reprovado - O campo 'DataOcorrencia' apresenta um valor invalido. Data de ocorrência não pode ser null. Restrição de Vazios */


/* Estação Meteorológica */
/* Requer INTEGER id da estação meteorológica, INTEGER id da exploração agrícola */
INSERT INTO EstacaoMeteorologica(idExploracaoAgricola) VALUES(100);      /* Aprovado - Todos os campos são válidos */

INSERT INTO EstacaoMeteorologica(idExploracaoAgricola) VALUES(777);      /* Reprovado - O campo 'idExploracaoAgricola' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */


/* Tipo Sensor */
/* Requer CHAR(2) tipo de sensor, VARCHAR(5) unidade de medida */
INSERT INTO TipoSensor VALUES('TS', '°C');                      /* Aprovado - Todos os campos são válidos */

INSERT INTO TipoSensor VALUES('Temperatura do Somo', '°C');     /* Reprovado - O campo 'Tipo' apresenta um valor demasiado grande. VARCHAR(2). Restrição de Integridade de Coluna */
INSERT INTO TipoSensor VALUES('HS', 'Graus Celsius');           /* Reprovado - O campo 'Unidade' apresenta um valor demasiado grande. VARCHAR(5). Restrição de Integridade de Coluna */


/* Sensor */
/* Requer INTEGER identificador, INTEGER id da estação meteorológica, CHAR(2) tipo de sensor , NUMBER(5, 2) valor lido, NUMBER(5, 2) valor de referência, DATE instante de leitura */
INSERT INTO Sensor(idEstacaoMeteorologica, tipoTipoSensor)
VALUES(1, 'TS');       /* Aprovado - Todos os campos são válidos */

INSERT INTO Sensor(idEstacaoMeteorologica, tipoTipoSensor)
VALUES(111, 'TAP' );      /* Reprovado - O campo 'tipoSensor' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */

/* Setor */
/* Requer VARCHAR(40) designacao, INTEGER id da exploração agrícola, NUMBER(8, 2) area total */
INSERT INTO Setor VALUES('A', 100, 844.0);                                              /* Aprovado - Todos os campos são válidos */

INSERT INTO Setor VALUES('Setor Com Nome demasiado Grande para Caber', 100, 844.0);     /* Reprovado - O campo 'Designacao' apresenta um valor demasiado grande. VARCHAR(10). Restrição de Integridade de Coluna */
INSERT INTO Setor VALUES('B', 789, 844.0);                                              /* Reprovado - O campo 'idExploracaoAgricola' apresenta um valor inválido. Chave pai não encontrada */
INSERT INTO Setor VALUES('C', 100, 71589456.0);                                         /* Reprovado - O campo 'AreaTotal' apresenta um valor demasiado grande. NUMBER(8, 2). Restrição de Integridade de Coluna */
INSERT INTO Setor VALUES('E', 100, -1658.0);                                            /* Reprovado - O campo 'AreaTotal' apresenta um valor inválido. Este campo não pode apresentar um valor negativo. Restrição de Vazios */


/* Auditoria */
/* Requer INTEGER id da auditoria, INTEGER id do gestor agrícola, VARCHAR(10) designacao do setor, INTEGER id da exploração agrícola, DATE date e hora, CHAR(1) operação de escrita */
INSERT INTO Auditoria(idGestorAgricola, designacaoSetor, idExploracaoAgricola, dataHora, username, operacaoEscrita)
VALUES(1, 'A', 100, TO_DATE('27-05-2015 05:07','DD-MM-YYYY HH24:MI'), 'Paul', 'UPDATE');      /* Aprovado - Todos os campos são válidos */

INSERT INTO Auditoria(idGestorAgricola, designacaoSetor, idExploracaoAgricola, dataHora, username, operacaoEscrita)
VALUES(70, 'A', 100, TO_DATE('27-05-2015 05:07','DD-MM-YYYY HH24:MI'), 'Paul',  'INSERT');     /* Reprovado - O campo 'idGestorAgricola' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Auditoria(idGestorAgricola, designacaoSetor, idExploracaoAgricola, dataHora, username, operacaoEscrita)
VALUES(1, 'A', 200, TO_DATE('27-05-2015 05:07','DD-MM-YYYY HH24:MI'), 'Paul',  'INSERT');      /* Reprovado - O campo 'Designacao + idExploracaoAgricola' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Auditoria(idGestorAgricola, designacaoSetor, idExploracaoAgricola, dataHora, username, operacaoEscrita)
VALUES(1, 'A', 200, TO_DATE('27-05-2015 05:07','DD-MM-YYYY HH24:MI'), null,  'INSERT');      /* Reprovado - O campo 'Username' apresenta um valor invalido. Este campo não pode apresentar o valor null. Restrição de Vazios */
INSERT INTO Auditoria(idGestorAgricola, designacaoSetor, idExploracaoAgricola, dataHora, username, operacaoEscrita)
VALUES(1, 'A', 100, TO_DATE('27-05-2015 05:07','DD-MM-YYYY HH24:MI'), 'Bob', 'NONEXISTENT');      /* Reprovado - O campo 'OperacaoEscrita' apresenta um valor invalido. Este campo apenas pode conter 'I', 'U' ou 'D'. Restrição de Domínio */


/* Operacão Agrícola */
/* Requer INTEGER id da operação, VARCHAR(10) designacao do setor, INTEGER id da exploração agrícola, DATE data agendada, DATE data de realizacao, VARCHAR(40) tipo de operação, CHAR(1) estado da operação */
INSERT INTO OperacaoAgricola(designacaoSetor, idExploracaoAgricola, dataAgendada, dataRealizacao, tipo, estadoOperacao)
VALUES('A', 100, TO_DATE('27-11-2016','DD-MM-YYYY'), TO_DATE('04-04-2017','DD-MM-YYYY'), 'Irrigação e adubação', 'A');
/* Aprovado - Todos os campos são válidos */

INSERT INTO OperacaoAgricola(designacaoSetor, idExploracaoAgricola, dataAgendada, dataRealizacao, tipo, estadoOperacao)
VALUES('A', 789, TO_DATE('27-11-2016','DD-MM-YYYY'), TO_DATE('04-04-2017','DD-MM-YYYY'), 'Irrigação e adubação', 'A');
/* Reprovado - O campo 'Designacao + idExploracaoAgricola' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */

INSERT INTO OperacaoAgricola(designacaoSetor, idExploracaoAgricola, dataAgendada, dataRealizacao, tipo, estadoOperacao)
VALUES('A', 100, null, TO_DATE('04-04-2017','DD-MM-YYYY'), 'Irrigação e adubação', 'A');
/* Reprovado - O campo 'DataAgendanda' apresenta um valor invalido. Este campo não pode apresentar o valor null. Restrição de Vazios */

INSERT INTO OperacaoAgricola(designacaoSetor, idExploracaoAgricola, dataAgendada, dataRealizacao, tipo, estadoOperacao)
VALUES('A', 100, TO_DATE('27-11-2016','DD-MM-YYYY'), TO_DATE('04-04-2015','DD-MM-YYYY'), 'Irrigação e adubação', 'A');
/* Reprovado - O campo 'DataRealizacao' apresenta um valor invalido. Este campo não pode apresentar um valor inferior ao valor do campo 'DataAgendada'. Restrição de Integridade de Coluna */

INSERT INTO OperacaoAgricola(designacaoSetor, idExploracaoAgricola, dataAgendada, dataRealizacao, tipo, estadoOperacao)
VALUES('A', 100, TO_DATE('27-11-2016','DD-MM-YYYY'), TO_DATE('04-04-2017','DD-MM-YYYY'), 'Tipo Demasiado Grande Para Poder Caber Em 40 Espaços', 'A');
/* Reprovado - O campo 'Tipo' apresenta um valor demasiado grande. VARHCAR(40). Restrição de Integridade de Coluna */

INSERT INTO OperacaoAgricola(designacaoSetor, idExploracaoAgricola, dataAgendada, dataRealizacao, tipo, estadoOperacao)
VALUES('A', 100, TO_DATE('27-11-2016','DD-MM-YYYY'), TO_DATE('04-04-2017','DD-MM-YYYY'), 'Irrigação e adubação', 'B');
/* Reprovado - O campo 'EstadoOperacao' apresenta um valor invalido. Este campo apenas pode conter 'A', 'R' ou 'C'. Restrição de Domínio */


/* Fator Produção */
/* Requer VARCHAR(30) nome comercial, CHAR(2) tipo, VARCHAR(30) fornecedor */
INSERT INTO FatorProducao VALUES('Ametoctradina', 'FE', 'Jovagro');                             /* Aprovado - Todos os campos são válidos */

INSERT INTO FatorProducao VALUES('Nome Comercial Demasiado Grande', 'FE', 'Jovagro');           /* Reprovado - O campo 'NomeComercial' apresenta um valor demasiado grande. VARCHAR(30). Restrição de Integridade de Coluna */
INSERT INTO FatorProducao VALUES('1', 'Fertilizante', 'Jovagro');                               /* Reprovado - O campo 'Tipo' apresenta um valor demasiado grande. CHAR(2). Restrição de Integridade de Coluna */
INSERT INTO FatorProducao VALUES('2', 'FE', 'Fornecedor Com Nome Demasiado Grande');            /* Reprovado - O campo 'Fornecedor' apresenta um valor demasiado grande. VARCHAR(30). Restrição de Integridade de Coluna */


/* Fatores Aplicados */
/* Requer INTEGER id da operação, VARCHAR(30) nome comercial do fator de produção, NUMBER(5, 2) quantidade aplicada, VARCHAR(10) forma de aplicação */
INSERT INTO FatoresAplicados VALUES(1, 'Ametoctradina',  27.0, 'Fertirrega');                            /* Aprovado - Todos os campos são válidos */

INSERT INTO FatoresAplicados VALUES(79602606, 'Nome Comercial Não existente',  27.0, 'Fertirrega');             /* Reprovado - O campo 'NomeComercialFatorProducao' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO FatoresAplicados VALUES(79602607, 'Imazamox',  123465.0, 'Fertirrega');                             /* Reprovado - O campo 'QuandidadeAplicada' apresenta um valor demasiado grande. NUMBER(5, 2). Restrição de Integridade de Coluna */
INSERT INTO FatoresAplicados VALUES(79602608, 'Imazamox',  -123.0, 'Fertirrega');                               /* Reprovado - O campo 'QuandidadeAplicada' apresenta um valor inválido. Este campo não pode ser negativo. Restrição de Integridade de Coluna */
INSERT INTO FatoresAplicados VALUES(79602609, 'Imazamox',  27.0, 'Forma de Aplicado Grande');                   /* Reprovado - O campo 'idGestorAgricola' apresenta um valor demasiado grande. VARCHAR(10). Restrição de Integridade de Coluna */


/* Restricao */
/* Requer INTEGER idRestricao, VARCHAR(30) nome comercial do fator de produção, DATE data de inicio, DATE data de fim */
INSERT INTO Restricao(nomeComercialFatorProducao, dataInicial, dataFinal)
VALUES('Ametoctradina', TO_DATE('09-10-2020','DD-MM-YYYY'), TO_DATE('09-04-2022','DD-MM-YYYY'));  /* Aprovado - Todos os campos são válidos */

INSERT INTO Restricao(nomeComercialFatorProducao, dataInicial, dataFinal)
VALUES('Nome Comercial Não existente', TO_DATE('09-10-2020','DD-MM-YYYY'), TO_DATE('09-04-2022','DD-MM-YYYY')); /* Reprovado - O campo 'NomeComercialFatorProducao' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */

INSERT INTO Restricao(nomeComercialFatorProducao, dataInicial, dataFinal)
VALUES('Ametoctradina', null, TO_DATE('09-04-2022','DD-MM-YYYY'));   /* Reprovado - O campo 'DataInicial' apresenta um valor invalido. Este campo não pode apresentar um valor null. Restrição de Vazios */

INSERT INTO Restricao(nomeComercialFatorProducao, dataInicial, dataFinal)
VALUES('Ametoctradina', TO_DATE('09-10-2020','DD-MM-YYYY'), TO_DATE('09-04-2020','DD-MM-YYYY')); /* Reprovado - O campo 'DataFim' apresenta um valor invalido. Este campo não pode ser inferior ao valor do campo 'DataInicio'. Restrição de Integridade de Coluna */

/* Restrição Setor */
/* Requer INTEGER idRestricao, VARCHAR(40) nome do setor, INTEGER id da Exploração Agrícola */
INSERT INTO RestricaoSetor (DESIGNACAOSETOR,IDEXPLORACAOAGRICOLA,IDRESTRICAO) VALUES('A', 100, 1);         /* Aprovado - Todos os campos são válidos */

INSERT INTO RestricaoSetor (DESIGNACAOSETOR,IDEXPLORACAOAGRICOLA,IDRESTRICAO) VALUES('A', 100, 20);        /* Reprovado - O campo 'IDRestricao' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO RestricaoSetor (DESIGNACAOSETOR,IDEXPLORACAOAGRICOLA,IDRESTRICAO) VALUES('Z', 123, 1);         /* Reprovado - O campo 'Designacao + IdExploracaoAgricola' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */

/* Constituinte */
/* Requer VARCHAR(30) nome, NUMBER(5, 2) quantidade, VARCHAR(5) unidade de medida, CHAR(1) categoria */
INSERT INTO Constituinte VALUES('Pentóxido de fósforo', 86.0, '%', 'E');                        /* Aprovado - Todos os campos são válidos */
INSERT INTO Constituinte VALUES('Nome Demasiado Grande Para 30 Espaços', 86.0, '%', 'E');      /* Reprovado - O campo 'Nome' apresenta um valor demasiado grande. VARCHAR(30). Restrição de Integridade de Coluna */
INSERT INTO Constituinte VALUES('1', 123456.0, '%', 'E');                                      /* Reprovado - O campo 'Quantidade' apresenta um valor demasiado grande. NUMBER(5, 2). Restrição de Integridade de Coluna */
INSERT INTO Constituinte VALUES('2', 86.0, 'milímetros', 'E');                                 /* Reprovado - O campo 'Unidade' apresenta um valor demasiado grande. VARCHAR(5). Restrição de Integridade de Coluna */
INSERT INTO Constituinte VALUES('3', 86.0, '%', 'P');                                          /* Reprovado - O campo 'Categoria' apresenta um valor inválido. Este campo apenas pode contar 'E' e 'S'. Restrição de Domínio */


/* Ficha Ténica */
/* Requer VARCHAR(30) nome comercial do fator de produção, VARCHAR(30) nome do constituinte */
INSERT INTO FatorProducaoConstituinte VALUES ('Ametoctradina','Pentóxido de fósforo');                                  /* Aprovado - Todos os campos são válidos */

INSERT INTO FatorProducaoConstituinte VALUES ('Nao Existenet Nome de Fator de Producao','Pentóxido de fósforo');        /* Reprovado - O campo 'nomeComercial' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO FatorProducaoConstituinte VALUES ('Pentóxido de fósforo','Nao Existenet Nome de Constituinte');             /* Reprovado - O campo 'nomeComercial' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */

/* Cultura */
/* Requer INTEGER id da cultura, VARCHAR(10) designacao do setor, INTEGER id da exploração agrícola, NUMBER(8, 2) area da cultura, CHAR(1) tipo da cultura, VARCHAR(20) cultivo */
INSERT INTO Cultura(designacaoSetor, idExploracaoAgricola, areaCultura, tipo, cultivo)
VALUES ('A', 100, 140.0, 'P', 'Tomate');                        /* Aprovado - Todos os campos são válidos */

INSERT INTO Cultura(designacaoSetor, idExploracaoAgricola, areaCultura, tipo, cultivo)
VALUES ('A', 789, 140.0, 'P', 'Tomate');                        /* Reprovado - O campo 'Designacao + idExploracaoAgricola' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Cultura(designacaoSetor, idExploracaoAgricola, areaCultura, tipo, cultivo)
VALUES ('A', 789, 123456798.0, 'P', 'Tomate');                  /* Reprovado - O campo 'AreaCultura' apresenta um valor demasiado grande. NUMBER(8, 2). Restrição de Integridade de Coluna */
INSERT INTO Cultura(designacaoSetor, idExploracaoAgricola, areaCultura, tipo, cultivo)
VALUES ('A', 789, -8.0, 'P', 'Tomate');                         /* Reprovado - O campo 'AreaCultura' apresenta um valor inválido. Este campo não pode ser negativo. Restrição de Integridade de Coluna */
INSERT INTO Cultura(designacaoSetor, idExploracaoAgricola, areaCultura, tipo, cultivo)
VALUES ('A', 100, 140.0, 'R', 'Tomate');                        /* Reprovado - O campo 'Tipo' apresenta um valor inválido. Este campo apenas pode contar 'P', 'T'. Restrição de Domínio */
INSERT INTO Cultura(designacaoSetor, idExploracaoAgricola, areaCultura, tipo, cultivo)
VALUES ('A', 100, 140.0, 'P', 'Cultivo Demasiado Grande Para Caber Aqui.');      /* Reprovado - O campo 'Cultivo' apresenta um valor demasiado grande. VARCHAR(20). Restrição de Integridade de Coluna */

/* Produto */
/* Requer INTEGER id do produto, VARCHAR(40) nome do produto*/
INSERT INTO Produto VALUES(1, 'Tomate');                        /* Aprovado - Todos os campos são válidos */

INSERT INTO Produto(nome)
VALUES('Nome Demasiado Grande Para 40 Espaços');                /* Reprovado - O campo 'Nome' apresenta um valor demasiado grande. VARCHAR(40). Restrição de Integridade de Coluna */


/* CulturaProduto */
/* Requer INTEGER id do produto, INTEGER id da cultura */
INSERT INTO CulturaProduto VALUES(1, 1);                        /* Aprovado - Todos os campos são válidos */

INSERT INTO CulturaProduto VALUES(1, 100);                      /* Reprovado - O campo 'IdCultura' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO CulturaProduto VALUES(100, 1);                      /* Reprovado - O campo 'IdProduto' apresenta um valor invalido. Chave pai não encontrada. Restrição de Integridade Referencial */


/* Safra */
/* Requer INTEGER id da safra, INTEGER id da cultura, INTEGER quantidade de produção, NUMBER(8, 2) lucro */
INSERT INTO Safra(idCultura, quantidadeProducao, lucro)
VALUES(1, 93553.0, 478817.0);                /* Aprovado - Todos os campos são válidos */

INSERT INTO Safra(idCultura, quantidadeProducao, lucro)
VALUES(123456, 123456789.0, 478817.0);       /* Reprovado - O campo 'IdCultura' apresenta um valor inválido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Safra(idCultura, quantidadeProducao, lucro)
VALUES(62, -3553.0, 478817.0);                /* Reprovado - O campo 'QuantidadeProducao' apresenta um valor inválido. Este campo não pode ser negativo. Restrição de Integridade de Coluna */
INSERT INTO Safra(idCultura, quantidadeProducao, lucro)
VALUES(62, 93553.0, 123456789.0);             /* Reprovado - O campo 'Lucro' apresenta um valor demasiado grande. NUMBER(8, 2). Restrição de Integridade de Coluna */


/* Característica */
/* Requer INTEGER id da característica, INTEGER id da cultura, VARCHAR(20) nome da característica */
INSERT INTO Caracteristica(idCultura, nome) VALUES(1, 'Capacidade');                          /* Aprovado - Todos os campos são válidos */

INSERT INTO Caracteristica(idCultura, nome) VALUES(123456, 'Capacidade');                     /* Reprovado - O campo 'IdCultura' apresenta um valor inválido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Caracteristica(idCultura, nome) VALUES(62, 'Nome Demasiado Grande');               /* Reprovado - O campo 'Nome' apresenta um valor demasiado grande. VARCHAR(20). Restrição de Integridade de Coluna */

/* Parámetros */
/* Requer INTEGER id do parâmetro, INTEGER id da característica, INTEGER id da cultura, VARCHAR(20) nome do parâmetro */
INSERT INTO Parametro(idCaracteristica, idCultura, nome)
VALUES(1, 1, 'espécie');                       /* Aprovado - Todos os campos são válidos */

INSERT INTO Parametro(idCaracteristica, idCultura, nome)
VALUES(123456, 98, 'espécie');                       /* Reprovado - O campo 'IdCaracteristica' apresenta um valor inválido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Parametro(idCaracteristica, idCultura, nome)
VALUES(287574, 123456, 'espécie');                  /* Reprovado - O campo 'IdCultura' apresenta um valor inválido. Chave pai não encontrada. Restrição de Integridade Referencial */
INSERT INTO Parametro(idCaracteristica, idCultura, nome)
VALUES(287574, 98, 'Nome Demasiado Grande');         /* Reprovado - O campo 'Nome' apresenta um valor demasiado grande. VARCHAR(20). Restrição de Integridade de Coluna */

/* LIMPAR */
DELETE FROM Parametro;
DELETE FROM Caracteristica;
DELETE FROM Safra;
DELETE FROM CulturaProduto;
DELETE FROM Produto;
DELETE FROM Cultura;
DELETE FROM FatorProducaoConstituinte;
DELETE FROM Constituinte;
DELETE FROM RestricaoSetor;
DELETE FROM Restricao;
DELETE FROM FatoresAplicados;
DELETE FROM FatorProducao;
DELETE FROM OperacaoAgricola;
DELETE FROM Auditoria;
DELETE FROM Setor;
DELETE FROM Sensor;
DELETE FROM TipoSensor;
DELETE FROM EstacaoMeteorologica;
DELETE FROM Incidente;
DELETE FROM Encomenda;
DELETE FROM Morada;
DELETE FROM CodigoPostal;
DELETE FROM ClienteExploracaoAgricola;
DELETE FROM Cliente;
DELETE FROM ExploracaoAgricola;
DELETE FROM GestorAgricola;

/* DROP TABLES */
/* LIMPAR TABELAS */
drop table FATORPRODUCAOCONSTITUINTE cascade constraints
/

drop table GESTORAGRICOLA cascade constraints
/

drop table EXPLORACAOAGRICOLA cascade constraints
/

drop table CLIENTE cascade constraints
/

drop table CLIENTEEXPLORACAOAGRICOLA cascade constraints
/

drop table CODIGOPOSTAL cascade constraints
/

drop table MORADA cascade constraints
/

drop table ENCOMENDA cascade constraints
/

drop table INCIDENTE cascade constraints
/

drop table ESTACAOMETEOROLOGICA cascade constraints
/

drop table TIPOSENSOR cascade constraints
/

drop table SENSOR cascade constraints
/

drop table SENSORLEITURAS cascade constraints
/

drop table SETOR cascade constraints
/

drop table AUDITORIA cascade constraints
/

drop table OPERACAOAGRICOLA cascade constraints
/

drop table FATORPRODUCAO cascade constraints
/

drop table FATORESAPLICADOS cascade constraints
/

drop table RESTRICAO cascade constraints
/

drop table RESTRICAOSETOR cascade constraints
/

drop table CONSTITUINTE cascade constraints
/

drop table CULTURA cascade constraints
/

drop table PRODUTO cascade constraints
/

drop table CULTURAPRODUTO cascade constraints
/

drop table SAFRA cascade constraints
/

drop table CARACTERISTICA cascade constraints
/

drop table PARAMETRO cascade constraints
/

drop table INPUT_SENSOR cascade constraints
/

drop table INPUT_HUB cascade constraints
/

drop table HUB cascade constraints
/

drop table LOGLEITURASINPUT cascade constraints
/