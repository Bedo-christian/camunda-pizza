/**
 create roles table
*/
CREATE TABLE roles (
id_roles INT NOT NULL AUTO_INCREMENT,
code_role VARCHAR(30) NOT NULL,
nom_role VARCHAR(100) NOT NULL,
PRIMARY KEY (id_roles)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
-----table utilisateur
*/
CREATE TABLE utilisateur(
id_user INT NOT NULL AUTO_INCREMENT,
identifiant VARCHAR(100) NOT NULL UNIQUE,
`password` VARCHAR(200) NOT NULL,

PRIMARY KEY(id_user)
);

/**
or replace roles_user
*/
CREATE or REPLACE TABLE `roles_user` (
    `user_id` INT NOT NULL,
    `roles_id` INT NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `roles_fk_idx` (`roles_id`),
    CONSTRAINT `roles_fk` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id_roles`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `utilisateur` (`id_user`)
);

/*
-----table pizza
*/
CREATE TABLE pizza(
id_pizza INT NOT NULL AUTO_INCREMENT,
nom VARCHAR(100) NOT NULL,
type VARCHAR(100) NOT NULL,
description VARCHAR(200) NOT NULL,
image VARCHAR(100) NOT NULL,
PRIMARY KEY (id_pizza)
);


/*
-----table clients
*/
CREATE TABLE `client`(
id_client INT NOT NULL AUTO_INCREMENT,
nom_client VARCHAR(200) NOT NULL,
`adresse` VARCHAR(200) NOT NULL,
rue VARCHAR(10) NOT NULL,
ville VARCHAR(100) NOT NULL,
`code_postal` VARCHAR(10) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`telephon` VARCHAR(11) NOT NULL,

PRIMARY KEY (id_client)
);

 /*
 -----table commande
*/
 CREATE TABLE commande(
 id_commande INT NOT NULL AUTO_INCREMENT,
 id_client INT,
 id_pizza INT,
 date_commande DATETIME,
 status VARCHAR(50) NOT NULL,
PRIMARY KEY(id_commande),
FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
FOREIGN KEY (`id_pizza`) REFERENCES `pizza` (`id_pizza`)
 )
