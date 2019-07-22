-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fablab
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user_rol`
--

DROP TABLE IF EXISTS `user_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_rol` (
  `iduser_rol` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `id_participante` int(11) DEFAULT NULL,
  `id_mentor` int(11) DEFAULT NULL,
  `id_supervisor` int(11) DEFAULT NULL,
  `rol_name` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser_rol`),
  KEY `participante_idx` (`id_participante`),
  KEY `mentor_idx` (`id_mentor`),
  KEY `user_idx` (`user_id`),
  KEY `id_supervisor_idx` (`id_supervisor`),
  CONSTRAINT `id_supervisor` FOREIGN KEY (`id_supervisor`) REFERENCES `supervisor` (`id_supervisor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mentor` FOREIGN KEY (`id_mentor`) REFERENCES `mentor` (`id_mentor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `participante` FOREIGN KEY (`id_participante`) REFERENCES `participante` (`id_participante`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rol`
--

LOCK TABLES `user_rol` WRITE;
/*!40000 ALTER TABLE `user_rol` DISABLE KEYS */;
INSERT INTO `user_rol` VALUES (1,1,1,NULL,NULL,'participante'),(2,2,NULL,2,NULL,'mentor'),(3,3,NULL,NULL,1,'supervisor');
/*!40000 ALTER TABLE `user_rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-21 21:22:11
