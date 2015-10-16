-- MySQL dump 10.13  Distrib 5.6.26, for osx10.10 (x86_64)
--
-- Host: localhost    Database: EventTracker
-- ------------------------------------------------------
-- Server version	5.6.26
--
-- Table structure for table `attendee`
--

DROP TABLE IF EXISTS `attendee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendee` (
  `attendee_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(31) NOT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `email` varchar(51) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `fk_event_id` int(11) NOT NULL,
  `company` varchar(31) DEFAULT NULL,
  PRIMARY KEY (`attendee_id`),
  KEY `idx_attendee_id` (`attendee_id`),
  KEY `idx_aname` (`name`),
  KEY `fk_event` (`fk_event_id`),
  CONSTRAINT `attendee_ibfk_1` FOREIGN KEY (`fk_event_id`) REFERENCES `event` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(31) NOT NULL,
  `date` date NOT NULL,
  `location` varchar(31) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `url` varchar(51) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `idx_event_id` (`event_id`),
  KEY `idx_ename` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
