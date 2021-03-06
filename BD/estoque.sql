-- Criando o banco de dados;
DROP DATABASE IF EXISTS estoque;
CREATE DATABASE IF NOT EXISTS estoque DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;

-- Selecionando o banco de dados;
USE estoque;

-- Criando a tabela pessoa;
CREATE TABLE tblpessoa(
pes_id INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
pes_tipo VARCHAR(15) NOT NULL,
pes_nome VARCHAR(50) NOT NULL,
pes_rg VARCHAR(15) NULL,
pes_cpf VARCHAR(15) NULL,
pes_endereco VARCHAR(50) NOT NULL,
pes_bairro VARCHAR(30) NOT NULL,
pes_cidade VARCHAR(30) NOT NULL,
pes_fone VARCHAR(15) NOT NULL,
pes_email VARCHAR(30) NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Inserindo os dados na tabela pessoa;
INSERT INTO tblpessoa (pes_id, pes_tipo, pes_nome, pes_rg, pes_cpf, pes_endereco, pes_bairro, pes_cidade, pes_fone, pes_email) VALUES 
	(1,"Funcionario","ADM","","111.111.111.11","RUA 1","UM","A","(11)1111-1111",""),
	(2,"Fornecedor","FRN","","222.222.222.22","RUA 2","DOIS","B","(22)2222-2222","");

-- Criando a tabela usuario;
CREATE TABLE tblusuario(
pes_id INT(6) NOT NULL AUTO_INCREMENT,
login VARCHAR(50) NOT NULL,
senha VARCHAR(8) NOT NULL,
id_tipo INT(2) NOT NULL,
tipo VARCHAR(15) NOT NULL,
id_nivel INT(2) NOT NULL,
nivel VARCHAR(15) NOT NULL,
PRIMARY KEY (pes_id),
UNIQUE INDEX id_UNIQUE (pes_id ASC),
CONSTRAINT fk_usuario FOREIGN KEY(pes_id) REFERENCES tblpessoa(pes_id) ON DELETE NO ACTION ON UPDATE NO ACTION 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Inserindo os dados na tabela usuario;
INSERT INTO tblusuario (pes_id, login, senha, id_tipo, tipo, id_nivel, nivel) VALUES
	(1,"ADMIN","admin123",1,"Funcionário",1,"Administrador");

-- Criando View dos usuários;	
CREATE VIEW View_Usuarios AS
SELECT u.pes_id, p.pes_nome AS nome, u.tipo, u.nivel, u.login 
FROM tblusuario AS u
INNER JOIN tblpessoa AS p ON p.pes_id = u.pes_id;	
	
-- Criando a tabela pedido;
CREATE TABLE tblpedido(
ped_cod INT(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
ped_data DATE NOT NULL,
ped_tipo CHAR NOT NULL,
pes_id INT(6) NOT NULL,
ped_destino VARCHAR(50) NOT NULL,
PRIMARY KEY(ped_cod),
CONSTRAINT fk_pes_id FOREIGN KEY(pes_id) REFERENCES tblpessoa(pes_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;	

-- Criando a tabela tipo de unidade de medida;
CREATE TABLE tbltipo(
tipo_cod INT(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
tipo_desc VARCHAR(25) NOT NULL,
tipo_sigla VARCHAR(3) NOT NULL,
PRIMARY KEY (tipo_cod)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Inserindo os dados na tabela tipo;
INSERT INTO tbltipo (tipo_cod, tipo_desc, tipo_sigla) VALUES 
	(1,'UNIDADE','UNI'),
	(2,'PAR','PAR'),
	(3,'PACOTE','PCT'),
	(4,'GALÃO','GAL');

-- Criando a tabela categoria;
CREATE TABLE tblcategoria(
cat_cod INT(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
cat_tipo VARCHAR(25) NOT NULL,
PRIMARY KEY (cat_cod)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Inserindo os dados na tabela categoria;
INSERT INTO tblcategoria (cat_cod, cat_tipo) VALUES 
	(1,'LIMPEZA'),
	(2,'ESCRITORIO');

-- Criando a tabela produto;
CREATE TABLE tblproduto(
prod_cod INT(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
prod_desc VARCHAR(50) NOT NULL,
prod_qtde INT(6) NOT NULL,
-- prod_tipo VARCHAR(3) NOT NULL,
prod_min INT(6) NOT NULL,
tipo_cod INT(6) UNSIGNED ZEROFILL NOT NULL,
cat_cod INT(6) UNSIGNED ZEROFILL NOT NULL,
PRIMARY KEY (prod_cod),
CONSTRAINT fk_tipo FOREIGN KEY(tipo_cod) REFERENCES tbltipo(tipo_cod),
CONSTRAINT fk_categoria FOREIGN KEY(cat_cod) REFERENCES tblcategoria(cat_cod)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;				

-- Inserindo os dados na tabela produto;
INSERT INTO tblproduto (prod_cod, prod_desc, prod_qtde, tipo_cod, prod_min, cat_cod) VALUES
	(1,'AGUA SANITARIA 1L',0,1,1,1),
	(2,'ALCOOL 1L',0,1,1,1),
	(3,'BALDE PLASTICO 20L',0,1,1,1),
	(4,'CLORO 5L',0,4,1,1),
	(5,'DESENTUPIDOR DE PIA (PEQUENO)',0,1,1,1),
	(6,'DESENTUPIDOR DE PIA C/ CABO (GRANDE)',0,1,1,1),
	(7,'DESINFETANTE 2L',0,1,1,1),
	(8,'DETERGENTE LIQUIDO 5L',0,4,1,1),
	(9,'ESPATULA DE INOX P/ PINTURA',0,1,1,1),
	(10,'ESPONJA DE ACO',0,1,1,1),
	(11,'ESPONJA DUPLA FACE MULTIUSO',0,1,1,1),
	(12,'LIMPADOR DE VASO SANITARIO',0,1,1,1),
	(13,'LIMPADOR INSTANTANEO MULTIUSO 500ml',0,1,1,1),
	(14,'LUVA DE LATEX',0,2,1,1),
	(15,'PA DE LIXO S/ SERRILHA',0,1,1,1),
	(16,'PANO DE CHAO ALVEJADO',0,1,1,1),
	(17,'PANO MULTIUSO C/ FURINHOS',0,3,1,1),
	(18,'PAPEL HIGIENICO 10cm X 300m CAIXA C/ 08 uni',0,3,1,1),
	(19,'PAPEL TOALHA 21cm X 23cm PACOTE C/ 1000 FOLHAS',0,3,1,1),
	(20,'REFIL P/ VASSOURA MOPP',0,1,1,1),
	(21,'RESERVATORIO PARA SABONETEIRA',0,1,1,1),
	(22,'RODO DE MADEIRA 60cm (GRANDE)',0,1,1,1),
	(23,'RODO DE MADEIRA (PEQUENO)',0,1,1,1),
	(24,'SABAO EM PO 1Kg',0,3,1,1),
	(25,'SABONETE LIQUIDO 5L',0,4,1,1),
	(26,'SACO DE LIXO 15L PRETO',0,1,1,1),
	(27,'SACO DE LIXO 50L PRETO',0,1,1,1),
	(28,'SACO DE LIXO 100L PRETO',0,1,1,1),
	(29,'SUPORTE DE PAREDE P/ PAPEL HIGIENICO',0,1,1,1),
	(30,'VASSOURA DE PALHA',0,1,1,1),
	(31,'VASSOURA DE NYLON PEQUENA',0,1,1,1);

-- Criando a tabela item;
CREATE TABLE tblitem(
item_cod INT(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
-- item_tipo VARCHAR(3) NOT NULL,
item_qtde INT(6) NOT NULL,
item_valor FLOAT(6) NOT NULL,
ped_cod INT(6) UNSIGNED ZEROFILL NOT NULL,
prod_cod INT(6) UNSIGNED ZEROFILL NOT NULL,
PRIMARY KEY(item_cod),
CONSTRAINT fk_pedido FOREIGN KEY(ped_cod) REFERENCES tblpedido(ped_cod) ON DELETE NO ACTION ON UPDATE NO ACTION,	
CONSTRAINT fk_produto FOREIGN KEY(prod_cod) REFERENCES tblproduto(prod_cod) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- #########################################################################################################################################################	

-- Criando a tabela de Pessoas Excluídas;
-- DROP TABLE IF EXISTS arquivopes;
CREATE TABLE IF NOT EXISTS arquivopes(
p_id int(6) not null PRIMARY KEY,
p_tipo varchar(15) NOT NULL,
p_nome varchar(50) NOT NULL,
p_rg varchar(15) NULL,
p_cpf varchar(15) NULL,
p_endereco varchar(50) NOT NULL,
p_bairro varchar(30) NOT NULL,
p_cidade varchar(30) NOT NULL,
p_fone varchar(15) NOT NULL,
p_email varchar(30) NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;;

-- Criando a tabela de Produtos Excluídos;
-- DROP TABLE IF EXISTS arquivoprod;
CREATE TABLE IF NOT EXISTS arquivoprod(
prod_cod int(6) NOT NULL,
prod_desc varchar(50) NOT NULL,
prod_tipo varchar(25) NOT NULL,
cat_cod int(6) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;;

-- *********************************************** TRIGGERS ************************************************************************************************

-- TRIGGER(gatilho) Pessoas;
-- DROP TRIGGER IF EXISTS pes;
DELIMITER //
CREATE TRIGGER pes BEFORE DELETE ON tblpessoa
FOR EACH ROW 
BEGIN
    INSERT INTO arquivopes VALUES (OLD.pes_id, OLD.pes_tipo, OLD.pes_nome, OLD.pes_rg, OLD.pes_cpf, OLD.pes_endereco, OLD.pes_bairro, OLD.pes_cidade, OLD.pes_fone, OLD.pes_email);     	     
END //
DELIMITER ;


-- TRIGGER(gatilho) Produtos;
-- DROP TRIGGER IF EXISTS prod;
DELIMITER //
CREATE TRIGGER prod BEFORE DELETE ON tblproduto
FOR EACH ROW 
BEGIN
    INSERT INTO arquivoprod VALUES (OLD.prod_cod, OLD.prod_desc, OLD.tipo_cod, OLD.cat_cod);     	     
END //
DELIMITER ;


-- TRIGGER(gatilho) Verifica Pessoa antes de Inserir
-- DROP TRIGGER IF EXISTS incluirPessoa;
DELIMITER //
CREATE TRIGGER incluirPessoa BEFORE INSERT ON tblpessoa
FOR EACH ROW
	BEGIN
		DECLARE estatus BOOLEAN DEFAULT FALSE;
		DECLARE pes_nome VARCHAR(50);
		SET pes_nome = NEW.pes_nome;
		
		CALL exibirPessoaExcluida(pes_nome, estatus);
		IF estatus THEN
			DELETE FROM arquivopes WHERE pes_nome = pes_nome;
		END IF;
	END //
DELIMITER ;


-- TRIGGER(gatilho) Verifica Produto antes de Inserir
-- DROP TRIGGER IF EXISTS incluirProduto;
DELIMITER //
CREATE TRIGGER incluirProduto BEFORE INSERT ON tblproduto
FOR EACH ROW
	BEGIN
		DECLARE estatus BOOLEAN DEFAULT FALSE;
		DECLARE prod_desc VARCHAR(50);
		SET prod_desc = NEW.prod_desc;
		
		CALL exibirProdutoExcluido(prod_desc, estatus);
		IF estatus THEN
			DELETE FROM arquivoprod WHERE prod_desc = prod_desc;
		END IF;
	END //
DELIMITER ;

-- *********************************************** PROCEDURES ***********************************************************************************************

-- PROCEDURE Salva Pessoas Excluidas
-- DROP PROCEDURE IF EXISTS arquivopes;
DELIMITER //
CREATE PROCEDURE arquivopes(IN cp varchar(6))
BEGIN
DECLARE fim INT DEFAULT FALSE;
DECLARE idpes int(6);
DECLARE tipopes varchar(15);
DECLARE nomepes varchar(50);
DECLARE rgpes varchar(15);
DECLARE cpfpes varchar(15);
DECLARE enderecopes varchar(50);
DECLARE bairropes varchar(30);
DECLARE cidadepes varchar(30);
DECLARE fonepes varchar(15);
DECLARE emailpes varchar(30);
DECLARE pes CURSOR FOR SELECT * FROM
				estoque.tblpessoa AS lp WHERE pes_nome=cp;
DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET fim = TRUE;
OPEN pes;
read_loop: LOOP
			FETCH pes INTO idpes, tipopes, nomepes, rgpes, cpfpes, enderecopes, bairropes, cidadepes, fonepes, emailpes; -- FETCH = lê a tabela
				IF fim THEN LEAVE read_loop;
				END IF;
				INSERT INTO estoque.arquivopes VALUES (idpes, tipopes, nomepes, rgpes, cpfpes, enderecopes, bairropes, cidadepes, fonepes, emailpes);
			END LOOP;
CLOSE pes;
END //
DELIMITER ;


-- PROCEDURE Salva Produtos Excluidos
-- DROP PROCEDURE IF EXISTS arquivoprod;
DELIMITER //
CREATE PROCEDURE arquivoprod(IN cpr varchar(6))
BEGIN
DECLARE fim INT DEFAULT FALSE;
DECLARE codprod int(6);
DECLARE descprod varchar(50);
DECLARE tipoprod varchar(25);
DECLARE prod CURSOR FOR SELECT * FROM
				estoque.tblproduto AS lpr WHERE prod_desc=cpr;
DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET fim = TRUE;
OPEN prod;
read_loop: LOOP
			FETCH prod INTO codprod, descprod, tipoprod; -- FETCH = lê a tabela
				IF fim THEN LEAVE read_loop;
				END IF;
				INSERT INTO estoque.arquivoprod VALUES (codprod, descprod, tipoprod);
			END LOOP;
CLOSE prod;
END //
DELIMITER ;


-- PROCEDURE Recuperar Pessoas Excluidas
-- DROP PROCEDURE IF EXISTS recarquivopes;
DELIMITER //
CREATE PROCEDURE recarquivopes(IN rp varchar(6))
BEGIN  
DECLARE fim INT DEFAULT FALSE;  
DECLARE ridpes int(6);
DECLARE rtipopes varchar(15);
DECLARE rnomepes varchar(50);
DECLARE rrgpes varchar(15);
DECLARE rcpfpes varchar(15);
DECLARE renderecopes varchar(50);
DECLARE rbairropes varchar(30);
DECLARE rcidadepes varchar(30);
DECLARE rfonepes varchar(15);
DECLARE remailpes varchar(30);
DECLARE rpes CURSOR FOR SELECT * FROM 
		arquivopes WHERE pes_nome=rp;  
DECLARE CONTINUE HANDLER FOR NOT FOUND 
                    SET fim = TRUE;  
OPEN rpes;
read_loop:  LOOP
				FETCH rpes INTO ridpes, rtipopes, rnomepes, rrgpes, rcpfpes, renderecopes, rbairropes, rcidadepes, rfonepes, remailpes;	   
				IF fim THEN LEAVE read_loop;   
				END IF;	   
				INSERT INTO estoque.tblpessoa VALUES (ridpes, rtipopes, rnomepes, rrgpes, rcpfpes, renderecopes, rbairropes, rcidadepes, rfonepes, remailpes); 
				DELETE FROM estoque.arquivopes WHERE pes_nome=rp;
			END LOOP; 
CLOSE rpes;
 END //
DELIMITER ;


-- PROCEDURE Recuperar Produtos Excluidos
-- DROP PROCEDURE IF EXISTS recarquivoprod;
DELIMITER //
CREATE PROCEDURE recarquivoprod(IN rpr varchar(6))
BEGIN  
DECLARE fim INT DEFAULT FALSE;  
DECLARE rprodcod int(6);
DECLARE rproddesc varchar(50);
DECLARE rprodtipo varchar(25);
DECLARE rprod CURSOR FOR SELECT * FROM 
		arquivoprod WHERE prod_desc=rpr;  
DECLARE CONTINUE HANDLER FOR NOT FOUND 
                    SET fim = TRUE;  
OPEN rprod;
read_loop:  LOOP
				FETCH rprod INTO rprodcod, rproddesc, rprodtipo;	   
				IF fim THEN LEAVE read_loop;   
				END IF;	   
				INSERT INTO estoque.tblproduto VALUES (rprodcod, rproddesc, rprodtipo); 
				DELETE FROM estoque.arquivoprod WHERE prod_desc=rpr;
			END LOOP; 
CLOSE rprod;
 END //
DELIMITER ;


-- PROCEDURE Exclui mortopes e exibe na tabela pessoa
-- DROP PROCEDURE IF EXISTS exibirPessoaExcluida;
DELIMITER //
CREATE PROCEDURE exibirPessoaExcluida(IN p_nome VARCHAR(50), OUT estatus BOOLEAN)
	BEGIN
		DECLARE fim INT DEFAULT FALSE;
		DECLARE cp VARCHAR(50);
		DECLARE pessoam CURSOR FOR SELECT p_nome FROM estoque.arquivopes AS mp WHERE mp.p_nome = p_nome;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET fim = TRUE;
		OPEN pessoam;
			FETCH pessoam INTO cp;
			IF fim = TRUE then
				SET estatus = FALSE;
			ELSE
				SET estatus = TRUE;
			END IF;
		CLOSE pessoam;
	END // 
DELIMITER ;


-- PROCEDURE Exclui mortoprod e exibe na tabela produto
-- DROP PROCEDURE IF EXISTS exibirProdutosExcluido;
DELIMITER //
CREATE PROCEDURE exibirProdutoExcluido(IN prod_desc VARCHAR(50), OUT estatus BOOLEAN)
	BEGIN
		DECLARE fim INT DEFAULT FALSE;
		DECLARE cpr VARCHAR(50);
		DECLARE prodm CURSOR FOR SELECT mpr.prod_desc FROM estoque.arquivoprod AS mpr WHERE mpr.prod_desc = prod_desc;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET fim = TRUE;
		OPEN prodm;
			FETCH prodm INTO cpr;
			IF fim = TRUE then
				SET estatus = FALSE;
			ELSE
				SET estatus = TRUE;
			END IF;
		CLOSE prodm;
	END // 
DELIMITER ;