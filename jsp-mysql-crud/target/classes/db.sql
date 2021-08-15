# Dumping database structure for userdb
DROP DATABASE IF EXISTS `userdb`;
CREATE DATABASE IF NOT EXISTS `userdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `userdb`;

# Dumping structure for table userdb.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(45) DEFAULT NULL,
    `lastname` VARCHAR(45) DEFAULT NULL,
    `dob` DATE DEFAULT NULL,
    `email` VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=UTF8;

# Inserts
INSERT INTO `users` (`id`, `firstname`, `lastname`, `dob`, `email`) VALUES
	(1, 'Juan', 'Perez', '1984-11-23', 'juan@perez.com'),
	(2, 'Maria', 'Fernandez', '1988-07-07', 'maria@fernandez.com');