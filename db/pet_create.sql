-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-12-21 13:25:01.267

-- tables
-- Table: color
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
                     id_code serial  NOT NULL,
                     name varchar(255)  NOT NULL,
                     user_id int  NOT NULL,
                     type_id int  NOT NULL,
                     color_id int  NOT NULL,
                     country_id int  NOT NULL,
                     CONSTRAINT pet_pk PRIMARY KEY (id_code)
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

-- foreign keys
-- Reference: pet_color (table: pet)
ALTER TABLE pet ADD CONSTRAINT pet_color
    FOREIGN KEY (color_id)
        REFERENCES color (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: pet_country (table: pet)
ALTER TABLE pet ADD CONSTRAINT pet_country
    FOREIGN KEY (country_id)
        REFERENCES country (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: pet_type (table: pet)
ALTER TABLE pet ADD CONSTRAINT pet_type
    FOREIGN KEY (type_id)
        REFERENCES type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: pet_user (table: pet)
ALTER TABLE pet ADD CONSTRAINT pet_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

