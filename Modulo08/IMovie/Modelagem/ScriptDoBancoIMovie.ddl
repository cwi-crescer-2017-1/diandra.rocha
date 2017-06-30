-- Gerado por Oracle SQL Developer Data Modeler 4.2.0.932
--   em:        2017-06-30 02:13:30 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE amizade (
    idamizade          INTEGER NOT NULL,
    idusuarioenviou    INTEGER NOT NULL,
    idusuariorecebeu   INTEGER NOT NULL,
    status             VARCHAR2(50) NOT NULL
);

ALTER TABLE amizade ADD CONSTRAINT amizade_pk PRIMARY KEY ( idamizade );

CREATE TABLE comentario (
    idcomentario     VARCHAR2(255) NOT NULL,
    conteudo         VARCHAR2(500) NOT NULL,
    datacomentario   DATE NOT NULL,
    idusuario        INTEGER NOT NULL,
    idpost           INTEGER NOT NULL
);

ALTER TABLE comentario ADD CONSTRAINT comentario_pk PRIMARY KEY ( idcomentario,idpost );

CREATE TABLE curtida (
    idcurtida   INTEGER NOT NULL,
    idpost      INTEGER NOT NULL,
    idusuario   INTEGER NOT NULL
);

ALTER TABLE curtida ADD CONSTRAINT curtida_pk PRIMARY KEY ( idcurtida );

CREATE TABLE post (
    idpost      INTEGER NOT NULL,
    conteudo    VARCHAR2(255) NOT NULL,
    datapost    DATE NOT NULL,
    urlfoto     VARCHAR2(255) NOT NULL,
    idusuario   INTEGER NOT NULL
);

ALTER TABLE post ADD CONSTRAINT post_pk PRIMARY KEY ( idpost );

CREATE TABLE usuario (
    idusuario        INTEGER NOT NULL,
    email            VARCHAR2(255) NOT NULL,
    senha            VARCHAR2(500) NOT NULL,
    nome             VARCHAR2(255) NOT NULL,
    sexo             VARCHAR2(2) NOT NULL,
    datanascimento   DATE NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( idusuario );

ALTER TABLE amizade ADD CONSTRAINT amizade_usuarioe_fk FOREIGN KEY ( idusuarioenviou )
    REFERENCES usuario ( idusuario );

ALTER TABLE amizade ADD CONSTRAINT amizade_usuarior_fk FOREIGN KEY ( idusuariorecebeu )
    REFERENCES usuario ( idusuario );

ALTER TABLE comentario ADD CONSTRAINT comentario_post_fk FOREIGN KEY ( idpost )
    REFERENCES post ( idpost );

ALTER TABLE comentario ADD CONSTRAINT comentario_usuario_fk FOREIGN KEY ( idusuario )
    REFERENCES usuario ( idusuario );

ALTER TABLE curtida ADD CONSTRAINT curtida_post_fk FOREIGN KEY ( idpost )
    REFERENCES post ( idpost );

ALTER TABLE curtida ADD CONSTRAINT curtida_usuario_fk FOREIGN KEY ( idusuario )
    REFERENCES usuario ( idusuario );

ALTER TABLE post ADD CONSTRAINT post_usuario_fk FOREIGN KEY ( idusuario )
    REFERENCES usuario ( idusuario );

CREATE SEQUENCE amizade_idamizade_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER amizade_idamizade_trg BEFORE
    INSERT ON amizade
    FOR EACH ROW
    WHEN (
        new.idamizade IS NULL
    )
BEGIN
    :new.idamizade := amizade_idamizade_seq.nextval;
END;
/

CREATE SEQUENCE comentario_idcomentario_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER comentario_idcomentario_trg BEFORE
    INSERT ON comentario
    FOR EACH ROW
    WHEN (
        new.idcomentario IS NULL
    )
BEGIN
    :new.idcomentario := comentario_idcomentario_seq.nextval;
END;
/

CREATE SEQUENCE curtida_idcurtida_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER curtida_idcurtida_trg BEFORE
    INSERT ON curtida
    FOR EACH ROW
    WHEN (
        new.idcurtida IS NULL
    )
BEGIN
    :new.idcurtida := curtida_idcurtida_seq.nextval;
END;
/

CREATE SEQUENCE post_idpost_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER post_idpost_trg BEFORE
    INSERT ON post
    FOR EACH ROW
    WHEN (
        new.idpost IS NULL
    )
BEGIN
    :new.idpost := post_idpost_seq.nextval;
END;
/

CREATE SEQUENCE usuario_idusuario_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER usuario_idusuario_trg BEFORE
    INSERT ON usuario
    FOR EACH ROW
    WHEN (
        new.idusuario IS NULL
    )
BEGIN
    :new.idusuario := usuario_idusuario_seq.nextval;
END;
/



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                             12
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           5
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          5
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
