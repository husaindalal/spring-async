-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for spring
DROP DATABASE IF EXISTS `spring`;
CREATE DATABASE IF NOT EXISTS `spring` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spring`;


-- Dumping structure for table spring.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.users: ~1 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `name`, `email`) VALUES
	(8, 'husain2', 'husain@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping structure for table spring.user_aud
DROP TABLE IF EXISTS `user_aud`;
CREATE TABLE IF NOT EXISTS `user_aud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_b` varchar(50) DEFAULT NULL,
  `name_a` varchar(50) DEFAULT NULL,
  `email_b` varchar(50) DEFAULT NULL,
  `email_a` varchar(50) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_on` timestamp NULL DEFAULT NULL,
  `action_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.user_aud: ~3 rows (approximately)
DELETE FROM `user_aud`;
/*!40000 ALTER TABLE `user_aud` DISABLE KEYS */;
INSERT INTO `user_aud` (`id`, `name_b`, `name_a`, `email_b`, `email_a`, `action`, `action_on`, `action_by`) VALUES
	(1, 'husain2', 'husain2', 'husain@gmail.com', 'husain@gmail.com', NULL, NULL, NULL),
	(2, 'husain2', 'husain2', 'husain@gmail.com', 'husain@gmail.com', NULL, NULL, NULL),
	(3, 'husain2', 'husain2', 'husain@gmail.com', 'husain@gmail.com', 'I', '2014-12-23 18:16:20', 'HDI');
/*!40000 ALTER TABLE `user_aud` ENABLE KEYS */;


-- Dumping structure for table spring.user_calc
DROP TABLE IF EXISTS `user_calc`;
CREATE TABLE IF NOT EXISTS `user_calc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_email` varchar(50) DEFAULT NULL,
  `action_on` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.user_calc: ~1 rows (approximately)
DELETE FROM `user_calc`;
/*!40000 ALTER TABLE `user_calc` DISABLE KEYS */;
INSERT INTO `user_calc` (`id`, `name_email`, `action_on`) VALUES
	(1, 'hello.model.User@2e63f7bb', NULL);
/*!40000 ALTER TABLE `user_calc` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
