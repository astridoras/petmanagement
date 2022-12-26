CREATE TABLE color (
                       id serial  NOT NULL,
                       name varchar(255)  NOT NULL,
                       CONSTRAINT color_pk PRIMARY KEY (id)
);

-- Table: country
CREATE TABLE country (
                         id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         CONSTRAINT country_pk PRIMARY KEY (id)
);

-- Table: pet
CREATE TABLE pet (
                     id serial  NOT NULL,
                     name varchar(255)  NOT NULL,
                     code varchar(255)  NOT NULL,
                     user_id int  NOT NULL,
                     type varchar(255)  NOT NULL,
                     color varchar(255)  NOT NULL,
                     country varchar(255)  NOT NULL,
                     CONSTRAINT pet_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        username varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);


