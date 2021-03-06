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
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proyecto` (
  `id_proyecto` int(11) NOT NULL AUTO_INCREMENT,
  `id_comite` int(11) DEFAULT NULL,
  `id_mentor` int(11) DEFAULT NULL,
  `id_jefe` int(11) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `detalle` longtext NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  `tipo` tinyint(4) NOT NULL,
  `comentario` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_proyecto`),
  KEY `comiteFK_idx` (`id_comite`),
  KEY `mentorFK_idx` (`id_mentor`),
  KEY `jefeFK_idx` (`id_jefe`),
  CONSTRAINT `comiteFK` FOREIGN KEY (`id_comite`) REFERENCES `comite` (`id_comite`) ON DELETE SET NULL,
  CONSTRAINT `jefeFK` FOREIGN KEY (`id_jefe`) REFERENCES `participante` (`id_participante`) ON DELETE SET NULL,
  CONSTRAINT `mentorFK` FOREIGN KEY (`id_mentor`) REFERENCES `mentor` (`id_mentor`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,NULL,NULL,NULL,'Proyecto 1','Proyecto de Prueba 1',1,1,NULL),(2,NULL,NULL,NULL,'Proyecto 2','Proyecto de Prueba 2',1,0,NULL),(3,NULL,NULL,NULL,'Proyecto 3','Proyecto de Prueba 3',1,1,NULL),(4,NULL,2,NULL,'Proyecto 4','Proyecto de Prueba 4',1,0,'holi'),(5,NULL,NULL,NULL,'Proyecto 5','Proyecto de Prueba 5',0,0,'prueba5'),(6,NULL,NULL,NULL,'Proyecto 6','Proyecto de Prueba 6',1,1,NULL),(7,NULL,NULL,NULL,'Proyecto 7','Proyecto de Prueba 7',1,1,NULL),(8,NULL,NULL,NULL,'Proyecto 8','Proyecto de Prueba 8',3,0,NULL);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
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
