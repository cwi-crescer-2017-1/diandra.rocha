CREATE TABLE amizade (
    idamizade          INTEGER NOT NULL,
    idusuarioenviou    INTEGER NOT NULL,
    idusuariorecebeu   INTEGER NOT NULL,
    status             VARCHAR2(50) NOT NULL
);
ALTER TABLE amizade ADD CONSTRAINT amizade_uc UNIQUE (idusuarioenviou, idusuariorecebeu);
ALTER TABLE amizade ADD CONSTRAINT amizade_pk PRIMARY KEY ( idamizade );

CREATE TABLE comentario (
    idcomentario     INTEGER NOT NULL,
    conteudo         VARCHAR2(500) NOT NULL,
    datacomentario   DATE NOT NULL,
    idusuario        INTEGER NOT NULL,
    idpost           INTEGER NOT NULL
);

ALTER TABLE comentario ADD CONSTRAINT comentario_pk PRIMARY KEY ( idcomentario );

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