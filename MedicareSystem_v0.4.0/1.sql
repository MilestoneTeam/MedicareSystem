-- MySQL dump 10.10
--
-- Host: localhost    Database: medicaresystem
-- ------------------------------------------------------
-- Server version	5.0.18-nt

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `physicianLicenseNum` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY  (`physicianLicenseNum`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `doctor`
--


/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
LOCK TABLES `doctor` WRITE;
INSERT INTO `doctor` VALUES ('aa','11');
UNLOCK TABLES;
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;

--
-- Table structure for table `doctorinfo`
--

DROP TABLE IF EXISTS `doctorinfo`;
CREATE TABLE `doctorinfo` (
  `physicianLicenseNum` varchar(20) NOT NULL,
  `name` varchar(20) default NULL,
  `sex` tinyint(1) default NULL,
  `age` int(11) default NULL,
  `profession` varchar(20) default NULL,
  `hospital` varchar(40) default NULL,
  `location` varchar(80) default NULL,
  `phone` varchar(20) default NULL,
  `resume` varchar(400) default NULL,
  KEY `FK_doctorinfo_1` (`physicianLicenseNum`),
  CONSTRAINT `FK_doctorinfo_1` FOREIGN KEY (`physicianLicenseNum`) REFERENCES `doctor` (`physicianLicenseNum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `doctorinfo`
--


/*!40000 ALTER TABLE `doctorinfo` DISABLE KEYS */;
LOCK TABLES `doctorinfo` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `doctorinfo` ENABLE KEYS */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `medicareNum` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY  (`medicareNum`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `patient`
--


/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
LOCK TABLES `patient` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;

--
-- Table structure for table `patientinfo`
--

DROP TABLE IF EXISTS `patientinfo`;
CREATE TABLE `patientinfo` (
  `medicareNum` varchar(20) NOT NULL,
  `name` varchar(20) default NULL,
  `sex` tinyint(1) default NULL,
  `age` int(11) default NULL,
  `birthday` date default NULL,
  `marriage` int(11) default NULL,
  `nationality` varchar(20) default NULL,
  PRIMARY KEY  (`medicareNum`),
  CONSTRAINT `FK_patientinfo_1` FOREIGN KEY (`medicareNum`) REFERENCES `patient` (`medicareNum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `patientinfo`
--


/*!40000 ALTER TABLE `patientinfo` DISABLE KEYS */;
LOCK TABLES `patientinfo` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `patientinfo` ENABLE KEYS */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'aa','s'),(2,'aa','s'),(3,'aa','s');
UNLOCK TABLES;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

