-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: u7281p15572_swipeyourjob
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companies` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `comanydesc` mediumtext,
  `name` varchar(45) DEFAULT NULL,
  `weburl` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'Albert Heijn is de grootste Nederlandse keten van supermarkten, eigendom van Ahold Delhaize. In Nederland heeft het bedrijf 985 winkels. Daarnaast is AH sinds 2011 actief in België, met medio 2020 zo\'n 55 filialen in Vlaanderen.','Albert heijn','https://www.ah.nl');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joblocation`
--

DROP TABLE IF EXISTS `joblocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `joblocation` (
  `idjoblocation` int NOT NULL AUTO_INCREMENT,
  `streetname` varchar(45) DEFAULT NULL,
  `housenumber` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  `cardid` varchar(45) DEFAULT NULL,
  `defaultlocation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idjoblocation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joblocation`
--

LOCK TABLES `joblocation` WRITE;
/*!40000 ALTER TABLE `joblocation` DISABLE KEYS */;
INSERT INTO `joblocation` VALUES (1,'Papendorp','100','Utrecht','3528BJ','32242','1'),(2,'Papendorp','100','Utrecht','3528BJ','32242','0');
/*!40000 ALTER TABLE `joblocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `jobid` int NOT NULL AUTO_INCREMENT,
  `jobtitle` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `companyid` int DEFAULT NULL,
  `jobdescription` longtext,
  `timestamps` datetime DEFAULT CURRENT_TIMESTAMP,
  `minhours` int DEFAULT NULL,
  `maxhours` int DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `salaryunit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`jobid`),
  KEY `foreignkey` (`companyid`),
  CONSTRAINT `fs` FOREIGN KEY (`companyid`) REFERENCES `companies` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32243 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (32242,'Vulploegmedewerker','Utrecht',1,'Als vulploegmedewerker bij Albert Heijn help je bij het lossen van de vrachtwagens en vul je de schappen. Je zorgt ervoor dat de winkel er verzorgd uitziet en je helpt klanten als zij een product niet kunnen vinden. Je doet dit samen met een team. Zo help je elkaar en is het iedere dag weer gezellig.','2020-11-17 09:48:41',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobsimages`
--

DROP TABLE IF EXISTS `jobsimages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobsimages` (
  `jobimageid` int NOT NULL AUTO_INCREMENT,
  `imageurl` tinytext,
  `jobid` int DEFAULT NULL,
  PRIMARY KEY (`jobimageid`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobsimages`
--

LOCK TABLES `jobsimages` WRITE;
/*!40000 ALTER TABLE `jobsimages` DISABLE KEYS */;
INSERT INTO `jobsimages` VALUES (43,'https://media.s-bol.com/xYpp09vnR93/436x840.jpg',32242),(44,'https://www.elektrowitgoedoutlet.nl/wp-content/uploads/sites/3/2020/10/RANGEMASTER-RDXD18BL.jpg',32242);
/*!40000 ALTER TABLE `jobsimages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likedjobs`
--

DROP TABLE IF EXISTS `likedjobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likedjobs` (
  `liked_jobs_id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `timestamps` datetime DEFAULT CURRENT_TIMESTAMP,
  `jobid` int DEFAULT NULL,
  PRIMARY KEY (`liked_jobs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedjobs`
--

LOCK TABLES `likedjobs` WRITE;
/*!40000 ALTER TABLE `likedjobs` DISABLE KEYS */;
INSERT INTO `likedjobs` VALUES (6,2,'2020-11-19 14:01:58',1),(7,2,'2020-11-19 14:02:12',1),(8,2,'2020-11-19 14:02:15',1),(9,2,'2020-11-19 14:02:16',1),(10,2,'2020-11-19 14:02:17',1);
/*!40000 ALTER TABLE `likedjobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showedjobs`
--

DROP TABLE IF EXISTS `showedjobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showedjobs` (
  `showedjobs_id` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(555) NOT NULL,
  `timestamps` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `jobid` int NOT NULL,
  PRIMARY KEY (`showedjobs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2130 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showedjobs`
--

LOCK TABLES `showedjobs` WRITE;
/*!40000 ALTER TABLE `showedjobs` DISABLE KEYS */;
INSERT INTO `showedjobs` VALUES (2125,'2','2020-11-19 14:04:41',1),(2126,'2','2020-11-19 14:04:48',1),(2127,'2','2020-11-26 13:57:58',1),(2128,'2','2020-11-26 13:58:14',32242),(2129,'bart','2020-11-26 13:58:26',32242);
/*!40000 ALTER TABLE `showedjobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webusers`
--

DROP TABLE IF EXISTS `webusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `webusers` (
  `idwebusers` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `companyid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idwebusers`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webusers`
--

LOCK TABLES `webusers` WRITE;
/*!40000 ALTER TABLE `webusers` DISABLE KEYS */;
INSERT INTO `webusers` VALUES (1,'zyad','123','Zyad','Osseyran','1');
/*!40000 ALTER TABLE `webusers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-26 17:41:40
