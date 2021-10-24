-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: 84.247.13.137    Database: swipeyourjob2
-- ------------------------------------------------------
-- Server version	8.0.25-0ubuntu0.20.04.1

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
-- Table structure for table `Webusers_establishment`
--

DROP TABLE IF EXISTS `Webusers_establishment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Webusers_establishment` (
  `idWebusers_estamblishment` int NOT NULL AUTO_INCREMENT,
  `webusers_idwebusers` int NOT NULL,
  `establishment_idestablishment` int NOT NULL,
  PRIMARY KEY (`idWebusers_estamblishment`,`establishment_idestablishment`),
  KEY `fk_Webusers_estamblishment_webusers_idx` (`webusers_idwebusers`),
  KEY `fk_Webusers_estamblishment_establishment1_idx` (`establishment_idestablishment`),
  CONSTRAINT `fk_Webusers_estamblishment_establishment1` FOREIGN KEY (`establishment_idestablishment`) REFERENCES `establishment` (`idestablishment`),
  CONSTRAINT `fk_Webusers_estamblishment_webusers` FOREIGN KEY (`webusers_idwebusers`) REFERENCES `webusers` (`idwebusers`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Webusers_establishment`
--

LOCK TABLES `Webusers_establishment` WRITE;
/*!40000 ALTER TABLE `Webusers_establishment` DISABLE KEYS */;
INSERT INTO `Webusers_establishment` VALUES (41,85,57),(42,86,58),(43,87,59),(44,88,60),(45,89,61),(46,90,62),(47,91,63),(48,92,64),(49,93,65),(50,94,66),(51,95,67),(52,96,68),(53,97,69),(54,98,70),(55,99,71),(56,100,72),(57,101,73),(58,103,75),(59,104,76),(60,105,77),(61,106,78),(62,107,79),(63,112,84),(64,113,85),(65,114,86),(66,115,87);
/*!40000 ALTER TABLE `Webusers_establishment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appusers`
--

DROP TABLE IF EXISTS `appusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appusers` (
  `idappusers` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `birthdate` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` mediumtext NOT NULL,
  `roleid` int DEFAULT NULL,
  PRIMARY KEY (`idappusers`),
  KEY `role_assigned_idx` (`roleid`),
  CONSTRAINT `role_assigned` FOREIGN KEY (`roleid`) REFERENCES `userroles` (`iduserroles`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appusers`
--

LOCK TABLES `appusers` WRITE;
/*!40000 ALTER TABLE `appusers` DISABLE KEYS */;
INSERT INTO `appusers` VALUES (1,'Zyad','Osseyran','03-02-1998','Zyadosseyran@gmail.com','9+jmrvGY6j2LNXRIwkdnLQ==',6),(2,'Zyad','Osseyran','03-02-1998','Zyadosseyran@gmail.com','9+jmrvGY6j2LNXRIwkdnLQ==',6),(3,'Zyad','Osseyran','03-02-1998','Zyadosseyran@gmail.com','9+jmrvGY6j2LNXRIwkdnLQ==',6);
/*!40000 ALTER TABLE `appusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bugs`
--

DROP TABLE IF EXISTS `bugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bugs` (
  `idbugs` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `description` mediumtext NOT NULL,
  `versionnumber` varchar(45) NOT NULL,
  PRIMARY KEY (`idbugs`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bugs`
--

LOCK TABLES `bugs` WRITE;
/*!40000 ALTER TABLE `bugs` DISABLE KEYS */;
/*!40000 ALTER TABLE `bugs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_rooms`
--

DROP TABLE IF EXISTS `chat_rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_rooms` (
  `idchat_rooms` int NOT NULL AUTO_INCREMENT,
  `Chatname` varchar(45) NOT NULL,
  `chatjobid` int DEFAULT NULL,
  `roomadmin` varchar(45) NOT NULL,
  PRIMARY KEY (`idchat_rooms`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_rooms`
--

LOCK TABLES `chat_rooms` WRITE;
/*!40000 ALTER TABLE `chat_rooms` DISABLE KEYS */;
INSERT INTO `chat_rooms` VALUES (1,'1-wus6GIOhdLghCHrgxAHzK5Q2Ll93',1,'88'),(2,'1-wus6GIOhdLghCHrgxAHzK5Q2Ll93',1,'88'),(3,'2-PIJHAvESISNt1cBppfhRrris1ll2',2,'115');
/*!40000 ALTER TABLE `chat_rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatmessages`
--

DROP TABLE IF EXISTS `chatmessages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chatmessages` (
  `chatid` int NOT NULL AUTO_INCREMENT,
  `chatmessage` mediumtext NOT NULL,
  `roomid` int NOT NULL,
  `userid` varchar(45) NOT NULL,
  `timestampmessage` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`chatid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatmessages`
--

LOCK TABLES `chatmessages` WRITE;
/*!40000 ALTER TABLE `chatmessages` DISABLE KEYS */;
INSERT INTO `chatmessages` VALUES (1,'sdafasdf',2,'85','2021-08-24 11:37:00'),(2,'sadf',2,'85','2021-08-24 11:37:03'),(3,'pesto',2,'100','2021-08-24 11:39:02'),(4,'pesto',2,'100','2021-08-24 11:39:36'),(5,'pesto',2,'100','2021-08-24 11:39:47');
/*!40000 ALTER TABLE `chatmessages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companies` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `companylogo` mediumtext,
  `name` varchar(45) NOT NULL,
  `kvk` varchar(45) NOT NULL,
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `kvk_UNIQUE` (`kvk`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (129,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','zyad','12342'),(130,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','test','123456789'),(131,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','Bart Hiemstra','92929296'),(138,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','Bridge Commander 2','987654321'),(174,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','test','74232231'),(175,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','Intratuin','098765432'),(177,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','Test1234','123458965'),(179,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','SDFKJSDLFKJSDLKDSJFDFSSDF','23422222'),(180,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','LKDSJLSDKJLSKDJF','38383883'),(181,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','kddkskdksd','39311111'),(182,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','sdflkjsdlfkj','11111111'),(186,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','sdfsdfsdf','33333333'),(197,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','lsdkfj','11111112'),(215,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','sdfsdf','44444444'),(217,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','sdfsdf','22222222'),(220,'https://swipeyourjob.nl/api_assets/Screenshot 2021-08-05 at 13.08.46.png','Nee B.V.','874637293'),(221,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','testwej','23122222'),(222,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','test','53213442'),(223,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','test','41231225'),(224,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','dsfsdf','39399393'),(225,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','dsfdddd','34343434'),(226,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','dsfsdfsf','34343444'),(227,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','testse','14256789'),(242,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','Testyy','14582796'),(243,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','Testyy','14583796'),(245,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','Testyy','14483796'),(247,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','Testyy','14453796'),(248,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Albert_Heijn_Logo.svg/1000px-Albert_Heijn_Logo.svg.png','test','14473799'),(249,NULL,'Bart H','39339393'),(250,NULL,'Water Bron B.V. ','69732981'),(252,'https://swipeyourjob.nl/api_assets/intratuin-barneveld-barneveld.png','Testbedrijf','12345678');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `establishment`
--

DROP TABLE IF EXISTS `establishment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `establishment` (
  `idestablishment` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `url` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `headlocation` tinyint DEFAULT NULL,
  `companies_company_id` int NOT NULL,
  `establishmentowner` int DEFAULT NULL,
  `facebookurl` tinytext,
  `linkedinurl` tinytext,
  `instagramurl` tinytext,
  PRIMARY KEY (`idestablishment`,`companies_company_id`),
  KEY `fk_establishment_companies1_idx` (`companies_company_id`),
  KEY `fk_headcontact_idx` (`establishmentowner`),
  CONSTRAINT `fk_establishment_companies1` FOREIGN KEY (`companies_company_id`) REFERENCES `companies` (`company_id`),
  CONSTRAINT `fk_headcontact` FOREIGN KEY (`establishmentowner`) REFERENCES `webusers` (`idwebusers`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `establishment`
--

LOCK TABLES `establishment` WRITE;
/*!40000 ALTER TABLE `establishment` DISABLE KEYS */;
INSERT INTO `establishment` VALUES (57,'HQ','www.ah.nl','<p>sdfdsaf</p>',1,129,85,'facebook.nl/ah','linkedin.com/linkedin','instagram.nl/instagram'),(58,'HQ',NULL,NULL,1,130,86,NULL,NULL,NULL),(59,'HQ',NULL,NULL,1,131,87,NULL,NULL,NULL),(60,'HQ','lkse','<p>lit</p>',1,138,88,'lskdjofwej',';lkdj','osjdlkj'),(61,'HQ',NULL,NULL,1,174,89,NULL,NULL,NULL),(62,'HQ',NULL,'<p>Aangepaste bedrijfsprofiel :)</p>',1,175,90,NULL,NULL,NULL),(63,'HQ',NULL,NULL,1,177,91,NULL,NULL,NULL),(64,'HQ',NULL,NULL,1,179,92,NULL,NULL,NULL),(65,'HQ',NULL,NULL,1,180,93,NULL,NULL,NULL),(66,'HQ',NULL,NULL,1,181,94,NULL,NULL,NULL),(67,'HQ',NULL,NULL,1,182,95,NULL,NULL,NULL),(68,'HQ',NULL,NULL,1,186,96,NULL,NULL,NULL),(69,'HQ',NULL,NULL,1,197,97,NULL,NULL,NULL),(70,'HQ',NULL,NULL,1,215,98,NULL,NULL,NULL),(71,'HQ',NULL,NULL,1,217,99,NULL,NULL,NULL),(72,'HQ','test.nl','<p>test</p>',1,220,100,'facebook.nl','linkeding.nl','instagram.nl'),(73,'HQ',NULL,NULL,1,221,101,NULL,NULL,NULL),(75,'HQ',NULL,NULL,1,223,103,NULL,NULL,NULL),(76,'HQ',NULL,NULL,1,224,104,NULL,NULL,NULL),(77,'HQ',NULL,NULL,1,225,105,NULL,NULL,NULL),(78,'HQ',NULL,NULL,1,226,106,NULL,NULL,NULL),(79,'HQ',NULL,NULL,1,227,107,NULL,NULL,NULL),(84,'HQ',NULL,NULL,1,248,112,NULL,NULL,NULL),(85,'HQ',NULL,NULL,1,249,113,NULL,NULL,NULL),(86,'HQ',NULL,NULL,1,250,114,NULL,NULL,NULL),(87,'HQ','www.swipeyourjob.nl','<p>Wij zijn een mooi bedrijf</p>',1,252,115,'www.swipeyourjob.nl','www.swipeyourjob.nl','www.swipeyourjob.nl');
/*!40000 ALTER TABLE `establishment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `establishment_adress`
--

DROP TABLE IF EXISTS `establishment_adress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `establishment_adress` (
  `idestablishment_adress` int NOT NULL AUTO_INCREMENT,
  `latitude` varchar(45) NOT NULL,
  `longtitude` varchar(45) NOT NULL,
  `zipcode` varchar(45) NOT NULL,
  `startdate` date NOT NULL,
  `place` varchar(45) DEFAULT NULL,
  `streetname` varchar(45) DEFAULT NULL,
  `housenumber` varchar(45) DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `establishment_idestablishment` int NOT NULL,
  PRIMARY KEY (`idestablishment_adress`,`establishment_idestablishment`),
  KEY `fk_establishment_adress_establishment1_idx` (`establishment_idestablishment`),
  CONSTRAINT `fk_establishment_adress_establishment1` FOREIGN KEY (`establishment_idestablishment`) REFERENCES `establishment` (`idestablishment`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `establishment_adress`
--

LOCK TABLES `establishment_adress` WRITE;
/*!40000 ALTER TABLE `establishment_adress` DISABLE KEYS */;
INSERT INTO `establishment_adress` VALUES (33,'52.06620916','5.140394453333333','3524BL','2021-05-26','Utrecht','3524BL','147',NULL,57),(34,'52.2289762333333','5.1716291','1217JD','2021-05-26',NULL,NULL,NULL,NULL,58),(35,'12.1783956','-68.2790681','1234AB','2021-05-27',NULL,NULL,NULL,NULL,59),(36,'52.09249768409093','5.148857559090907','3584BB','2021-05-27','Utrecht','Pythagoraslaan','111',NULL,60),(37,'52.06620916','5.14039445333333','3524BL','2021-05-27',NULL,NULL,NULL,NULL,61),(38,'51.8114326375','4.6355064875','3333AB','2021-06-11',NULL,NULL,NULL,NULL,65),(39,'51.8114326375','4.6355064875','3333AB','2021-06-13',NULL,NULL,NULL,NULL,66),(40,'12.1783956','-68.2790681','1234AB','2021-06-13',NULL,NULL,NULL,NULL,67),(41,'12.1783956','-68.2790681','1234AB','2021-06-13',NULL,NULL,NULL,NULL,69),(42,'12.1783956','-68.2790681','1234AB','2021-06-14',NULL,NULL,NULL,NULL,70),(43,'52.06620916','5.140394453333333','3524BL','2021-06-15','Utrecht','Fivelingo','12',NULL,72),(44,'52.06620916','5.14039445333333','3524BL','2021-06-22',NULL,NULL,NULL,NULL,73),(45,'51.91563415','4.99287954','4231ED','2021-06-22',NULL,NULL,NULL,NULL,75),(46,'12.1783956','-68.2790681','1234AB','2021-06-26',NULL,NULL,NULL,NULL,76),(51,'52.3548591333333','4.82127248333333','1065HA','2021-07-20',NULL,NULL,NULL,NULL,84),(52,'12.1783956','-68.2790681','1234AB','2021-08-03',NULL,NULL,NULL,NULL,85),(53,'52.06620916','5.140394453333333','3524BL','2021-09-03','Utrecht',NULL,'0',NULL,62),(54,'12.1783956','-68.2790681','1234AB','2021-08-23','Barneveld','straatweglaan','123',NULL,87);
/*!40000 ALTER TABLE `establishment_adress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_log`
--

DROP TABLE IF EXISTS `general_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `general_log` (
  `event_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_host` mediumtext NOT NULL,
  `thread_id` bigint unsigned NOT NULL,
  `server_id` int unsigned NOT NULL,
  `command_type` varchar(64) NOT NULL,
  `argument` mediumtext NOT NULL
) ENGINE=CSV DEFAULT CHARSET=utf8mb3 COMMENT='General log';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_log`
--

LOCK TABLES `general_log` WRITE;
/*!40000 ALTER TABLE `general_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `general_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_tag`
--

DROP TABLE IF EXISTS `job_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_tag` (
  `jobid` int DEFAULT NULL,
  `tagid` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `tagcon_idx` (`tagid`),
  KEY `jobid` (`jobid`),
  CONSTRAINT `jobid` FOREIGN KEY (`jobid`) REFERENCES `jobs` (`jobid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tagcon` FOREIGN KEY (`tagid`) REFERENCES `tagbox` (`tagid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_tag`
--

LOCK TABLES `job_tag` WRITE;
/*!40000 ALTER TABLE `job_tag` DISABLE KEYS */;
INSERT INTO `job_tag` VALUES (1,1,1),(2,21,2),(2,24,3),(2,12,4),(3,16,5),(3,25,6),(3,12,7),(4,16,8),(5,16,9),(4,12,10),(4,21,11),(5,12,12),(6,16,13),(6,12,14),(6,21,15),(5,21,16);
/*!40000 ALTER TABLE `job_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobavability`
--

DROP TABLE IF EXISTS `jobavability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobavability` (
  `idjobavability` int NOT NULL AUTO_INCREMENT,
  `day` int NOT NULL,
  `jobid` int DEFAULT NULL,
  `morning` int NOT NULL,
  `afternoon` int NOT NULL,
  `evening` int NOT NULL,
  `night` int NOT NULL,
  PRIMARY KEY (`idjobavability`),
  KEY `jobconn_idx` (`jobid`),
  CONSTRAINT `jobconn` FOREIGN KEY (`jobid`) REFERENCES `jobs` (`jobid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobavability`
--

LOCK TABLES `jobavability` WRITE;
/*!40000 ALTER TABLE `jobavability` DISABLE KEYS */;
INSERT INTO `jobavability` VALUES (1,1,1,0,0,1,1),(2,2,1,0,0,1,1),(3,3,1,0,0,1,1),(4,4,1,0,0,1,1),(5,5,1,0,0,1,1),(6,6,1,0,0,1,1),(7,7,1,0,0,1,1),(8,1,2,0,0,0,0),(9,2,2,0,1,0,0),(10,3,2,0,1,0,0),(11,4,2,1,1,0,0),(12,5,2,1,1,1,0),(13,6,2,1,1,0,0),(14,7,2,0,0,0,0),(15,1,3,1,1,1,0),(16,2,3,1,1,1,0),(17,3,3,1,1,0,0),(18,4,3,1,1,0,0),(19,5,3,0,0,1,0),(20,6,3,0,0,1,0),(21,7,3,0,0,0,0),(22,1,4,1,1,0,0),(23,2,4,1,1,0,0),(24,3,4,0,0,1,0),(25,4,4,0,0,1,0),(26,5,4,1,1,0,0),(27,6,4,1,1,0,0),(28,7,4,0,0,0,0),(29,1,5,1,1,0,0),(30,2,5,1,1,0,0),(31,3,5,0,0,1,0),(32,1,6,1,1,0,0),(33,2,6,1,1,0,0),(34,3,6,0,0,1,0),(35,4,6,0,0,1,0),(36,4,5,0,0,1,0),(37,5,5,1,1,0,0),(38,6,5,1,1,0,0),(39,7,5,0,0,0,0),(40,5,6,1,1,0,0),(41,6,6,1,1,0,0),(42,7,6,0,0,0,0);
/*!40000 ALTER TABLE `jobavability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobimages`
--

DROP TABLE IF EXISTS `jobimages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobimages` (
  `idjobimages` int NOT NULL AUTO_INCREMENT,
  `imageurl` mediumtext NOT NULL,
  `jobid` int DEFAULT NULL,
  PRIMARY KEY (`idjobimages`),
  KEY `job_conn_idx` (`jobid`),
  CONSTRAINT `job_conn` FOREIGN KEY (`jobid`) REFERENCES `jobs` (`jobid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobimages`
--

LOCK TABLES `jobimages` WRITE;
/*!40000 ALTER TABLE `jobimages` DISABLE KEYS */;
INSERT INTO `jobimages` VALUES (1,'https://swipeyourjob.nl/api_assets/young-woman-1064666_1920.jpg',1),(2,'',2),(3,'',3),(4,'',4),(5,'',5),(6,'',6);
/*!40000 ALTER TABLE `jobimages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobperiod`
--

DROP TABLE IF EXISTS `jobperiod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobperiod` (
  `idjobperiod` int NOT NULL AUTO_INCREMENT,
  `startdate` date NOT NULL,
  `enddate` date DEFAULT NULL,
  `jobs_jobid` int NOT NULL,
  PRIMARY KEY (`idjobperiod`,`jobs_jobid`),
  KEY `fk_jobperiod_jobs1_idx` (`jobs_jobid`),
  CONSTRAINT `fk_jobperiod_jobs1` FOREIGN KEY (`jobs_jobid`) REFERENCES `jobs` (`jobid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobperiod`
--

LOCK TABLES `jobperiod` WRITE;
/*!40000 ALTER TABLE `jobperiod` DISABLE KEYS */;
INSERT INTO `jobperiod` VALUES (1,'2021-08-23',NULL,1),(2,'2021-06-30','2021-09-01',2),(3,'2021-09-02','2021-09-19',3),(4,'2021-09-01','2021-09-19',4),(5,'2021-09-01','2021-09-19',5),(6,'2021-09-01','2021-09-19',6);
/*!40000 ALTER TABLE `jobperiod` ENABLE KEYS */;
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
  `jobdescription` mediumtext,
  `timestamps` datetime DEFAULT CURRENT_TIMESTAMP,
  `minhours` float DEFAULT NULL,
  `maxhours` float DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `minage` int DEFAULT NULL,
  `establishment_idestablishment` int NOT NULL,
  `establishment_companies_company_id` int NOT NULL,
  PRIMARY KEY (`jobid`),
  KEY `fk_jobs_establishment1_idx` (`establishment_idestablishment`,`establishment_companies_company_id`),
  CONSTRAINT `fk_jobs_establishment1` FOREIGN KEY (`establishment_idestablishment`, `establishment_companies_company_id`) REFERENCES `establishment` (`idestablishment`, `companies_company_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,'Tapper','Lekker achter de bar werken! ','2021-08-23 18:02:33',NULL,NULL,NULL,NULL,60,138),(2,'Medewerker Kamerplanten','Als medewerker kamerplanten, verzorg je kamerplanten en help je klanten het beste product vinden.','2021-08-24 10:15:06',NULL,NULL,NULL,NULL,87,252),(3,'Vulploegmedewerker','Klanten helpen en zorgen dat de winkel er netjes en verzorgd uit ziet.','2021-09-06 14:04:41',NULL,NULL,NULL,NULL,87,252),(4,'Kassamedewerker','Wij zoeken medewerkers voor achter de kassa. Je staat klanten vriendelijk te woord en zorgt dat iedereen tevreden de winkel verlaat.','2021-09-06 14:16:30',NULL,NULL,NULL,NULL,87,252),(5,'Kassamedewerker','Wij zoeken medewerkers voor achter de kassa. Je staat klanten vriendelijk te woord en zorgt dat iedereen tevreden de winkel verlaat.','2021-09-06 14:16:30',NULL,NULL,NULL,NULL,87,252),(6,'Kassamedewerker','Wij zoeken medewerkers voor achter de kassa. Je staat klanten vriendelijk te woord en zorgt dat iedereen tevreden de winkel verlaat.','2021-09-06 14:16:30',NULL,NULL,NULL,NULL,87,252);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobstatus_users`
--

DROP TABLE IF EXISTS `jobstatus_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobstatus_users` (
  `idjobstatus_users` int NOT NULL AUTO_INCREMENT,
  `timestamps` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `statusid` int NOT NULL,
  `jobid` int NOT NULL,
  `userid` varchar(100) NOT NULL,
  `webuser` int DEFAULT NULL,
  PRIMARY KEY (`idjobstatus_users`),
  KEY `fk_jobstatus_users_jobs1_idx` (`jobid`),
  KEY `fk_jobstatus_users_jobstatuses1_idx` (`statusid`),
  KEY `approver_idx` (`webuser`),
  CONSTRAINT `approver` FOREIGN KEY (`webuser`) REFERENCES `webusers` (`idwebusers`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_jobstatus_users_jobs1` FOREIGN KEY (`jobid`) REFERENCES `jobs` (`jobid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_jobstatus_users_jobstatuses1` FOREIGN KEY (`statusid`) REFERENCES `jobstatuses` (`idjobstatuses`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobstatus_users`
--

LOCK TABLES `jobstatus_users` WRITE;
/*!40000 ALTER TABLE `jobstatus_users` DISABLE KEYS */;
INSERT INTO `jobstatus_users` VALUES (8,'2021-09-06 14:00:19',2,1,'PIJHAvESISNt1cBppfhRrris1ll2',NULL),(9,'2021-09-06 14:17:27',1,3,'PIJHAvESISNt1cBppfhRrris1ll2',NULL),(10,'2021-09-06 14:18:17',5,4,'PIJHAvESISNt1cBppfhRrris1ll2',115),(11,'2021-09-06 14:18:20',2,5,'PIJHAvESISNt1cBppfhRrris1ll2',NULL),(12,'2021-09-06 14:18:20',2,6,'PIJHAvESISNt1cBppfhRrris1ll2',NULL);
/*!40000 ALTER TABLE `jobstatus_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobstatuses`
--

DROP TABLE IF EXISTS `jobstatuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobstatuses` (
  `idjobstatuses` int NOT NULL AUTO_INCREMENT,
  `statusname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idjobstatuses`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobstatuses`
--

LOCK TABLES `jobstatuses` WRITE;
/*!40000 ALTER TABLE `jobstatuses` DISABLE KEYS */;
INSERT INTO `jobstatuses` VALUES (1,'liked'),(2,'denied'),(3,'bookmarked'),(4,'rejected'),(5,'accepted');
/*!40000 ALTER TABLE `jobstatuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passwordforget`
--

DROP TABLE IF EXISTS `passwordforget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passwordforget` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `passwordforgotcode` varchar(45) NOT NULL,
  `requesttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passwordforget`
--

LOCK TABLES `passwordforget` WRITE;
/*!40000 ALTER TABLE `passwordforget` DISABLE KEYS */;
INSERT INTO `passwordforget` VALUES (1,'zyadosseyran@gmail.com','558442722','2021-06-03 12:53:14'),(2,'zyadosseyran@gmail.com','452330251','2021-06-07 14:17:17'),(3,'zyadosseyran@gmail.com','681457662','2021-06-07 14:26:04'),(4,'zyadosseyran@gmail.com','242946145','2021-06-15 10:43:38'),(5,'zyad.osseyran@student.hu.nl','850640945','2021-07-27 19:04:57'),(6,'zyadosseyran@gmail.com','223191922','2021-07-27 19:05:21'),(7,'bart@swipeyourjob.nl','885424270','2021-08-20 15:42:12'),(8,'bart@swipeyourjob.nl','701806748','2021-08-20 15:53:50'),(9,'bart@swipeyourjob.nl','917623534','2021-08-20 16:52:48'),(10,'bart@swipeyourjob.nl','721641117','2021-08-20 17:21:04'),(11,'bart@swipeyourjob.nl','554089901','2021-08-20 17:30:37'),(12,'bart@swipeyourjob.nl','219144192','2021-08-20 17:33:53'),(13,'bart@swipeyourjob.nl','777735189','2021-08-20 17:36:30'),(14,'bart@swipeyourjob.nl','895862121','2021-08-20 17:37:08'),(15,'bart@swipeyourjob.nl','780941360','2021-08-20 17:39:10'),(16,'bart@swipeyourjob.nl','853891159','2021-08-21 10:14:11'),(17,'bart@swipeyourjob.nl','382168989','2021-08-21 10:15:41'),(18,'bart@swipeyourjob.nl','748683065','2021-08-21 10:17:02'),(19,'bart@swipeyourjob.nl','129494778','2021-08-21 10:20:04'),(20,'bart@swipeyourjob.nl','116854031','2021-08-21 10:21:26'),(21,'bart@swipeyourjob.nl','673090446','2021-08-21 10:27:46');
/*!40000 ALTER TABLE `passwordforget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_users`
--

DROP TABLE IF EXISTS `room_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_users` (
  `guest_id` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) NOT NULL,
  `room_id` varchar(45) NOT NULL,
  PRIMARY KEY (`guest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_users`
--

LOCK TABLES `room_users` WRITE;
/*!40000 ALTER TABLE `room_users` DISABLE KEYS */;
INSERT INTO `room_users` VALUES (1,'85','1'),(2,'85','2'),(3,'85','3'),(4,'re','4'),(5,'85','4'),(6,'re','5'),(7,'85','5'),(8,'85','0'),(9,'85','0'),(10,'85','0'),(11,'85','0'),(12,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','6'),(13,'85','6'),(14,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','7'),(15,'85','7'),(16,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','8'),(17,'85','8'),(18,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','9'),(19,'85','9'),(20,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','10'),(21,'85','10'),(22,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','11'),(23,'85','11'),(24,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','12'),(25,'85','12'),(26,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','13'),(27,'85','13'),(28,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','14'),(29,'85','14'),(30,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','15'),(31,'85','15'),(32,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','16'),(33,'85','16'),(34,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','17'),(35,'85','17'),(36,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','18'),(37,'85','18'),(38,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','19'),(39,'85','19'),(40,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','20'),(41,'85','20'),(42,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','21'),(43,'85','21'),(44,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','22'),(45,'85','22'),(46,'PIJHAvESISNt1cBppfhRrris1ll2','23'),(47,'88','23'),(48,'PIJHAvESISNt1cBppfhRrris1ll2','24'),(49,'85','24'),(50,'PIJHAvESISNt1cBppfhRrris1ll2','25'),(51,'115','25'),(52,'PIJHAvESISNt1cBppfhRrris1ll2','26'),(53,'115','26'),(54,'PIJHAvESISNt1cBppfhRrris1ll2','27'),(55,'115','27'),(56,'PIJHAvESISNt1cBppfhRrris1ll2','28'),(57,'115','28'),(58,'PIJHAvESISNt1cBppfhRrris1ll2','29'),(59,'115','29'),(60,'PIJHAvESISNt1cBppfhRrris1ll2','30'),(61,'115','30'),(62,'PIJHAvESISNt1cBppfhRrris1ll2','31'),(63,'115','31'),(64,'PIJHAvESISNt1cBppfhRrris1ll2','32'),(65,'115','32'),(66,'PIJHAvESISNt1cBppfhRrris1ll2','1'),(67,'115','1'),(68,'PIJHAvESISNt1cBppfhRrris1ll2','2'),(69,'115','2'),(70,'PIJHAvESISNt1cBppfhRrris1ll2','3'),(71,'115','3'),(72,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','1'),(73,'88','1'),(74,'wus6GIOhdLghCHrgxAHzK5Q2Ll93','2'),(75,'88','2'),(76,'PIJHAvESISNt1cBppfhRrris1ll2','3'),(77,'115','3');
/*!40000 ALTER TABLE `room_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `idsalary` int NOT NULL AUTO_INCREMENT,
  `salary` decimal(10,2) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `jobs_jobid` int NOT NULL,
  PRIMARY KEY (`idsalary`),
  KEY `fk_salary_jobs1_idx` (`jobs_jobid`),
  CONSTRAINT `fk_salary_jobs1` FOREIGN KEY (`jobs_jobid`) REFERENCES `jobs` (`jobid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,8.00,16,1),(2,9.00,17,1),(3,10.00,18,1),(4,11.00,19,1),(5,12.00,20,1),(6,13.19,21,1),(7,5.00,16,2),(8,6.00,17,2),(9,7.00,18,2),(10,8.00,19,2),(11,9.00,20,2),(12,10.00,21,2),(13,6.00,16,3),(14,7.00,17,3),(15,8.00,18,3),(16,9.00,19,3),(17,10.00,20,3),(18,12.00,21,3),(19,5.00,16,4),(20,6.00,17,4),(21,7.00,18,4),(22,8.00,19,4),(23,5.00,16,5),(24,6.00,17,5),(25,7.00,18,5),(26,9.00,20,4),(27,10.00,21,4),(28,5.00,16,6),(29,6.00,17,6),(30,7.00,18,6),(31,8.00,19,5),(32,9.00,20,5),(33,8.00,19,6),(34,9.00,20,6),(35,10.00,21,5),(36,10.00,21,6);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showedmessages`
--

DROP TABLE IF EXISTS `showedmessages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showedmessages` (
  `readid` int NOT NULL AUTO_INCREMENT,
  `messageid` int DEFAULT NULL,
  `roomid` int DEFAULT NULL,
  `userid` varchar(45) DEFAULT NULL,
  `moment` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`readid`)
) ENGINE=InnoDB AUTO_INCREMENT=6504 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showedmessages`
--

LOCK TABLES `showedmessages` WRITE;
/*!40000 ALTER TABLE `showedmessages` DISABLE KEYS */;
INSERT INTO `showedmessages` VALUES (5926,365,2,'85','2021-08-21 03:33:14'),(5927,365,2,'85','2021-08-21 03:33:20'),(5928,0,3,'85','2021-08-21 03:33:33'),(5929,365,2,'85','2021-08-21 03:33:35'),(5930,365,2,'85','2021-08-21 03:40:03'),(5931,365,2,'85','2021-08-21 03:40:06'),(5932,365,2,'85','2021-08-21 03:40:07'),(5933,365,2,'85','2021-08-21 03:40:08'),(5934,365,2,'85','2021-08-21 03:40:08'),(5935,365,2,'85','2021-08-21 03:40:09'),(5936,365,2,'85','2021-08-21 03:40:09'),(5937,365,2,'85','2021-08-21 03:40:10'),(5938,365,2,'85','2021-08-21 03:40:10'),(5939,365,2,'85','2021-08-21 03:40:11'),(5940,365,2,'85','2021-08-21 03:40:11'),(5941,365,2,'85','2021-08-21 03:40:22'),(5942,365,2,'85','2021-08-21 03:40:23'),(5943,365,2,'85','2021-08-21 03:41:18'),(5944,365,2,'85','2021-08-21 03:41:19'),(5945,365,2,'85','2021-08-21 03:41:20'),(5946,365,2,'85','2021-08-21 03:41:21'),(5947,365,2,'85','2021-08-21 03:41:21'),(5948,365,2,'85','2021-08-21 03:42:09'),(5949,365,2,'85','2021-08-21 03:42:11'),(5950,365,2,'85','2021-08-21 03:42:12'),(5951,365,2,'85','2021-08-21 03:42:12'),(5952,365,2,'85','2021-08-21 03:42:39'),(5953,365,2,'85','2021-08-21 03:42:55'),(5954,365,2,'85','2021-08-21 03:43:21'),(5955,365,2,'85','2021-08-21 03:44:46'),(5956,365,2,'85','2021-08-21 03:45:01'),(5957,365,2,'85','2021-08-21 04:21:11'),(5958,365,2,'85','2021-08-21 09:38:42'),(5959,365,2,'85','2021-08-21 09:48:24'),(5960,365,2,'85','2021-08-21 09:48:57'),(5961,365,2,'85','2021-08-21 09:48:58'),(5962,365,2,'85','2021-08-21 09:53:34'),(5963,0,3,'85','2021-08-21 09:53:35'),(5964,365,2,'85','2021-08-21 09:53:42'),(5965,365,2,'85','2021-08-21 09:54:42'),(5966,0,3,'85','2021-08-21 09:54:43'),(5967,365,2,'85','2021-08-21 09:54:44'),(5968,0,3,'85','2021-08-21 09:54:47'),(5969,365,2,'85','2021-08-21 09:54:47'),(5970,0,3,'85','2021-08-21 09:54:48'),(5971,365,2,'85','2021-08-21 09:54:48'),(5972,0,3,'85','2021-08-21 09:54:55'),(5973,365,2,'85','2021-08-21 09:54:55'),(5974,365,2,'85','2021-08-21 11:46:17'),(5975,365,2,'85','2021-08-21 11:49:38'),(5976,0,3,'85','2021-08-21 11:49:39'),(5977,365,2,'85','2021-08-21 11:49:40'),(5978,0,3,'85','2021-08-21 11:49:41'),(5979,365,2,'85','2021-08-21 11:49:41'),(5980,0,3,'85','2021-08-21 11:49:41'),(5981,365,2,'85','2021-08-21 11:49:41'),(5982,0,3,'85','2021-08-21 11:49:42'),(5983,365,2,'85','2021-08-21 11:49:42'),(5984,0,3,'85','2021-08-21 11:49:42'),(5985,365,2,'85','2021-08-21 11:49:43'),(5986,0,3,'85','2021-08-21 11:49:43'),(5987,365,2,'85','2021-08-21 11:49:44'),(5988,0,3,'85','2021-08-21 11:49:45'),(5989,365,2,'85','2021-08-21 11:49:46'),(5990,0,3,'85','2021-08-21 11:49:46'),(5991,365,2,'85','2021-08-21 11:49:47'),(5992,0,3,'85','2021-08-21 11:49:47'),(5993,365,2,'85','2021-08-21 11:49:47'),(5994,0,3,'85','2021-08-21 11:49:48'),(5995,365,2,'85','2021-08-21 11:49:56'),(5996,0,3,'85','2021-08-21 11:49:56'),(5997,365,2,'85','2021-08-21 11:49:56'),(5998,0,3,'85','2021-08-21 11:49:57'),(5999,365,2,'85','2021-08-21 11:49:57'),(6000,0,3,'85','2021-08-21 11:49:57'),(6001,365,2,'85','2021-08-21 11:49:58'),(6002,365,2,'85','2021-08-21 11:53:39'),(6003,365,2,'85','2021-08-21 11:54:02'),(6004,0,3,'85','2021-08-21 11:54:03'),(6005,365,2,'85','2021-08-21 11:54:03'),(6006,0,3,'85','2021-08-21 11:54:04'),(6007,365,2,'85','2021-08-21 11:54:04'),(6008,0,3,'85','2021-08-21 11:54:04'),(6009,365,2,'85','2021-08-21 11:54:05'),(6010,0,3,'85','2021-08-21 11:54:05'),(6011,365,2,'85','2021-08-21 11:54:05'),(6012,0,3,'85','2021-08-21 11:54:06'),(6013,365,2,'85','2021-08-21 11:54:06'),(6014,0,3,'85','2021-08-21 11:54:06'),(6015,365,2,'85','2021-08-21 11:54:07'),(6016,0,3,'85','2021-08-21 11:54:08'),(6017,365,2,'85','2021-08-21 11:54:08'),(6018,0,6,'85','2021-08-21 13:38:59'),(6019,0,3,'85','2021-08-21 13:38:59'),(6020,365,2,'85','2021-08-21 13:39:00'),(6021,0,3,'85','2021-08-21 13:39:04'),(6022,0,6,'85','2021-08-21 13:39:04'),(6023,0,7,'85','2021-08-21 13:39:05'),(6024,0,6,'85','2021-08-21 13:39:06'),(6025,0,3,'85','2021-08-21 13:39:06'),(6026,365,2,'85','2021-08-21 13:39:07'),(6027,0,6,'85','2021-08-21 13:48:42'),(6028,0,7,'85','2021-08-21 13:48:43'),(6029,0,8,'85','2021-08-21 13:48:44'),(6030,0,9,'85','2021-08-21 13:48:44'),(6031,0,3,'85','2021-08-21 13:48:46'),(6032,365,2,'85','2021-08-21 13:48:47'),(6033,0,3,'85','2021-08-21 13:48:47'),(6034,365,2,'85','2021-08-21 13:48:48'),(6035,0,3,'85','2021-08-21 13:48:49'),(6036,0,6,'85','2021-08-21 13:48:50'),(6037,0,7,'85','2021-08-21 13:48:51'),(6038,0,6,'85','2021-08-21 13:48:51'),(6039,365,2,'85','2021-08-21 13:48:52'),(6040,0,3,'85','2021-08-21 13:49:46'),(6041,365,2,'85','2021-08-21 13:49:46'),(6042,0,6,'85','2021-08-21 13:49:47'),(6043,0,7,'85','2021-08-21 13:49:48'),(6044,0,8,'85','2021-08-21 13:49:48'),(6045,0,9,'85','2021-08-21 13:49:49'),(6046,0,10,'85','2021-08-21 13:49:49'),(6047,0,11,'85','2021-08-21 13:49:50'),(6048,0,12,'85','2021-08-21 13:49:51'),(6049,0,13,'85','2021-08-21 13:49:51'),(6050,0,16,'85','2021-08-21 13:49:56'),(6051,0,17,'85','2021-08-21 13:49:56'),(6052,365,2,'85','2021-08-21 13:49:59'),(6053,0,3,'85','2021-08-21 13:50:00'),(6054,0,6,'85','2021-08-21 13:50:01'),(6055,0,7,'85','2021-08-21 13:50:02'),(6056,0,3,'85','2021-08-21 13:50:03'),(6057,365,2,'85','2021-08-21 13:50:03'),(6058,0,3,'85','2021-08-21 13:50:04'),(6059,0,6,'85','2021-08-21 13:50:05'),(6060,0,7,'85','2021-08-21 13:50:05'),(6061,0,8,'85','2021-08-21 13:50:06'),(6062,0,7,'85','2021-08-21 13:50:06'),(6063,0,6,'85','2021-08-21 13:50:07'),(6064,0,3,'85','2021-08-21 13:50:07'),(6065,365,2,'85','2021-08-21 13:50:08'),(6066,0,3,'85','2021-08-21 13:50:11'),(6067,365,2,'85','2021-08-21 13:50:12'),(6068,365,2,'85','2021-08-21 15:37:10'),(6069,0,3,'85','2021-08-21 15:37:11'),(6070,0,6,'85','2021-08-21 15:37:11'),(6071,0,7,'85','2021-08-21 15:37:12'),(6072,0,8,'85','2021-08-21 15:37:12'),(6073,0,9,'85','2021-08-21 15:37:13'),(6074,0,10,'85','2021-08-21 15:37:13'),(6075,0,11,'85','2021-08-21 15:37:14'),(6076,0,12,'85','2021-08-21 15:37:14'),(6077,0,13,'85','2021-08-21 15:37:15'),(6078,365,2,'85','2021-08-21 15:37:15'),(6079,365,2,'85','2021-08-21 16:07:42'),(6080,0,3,'85','2021-08-21 16:07:43'),(6081,365,2,'85','2021-08-21 16:07:44'),(6082,0,3,'85','2021-08-21 16:07:46'),(6083,365,2,'85','2021-08-21 16:07:47'),(6084,0,3,'85','2021-08-21 16:07:48'),(6085,365,2,'85','2021-08-21 16:07:48'),(6086,0,3,'85','2021-08-21 16:07:49'),(6087,365,2,'85','2021-08-21 16:07:49'),(6088,0,3,'85','2021-08-21 16:07:49'),(6089,365,2,'85','2021-08-21 16:07:50'),(6090,0,3,'85','2021-08-21 16:07:50'),(6091,365,2,'85','2021-08-21 16:07:50'),(6092,0,3,'85','2021-08-21 16:07:50'),(6093,365,2,'85','2021-08-21 16:07:51'),(6094,365,2,'85','2021-08-21 16:07:52'),(6095,0,3,'85','2021-08-21 16:07:52'),(6096,365,2,'85','2021-08-21 16:07:52'),(6097,365,2,'85','2021-08-21 16:09:20'),(6098,0,3,'85','2021-08-21 16:09:20'),(6099,0,3,'85','2021-08-21 16:09:21'),(6100,365,2,'85','2021-08-21 16:09:21'),(6101,0,3,'85','2021-08-21 16:12:20'),(6102,365,2,'85','2021-08-21 16:12:21'),(6103,0,3,'85','2021-08-21 16:12:22'),(6104,365,2,'85','2021-08-21 16:12:22'),(6105,0,3,'85','2021-08-21 16:25:22'),(6106,0,3,'85','2021-08-21 16:33:06'),(6107,0,3,'85','2021-08-21 16:33:45'),(6108,0,3,'85','2021-08-21 17:05:45'),(6109,365,2,'85','2021-08-21 17:19:02'),(6110,365,2,'85','2021-08-21 17:19:40'),(6111,365,2,'85','2021-08-21 17:21:10'),(6112,365,2,'85','2021-08-21 17:23:25'),(6113,365,2,'85','2021-08-21 17:23:43'),(6114,365,2,'85','2021-08-21 17:24:31'),(6115,365,2,'85','2021-08-21 17:26:13'),(6116,365,2,'85','2021-08-21 17:26:34'),(6117,365,2,'85','2021-08-21 17:28:18'),(6118,365,2,'85','2021-08-21 17:28:27'),(6119,365,2,'85','2021-08-21 17:30:25'),(6120,365,2,'85','2021-08-21 17:32:42'),(6121,365,2,'85','2021-08-21 17:33:01'),(6122,365,2,'85','2021-08-21 17:33:05'),(6123,365,2,'85','2021-08-21 17:36:10'),(6124,0,23,'88','2021-08-21 17:38:37'),(6125,365,2,'85','2021-08-21 17:40:10'),(6126,365,2,'85','2021-08-21 17:43:46'),(6127,365,2,'85','2021-08-21 17:45:06'),(6128,366,2,'85','2021-08-21 17:45:39'),(6129,367,2,'85','2021-08-21 17:52:17'),(6130,368,2,'85','2021-08-21 17:52:27'),(6131,369,2,'85','2021-08-21 17:52:34'),(6132,370,2,'85','2021-08-21 17:52:49'),(6133,0,3,'85','2021-08-21 17:55:05'),(6134,370,2,'85','2021-08-21 17:55:06'),(6135,371,2,'85','2021-08-21 17:59:15'),(6136,372,2,'85','2021-08-21 18:00:09'),(6137,373,2,'85','2021-08-21 18:01:59'),(6138,374,2,'85','2021-08-21 18:02:10'),(6139,374,2,'85','2021-08-21 18:04:08'),(6140,374,2,'85','2021-08-21 18:05:23'),(6141,375,2,'85','2021-08-21 18:10:51'),(6142,375,2,'85','2021-08-21 18:12:20'),(6143,377,2,'85','2021-08-21 18:13:43'),(6144,0,23,'88','2021-08-21 20:37:06'),(6145,0,23,'88','2021-08-21 20:37:18'),(6146,378,2,'85','2021-08-21 20:39:43'),(6147,0,3,'85','2021-08-21 20:41:49'),(6148,379,2,'85','2021-08-21 20:42:03'),(6149,0,3,'85','2021-08-21 20:42:05'),(6150,379,2,'85','2021-08-21 20:53:13'),(6151,380,2,'85','2021-08-21 20:53:43'),(6152,0,3,'85','2021-08-21 21:00:04'),(6153,380,2,'85','2021-08-21 21:00:05'),(6154,0,3,'85','2021-08-21 21:00:06'),(6155,380,2,'85','2021-08-21 21:00:06'),(6156,364,2,'85','2021-08-21 21:01:17'),(6157,364,2,'85','2021-08-21 21:01:28'),(6158,364,2,'85','2021-08-21 21:02:23'),(6159,364,2,'85','2021-08-21 21:03:50'),(6160,364,2,'85','2021-08-21 21:04:22'),(6161,364,2,'85','2021-08-21 21:10:45'),(6162,364,2,'85','2021-08-21 21:10:57'),(6163,0,3,'85','2021-08-21 21:10:57'),(6164,364,2,'85','2021-08-21 21:10:58'),(6165,364,2,'85','2021-08-21 21:11:06'),(6166,364,2,'85','2021-08-21 21:12:47'),(6167,0,3,'85','2021-08-21 21:13:07'),(6168,364,2,'85','2021-08-21 21:13:08'),(6169,364,2,'85','2021-08-21 21:13:19'),(6170,364,2,'85','2021-08-21 21:15:05'),(6171,364,2,'85','2021-08-21 21:15:15'),(6172,0,3,'85','2021-08-21 21:16:55'),(6173,0,3,'85','2021-08-21 21:17:10'),(6174,364,2,'85','2021-08-21 21:17:12'),(6175,364,2,'85','2021-08-21 21:23:59'),(6176,364,2,'85','2021-08-21 21:26:05'),(6177,364,2,'85','2021-08-21 21:28:41'),(6178,0,3,'85','2021-08-21 21:29:21'),(6179,364,2,'85','2021-08-21 21:29:22'),(6180,364,2,'85','2021-08-21 21:29:49'),(6181,364,2,'85','2021-08-21 21:32:33'),(6182,0,3,'85','2021-08-21 21:32:36'),(6183,364,2,'85','2021-08-21 21:32:37'),(6184,0,3,'85','2021-08-21 21:32:37'),(6185,364,2,'85','2021-08-21 21:32:38'),(6186,0,3,'85','2021-08-21 21:32:38'),(6187,364,2,'85','2021-08-21 21:32:39'),(6188,0,3,'85','2021-08-21 21:32:39'),(6189,364,2,'85','2021-08-21 21:32:40'),(6190,364,2,'85','2021-08-21 21:35:17'),(6191,364,2,'85','2021-08-21 21:42:08'),(6192,364,2,'85','2021-08-21 21:46:18'),(6193,364,2,'85','2021-08-21 21:48:20'),(6194,364,2,'85','2021-08-21 21:50:49'),(6195,364,2,'85','2021-08-21 22:08:04'),(6196,364,2,'85','2021-08-21 22:08:10'),(6197,364,2,'85','2021-08-21 22:09:26'),(6198,0,3,'85','2021-08-21 22:09:36'),(6199,364,2,'85','2021-08-21 22:09:37'),(6200,364,2,'85','2021-08-22 10:36:50'),(6201,364,2,'85','2021-08-22 10:37:38'),(6202,364,2,'85','2021-08-22 11:29:01'),(6203,364,2,'85','2021-08-22 11:30:03'),(6204,364,2,'85','2021-08-22 11:37:43'),(6205,364,2,'85','2021-08-22 11:38:55'),(6206,364,2,'85','2021-08-22 11:40:21'),(6207,364,2,'85','2021-08-22 11:40:25'),(6208,364,2,'85','2021-08-22 11:40:25'),(6209,0,3,'85','2021-08-22 11:40:26'),(6210,0,3,'85','2021-08-22 11:40:27'),(6211,0,3,'85','2021-08-22 11:40:27'),(6212,0,3,'85','2021-08-22 11:40:27'),(6213,0,3,'85','2021-08-22 11:40:27'),(6214,0,3,'85','2021-08-22 11:40:27'),(6215,364,2,'85','2021-08-22 11:40:28'),(6216,364,2,'85','2021-08-22 11:40:28'),(6217,364,2,'85','2021-08-22 11:40:28'),(6218,364,2,'85','2021-08-22 11:40:29'),(6219,0,3,'85','2021-08-22 11:40:29'),(6220,364,2,'85','2021-08-22 11:40:29'),(6221,0,3,'85','2021-08-22 11:40:30'),(6222,364,2,'85','2021-08-22 11:40:30'),(6223,0,3,'85','2021-08-22 11:40:31'),(6224,0,3,'85','2021-08-22 11:40:31'),(6225,364,2,'85','2021-08-22 11:40:31'),(6226,0,3,'85','2021-08-22 11:40:32'),(6227,364,2,'85','2021-08-22 11:40:32'),(6228,0,3,'85','2021-08-22 11:40:33'),(6229,364,2,'85','2021-08-22 11:40:33'),(6230,0,3,'85','2021-08-22 11:40:33'),(6231,364,2,'85','2021-08-22 11:40:34'),(6232,364,2,'85','2021-08-22 11:40:35'),(6233,364,2,'85','2021-08-22 11:40:35'),(6234,364,2,'85','2021-08-22 11:40:35'),(6235,364,2,'85','2021-08-22 11:40:37'),(6236,364,2,'85','2021-08-22 11:40:37'),(6237,364,2,'85','2021-08-22 11:40:37'),(6238,364,2,'85','2021-08-22 11:40:37'),(6239,364,2,'85','2021-08-22 11:40:37'),(6240,0,3,'85','2021-08-22 11:40:53'),(6241,364,2,'85','2021-08-22 11:40:54'),(6242,0,3,'85','2021-08-22 11:40:54'),(6243,364,2,'85','2021-08-22 11:40:55'),(6244,0,3,'85','2021-08-22 11:40:55'),(6245,364,2,'85','2021-08-22 11:40:56'),(6246,364,2,'85','2021-08-22 11:40:56'),(6247,0,3,'85','2021-08-22 11:40:57'),(6248,364,2,'85','2021-08-22 11:40:57'),(6249,0,3,'85','2021-08-22 11:40:58'),(6250,364,2,'85','2021-08-22 11:40:58'),(6251,0,3,'85','2021-08-22 11:40:59'),(6252,364,2,'85','2021-08-22 11:40:59'),(6253,0,3,'85','2021-08-22 11:40:59'),(6254,364,2,'85','2021-08-22 11:41:00'),(6255,0,3,'85','2021-08-22 11:41:00'),(6256,364,2,'85','2021-08-22 11:41:00'),(6257,0,3,'85','2021-08-22 11:41:29'),(6258,364,2,'85','2021-08-22 11:41:29'),(6259,364,2,'85','2021-08-22 12:14:36'),(6260,364,2,'85','2021-08-22 12:42:35'),(6261,364,2,'85','2021-08-22 12:42:50'),(6262,364,2,'85','2021-08-22 12:43:14'),(6263,364,2,'85','2021-08-22 12:59:52'),(6264,0,3,'85','2021-08-22 12:59:56'),(6265,364,2,'85','2021-08-22 12:59:56'),(6266,0,3,'85','2021-08-22 13:00:03'),(6267,364,2,'85','2021-08-22 13:00:04'),(6268,0,3,'85','2021-08-22 13:00:05'),(6269,364,2,'85','2021-08-22 13:00:06'),(6270,364,2,'85','2021-08-22 13:00:07'),(6271,0,23,'88','2021-08-22 14:33:27'),(6272,0,23,'88','2021-08-22 14:33:30'),(6273,0,23,'88','2021-08-22 14:33:35'),(6274,0,23,'88','2021-08-22 14:33:35'),(6275,364,2,'85','2021-08-22 16:02:27'),(6276,364,2,'85','2021-08-22 16:02:28'),(6277,364,2,'85','2021-08-22 16:02:28'),(6278,364,2,'85','2021-08-22 16:02:39'),(6279,0,3,'85','2021-08-22 16:02:49'),(6280,364,2,'85','2021-08-22 16:24:09'),(6281,364,2,'85','2021-08-22 16:24:09'),(6282,0,3,'85','2021-08-22 16:24:10'),(6283,0,3,'85','2021-08-22 16:24:10'),(6284,364,2,'85','2021-08-22 16:24:10'),(6285,364,2,'85','2021-08-22 16:24:11'),(6286,0,3,'85','2021-08-22 16:24:11'),(6287,0,3,'85','2021-08-22 16:24:12'),(6288,364,2,'85','2021-08-22 16:24:12'),(6289,364,2,'85','2021-08-22 16:24:13'),(6290,0,24,'85','2021-08-23 17:41:57'),(6291,0,25,'115','2021-08-23 17:47:13'),(6292,0,26,'115','2021-08-23 17:47:41'),(6293,0,25,'115','2021-08-23 17:48:00'),(6294,0,27,'115','2021-08-23 17:48:09'),(6295,0,26,'115','2021-08-23 17:48:10'),(6296,0,25,'115','2021-08-23 17:48:10'),(6297,0,26,'115','2021-08-23 17:48:23'),(6298,0,25,'115','2021-08-23 17:48:24'),(6299,0,25,'115','2021-08-23 17:48:34'),(6300,0,27,'115','2021-08-23 17:48:37'),(6301,0,26,'115','2021-08-23 17:48:39'),(6302,0,29,'115','2021-08-23 17:48:42'),(6303,0,27,'115','2021-08-23 17:48:52'),(6304,0,32,'115','2021-08-23 17:48:53'),(6305,0,26,'115','2021-08-23 17:48:54'),(6306,0,25,'115','2021-08-23 17:48:55'),(6307,0,30,'115','2021-08-23 17:48:56'),(6308,0,29,'115','2021-08-23 17:49:21'),(6309,0,28,'115','2021-08-23 17:49:22'),(6310,0,27,'115','2021-08-23 17:49:22'),(6311,0,26,'115','2021-08-23 17:49:23'),(6312,0,25,'115','2021-08-23 17:49:23'),(6313,0,26,'115','2021-08-23 17:49:24'),(6314,0,27,'115','2021-08-23 17:49:25'),(6315,0,28,'115','2021-08-23 17:49:25'),(6316,0,28,'115','2021-08-23 17:49:26'),(6317,0,28,'115','2021-08-23 17:49:26'),(6318,0,28,'115','2021-08-23 17:49:27'),(6319,0,28,'115','2021-08-23 17:49:28'),(6320,0,28,'115','2021-08-23 17:49:28'),(6321,0,29,'115','2021-08-23 17:49:29'),(6322,0,29,'115','2021-08-23 17:49:29'),(6323,0,30,'115','2021-08-23 17:49:30'),(6324,0,30,'115','2021-08-23 17:49:30'),(6325,0,31,'115','2021-08-23 17:49:30'),(6326,0,32,'115','2021-08-23 17:49:31'),(6327,0,31,'115','2021-08-23 17:49:31'),(6328,0,30,'115','2021-08-23 17:49:32'),(6329,0,30,'115','2021-08-23 17:49:32'),(6330,0,25,'115','2021-08-23 17:49:33'),(6331,0,25,'115','2021-08-23 17:49:36'),(6332,0,25,'115','2021-08-23 17:49:39'),(6333,0,26,'115','2021-08-23 17:49:57'),(6334,0,27,'115','2021-08-23 17:49:58'),(6335,0,28,'115','2021-08-23 17:49:58'),(6336,0,29,'115','2021-08-23 17:49:59'),(6337,0,30,'115','2021-08-23 17:49:59'),(6338,0,31,'115','2021-08-23 17:49:59'),(6339,0,32,'115','2021-08-23 17:50:00'),(6340,0,31,'115','2021-08-23 17:50:06'),(6341,0,32,'115','2021-08-23 17:50:07'),(6342,0,32,'115','2021-08-23 17:50:10'),(6343,0,32,'115','2021-08-23 17:50:10'),(6344,0,31,'115','2021-08-23 17:50:40'),(6345,0,26,'115','2021-08-23 17:52:33'),(6346,0,25,'115','2021-08-23 17:52:33'),(6347,0,32,'115','2021-08-23 17:52:33'),(6348,0,27,'115','2021-08-23 17:52:33'),(6349,0,32,'115','2021-08-23 17:52:36'),(6350,0,3,'85','2021-08-23 17:52:57'),(6351,0,24,'85','2021-08-23 17:52:58'),(6352,0,24,'85','2021-08-23 17:52:58'),(6353,0,3,'85','2021-08-23 17:52:59'),(6354,0,3,'85','2021-08-23 17:52:59'),(6355,0,3,'85','2021-08-23 17:53:00'),(6356,364,2,'85','2021-08-23 17:53:00'),(6357,364,2,'85','2021-08-23 17:53:01'),(6358,364,2,'85','2021-08-23 17:53:01'),(6359,364,2,'85','2021-08-23 17:53:02'),(6360,0,32,'115','2021-08-23 17:53:08'),(6361,0,32,'115','2021-08-23 17:53:09'),(6362,0,31,'115','2021-08-23 17:53:09'),(6363,0,32,'115','2021-08-23 17:53:10'),(6364,364,2,'115','2021-08-23 17:54:47'),(6365,364,2,'115','2021-08-23 17:55:02'),(6366,364,2,'115','2021-08-23 17:55:03'),(6367,0,3,'115','2021-08-23 17:55:11'),(6368,0,2,'115','2021-08-23 17:55:13'),(6369,0,3,'115','2021-08-23 17:55:14'),(6370,0,2,'88','2021-08-23 18:40:27'),(6371,0,2,'88','2021-08-23 18:40:58'),(6372,0,2,'88','2021-08-23 18:40:59'),(6373,0,2,'88','2021-08-23 18:40:59'),(6374,0,3,'115','2021-08-24 10:16:19'),(6375,0,3,'85','2021-08-24 10:26:48'),(6376,0,3,'85','2021-08-24 10:26:49'),(6377,0,3,'85','2021-08-24 10:26:53'),(6378,0,2,'85','2021-08-24 10:26:54'),(6379,0,3,'85','2021-08-24 10:26:55'),(6380,0,2,'85','2021-08-24 11:36:57'),(6381,0,3,'85','2021-08-24 11:37:04'),(6382,1,2,'85','2021-08-24 11:37:05'),(6383,0,3,'85','2021-08-24 11:37:08'),(6384,1,2,'85','2021-08-24 11:38:38'),(6385,1,2,'85','2021-08-24 11:40:37'),(6386,1,2,'88','2021-08-24 18:34:26'),(6387,1,2,'88','2021-08-24 18:52:59'),(6388,1,2,'88','2021-08-24 18:59:23'),(6389,1,2,'88','2021-08-24 19:02:07'),(6390,1,2,'88','2021-08-24 19:03:57'),(6391,1,2,'88','2021-08-24 19:08:31'),(6392,1,2,'88','2021-08-24 19:08:34'),(6393,1,2,'88','2021-08-24 19:10:51'),(6394,1,2,'88','2021-08-24 19:10:54'),(6395,1,2,'88','2021-08-24 19:10:55'),(6396,1,2,'88','2021-08-24 19:11:06'),(6397,1,2,'88','2021-08-24 19:11:07'),(6398,1,2,'88','2021-08-24 19:11:10'),(6399,1,2,'88','2021-08-24 19:11:11'),(6400,1,2,'88','2021-08-24 19:11:13'),(6401,1,2,'88','2021-08-24 19:11:14'),(6402,1,2,'88','2021-08-24 19:11:20'),(6403,1,2,'88','2021-08-24 19:11:46'),(6404,1,2,'88','2021-08-24 19:11:49'),(6405,1,2,'88','2021-08-24 19:11:50'),(6406,1,2,'88','2021-08-24 19:11:50'),(6407,1,2,'88','2021-08-24 19:11:51'),(6408,1,2,'88','2021-08-24 19:11:52'),(6409,1,2,'88','2021-08-24 19:11:52'),(6410,1,2,'88','2021-08-24 19:11:53'),(6411,1,2,'88','2021-08-24 19:11:56'),(6412,1,2,'88','2021-08-24 19:12:43'),(6413,1,2,'88','2021-08-24 19:13:24'),(6414,1,2,'88','2021-08-24 19:13:39'),(6415,1,2,'88','2021-08-24 19:14:40'),(6416,1,2,'88','2021-08-24 19:14:42'),(6417,1,2,'88','2021-08-24 19:14:43'),(6418,1,2,'88','2021-08-24 19:14:44'),(6419,1,2,'88','2021-08-24 19:14:44'),(6420,1,2,'88','2021-08-24 19:14:45'),(6421,1,2,'88','2021-08-24 19:14:45'),(6422,1,2,'88','2021-08-24 19:14:47'),(6423,1,2,'88','2021-08-24 19:14:48'),(6424,1,2,'88','2021-08-24 19:14:49'),(6425,1,2,'88','2021-08-24 19:15:04'),(6426,1,2,'88','2021-08-24 19:15:24'),(6427,1,2,'88','2021-08-24 19:15:25'),(6428,1,2,'88','2021-08-24 19:15:26'),(6429,1,2,'88','2021-08-24 19:15:29'),(6430,1,2,'88','2021-08-24 19:15:29'),(6431,1,2,'88','2021-08-24 19:15:30'),(6432,1,2,'88','2021-08-24 19:15:30'),(6433,1,2,'88','2021-08-24 19:15:31'),(6434,1,2,'88','2021-08-24 19:15:39'),(6435,1,2,'88','2021-08-24 19:16:06'),(6436,1,2,'88','2021-08-24 19:16:07'),(6437,1,2,'88','2021-08-24 19:17:05'),(6438,1,2,'88','2021-08-24 19:18:20'),(6439,1,2,'88','2021-08-24 19:18:37'),(6440,1,2,'88','2021-08-24 19:19:44'),(6441,1,2,'88','2021-08-24 19:23:27'),(6442,1,2,'88','2021-08-24 19:24:05'),(6443,1,2,'88','2021-08-24 19:25:11'),(6444,1,2,'88','2021-08-24 19:25:13'),(6445,1,2,'88','2021-08-24 19:25:27'),(6446,1,2,'88','2021-08-24 19:25:53'),(6447,1,2,'88','2021-08-24 19:26:04'),(6448,1,2,'88','2021-08-24 19:26:38'),(6449,1,2,'88','2021-08-24 19:27:33'),(6450,1,2,'88','2021-08-24 19:27:49'),(6451,1,2,'88','2021-08-24 19:28:08'),(6452,1,2,'88','2021-08-24 19:28:49'),(6453,1,2,'88','2021-08-24 19:29:12'),(6454,1,2,'88','2021-08-24 19:29:59'),(6455,1,2,'88','2021-08-24 19:30:19'),(6456,1,2,'88','2021-08-24 19:32:18'),(6457,1,2,'88','2021-08-24 19:33:12'),(6458,1,2,'88','2021-08-24 19:34:59'),(6459,1,2,'88','2021-08-24 19:39:24'),(6460,1,2,'88','2021-08-24 19:40:03'),(6461,1,2,'88','2021-08-24 19:40:34'),(6462,1,2,'88','2021-08-24 19:40:35'),(6463,1,2,'88','2021-08-24 19:40:35'),(6464,1,2,'88','2021-08-24 19:41:28'),(6465,1,2,'88','2021-08-24 19:42:49'),(6466,1,2,'88','2021-08-24 19:43:14'),(6467,1,2,'88','2021-08-24 19:44:31'),(6468,1,2,'88','2021-08-24 19:44:54'),(6469,1,2,'88','2021-08-24 19:45:16'),(6470,1,2,'88','2021-08-24 19:45:41'),(6471,1,2,'88','2021-08-24 19:46:02'),(6472,1,2,'88','2021-08-24 19:46:44'),(6473,1,2,'88','2021-08-24 19:47:49'),(6474,1,2,'88','2021-08-24 19:48:01'),(6475,1,2,'88','2021-08-24 19:48:22'),(6476,1,2,'88','2021-08-24 19:48:47'),(6477,1,2,'88','2021-08-24 19:50:38'),(6478,1,2,'88','2021-08-24 19:50:52'),(6479,1,2,'88','2021-08-24 19:54:27'),(6480,1,2,'88','2021-08-30 18:00:43'),(6481,1,2,'88','2021-08-30 18:00:44'),(6482,1,2,'88','2021-08-30 18:00:45'),(6483,1,2,'88','2021-08-30 18:00:48'),(6484,1,2,'88','2021-08-30 18:00:49'),(6485,1,2,'88','2021-08-30 18:00:50'),(6486,1,2,'88','2021-08-30 18:00:53'),(6487,1,2,'88','2021-08-30 18:00:54'),(6488,1,2,'88','2021-08-30 18:00:54'),(6489,1,2,'88','2021-08-30 18:00:57'),(6490,1,2,'88','2021-08-30 18:00:58'),(6491,1,2,'88','2021-08-30 18:00:59'),(6492,1,2,'88','2021-08-30 18:01:03'),(6493,1,2,'88','2021-08-30 18:01:05'),(6494,0,3,'115','2021-08-31 20:30:50'),(6495,0,3,'115','2021-08-31 20:30:51'),(6496,1,2,'115','2021-08-31 20:30:52'),(6497,0,3,'115','2021-08-31 20:30:53'),(6498,1,2,'115','2021-08-31 20:32:38'),(6499,1,2,'115','2021-08-31 20:32:39'),(6500,0,3,'115','2021-08-31 20:39:42'),(6501,0,3,'115','2021-08-31 20:39:45'),(6502,1,2,'88','2021-09-24 11:00:01'),(6503,1,2,'88','2021-09-24 11:02:29');
/*!40000 ALTER TABLE `showedmessages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slow_log`
--

DROP TABLE IF EXISTS `slow_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slow_log` (
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_host` mediumtext NOT NULL,
  `query_time` time NOT NULL,
  `lock_time` time NOT NULL,
  `rows_sent` int NOT NULL,
  `rows_examined` int NOT NULL,
  `db` varchar(512) NOT NULL,
  `last_insert_id` int NOT NULL,
  `insert_id` int NOT NULL,
  `server_id` int unsigned NOT NULL,
  `sql_text` mediumtext NOT NULL,
  `thread_id` bigint unsigned NOT NULL
) ENGINE=CSV DEFAULT CHARSET=utf8mb3 COMMENT='Slow log';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slow_log`
--

LOCK TABLES `slow_log` WRITE;
/*!40000 ALTER TABLE `slow_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `slow_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tagbox`
--

DROP TABLE IF EXISTS `tagbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tagbox` (
  `tagid` int NOT NULL AUTO_INCREMENT,
  `tagname` varchar(45) NOT NULL,
  PRIMARY KEY (`tagid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagbox`
--

LOCK TABLES `tagbox` WRITE;
/*!40000 ALTER TABLE `tagbox` DISABLE KEYS */;
INSERT INTO `tagbox` VALUES (1,'Horeca'),(2,'Retail'),(3,'Bezorging'),(4,'Horeca'),(5,'Retail'),(6,'Bezorging'),(7,'Horeca'),(8,'Retail'),(9,'Bezorging'),(10,'Barvrouw'),(11,'Barman'),(12,'Flexibel'),(13,'Sdfsdfsdf'),(14,'Tet'),(15,'Test'),(16,'Supermarkt'),(17,'Testww'),(18,'Verkoper'),(19,'Vissen'),(20,'Gezellig'),(21,'Gezellig team'),(22,'Cool!'),(23,'Brood'),(24,'Groen werken'),(25,'Vulploeg');
/*!40000 ALTER TABLE `tagbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userroles` (
  `iduserroles` int NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduserroles`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (4,'ROLE_ADMIN'),(5,'ROLE_MODERATOR'),(6,'ROLE_APPUSER');
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verificationcodes`
--

DROP TABLE IF EXISTS `verificationcodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verificationcodes` (
  `idverificationcodes` int NOT NULL AUTO_INCREMENT,
  `code` int NOT NULL,
  `userid` int NOT NULL,
  `requesttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idverificationcodes`),
  KEY `webuser_idx` (`userid`),
  CONSTRAINT `webuser` FOREIGN KEY (`userid`) REFERENCES `webusers` (`idwebusers`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verificationcodes`
--

LOCK TABLES `verificationcodes` WRITE;
/*!40000 ALTER TABLE `verificationcodes` DISABLE KEYS */;
INSERT INTO `verificationcodes` VALUES (18,905403681,85,'2021-05-26 21:11:12'),(19,317195301,86,'2021-05-26 21:16:49'),(20,872738305,87,'2021-05-27 08:42:27'),(21,269943840,88,'2021-05-27 10:28:46'),(22,697237522,89,'2021-05-27 13:03:03'),(23,938762352,90,'2021-05-27 13:42:16'),(24,776922074,91,'2021-06-07 11:40:10'),(25,157283614,92,'2021-06-11 13:28:00'),(26,783274369,93,'2021-06-11 13:28:35'),(27,410353657,94,'2021-06-13 18:31:51'),(28,400822717,95,'2021-06-13 18:33:49'),(29,905047184,96,'2021-06-13 18:37:17'),(30,314308761,97,'2021-06-13 18:47:04'),(31,772059892,98,'2021-06-14 17:43:44'),(32,551066514,99,'2021-06-14 17:46:39'),(33,309623932,100,'2021-06-15 22:53:03'),(34,114221454,101,'2021-06-22 15:17:23'),(35,749482367,103,'2021-06-22 15:19:32'),(36,419051018,104,'2021-06-26 16:33:01'),(37,655509905,105,'2021-06-26 16:33:34'),(38,546198279,106,'2021-06-26 16:34:26'),(39,412077119,107,'2021-07-01 08:27:30'),(40,798526530,112,'2021-07-20 14:22:51'),(41,408794184,113,'2021-08-03 12:54:37'),(42,171415954,114,'2021-08-22 15:47:49'),(43,522204617,115,'2021-08-23 11:15:42');
/*!40000 ALTER TABLE `verificationcodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verificationcodesapp`
--

DROP TABLE IF EXISTS `verificationcodesapp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verificationcodesapp` (
  `idverificationcodes` int NOT NULL AUTO_INCREMENT,
  `code` int NOT NULL,
  `userid` int NOT NULL,
  `requesttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idverificationcodes`),
  KEY `appuser_idx` (`userid`),
  CONSTRAINT `appuser_foreignkey` FOREIGN KEY (`userid`) REFERENCES `appusers` (`idappusers`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verificationcodesapp`
--

LOCK TABLES `verificationcodesapp` WRITE;
/*!40000 ALTER TABLE `verificationcodesapp` DISABLE KEYS */;
INSERT INTO `verificationcodesapp` VALUES (51,293496714,3,'2021-09-10 14:11:33');
/*!40000 ALTER TABLE `verificationcodesapp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webusers`
--

DROP TABLE IF EXISTS `webusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `webusers` (
  `idwebusers` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `profilepicture` tinytext,
  `verified` varchar(45) NOT NULL DEFAULT 'False',
  `roleid` int DEFAULT '1',
  PRIMARY KEY (`idwebusers`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `role_idx` (`roleid`),
  CONSTRAINT `role` FOREIGN KEY (`roleid`) REFERENCES `userroles` (`iduserroles`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webusers`
--

LOCK TABLES `webusers` WRITE;
/*!40000 ALTER TABLE `webusers` DISABLE KEYS */;
INSERT INTO `webusers` VALUES (85,'zyadosseyran@gmail.com','P2YQFJPOxWuW+O49QogeKA==','zyad','osseyran','https://swipeyourjob.nl/api_assets/1517596536464.jpeg','True',4),(86,'zyad.osseyran@student.hu.nl','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'True',4),(87,'bart@swipeyourjob.nl','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(88,'lars@swipeyourjob.nl','P2YQFJPOxWuW+O49QogeKA==','Lars','van Scheijndel','https://swipeyourjob.nl/api_assets/rock-star-1472736_1920.jpg','False',4),(89,'jeroen.weber@hu.nl','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'True',4),(90,'barteld.kuijt@student.hu.nl','sXRU4i/VViyMI2XAY760Wg==',NULL,NULL,NULL,'True',4),(91,'dahir@swipeyourjob.nl','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(92,'lksjdflksdkdsjf@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(93,'sldkjfsldkfjsdf33@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(94,'lsdkfjlsdkjflskdjfd@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(95,'sldkfjsldf@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(96,'lsdkjf@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(97,'lskdjf@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(98,'sdlfkj@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(99,'dsf@sdf.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(100,'info@souf.nl','P2YQFJPOxWuW+O49QogeKA==','willem','van oranje','https://swipeyourjob.nl/api_assets/willem.jpeg','True',4),(101,'zyad.osseyran@ingrammicro.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(103,'zyadee@sip.nl','hkpNyr2FRJGBEMxTADm8/w==',NULL,NULL,NULL,'False',4),(104,'slkdfjlsdkjf@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(105,'sldkfj@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(106,'sdf@sdfsd.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(107,'dahirwarsame@gmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'True',4),(112,'dahir.warsame@gmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'True',4),(113,'bartenilja11@hotmail.com','+2sU4wFtmi3gPfh/5Yc0PQ==',NULL,NULL,NULL,'False',4),(114,'info@water-bron.nl','2rwbJFA5M1UJKVRkhdrjiQ==',NULL,NULL,NULL,'False',4),(115,'barteldkuijt@hotmail.com','N9bY37eduTOQXu2ED4oxNw==','Barteld','Kuijt','https://swipeyourjob.nl/api_assets/Schermafbeelding 2021-08-23 om 13.17.08.png','True',4);
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

-- Dump completed on 2021-10-24 13:50:24
