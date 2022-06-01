CREATE DATABASE marketi;

USE marketi;

CREATE TABLE produto (
	id CHAR(4) NOT NULL PRIMARY KEY,
    marca VARCHAR(45) NOT NULL,
    modelo VARCHAR(45) NOT NULL,
    lote VARCHAR(45) NOT NULL,
    preco FLOAT NOT NULL,
    categoria VARCHAR(45) NOT NULL
    );
    
CREATE TABLE monitor (
	id CHAR(4) NOT NULL,
    tamanho INT NOT NULL,
    taxadeatualizacao INT NOT NULL,
    resolucao VARCHAR(45) NOT NULL,
    tipodetela VARCHAR(45) NOT NULL,
    FOREIGN KEY (id) REFERENCES produto(id) ON DELETE CASCADE
    );
    
CREATE TABLE computador (
	id CHAR(4) NOT NULL,
    memoriaram INT NOT NULL,
    armazenamento INT NOT NULL,
    sistemaoperacional VARCHAR(45) NOT NULL,
    FOREIGN KEY (id) REFERENCES produto(id) ON DELETE CASCADE
    );

CREATE TABLE auricular (
	id CHAR(4) NOT NULL,
    impedancia INT NOT NULL,
    sensibilidade INT NOT NULL,
    conexao VARCHAR(45) NOT NULL,
    FOREIGN KEY (id) REFERENCES produto(id) ON DELETE CASCADE
    );