CREATE DATABASE  IF NOT EXISTS `marketi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `marketi`;
-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: marketi
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auricular`
--

DROP TABLE IF EXISTS `auricular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auricular` (
  `id` char(4) NOT NULL,
  `impedancia` int NOT NULL,
  `sensibilidade` int NOT NULL,
  `conexao` varchar(45) NOT NULL,
  UNIQUE KEY `id` (`id`),
  CONSTRAINT `auricular_ibfk_1` FOREIGN KEY (`id`) REFERENCES `produto` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auricular`
--

LOCK TABLES `auricular` WRITE;
/*!40000 ALTER TABLE `auricular` DISABLE KEYS */;
INSERT INTO `auricular` VALUES ('215',22,110,'Bluetooth'),('523',16,105,'P2');
/*!40000 ALTER TABLE `auricular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computador`
--

DROP TABLE IF EXISTS `computador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `computador` (
  `id` char(4) NOT NULL,
  `memoriaram` int NOT NULL,
  `armazenamento` int NOT NULL,
  `sistemaoperacional` varchar(45) NOT NULL,
  UNIQUE KEY `id` (`id`),
  CONSTRAINT `computador_ibfk_1` FOREIGN KEY (`id`) REFERENCES `produto` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computador`
--

LOCK TABLES `computador` WRITE;
/*!40000 ALTER TABLE `computador` DISABLE KEYS */;
INSERT INTO `computador` VALUES ('329',16,512,'OSX'),('430',16,1000,'Windows');
/*!40000 ALTER TABLE `computador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitor`
--

DROP TABLE IF EXISTS `monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitor` (
  `id` char(4) NOT NULL,
  `tamanho` int NOT NULL,
  `taxadeatualizacao` int NOT NULL,
  `resolucao` varchar(45) NOT NULL,
  `tipodetela` varchar(45) NOT NULL,
  UNIQUE KEY `id` (`id`),
  CONSTRAINT `monitor_ibfk_1` FOREIGN KEY (`id`) REFERENCES `produto` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor`
--

LOCK TABLES `monitor` WRITE;
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
INSERT INTO `monitor` VALUES ('414',27,240,'1920x1080','LED');
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` char(4) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `lote` varchar(45) NOT NULL,
  `preco` float NOT NULL,
  `categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES ('215','JBL','EarPhone','456',150,'Auricular'),('322','Zowie','Ec2A','123',300,'Diverso'),('329','Apple','Macbook Pro','791',10000,'Computador'),('414','Acer','SuperMonitor','987',1900,'Monitor'),('430','Dell','PcGamer','678',4999,'Computador'),('523','Logitech','LogiPhone','975',250,'Auricular'),('811','GFallen','Falcãozinho','135',499,'Diverso');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-09 10:15:48
