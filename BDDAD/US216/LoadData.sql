/* Setor */
INSERT INTO Setor VALUES ('A', 100);
INSERT INTO Setor VALUES ('B', 100);
INSERT INTO Setor VALUES ('C', 200);
INSERT INTO Setor VALUES ('D', 200);
INSERT INTO Setor VALUES ('E', 300);

/* Alternative */
/*
INSERT INTO Setor(designacao, idExploracaoAgricola)
SELECT designacao, idExploracaoAgricola
FROM User1.Setor;
 */

/* Cultura */
INSERT INTO Cultura VALUES(10, 'A', 100, 'T', 'Morango');
INSERT INTO Cultura VALUES(11, 'A', 100, 'T', 'Mirtilo');
INSERT INTO Cultura VALUES(12, 'B', 100, 'P', 'Banana');
INSERT INTO Cultura VALUES(13, 'B', 100, 'T', 'Kiwi');

INSERT INTO Cultura VALUES(14, 'C', 200, 'P', 'Pera');
INSERT INTO Cultura VALUES(15, 'C', 200, 'P', 'Maça');
INSERT INTO Cultura VALUES(16, 'D', 200, 'P', 'Laranja');

INSERT INTO Cultura VALUES(17, 'E', 300, 'T', 'Maracuja');

/* Alternative */
/*
INSERT INTO Cultura(idCultura, designacaoSetor, idExploracaoAgricola, tipoCultura, cultivo)
SELECT idCultura, designacaoSetor, idExploracaoAgricola, tipo, cultivo
FROM User1.Cultura;

 */

/* Cliente */
INSERT INTO Cliente VALUES (1);
INSERT INTO Cliente VALUES (2);
INSERT INTO Cliente VALUES (3);
INSERT INTO Cliente VALUES (4);
INSERT INTO Cliente VALUES (5);
INSERT INTO Cliente VALUES (6);
INSERT INTO Cliente VALUES (7);
INSERT INTO Cliente VALUES (8);
INSERT INTO Cliente VALUES (9);
INSERT INTO Cliente VALUES (10);

/* Alternative */
/*
INSERT INTO Cliente(codigoInterno)
SELECT codigoInterno
FROM User1.Cliente;
 */

/* Tempo */
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'));

INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'));

INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'));

INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'));

INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'));
INSERT INTO Tempo VALUES (TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'));

/* Produto */
INSERT INTO Produto VALUES (1,  'Sumo de Frutos Vermelhos');
INSERT INTO Produto VALUES (2,  'Salada de Fruta');
INSERT INTO Produto VALUES (3,  'Sumo de Laranja');
INSERT INTO Produto VALUES (4,  'Maracuja');
INSERT INTO Produto VALUES (5,  'Laranja');
INSERT INTO Produto VALUES (6,  'Morango');
INSERT INTO Produto VALUES (7,  'Bolo de Mirtilo');
INSERT INTO Produto VALUES (8,  'Bolo de Laranja');
INSERT INTO Produto VALUES (9,  'Pera');
INSERT INTO Produto VALUES (10, 'Sumo Tutti Fruti');
INSERT INTO Produto VALUES (11, 'Kiwi');
INSERT INTO Produto VALUES (12, 'Bolo de Morango');

/* Alternative */
/*
INSERT INTO Produto(idProduto, nome)
SELECT idProduto, nome
FROM User1.Produto;
 */

/* Cultura Produto */
INSERT INTO CulturaProduto VALUES (10, 1);
INSERT INTO CulturaProduto VALUES (11, 1);
INSERT INTO CulturaProduto VALUES (10, 2);
INSERT INTO CulturaProduto VALUES (12, 2);
INSERT INTO CulturaProduto VALUES (13, 2);
INSERT INTO CulturaProduto VALUES (14, 2);
INSERT INTO CulturaProduto VALUES (16, 3);
INSERT INTO CulturaProduto VALUES (10, 4);
INSERT INTO CulturaProduto VALUES (16, 5);
INSERT INTO CulturaProduto VALUES (10, 6);
INSERT INTO CulturaProduto VALUES (11, 7);
INSERT INTO CulturaProduto VALUES (16, 8);
INSERT INTO CulturaProduto VALUES (14, 9);
INSERT INTO CulturaProduto VALUES (10, 10);
INSERT INTO CulturaProduto VALUES (11, 10);
INSERT INTO CulturaProduto VALUES (12, 10);
INSERT INTO CulturaProduto VALUES (14, 10);
INSERT INTO CulturaProduto VALUES (15, 10);
INSERT INTO CulturaProduto VALUES (17, 10);

/* Alternative */
/*
INSERT INTO CulturaProduto(idCultura, idProduto)
SELECT idCultura, idProduto
FROM User1.CulturaProduto;
 */

/* Hub */
INSERT INTO Hub VALUES (1,  'C');
INSERT INTO Hub VALUES (2,  'C');
INSERT INTO Hub VALUES (3,  'E');
INSERT INTO Hub VALUES (4,  'E');
INSERT INTO Hub VALUES (5,  'C');
INSERT INTO Hub VALUES (6,  'P');
INSERT INTO Hub VALUES (7,  'C');
INSERT INTO Hub VALUES (8,  'P');
INSERT INTO Hub VALUES (9,  'P');
INSERT INTO Hub VALUES (10, 'C');


/* Dados Negocio */
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8761.56, 6776.84, 10, TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'), 9, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5811.86, 3668.58, 10, TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'), 7, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9687.20, 2735.60, 10, TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2311.21, 7661.35, 10, TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2329.53, 3101.77, 10, TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'), 8, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9044.2, 3060.39, 10, TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5195.33, 2666.98, 10, TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'), 5, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7124.47, 7459.73, 10, TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'), 2, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9470.41, 4409.84, 10, TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'), 1, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1414.47, 5769.7, 10, TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'), 5, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6803.6, 7771.19, 10, TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'), 7, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8107.6, 5109.62, 10, TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'), 1, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3731.56, 4566.96, 10, TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'), 5, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6075.75, 4972.97, 10, TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'), 3, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5947.37, 6506.8, 10, TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6352.18, 5422.40, 10, TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'), 1, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8373.60, 9788.90, 10, TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'), 8, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8061.71, 6010.14, 10, TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'), 9, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2088.12, 7488.77, 10, TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'), 6, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9533.62, 4231.84, 10, TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'), 6, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1638.74, 8425.49, 10, TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'), 8, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4983.59, 8681.16, 10, TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9355.72, 3142.40, 10, TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'), 1, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7028.75, 4991.35, 10, TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'), 1, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1916.45, 1544.70, 10, TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'), 7, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6056.4, 7636.94, 10, TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'), 6, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1297.89, 9678.22, 10, TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'), 8, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4901.16, 4537.52, 10, TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'), 3, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4393.70, 5050.94, 10, TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'), 6, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6141.36, 8070.60, 10, TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'), 5, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4662.98, 1612.18, 10, TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'), 3, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1775.8, 5673.84, 10, TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7033.96, 1340.56, 10, TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1636.87, 5619.11, 10, TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'), 2, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1488.97, 9896.76, 10, TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'), 2, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7465.67, 8519.92, 10, TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'), 2, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1503.57, 1809.63, 10, TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'), 9, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3625.80, 2424.81, 10, TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'), 8, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4008.32, 9955.13, 10, TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'), 9, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2916.78, 6909.31, 10, TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'), 6, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3820.76, 5580.93, 10, TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'), 6, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2968.8, 3169.92, 10, TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'), 9, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6080.91, 3121.5, 10, TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'), 8, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2614.50, 1063.68, 10, TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'), 4, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2086.5, 4214.34, 10, TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'), 4, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5794.3, 5021.79, 10, TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'), 4, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9097.34, 7394.61, 10, TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'), 4, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8735.48, 8566.35, 10, TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'), 7, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3036.39, 5137.43, 10, TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'), 1, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5518.82, 2380.73, 10, TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'), 6, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6421.3, 6900.64, 10, TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5936.55, 8733.26, 10, TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'), 5, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5903.51, 8442.56, 10, TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'), 8, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6654.97, 1387.60, 10, TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'), 7, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2701.59, 8902.13, 10, TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'), 2, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7152.87, 2453.40, 10, TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'), 2, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3736.89, 4688.27, 10, TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'), 7, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4370.59, 3806.2, 10, TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'), 5, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3462.43, 3006.20, 10, TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'), 7, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2074.65, 6981.29, 10, TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'), 3, 5);


INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8670.37, 7565.64, 11, TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'), 3, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5733.71, 6428.65, 11, TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'), 5, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7759.10, 9636.66, 11, TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'), 1, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5057.22, 9583.34, 11, TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'), 5, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9115.33, 1561.40, 11, TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'), 7, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6118.35, 9122.49, 11, TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'), 6, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4304.44, 1174.36, 11, TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'), 9, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8028.44, 6445.46, 11, TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'), 1, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9626.94, 9166.77, 11, TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'), 3, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6175.40, 2019.79, 11, TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'), 6, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1002.72, 5874.38, 11, TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8115.92, 2823.66, 11, TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'), 6, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4706.68, 9189.3, 11, TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'), 8, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5148.85, 4253.91, 11, TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2095.12, 1228.81, 11, TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'), 7, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7017.85, 7557.92, 11, TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'), 7, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3876.58, 8444.13, 11, TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3963.63, 2883.49, 11, TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'), 3, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2383.21, 6002.13, 11, TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'), 7, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9972.34, 9682.78, 11, TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'), 5, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9615.36, 7537.72, 11, TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'), 7, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2382.36, 9669.48, 11, TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3476.28, 6601.27, 11, TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'), 7, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7224.20, 3800.62, 11, TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'), 5, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5989.64, 5702.71, 11, TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6371.1, 6595.70, 11, TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'), 7, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5146.64, 2767.66, 11, TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'), 2, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8228.89, 4318.86, 11, TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'), 5, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2497.91, 9303.71, 11, TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'), 2, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4299.3, 8544.52, 11, TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'), 7, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3613.61, 3990.34, 11, TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'), 3, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3270.26, 9478.84, 11, TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'), 9, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2439.58, 5068.49, 11, TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'), 1, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2151.62, 6096.5, 11, TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9101.53, 6284.73, 11, TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'), 7, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9696.39, 3900.61, 11, TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'), 3, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3083.3, 2563.76, 11, TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'), 1, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7435.88, 7889.28, 11, TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'), 7, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1303.57, 2998.83, 11, TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7324.82, 2678.22, 11, TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'), 3, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5408.27, 7935.84, 11, TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'), 3, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9410.71, 6588.66, 11, TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'), 7, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9173.19, 1938.98, 11, TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'), 1, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7186.18, 3715.84, 11, TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'), 2, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4265.23, 5344.94, 11, TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'), 4, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1350.5, 7367.29, 11, TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'), 5, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6058.22, 7223.70, 11, TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'), 7, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9099.93, 9987.81, 11, TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'), 6, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9110.95, 1770.57, 11, TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'), 7, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6661.98, 7039.57, 11, TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2136.49, 4622.39, 11, TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'), 4, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9870.39, 2905.25, 11, TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'), 6, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8994.94, 5665.82, 11, TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'), 8, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2063.28, 5746.93, 11, TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'), 1, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1070.55, 8085.37, 11, TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'), 6, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2096.71, 4206.72, 11, TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'), 7, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6555.40, 2398.55, 11, TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'), 2, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3324.76, 7301.32, 11, TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'), 6, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5001.32, 2327.90, 11, TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'), 7, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4496.51, 2853.35, 11, TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'), 8, 7);


INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4939.26, 3263.35, 12, TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'), 7, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8028.81, 1413.91, 12, TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'), 3, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5960.32, 7829.67, 12, TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'), 6, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5608.26, 6644.61, 12, TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'), 7, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6383.42, 3410.88, 12, TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'), 4, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9273.26, 5375.57, 12, TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'), 8, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6968.86, 9819.25, 12, TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4062.31, 4770.38, 12, TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'), 5, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7793.65, 5800.1, 12, TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2859.42, 7213.21, 12, TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3953.34, 1011.27, 12, TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'), 6, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5566.21, 1348.92, 12, TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'), 8, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4505.77, 4766.43, 12, TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5430.5, 6807.30, 12, TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'), 3, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3574.20, 4410.92, 12, TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'), 4, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2931.91, 5437.82, 12, TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'), 2, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1887.46, 7214.38, 12, TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'), 1, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3622.35, 6005.19, 12, TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'), 8, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8485.10, 2759.31, 12, TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'), 1, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1751.2, 3597.3, 12, TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4927.35, 6411.16, 12, TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'), 4, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4153.26, 2618.76, 12, TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'), 2, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7900.16, 8664.25, 12, TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'), 1, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9588.26, 3528.71, 12, TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'), 4, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3212.70, 4588.40, 12, TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'), 7, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4644.60, 8204.34, 12, TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'), 9, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6494.64, 2546.47, 12, TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'), 6, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1741.10, 8709.26, 12, TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'), 7, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9754.14, 8270.33, 12, TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8274.41, 7604.28, 12, TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'), 1, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2386.23, 1705.73, 12, TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'), 4, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4717.40, 2206.26, 12, TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'), 5, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7608.62, 2743.50, 12, TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8875.47, 5735.63, 12, TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'), 8, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2381.25, 9338.76, 12, TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5518.18, 5788.84, 12, TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'), 4, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9332.56, 2257.46, 12, TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'), 9, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3797.98, 7850.24, 12, TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8947.97, 4461.34, 12, TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'), 9, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3517.83, 7516.70, 12, TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'), 3, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6302.34, 4672.24, 12, TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'), 4, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9268.83, 8056.49, 12, TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'), 3, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7017.7, 7264.13, 12, TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'), 7, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9265.50, 1009.86, 12, TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'), 4, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2674.60, 8429.48, 12, TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'), 2, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1290.63, 8697.96, 12, TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6058.38, 3805.13, 12, TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'), 1, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8215.39, 1890.62, 12, TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'), 1, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6835.58, 5156.2, 12, TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'), 7, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2849.72, 5682.15, 12, TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'), 5, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5561.95, 7424.68, 12, TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'), 9, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8022.32, 2809.93, 12, TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'), 5, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1979.36, 9311.67, 12, TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'), 6, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1232.75, 7174.43, 12, TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'), 7, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4686.34, 6987.28, 12, TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'), 2, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8289.33, 2378.9, 12, TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4616.1, 3238.22, 12, TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'), 3, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1546.89, 1040.45, 12, TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4242.27, 9379.77, 12, TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'), 1, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5525.18, 2730.6, 12, TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'), 5, 2);


INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3814.13, 7251.32, 13, TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'), 7, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5105.51, 8551.84, 13, TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2290.6, 8666.11, 13, TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2903.91, 2961.74, 13, TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'), 2, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2931.90, 8920.89, 13, TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6328.54, 1765.12, 13, TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'), 8, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3491.40, 6950.96, 13, TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'), 2, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3215.7, 5816.43, 13, TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'), 9, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2070.15, 3117.98, 13, TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'), 7, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4025.13, 2307.62, 13, TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'), 3, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4603.83, 9846.75, 13, TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2511.40, 6983.93, 13, TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'), 7, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3549.13, 7015.40, 13, TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3836.34, 7001.61, 13, TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'), 1, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9569.6, 2722.26, 13, TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'), 5, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6784.33, 2898.14, 13, TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'), 2, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7656.5, 1617.58, 13, TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'), 1, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4133.12, 9896.1, 13, TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'), 9, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9746.32, 1728.3, 13, TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'), 7, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4700.51, 5168.24, 13, TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'), 3, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9593.27, 1833.52, 13, TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'), 4, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6911.21, 5680.25, 13, TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'), 8, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3639.4, 9884.10, 13, TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'), 2, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2457.17, 5119.60, 13, TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'), 9, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6091.71, 7862.48, 13, TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'), 6, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6433.27, 8599.97, 13, TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'), 3, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9793.50, 4917.21, 13, TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'), 9, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4512.29, 1587.45, 13, TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4817.43, 3179.69, 13, TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4926.60, 1878.75, 13, TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6143.11, 1955.6, 13, TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'), 4, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9539.71, 1743.34, 13, TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'), 7, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4781.56, 7273.44, 13, TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'), 1, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2398.38, 1547.71, 13, TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'), 9, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1161.10, 7140.19, 13, TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'), 4, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9896.10, 1300.77, 13, TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3683.73, 6222.33, 13, TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'), 8, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5209.5, 4845.45, 13, TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'), 5, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2010.13, 2853.50, 13, TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'), 4, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6755.2, 5687.93, 13, TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'), 6, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3421.91, 2337.11, 13, TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'), 5, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1207.48, 3074.94, 13, TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'), 3, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1603.35, 9499.96, 13, TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'), 6, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9370.65, 1188.48, 13, TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5220.63, 2281.76, 13, TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'), 8, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8698.23, 2206.17, 13, TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'), 3, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6844.49, 3183.87, 13, TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'), 2, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8157.20, 1187.17, 13, TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'), 4, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2913.71, 1448.62, 13, TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8908.8, 2929.30, 13, TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4649.63, 2535.1, 13, TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'), 5, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2274.36, 9574.90, 13, TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'), 8, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9784.32, 8763.55, 13, TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'), 6, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2155.64, 2628.97, 13, TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'), 5, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3178.26, 7883.32, 13, TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'), 6, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2134.10, 3002.38, 13, TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'), 9, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3221.91, 8054.2, 13, TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'), 2, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5385.40, 4175.76, 13, TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6059.41, 3712.4, 13, TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4398.87, 3684.45, 13, TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'), 4, 9);


INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2419.61, 1512.75, 14, TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'), 4, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8925.67, 9641.23, 14, TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8515.74, 2686.89, 14, TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8727.76, 9818.3, 14, TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'), 2, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9963.6, 6060.56, 14, TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9566.89, 6341.3, 14, TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'), 2, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7822.10, 8040.54, 14, TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'), 4, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8675.24, 6138.52, 14, TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'), 7, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5340.65, 9464.32, 14, TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'), 7, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1141.45, 6010.54, 14, TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'), 6, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9830.94, 6550.48, 14, TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'), 1, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9079.89, 7746.12, 14, TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'), 6, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6632.97, 8988.42, 14, TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'), 4, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1468.17, 8943.21, 14, TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'), 4, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6953.9, 9135.83, 14, TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2679.36, 6538.8, 14, TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'), 9, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8142.38, 6727.19, 14, TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'), 8, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2480.91, 5345.92, 14, TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1817.67, 1337.96, 14, TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'), 9, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1364.12, 4951.4, 14, TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3931.71, 5130.38, 14, TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'), 8, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4490.17, 9770.48, 14, TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'), 5, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4119.37, 2431.76, 14, TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'), 9, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7642.75, 2751.44, 14, TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1218.62, 8579.6, 14, TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'), 5, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8271.8, 7392.3, 14, TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'), 7, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9668.31, 7508.70, 14, TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'), 6, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4719.40, 1365.76, 14, TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'), 7, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7822.42, 7641.18, 14, TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'), 6, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1870.72, 7068.71, 14, TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'), 3, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7125.86, 3587.62, 14, TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8057.28, 4942.64, 14, TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'), 2, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8834.32, 6064.82, 14, TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'), 6, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4472.37, 2357.45, 14, TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'), 3, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1598.44, 7529.81, 14, TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'), 6, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4991.11, 6030.73, 14, TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'), 7, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4531.93, 4072.55, 14, TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'), 3, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5707.85, 4018.70, 14, TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'), 9, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2207.37, 4933.88, 14, TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6926.48, 3567.62, 14, TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'), 3, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1992.45, 3810.2, 14, TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'), 1, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7144.34, 4709.70, 14, TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6384.58, 8858.39, 14, TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'), 5, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5773.13, 8617.48, 14, TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'), 4, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9755.52, 4437.3, 14, TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'), 9, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2592.79, 3646.37, 14, TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'), 6, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2699.90, 5838.21, 14, TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'), 3, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6772.44, 8340.13, 14, TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'), 9, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8716.57, 5759.61, 14, TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'), 2, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5404.25, 7282.23, 14, TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'), 6, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4771.6, 8267.36, 14, TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2013.45, 7848.67, 14, TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'), 4, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9957.68, 8038.5, 14, TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'), 6, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3406.52, 3678.23, 14, TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'), 6, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1468.89, 9869.40, 14, TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'), 1, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7055.62, 9409.17, 14, TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'), 3, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8380.78, 6436.57, 14, TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'), 6, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2903.52, 6231.27, 14, TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'), 8, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9427.17, 1054.49, 14, TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8376.39, 6737.78, 14, TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'), 7, 9);


INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7098.37, 4573.74, 15, TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'), 9, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2325.98, 9518.69, 15, TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'), 5, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4391.54, 5896.88, 15, TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'), 1, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9654.9, 9318.32, 15, TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3153.66, 7718.6, 15, TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'), 5, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9533.27, 2672.38, 15, TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'), 5, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5121.2, 9036.27, 15, TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'), 6, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8462.54, 1544.92, 15, TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'), 1, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2385.35, 8870.97, 15, TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'), 6, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2732.98, 4548.77, 15, TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'), 2, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9409.53, 6427.2, 15, TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7355.5, 9130.25, 15, TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'), 9, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7396.18, 2182.97, 15, TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'), 2, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9956.57, 5979.3, 15, TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5285.63, 5622.40, 15, TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'), 3, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6832.29, 8962.30, 15, TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'), 8, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6587.10, 6505.80, 15, TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5077.41, 1770.61, 15, TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'), 9, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6880.75, 1807.66, 15, TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3984.38, 6434.84, 15, TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'), 7, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8741.19, 2115.98, 15, TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'), 4, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2816.9, 3297.86, 15, TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'), 8, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2462.1, 4951.20, 15, TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1471.77, 3663.83, 15, TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'), 7, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5879.40, 6373.64, 15, TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8963.83, 3760.32, 15, TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'), 9, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2012.84, 8933.35, 15, TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'), 3, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2599.12, 7754.41, 15, TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'), 9, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3353.41, 2129.1, 15, TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'), 8, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7817.56, 2107.68, 15, TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'), 9, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2815.5, 6157.52, 15, TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'), 5, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1234.40, 9590.56, 15, TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'), 8, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8504.9, 8014.39, 15, TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'), 5, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3766.72, 7766.21, 15, TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'), 5, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2706.13, 6297.46, 15, TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'), 9, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9492.4, 7669.77, 15, TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'), 5, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5246.34, 1614.24, 15, TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'), 2, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7215.34, 2812.83, 15, TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'), 5, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6602.54, 1866.17, 15, TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6197.36, 3318.25, 15, TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'), 9, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1332.51, 9491.2, 15, TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'), 7, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9091.93, 9774.98, 15, TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'), 5, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3151.89, 1281.7, 15, TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3687.39, 9554.18, 15, TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8751.19, 7097.14, 15, TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'), 3, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8199.67, 3463.53, 15, TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7401.10, 7267.91, 15, TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'), 2, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8568.53, 5651.97, 15, TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'), 2, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1625.22, 5913.54, 15, TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'), 7, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9074.47, 8534.30, 15, TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7642.9, 3521.40, 15, TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8860.3, 3850.22, 15, TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'), 6, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1555.93, 9626.70, 15, TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4144.64, 4614.35, 15, TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'), 3, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5667.83, 8597.64, 15, TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'), 5, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1538.46, 9121.59, 15, TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'), 4, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4388.78, 6671.22, 15, TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'), 8, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1672.4, 6665.32, 15, TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'), 4, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2812.40, 8003.20, 15, TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'), 9, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8219.78, 1495.82, 15, TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'), 8, 8);


INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8289.7, 2927.39, 16, TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'), 9, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7930.73, 7134.2, 16, TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'), 8, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6586.41, 2072.12, 16, TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'), 4, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2294.4, 6532.10, 16, TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1567.64, 4350.78, 16, TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'), 6, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1417.45, 4239.67, 16, TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'), 3, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4184.54, 5067.95, 16, TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'), 2, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6382.18, 9252.48, 16, TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'), 2, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4913.19, 5328.97, 16, TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'), 8, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7722.11, 2238.25, 16, TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6773.74, 8834.82, 16, TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'), 9, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4994.30, 1775.98, 16, TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'), 4, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6809.5, 3102.34, 16, TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'), 2, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8040.5, 2545.80, 16, TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'), 5, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2957.64, 8348.8, 16, TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'), 7, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5832.49, 3457.69, 16, TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'), 5, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4897.95, 9788.47, 16, TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'), 9, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3416.76, 1003.47, 16, TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8792.98, 2518.23, 16, TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'), 4, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4512.2, 5812.98, 16, TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'), 4, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4878.91, 3005.31, 16, TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'), 9, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4866.18, 5701.21, 16, TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'), 9, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6638.23, 3785.87, 16, TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'), 7, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3534.21, 2739.24, 16, TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4877.26, 8417.70, 16, TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6718.27, 1493.24, 16, TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'), 4, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8498.88, 5290.1, 16, TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'), 4, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6302.30, 8298.66, 16, TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'), 6, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5853.29, 8316.64, 16, TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'), 1, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1959.80, 3145.87, 16, TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'), 7, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3728.30, 5295.29, 16, TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4575.16, 3552.63, 16, TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8048.21, 7265.53, 16, TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'), 6, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5345.86, 4170.77, 16, TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'), 4, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4835.37, 9098.70, 16, TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'), 5, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6341.46, 5756.23, 16, TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'), 5, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5403.35, 7201.6, 16, TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'), 4, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4066.66, 1187.88, 16, TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'), 1, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3185.56, 9715.52, 16, TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'), 6, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1582.76, 7233.48, 16, TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'), 1, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3284.60, 9359.4, 16, TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5317.4, 3739.91, 16, TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7580.44, 4989.85, 16, TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'), 1, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7389.73, 2205.17, 16, TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'), 5, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9774.41, 8366.16, 16, TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'), 6, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8779.13, 6116.15, 16, TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'), 9, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5056.35, 2697.39, 16, TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'), 5, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4603.8, 3496.18, 16, TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'), 3, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9371.18, 1746.33, 16, TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'), 8, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3524.76, 9372.60, 16, TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'), 5, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3070.95, 2249.19, 16, TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'), 9, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7032.17, 1438.84, 16, TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'), 3, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1807.34, 6325.69, 16, TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'), 3, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7086.61, 5632.33, 16, TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'), 3, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9706.11, 1883.9, 16, TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'), 2, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7230.61, 5437.9, 16, TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'), 5, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5785.82, 8086.56, 16, TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'), 1, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5863.88, 4744.98, 16, TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'), 9, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4245.89, 9489.46, 16, TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'), 4, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4092.82, 5011.88, 16, TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'), 6, 2);


INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7067.47, 6201.86, 17, TO_DATE('2018', 'YYYY'), TO_DATE('01', 'MM'), 5, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7300.8, 7467.84, 17, TO_DATE('2018', 'YYYY'), TO_DATE('02', 'MM'), 9, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4301.55, 9672.74, 17, TO_DATE('2018', 'YYYY'), TO_DATE('03', 'MM'), 6, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7494.29, 6501.97, 17, TO_DATE('2018', 'YYYY'), TO_DATE('04', 'MM'), 1, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8109.54, 7722.64, 17, TO_DATE('2018', 'YYYY'), TO_DATE('05', 'MM'), 5, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3948.98, 2699.20, 17, TO_DATE('2018', 'YYYY'), TO_DATE('06', 'MM'), 2, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4492.61, 3862.56, 17, TO_DATE('2018', 'YYYY'), TO_DATE('07', 'MM'), 7, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5987.66, 4669.32, 17, TO_DATE('2018', 'YYYY'), TO_DATE('08', 'MM'), 3, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8666.25, 2439.98, 17, TO_DATE('2018', 'YYYY'), TO_DATE('09', 'MM'), 6, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4846.83, 8452.13, 17, TO_DATE('2018', 'YYYY'), TO_DATE('10', 'MM'), 1, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6986.92, 7142.20, 17, TO_DATE('2018', 'YYYY'), TO_DATE('11', 'MM'), 3, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4453.40, 7609.20, 17, TO_DATE('2018', 'YYYY'), TO_DATE('12', 'MM'), 7, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5813.38, 1315.74, 17, TO_DATE('2019', 'YYYY'), TO_DATE('01', 'MM'), 1, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6848.44, 4821.23, 17, TO_DATE('2019', 'YYYY'), TO_DATE('02', 'MM'), 9, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7910.44, 6678.14, 17, TO_DATE('2019', 'YYYY'), TO_DATE('03', 'MM'), 5, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6903.4, 6009.8, 17, TO_DATE('2019', 'YYYY'), TO_DATE('04', 'MM'), 8, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9567.89, 1240.43, 17, TO_DATE('2019', 'YYYY'), TO_DATE('05', 'MM'), 8, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5451.72, 9012.77, 17, TO_DATE('2019', 'YYYY'), TO_DATE('06', 'MM'), 2, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6709.73, 7977.71, 17, TO_DATE('2019', 'YYYY'), TO_DATE('07', 'MM'), 7, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1164.2, 2090.49, 17, TO_DATE('2019', 'YYYY'), TO_DATE('08', 'MM'), 7, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8893.65, 3413.71, 17, TO_DATE('2019', 'YYYY'), TO_DATE('09', 'MM'), 7, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9138.23, 1878.41, 17, TO_DATE('2019', 'YYYY'), TO_DATE('10', 'MM'), 6, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6896.84, 2760.29, 17, TO_DATE('2019', 'YYYY'), TO_DATE('11', 'MM'), 1, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1245.91, 3137.68, 17, TO_DATE('2019', 'YYYY'), TO_DATE('12', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8138.98, 1644.29, 17, TO_DATE('2020', 'YYYY'), TO_DATE('01', 'MM'), 3, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7919.63, 5917.14, 17, TO_DATE('2020', 'YYYY'), TO_DATE('02', 'MM'), 6, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6838.74, 6192.23, 17, TO_DATE('2020', 'YYYY'), TO_DATE('03', 'MM'), 7, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3077.38, 5274.57, 17, TO_DATE('2020', 'YYYY'), TO_DATE('04', 'MM'), 1, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2993.7, 9331.7, 17, TO_DATE('2020', 'YYYY'), TO_DATE('05', 'MM'), 8, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3726.72, 7548.16, 17, TO_DATE('2020', 'YYYY'), TO_DATE('06', 'MM'), 4, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6817.73, 5226.8, 17, TO_DATE('2020', 'YYYY'), TO_DATE('07', 'MM'), 5, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6903.46, 4494.14, 17, TO_DATE('2020', 'YYYY'), TO_DATE('08', 'MM'), 9, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8687.69, 3232.3, 17, TO_DATE('2020', 'YYYY'), TO_DATE('09', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5648.83, 6688.86, 17, TO_DATE('2020', 'YYYY'), TO_DATE('10', 'MM'), 2, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8797.29, 9178.48, 17, TO_DATE('2020', 'YYYY'), TO_DATE('11', 'MM'), 6, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5692.40, 4853.69, 17, TO_DATE('2020', 'YYYY'), TO_DATE('12', 'MM'), 5, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5914.38, 2564.67, 17, TO_DATE('2021', 'YYYY'), TO_DATE('01', 'MM'), 2, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5584.64, 6849.87, 17, TO_DATE('2021', 'YYYY'), TO_DATE('02', 'MM'), 5, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3401.9, 7301.31, 17, TO_DATE('2021', 'YYYY'), TO_DATE('03', 'MM'), 8, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2575.61, 3487.40, 17, TO_DATE('2021', 'YYYY'), TO_DATE('04', 'MM'), 6, 5);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5498.87, 2482.84, 17, TO_DATE('2021', 'YYYY'), TO_DATE('05', 'MM'), 3, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8161.11, 6243.86, 17, TO_DATE('2021', 'YYYY'), TO_DATE('06', 'MM'), 8, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7178.31, 8672.64, 17, TO_DATE('2021', 'YYYY'), TO_DATE('07', 'MM'), 8, 7);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(5117.87, 8013.73, 17, TO_DATE('2021', 'YYYY'), TO_DATE('08', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(8828.85, 5528.13, 17, TO_DATE('2021', 'YYYY'), TO_DATE('09', 'MM'), 8, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2423.8, 2356.86, 17, TO_DATE('2021', 'YYYY'), TO_DATE('10', 'MM'), 7, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4877.52, 8031.48, 17, TO_DATE('2021', 'YYYY'), TO_DATE('11', 'MM'), 9, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6885.71, 3537.53, 17, TO_DATE('2021', 'YYYY'), TO_DATE('12', 'MM'), 5, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1240.47, 8060.27, 17, TO_DATE('2022', 'YYYY'), TO_DATE('01', 'MM'), 9, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3849.72, 3856.97, 17, TO_DATE('2022', 'YYYY'), TO_DATE('02', 'MM'), 6, 4);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4811.46, 1968.69, 17, TO_DATE('2022', 'YYYY'), TO_DATE('03', 'MM'), 3, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(3036.13, 3559.78, 17, TO_DATE('2022', 'YYYY'), TO_DATE('04', 'MM'), 7, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4993.77, 4586.25, 17, TO_DATE('2022', 'YYYY'), TO_DATE('05', 'MM'), 9, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(9304.85, 5792.55, 17, TO_DATE('2022', 'YYYY'), TO_DATE('06', 'MM'), 5, 3);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1917.90, 7348.22, 17, TO_DATE('2022', 'YYYY'), TO_DATE('07', 'MM'), 1, 6);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(7337.31, 6176.6, 17, TO_DATE('2022', 'YYYY'), TO_DATE('08', 'MM'), 3, 2);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(4241.11, 5386.38, 17, TO_DATE('2022', 'YYYY'), TO_DATE('09', 'MM'), 3, 8);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(1464.21, 4855.39, 17, TO_DATE('2022', 'YYYY'), TO_DATE('10', 'MM'), 3, 1);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(6577.5, 9789.81, 17, TO_DATE('2022', 'YYYY'), TO_DATE('11', 'MM'), 3, 9);
INSERT INTO DadosNegocio(producaoEmToneladas, vendasEmMilharesEuros, idCultura, anoTempo, mesTempo, codigoInternoCliente, hubId) VALUES(2029.14, 8626.37, 17, TO_DATE('2022', 'YYYY'), TO_DATE('12', 'MM'), 7, 8);

