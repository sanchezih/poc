DROP DATABASE IF EXISTS `reactiveprograming`;

-- Volcando estructura de base de datos para reactiveprograming
CREATE DATABASE IF NOT EXISTS `reactiveprograming`;
USE `reactiveprograming`;

-- Volcando estructura para tabla reactiveprograming.book
CREATE TABLE IF NOT EXISTS `book` (
  `id` int NOT NULL,
  `title` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `author` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  KEY `book_pk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reactiveprograming.book: ~8 rows (aproximadamente)
DELETE FROM `book`;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`id`, `title`, `author`) VALUES
	(1, 'El principito', 'Antoine de Saint-Exupery'),
	(2, 'La metamorfosis', 'Franz Kafka'),
	(3, 'Orgullo y prejuicio', 'Jane Austen'),
	(4, 'Don Quijote de la Mancha', 'Miguel de Cervantes Saavedra'),
	(5, 'Romeo y Julieta', 'William Shakespeare'),
	(6, 'Cumbres borrascosas', 'Emily Bronte'),
	(7, 'El retrato de Dorian Gray', 'Oscar Wilde'),
	(8, 'Dracula', 'Bram Stoker');
	
SELECT * FROM reactiveprograming.book;