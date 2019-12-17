DROP DATABASE IF EXISTS party;

CREATE DATABASE party DEFAULT CHARACTER SET utf8;

ALTER USER 'diana' IDENTIFIED WITH mysql_native_password BY '1073277';

USE party;

create table party
(
    id               int auto_increment
        primary key,
    address          varchar(255) not null,
    date             datetime     not null,
    name             varchar(255) not null,
    status           int          not null
)
    ENGINE = INNODB;

create table party_products
(
    party_id    int not null,
    products_id int not null
)
    ENGINE = INNODB;

create table party_users
(
    party_id int not null,
    users_id int not null
)
    ENGINE = INNODB;

create table product
(
    id              int auto_increment
        primary key,
    name            varchar(255) not null,
    price           double       not null,
    product_type_id int          not null,
    measure varchar(255) not null
)
    ENGINE = INNODB;

create table product_type
(
    id    int auto_increment
        primary key,
    value varchar(255) not null
)
    ENGINE = INNODB;

create table task
(
    id            int auto_increment
        primary key,
    money         double,
    task_status   int    not null,
    party_id int    not null,
    product_id    int    not null,
    user_id  int    not null
)
    ENGINE = INNODB;

create table user
(
    id       int auto_increment
        primary key,
    login    varchar(255) not null,
    password varchar(255) not null,
    name varchar(255),
    email varchar(255)
)
    ENGINE = INNODB;


ALTER TABLE party_products
  ADD FOREIGN KEY (party_id) REFERENCES party (id)
    ON UPDATE cascade
    ON DELETE cascade ;

ALTER TABLE party_products
  ADD FOREIGN KEY (products_id) REFERENCES product (id)
    ON UPDATE cascade
    ON DELETE cascade ;

ALTER TABLE party_users
  ADD FOREIGN KEY (party_id) REFERENCES party (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE party_users
  ADD FOREIGN KEY (users_id) REFERENCES user (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE product
  ADD FOREIGN KEY (product_type_id) REFERENCES product_type (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE task
  ADD FOREIGN KEY (party_id) REFERENCES party (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE task
  ADD FOREIGN KEY (product_id) REFERENCES product (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE task
  ADD FOREIGN KEY (user_id) REFERENCES user (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

INSERT INTO product_type (id, value) VALUES (1, 'MEAT');
INSERT INTO product_type (id, value) VALUES (2, 'ALCOHOL');
INSERT INTO product_type (id, value) VALUES (3, 'FRUITS');
INSERT INTO product_type (id, value) VALUES (4, 'VEGETABLES');
INSERT INTO product_type (id, value) VALUES (5, 'ALCOHOL');
INSERT INTO product_type (id, value) VALUES (6, 'NO-ALC DRINKS');
INSERT INTO product_type (id, value) VALUES (7, 'OTHER');



