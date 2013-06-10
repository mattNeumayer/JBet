-- MySQL dump 10.13  Distrib 5.6.11, for Win64 (x86_64)
--
-- Host: localhost    Database: jbet
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Current Database: `jbet`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jbet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jbet`;

--
-- Table structure for table `league`
--

DROP TABLE IF EXISTS `league`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `league` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `league`
--

LOCK TABLES `league` WRITE;
/*!40000 ALTER TABLE `league` DISABLE KEYS */;
/*!40000 ALTER TABLE `league` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matchday`
--

DROP TABLE IF EXISTS `matchday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matchday` (
  `MD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `season` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`MD_ID`),
  KEY `season` (`season`),
  CONSTRAINT `matchday_ibfk_1` FOREIGN KEY (`season`) REFERENCES `season` (`S_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matchday`
--

LOCK TABLES `matchday` WRITE;
/*!40000 ALTER TABLE `matchday` DISABLE KEYS */;
/*!40000 ALTER TABLE `matchday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matchup`
--

DROP TABLE IF EXISTS `matchup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matchup` (
  `M_ID` int(11) NOT NULL AUTO_INCREMENT,
  `matchday` int(11) NOT NULL,
  `team1` varchar(255) NOT NULL,
  `team2` varchar(255) NOT NULL,
  `score1` int(11) DEFAULT NULL,
  `score2` int(11) DEFAULT NULL,
  PRIMARY KEY (`M_ID`),
  KEY `matchday` (`matchday`),
  KEY `team1` (`team1`),
  KEY `team2` (`team2`),
  CONSTRAINT `matchup_ibfk_1` FOREIGN KEY (`matchday`) REFERENCES `matchday` (`MD_ID`),
  CONSTRAINT `matchup_ibfk_2` FOREIGN KEY (`team1`) REFERENCES `team` (`name`),
  CONSTRAINT `matchup_ibfk_3` FOREIGN KEY (`team2`) REFERENCES `team` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matchup`
--

LOCK TABLES `matchup` WRITE;
/*!40000 ALTER TABLE `matchup` DISABLE KEYS */;
/*!40000 ALTER TABLE `matchup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `season`
--

DROP TABLE IF EXISTS `season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season` (
  `S_ID` int(11) NOT NULL AUTO_INCREMENT,
  `league` varchar(255) NOT NULL,
  `startYear` int(11) NOT NULL,
  PRIMARY KEY (`S_ID`),
  KEY `league` (`league`),
  CONSTRAINT `season_ibfk_1` FOREIGN KEY (`league`) REFERENCES `league` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season`
--

LOCK TABLES `season` WRITE;
/*!40000 ALTER TABLE `season` DISABLE KEYS */;
/*!40000 ALTER TABLE `season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-06  0:38:55
