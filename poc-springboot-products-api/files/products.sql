-- Volcando estructura de base de datos para products
CREATE DATABASE IF NOT EXISTS `products`;
USE `products`;

-- Volcando estructura para tabla products.products
CREATE TABLE IF NOT EXISTS `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla products.products: 6 rows
DELETE FROM `products`;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`, `name`) VALUES
	(1, 'producto 1'),
	(2, 'producto 2'),
	(3, 'producto 3'),
	(4, 'producto 4'),
	(5, 'producto 5'),
	(6, 'producto 6');