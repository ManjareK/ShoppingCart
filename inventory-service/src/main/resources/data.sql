CREATE TABLE IF NOT EXISTS `inventory` (

                                          `id` int(11) NOT NULL auto_increment,
                                          `product_code`  varchar(250) NOT NULL default '',
                                          `quantity` int(11)  NULL,
                                          PRIMARY KEY  (`id`)
);

DELETE FROM inventory;

insert into inventory(id, product_code, quantity) VALUES
(1, 'P001', 250),
(2, 'P002', 132),
(3, 'P003', 0)
;