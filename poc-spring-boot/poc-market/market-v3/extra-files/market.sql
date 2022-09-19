-- Volcando estructura de base de datos para market
CREATE DATABASE IF NOT EXISTS `market`;
USE `market`;

-- Volcando estructura para tabla market.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cost` decimal(19,2) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type_product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfkrbelgnteuty2c98jmaowfq4` (`type_product_id`),
  CONSTRAINT `FKfkrbelgnteuty2c98jmaowfq4` FOREIGN KEY (`type_product_id`) REFERENCES `type_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla market.product: ~0 rows (aproximadamente)
DELETE FROM `product`;

-- Volcando estructura para tabla market.type_product
CREATE TABLE IF NOT EXISTS `type_product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ya14cog1g5c6ko4ix0ki7c5k` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla market.type_product: ~0 rows (aproximadamente)
DELETE FROM `type_product`;

INSERT INTO `type_product` (`id`, `name`) VALUES
	(1, 'Fruta'),
	(2, 'Verdura');
