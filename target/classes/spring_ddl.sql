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
  `locked` varchar(1) DEFAULT NULL COMMENT 'Y/N',
  `location` varchar(50) DEFAULT NULL COMMENT 'Miqaat location eg: Masjid',
  PRIMARY KEY (`day_id`),
  UNIQUE KEY `day` (`day`)
) ENGINE=InnoDB AUTO_INCREMENT=361 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.days: ~120 rows (approximately)
DELETE FROM `days`;
/*!40000 ALTER TABLE `days` DISABLE KEYS */;
INSERT INTO `days` (`day_id`, `day`, `occasion_type`, `menu`, `description`, `host`, `time`, `locked`, `location`) VALUES
	(241, '2015-01-03', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(242, '2015-01-04', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(243, '2015-01-05', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(244, '2015-01-06', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(245, '2015-01-07', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(246, '2015-01-08', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(247, '2015-01-09', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(248, '2015-01-10', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(249, '2015-01-11', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(250, '2015-01-12', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(251, '2015-01-13', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(252, '2015-01-14', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(253, '2015-01-15', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(254, '2015-01-16', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(255, '2015-01-17', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(256, '2015-01-18', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(257, '2015-01-19', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(258, '2015-01-20', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(259, '2015-01-21', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(260, '2015-01-22', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(261, '2015-01-23', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(262, '2015-01-24', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(263, '2015-01-25', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(264, '2015-01-26', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(265, '2015-01-27', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(266, '2015-01-28', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(267, '2015-01-29', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(268, '2015-01-30', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(269, '2015-01-31', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(270, '2015-02-01', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(271, '2015-02-02', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(272, '2015-02-03', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(273, '2015-02-04', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(274, '2015-02-05', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(275, '2015-02-06', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(276, '2015-02-07', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(277, '2015-02-08', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(278, '2015-02-09', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(279, '2015-02-10', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(280, '2015-02-11', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(281, '2015-02-12', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(282, '2015-02-13', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(283, '2015-02-14', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(284, '2015-02-15', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(285, '2015-02-16', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(286, '2015-02-17', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(287, '2015-02-18', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(288, '2015-02-19', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(289, '2015-02-20', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(290, '2015-02-21', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(291, '2015-02-22', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(292, '2015-02-23', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(293, '2015-02-24', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(294, '2015-02-25', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(295, '2015-02-26', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(296, '2015-02-27', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(297, '2015-02-28', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(298, '2015-03-01', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(299, '2015-03-02', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(300, '2015-03-03', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(301, '2015-03-04', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(302, '2015-03-05', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(303, '2015-03-06', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(304, '2015-03-07', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(305, '2015-03-08', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(306, '2015-03-09', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(307, '2015-03-10', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(308, '2015-03-11', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(309, '2015-03-12', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(310, '2015-03-13', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(311, '2015-03-14', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(312, '2015-03-15', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(313, '2015-03-16', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(314, '2015-03-17', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(315, '2015-03-18', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(316, '2015-03-19', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(317, '2015-03-20', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(318, '2015-03-21', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(319, '2015-03-22', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(320, '2015-03-23', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(321, '2015-03-24', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(322, '2015-03-25', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(323, '2015-03-26', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(324, '2015-03-27', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(325, '2015-03-28', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(326, '2015-03-29', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(327, '2015-03-30', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(328, '2015-03-31', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(329, '2015-04-01', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(330, '2015-04-02', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(331, '2015-04-03', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(332, '2015-04-04', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(333, '2015-04-05', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(334, '2015-04-06', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(335, '2015-04-07', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(336, '2015-04-08', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(337, '2015-04-09', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(338, '2015-04-10', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(339, '2015-04-11', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(340, '2015-04-12', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(341, '2015-04-13', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(342, '2015-04-14', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(343, '2015-04-15', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(344, '2015-04-16', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(345, '2015-04-17', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(346, '2015-04-18', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(347, '2015-04-19', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(348, '2015-04-20', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(349, '2015-04-21', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(350, '2015-04-22', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(351, '2015-04-23', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(352, '2015-04-24', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(353, '2015-04-25', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(354, '2015-04-26', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(355, '2015-04-27', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(356, '2015-04-28', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(357, '2015-04-29', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(358, '2015-04-30', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(359, '2015-05-01', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL),
	(360, '2015-05-02', 'MAWAID', NULL, NULL, NULL, NULL, 'N', NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.roles: ~1 rows (approximately)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`role_id`, `user_id`, `role`) VALUES
	(1, 4, 'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Dumping structure for table spring.rsvp
CREATE TABLE IF NOT EXISTS `rsvp` (
  `rsvp_id` int(11) NOT NULL AUTO_INCREMENT,
  `day_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `thali_count` smallint(6) DEFAULT NULL,
  `thali_size` varchar(1) DEFAULT NULL COMMENT 'S/M/L',
  `location` varchar(20) DEFAULT NULL,
  `adult_count` smallint(6) DEFAULT NULL,
  `child_count` smallint(6) DEFAULT NULL,
  `thali_picked` varchar(1) DEFAULT NULL COMMENT 'Y/N',
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
  `enabled` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.users: ~1 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `name`, `phone1`, `phone2`, `email`, `password`, `enabled`) VALUES
	(4, 'husaind', NULL, NULL, 'husaind@gmail', 'welcome1', 'Y');
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


-- Dumping structure for table spring.user_defaults
CREATE TABLE IF NOT EXISTS `user_defaults` (
  `default_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `thali_count` smallint(6) DEFAULT NULL,
  `thali_size` varchar(1) DEFAULT NULL,
  `adult_count` smallint(6) DEFAULT NULL,
  `child_count` smallint(6) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`default_id`),
  KEY `FK_user_defaults_users` (`user_id`),
  CONSTRAINT `FK_user_defaults_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.user_defaults: ~0 rows (approximately)
DELETE FROM `user_defaults`;
/*!40000 ALTER TABLE `user_defaults` DISABLE KEYS */;
INSERT INTO `user_defaults` (`default_id`, `user_id`, `thali_count`, `thali_size`, `adult_count`, `child_count`, `location`) VALUES
	(1, NULL, 0, NULL, 0, 0, NULL);
/*!40000 ALTER TABLE `user_defaults` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
