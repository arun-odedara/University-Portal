-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: login
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `alumni`
--

DROP TABLE IF EXISTS `alumni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumni` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_name` varchar(45) NOT NULL,
  `founded` varchar(45) NOT NULL,
  `link` varchar(45) NOT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumni`
--

LOCK TABLES `alumni` WRITE;
/*!40000 ALTER TABLE `alumni` DISABLE KEYS */;
INSERT INTO `alumni` VALUES (1,'Jainam','2016','jainam.com'),(2,'jainu','2016','google.com'),(3,'Akki','1258','facebook.com'),(4,'Shaoni','2016','fkjbgkdj.com');
/*!40000 ALTER TABLE `alumni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(45) NOT NULL,
  `o_Hours` varchar(45) NOT NULL,
  `TA` varchar(45) NOT NULL,
  `Syllabus` varchar(405) NOT NULL,
  `n_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'c_Logic','1-2','June Rose','Algebra, Unification, Set Clauses','abc'),(2,'SE','2-3','Ross Geller','Agile, Design Pattern, Web Developmen','pdran'),(3,'CN','3-4','Monica Geller','Routing, Layers, Wireshark','abc'),(4,'OS','4-5','Rachel Green','Kernal, Ubuntu System, RAID','abc'),(5,'SE','3-5','2-3','Agile, Design Pattern, Web Developmen\r\n','pdran'),(6,'Algo & data Structure','Tuesday 5-6','Chang Jiang','Algo Database management and structures','pdran'),(7,'Distributed System','Friday','D Patel','Multi threading, POSIX','abc');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discuss`
--

DROP TABLE IF EXISTS `discuss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discuss` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(45) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discuss`
--

LOCK TABLES `discuss` WRITE;
/*!40000 ALTER TABLE `discuss` DISABLE KEYS */;
INSERT INTO `discuss` VALUES (1,'Global warming'),(2,'Pollution '),(3,'Poverty '),(4,'Technology'),(5,'Space Junk');
/*!40000 ALTER TABLE `discuss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discuss_post`
--

DROP TABLE IF EXISTS `discuss_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discuss_post` (
  `t_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post` varchar(450) NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `t_id_idx` (`t_id`),
  CONSTRAINT `t_id` FOREIGN KEY (`t_id`) REFERENCES `discuss` (`t_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discuss_post`
--

LOCK TABLES `discuss_post` WRITE;
/*!40000 ALTER TABLE `discuss_post` DISABLE KEYS */;
INSERT INTO `discuss_post` VALUES (1,1,'helloooo'),(1,2,'how are you'),(1,3,'what up ??'),(4,4,'helloooooooo'),(4,5,'Hellooooooooooooo'),(5,6,'It is all junk\r\n'),(3,7,'hey\r\n'),(3,8,'hey\r\n');
/*!40000 ALTER TABLE `discuss_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_staff`
--

DROP TABLE IF EXISTS `faculty_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_staff` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `nid` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_staff`
--

LOCK TABLES `faculty_staff` WRITE;
/*!40000 ALTER TABLE `faculty_staff` DISABLE KEYS */;
INSERT INTO `faculty_staff` VALUES (1,'P Naren','Dran','Faculty','pdran','pdran'),(2,'abc','abc','Faculty','abc','abc'),(3,'Maria','Zhelva','Faculty','mz12345','12345');
/*!40000 ALTER TABLE `faculty_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phd`
--

DROP TABLE IF EXISTS `phd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phd` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sem` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phd`
--

LOCK TABLES `phd` WRITE;
/*!40000 ALTER TABLE `phd` DISABLE KEYS */;
/*!40000 ALTER TABLE `phd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `nid` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `program` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Arunkumar','Odedara','Student','ao12345','12345','2015','MS'),(2,'Shaoni ','Paul','Student','SP12345','12345','2015','PHD'),(3,'John','Geller','Student','jg12345','12345','2014','PHD'),(4,'Chris','Diggle','Student','cd12345','12345','2013','PHD'),(5,'Justine','Miller','Student','jm12345','12345','2012','MS');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-03 17:12:39
