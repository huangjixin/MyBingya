-- MySQL dump 10.13  Distrib 5.6.20, for Win64 (x86_64)
--
-- Host: localhost    Database: jcincms
-- ------------------------------------------------------
-- Server version	5.6.20-log

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
-- Table structure for table `tb_article`
--

DROP TABLE IF EXISTS `tb_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_article` (
  `id` varchar(120) NOT NULL,
  `title` varchar(120) DEFAULT NULL,
  `author` varchar(120) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `tb_category_id` varchar(120) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `source` varchar(120) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_id` (`tb_category_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`tb_category_id`) REFERENCES `tb_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_article`
--

LOCK TABLES `tb_article` WRITE;
/*!40000 ALTER TABLE `tb_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_asset`
--

DROP TABLE IF EXISTS `tb_asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_asset` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `path` varchar(4500) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_asset`
--

LOCK TABLES `tb_asset` WRITE;
/*!40000 ALTER TABLE `tb_asset` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_category`
--

DROP TABLE IF EXISTS `tb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_category` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `parentId` varchar(120) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category`
--

LOCK TABLES `tb_category` WRITE;
/*!40000 ALTER TABLE `tb_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comment`
--

DROP TABLE IF EXISTS `tb_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_comment` (
  `id` varchar(120) NOT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `tb_article_id` varchar(120) DEFAULT NULL,
  `parentId` varchar(120) DEFAULT NULL,
  `updateDate` varchar(120) DEFAULT NULL,
  `createDate` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbartilce` (`tb_article_id`),
  KEY `fk_tb_comment_tb_comment1` (`parentId`),
  CONSTRAINT `fk_tb_comment_tb_comment1` FOREIGN KEY (`parentId`) REFERENCES `tb_comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbartilce` FOREIGN KEY (`tb_article_id`) REFERENCES `tb_article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comment`
--

LOCK TABLES `tb_comment` WRITE;
/*!40000 ALTER TABLE `tb_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_menu` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `path` varchar(120) DEFAULT NULL,
  `parentId` varchar(120) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `icon` varchar(120) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `url` varchar(1200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_menu_menu1` (`parentId`),
  CONSTRAINT `fk_menu_menu1` FOREIGN KEY (`parentId`) REFERENCES `tb_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES ('1419930903603','首页',NULL,NULL,NULL,'2014-12-30 00:00:00',NULL,'2014-12-30 00:00:00',NULL),('1419931477180','后台首页',NULL,NULL,'1419930903603','2014-12-30 00:00:00',NULL,'2014-12-30 00:00:00',NULL),('1419931503085','系统信息',NULL,NULL,'1419930903603','2014-12-30 00:00:00',NULL,'2014-12-30 00:00:00',NULL),('1419931535605','密码修改',NULL,NULL,'1419930903603','2014-12-30 00:00:00',NULL,'2014-12-30 00:00:00',NULL),('1420007677161','系统管理',NULL,NULL,NULL,'2014-12-31 00:00:00',NULL,'2014-12-31 00:00:00',NULL),('1420007732563','菜单管理',NULL,NULL,NULL,'2014-12-31 00:00:00',NULL,'2014-12-31 00:00:00','menu/list'),('1420024828218','用户管理',NULL,NULL,NULL,'2014-12-31 00:00:00',NULL,'2014-12-31 00:00:00','user/list'),('1420353382807','操作日志',NULL,NULL,NULL,'2015-01-04 00:00:00',NULL,'2015-01-04 00:00:00','opelog/list'),('1420447362845','localhost',NULL,NULL,NULL,'2015-01-05 16:42:43',NULL,'2015-01-05 16:42:43','');
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_operationlog`
--

DROP TABLE IF EXISTS `tb_operationlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_operationlog` (
  `id` varchar(120) NOT NULL,
  `operator` varchar(120) DEFAULT NULL,
  `name` varchar(120) DEFAULT NULL,
  `ip` varchar(120) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(1200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_operationlog`
--

LOCK TABLES `tb_operationlog` WRITE;
/*!40000 ALTER TABLE `tb_operationlog` DISABLE KEYS */;
INSERT INTO `tb_operationlog` VALUES ('1420341589772',NULL,'com.jcin.cms.domain.Menu.insert',NULL,'2015-01-04 00:00:00',NULL),('1420341825164',NULL,'com.jcin.cms.domain.Menu.deleteByPrimaryKey',NULL,'2015-01-04 00:00:00',NULL),('1420342024189',NULL,'com.jcin.cms.domain.Menu.insert',NULL,'2015-01-04 00:00:00',NULL),('1420348212662',NULL,'com.jcin.cms.domain.Menu.deleteByPrimaryKey',NULL,'2015-01-04 00:00:00',NULL),('1420348287948',NULL,'com.jcin.cms.domain.User.update',NULL,'2015-01-04 00:00:00',NULL),('1420349286440',NULL,'com.jcin.cms.domain.User.update',NULL,'2015-01-04 00:00:00',NULL),('1420350266699',NULL,'com.jcin.cms.domain.User.update',NULL,'2015-01-04 00:00:00',NULL),('1420350414347',NULL,'com.jcin.cms.domain.User.update',NULL,'2015-01-04 00:00:00',NULL),('1420350414606','admin','com.jcin.cms.web.LoginController.validateLogin',NULL,'2015-01-04 00:00:00',NULL),('1420350642657',NULL,'com.jcin.cms.domain.User.update 更新成功',NULL,'2015-01-04 00:00:00',NULL),('1420350642932','admin','com.jcin.cms.web.LoginController.validateLogin 登录成功',NULL,'2015-01-04 00:00:00',NULL),('1420350644822','admin','com.jcin.cms.domain.User.update 更新成功',NULL,'2015-01-04 00:00:00',NULL),('1420350644866','admin','com.jcin.cms.web.LoginController.validateLogin 登录成功',NULL,'2015-01-04 00:00:00',NULL),('1420352484547',NULL,'com.jcin.cms.domain.Menu.insert 添加成功',NULL,'2015-01-04 00:00:00',NULL),('1420353267409',NULL,'com.jcin.cms.domain.Menu.insert 添加成功',NULL,'2015-01-04 00:00:00',NULL),('1420365280429',NULL,'com.jcin.cms.domain.Menu.insert 添加成功',NULL,'2015-01-04 00:00:00',NULL),('1420365283138',NULL,'com.jcin.cms.domain.Menu.insert 添加成功',NULL,'2015-01-04 00:00:00',NULL),('1420365284684',NULL,'com.jcin.cms.domain.Menu.insert 添加成功',NULL,'2015-01-04 00:00:00',NULL),('1420365285651',NULL,'com.jcin.cms.domain.Menu.insert 添加成功',NULL,'2015-01-04 00:00:00',NULL),('1420447362845',NULL,'com.jcin.cms.domain.Menu.insert 添加成功',NULL,'2015-01-05 16:42:43',NULL);
/*!40000 ALTER TABLE `tb_operationlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_role` (
  `id` varchar(120) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_menu`
--

DROP TABLE IF EXISTS `tb_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_role_menu` (
  `role_id` varchar(120) DEFAULT NULL,
  `menu_id` varchar(120) DEFAULT NULL,
  `id` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_table1_role1` (`role_id`),
  KEY `fk_table1_menu1` (`menu_id`),
  KEY `fk_role_menu_menu1` (`menu_id`),
  KEY `fk_role_menu_role1` (`role_id`),
  CONSTRAINT `fk_role_menu_menu1` FOREIGN KEY (`menu_id`) REFERENCES `tb_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_role_menu_role1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_menu`
--

LOCK TABLES `tb_role_menu` WRITE;
/*!40000 ALTER TABLE `tb_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` varchar(120) NOT NULL,
  `username` varchar(120) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `status` smallint(6) DEFAULT '1',
  `description` varchar(120) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `ip` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('1','admin','admin',1,NULL,NULL,NULL,'2015-01-02 00:00:00',''),('1420083533509','123456','123456',NULL,NULL,NULL,'2015-01-01 00:00:00','2015-01-01 00:00:00',NULL),('1420180720300','123456','123456',NULL,NULL,NULL,'2015-01-02 00:00:00','2015-01-02 00:00:00',NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_role`
--

DROP TABLE IF EXISTS `tb_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_role` (
  `id` varchar(120) NOT NULL,
  `user_id` varchar(120) NOT NULL,
  `role_id` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_user` (`user_id`),
  KEY `fk_user_role_role1` (`role_id`),
  CONSTRAINT `fk_user_role_role1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_role`
--

LOCK TABLES `tb_user_role` WRITE;
/*!40000 ALTER TABLE `tb_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-05 18:24:25
