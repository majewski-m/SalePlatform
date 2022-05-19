CREATE SCHEMA IF NOT EXISTS `sale_platform`;
USE `sale_platform`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(64) NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES
	(1,'john.williams@gmail.com','$2a$12$nNTKUmxK7b/ut9jGoSXyDu0pTIZHkNfMb3Ust3SNbyUZwt.SemLwq', 'John', 'Williams'),
	(2,'james.smith@gmail.com','$2a$12$nNTKUmxK7b/ut9jGoSXyDu0pTIZHkNfMb3Ust3SNbyUZwt.SemLwq', 'James', 'Smith'),
	(3,'jacob.brown@gmail.com','$2a$12$nNTKUmxK7b/ut9jGoSXyDu0pTIZHkNfMb3Ust3SNbyUZwt.SemLwq', 'Jacob', 'Brown');

UNLOCK TABLES;

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `price` DECIMAL(10, 2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `end_date` DATE NOT NULL,
  `seller_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_USER_idx` (`seller_id`),
  
  CONSTRAINT `FK_USER` 
  FOREIGN KEY (`seller_id`) 
  REFERENCES `users` (`id`) 
  
  ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

LOCK TABLES `products` WRITE;

INSERT INTO `products` VALUES
	(1, 'item1', 'description1', '12345.23', '124', '2022-05-08 13:12', '2022-06-08', 1),
	(2, 'item2', 'description2', '123445.23', '57', '2022-05-06 11:13', '2022-06-30', 1),
	(3, 'item3', 'description3', '132345.23', '15', '2022-05-09 09:32', '2022-06-11', 1),
	(4, 'item4', 'description4', '345.23', '45', '2022-05-11 05:42', '2022-06-23', 2),
	(5, 'item5', 'description5', '33312345.23', '35', '2022-05-15 23:22', '2022-06-09', 3);

UNLOCK TABLES;

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity_sold` int(255) NOT NULL,
  `sale_time` DATETIME NOT NULL,
  `buyer_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_buyer` (`buyer_id`),
  KEY `fk_product` (`product_id`),
  CONSTRAINT `fk_buyer` FOREIGN KEY (`buyer_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

LOCK TABLES `sales` WRITE;

INSERT INTO `sales` VALUES
	(1, 52, '2022-05-19 14:47', 1, 1),
	(2, 2, '2022-05-19 14:47', 1, 2),
	(3, 4, '2022-05-19 14:47', 1, 3);

UNLOCK TABLES;

SET FOREIGN_KEY_CHECKS = 0;