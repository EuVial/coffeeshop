-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: coffee
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `CoffeeOrder`
--

DROP TABLE IF EXISTS `CoffeeOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CoffeeOrder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(80) DEFAULT NULL,
  `delivery_address` varchar(100) NOT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CoffeeOrder`
--

LOCK TABLES `CoffeeOrder` WRITE;
/*!40000 ALTER TABLE `CoffeeOrder` DISABLE KEYS */;
/*!40000 ALTER TABLE `CoffeeOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CoffeeOrderItem`
--

DROP TABLE IF EXISTS `CoffeeOrderItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CoffeeOrderItem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `CoffeeOrderItem_idx_CoffeeType` (`type_id`),
  KEY `CoffeeOrderItem_idx_CoffeeOrder` (`order_id`),
  CONSTRAINT `CoffeeOrder_id_fkey` FOREIGN KEY (`order_id`) REFERENCES `CoffeeOrder` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `CoffeeType_id_fkey` FOREIGN KEY (`type_id`) REFERENCES `CoffeeType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CoffeeOrderItem`
--

LOCK TABLES `CoffeeOrderItem` WRITE;
/*!40000 ALTER TABLE `CoffeeOrderItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `CoffeeOrderItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CoffeeType`
--

DROP TABLE IF EXISTS `CoffeeType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CoffeeType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `disabled` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CoffeeType`
--

LOCK TABLES `CoffeeType` WRITE;
/*!40000 ALTER TABLE `CoffeeType` DISABLE KEYS */;
/*!40000 ALTER TABLE `CoffeeType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Configuration`
--

DROP TABLE IF EXISTS `Configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Configuration` (
  `id` varchar(30) NOT NULL,
  `value` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Configuration`
--

LOCK TABLES `Configuration` WRITE;
/*!40000 ALTER TABLE `Configuration` DISABLE KEYS */;
INSERT INTO `Configuration` VALUES ('m','2'),('n','5'),('x','10');
/*!40000 ALTER TABLE `Configuration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-05 23:23:27
