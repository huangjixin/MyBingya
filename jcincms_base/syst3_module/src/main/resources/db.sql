CREATE DATABASE  IF NOT EXISTS `jcincms3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jcincms3`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: jcincms3
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` varchar(120) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `create_by` varchar(45) DEFAULT NULL,
  `remote_addr` varchar(45) DEFAULT NULL,
  `user_agent` varchar(45) DEFAULT NULL,
  `request_uri` varchar(120) DEFAULT NULL,
  `Method` varchar(45) DEFAULT NULL,
  `params` varchar(1200) DEFAULT NULL,
  `exception` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES ('1444461791779','access','admin','/syst/admin',NULL,'/syst/admin/user/create','POST','username=11&password=&roleId=1',''),('1444462164666','access','admin','/syst/admin',NULL,'/syst/admin/user/create','POST','username=ewew&password=&roleId=1',''),('1444462267090','access','admin','/syst/admin',NULL,'/syst/admin/user/deleteById','POST','idstring=1444462156956',''),('1444473873451','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','id=&value=dsfdsf&label=fsdfs&type=dsf',''),('1444521665878','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','id=&value=klkl&label=klkl&type=dsf',''),('1444521698983','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/deleteById','POST','idstring=1444521665766',''),('1444522698205','access','admin','/syst/admin',NULL,'/syst/admin/test/create','POST','id=&name=dsds&createDate=&updateDate=',''),('1444522751730','access','admin','/syst/admin',NULL,'/syst/admin/test/deleteById','POST','idstring=1444522696210',''),('1444522792673','access','admin','/syst/admin',NULL,'/syst/admin/test/create','POST','id=eww&name=wqwq&createDate=&updateDate=',''),('1444522818280','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqiii&createDate=Sun Oct 11 08:19:53 CST 2015&updateDate=',''),('1444522877181','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqiii&createDate=Sun Oct 11 08:19:53 CST 2015&updateDate=',''),('1444523023078','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqii&createDate=Sun Oct 11 08:19:53 CST 2015&updateDate=',''),('1444523252297','access','admin','/syst/admin',NULL,'/syst/admin/user/update/2','POST','id=2&username=test1&password=&roleId=2',''),('1444523367070','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqewew',''),('1444523435595','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqiiiiii',''),('1444523458827','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=test',''),('1444523589961','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=test112',''),('1444526990037','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=&parentIds=&name=test&available=',''),('1444527152005','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=&parentIds=&name=test&available=',''),('1444534867380','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=&parentIds=&name=ass&available=',''),('1444548142682','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=2&name=组织管理&authName=organization:*&path=/organization&type=menu',''),('1444548969561','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=2&name=角色授权&authName=roleResource|*&path=/roleResource&type=menu',''),('1444550544945','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=2&name=组织授权&authName=organizationResource:*&path=/organizationResource&type=menu',''),('1444573320976','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=&name=关于系统&authName=&path=&type=menu',''),('1444573378659','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1444573320799&name=产品信息&authName=&path=/productInfo&type=menu',''),('1444574410762','access','admin','/syst/admin',NULL,'/syst/admin/resource/deleteById','POST','idstring=1',''),('1444575788831','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1444573320799&name=修改密码&authName=&path=/changePassword&type=menu',''),('1444628148087','access','admin','/syst/admin',NULL,'/syst/admin/resource/deleteById','POST','idstring=1444575788723',''),('1444631314573','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=2&name=字典管理&authName=&path=/dictionary&type=menu',''),('1444632936253','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/deleteById','POST','idstring=1444473873037',''),('1444633076902','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=true&label=是&type=available',''),('1444633285726','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=false&label=否&type=available',''),('1444635718867','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=true&label=男&type=sex',''),('1444635730168','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=false&label=女&type=sex',''),('1444636328281','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=&name=公司&available=true',''),('1444636390553','access','admin','/syst/admin',NULL,'/syst/admin/organization/deleteById','POST','idstring=1444534865650',''),('1444636521753','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636328008&name=财务部&available=true',''),('1444636560272','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636328008&name=市场部&available=true',''),('1444636576043','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636328008&name=研发部&available=true',''),('1444636666722','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636575952&name=研发一部&available=true',''),('1444636687175','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636575952&name=研发二部&available=true',''),('1444646456492','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1444573378567','POST','parentId=1444573320799&name=产品信息&authName=&path=/user/productInfo&type=menu','');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_qunhu_info`
--

DROP TABLE IF EXISTS `t_qunhu_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_qunhu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_Name` varchar(120) DEFAULT NULL COMMENT '数据规则：qunhu20150929_4455,qunhu+当天时间+4455是上一条记录的“_”后面的数字+1',
  `table_Name` varchar(120) DEFAULT NULL COMMENT '数据表名',
  `times` varchar(120) DEFAULT NULL,
  `callbs` varchar(120) DEFAULT NULL,
  `countB` int(11) DEFAULT NULL,
  `filename` varchar(120) DEFAULT NULL,
  `ip` varchar(120) DEFAULT NULL,
  `leixing` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_qunhu_info`
--

LOCK TABLES `t_qunhu_info` WRITE;
/*!40000 ALTER TABLE `t_qunhu_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_qunhu_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_dictionary`
--

DROP TABLE IF EXISTS `tb_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_dictionary` (
  `id` varchar(120) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `label` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_dictionary`
--

LOCK TABLES `tb_dictionary` WRITE;
/*!40000 ALTER TABLE `tb_dictionary` DISABLE KEYS */;
INSERT INTO `tb_dictionary` VALUES ('1444633076622','available','是','true'),('1444633285663','available','否','false'),('1444635718573','sex','男','true'),('1444635730059','sex','女','false');
/*!40000 ALTER TABLE `tb_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_organization`
--

DROP TABLE IF EXISTS `tb_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_organization` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `parent_id` varchar(120) DEFAULT NULL,
  `parent_ids` varchar(1200) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '1',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orga_orga_idx` (`parent_id`),
  CONSTRAINT `fk_orga_orga` FOREIGN KEY (`parent_id`) REFERENCES `tb_organization` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_organization`
--

LOCK TABLES `tb_organization` WRITE;
/*!40000 ALTER TABLE `tb_organization` DISABLE KEYS */;
INSERT INTO `tb_organization` VALUES ('1444636328008','公司',NULL,NULL,1,'2015-10-12 15:52:08',NULL),('1444636521670','财务部','1444636328008','1444636328008',1,'2015-10-12 15:55:22',NULL),('1444636560192','市场部','1444636328008','1444636328008',1,'2015-10-12 15:56:00',NULL),('1444636575952','研发部','1444636328008','1444636328008',1,'2015-10-12 15:56:16',NULL),('1444636666661','研发一部','1444636575952','1444636328008,1444636575952',1,'2015-10-12 15:57:47',NULL),('1444636687117','研发二部','1444636575952','1444636328008,1444636575952',1,'2015-10-12 15:58:07',NULL);
/*!40000 ALTER TABLE `tb_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_organization_resource`
--

DROP TABLE IF EXISTS `tb_organization_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_organization_resource` (
  `id` varchar(120) NOT NULL,
  `organization_id` varchar(120) DEFAULT NULL,
  `resource_id` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tb_organization_resource_organization_idx` (`organization_id`),
  KEY `fk_tb_organization_resource_resource_idx` (`resource_id`),
  CONSTRAINT `fk_tb_organization_resource_organization` FOREIGN KEY (`organization_id`) REFERENCES `tb_organization` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_organization_resource_resource` FOREIGN KEY (`resource_id`) REFERENCES `tb_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_organization_resource`
--

LOCK TABLES `tb_organization_resource` WRITE;
/*!40000 ALTER TABLE `tb_organization_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_organization_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_resource`
--

DROP TABLE IF EXISTS `tb_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_resource` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL COMMENT '菜单名',
  `parentids` varchar(1200) DEFAULT NULL COMMENT '父亲节点集，用逗号分开',
  `parent_id` varchar(120) DEFAULT NULL COMMENT '父亲节点',
  `auth_name` varchar(120) DEFAULT NULL COMMENT '权限名称',
  `path` varchar(120) DEFAULT NULL COMMENT '访问路径，以“/”开头',
  `type` varchar(45) DEFAULT 'menu',
  PRIMARY KEY (`id`),
  KEY `fk_tb_resource_tb_resource_idx` (`parent_id`),
  CONSTRAINT `fk_tb_resource_tb_resource` FOREIGN KEY (`parent_id`) REFERENCES `tb_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resource`
--

LOCK TABLES `tb_resource` WRITE;
/*!40000 ALTER TABLE `tb_resource` DISABLE KEYS */;
INSERT INTO `tb_resource` VALUES ('10','角色管理删除','2,8','8','role:delete',NULL,'button'),('11','角色管理修改','2,8','8','role:update',NULL,'button'),('12','角色管理查询','2,8','8','role:view',NULL,'button'),('13','资源管理','2','2','resource:*','/resource','menu'),('14','资源管理新增','2,13','13','resource:create',NULL,'button'),('1444459418042','日志管理','2','2','log:*','/log','menu'),('1444548142152','组织管理','2','2','organization:*','/organization','menu'),('1444548968675','角色授权','2','2','roleResource:*','/roleResource','menu'),('1444550544838','组织授权','2','2','organizationResource:*','/organizationResource','menu'),('1444573320799','关于系统',NULL,NULL,'','','menu'),('1444573378567','产品信息','1444573320799','1444573320799','','/user/productInfo','menu'),('1444631314253','字典管理','2','2','','/dictionary','menu'),('15','资源管理删除','2,13','13','resource:delete',NULL,'button'),('16','资源管理修改','2,13','13','resource:update',NULL,'button'),('17','资源管理查询','2,13','13','resource:view',NULL,'button'),('2','系统管理',NULL,NULL,NULL,NULL,'menu'),('3','用户管理','2','2','user:*','/user','menu'),('4','用户管理新增','2,3','3','user:create',NULL,'button'),('5','用户管理删除','2,3','3','user:delete',NULL,'button'),('6','用户管理修改','2,3','3','user:update',NULL,'button'),('7','用户管理查询','2,3','3','user:view',NULL,'button'),('8','角色管理','2','2','role:*','/role','menu'),('9','角色管理新增','2,8','8','role:create',NULL,'button');
/*!40000 ALTER TABLE `tb_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_role` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES ('1','admin'),('2','test');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_resource`
--

DROP TABLE IF EXISTS `tb_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_role_resource` (
  `id` varchar(120) NOT NULL,
  `role_id` varchar(120) DEFAULT NULL,
  `resource_id` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tb_role_tb_resource_tb_role_idx` (`role_id`),
  KEY `fk_tb_role_tb_resource_tb_resource_idx` (`resource_id`),
  CONSTRAINT `fk_tb_role_tb_resource_tb_resource` FOREIGN KEY (`resource_id`) REFERENCES `tb_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_role_tb_resource_tb_role` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_resource`
--

LOCK TABLES `tb_role_resource` WRITE;
/*!40000 ALTER TABLE `tb_role_resource` DISABLE KEYS */;
INSERT INTO `tb_role_resource` VALUES ('10','1','1444550544838'),('2','1','2'),('3','1','3'),('4','1','8'),('5','1','13'),('7','1','1444459418042'),('8','1','1444548142152'),('9','1','1444548968675');
/*!40000 ALTER TABLE `tb_role_resource` ENABLE KEYS */;
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
  `password` varchar(1200) DEFAULT NULL,
  `login_date` date DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `show_name` varchar(45) DEFAULT NULL COMMENT '显示名称',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(45) DEFAULT NULL,
  `login_count` varchar(45) DEFAULT NULL COMMENT '登录次数',
  `login_ip` varchar(45) DEFAULT NULL COMMENT '登录IP',
  `last_login` datetime DEFAULT NULL COMMENT '上一次登录',
  `sex` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('1','admin','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('2','test','test',NULL,'2015-10-04','2015-10-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_organization`
--

DROP TABLE IF EXISTS `tb_user_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_organization` (
  `id` varchar(120) NOT NULL,
  `user_id` varchar(120) DEFAULT NULL,
  `organization_id` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tb_user_user_organization_idx` (`user_id`),
  KEY `fk_tb_organization_user_organization_idx` (`organization_id`),
  CONSTRAINT `fk_tb_organization_user_organization` FOREIGN KEY (`organization_id`) REFERENCES `tb_organization` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_user_user_organization` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_organization`
--

LOCK TABLES `tb_user_organization` WRITE;
/*!40000 ALTER TABLE `tb_user_organization` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_organization` ENABLE KEYS */;
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
  `tb_role_id` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tb_user_role_tb_user_idx` (`user_id`),
  KEY `fk_tb_user_role_tb_role1_idx` (`tb_role_id`),
  CONSTRAINT `fk_tb_user_role_tb_role1` FOREIGN KEY (`tb_role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_user_role_tb_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_role`
--

LOCK TABLES `tb_user_role` WRITE;
/*!40000 ALTER TABLE `tb_user_role` DISABLE KEYS */;
INSERT INTO `tb_user_role` VALUES ('1','1','1'),('2','2','2');
/*!40000 ALTER TABLE `tb_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` varchar(120) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES ('1444522792556','test112','2015-10-11 08:19:53','2015-10-11 08:33:10');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-12 20:24:38
