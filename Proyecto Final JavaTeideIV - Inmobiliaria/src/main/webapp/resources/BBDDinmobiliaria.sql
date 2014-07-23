CREATE DATABASE  IF NOT EXISTS `teide2014` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `teide2014`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: teide2014
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `propietario`
--

DROP TABLE IF EXISTS `propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propietario` (
  `idPropietario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  PRIMARY KEY (`idPropietario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietario`
--

LOCK TABLES `propietario` WRITE;
/*!40000 ALTER TABLE `propietario` DISABLE KEYS */;
INSERT INTO `propietario` VALUES (1,'Genji','73423097G'),(2,'To no Chujo','81234078T'),(3,'Murasaki','37801583M'),(4,'Hachi','48484884I'),(5,'Fujitsubo','23200673B');
/*!40000 ALTER TABLE `propietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquilino`
--

DROP TABLE IF EXISTS `inquilino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inquilino` (
  `idInquilino` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `edad` int(11) NOT NULL,
  `trabaja` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idInquilino`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquilino`
--

LOCK TABLES `inquilino` WRITE;
/*!40000 ALTER TABLE `inquilino` DISABLE KEYS */;
INSERT INTO `inquilino` VALUES (1,'01234567A','Hanachirusato',37,''),(2,'98765432Z','Suetsumuhana',33,'\0'),(3,'19283747E','Tamakazura',24,''),(4,'81726354H','Kaoru',25,''),(5,'51928375F','Niou',25,'\0');
/*!40000 ALTER TABLE `inquilino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inmueble` (
  `idInmueble` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(455) NOT NULL,
  `precio` double NOT NULL,
  `idPropietario` int(11) NOT NULL,
  `idInquilino` int(11) DEFAULT NULL,
  PRIMARY KEY (`idInmueble`),
  KEY `inmueble_idPropietario_idx` (`idPropietario`),
  KEY `fk_inmueble_idInquilino_idx` (`idInquilino`),
  CONSTRAINT `fk_inmueble_idPropietario` FOREIGN KEY (`idPropietario`) REFERENCES `propietario` (`idPropietario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inmueble_idInquilino` FOREIGN KEY (`idInquilino`) REFERENCES `inquilino` (`idInquilino`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
INSERT INTO `inmueble` VALUES (1,'Sexta Avenida 4',2500000,1,1),(2,'Tercera Avenida 23',1750600,1,2),(3,'Cuarta Avenida 6',500250,2,NULL),(4,'Oto 2',200000,4,4),(5,'Avenida Central',10500700,5,NULL);
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-23 15:54:30
