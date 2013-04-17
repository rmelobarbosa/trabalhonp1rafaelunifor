CREATE DATABASE  IF NOT EXISTS `organograma` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `organograma`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: organograma
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info` (
  `idinfo` int(11) NOT NULL AUTO_INCREMENT,
  `representante` varchar(45) NOT NULL,
  `ramal` int(4) NOT NULL,
  `email_representante` varchar(45) NOT NULL,
  `sala` int(4) NOT NULL,
  `idno_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinfo`),
  KEY `fk_idno_idx` (`idno_fk`),
  CONSTRAINT `fk_idno` FOREIGN KEY (`idno_fk`) REFERENCES `no` (`idno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES (1,'José Arnaldo',7701,'josearnaldo@sc.com.br',100,1),(2,'João Oliveira',7702,'joliveira@sc.com.br',98,2),(3,'Maria das Graças',7703,'mg@sc.com.br',96,3),(4,'Joana Silva',7704,'js@sc.com.br',94,4),(5,'Carlos de Jesus',7705,'cj@sc.com.br',92,5),(6,'Felipe Maranhão',7706,'fmaranhao@sc.com.br',90,6),(7,'Carlos Chagas',7707,'cc@sc.com.br',88,7),(8,'Sara Veraneio',7708,'sarav@sc.com.br',86,8),(9,'Tomás Bastos',7710,'tb@sc.com.br',84,9),(10,'Carla Ramires',7711,'carlar@sc.com.br',82,10),(11,'Cibele Moura',7712,'cibelemoura@sc.com.br',80,11),(12,'Jorge Veras',7714,'jv@sc.com.br',78,12);
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `no`
--

DROP TABLE IF EXISTS `no`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `no` (
  `idno` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `data_criacao` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `no_id_pai` int(11) DEFAULT NULL,
  PRIMARY KEY (`idno`),
  KEY `fk_no_no_idx` (`no_id_pai`),
  CONSTRAINT `fk_no_no` FOREIGN KEY (`no_id_pai`) REFERENCES `no` (`idno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `no`
--

LOCK TABLES `no` WRITE;
/*!40000 ALTER TABLE `no` DISABLE KEYS */;
INSERT INTO `no` VALUES (1,'Diretor',NULL,'2013-04-13 12:36:19',NULL),(2,'Vice-diretor',NULL,'2013-04-13 00:45:01',1),(3,'Direitor de Ensino',NULL,'2013-04-13 00:45:01',2),(4,'Direitor Financeiro',NULL,'2013-04-13 00:45:01',2),(5,'Direitor Administrativo',NULL,'2013-04-13 00:45:01',2),(6,'Secretaria',NULL,'2013-04-13 00:47:27',3),(7,'Coordenador Pedagógico',NULL,'2013-04-13 00:47:27',3),(8,'Coordenador de Disciplina',NULL,'2013-04-13 00:47:27',3),(9,'Coordenador Esportivo',NULL,'2013-04-13 00:47:27',3),(10,'Tesouraria',NULL,'2013-04-13 00:53:15',4),(11,'Biblioteca',NULL,'2013-04-13 00:53:15',5),(12,'Serviços Gerais',NULL,'2013-04-13 00:53:15',5);
/*!40000 ALTER TABLE `no` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `no_info`
--

DROP TABLE IF EXISTS `no_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `no_info` (
  `no_idno` int(11) NOT NULL,
  `info_idinfo` int(11) NOT NULL,
  `flag_exibe` tinyint(1) NOT NULL,
  PRIMARY KEY (`no_idno`,`info_idinfo`),
  KEY `fk_table1_no1_idx` (`no_idno`),
  KEY `fk_table1_info1_idx` (`info_idinfo`),
  CONSTRAINT `fk_table1_info1` FOREIGN KEY (`info_idinfo`) REFERENCES `info` (`idinfo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_no1` FOREIGN KEY (`no_idno`) REFERENCES `no` (`idno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `no_info`
--

LOCK TABLES `no_info` WRITE;
/*!40000 ALTER TABLE `no_info` DISABLE KEYS */;
INSERT INTO `no_info` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(10,10,1),(11,11,1),(12,12,1);
/*!40000 ALTER TABLE `no_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `perfil` varchar(45) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('mg','marina','Marina Gosson','administrador'),('nm','natalia','Natalia','administrador'),('super','123456','Jose Arnaldo','diretor'),('vj','valmar','Valmar Junior','administrador');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-16 10:35:59
