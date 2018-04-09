-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.21-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных roomreservation
CREATE DATABASE IF NOT EXISTS `roomreservation` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `roomreservation`;

-- Дамп структуры для таблица roomreservation.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `id` int(11) NOT NULL,
  `idEmployee` int(11) NOT NULL,
  `idRoom` int(11) NOT NULL,
  `date` date NOT NULL,
  `timeStart` time NOT NULL,
  `timeEnd` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_booking_employee` (`idEmployee`),
  KEY `FK_booking_room` (`idRoom`),
  CONSTRAINT `FK_booking_employee` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_booking_room` FOREIGN KEY (`idRoom`) REFERENCES `room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы roomreservation.booking: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` (`id`, `idEmployee`, `idRoom`, `date`, `timeStart`, `timeEnd`) VALUES
	(1, 2, 2, '2018-04-06', '15:48:36', '16:48:41'),
	(2, 2, 3, '2018-04-06', '16:50:05', '17:49:19');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;

-- Дамп структуры для таблица roomreservation.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `patronymic` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы roomreservation.employee: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `name`, `surname`, `patronymic`, `login`, `password`) VALUES
	(1, 'admin', 'admin', 'amdin', 'admin', 'admin'),
	(2, 'user', 'user', 'user', 'user', 'user');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Дамп структуры для таблица roomreservation.room
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL,
  `number` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы roomreservation.room: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`id`, `number`) VALUES
	(1, '1'),
	(2, '2'),
	(3, '3'),
	(4, '4'),
	(5, '5');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
