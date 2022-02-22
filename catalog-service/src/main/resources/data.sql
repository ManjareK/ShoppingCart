CREATE DATABASE IF NOT EXISTS `catalog`;

use catalog;

CREATE TABLE IF NOT EXISTS `products` (

    `id` int(11) NOT NULL auto_increment,
    `code` varchar(50)  NOT NULL default '',
    `name`  varchar(50) NOT NULL default '',
    `description`  varchar(250) NOT NULL default '',
    `price` int(11)  NULL,
    PRIMARY KEY  (`id`)
    );

CREATE TABLE IF NOT EXISTS hibernate_sequence(next_val bigint);

DELETE FROM products;

insert into products(id, code, name, description, price) VALUES
(1, 'P001', 'Product 1', 'Product 1 description', 25),
(2, 'P002', 'Product 2', 'Product 2 description', 32),
(3, 'P003', 'Product 3', 'Product 3 description', 50)
;