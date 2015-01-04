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
CREATE DATABASE IF NOT EXISTS `spring` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spring`;


-- Dumping structure for table spring.days
CREATE TABLE IF NOT EXISTS `days` (
  `day_id` int(11) NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `occasion_type` varchar(10) DEFAULT NULL COMMENT 'Mawaid / Miqaat',
  `menu` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL COMMENT 'Miqaat Description',
  `host` varchar(100) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL COMMENT 'Time from - to',
  `locked` varchar(1) DEFAULT 'N' COMMENT 'Y/N',
  `location` varchar(50) DEFAULT NULL COMMENT 'Miqaat location eg: Masjid',
  PRIMARY KEY (`day_id`),
  UNIQUE KEY `day` (`day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table spring.days: ~0 rows (approximately)
DELETE FROM `days`;
/*!40000 ALTER TABLE `days` DISABLE KEYS */;
/*!40000 ALTER TABLE `days` ENABLE KEYS */;


-- Dumping structure for table spring.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`user_id`),
  KEY `FK_roles_users` (`user_id`),
  CONSTRAINT `FK_roles_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table spring.roles: ~0 rows (approximately)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Dumping structure for table spring.rsvp
CREATE TABLE IF NOT EXISTS `rsvp` (
  `rsvp_id` int(11) NOT NULL AUTO_INCREMENT,
  `day_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `thali_count` smallint(6) DEFAULT '0',
  `thali_size` varchar(1) DEFAULT NULL COMMENT 'S/M/L',
  `location` varchar(20) DEFAULT NULL,
  `adult_count` smallint(6) DEFAULT '0',
  `child_count` smallint(6) DEFAULT '0',
  `thali_picked` varchar(1) DEFAULT 'N' COMMENT 'Y/N',
  PRIMARY KEY (`rsvp_id`),
  KEY `FK_rsvp_users` (`user_id`),
  KEY `FK_rsvp_days` (`day_id`),
  CONSTRAINT `FK_rsvp_days` FOREIGN KEY (`day_id`) REFERENCES `days` (`day_id`),
  CONSTRAINT `FK_rsvp_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table spring.rsvp: ~0 rows (approximately)
DELETE FROM `rsvp`;
/*!40000 ALTER TABLE `rsvp` DISABLE KEYS */;
/*!40000 ALTER TABLE `rsvp` ENABLE KEYS */;


-- Dumping structure for table spring.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone1` bigint(20) DEFAULT NULL,
  `phone2` bigint(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` varchar(1) DEFAULT 'Y',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.users: ~1 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `name`, `phone1`, `phone2`, `email`, `password`, `enabled`) VALUES
	(1, 'husain', NULL, NULL, 'husain@gmail', 'welcome1', NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping structure for table spring.user_aud
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.user_aud: ~4 rows (approximately)
DELETE FROM `user_aud`;
/*!40000 ALTER TABLE `user_aud` DISABLE KEYS */;
INSERT INTO `user_aud` (`id`, `name_b`, `name_a`, `email_b`, `email_a`, `action`, `action_on`, `action_by`) VALUES
	(1, 'husain2', 'husain2', 'husain@gmail.com', 'husain@gmail.com', NULL, NULL, NULL),
	(2, 'husain2', 'husain2', 'husain@gmail.com', 'husain@gmail.com', NULL, NULL, NULL),
	(3, 'husain2', 'husain2', 'husain@gmail.com', 'husain@gmail.com', 'I', '2014-12-23 18:16:20', 'HDI'),
	(4, 'husain', 'husain', 'husain@gmail', 'husain@gmail', 'I', '2015-01-03 15:45:45', 'HDI');
/*!40000 ALTER TABLE `user_aud` ENABLE KEYS */;


-- Dumping structure for table spring.user_calc
CREATE TABLE IF NOT EXISTS `user_calc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_email` varchar(50) DEFAULT NULL,
  `action_on` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.user_calc: ~2 rows (approximately)
DELETE FROM `user_calc`;
/*!40000 ALTER TABLE `user_calc` DISABLE KEYS */;
INSERT INTO `user_calc` (`id`, `name_email`, `action_on`) VALUES
	(1, 'hello.model.User@2e63f7bb', NULL),
	(2, 'hello.model.User@234f46b2', NULL);
/*!40000 ALTER TABLE `user_calc` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
