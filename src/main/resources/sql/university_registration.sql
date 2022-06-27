-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.29 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para university_registration
CREATE DATABASE IF NOT EXISTS `university_registration` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `university_registration`;

-- Volcando estructura para tabla university_registration.course
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` char(200) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `course_id` (`course_id`),
  UNIQUE KEY `course_name` (`course_name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- Volcando datos para la tabla university_registration.course: ~0 rows (aproximadamente)
INSERT INTO `course` (`course_id`, `course_name`) VALUES
	(13, 'Comunicación'),
	(1, 'Geografía'),
	(14, 'Java EE'),
	(2, 'Matemáticas');

-- Volcando estructura para tabla university_registration.course_like
CREATE TABLE IF NOT EXISTS `course_like` (
  `course_like_student_id` int NOT NULL,
  `course_like_course_id` int NOT NULL,
  `course_like_rating` smallint NOT NULL,
  KEY `FK2a6l09b3hyxwnnaw7y7sc5prq` (`course_like_course_id`),
  KEY `FKl4ysdrmsyvm52f4yjwwa6xpu6` (`course_like_student_id`),
  CONSTRAINT `FK2a6l09b3hyxwnnaw7y7sc5prq` FOREIGN KEY (`course_like_course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FKl4ysdrmsyvm52f4yjwwa6xpu6` FOREIGN KEY (`course_like_student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- Volcando datos para la tabla university_registration.course_like: ~0 rows (aproximadamente)
INSERT INTO `course_like` (`course_like_student_id`, `course_like_course_id`, `course_like_rating`) VALUES
	(2, 1, 1),
	(1, 1, 2),
	(1, 2, 3),
	(4, 13, 4),
	(5, 14, 5);

-- Volcando estructura para tabla university_registration.student
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- Volcando datos para la tabla university_registration.student: ~0 rows (aproximadamente)
INSERT INTO `student` (`student_id`, `student_name`) VALUES
	(1, 'Juan'),
	(2, 'Juana'),
	(4, 'Adrian'),
	(5, 'Marta');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
