-- MySQL dump 10.13  Distrib 5.6.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jcincms3
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
-- Table structure for table `act_evt_log`
--

DROP TABLE IF EXISTS `act_evt_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_evt_log` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_evt_log`
--

LOCK TABLES `act_evt_log` WRITE;
/*!40000 ALTER TABLE `act_evt_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_evt_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ge_bytearray`
--

DROP TABLE IF EXISTS `act_ge_bytearray`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ge_bytearray`
--

LOCK TABLES `act_ge_bytearray` WRITE;
/*!40000 ALTER TABLE `act_ge_bytearray` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ge_bytearray` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ge_property`
--

DROP TABLE IF EXISTS `act_ge_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ge_property`
--

LOCK TABLES `act_ge_property` WRITE;
/*!40000 ALTER TABLE `act_ge_property` DISABLE KEYS */;
INSERT INTO `act_ge_property` VALUES ('next.dbid','1',1),('schema.history','create(5.17.0.2)',1),('schema.version','5.17.0.2',1);
/*!40000 ALTER TABLE `act_ge_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_actinst`
--

DROP TABLE IF EXISTS `act_hi_actinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_actinst`
--

LOCK TABLES `act_hi_actinst` WRITE;
/*!40000 ALTER TABLE `act_hi_actinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_actinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_attachment`
--

DROP TABLE IF EXISTS `act_hi_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_attachment`
--

LOCK TABLES `act_hi_attachment` WRITE;
/*!40000 ALTER TABLE `act_hi_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_comment`
--

DROP TABLE IF EXISTS `act_hi_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_comment`
--

LOCK TABLES `act_hi_comment` WRITE;
/*!40000 ALTER TABLE `act_hi_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_detail`
--

DROP TABLE IF EXISTS `act_hi_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_detail`
--

LOCK TABLES `act_hi_detail` WRITE;
/*!40000 ALTER TABLE `act_hi_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_identitylink`
--

DROP TABLE IF EXISTS `act_hi_identitylink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_identitylink`
--

LOCK TABLES `act_hi_identitylink` WRITE;
/*!40000 ALTER TABLE `act_hi_identitylink` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_identitylink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_procinst`
--

DROP TABLE IF EXISTS `act_hi_procinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_procinst`
--

LOCK TABLES `act_hi_procinst` WRITE;
/*!40000 ALTER TABLE `act_hi_procinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_procinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_taskinst`
--

DROP TABLE IF EXISTS `act_hi_taskinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_taskinst`
--

LOCK TABLES `act_hi_taskinst` WRITE;
/*!40000 ALTER TABLE `act_hi_taskinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_taskinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_varinst`
--

DROP TABLE IF EXISTS `act_hi_varinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_varinst`
--

LOCK TABLES `act_hi_varinst` WRITE;
/*!40000 ALTER TABLE `act_hi_varinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_varinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_id_group`
--

DROP TABLE IF EXISTS `act_id_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_id_group`
--

LOCK TABLES `act_id_group` WRITE;
/*!40000 ALTER TABLE `act_id_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_id_info`
--

DROP TABLE IF EXISTS `act_id_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_id_info`
--

LOCK TABLES `act_id_info` WRITE;
/*!40000 ALTER TABLE `act_id_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_id_membership`
--

DROP TABLE IF EXISTS `act_id_membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_id_membership`
--

LOCK TABLES `act_id_membership` WRITE;
/*!40000 ALTER TABLE `act_id_membership` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_id_user`
--

DROP TABLE IF EXISTS `act_id_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_id_user`
--

LOCK TABLES `act_id_user` WRITE;
/*!40000 ALTER TABLE `act_id_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_re_deployment`
--

DROP TABLE IF EXISTS `act_re_deployment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_re_deployment`
--

LOCK TABLES `act_re_deployment` WRITE;
/*!40000 ALTER TABLE `act_re_deployment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_deployment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_re_model`
--

DROP TABLE IF EXISTS `act_re_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_re_model`
--

LOCK TABLES `act_re_model` WRITE;
/*!40000 ALTER TABLE `act_re_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_re_procdef`
--

DROP TABLE IF EXISTS `act_re_procdef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_re_procdef`
--

LOCK TABLES `act_re_procdef` WRITE;
/*!40000 ALTER TABLE `act_re_procdef` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_procdef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_event_subscr`
--

DROP TABLE IF EXISTS `act_ru_event_subscr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_event_subscr`
--

LOCK TABLES `act_ru_event_subscr` WRITE;
/*!40000 ALTER TABLE `act_ru_event_subscr` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_event_subscr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_execution`
--

DROP TABLE IF EXISTS `act_ru_execution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_execution`
--

LOCK TABLES `act_ru_execution` WRITE;
/*!40000 ALTER TABLE `act_ru_execution` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_execution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_identitylink`
--

DROP TABLE IF EXISTS `act_ru_identitylink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_identitylink`
--

LOCK TABLES `act_ru_identitylink` WRITE;
/*!40000 ALTER TABLE `act_ru_identitylink` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_identitylink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_job`
--

DROP TABLE IF EXISTS `act_ru_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_job`
--

LOCK TABLES `act_ru_job` WRITE;
/*!40000 ALTER TABLE `act_ru_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_task`
--

DROP TABLE IF EXISTS `act_ru_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_task`
--

LOCK TABLES `act_ru_task` WRITE;
/*!40000 ALTER TABLE `act_ru_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_variable`
--

DROP TABLE IF EXISTS `act_ru_variable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_variable`
--

LOCK TABLES `act_ru_variable` WRITE;
/*!40000 ALTER TABLE `act_ru_variable` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_variable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busi_channel`
--

DROP TABLE IF EXISTS `busi_channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busi_channel` (
  `id` varchar(120) NOT NULL COMMENT 'id标识符',
  `name` varchar(45) DEFAULT NULL COMMENT '名称',
  `code` varchar(45) DEFAULT NULL COMMENT '代码',
  `keyword` varchar(45) DEFAULT NULL COMMENT '关键词',
  `link_addr` varchar(120) DEFAULT NULL COMMENT '链接地址',
  `open_mode` varchar(45) DEFAULT NULL COMMENT '打开模式',
  `descrition` varchar(120) DEFAULT NULL COMMENT '描述',
  `parent_id` varchar(120) DEFAULT NULL,
  `channel_templete` varchar(120) DEFAULT NULL COMMENT '栏目模板',
  `document_templete` varchar(120) DEFAULT NULL COMMENT '文档模板',
  `hidden` bit(1) DEFAULT NULL COMMENT '是否显示',
  `asdocument` bit(1) DEFAULT NULL,
  `document_id` varchar(120) DEFAULT NULL,
  `sort` int(11) DEFAULT '0',
  `parent_ids` varchar(1200) DEFAULT NULL,
  `link_addr_zh` varchar(1200) DEFAULT NULL COMMENT '中文连接导航',
  PRIMARY KEY (`id`),
  KEY `fk_busi_channel_busichannel_idx` (`parent_id`),
  CONSTRAINT `fk_busi_channel_busichannel` FOREIGN KEY (`parent_id`) REFERENCES `busi_channel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='栏目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busi_channel`
--

LOCK TABLES `busi_channel` WRITE;
/*!40000 ALTER TABLE `busi_channel` DISABLE KEYS */;
INSERT INTO `busi_channel` VALUES ('1445933697685','关于我们','aboutus','公司主页，关于我们','channel/aboutus','false','',NULL,'',NULL,'\0','','1445940554062',2,NULL,NULL),('1445933756067','组织架构','organization','组织架构','channel/aboutus/organization','false','','1445933697685',NULL,NULL,'\0','','1447039321447',0,NULL,NULL),('1445933793433','公司历史','history','公司历史','channel/aboutus/history','false','','1445933697685','',NULL,'\0','','1445944340585',0,NULL,NULL),('1445933824290','联系我们','contact','联系我们','channel/aboutus/contact','false','contact','1445933697685','',NULL,'\0','','1445947810718',0,NULL,NULL),('1445933910969','产品展示','products','产品展示','channel/products','false','product产品展示',NULL,'defaultApp/products',NULL,'\0','\0','',3,'',NULL),('1445934192714','医药原料及中间体','yyyljzhjt','医药原料及中间体','channel/products/yyyljzhjt','false','','1445933910969','defaultApp/products',NULL,'\0','\0','',0,'1445933910969',NULL),('1445934220786','无机化工产品','wjhgchp','无机化工产品','channel/products/wjhgchp','false','无机化工产品','1445933910969','defaultApp/products',NULL,'\0','\0','',0,'1445933910969',NULL),('1445934282711','香精香料及植物提取物','xjxljzhwtqw','香精香料及植物提取物','channel/products/xjxljzhwtqw','false','ewwweewfwf','1445933910969','defaultApp/products',NULL,'\0','\0','',0,'1445933910969',NULL),('1445934468960','招聘信息','jobs','招聘信息,jobs','channel/jobs','false','招聘信息,jobs',NULL,'',NULL,'\0','\0','',5,'',NULL),('1446965194084','新闻中心','news','','channel/news','false','',NULL,'defaultApp/news',NULL,'\0','\0','',4,NULL,NULL),('1448842462004','市场部招聘','market','','channel/jobs/market','false','市场部招聘','1445934468960','',NULL,'\0','\0','',NULL,',1445934468960',NULL),('1448843740500','华南区市场调研员','southmarket','','channel/jobs/market/southmarket','false','','1448842462004','',NULL,'\0','\0','',NULL,',1445934468960,1448842462004',NULL),('1448876308785','国际新闻','internalnews','国际新闻','channel/news/internalnews','false','','1446965194084','',NULL,'\0','\0','',NULL,'1446965194084',''),('1448876768973','国内新闻','innernews','innernews','channel/news/innernews','false','innernews','1446965194084','',NULL,'\0','\0','',NULL,'1446965194084',''),('1448877803257','娱乐新闻','entertaiment','entertaiment','channel/news/innernews/entertaiment','false','entertaiment','1448876768973','',NULL,'\0','\0','',NULL,'1446965194084,1448876768973','');
/*!40000 ALTER TABLE `busi_channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busi_comment`
--

DROP TABLE IF EXISTS `busi_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busi_comment` (
  `id` varchar(120) NOT NULL,
  `document_id` varchar(120) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `content` varchar(1200) DEFAULT NULL,
  `parent_ids` varchar(1200) DEFAULT NULL,
  `parent_id` varchar(120) DEFAULT NULL,
  `hidden` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_comment_docu_idx` (`document_id`),
  KEY `comment_fk_comment_idx` (`parent_id`),
  CONSTRAINT `comment_fk_comment` FOREIGN KEY (`parent_id`) REFERENCES `busi_comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_fk_docu` FOREIGN KEY (`document_id`) REFERENCES `busi_document` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busi_comment`
--

LOCK TABLES `busi_comment` WRITE;
/*!40000 ALTER TABLE `busi_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `busi_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busi_document`
--

DROP TABLE IF EXISTS `busi_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busi_document` (
  `id` varchar(120) NOT NULL,
  `channel_id` varchar(120) DEFAULT NULL,
  `title` varchar(120) DEFAULT NULL COMMENT '标题',
  `color` varchar(10) DEFAULT NULL COMMENT '颜色',
  `keyword` varchar(45) DEFAULT NULL COMMENT '关键词',
  `descrition` varchar(1200) DEFAULT NULL COMMENT '描述',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `source` varchar(45) DEFAULT NULL COMMENT '来源',
  `source_addr` varchar(1200) DEFAULT NULL COMMENT '来源地址',
  `author` varchar(45) DEFAULT NULL COMMENT '作者',
  `title_image` varchar(120) DEFAULT NULL COMMENT '标题图片',
  `file_name` varchar(120) DEFAULT NULL,
  `file_addr` varchar(120) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `content` varchar(16000) DEFAULT NULL COMMENT '内容',
  `document_templete` varchar(120) DEFAULT NULL COMMENT '文档模板',
  `hidden` bit(1) DEFAULT b'0' COMMENT '是否显示',
  `assets_ids` varchar(1200) DEFAULT NULL,
  `recommend` bit(1) DEFAULT b'0' COMMENT '是否推荐',
  `click_count` int(11) DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `content_short` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_busi_doc_channel_idx` (`channel_id`),
  CONSTRAINT `fk_busi_doc_channel` FOREIGN KEY (`channel_id`) REFERENCES `busi_channel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文档';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busi_document`
--

LOCK TABLES `busi_document` WRITE;
/*!40000 ALTER TABLE `busi_document` DISABLE KEYS */;
INSERT INTO `busi_document` VALUES ('1445940554062','1445933697685','关于我们','','',NULL,NULL,'','','','','','',NULL,'<p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"><strong style=\"border: 0px; margin: 0px; padding: 0px;\">关于IT技术精华网</strong></p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">作为一名程序员，在工作中，会遇到各种问题。每天都会用搜索引擎去搜索各种问题，搜索结果鱼目混杂，找一个比较准确的结果比较困难，于是我就产生了这样一个想法，把一些互联网中的精华内容进行分类，整理，推荐给网友。最后由于本人能力和精力有限，该网站已经成为个人技术blog，主要记录技术和生活中的点点滴滴。</p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"><strong style=\"border: 0px; margin: 0px; padding: 0px;\">关于作者</strong></p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">本人主要从事互联网Java方面的开发工作。熟悉前端技术CSS,JQuery等，对互联网后端开发有较丰富的经验。熟悉分布式系统，搜索系统开发。对系统性能调优有一定的经验。</p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">本人热爱开发工作，对开发工作有着持续的激情。愿结交热爱技术的朋友，共同进步。</p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"><strong style=\"border: 0px; margin: 0px; padding: 0px;\">&nbsp;联系方式</strong></p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">email：517714860#163.com</p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; text-indent: 28px; background-color: rgb(255, 255, 255);\">QQ：</span><span style=\"color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; text-indent: 28px; background-color: rgb(255, 255, 255);\">517714860</span><span style=\"color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; text-indent: 28px; background-color: rgb(255, 255, 255);\"></span></p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; text-indent: 28px; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; text-indent: 28px; background-color: rgb(255, 255, 255);\">电话：</span><span style=\"color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; line-height: 22px; text-indent: 28px; background-color: rgb(255, 255, 255);\">13926205227</span></span></p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">2015.11.28&nbsp;</p><p><br/></p>','doc.jsp','','','\0',0,NULL,NULL,NULL),('1445944340585','1445933793433','公司历史','','',NULL,NULL,'','','','',NULL,'',NULL,'<p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\"><strong style=\"margin: 0px; padding: 0px; color: rgb(255, 0, 0); font-size: 14px;\">2013年</strong></p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\">1月9日，公司再次荣登福布斯《中国潜力企业榜》榜单，位列2012年度 “最具潜力上市企业”第33位。<br style=\"margin: 0px; padding: 0px;\"/>1月14日，河南省信用建设促进会授予公司首批“河南省信用建设示范单位”荣誉称号。<br style=\"margin: 0px; padding: 0px;\"/>1月29日，公司入选“2012年度河南省物联网十强企业”。<br style=\"margin: 0px; padding: 0px;\"/>4月16日，公司荣获中国信用建设促进委员会颁发的“中国信用共建2012年度重信用企业”。<br style=\"margin: 0px; padding: 0px;\"/>6月4日，公司 “安徽电信翼机通集中平台”获得国家金卡工程2013年度金蚂蚁奖优秀应用成果奖。</p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\"><strong style=\"margin: 0px; padding: 0px; color: rgb(255, 0, 0); font-size: 14px;\">2012年</strong></p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\">1月13日，公司被科学技术部火炬中心认定为“国家火炬计划软件产业基地郑州软件园骨干企业”；<br style=\"margin: 0px; padding: 0px;\"/>2月17日，公司完成对外贸易经营者备案登记工作；<br style=\"margin: 0px; padding: 0px;\"/>2月20日，郑州市人力资源和社会保障局授予公司“2011年度郑州市人力资源和社会保障工作先进单位”；<br style=\"margin: 0px; padding: 0px;\"/>2月26日，河南省工业和信息化厅认定公司为“软件和信息服务业20优企业”；<br style=\"margin: 0px; padding: 0px;\"/>3月15日，公司荣登福布斯2012中国最具潜力企业榜；<br style=\"margin: 0px; padding: 0px;\"/>6月，“郑州新开普电子股份有限公司实施质量总体解决方案（TSQ）的实践经验”被工信部评定为：2012年度全国“质量标杆”。<br style=\"margin: 0px; padding: 0px;\"/></p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\"><strong style=\"margin: 0px; padding: 0px; color: rgb(255, 0, 0); font-size: 14px;\">2011年</strong></p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\">1月5日，公司上市首发申请材料正式获中国证监会受理；<br style=\"margin: 0px; padding: 0px;\"/>1月，公司由河南省工业和信息化厅授予 “河南省高技术工业60强企业”；<br style=\"margin: 0px; padding: 0px;\"/>3月22日，公司由郑州市人力资源和社会保障局授予“郑州市劳动关系和谐模范企业”称号；<br style=\"margin: 0px; padding: 0px;\"/>6月9日，中国证券监督管理委员会创业板发行监管部公布我公司（首发）获通过；<br style=\"margin: 0px; padding: 0px;\"/>6月25日，公司“基于物联网应用的系列智能终端与信息系统建设项目”顺利奠基；<br style=\"margin: 0px; padding: 0px;\"/>7月 7日，我公司首次公开发行股票并在创业板上市获得中国证监会的核准；<br style=\"margin: 0px; padding: 0px;\"/>7月29日，公司股票在深圳证券交易所创业板挂牌上市；<br style=\"margin: 0px; padding: 0px;\"/>7月25日，公司获得由郑州市委、郑州市人民政府颁发的“郑州市高成长型民营企业”荣誉称号；<br style=\"margin: 0px; padding: 0px;\"/>9月15日，公司被中国银行股份有限公司河南省分行授予“总行级中小企业重点客户”；<br style=\"margin: 0px; padding: 0px;\"/>9月24日，公司获得由中国信息协会颁发的“2011中国城市信息化产品创新奖”；<br style=\"margin: 0px; padding: 0px;\"/>11月16日，公司携“智慧城市”解决方案亮相深圳第十三届高交会，获得由国家发展和改革委员会颁发的“优秀展示奖”和中国国际高新技术成果交易会组委会颁发的“优秀产品证书”；<br style=\"margin: 0px; padding: 0px;\"/>11月29日，公司在2011中国移动支付产业年会上荣获“2011年度移动支付产业优秀方案奖”；</p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\"><strong style=\"margin: 0px; padding: 0px; color: rgb(255, 0, 0); font-size: 14px;\">2010年</strong></p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\">1月，公司成立生产、研发、营销、客服中心，组织架构更加完善；<br style=\"margin: 0px; padding: 0px;\"/>10月，公司取得了由工业和信息化部颁发的《增值电信业务经营许可证》；<br style=\"margin: 0px; padding: 0px;\"/>12月，公司被科学技术部火炬高技术产业开发中心评为“国家火炬计划重点高新技术企业”；</p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\"><strong style=\"margin: 0px; padding: 0px; color: rgb(255, 0, 0); font-size: 14px;\">2009年</strong></p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\">6月19日，经河南省科技厅批准,公司成立“河南省智能卡与射频识别应用工程技术研究中心”；<br style=\"margin: 0px; padding: 0px;\"/>6月26日，经郑州市科技局批准，公司成立“郑州市企业技术中心”；<br style=\"margin: 0px; padding: 0px;\"/>12月12日，公司取得由工业和信息化部颁发的计算机系统集成二级资质；新开普CPU校园一卡通系统在河南大学成功实施；</p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\"><strong style=\"margin: 0px; padding: 0px; color: rgb(255, 0, 0); font-size: 14px;\">2008年</strong></p><p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; color: rgb(85, 85, 85); font-family: Arial, Helvetica, sans-serif; white-space: normal;\">4月，通过CMMI L3认证，成为河南省首家同时也是一卡通行业首家通过CMMI L3认证的企业<br style=\"margin: 0px; padding: 0px;\"/>5月，公司正式更名为郑州新开普电子股份有限公司<br style=\"margin: 0px; padding: 0px;\"/>10月，中标山东淄博城市一卡通项目，正式进入城市一卡通领域。</p><p><br/></p>','defaultApp/single','',NULL,'\0',0,NULL,NULL,NULL),('1445947810718','1445933824290','联系我们','','',NULL,NULL,'','','','',NULL,'',NULL,'<p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(254, 254, 254);\"><strong style=\"margin: 0px; padding: 0px;\">新开普电子股份有限公司</strong><br style=\"margin: 0px; padding: 0px;\"/>地址：郑州市高新技术产业开发区迎春街18号</p><p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(254, 254, 254);\"><strong style=\"margin: 0px; padding: 0px;\">全国统一服务热线</strong>：4006 300248</p><p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(254, 254, 254);\"><strong style=\"margin: 0px; padding: 0px;\">销售热线</strong><br style=\"margin: 0px; padding: 0px;\"/>电话：4006300248转1</p><p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(254, 254, 254);\"><strong style=\"margin: 0px; padding: 0px;\">售后服务热线</strong><br style=\"margin: 0px; padding: 0px;\"/>传真：0371-56599840</p><p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(254, 254, 254);\"><strong style=\"margin: 0px; padding: 0px;\">工程维修热线</strong><br style=\"margin: 0px; padding: 0px;\"/>电话：0371-56599111</p><p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(254, 254, 254);\"><strong style=\"margin: 0px; padding: 0px;\">人力资源热线</strong><br style=\"margin: 0px; padding: 0px;\"/>电话：0371-56599771</p><p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(254, 254, 254);\"><strong style=\"margin: 0px; padding: 0px;\">投资者热线</strong><br style=\"margin: 0px; padding: 0px;\"/>电话：0371-56599758<br style=\"margin: 0px; padding: 0px;\"/>传真：0371-56599716<br/></p><p><br/></p>','defaultApp/single','',NULL,'\0',0,NULL,NULL,NULL),('1446965467743','1446965194084','6个技巧让你成为专业程序员','','',NULL,NULL,'','','','',NULL,'',NULL,'<p><span style=\"font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: medium; line-height: 25.2000007629395px; background-color: rgb(255, 255, 255);\">想从普通的程序员变成专业程序员吗？没关系，来看看笔者的这篇文章吧！</span></p><p>1、在你责怪别人之前，先检查自己的代码</p><p>先想一想自己的假设和其他人的假设。来自不同供应商的工具可能内置不同的假设，即便是相同的供应商对于不同的工具，其假设也可能不同。</p><p>当其他人正在报告一个你不能重复的问题的时候，去看看他们在做什么。他们可能会做一些你从来没有想到过的事情，或者他们的做事顺序与你的截然不同。</p><p>我 个人的原则是，如果我有一个不能确定的错误，那么我会先考虑是不是编译器的问题，然后再去检查堆栈是否损坏。特别是当添加跟踪代码会使得问题移动的话就更 要这么做了。多线程问题是bug的另一个来源，有时候令人焦躁得简直想拔光头发，或者直接想摔电脑。当系统是多线程的时候，最好倾向于简单的代码。我们不 能依赖调试和单元测试来发现任何一致性的bug，所以设计的简单性是最重要的。</p><p>所以，在你不分青红皂白地去责怪编译器之前，先想一想福尔摩斯的这条建议，“一旦你排除了种种不可能，剩下的不管有多么难以置信，一定就是真相”。</p><p>2、不断学习</p><p>我们生活在一个有趣的时代。随着软件开发逐渐遍布全球各地，你会发现有很多人都可以干你的工作。所以你需要不断学习以保持竞争力。否则，你就会落伍，停滞不前，直到有一天，这份工作不再需要你，或外包给一些更廉价的劳动力。</p><p>那么我们能做些什么?有些雇主很慷慨，会提供培训以拓宽你的技能。也有的人会说我没时间或者没这个资金去接受任何培训。所以，关键是要摆正心态，学习是对自己的负责。</p><p>这里有一些学习的方法。而且许多资源都可以在互联网上免费获取：</p><p>阅读书籍、杂志、博客、Twitter feeds和网站。如果你想更深入地了解对象，可以考虑添加到邮件列表或新闻组。点击这里通过邮件订阅《快乐码农》杂志</p><p>如果你真的很想学习某一种技术，那么就亲自动手写代码。</p><p>尽量与导师一起工作。虽然你从任何人身上都可以学到一些东西，但是从那些比你更聪明或更有经验的人身上，你能学到的更多。如果你实在找不到这样的良师益友，那么请继续往下看。</p><p>使用虚拟导师。在网络上找你真正喜欢的作者和开发人员，阅读他们写的内容。订阅他们的博客。</p><p>了解你使用的框架和库。知道事物的工作原理，有助于你更好地应用它们。如果你使用的是开源资源，那么你真的很幸运。使用调试器单步执行代码，以查看内部究竟是怎么回事。你也可以去看看那些确实比你聪明的人是如何编写和审查代码的。</p><p>当你犯了错误，修复bug，或者遇到问题的时候，试着去真正理解发生了什么事情。很有可能其他人已经遇到过同样的问题，并且发布在了网上。谷歌搜索真的很有用。</p><p>学习东西还有一个好方法就是所谓的“教学相长”。当别人在倾听你的言语，并问你问题的同时，你也会学到东西。可以建立用户组或本地会议。</p><p>为自己感兴趣语言和技术加入或启动一个研究小组(模式社区)，也可以创建本地的用户组。</p><p>参加会议。如果去不了的话，也可以在网上看，许多会议会将其谈话免费发布到网上。</p><p>收听播客。</p><p>曾经对代码库运行过静态分析工具，又或者查看下你的IDE警告?了解它们报告了什么，以及其原因。</p><p>当 然如果你有《黑客帝国》中Neo那样的超能力，自然这一切对你而言不过是小菜一碟。但很可惜，我们都是普通人，我们需要时间和精力，以及不断的努力才能促 使自己不断的学习。不过，你不必成天学习。只要你能有意识地花点时间去学习就可以了，哪怕每天一小时，有总比没有好。人活着不是为了工作，你还应该有自己 的生活。</p><p>3、不要害怕破坏东西</p><p>每 个具备行业经验的程序员肯定参与过代码库岌岌可危的项目。系统很糟糕，并且改变这边总是会破坏另一边不相关的功能。每次添加模块，程序员只能想着尽可能少 地改变代码，每次发布都胆战心惊。这座软件的摩天大楼随时有坍塌的可能。之所以改动代码会如此伤脑筋是因为系统太糟糕了。但是即使你知道系统出了问题，却 又因为投鼠忌器，而不得不听之任之。任何一个外科医生都懂得，伤口要想愈合就必须得切除腐肉。虽然手术会带来痛苦，但绝对比任伤口发炎溃烂要好。</p><p>不 要害怕你的代码。没有人会在乎当你捣鼓代码的时候有没有暂时破坏了什么东西。只要你做的改变不会让项目重新回到开始状态，就不会令人崩溃。投入时间重构， 能让你受益于项目整个生命周期。这样做还有一个额外的好处是，由于你有过这种处理病危系统的经验，所以你对它应该如何工作非常内行。要善于应用这些知识， 千万不要反感这些宝贵的财富。重新定义内部接口，重构模块，重构复制粘贴代码，并通过减少依赖来简化设计。你可以通过消除特殊情况显著降低代码的复杂性， 因为特殊情况往往是因为错误的耦合特点导致的。慢慢地从旧结构过渡到新结构，测试一路同行。如果你想要一下子完成一个大的重构，那么往往会因为各种频出的 问题而考虑中途放弃。</p><p>4、专业程序员</p><p>专业程序员的一个最重要的特点是有责任心。专业程序员会为他们的职业生涯、预算、日程安排承诺、错误、技能技巧负责。一个专业的程序员不会将责任推卸给别人。</p><p>如 果你是专业的，那么你就需要为自己的职业生涯负责。你有责任去阅读和学习。你有责任去时刻关注最新的产业和技术。但是许多程序员觉得这应该是他们雇主的工 作。NO，大错特错。想一想医生?想一想律师?他们都是靠自己来培养和训练自己的。他们的下班时间多用在了阅读杂志报刊上。他们时刻关注着最新的资讯动 态。所以，我们也应该如此。你和你雇主之间的关系，已经在雇用合同上作了详细的说明，简而言之就是：你的雇主承诺支付你薪酬，而你承诺做好工作。</p><p>专 业程序员会为他们编写的代码负责。除非他们知道这些代码是有效的，否则就不会发布代码。现在，好好思考这个问题：如果是你，你会不会在不透彻了解代码的情 况下就直接发布代码?专业程序员不希望QA找到任何bug，因为这些代码都是经过他测试之后才发布的。当然，QA依然会发现一些问题，因为没有一个人是完 美的。但作为专业程序员，我们的态度应该是让QA找不到任何缺陷。</p><p>专业程序员也是好的团队成员。他们负责地对待整个团队的输出，而不是只顾自己的工作。他们乐于助人，善于向彼此学习，在需要的时候甚至会鼎力相助，为了项目前仆后继。</p><p>5、充分利用代码分析工具</p><p>测试的价值是编程早期阶段就灌输给软件开发者的一个理念。近年来，单元测试，测试驱动开发和敏捷方法的兴起，证实了我们开始注重于在开发周期的各个阶段进行测试。但是，测试只是你可以用来提高代码质量的许多工具之一。</p><p>回 过头去看，当C语言还是一个新事物的时候，CPU时间和任何类型的存储都是非常宝贵的。第一个C语言编译器注意到了这一点，所以选择了通过去掉一些语义分 析，来减少代码之间的传递次数。这意味着，在编译时，编译器检查到的可能只是可被检测到的bug中的一小部分。为了弥补这个缺陷，Stephen Johnson写了一个名为lint的工具——它将从你的代码中删除一些没有价值的东西——从而实现一些已被它的兄弟C语言编译器撤掉的静态分析功能。然 而，静态分析工具却因为可以给出大范围的误报警告和一些没有必要遵循的静态文体惯例的警告而倍受赞誉。</p><p>现 在的语言、编译器和静态分析工具的设计和以前已经大不相同。由于内存和CPU时间变得相对比较便宜，因此负担得起编译器检查更多的错误。几乎每一种语言都 拥有至少一个工具，用来检查风格指南的违规行为、常见问题以及一些狡猾的有时候可能很难捕捉到的错误，如潜在取消引用空指针。更高级的工具，如C的 Splint，以及Python的pylint，是可配置的，这意味着你可以通过命令行开关或在IDE中，使用配置文件来让工具选择放过其中的哪些错误和 警告。Splint甚至还能让你在注释中注解你的代码，以便于更好地提示你的程序是如何工作的。</p><p>6、关心代码</p><p>优秀程序员能写出好代码，这是毋庸置疑的。坏程序员……则不能(他们能写出好代码，就不是坏程序员了，哈哈)。他们总是在生产其他人不得不消灭的怪兽。你的目标是写出好代码，对不?那么你应该成为好程序员。</p><p>好的代码并不是凭空而来的，也不能靠运气然后恰巧让你瞎猫碰到死老鼠。为了获得良好的代码，你必须努力的改进。过程是艰难的。但是如果你确实关心代码的话，那么你一定能收获好代码。</p><p>仅 靠技术并不能成就好的编程。我碰到过一些非常聪明的程序员，他们能够产出令人印象深刻的算法，能够熟记语言标准，但却写出了最可怕的代码。这种代码，阅读 起来很痛苦，使用起来很痛苦，修改起来更是令人痛不欲生。我也碰到过一些非常谦逊的程序员，因为坚持简单的代码，所以写出来的程序更优雅，更易于表达他的 意思，和他们工作非常愉快。</p><p>基于我多年的软件生产经验，我得出的结论是，差强人意的程序员和伟大的程序员之间的真正区别是：态度。好的编程在于专业的方法，以及一种竭尽全力希望写出最好软件的期望。</p><p>要成为一个优秀的程序员，你必须对自己的代码负责，真正关心代码——养成积极向上的心态。伟大的代码是由大师精心雕琢的，而不是由那些马虎的程序员胡乱写出来的。</p><p><br/></p>','defaultApp/newsInfo','',NULL,'\0',0,NULL,NULL,NULL),('1446965523812','1446965194084','6个技巧让你成为专业程序员','','',NULL,NULL,'','','','',NULL,NULL,NULL,'<p><span style=\"font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: medium; line-height: 25.2000007629395px; background-color: rgb(255, 255, 255);\">想从普通的程序员变成专业程序员吗？没关系，来看看笔者的这篇文章吧！</span></p><p>1、在你责怪别人之前，先检查自己的代码</p><p>先想一想自己的假设和其他人的假设。来自不同供应商的工具可能内置不同的假设，即便是相同的供应商对于不同的工具，其假设也可能不同。</p><p>当其他人正在报告一个你不能重复的问题的时候，去看看他们在做什么。他们可能会做一些你从来没有想到过的事情，或者他们的做事顺序与你的截然不同。</p><p>我 个人的原则是，如果我有一个不能确定的错误，那么我会先考虑是不是编译器的问题，然后再去检查堆栈是否损坏。特别是当添加跟踪代码会使得问题移动的话就更 要这么做了。多线程问题是bug的另一个来源，有时候令人焦躁得简直想拔光头发，或者直接想摔电脑。当系统是多线程的时候，最好倾向于简单的代码。我们不 能依赖调试和单元测试来发现任何一致性的bug，所以设计的简单性是最重要的。</p><p>所以，在你不分青红皂白地去责怪编译器之前，先想一想福尔摩斯的这条建议，“一旦你排除了种种不可能，剩下的不管有多么难以置信，一定就是真相”。</p><p>2、不断学习</p><p>我们生活在一个有趣的时代。随着软件开发逐渐遍布全球各地，你会发现有很多人都可以干你的工作。所以你需要不断学习以保持竞争力。否则，你就会落伍，停滞不前，直到有一天，这份工作不再需要你，或外包给一些更廉价的劳动力。</p><p>那么我们能做些什么?有些雇主很慷慨，会提供培训以拓宽你的技能。也有的人会说我没时间或者没这个资金去接受任何培训。所以，关键是要摆正心态，学习是对自己的负责。</p><p>这里有一些学习的方法。而且许多资源都可以在互联网上免费获取：</p><p>阅读书籍、杂志、博客、Twitter feeds和网站。如果你想更深入地了解对象，可以考虑添加到邮件列表或新闻组。点击这里通过邮件订阅《快乐码农》杂志</p><p>如果你真的很想学习某一种技术，那么就亲自动手写代码。</p><p>尽量与导师一起工作。虽然你从任何人身上都可以学到一些东西，但是从那些比你更聪明或更有经验的人身上，你能学到的更多。如果你实在找不到这样的良师益友，那么请继续往下看。</p><p>使用虚拟导师。在网络上找你真正喜欢的作者和开发人员，阅读他们写的内容。订阅他们的博客。</p><p>了解你使用的框架和库。知道事物的工作原理，有助于你更好地应用它们。如果你使用的是开源资源，那么你真的很幸运。使用调试器单步执行代码，以查看内部究竟是怎么回事。你也可以去看看那些确实比你聪明的人是如何编写和审查代码的。</p><p>当你犯了错误，修复bug，或者遇到问题的时候，试着去真正理解发生了什么事情。很有可能其他人已经遇到过同样的问题，并且发布在了网上。谷歌搜索真的很有用。</p><p>学习东西还有一个好方法就是所谓的“教学相长”。当别人在倾听你的言语，并问你问题的同时，你也会学到东西。可以建立用户组或本地会议。</p><p>为自己感兴趣语言和技术加入或启动一个研究小组(模式社区)，也可以创建本地的用户组。</p><p>参加会议。如果去不了的话，也可以在网上看，许多会议会将其谈话免费发布到网上。</p><p>收听播客。</p><p>曾经对代码库运行过静态分析工具，又或者查看下你的IDE警告?了解它们报告了什么，以及其原因。</p><p>当 然如果你有《黑客帝国》中Neo那样的超能力，自然这一切对你而言不过是小菜一碟。但很可惜，我们都是普通人，我们需要时间和精力，以及不断的努力才能促 使自己不断的学习。不过，你不必成天学习。只要你能有意识地花点时间去学习就可以了，哪怕每天一小时，有总比没有好。人活着不是为了工作，你还应该有自己 的生活。</p><p>3、不要害怕破坏东西</p><p>每 个具备行业经验的程序员肯定参与过代码库岌岌可危的项目。系统很糟糕，并且改变这边总是会破坏另一边不相关的功能。每次添加模块，程序员只能想着尽可能少 地改变代码，每次发布都胆战心惊。这座软件的摩天大楼随时有坍塌的可能。之所以改动代码会如此伤脑筋是因为系统太糟糕了。但是即使你知道系统出了问题，却 又因为投鼠忌器，而不得不听之任之。任何一个外科医生都懂得，伤口要想愈合就必须得切除腐肉。虽然手术会带来痛苦，但绝对比任伤口发炎溃烂要好。</p><p>不 要害怕你的代码。没有人会在乎当你捣鼓代码的时候有没有暂时破坏了什么东西。只要你做的改变不会让项目重新回到开始状态，就不会令人崩溃。投入时间重构， 能让你受益于项目整个生命周期。这样做还有一个额外的好处是，由于你有过这种处理病危系统的经验，所以你对它应该如何工作非常内行。要善于应用这些知识， 千万不要反感这些宝贵的财富。重新定义内部接口，重构模块，重构复制粘贴代码，并通过减少依赖来简化设计。你可以通过消除特殊情况显著降低代码的复杂性， 因为特殊情况往往是因为错误的耦合特点导致的。慢慢地从旧结构过渡到新结构，测试一路同行。如果你想要一下子完成一个大的重构，那么往往会因为各种频出的 问题而考虑中途放弃。</p><p>4、专业程序员</p><p>专业程序员的一个最重要的特点是有责任心。专业程序员会为他们的职业生涯、预算、日程安排承诺、错误、技能技巧负责。一个专业的程序员不会将责任推卸给别人。</p><p>如 果你是专业的，那么你就需要为自己的职业生涯负责。你有责任去阅读和学习。你有责任去时刻关注最新的产业和技术。但是许多程序员觉得这应该是他们雇主的工 作。NO，大错特错。想一想医生?想一想律师?他们都是靠自己来培养和训练自己的。他们的下班时间多用在了阅读杂志报刊上。他们时刻关注着最新的资讯动 态。所以，我们也应该如此。你和你雇主之间的关系，已经在雇用合同上作了详细的说明，简而言之就是：你的雇主承诺支付你薪酬，而你承诺做好工作。</p><p>专 业程序员会为他们编写的代码负责。除非他们知道这些代码是有效的，否则就不会发布代码。现在，好好思考这个问题：如果是你，你会不会在不透彻了解代码的情 况下就直接发布代码?专业程序员不希望QA找到任何bug，因为这些代码都是经过他测试之后才发布的。当然，QA依然会发现一些问题，因为没有一个人是完 美的。但作为专业程序员，我们的态度应该是让QA找不到任何缺陷。</p><p>专业程序员也是好的团队成员。他们负责地对待整个团队的输出，而不是只顾自己的工作。他们乐于助人，善于向彼此学习，在需要的时候甚至会鼎力相助，为了项目前仆后继。</p><p>5、充分利用代码分析工具</p><p>测试的价值是编程早期阶段就灌输给软件开发者的一个理念。近年来，单元测试，测试驱动开发和敏捷方法的兴起，证实了我们开始注重于在开发周期的各个阶段进行测试。但是，测试只是你可以用来提高代码质量的许多工具之一。</p><p>回 过头去看，当C语言还是一个新事物的时候，CPU时间和任何类型的存储都是非常宝贵的。第一个C语言编译器注意到了这一点，所以选择了通过去掉一些语义分 析，来减少代码之间的传递次数。这意味着，在编译时，编译器检查到的可能只是可被检测到的bug中的一小部分。为了弥补这个缺陷，Stephen Johnson写了一个名为lint的工具——它将从你的代码中删除一些没有价值的东西——从而实现一些已被它的兄弟C语言编译器撤掉的静态分析功能。然 而，静态分析工具却因为可以给出大范围的误报警告和一些没有必要遵循的静态文体惯例的警告而倍受赞誉。</p><p>现 在的语言、编译器和静态分析工具的设计和以前已经大不相同。由于内存和CPU时间变得相对比较便宜，因此负担得起编译器检查更多的错误。几乎每一种语言都 拥有至少一个工具，用来检查风格指南的违规行为、常见问题以及一些狡猾的有时候可能很难捕捉到的错误，如潜在取消引用空指针。更高级的工具，如C的 Splint，以及Python的pylint，是可配置的，这意味着你可以通过命令行开关或在IDE中，使用配置文件来让工具选择放过其中的哪些错误和 警告。Splint甚至还能让你在注释中注解你的代码，以便于更好地提示你的程序是如何工作的。</p><p>6、关心代码</p><p>优秀程序员能写出好代码，这是毋庸置疑的。坏程序员……则不能(他们能写出好代码，就不是坏程序员了，哈哈)。他们总是在生产其他人不得不消灭的怪兽。你的目标是写出好代码，对不?那么你应该成为好程序员。</p><p>好的代码并不是凭空而来的，也不能靠运气然后恰巧让你瞎猫碰到死老鼠。为了获得良好的代码，你必须努力的改进。过程是艰难的。但是如果你确实关心代码的话，那么你一定能收获好代码。</p><p>仅 靠技术并不能成就好的编程。我碰到过一些非常聪明的程序员，他们能够产出令人印象深刻的算法，能够熟记语言标准，但却写出了最可怕的代码。这种代码，阅读 起来很痛苦，使用起来很痛苦，修改起来更是令人痛不欲生。我也碰到过一些非常谦逊的程序员，因为坚持简单的代码，所以写出来的程序更优雅，更易于表达他的 意思，和他们工作非常愉快。</p><p>基于我多年的软件生产经验，我得出的结论是，差强人意的程序员和伟大的程序员之间的真正区别是：态度。好的编程在于专业的方法，以及一种竭尽全力希望写出最好软件的期望。</p><p>要成为一个优秀的程序员，你必须对自己的代码负责，真正关心代码——养成积极向上的心态。伟大的代码是由大师精心雕琢的，而不是由那些马虎的程序员胡乱写出来的。</p><p><br/></p>','defaultApp/newsInfo','',NULL,'\0',0,NULL,NULL,NULL),('1447039321447','1445933756067','组织架构','','',NULL,NULL,'','','','',NULL,NULL,NULL,'<p>组织机构<br/></p>','defaultApp/single','',NULL,'\0',0,NULL,NULL,NULL),('1447634117675','1445934192714','磷酸二氢钾','','',NULL,NULL,'','','','','20151116_083422.jpg','/upload/1/20151116_083422.jpg',5586,'<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"text-align: center;\"><img src=\"/syst/upload/1/20151116_083422.jpg\" title=\"20151116_083422.jpg\" alt=\"20151116_083422.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">磷酸二氢钾 (MKP)</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">分子式 KH2PO4<br/>分子量 136.09<br/>规 格 工业级：符合HG2321-92；食品级：符合FCC?1981; 客户要求<br/>包 装 25Kg、50Kg内塑外编袋装；客户要求<br/>用 途 工业上用作缓冲剂、培养剂；农业上用作高效磷钾复合肥；食品级用作食品改良添加剂<br/>技术要求&nbsp;<br/>1. 外观：白色粉状或结晶，农业用磷酸二氢钾允许带微色<br/>2. 工业磷酸二氢钾应符合表1要求（HG2321-92）</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">项目 工业 农业<br/>一等品 合格品 一等品 合格品<br/>磷酸二氢钾（KH2PO4以干基计）含量，% ≥ 98.0 97.0 96.0 92.0<br/>水分含量，% ≤ 2.5 3.0 4.0 5.0<br/>PH值 4.3-4.7 4.3-4.7<br/>水不溶物含量，% ≤ 0.20 0.50 —<br/>氯化物（Cl）含量，% ≤ 0.20 —&nbsp;<br/>铁（Fe）含量% ≤ 0.003&nbsp;<br/>砷（As）含量，% ≤ 0.005&nbsp;<br/>重金属（以Pb计）含量，% ≤ 0.005&nbsp;<br/>氯化钾（K2O以干基计）含量，% ≥ 33.9 33.5 33.2 31.8</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">3. 食品添加剂磷酸二氢钾应符合表2要求（FCC?1981）</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">项目 指标<br/>食品级<br/>磷酸二氢钾（KH2PO4以干基计）含量，% ≥ 98.0<br/>干燥失重含量% ≤ 1.0<br/>水不溶物含量，% ≤ 0.2<br/>砷（As）含量，% ≤ 0.0003<br/>重金属（以Pb计）含量，% ≤ 0.002<br/>氟化物（以F计）含量，% ≤ 0.001<br/>铅（以Pb计）含量，% ≤ 0.0005</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">无机盐产品<br/>CAS 编号：磷酸二氢钾&nbsp;<br/>分 子 式： KH 2 PO 4&nbsp;<br/>分 子 量： 136.09&nbsp;<br/>质量规格：<br/>工业级、农业级： HG2321 — 1992 ；客户要求&nbsp;<br/>医药级： USP ；客户要求<br/>食品级： FCC ；客户要求<br/>饲料级： HG2860 — 1997 ；客户要求&nbsp;<br/>项 目 指 标&nbsp;<br/>工业级 农业级 食品级 饲料级&nbsp;<br/>一等品 合格品 一等品 合格品&nbsp;<br/>磷酸二氢钾（ KH 2 PO 4 以干基计）含量， % ≥ 98.0 97.0 96.0 92.0 98.0 98.0&nbsp;<br/>水分， ％ ≤ 2.5 3.0 4.0 5.0 1.0 0.5&nbsp;<br/>PH值 4.3 ～ 4.7 4.3 ～ 4.7 — —&nbsp;<br/>水 不 溶 物 含 量， % ≤ 0.2 0.5 — — 0.2 —&nbsp;<br/>氯化物（以 Cl 计）含量，%≤ 0.20 — — — — 1.0&nbsp;<br/>硫酸盐（以SO 4计）含量%　≤ — — — — — 0.1&nbsp;<br/>铁（ Fe ）含量， % ≤ 0.003 — — — — —&nbsp;<br/>砷（ As ）含量， % ≤ 0.005 — — — 0.0003 0.001&nbsp;<br/>氟化物（以 F 计）含量， %≤ — — — — 0.001 —&nbsp;<br/>铅（ Pb ）， % ≤ — — — — 0.0005 —&nbsp;<br/>重金属（以 Pb 计）含量，%≤ 0.005 — — — 0.002 0.002&nbsp;<br/>氧化钾（K20以干基计）% ≥ 33.9 33.5 33.2 31.8 — —&nbsp;<br/>用 途： 用作高效磷钾复合肥，细菌培养剂，饲料营养补充剂等。在食品工业中作膨松剂、营养强化剂、缓冲剂、螯合剂。<br/>包 装： 25Kg 、 50Kg 袋装；集装吨袋；客户要求。</span></p><p><br/></p>','defaultApp/newsInfo','','1447634062641','',0,NULL,NULL,NULL),('1447634248282','1445934220786','氯霉素','','',NULL,NULL,'','','','','20151116_083704.jpg','/upload/1/20151116_083704.jpg',6221,'<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"text-align: center;\"><img src=\"/syst/upload/1/20151116_083704.jpg\" title=\"20151116_083704.jpg\" alt=\"20151116_083704.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">氯霉素(Chloramphenicol)</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">产品型号：BP 2000</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">产品名称：氯霉素</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">产　　地：江苏/江西</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">质量标准：BP 2000</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">用　　途：广谱抗生素</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">包　　装：25Kg/纸板桶</span></p><p><br/></p>','defaultApp/newsInfo','','1447634062641,1447634224837','',0,NULL,NULL,NULL),('1447634339009','1445934282711','利巴韦林(病毒唑）','','',NULL,NULL,'','','','','20151116_083821.jpg','/upload/1/20151116_083821.jpg',6439,'<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"text-align: center;\"><img src=\"/syst/upload/1/20151116_083821.jpg\" title=\"20151116_083821.jpg\" alt=\"20151116_083821.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">产品名称: 利巴韦林(病毒唑）(中国药典2005年版)</span></p><p><span style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 16px; line-height: 18px; background-color: rgb(255, 255, 255);\">产品类别: 医药原料和中间体&nbsp;</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span><br/></p><p><br/></p>','defaultApp/newsInfo','','1447634062641,1447634224837,1447634301705','',0,NULL,NULL,NULL),('1447634421399','1445934282711','土霉素','','',NULL,NULL,'','','','','20151116_083937.jpg','/upload/1/20151116_083937.jpg',6683,'<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"text-align: center;\"><img src=\"/syst/upload/1/20151116_083937.jpg\" title=\"20151116_083937.jpg\" alt=\"20151116_083937.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">土霉素</span></p><p><span style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 16px; line-height: 18px; background-color: rgb(255, 255, 255);\">抗菌谱和应用与四环素相同。本品对肠道感染，包括阿米巴痢疾，疗效略强于四环素。</span></p>','defaultApp/newsInfo','','1447634062641,1447634224837,1447634301705,1447634377568','',0,NULL,NULL,NULL),('1447639276434','1445934192714','盐酸特比奈芬','','',NULL,NULL,'','','','','20151116_100053.jpg','/upload/1/20151116_100053.jpg',5883,'<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"text-align: center;\"><img src=\"/syst/upload/1/20151116_100053.jpg\" title=\"20151116_100053.jpg\" alt=\"20151116_100053.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">盐酸特比奈芬</span></p><p><span style=\"font-size: 16px;\"><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">产品名称 盐酸特比萘芬 化学名 ：（E）-N-（6，6-二甲基-2-庚烯-4-炔）-N-甲基-1-萘甲胺盐酸盐&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">CAS 78628-80-5 质量标准 EP5.3&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">外观性状 类白色至白色性粉末 含量 不得低于98.5（%）&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">干燥失重 不得过1.0（%） 相关物质 不得过1.0（%）&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">保质期 24（月）&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">中文名：盐酸特比萘芬</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">英文名：Terbinafine hydrochloride;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">中文化学名：（E）-N-（6，6-二甲基-2-庚烯-4-炔）-N-甲基-1-萘甲胺盐酸盐</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">英文化学名：(E)-N-(6,6-Dimethyl-2-hepten-4-ynyl)-N-methyl-1-naphthylmethylamine Hydrochloride</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">分子式：C21H25N ﹒HCl&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">分子量：327.9</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">CAS: 78628-80-5</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">结构式：</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">质量标准：EP5.3</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">项目 标准&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">性状 类白色至白色结晶性粉末&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">有关物质 ≤1.0％&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">干燥失重 ≤0.5％&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">炽灼残渣 ≤0.1%&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">重金属 ≤20ppm&nbsp;</span><br style=\"font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"font-size: 12px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; line-height: 18px; background-color: rgb(255, 255, 255);\">含量 ≥98.5%</span></span></p><p><br/></p>','defaultApp/newsInfo','','1447639253865','',0,NULL,NULL,NULL),('1447639382137','1445934220786','氢化铝锂','','',NULL,NULL,'','','','','20151116_100235.jpg','/upload/1/20151116_100235.jpg',5568,'<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"text-align: center;\"><img src=\"/syst/upload/1/20151116_100235.jpg\" title=\"20151116_100235.jpg\" alt=\"20151116_100235.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">产品名称：氢化铝锂</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">英文名称：lithium aluminium tetrahydride；lithium aluminium hydride 　</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">CAS 号:16853-85-3　</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">含 量：98%以上</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">性 状：白色或类白色结晶粉末.<br/><br/>包 装：1kg铝听或根据客户需要包装.</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">主要用途：用作聚合催化剂、还原剂、喷气发动机燃料，也用于合成药物</span></p><p><br/></p>','defaultApp/newsInfo','','1447639253865,1447639355125','',0,NULL,NULL,NULL),('1447662943264','1445934282711','淀粉酶','','',NULL,NULL,'','','','','20151120_040842.jpg','/upload/1/20151120_040842.jpg',5586,'<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span></p><p style=\"text-align: center;\"><img src=\"/syst/upload/1/20151120_040842.jpg\" title=\"20151120_040842.jpg\" alt=\"20151120_040842.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\"></span><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">供应淀粉酶，1万/2万活力，黄褐色粉末，每袋2kg，每件20kg纸箱包装。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">该产品适用于饴糖、酒精、啤酒、味精、抗生素、有机酸的液化及纺织、印染等行业。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; font-family: 宋体, Tahoma, Helvetica, Arial, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 16px;\">使用注意事项：<br/>1、固体酶制剂在使用前，应提前半小时用40℃的水将酶粉溶解，少量不溶物不影响使用。<br/>2、糖化酶最适PH是6.0-6.5，应先调好PH，后加入淀粉酶。<br/>3、使用淀粉酶将控制好温度，严禁短期高温。本公司有中温和耐高温淀粉酶。<br/>4、钙离子对酶活性起稳定和提高的作用，没有钙离子酶活力全失。</span></p>','defaultApp/productsInfo','','1447662907538,1448006922435','\0',0,NULL,NULL,NULL),('1447668414006','1446965194084','test','','',NULL,NULL,'','','test','','','',NULL,'<p>时代发生的发生的发生</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668477599','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>当时发生的很舒服</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668483574','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>当时发生的很舒服</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668486413','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>当时发生的很舒服</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668489328','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>当时发生的很舒服</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668492260','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>当时发生的很舒服</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668495077','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>当时发生的很舒服</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668544610','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>是的哈哈哈水电费阿斯顿睡得但是但是</p><p>说大萨达但是</p><p>啥还是电话的时候时代复分</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668547780','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>是的哈哈哈水电费阿斯顿睡得但是但是</p><p>说大萨达但是</p><p>啥还是电话的时候时代复分</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668551895','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>是的哈哈哈水电费阿斯顿睡得但是但是</p><p>说大萨达但是</p><p>啥还是电话的时候时代复分</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447668555763','1446965194084','test','','',NULL,NULL,'','','','','','',NULL,'<p>是的哈哈哈水电费阿斯顿睡得但是但是</p><p>说大萨达但是</p><p>啥还是电话的时候时代复分</p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447988832047','1446965194084','Spring注解注入','','',NULL,NULL,'','','','','','',NULL,'<p>,</p><p>1、古老的注入方式：&nbsp;</p><p>实现类:&nbsp;</p><p>Java代码 &nbsp;</p><p>/**&nbsp;</p><p>&nbsp;* @title UserServiceImpl.java&nbsp;</p><p>&nbsp;* @description UserService实现类&nbsp;</p><p>&nbsp;* @author cao_xhu&nbsp;</p><p>&nbsp;* @version&nbsp;</p><p>&nbsp;* @create_date Oct 30, 2009&nbsp;</p><p>&nbsp;* @copyright (c) CVIC SE&nbsp;</p><p>&nbsp;*/ &nbsp;</p><p>public class UserServiceImpl implements UserService { &nbsp;</p><p>&nbsp;&nbsp;</p><p>&nbsp; &nbsp; private UserDAO userDAO; &nbsp;</p><p>&nbsp;&nbsp;</p><p>&nbsp; &nbsp; public void setUserDAO(UserDAO userDAO) { &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; this.userDAO = userDAO; &nbsp;</p><p>&nbsp; &nbsp; } &nbsp;</p><p>... &nbsp;</p><p>} &nbsp;</p><p><br/></p><p>配置文件:&nbsp;</p><p>Xml代码 &nbsp;</p><p>&lt;bean id=&quot;userDAO&quot; class=&quot;springlive.dao.impl.UserDAOImpl&quot;&gt; &nbsp;</p><p>&nbsp; &nbsp; &lt;property name=&quot;sessionFactory&quot;&gt; &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &lt;ref local=&quot;sessionFactory&quot; /&gt; &nbsp;</p><p>&nbsp; &nbsp; &lt;/property&gt; &nbsp;</p><p>&lt;/bean&gt; &nbsp;</p><p>&lt;bean id=&quot;userServiceImpl&quot; &nbsp;</p><p>&nbsp; &nbsp; class=&quot;springlive.service.impl.UserServiceImpl&quot;&gt; &nbsp;</p><p>&nbsp; &nbsp; &lt;property name=&quot;userDAO&quot;&gt; &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &lt;ref local=&quot;userDAO&quot; /&gt; &nbsp;</p><p>&nbsp; &nbsp; &lt;/property&gt; &nbsp;</p><p>&lt;/bean&gt; &nbsp;</p><p><br/></p><p><br/></p><p>2、使用注解的方式：&nbsp;</p><p>2.1、Autowired注解&nbsp;</p><p>&lt;1&gt;对成员变量注解&nbsp;</p><p>实现类：&nbsp;</p><p>Java代码 &nbsp;</p><p>&nbsp; &nbsp; @Autowired &nbsp;</p><p>&nbsp; &nbsp; private IndustryDao industryDao; &nbsp;</p><p>... &nbsp;</p><p>&nbsp; &nbsp; &nbsp;&nbsp;</p><p><br/></p><p>&lt;2&gt;set方法注解&nbsp;</p><p>Java代码 &nbsp;</p><p>@Autowired &nbsp;</p><p>public void setDao(IndustryDao industryDao) &nbsp;</p><p>{ &nbsp;</p><p>&nbsp; &nbsp; super.setDao(industryDao); &nbsp;</p><p>} &nbsp;</p><p><br/></p><p>配置文件：&nbsp;</p><p><br/></p><p>Xml代码 &nbsp;</p><p>&lt;!-- 使用 &lt;context:annotation-config/&gt; 简化配置 &nbsp;</p><p>&nbsp;&nbsp;</p><p>Spring 2.1 添加了一个新的 context 的 Schema 命名空间，该命名空间对注释驱动、属性文件引入、加载期织入等功能提供了便捷的配置。我们知道注释本身是不会做任何事情的，它仅提供元数据信息。要使元数据信息真正起作用，必须让负责处理这些元数据的处理器工作起来。 &nbsp;&nbsp;</p><p>&nbsp;&nbsp;</p><p>而我们前面所介绍的 AutowiredAnnotationBeanPostProcessor 和 CommonAnnotationBeanPostProcessor 就是处理这些注释元数据的处理器。但是直接在 Spring 配置文件中定义这些 Bean 显得比较笨拙。Spring 为我们提供了一种方便的注册这些 BeanPostProcessor 的方式，这就是 &lt;context:annotation-config/&gt;。 &nbsp;</p><p>&nbsp;--&gt; &nbsp;</p><p>&lt;context:annotation-config /&gt; &nbsp;</p><p>&nbsp; &nbsp; &lt;bean id=&quot;industryDao&quot; &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; class=&quot;efs.sadapter.system.industry.dao.hibernate.HibernateIndustryDao&quot; /&gt; &nbsp;</p><p>&nbsp; &nbsp; &lt;bean id=&quot;industryService&quot; &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; class=&quot;efs.sadapter.system.industry.service.impl.IndustryServiceImpl&quot; /&gt; &nbsp;</p><p><br/></p><p><br/></p><p>@Autowired可以对成员变量、方法和构造函数进行标注，来完成自动注入。&nbsp;</p><p>@Autowired的标注位置不同，它们都会在Spring在初始化industryService这个bean时，自动装配industryDao这个属性，区别是：第一种实现中，Spring会直接将IndustryDao类型的唯一一个bean赋值给industryDao这个成员变量；第二种实现中，Spring会调用setDao方法来将IndustryDao类型的唯一一个bean装配到industryDao这个属性。&nbsp;</p><p><br/></p><p>2.2、@Qualifier&nbsp;</p><p>@Autowired是根据类型进行自动注入的，如果spring配置文件中存在多个IndustryDao类型的bean时，或者不存在IndustryDao类型的bean，都会抛出异常。&nbsp;</p><p>存在多个类型的实例时，按id注入@Qualifier(&quot;core.system.hibernateService&quot;)&nbsp;</p><p>Java代码 &nbsp;</p><p>HibernateService hibernateService; &nbsp;</p><p>&nbsp;&nbsp;</p><p>@Autowired &nbsp;</p><p>public void setHibernateService(@Qualifier(&quot;core.system.hibernateService&quot;) &nbsp;</p><p>HibernateService hibernateService) &nbsp;</p><p>{ &nbsp;</p><p>&nbsp; &nbsp; this.hibernateService = hibernateService; &nbsp;</p><p>} &nbsp;</p><p><br/></p><p>若不存在某类型的实例：告诉 Spring：在找不到匹配 Bean 时也不报错&nbsp;</p><p><br/></p><p>Java代码 &nbsp;</p><p>@Autowired(required = false) &nbsp;</p><p>&nbsp; &nbsp; public void setHibernateService(@Qualifier(&quot;core.system.hibernateService&quot;) &nbsp;</p><p>&nbsp; &nbsp; HibernateService hibernateService) &nbsp;</p><p>&nbsp; &nbsp; { &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; this.hibernateService = hibernateService; &nbsp;</p><p>&nbsp; &nbsp; } &nbsp;</p><p><br/></p><p>2.3、使用 JSR-250 的注解&nbsp;</p><p>&lt;1&gt; @Resource&nbsp;</p><p>spring支持@Resource、@PostConstruct以及@PreDestroyJSR-250的标准注解。&nbsp;</p><p>@Resource可以按type注入，也可以按name注入。@Resource默认按byName自动注入。&nbsp;</p><p>Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。&nbsp;</p><p><br/></p><p>@Resource装配顺序&nbsp;</p><p>如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常&nbsp;</p><p>如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常&nbsp;</p><p>如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常&nbsp;</p><p>如果既没有指定name，又没有指定type，则自动按照byName方式进行装配（见2）；如果没有匹配，则回退为一个原始类型（UserDao）进行匹配，如果匹配则自动装配；&nbsp;</p><p>&lt;2&gt; @PostConstruct 和 @PreDestroy&nbsp;</p><p>Spring 容器中的 Bean 是有生命周期的，Spring 允许在 Bean 在初始化完成后以及 Bean 销毁前执行特定的操作，您既可以通过实现 InitializingBean/DisposableBean 接口来定制初始化之后 / 销毁之前的操作方法，也可以通过 &lt;bean&gt; 元素的 init-method/destroy-method 属性指定初始化之后 / 销毁之前调用的操作方法。&nbsp;</p><p>JSR-250 为初始化之后/销毁之前方法的指定定义了两个注释类，分别是 @PostConstruct 和 @PreDestroy，这两个注释只能应用于方法上。标注了 @PostConstruct 注释的方法将在类实例化后调用，而标注了 @PreDestroy 的方法将在类销毁之前调用。&nbsp;</p><p><br/></p><p>使用 @PostConstruct 和 @PreDestroy 注释的 Boss.java&nbsp;</p><p>Java代码 &nbsp;</p><p>package com.baobaotao; &nbsp;</p><p>&nbsp;&nbsp;</p><p>import javax.annotation.Resource; &nbsp;</p><p>import javax.annotation.PostConstruct; &nbsp;</p><p>import javax.annotation.PreDestroy; &nbsp;</p><p>&nbsp;&nbsp;</p><p>public class Boss { &nbsp;</p><p>&nbsp; &nbsp; @Resource &nbsp;</p><p>&nbsp; &nbsp; private Car car; &nbsp;</p><p>&nbsp;&nbsp;</p><p>&nbsp; &nbsp; @Resource(name = &quot;office&quot;) &nbsp;</p><p>&nbsp; &nbsp; private Office office; &nbsp;</p><p>&nbsp;&nbsp;</p><p>&nbsp; &nbsp; @PostConstruct &nbsp;</p><p>&nbsp; &nbsp; public void postConstruct1(){ &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; System.out.println(&quot;postConstruct1&quot;); &nbsp;</p><p>&nbsp; &nbsp; } &nbsp;</p><p>&nbsp;&nbsp;</p><p>&nbsp; &nbsp; @PreDestroy &nbsp;</p><p>&nbsp; &nbsp; public void preDestroy1(){ &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; System.out.println(&quot;preDestroy1&quot;); &nbsp;&nbsp;</p><p>&nbsp; &nbsp; } &nbsp;</p><p>&nbsp; &nbsp; … &nbsp;</p><p>} &nbsp;</p><p><br/></p><p><br/></p><p>测试类代码:&nbsp;</p><p>Java代码 &nbsp;</p><p>package com.baobaotao; &nbsp;</p><p>&nbsp;&nbsp;</p><p>import org.springframework.context.support.ClassPathXmlApplicationContext; &nbsp;</p><p>&nbsp;&nbsp;</p><p>public class AnnoIoCTest { &nbsp;</p><p>&nbsp;&nbsp;</p><p>&nbsp; &nbsp; public static void main(String[] args) { &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; String[] locations = {&quot;beans.xml&quot;}; &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; ClassPathXmlApplicationContext ctx = &nbsp;&nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; new ClassPathXmlApplicationContext(locations); &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; Boss boss = (Boss) ctx.getBean(&quot;boss&quot;); &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; System.out.println(boss); &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; ctx.destroy();// 关闭 Spring 容器，以触发 Bean 销毁方法的执行 &nbsp;</p><p>&nbsp; &nbsp; } &nbsp;</p><p>} &nbsp;</p><p><br/></p><p>标注了 @PostConstruct 的 postConstruct1() 方法将在 Spring 容器启动时，创建 Boss Bean 的时候被触发执行，而标注了 @PreDestroy 注释的 preDestroy1() 方法将在 Spring 容器关闭前销毁 Boss Bean 的时候被触发执行。&nbsp;</p><p><br/></p><p>3、使用 @Component&nbsp;</p><p>虽然我们可以通过 @Autowired 或 @Resource 在 Bean 类中使用自动注入功能，但是 Bean 还是在 XML 文件中通过 &lt;bean&gt; 进行定义 —— 也就是说，在 XML 配置文件中定义 Bean，通过 @Autowired 或 @Resource 为 Bean 的成员变量、方法入参或构造函数入参提供自动注入的功能。能否也通过注释定义 Bean，从 XML 配置文件中完全移除 Bean 定义的配置呢？答案是肯定的，我们通过 Spring 2.5 提供的 @Component 注释就可以达到这个目标了。&nbsp;</p><p><br/></p><p>下面，我们完全使用注释定义 Bean 并完成 Bean 之间装配：&nbsp;</p><p>使用 @Component 注释的Woman.java&nbsp;</p><p>Java代码 &nbsp;</p><p>@Component &nbsp;</p><p>public class Woman{ &nbsp;</p><p>&nbsp; &nbsp; … &nbsp;</p><p>} &nbsp;</p><p><br/></p><p><br/></p><p>使用 @Component 注释的Woman.java&nbsp;</p><p>Java代码 &nbsp;</p><p>@Component &nbsp;</p><p>public class Man{ &nbsp;</p><p>&nbsp; &nbsp; … &nbsp;</p><p>} &nbsp;</p><p><br/></p><p>这样，我们就可以在 Human类中通过 @Autowired 注入前面定义的 Woman和 Man Bean 了。&nbsp;</p><p><br/></p><p>Java代码 &nbsp;</p><p>@Component(&quot;human&quot;) &nbsp;</p><p>public class Human{ &nbsp;</p><p>&nbsp; &nbsp; @Autowired &nbsp;</p><p>&nbsp; &nbsp; private Woman woman; &nbsp;</p><p>&nbsp;&nbsp;</p><p>&nbsp; &nbsp; @Autowired &nbsp;</p><p>&nbsp; &nbsp; private Man man; &nbsp;</p><p>&nbsp; &nbsp; … &nbsp;</p><p>} &nbsp;</p><p><br/></p><p><br/></p><p>一般情况下，Bean 都是 singleton 的，需要注入 Bean 的地方仅需要通过 byType 策略就可以自动注入了，所以大可不必指定 Bean 的名称。如果需要使用其它作用范围的 Bean，可以通过 @Scope 注释来达到目标:&nbsp;</p><p>Java代码 &nbsp;</p><p>@Scope(&quot;prototype&quot;) &nbsp;</p><p>@Component(&quot;human&quot;) &nbsp;</p><p>public class Human{ &nbsp;</p><p>&nbsp; &nbsp; &nbsp; &nbsp;… &nbsp;</p><p>} &nbsp;</p><p><br/></p><p><br/></p><p>在使用 @Component 注释后，Spring 容器必须启用类扫描机制以启用注释驱动 Bean 定义和注释驱动 Bean 自动注入的策略。Spring 2.5 对 context 命名空间进行了扩展，提供了这一功能，请看下面的配置：&nbsp;</p><p>Xml代码 &nbsp;</p><p>&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; ?&gt; &nbsp;</p><p>&lt;beans xmlns=&quot;http://www.springframework.org/schema/beans&quot; &nbsp;</p><p>&nbsp; &nbsp; xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot; &nbsp;</p><p>&nbsp; &nbsp; xmlns:context=&quot;http://www.springframework.org/schema/context&quot; &nbsp;</p><p>&nbsp; &nbsp; xsi:schemaLocation=&quot;http://www.springframework.org/schema/beans &nbsp;&nbsp;</p><p>&nbsp;http://www.springframework.org/schema/beans/spring-beans-2.5.xsd &nbsp;</p><p>&nbsp;http://www.springframework.org/schema/context &nbsp;&nbsp;</p><p>&nbsp;http://www.springframework.org/schema/context/spring-context-2.5.xsd&quot;&gt; &nbsp;</p><p>&nbsp; &nbsp; &lt;context:component-scan base-package=&quot;springlive.learn.component &quot;/&gt; &nbsp;</p><p>&lt;/beans&gt; &nbsp;</p><p>参考资料:&nbsp;</p><p>使用 Spring 2.5 注释驱动的 IoC 功能http://www.ibm.com/developerworks/cn/java/j-lo-spring25-ioc/?ca=drs-tp0808</p><p><br/></p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447990200173','1446965194084','Spring Annotation','','',NULL,NULL,'','','','','','',NULL,'<p>使用 JSR-250 的注释</p><p><br/></p><p>Spring 不但支持自己定义的 @Autowired 的注释，还支持几个由 JSR-250 规范定义的注释，它们分别是@Resource、@PostConstruct 以及 @PreDestroy。</p><p><br/></p><p>@Resource</p><p><br/></p><p>@Resource 的作用相当于 @Autowired，只不过 @Autowired 按 byType 自动注入，面 @Resource 默认按 byName 自动注入罢了。@Resource 有两个属性是比较重要的，分别是 name 和 type，Spring 将 @Resource 注释的 name 属性解析为 Bean 的名字，而 type 属性则解析为 Bean 的类型。所以如果使用 name 属性，则使用 byName 的自动注入策略，而使用 type 属性时则使用 byType 自动注入策略。如果既不指定 name 也不指定 type 属性，这时将通过反射机制使用 byName 自动注入策略。</p><p><br/></p><p>Resource 注释类位于 Spring 发布包的 lib/j2ee/common-annotations.jar 类包中，因此在使用之前必须将其加入到项目的类库中。来看一个使用 @Resource 的例子：</p><p><br/></p><p><br/></p><p>清单 16. 使用 @Resource 注释的 Boss.java</p><p><br/></p><p>[html] view plaincopy</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &lt;pre class=&quot;html&quot; name=&quot;code&quot;&gt;package com.baobaotao; &nbsp;</p><p>&nbsp;&nbsp;</p><p>import javax.annotation.Resource; &nbsp;</p><p>&nbsp;&nbsp;</p><p>public class Boss { &nbsp;</p><p>&nbsp; &nbsp; // 自动注入类型为 Car 的 Bean &nbsp;</p><p>&nbsp; &nbsp; @Resource &nbsp;</p><p>&nbsp; &nbsp; private Car car; &nbsp;</p><p>&nbsp;&nbsp;</p><p>&nbsp; &nbsp; // 自动注入 bean 名称为 office 的 Bean &nbsp;</p><p>&nbsp; &nbsp; @Resource(name = &quot;office&quot;) &nbsp;</p><p>&nbsp; &nbsp; private Office office; &nbsp;</p><p>} &nbsp;</p><p>&nbsp;&nbsp;</p><p>&lt;/pre&gt;&lt;br&gt; &nbsp;</p><p>&lt;pre&gt;&lt;/pre&gt; &nbsp;</p><p>&lt;p&gt;一般情况下，我们无需使用类似于&lt;span&gt; &lt;/span&gt;&lt;code style=&quot;font-family:&#39;Courier New&#39;,Courier,monospace; white-space:pre; font-size:1em&quot;&gt;@Resource(type=Car.class)&lt;/code&gt;&lt;span&gt; &lt;/span&gt;的注释方式，因为 Bean 的类型信息可以通过 Java 反射从代码中获取。&lt;/p&gt; &nbsp;</p><p>&lt;p&gt;要让 JSR-250 的注释生效，除了在 Bean 类中标注这些注释外，还需要在 Spring 容器中注册一个负责处理这些注释的&lt;span&gt; &lt;/span&gt;&lt;code style=&quot;font-family:&#39;Courier New&#39;,Courier,monospace; white-space:pre; font-size:1em&quot;&gt;BeanPostProcessor&lt;/code&gt;：&lt;/p&gt; &nbsp;</p><p>&lt;pre class=&quot;html&quot; name=&quot;code&quot;&gt;&lt;bean class=&quot;org.springframework.context.annotation.CommonAnnotationBeanPostProcessor&quot;/&gt; &nbsp;&nbsp;</p><p>&lt;/pre&gt;</p><p><br/></p>','defaultApp/newsInfo','','','\0',0,NULL,NULL,NULL),('1447991085421','1445934192714','淀粉酶','','',NULL,NULL,'','','淀粉酶','','20151120_114304.jpg','/upload/1/20151120_114304.jpg',5586,'<p style=\"text-align:center\"><img src=\"/syst/upload/1/20151120_114304.jpg\" title=\"20151120_114304.jpg\" alt=\"20151120_114304.jpg\"/></p><p>很多时候速度发顺丰<br/></p>','defaultApp/productsInfo','','1447990985292','',0,NULL,NULL,NULL),('1447999888637','1446965194084','dfsfsa','','',NULL,NULL,'','','','','20151120_021037.jpg','/upload/1/20151120_021037.jpg',5568,'<p><img src=\"/syst/upload/1/20151120_021037.jpg\" title=\"20151120_021037.jpg\" alt=\"20151120_021037.jpg\"/>dsfdsfsdfsdfdsfdsfsdf</p><p><br/></p>','defaultApp/newsInfo','','1447999837785','\0',0,NULL,NULL,NULL),('1448682617468','1446965194084','elasticsearch ik分词插件es-ik发布了','','',NULL,NULL,'','','','','','',NULL,'<p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">呵呵，以前我一直用medcl大神开发的<a herf=\"https://github.com/medcl/elasticsearch-analysis-ik\" style=\"border: 0px; margin: 0px; padding: 0px;\">https://github.com/medcl/elasticsearch-analysis-ik</a>,感觉对源代码稍微改动大了点。对ik源码不是很熟悉的朋友，阅读该插件代码，稍微有点困难。自己就将代码做了一些修改。使初学者能较快的阅读代码。在这里，没有对medcl大神不敬的意思。</p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">该插件仅对ik分词源码Dictionary.java源码做了修改。Analyzer 使用了ESIKAnalyzer类，未对IKAnalyzer类做修改。Tokenizer使用ESIKTokenizer类，未对IKTokenizer类做修改。这样对ik源码未作较大的破坏，也比较容易阅读。</p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">喜欢的朋友可以用一下，多提意见。</p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">备注：支持lucene4版本，lucene3不支持。支持elasticsearch-0.90.0及以上版本。以下版本暂不支持。<br style=\"border: 0px; margin: 0px; padding: 0px;\"/>因为：elasticsearch-0.90.0及以上版本采用lucene4版本。</p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">下载地址：<a href=\"https://github.com/awnuxkjy/es-ik\" style=\"border: 0px; margin: 0px; padding: 0px; color: rgb(0, 136, 221); text-decoration: none;\">https://github.com/awnuxkjy/es-ik</a></p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">参考了medcl的插件：<a href=\"https://github.com/medcl/elasticsearch-analysis-ik\" style=\"border: 0px; margin: 0px; padding: 0px; color: rgb(0, 136, 221); text-decoration: none;\">https://github.com/medcl/elasticsearch-analysis-ik</a></p><p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &#39;Hiragino Sans GB&#39;, &#39;Microsoft Yahei&#39;, &#39;Helvetica Neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\">ik源码下载：<a href=\"https://code.google.com/p/ik-analyzer/downloads/detail?name=IK%20Analyzer%202012FF_hf1_source.rar&can=2&q=\" style=\"border: 0px; margin: 0px; padding: 0px; color: rgb(0, 136, 221); text-decoration: none;\">IK Analyzer 2012FF_hf1_source.rar</a><br style=\"border: 0px; margin: 0px; padding: 0px;\"/>这个版本是支持lucene4的.其主页为：<a href=\"https://code.google.com/p/ik-analyzer/\" style=\"border: 0px; margin: 0px; padding: 0px; color: rgb(0, 136, 221); text-decoration: none;\">https://code.google.com/p/ik-analyzer/</a></p><p><br/></p>','doc.jsp','','','',0,NULL,NULL,NULL),('1448851374598','1448843740500','整个集群fgc严重，导致无法为用户提供服务','','华南调研',NULL,NULL,'','','华南调研员','','','',NULL,'<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">官网地址:http://commons.apache.org/proper/commons-dbcp/configuration.html</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">initialSize：默认0,初始化连接:连接池启动时创建的初始化连接数量,1.2版本后支持</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">maxActive：默认8,最大活动连接:连接池在同一时间能够分配的最大活动连接的数量, 如果设置为非正数则表示不限制</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">maxIdle：默认8,最大空闲连接:连接池中容许保持空闲状态的最大连接数量,超过的空闲连接将被释放,如果设置为负数表示不限制</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">minIdle:默认0,最小空闲连接:连接池中容许保持空闲状态的最小连接数量,低于这个数量将创建新的连接,如果设置为0则不创建</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">maxOpenPreparedStatements：同一时间能够从语句池里分配的已备语句的最大数量。设置为0时表示无限制。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">maxWait:默认-1, [官网为：maxWaitMillis,但实际是用前面的]：在抛出异常之前，池等待连接被回收的最长时间（当没有可用连接时）。最大等待时间:当没有可用连接时,连接池等待连接被归还的最大时间(以毫秒计数),超过时间则抛出异常,如果设置为-1表示无限等待</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">minIdle：在不新建连接的条件下，池中保持空闲的最少连接数。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">poolPreparedStatements：默认值false,是否对statement进行池管理（布尔值）。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">maxOpenPreparedStatements:默认不限制,statement池能够同时分配的打开的statements的最大数量, 如果设置为0表示不限制</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">timeBetweenEvictionRunsMillis： 默认-1,在空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位. 如果设置为非正数,则不运行空闲连接回收器线程</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">minEvictableIdleTimeMillis：默认值1000 * 60 * 30,把空闲时间超过minEvictableIdleTimeMillis毫秒的连接断开, 直到连接池中的连接数到minIdle为止 连接池中连接可空闲的时间,毫秒</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">numTestsPerEvictionRun:默认值3,在每次空闲连接回收器线程(如果有)运行时检查的连接数量</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">testWhileIdle:默认-1,指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除.</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">注意: 设置为true后如果要生效,validationQuery参数必须设置为非空字符串</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">defaultAutoCommit：默认true,默认的SQL语句自动提交状态(开启或关闭)设置由连接池本身设置(false由连接池定)，不设置该值setAutoCommit方法不被调用；</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">defaultReadOnly:默认driver default，连接池创建的连接的默认的read-only状态. 如果没有设置则setReadOnly方法将不会被调用. (某些驱动不支持只读模式,比如:Informix)</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">defaultTransactionIsolation：默认driver default，连接池创建的连接的默认的TransactionIsolation状态. 下面列表当中的某一个: (参考javadoc)NONE，READ_COMMITTED，READ_UNCOMMITTED，REPEATABLE_READ，SERIALIZABLE</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">defaultCatalog：连接池创建的连接的默认的catalog</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">connectionProperties：当建立新连接时被发送给JDBC驱动的连接参数，格式必须是 [propertyName=property;]*</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">注意 ：参数user/password将被明确传递，所以不需要包括在这里。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">username：传递给JDBC驱动的用于建立连接的用户名</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">password：传递给JDBC驱动的用于建立连接的密码</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">url：传递给JDBC驱动的用于建立连接的URL</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">driverClassName:使用的JDBC驱动的完整有效的java 类名</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">validationQuery：要求必需是个SELECT类型的SQL语句，至少返回一行，由于它会在所有应用的SQL语句执行之前运行一次，所以原则上应该对数据库服务器带来的压力越小越好，推荐使用“SELECT 1”</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">testOnBorrow：表示从连接池中获取连接前是否运行validationQuery，true=运行[默认]，false=不运行；</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">testOnReturn：表示将连接归还连接池前是否运行validationQuery，true=运行，false=不运行[默认]；</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">removeAbandoned:默认值false，标记是否删除泄露的连接,如果他们超过了removeAbandonedTimout的限制.如果设置为true, 连接被认为是被泄露并且可以被删除,如果空闲时间超过removeAbandonedTimeout. 设置为true可以为写法糟糕的没有关闭连接的程序修复数据库连接.</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">removeAbandonedTimeout:默认值300,泄露的连接可以被删除的超时值, 单位秒</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">logAbandoned:默认值false,标记当Statement或连接被泄露时是否打印程序的stack traces日志。被泄露的Statements和连接的日志添加在每个连接打开或者生成新的Statement,因为需要生成stack trace。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">常用参数配置：</span></p><p><br/></p>','','','','\0',0,NULL,'2015-11-30 15:23:55','官网地址:http://commons.apache.org/proper/commons-dbcp/configuration.htmlinitialSize：默认0,初始化连接:连接池启动时创建的初始化连接数量,1.2版本后支持maxActive：默认8,最大活动连接:连接池在同一时间能够分配的最大活动连接的数量, 如果设置为非正数则表示不限制maxIdle：默认8,最大空闲连接:连接池中容许'),('1448866298907','1448843740500','master状态变迁','','华南区采购员',NULL,NULL,'','','华南区采购员','','','',NULL,'<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">server.slaves里维护所有的slave列表，slave.replstate里记录着每个slave当前的同步状态.</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">1.当master接受到slave发来的sync/psync命令时，将该slave的状态转换为REDIS_REPL_WAIT_BGSAVE_START</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">2.master为该slave后台启动rdbSaveBackground，并将该slave的状态转换为REDIS_REPL_WAIT_BGSAVE_END （如果master己收到sync时，master正在为某个slave转储rdb文件，则新的slave可以直接进入REDIS_REPL_WAIT_BGSAVE_END状态）</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">3.当rdbSaveBackground完成后，slave的状态转换为REDIS_REPL_SEND_BULK，master开始将rdb文件发送给slave，发送前会先发送rdb文件的长度信息。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">4.当rdb文件发送完成后，slave的状态转换为REDIS_REPL_ONLINE。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">master在为slave启动rdbSaveBackground后，master上的更新会累积到slave的连接缓冲区，等到slave接受完rdb文件之后，将缓冲区里累积的更新同步到slave上</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">slave状态变迁</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">server.repl_state储存slave当前的复制状态</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">redis启动时初始化为REDIS_REPL_NONE</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">当接受到slaveof命令后，该redis转换为slave，同时状态变为REDIS_REPL_CONNECT</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">周期性执行的replicationCron会检查slave当前的状态，来执行不同的操作</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">1.如果slave处于REDIS_REPL_CONNECT,调用connectWithMaster建立到master的连接，状态转换为REDIS_REPL_CONNECTING</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">2.连接建立后，向master发送PING，状态转换为REDIS_REPL_RECEIVE_PONG</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">3.接受到PONG后，如果master配置了需要认证，则slave发送AUTH消息，AUTH通过后；slave发送REPLCONF listening-port消息到master告知自身监听的端口；最后向master发送SYNC命令来请求同步rdb文件，同时状态转换为REDIS_REPL_TRANSFER。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">4.当master向slave发送rdb后，slave就开始读取rdb文件（master发送rdb前会先告知rdb文件的总长度），slave接受完rdb文件后，会emptyDb清空数据库，然后调用rdbLoad加载从master接受到的rdb文件，加载完成后状态变为REDIS_REPL_CONNECTED，接下来slave会继续接受从master同步过来的新操作，以保证主备的一致性。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">主从同步时序</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">1.管理员向server发送slaveof master-ip master-port，将该server变为master的slave</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">2.slave建立到master的网络连接</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">3.slave向master发送PING检测网络状态，master回复+PONG</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">4.slave向master发送AUTH进行认证（可选)，master恢复+OK</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">5.slave向master发送REPLCONF listening-port，master恢复+OK</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">6.slave向master发送sync/psync，master开始后台转储rdb文件</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">7.master转储rdb完成后，向slave发送rdb文件，slave接受rdb文件并清空数据库，load从master接受到的rdb文件</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">8.master将rdb转储及传输期间累积的更新操作同步到slave</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">9.master与slave数据到达一致，接下来master接受到的所有更新操作都会同步到slave</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">主从同步状态维护</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">master周期性的ping slave(默认10s)，当ping不通slave超过60s（默认）后，就会认为slave挂掉了，便会断开与该slave的连接；同理，slave如果超过一定时间没有接受到master的PING，会认为master挂掉了，便会断开与master的连接。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">当master、slave连接断开后，slave需要重新向master请求同步rdb文件；2.8版本里redis一定程度支持增量同步，master将同步数据同步给slave时，会同时存储到一个环形缓冲区（默认1M大小），这个缓冲区永远存储最新的同步数据；另外master、slave都会记录当前同步的offset。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">当slave与master断开后，slave会先尝试进行PSYNC增量同步，如果连接断开期间，master没有重启过，并且slave的offset在master的环形缓冲区内，则可直接进行增量同步，比如：假设环形缓冲区的长度为1000, master的同步offset为10000，此时缓冲区里记录的是9001-10000的同步数据，slave同步到9500时，与master断开了连接；slave重新建立与master连接后，会带上offset 9500，请求增量同步，master发现该slave的offset在9001-10000之间，可以进行增量同步，将9501-10000的同步数据发送给slave，以达到主备一致的状态。</span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p>','','','','\0',NULL,'2015-11-30 14:51:39','2015-11-30 15:21:20','server.slaves里维护所有的slave列表，slave.replstate里记录着每个slave当前的同步状态.1.当master接受到slave发来的sync/psync命令时，将该slave的状态转换为REDIS_REPL_WAIT_BGSAVE_START2.master为该slave后台启动rdbSaveBackground，并将该slave的状态转换为REDIS_REPL_WA');
/*!40000 ALTER TABLE `busi_document` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `log` VALUES ('1444461791779','access','admin','/syst/admin',NULL,'/syst/admin/user/create','POST','username=11&password=&roleId=1',''),('1444462164666','access','admin','/syst/admin',NULL,'/syst/admin/user/create','POST','username=ewew&password=&roleId=1',''),('1444462267090','access','admin','/syst/admin',NULL,'/syst/admin/user/deleteById','POST','idstring=1444462156956',''),('1444473873451','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','id=&value=dsfdsf&label=fsdfs&type=dsf',''),('1444521665878','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','id=&value=klkl&label=klkl&type=dsf',''),('1444521698983','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/deleteById','POST','idstring=1444521665766',''),('1444522698205','access','admin','/syst/admin',NULL,'/syst/admin/test/create','POST','id=&name=dsds&createDate=&updateDate=',''),('1444522751730','access','admin','/syst/admin',NULL,'/syst/admin/test/deleteById','POST','idstring=1444522696210',''),('1444522792673','access','admin','/syst/admin',NULL,'/syst/admin/test/create','POST','id=eww&name=wqwq&createDate=&updateDate=',''),('1444522818280','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqiii&createDate=Sun Oct 11 08:19:53 CST 2015&updateDate=',''),('1444522877181','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqiii&createDate=Sun Oct 11 08:19:53 CST 2015&updateDate=',''),('1444523023078','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqii&createDate=Sun Oct 11 08:19:53 CST 2015&updateDate=',''),('1444523252297','access','admin','/syst/admin',NULL,'/syst/admin/user/update/2','POST','id=2&username=test1&password=&roleId=2',''),('1444523367070','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqewew',''),('1444523435595','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=wqwqiiiiii',''),('1444523458827','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=test',''),('1444523589961','access','admin','/syst/admin',NULL,'/syst/admin/test/update/1444522792556','POST','id=1444522792556&name=test112',''),('1444526990037','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=&parentIds=&name=test&available=',''),('1444527152005','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=&parentIds=&name=test&available=',''),('1444534867380','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=&parentIds=&name=ass&available=',''),('1444548142682','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=2&name=组织管理&authName=organization:*&path=/organization&type=menu',''),('1444548969561','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=2&name=角色授权&authName=roleResource|*&path=/roleResource&type=menu',''),('1444550544945','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=2&name=组织授权&authName=organizationResource:*&path=/organizationResource&type=menu',''),('1444573320976','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=&name=关于系统&authName=&path=&type=menu',''),('1444573378659','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1444573320799&name=产品信息&authName=&path=/productInfo&type=menu',''),('1444574410762','access','admin','/syst/admin',NULL,'/syst/admin/resource/deleteById','POST','idstring=1',''),('1444575788831','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1444573320799&name=修改密码&authName=&path=/changePassword&type=menu',''),('1444628148087','access','admin','/syst/admin',NULL,'/syst/admin/resource/deleteById','POST','idstring=1444575788723',''),('1444631314573','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=2&name=字典管理&authName=&path=/dictionary&type=menu',''),('1444632936253','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/deleteById','POST','idstring=1444473873037',''),('1444633076902','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=true&label=是&type=available',''),('1444633285726','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=false&label=否&type=available',''),('1444635718867','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=true&label=男&type=sex',''),('1444635730168','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=false&label=女&type=sex',''),('1444636328281','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=&name=公司&available=true',''),('1444636390553','access','admin','/syst/admin',NULL,'/syst/admin/organization/deleteById','POST','idstring=1444534865650',''),('1444636521753','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636328008&name=财务部&available=true',''),('1444636560272','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636328008&name=市场部&available=true',''),('1444636576043','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636328008&name=研发部&available=true',''),('1444636666722','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636575952&name=研发一部&available=true',''),('1444636687175','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636575952&name=研发二部&available=true',''),('1444646456492','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1444573378567','POST','parentId=1444573320799&name=产品信息&authName=&path=/user/productInfo&type=menu',''),('1444657440163','access','admin','/syst/admin',NULL,'/syst/admin/user/create','POST','username=123&organizationId=1444636666661&password=&roleId=1',''),('1444658564224','access','admin','/syst/admin',NULL,'/syst/admin/user/deleteById','POST','idstring=1444658081768,1444657439316',''),('1444658595341','access','admin','/syst/admin',NULL,'/syst/admin/user/create','POST','username=123&organizationId=1444636666661&password=&roleId=1',''),('1444660524158','access','admin','/syst/admin',NULL,'/syst/admin/user/update/1444658591291','POST','id=1444658591291&username=123&organizationId=1444636521670&password=&roleId=1',''),('1444660940062','access','admin','/syst/admin',NULL,'/syst/admin/user/update/2','POST','id=2&username=test&organizationId=1444636328008&password=&roleId=2',''),('1444704614238','access','admin','/syst/admin',NULL,'/syst/admin/user/update/2','POST','id=2&username=test&organizationId=1444636328008&password=&roleId=2',''),('1444704720356','access','admin','/syst/admin',NULL,'/syst/admin/user/update/2','POST','id=2&username=test&organizationId=1444636328008&password=&roleId=2',''),('1444705528084','access','admin','/syst/admin',NULL,'/syst/admin/user/update/2','POST','id=2&username=test&organizationId=1444636328008&password=&roleId=1',''),('1444705760683','access','admin','/syst/admin',NULL,'/syst/admin/user/update/2','POST','id=2&username=test&organizationId=1444636328008&password=&roleId=1',''),('1444706427606','access','admin','/syst/admin',NULL,'/syst/admin/user/update/2','POST','id=2&username=test&organizationId=1444636560192&password=&roleId=1',''),('1444706750682','access','admin','/syst/admin',NULL,'/syst/admin/user/update/1','POST','id=1&username=admin&organizationId=1444636328008&password=&roleId=1',''),('1444707135766','access','admin','/syst/admin',NULL,'/syst/admin/user/update/1','POST','id=1&username=admin&organizationId=&password=&roleId=1',''),('1444707160889','access','admin','/syst/admin',NULL,'/syst/admin/user/update/1','POST','id=1&username=admin&organizationId=1444636521670&password=&roleId=1',''),('1444707442615','access','admin','/syst/admin',NULL,'/syst/admin/user/update/1444658591291','POST','id=1444658591291&username=123&organizationId=1444636560192&password=&roleId=1',''),('1444806244826','access','admin','/syst/admin',NULL,'/syst/admin/role/create','POST','name=test1',''),('1444876159396','access','admin','/syst/admin',NULL,'/syst/admin/user/create','POST','username=ewew&organizationId=1444636328008&password=&roleId=1',''),('1444885097090','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=&name=test&authName=&path=&type=menu',''),('1444885145375','access','admin','/syst/admin',NULL,'/syst/admin/resource/deleteById','POST','idstring=1444885095467',''),('1444890482621','access','admin','/syst/admin',NULL,'/syst/admin/organization/create','POST','parentId=1444636575952&name=研发三部&available=true',''),('1444891927652','access','admin','/syst/admin',NULL,'/syst/admin/organization/update/1444636560192','POST','id=1444636560192&parentId=1444636328008&name=市场部&available=false',''),('1444987150866','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=&name=数据库&authName=&path=&type=menu',''),('1444987227000','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1444987149377&name=数据库备份管理&authName=dbBackup:*&path=/dbBackup&type=menu',''),('1445057609284','access','admin','/syst/admin',NULL,'/syst/admin/dbBackup/deleteById','POST','idstring=94ef4a1e-2c5a-421d-8d91-4e5401e54f0f',''),('1445065243584','access','admin','/syst/admin',NULL,'/syst/admin/resource/deleteById','POST','idstring=1444548968675,1444550544838',''),('1445075671821','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=&name=栏目&authName=channel:*&path=/channel&type=menu',''),('1445075703962','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=&name=文档&authName=document:*&path=/document&type=menu',''),('1445084486374','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=true&label=是&type=openMode',''),('1445084504353','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=false&label=否&type=openMode',''),('1445086466947','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','parentId=&linkAddr=&desc=&name=新闻&keyword=新闻，news&code=news&openMode=true',''),('1445086819068','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','parentId=&linkAddr=&desc=&name=新闻&keyword=新闻，news&code=news&openMode=true',''),('1445086834289','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','parentId=&linkAddr=&desc=&name=新闻&keyword=新闻，news&code=news&openMode=true',''),('1445130394900','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=新闻&parentId=&linkAddr=&name=新闻&keyword=新闻，news&code=news&openMode=true',''),('1445137715738','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=&linkAddr=&name=test&keyword=&code=&openMode=true',''),('1445137720485','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445137715690',''),('1445137723908','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445137715690',''),('1445137772871','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=&linkAddr=&name=test&keyword=&code=&openMode=true',''),('1445137782009','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445137772831',''),('1445137809630','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=&linkAddr=&name=test&keyword=&code=&openMode=true',''),('1445137815235','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445137809586',''),('1445139154778','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445130394473','POST','id=1445130394473&descrition=新闻&parentId=1445130394473&linkAddr=&name=新闻&keyword=新闻，news&code=news&openMode=true',''),('1445139264057','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445130394473','POST','id=1445130394473&descrition=新闻&parentId=&linkAddr=&name=新闻&keyword=新闻，news&code=news&openMode=false',''),('1445139381681','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=1445130394473&linkAddr=&name=体育&keyword=体育，sports&code=sports&openMode=true',''),('1445222940765','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=&title=&source=&color=&titleImage=&priority=&keyword=&fileAddr=&fileName=&sourceAddr=&size=',''),('1445242395078','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=黄记新&title=二少联手砍40分 雷霆结束掘金4连胜&editorValue=<p>谈汽车0-100加速度</p><h2>什么是汽车0-100加速度</h2><p>汽车0-100加速度是指汽车点火后从静止状态加速到100km/h所用的时间，民用车通常在7-10秒左右。</p><&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445242558317','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=test&title=test&editorValue=<p>但是很舒服<br/></p>&source=&color=&titleImage=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445243132922','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=test&title=test&editorValue=<p>te额台湾问题为<br/></p>&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445243351338','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=test&title=test&editorValue=<p>特提斯<br/></p>&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445243390828','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=test&title=test&editorValue=<p>test<br/></p>&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445243465003','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=速度多少&title=到时候&editorValue=<p>第三方的身份<br/></p>&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445243727564','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=&title=&source=&color=&titleImage=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445244571986','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=&title=&source=&color=&titleImage=&priority=&keyword=&fileAddr=&fileName=&sourceAddr=&size=',''),('1445244631591','access','admin','/syst/admin',NULL,'/syst/admin/document/deleteById','POST','idstring=1445244571092,1445243727454,1445243464921,1445243390752',''),('1445245578403','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=<p>的时候说的话<br/></p>&author=&title=&editorValue=<p>的时候说的话<br/></p>&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445245594050','access','admin','/syst/admin',NULL,'/syst/admin/document/deleteById','POST','idstring=1445245577629',''),('1445245615601','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=&author=&title=&source=&color=&titleImage=&priority=&keyword=&fileAddr=&fileName=&sourceAddr=&size=',''),('1445245640733','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=<p>傻大时代<br/></p>&author=test&title=test&editorValue=<p>傻大时代<br/></p>&source=&titleImage=&color=&priority=&fileAddr=&keyword=test&fileName=&sourceAddr=&size=',''),('1445246336518','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=<p><img src=\"/ueditor/jsp/upload/image/20151019/1445246260741001574.jpg\" style=\"\" title=\"14452462607&author=test&title=test&editorValue=<p><img src=\"/ueditor/jsp/upload/image/20151019/1445246260741001574.jpg\" style=\"\" title=\"14452462607&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445249753622','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=<p>适当放松的方式<br/></p>&author=&title=test&editorValue=<p>适当放松的方式<br/></p>&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445249831820','access','admin','/syst/admin',NULL,'/syst/admin/document/deleteById','POST','idstring=1445245640651,1445245615476,1445243351210,1445243131971,1445242558182,1445242394645',''),('1445250072215','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=<p>test<br/></p>&author=&title=test&editorValue=<p>test<br/></p>&source=&titleImage=&color=&priority=&fileAddr=&keyword=&fileName=&sourceAddr=&size=',''),('1445250101344','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>发生的<br/></p>&channelId=1445130394473&keyword=&sourceAddr=&size=&content=<p>发生的<br/></p>&author=&title=时代复分&source=&titleImage=&color=&priority=&fileAddr=&fileName=',''),('1445250201938','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>test<br/></p>&channelId=1445130394473&keyword=&sourceAddr=&size=&content=<p>test<br/></p>&author=&title=test&source=&color=&titleImage=&priority=&fileAddr=&fileName=',''),('1445250240497','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>test<br/></p>&channelId=1445130394473&keyword=&sourceAddr=&size=&content=<p>test<br/></p>&author=&title=test&source=&color=&titleImage=&priority=&fileAddr=&fileName=',''),('1445250391899','access','admin','/syst/admin',NULL,'/syst/admin/document/deleteById','POST','idstring=1445250240419,1445250201825,1445250101228,1445250072114,1445249752872,1445246335614',''),('1445250404079','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>test<br/></p>&channelId=1445130394473&keyword=&sourceAddr=&size=&content=<p>test<br/></p>&author=&title=test&source=&titleImage=&color=&priority=&fileAddr=&fileName=',''),('1445306615984','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>的时候说的话说的话都是<br/></p>&channelId=1445139381638&keyword=&sourceAddr=&size=&content=<p>的时候说的话说的话都是<br/></p>&author=test&title=test&source=&color=&titleImage=&priority=&fileAddr=&fileName=',''),('1445309513544','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445250404016','POST','editorValue=<p>testfdgd<br/></p>&channelId=1445130394473&keyword=&sourceAddr=&size=&content=<p>testfdgd<br/></p>&id=1445250404016&author=yrdy&title=test&source=&color=&titleImage=&priority=&fileAddr=&fileName=',''),('1445311648453','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445139381638',''),('1445311813384','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=体育&parentId=&linkAddr=&name=体育&keyword=sports,体育&code=sports&openMode=true',''),('1445312220776','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=娱乐，entertainment&parentId=&linkAddr=&name=娱乐&keyword=娱乐，entertainment&code=entertainment&openMode=true',''),('1445322326622','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=科技,tech&parentId=&linkAddr=&name=科技&keyword=科技,tech&code=tech&openMode=true',''),('1445322448238','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=图集，picture&parentId=&linkAddr=&name=图集&keyword=图集，picture&code=picture&openMode=true',''),('1445322475673','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=video，视频&parentId=&linkAddr=&name=视频&keyword=video，视频&code=video&openMode=true',''),('1445322552825','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=product，产品&parentId=&linkAddr=&name=产品&keyword=product，产品&code=product&openMode=true',''),('1445322582071','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=download，下载&parentId=&linkAddr=&name=下载&keyword=download，下载&code=download&openMode=true',''),('1445323572017','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=doc，文库&parentId=&linkAddr=&name=文库&keyword=doc，文库&code=doc&openMode=true',''),('1445323609582','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=notice，网站公告&parentId=&linkAddr=&name=网站公告&keyword=notice，网站公告&code=notice&openMode=true',''),('1445323635460','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=position，诚聘英才&parentId=&linkAddr=&name=诚聘英才&keyword=position，诚聘英才&code=position&openMode=true',''),('1445502180613','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=<p>test</p>&author=test&editorValue=<p>test</p>&title=test&source=&titleImage=&color=&channelId=1445130394473&priority=&keyword=test&sourceAddr=',''),('1445506205169','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=society,&parentId=1445130394473&linkAddr=&name=社会&keyword=society,社会&code=society&openMode=true',''),('1445567200858','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=true&label=是&type=hidden',''),('1445567211571','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=false&label=否&type=hidden',''),('1445573148346','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=<p>123</p>&author=123&editorValue=<p>123</p>&title=123&source=&titleImage=&color=&channelId=1445506204924&priority=&keyword=&sourceAddr=',''),('1445573235349','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=international,国际&parentId=1445130394473&linkAddr=&name=国际&keyword=international,国际&code=international&openMode=false',''),('1445573294906','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','content=<p>英国派军舰赴地中海演习 西班牙称是恐吓行为</p>&author=123&editorValue=<p>英国派军舰赴地中海演习 西班牙称是恐吓行为</p>&title=英国派军舰赴地中海演习 西班牙称是恐吓行为&source=&titleImage=&color=&channelId=1445573235198&priority=&keyword=&sourceAddr=',''),('1445589799282','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445573294870','POST','editorValue=<p><span style=\"font-family: Verdana, Arial, Tahoma; font-size: 12px; background-color: rgb(255, 255&channelId=1445573235198&keyword=&sourceAddr=&size=&content=<p><span style=\"font-family: Verdana, Arial, Tahoma; font-size: 12px; background-color: rgb(255, 255&id=1445573294870&author=123&title=英国派军舰赴地中海演习 西班牙称是恐吓行为&source=&color=&titleImage=&priority=&fileAddr=&fileName=',''),('1445590069906','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445573294870','POST','editorValue=<p><span style=\"font-family: Verdana, Arial, Tahoma; font-size: 12px; background-color: rgb(255, 255&channelId=1445573235198&keyword=&sourceAddr=&size=&id=1445573294870&author=123&title=英国派军舰赴地中海演习 西班牙称是恐吓行为&source=&color=&titleImage=&priority=&fileAddr=&fileName=',''),('1445590572058','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445573294870','POST','editorValue=<p><span style=\"font-family: Verdana, Arial, Tahoma; font-size: 12px; background-color: rgb(255, 255&channelId=1445573235198&keyword=&sourceAddr=&size=&content=<p><span style=\"font-family: Verdana, Arial, Tahoma; font-size: 12px; background-color: rgb(255, 255&id=1445573294870&author=123&title=英国派军舰赴地中海演习 西班牙称是恐吓行为&source=&color=&titleImage=&priority=&fileAddr=&fileName=',''),('1445591560673','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445573294870','POST','editorValue=<p>腾讯财经讯 北京10月23日下午消息 据日本共同网文章，访日外国游客人数和消费额正在不断刷新历史纪录，今年1至9月分别达1448万人和25,967亿日元（约合人民币1368亿元），超过了去年全年&channelId=1445573235198&keyword=&sourceAddr=&size=&id=1445573294870&content=<p>腾讯财经讯 北京10月23日下午消息 据日本共同网文章，访日外国游客人数和消费额正在不断刷新历史纪录，今年1至9月分别达1448万人和25,967亿日元（约合人民币1368亿元），超过了去年全年&author=123&title=中国游客持续火爆 日媒：警惕过度依赖中国&source=&color=&titleImage=&priority=&fileAddr=&fileName=',''),('1445672557092','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=1445311813162&linkAddr=sports/sdfsdf&name=&keyword=&code=sdfsdf&openMode=true',''),('1445672570275','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445672555584',''),('1445672614253','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=篮球sports/basketball&parentId=1445311813162&linkAddr=sports/basketball&name=篮球&keyword=篮球,sports/basketball&code=basketball&openMode=true',''),('1445672877474','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445130394473','POST','id=1445130394473&descrition=新闻&parentId=&linkAddr=news&name=新闻&keyword=新闻，news&code=news&openMode=false',''),('1445672953081','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445506204924','POST','id=1445506204924&descrition=society,&parentId=1445130394473&linkAddr=news/society&name=社会&keyword=society,社会&code=society&openMode=true',''),('1445673027542','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445573235198','POST','id=1445573235198&descrition=international,国际&parentId=1445130394473&linkAddr=news/international&name=国际&keyword=international,国际&code=international&openMode=false',''),('1445673404283','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445311813162','POST','id=1445311813162&descrition=体育&parentId=&linkAddr=sports&name=体育&keyword=sports,体育&code=sports&openMode=true',''),('1445673528622','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445312220733','POST','id=1445312220733&descrition=娱乐，entertainment&parentId=&linkAddr=entertainment&name=娱乐&keyword=娱乐，entertainment&code=entertainment&openMode=true',''),('1445673647872','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445322325956','POST','id=1445322325956&descrition=科技,tech&parentId=&linkAddr=tech&name=科技&keyword=科技,tech&code=tech&openMode=true',''),('1445673674307','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445322448152','POST','id=1445322448152&descrition=图集，picture&parentId=&linkAddr=picture&name=图集&keyword=图集，picture&code=picture&openMode=true',''),('1445673687411','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445322475610','POST','id=1445322475610&descrition=video，视频&parentId=&linkAddr=video&name=视频&keyword=video，视频&code=video&openMode=true',''),('1445673701949','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445322552743','POST','id=1445322552743&descrition=product，产品&parentId=&linkAddr=product&name=产品&keyword=product，产品&code=product&openMode=true',''),('1445673718112','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445322582001','POST','id=1445322582001&descrition=download，下载&parentId=&linkAddr=download&name=下载&keyword=download，下载&code=download&openMode=true',''),('1445673730813','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445323571971','POST','id=1445323571971&descrition=doc，文库&parentId=&linkAddr=doc&name=文库&keyword=doc，文库&code=doc&openMode=true',''),('1445673745577','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445323609464','POST','id=1445323609464&descrition=notice，网站公告&parentId=&linkAddr=notice&name=网站公告&keyword=notice，网站公告&code=notice&openMode=true',''),('1445673765566','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445323635367','POST','id=1445323635367&descrition=position，诚聘英才&parentId=&linkAddr=position&name=诚聘英才&keyword=position，诚聘英才&code=position&openMode=true',''),('1445740435156','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=false&label=true&type=asdocument',''),('1445740454680','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/create','POST','value=false&label=否&type=asdocument',''),('1445740478911','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/update/1445740433805','POST','id=1445740433805&value=false&label=是&type=asdocument',''),('1445740575737','access','admin','/syst/admin',NULL,'/syst/admin/dictionary/update/1445740433805','POST','id=1445740433805&value=true&label=是&type=asdocument',''),('1445741407519','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445506204924','POST','id=1445506204924&descrition=society,&parentId=1445130394473&linkAddr=news/society&hidden=false&name=社会&keyword=society,社会&code=society&channelTemplete=&openMode=false&asdocument=false',''),('1445823925396','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=关于我们，aboutus&parentId=&linkAddr=aboutus&hidden=true&name=关于我们&keyword=关于我们，aboutus&code=aboutus&channelTemplete=default/test.jsp&openMode=false&asdocument=true',''),('1445824762514','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445823924985','POST','id=1445823924985&descrition=关于我们，aboutus&parentId=&linkAddr=aboutus&hidden=true&name=关于我们&keyword=关于我们，aboutus&code=aboutus&channelTemplete=default/test.jsp&openMode=false&asdocument=true',''),('1445826571690','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<h1 style=\"margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rgb(51, 51, 51); font-s&channelId=1445823924985&keyword=&documentTemplete=default/test.jsp&sourceAddr=&content=<h1 style=\"margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rgb(51, 51, 51); font-s&author=&title=关于我们&source=&color=&titleImage=&hidden=true&priority=',''),('1445829887884','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445823924985','POST','id=1445823924985&descrition=关于我们，aboutus&parentId=&linkAddr=aboutus&hidden=true&name=关于我们&keyword=关于我们，aboutus&code=aboutus&channelTemplete=default/test&openMode=false&asdocument=true',''),('1445830274478','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445826571527','POST','editorValue=<h1 style=\"margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rgb(51, 51, 51); font-s&channelId=1445823924985&documentTemplete=default/test&keyword=&sourceAddr=&size=&id=1445826571527&content=<h1 style=\"margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rgb(51, 51, 51); font-s&author=&title=关于我们&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445832244499','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445826571527','POST','editorValue=<h1 style=\"margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rgb(51, 51, 51); font-s&channelId=1445823924985&documentTemplete=default/test&keyword=&sourceAddr=&size=&id=1445826571527&content=<h1 style=\"margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rgb(51, 51, 51); font-s&author=&title=公司简介&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445832556633','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<h1 style=\"white-space: normal; margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rg&channelId=1445823924985&keyword=发展历程&documentTemplete=&sourceAddr=&content=<h1 style=\"white-space: normal; margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rg&author=&title=发展历程&source=&color=&titleImage=&hidden=true&priority=',''),('1445842678345','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=dsfsdf&parentId=1445823924985&linkAddr=aboutus/qiyewenhua&hidden=false&name=企业文化&keyword=企业文化,qiyewenhua&code=qiyewenhua&openMode=false&asdocument=true&documentId=',''),('1445842761024','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445842677582',''),('1445842816896','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=1445823924985&linkAddr=aboutus/qiyewenhua&hidden=false&name=企业文化&keyword=&code=qiyewenhua&openMode=false&asdocument=true&documentId=1445832556483',''),('1445843145227','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=1445823924985&linkAddr=aboutus/quarlitySystem&hidden=false&name=质量体系&keyword=&code=quarlitySystem&openMode=false&asdocument=true&documentId=1445832556483',''),('1445843356238','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445843145145',''),('1445844279362','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=发展历程,history&parentId=1445823924985&linkAddr=aboutus/history&hidden=false&name=发展历程&keyword=发展历程,history&code=history&openMode=false&asdocument=true&documentId=1445832556483',''),('1445844789708','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445844279063','POST','id=1445844279063&descrition=发展历程,history&parentId=1445823924985&linkAddr=aboutus/history&hidden=false&name=发展历程&keyword=发展历程,history&code=history&channelTemplete=&openMode=false&asdocument=true',''),('1445846106656','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445832556483','POST','editorValue=<h1 style=\"white-space: normal; margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rg&channelId=1445823924985&documentTemplete=default/test&keyword=发展历程&sourceAddr=&size=&id=1445832556483&content=<h1 style=\"white-space: normal; margin: 15px 35px; padding: 0px 0px 15px; font-size: 18px; color: rg&author=&title=发展历程&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445846786079','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445823924985','POST','id=1445823924985&descrition=关于我们，aboutus&parentId=&linkAddr=aboutus&hidden=true&name=关于我们&keyword=关于我们，aboutus&code=aboutus&openMode=false&asdocument=true',''),('1445846932758','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445823924985','POST','id=1445823924985&descrition=关于我们，aboutus&parentId=&linkAddr=aboutus&hidden=true&name=关于我们&keyword=关于我们，aboutus&code=aboutus&openMode=false&asdocument=true',''),('1445847054095','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445823924985','POST','id=1445823924985&descrition=关于我们，aboutus&parentId=&linkAddr=aboutus&hidden=true&name=关于我们&keyword=关于我们，aboutus&code=aboutus&channelTemplete=&openMode=false&asdocument=true',''),('1445847307130','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445823924985','POST','id=1445823924985&descrition=关于我们，aboutus&parentId=&linkAddr=aboutus&hidden=true&name=关于我们&keyword=关于我们，aboutus&code=aboutus&channelTemplete=&openMode=false&asdocument=true&documentId=1445826571527',''),('1445932612080','access','admin','/syst/admin',NULL,'/syst/admin/log/deleteById','POST','idstring=1445853807130,1445852169204,1445852116529',''),('1445933542372','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445130394473,1445506204924,1445573235198,1445311813162,1445672614195,1445312220733,1445322325956,14',''),('1445933614803','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=&linkAddr=/&hidden=false&name=公司主页&keyword=公司主页，网聚&code=/&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445933697755','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=&linkAddr=aboutus&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=aboutus&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445933756152','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=1445933697685&linkAddr=aboutus/organization&hidden=false&name=组织架构&keyword=组织架构&code=organization&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445933793481','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=1445933697685&linkAddr=aboutus/history&hidden=false&name=公司历史&keyword=公司历史&code=history&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445933824337','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=contact&parentId=1445933697685&linkAddr=aboutus/contact&hidden=false&name=联系我们&keyword=联系我们&code=contact&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445933911063','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=product产品展示&parentId=&linkAddr=product&hidden=false&name=产品展示&keyword=产品展示&code=product&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445934192770','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=医药原料及中间体&parentId=1445933910969&linkAddr=product/yyyljzhjt&hidden=false&name=医药原料及中间体&keyword=医药原料及中间体&code=yyyljzhjt&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445934220843','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=无机化工产品&parentId=1445933910969&linkAddr=product/wjhgchp&hidden=false&name=无机化工产品&keyword=无机化工产品&code=wjhgchp&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445934282778','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=香精香料及植物提取物&parentId=1445933910969&linkAddr=product/xjxljzhwtqw&hidden=false&name=香精香料及植物提取物&keyword=香精香料及植物提取物&code=xjxljzhwtqw&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445934363192','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=新闻中心&parentId=&linkAddr=news&hidden=false&name=新闻中心&keyword=新闻中心&code=news&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445934469054','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=招聘信息,jobs&parentId=&linkAddr=jobs&hidden=false&name=招聘信息&keyword=招聘信息,jobs&code=jobs&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445940555174','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204);&channelId=1445933697685&keyword=&documentTemplete=&sourceAddr=&content=<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204);&author=&title=公司简介&source=&color=&titleImage=&hidden=true&priority=',''),('1445940588755','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933697685','POST','id=1445933697685&descrition=&parentId=&linkAddr=aboutus&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=aboutus&openMode=false&asdocument=true&documentId=1445940554062',''),('1445941023750','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445940554062','POST','editorValue=<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204);&channelId=1445933697685&documentTemplete=WEB-INF//default/single&keyword=&sourceAddr=&size=&id=1445940554062&content=<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204);&author=&title=公司简介&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445941122676','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933697685','POST','id=1445933697685&descrition=&parentId=&linkAddr=aboutus&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=aboutus&channelTemplete=&openMode=false&asdocument=true&documentId=1445940554062',''),('1445941188235','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445940554062','POST','editorValue=<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204);&channelId=1445933697685&documentTemplete=default/single&keyword=&sourceAddr=&size=&id=1445940554062&content=<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204);&author=&title=公司简介&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445941803721','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445940554062','POST','editorValue=<p style=\"white-space: normal;\">&nbsp; 新开普电子股份有限公司2000年成立于郑州高新技术产业开发区，注册资本28544万元。公司专业致力于开发以智能卡及RFID&channelId=1445933697685&documentTemplete=default/single&keyword=&sourceAddr=&size=&id=1445940554062&content=<p style=\"white-space: normal;\">&nbsp; 新开普电子股份有限公司2000年成立于郑州高新技术产业开发区，注册资本28544万元。公司专业致力于开发以智能卡及RFID&author=&title=公司简介&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445941847365','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445940554062','POST','editorValue=<p style=\"white-space: normal;\"><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;新开普电子股份有限公司20&channelId=1445933697685&documentTemplete=default/single&keyword=&sourceAddr=&size=&id=1445940554062&content=<p style=\"white-space: normal;\"><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;新开普电子股份有限公司20&author=&title=公司简介&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445944238969','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; c&channelId=&keyword=&documentTemplete=default/single&sourceAddr=&content=<p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; c&author=&title=公司历史&source=&color=&titleImage=&hidden=true&priority=',''),('1445944340703','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; c&channelId=1445933793433&keyword=&documentTemplete=default/single&sourceAddr=&content=<p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; c&author=&title=公司历史&source=&color=&titleImage=&hidden=true&priority=',''),('1445944375088','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933793433','POST','id=1445933793433&descrition=&parentId=1445933697685&linkAddr=aboutus/history&hidden=false&name=公司历史&keyword=公司历史&code=history&openMode=false&asdocument=true&documentId=1445944340585',''),('1445947810766','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica&channelId=1445933824290&keyword=&documentTemplete=default/single&sourceAddr=&content=<p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica&author=&title=联系我们&source=&color=&titleImage=&hidden=true&priority=',''),('1445947842295','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933824290','POST','descrition=contact&keyword=联系我们&code=contact&id=1445933824290&parentId=1445933697685&linkAddr=aboutus/contact&hidden=false&name=联系我们&openMode=false&asdocument=true&documentId=1445947810718',''),('1445947886011','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445947810718','POST','editorValue=<p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica&channelId=1445933824290&documentTemplete=default/single&keyword=&sourceAddr=&size=&id=1445947810718&content=<p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica&author=&title=联系我们&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445948172030','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445934363146','POST','descrition=新闻中心&keyword=新闻中心&code=news&id=1445934363146&parentId=&linkAddr=news&hidden=false&name=新闻中心&channelTemplete=default/news&openMode=false&asdocument=false&documentId=',''),('1445948748159','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&channelId=1445934363146&keyword=&documentTemplete=&sourceAddr=&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&author=&title=江苏化工企业接受环境风险全面排查&source=&color=&titleImage=&hidden=true&priority=',''),('1445948753346','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&channelId=1445934363146&keyword=&documentTemplete=&sourceAddr=&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&author=&title=江苏化工企业接受环境风险全面排查&source=&color=&titleImage=&hidden=true&priority=',''),('1445948756562','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&channelId=1445934363146&keyword=&documentTemplete=&sourceAddr=&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&author=&title=江苏化工企业接受环境风险全面排查&source=&color=&titleImage=&hidden=true&priority=',''),('1445948760119','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&channelId=1445934363146&keyword=&documentTemplete=&sourceAddr=&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&author=&title=江苏化工企业接受环境风险全面排查&source=&color=&titleImage=&hidden=true&priority=',''),('1445953109624','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445948759983','POST','editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&channelId=1445934363146&documentTemplete=default/newsInfo&keyword=&sourceAddr=&size=&id=1445948759983&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&author=&title=江苏化工企业接受环境风险全面排查&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445953590061','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445948756494','POST','editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&channelId=1445934363146&documentTemplete=default/newsInfo&keyword=&sourceAddr=&size=&id=1445948756494&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&author=&title=江苏化工企业接受环境风险全面排查&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445953599612','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445948753286','POST','editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&channelId=1445934363146&documentTemplete=default/newsInfo&keyword=&sourceAddr=&size=&id=1445948753286&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&author=&title=江苏化工企业接受环境风险全面排查&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445953610225','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445948748061','POST','editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&channelId=1445934363146&documentTemplete=default/newsInfo&keyword=&sourceAddr=&size=&id=1445948748061&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&author=&title=江苏化工企业接受环境风险全面排查&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1445955237243','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933697685','POST','id=1445933697685&descrition=&parentId=&linkAddr=channel/aboutus&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=aboutus&channelTemplete=&openMode=false&asdocument=true&documentId=1445940554062',''),('1445955269165','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933756067','POST','id=1445933756067&descrition=&parentId=1445933697685&linkAddr=channel/aboutus/organization&hidden=false&name=组织架构&keyword=组织架构&code=organization&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1445955283881','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933793433','POST','id=1445933793433&descrition=&parentId=1445933697685&linkAddr=channel/aboutus/history&hidden=false&name=公司历史&keyword=公司历史&code=history&channelTemplete=&openMode=false&asdocument=true&documentId=1445944340585',''),('1445955301385','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933824290','POST','id=1445933824290&descrition=contact&parentId=1445933697685&linkAddr=channel/aboutus/contact&hidden=false&name=联系我们&keyword=联系我们&code=contact&channelTemplete=&openMode=false&asdocument=true&documentId=1445947810718',''),('1445955314967','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445934363146','POST','id=1445934363146&descrition=新闻中心&parentId=&linkAddr=channel/news&hidden=false&name=新闻中心&keyword=新闻中心&code=news&channelTemplete=default/news&openMode=false&asdocument=false&documentId=',''),('1446003030012','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933697685','POST','id=1445933697685&descrition=&parentId=&linkAddr=aboutus&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=aboutus&channelTemplete=&openMode=false&asdocument=true&documentId=1445940554062',''),('1446003041908','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933756067','POST','id=1445933756067&descrition=&parentId=1445933697685&linkAddr=aboutus/organization&hidden=false&name=组织架构&keyword=组织架构&code=organization&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446003056076','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933793433','POST','id=1445933793433&descrition=&parentId=1445933697685&linkAddr=aboutus/history&hidden=false&name=公司历史&keyword=公司历史&code=history&channelTemplete=&openMode=false&asdocument=true&documentId=1445944340585',''),('1446003069473','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933824290','POST','id=1445933824290&descrition=contact&parentId=1445933697685&linkAddr=aboutus/contact&hidden=false&name=联系我们&keyword=联系我们&code=contact&channelTemplete=&openMode=false&asdocument=true&documentId=1445947810718',''),('1446003087149','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933614530','POST','id=1445933614530&descrition=&parentId=&linkAddr=&hidden=false&name=公司主页&keyword=公司主页，网聚&code=/&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446032319136','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933697685','POST','id=1445933697685&descrition=&parentId=&linkAddr=aboutes&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=about&channelTemplete=&openMode=false&asdocument=true&documentId=1445940554062',''),('1446032369984','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933756067','POST','id=1445933756067&descrition=&parentId=1445933697685&linkAddr=aboutes/organizationes&hidden=false&name=组织架构&keyword=组织架构&code=organizationes&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446032499158','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933793433','POST','id=1445933793433&descrition=&parentId=1445933697685&linkAddr=aboutes/historyes&hidden=false&name=公司历史&keyword=公司历史&code=historyes&channelTemplete=&openMode=false&asdocument=true&documentId=1445944340585',''),('1446084590226','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445948759983','POST','editorValue=<p>ewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfw&channelId=1445934363146&documentTemplete=default/newsInfo&keyword=&sourceAddr=&size=&id=1445948759983&content=<p>ewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfw&author=&title=江苏化工企业接受环境风险全面排查&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1446084670061','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933697685','POST','id=1445933697685&descrition=&parentId=&linkAddr=aboutus&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=aboutus&channelTemplete=&openMode=false&asdocument=true&documentId=1445940554062',''),('1446084790743','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933756067','POST','id=1445933756067&descrition=&parentId=1445933697685&linkAddr=aboutus/organization&hidden=false&name=组织架构&keyword=组织架构&code=organization&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446084825096','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933793433','POST','id=1445933793433&descrition=&parentId=1445933697685&linkAddr=aboutus/history&hidden=false&name=公司历史&keyword=公司历史&code=history&channelTemplete=&openMode=false&asdocument=true&documentId=1445944340585',''),('1446166812467','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=1445934468960&linkAddr=jobs/techdep&hidden=false&name=技术部招聘信息&keyword=&code=techdep&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446166851937','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=1446166812093&linkAddr=techdep/javadep&hidden=false&name=技术部java招聘信息&keyword=&code=javadep&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446173864340','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933697685','POST','id=1445933697685&descrition=&parentId=&linkAddr=channel/aboutus&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=aboutus&channelTemplete=&openMode=false&asdocument=true&documentId=1445940554062',''),('1446173876389','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933756067','POST','id=1445933756067&descrition=&parentId=1445933697685&linkAddr=channel/aboutus/organization&hidden=false&name=组织架构&keyword=组织架构&code=organization&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446173886708','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933793433','POST','id=1445933793433&descrition=&parentId=1445933697685&linkAddr=channel/aboutus/history&hidden=false&name=公司历史&keyword=公司历史&code=history&channelTemplete=&openMode=false&asdocument=true&documentId=1445944340585',''),('1446173901364','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933824290','POST','id=1445933824290&descrition=contact&parentId=1445933697685&linkAddr=channel/aboutus/contact&hidden=false&name=联系我们&keyword=联系我们&code=contact&channelTemplete=&openMode=false&asdocument=true&documentId=1445947810718',''),('1446176652682','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>tetsatsetestsetsetstsetesteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee<br/></p>&channelId=1446166851818&keyword=&documentTemplete=default/newsInfo&sourceAddr=&content=<p>tetsatsetestsetsetstsetesteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee<br/></p>&author=test&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1446177611011','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=&linkAddr=channel/test&hidden=false&name=test&keyword=&code=test&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446177859872','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933910969','POST','id=1445933910969&descrition=product产品展示&parentId=&linkAddr=channel/product&hidden=false&name=产品展示&keyword=产品展示&code=product&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446177878392','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445934468960','POST','id=1445934468960&descrition=招聘信息,jobs&parentId=&linkAddr=channel/jobs&hidden=false&name=招聘信息&keyword=招聘信息,jobs&code=jobs&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446177902728','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1446166812093','POST','id=1446166812093&descrition=&parentId=1445934468960&linkAddr=channel/jobs/techdep&hidden=false&name=技术部招聘信息&keyword=&code=techdep&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446177934414','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1446166851827','POST','id=1446166851827&descrition=&parentId=1446166812093&linkAddr=channel/jobs/techdep/javadep&hidden=false&name=技术部java招聘信息&keyword=&code=javadep&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446193427112','access','admin','/syst/admin',NULL,'/syst/admin/user/update/1444658591291','POST','id=1444658591291&username=123&organizationId=1444636560192&password=&roleId=2',''),('1446197461400','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1445075702637&name=文章评论&authName=comment:*&path=/comment&type=menu',''),('1446204386419','access','admin','/syst/admin',NULL,'/syst/admin/resource/deleteById','POST','idstring=1446197461142',''),('1446339789178','access','admin','/syst/admin',NULL,'/syst/admin/log/deleteById','POST','idstring=1446339648303',''),('1446339793589','access','admin','/syst/admin',NULL,'/syst/admin/log/deleteById','POST','idstring=1446207161179',''),('1446344033636','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445940554062','POST','id=1445940554062&channelId=1445933697685&title=公司简介&author=&color=&keyword=&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p style=\"white-space: normal;\"><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;新开普电子股份有限公司20&documentTemplete=defaultApp/single&file=&fileAddr=&size=&editorValue=<p style=\"white-space: normal;\"><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;新开普电子股份有限公司20',''),('1446344052573','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445947810718','POST','id=1445947810718&channelId=1445933824290&title=联系我们&author=&color=&keyword=&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica&documentTemplete=defaultApp/single&file=&fileAddr=&size=&editorValue=<p style=\"margin: 0px 10px 20px 30px; padding: 0px; line-height: 22px; font-family: Arial, Helvetica',''),('1446344070423','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445944340585','POST','id=1445944340585&channelId=1445933793433&title=公司历史&author=&color=&keyword=&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; c&documentTemplete=defaultApp/single&file=&fileAddr=&size=&editorValue=<p style=\"margin-right: 10px; margin-left: 34px; padding: 0px; line-height: 24px; font-size: 12px; c',''),('1446344115563','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445934363146','POST','id=1445934363146&documentId=&parentId=&name=新闻中心&code=news&keyword=新闻中心&linkAddr=channel/news&openMode=false&channelTemplete=defaultApp/news&hidden=false&asdocument=false&descrition=新闻中心',''),('1446344161929','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445948759983','POST','id=1445948759983&channelId=1445934363146&title=江苏化工企业接受环境风险全面排查&author=&color=&keyword=&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p>ewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfw&documentTemplete=defaultApp/newsInfo&file=&fileAddr=&size=&editorValue=<p>ewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfwefewewfewfw',''),('1446344190344','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445948756494','POST','id=1445948756494&channelId=1445934363146&title=江苏化工企业接受环境风险全面排查&author=&color=&keyword=&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&documentTemplete=defaultApp/newsInfo&file=&fileAddr=&size=&editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea',''),('1446344491026','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1445948748061','POST','id=1445948748061&channelId=1445934363146&title=江苏化工企业接受环境风险全面排查&author=&color=&keyword=&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea&documentTemplete=defaultApp/newsInfo&file=&fileAddr=&size=&editorValue=<p style=\"margin-top: 0px; padding: 0px; border: 0px; list-style: none; word-wrap: normal; word-brea',''),('1446346025349','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<img src=\"/syst/upload/1/20151101_104100.jpg\"/><img style=\"width: 24px; height: 24px;\" alt=\"\" title=&channelId=1445933697685&keyword=&documentTemplete=defaultApp/single&sourceAddr=&content=<img src=\"/syst/upload/1/20151101_104100.jpg\"/><img style=\"width: 24px; height: 24px;\" alt=\"\" title=&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1446346063531','access','admin','/syst/admin',NULL,'/syst/admin/document/deleteById','POST','idstring=1446346025111',''),('1446965150404','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1445934363146,1446166812093,1446166851818,1446166851827',''),('1446965194420','access','admin','/syst/admin',NULL,'/syst/admin/channel/create','POST','descrition=&parentId=&linkAddr=channel/news&hidden=false&name=新闻中心&keyword=&code=news&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1446965284911','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1446965194084','POST','id=1446965194084&descrition=&parentId=&linkAddr=channel/news&hidden=false&name=新闻中心&keyword=&code=news&channelTemplete=defaultApp/news&openMode=false&asdocument=false&documentId=',''),('1446965337918','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1446965194084','POST','id=1446965194084&descrition=&parentId=&linkAddr=channel/news&hidden=false&name=新闻中心&keyword=&code=news&channelTemplete=defaultApp/news&openMode=false&asdocument=false&documentId=',''),('1446965467922','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p><span style=\"font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: medium; line-height: 2&channelId=1446965194084&keyword=&documentTemplete=&sourceAddr=&content=<p><span style=\"font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: medium; line-height: 2&author=&title=6个技巧让你成为专业程序员&source=&color=&titleImage=&hidden=true&priority=',''),('1446965523916','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p><span style=\"font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: medium; line-height: 2&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p><span style=\"font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: medium; line-height: 2&author=&title=6个技巧让你成为专业程序员&source=&color=&titleImage=&hidden=true&priority=',''),('1446965831071','access','admin','/syst/admin',NULL,'/syst/admin/document/update/1446965467743','POST','editorValue=<p><span style=\"font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: medium; line-height: 2&channelId=1446965194084&documentTemplete=defaultApp/newsInfo&keyword=&sourceAddr=&size=&id=1446965467743&content=<p><span style=\"font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: medium; line-height: 2&author=&title=6个技巧让你成为专业程序员&source=&titleImage=&color=&priority=&hidden=true&fileAddr=',''),('1446965839736','access','admin','/syst/admin',NULL,'/syst/admin/document/deleteById','POST','idstring=1446207160761',''),('1446966748502','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445934468960','POST','id=1445934468960&descrition=招聘信息,jobs&parentId=&linkAddr=channel/jobs&hidden=false&name=招聘信息&keyword=招聘信息,jobs&code=jobs&channelTemplete=defaultApp/jobs&openMode=false&asdocument=false&documentId=',''),('1446967150678','access','admin','/syst/admin',NULL,'/syst/admin/channel/deleteById','POST','idstring=1446177610360',''),('1446968871970','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>这篇文章主要介绍通过java连接mysql数据库的时候，页面出现乱码，这里简单分享下解决方法， \r\n需要的朋友可以参考下</p><p><strong>解决方法一: <br/></strong><&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>这篇文章主要介绍通过java连接mysql数据库的时候，页面出现乱码，这里简单分享下解决方法， \r\n需要的朋友可以参考下</p><p><strong>解决方法一: <br/></strong><&author=&title=java连接mysql数据库乱码的解决方法&source=&color=&titleImage=&hidden=true&priority=',''),('1446968931935','access','admin','/syst/admin',NULL,'/syst/admin/document/deleteById','POST','idstring=1446968871860',''),('1447030986229','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447030989111','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447030991734','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447030994014','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447030996272','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447030998554','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447031000560','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447031002470','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447031004730','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447031006684','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447031008420','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447031010279','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=1446965194084&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447031012688','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>testtesttest</p>&channelId=&keyword=&documentTemplete=defaultApp/newsInfo&sourceAddr=&content=<p>testtesttest</p>&author=&title=test&source=&color=&titleImage=&hidden=true&priority=',''),('1447036226781','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1444631314253','POST','parentId=2&name=字典管理&authName=dictionary:*&path=/dictionary&type=menu',''),('1447039321594','access','admin','/syst/admin',NULL,'/syst/admin/document/create','POST','editorValue=<p>组织机构<br/></p>&channelId=1445933756067&keyword=&documentTemplete=defaultApp/single&sourceAddr=&content=<p>组织机构<br/></p>&author=&title=组织架构&source=&color=&titleImage=&hidden=true&priority=',''),('1447039430974','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933756067','POST','id=1445933756067&descrition=&parentId=1445933697685&linkAddr=channel/aboutus/organization&hidden=false&name=组织架构&keyword=组织架构&code=organization&openMode=false&asdocument=true&documentId=1447039321447',''),('1447052126548','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933910969','POST','id=1445933910969&descrition=product产品展示&parentId=&linkAddr=channel/products&hidden=false&name=产品展示&keyword=产品展示&code=products&channelTemplete=defaultApp/products&openMode=false&asdocument=false&documentId=',''),('1447058887726','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933614530','POST','id=1445933614530&descrition=&parentId=&linkAddr=&sort=1&hidden=false&name=公司主页&keyword=公司主页，网聚&code=/&channelTemplete=&openMode=false&asdocument=false&documentId=',''),('1447058930834','access','admin','/syst/admin',NULL,'/syst/admin/channel/update/1445933697685','POST','id=1445933697685&descrition=&parentId=&linkAddr=channel/aboutus&sort=2&hidden=false&name=关于我们&keyword=公司主页，关于我们&code=aboutus&channelTemplete=&openMode=false&asdocument=true&documentId=1445940554062',''),('1448075607184','access','superAdmin','/syst/admin',NULL,'/syst/admin/log/deleteById','POST','idstring=1448075601933,1447137521182,1447137387461,1447128034565,1447127718061,1447127487236,1447126982951,14',''),('1448077430648','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1445075669752&name=栏目添加&authName=channel:create&path=&type=button',''),('1448077453497','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1448077430572','POST','parentId=1445075669752&name=栏目新增&authName=channel:create&path=&type=menu',''),('1448077502092','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1445075669752&name=栏目修改&authName=channel:update&path=&type=button',''),('1448077536373','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1445075669752&name=栏目删除&authName=channel:delete&path=&type=menu',''),('1448077558031','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=&name=栏目查看&authName=channel:view&path=&type=button',''),('1448077570863','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1448077501999','POST','parentId=1445075669752&name=栏目修改&authName=channel:update&path=&type=button',''),('1448077588451','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1448077430572','POST','parentId=1445075669752&name=栏目新增&authName=channel:create&path=&type=button',''),('1448077602440','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1448077536293','POST','parentId=1445075669752&name=栏目删除&authName=channel:delete&path=&type=button',''),('1448077982808','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1445075702637','POST','parentId=&name=文档&authName=document:*&path=/document&type=menu',''),('1448078024242','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1445075702637&name=文档新增&authName=document:create&path=&type=button',''),('1448078045493','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1445075702637&name=文档修改&authName=document:update&path=&type=button',''),('1448078495175','access','admin','/syst/admin',NULL,'/syst/admin/resource/create','POST','parentId=1445075702637&name=文档删除&authName=document:delete&path=&type=button',''),('1448078768634','access','admin','/syst/admin',NULL,'/syst/admin/resource/update/1448077557959','POST','parentId=1445075669752&name=栏目查询&authName=channel:view&path=&type=button',''),('1448331645263','access','admin','/admin',NULL,'/admin/dbBackup/deleteById','POST','idstring=e5da6655-c78e-4653-86b1-11c90b8831f3',''),('1448682618169','access','admin','/demo/admin',NULL,'/demo/admin/document/create','POST','editorValue=<p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; tex&channelId=1446965194084&documentTemplete=doc.jsp&keyword=&sourceAddr=&recommend=true&assetsIds=&size=&content=<p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; tex&author=&title=elasticsearch ik分词插件es-ik发布了&source=&color=&titleImage=&hidden=true&priority=&fileAddr=&fileName=',''),('1448683590269','access','admin','/demo/admin',NULL,'/demo/admin/document/update/1445940554062','POST','id=1445940554062&assetsIds=&documentTemplete=doc.jsp&channelId=1445933697685&title=关于我们&author=&color=&keyword=&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; tex&fileName=&fileAddr=&size=&recommend=false&editorValue=<p style=\"border: 0px; margin-top: 0px; margin-bottom: 0px; padding: 5px 0px; line-height: 22px; tex',''),('1448802258597','access','admin','/demo/admin',NULL,'/demo/admin/channel/update/1445934468960','POST','id=1445934468960&channelTemplete=defaultApp/jobs&parentIds=&documentId=&parentId=&name=招聘信息&code=jobs&keyword=招聘信息,jobs&linkAddr=channel/jobs&openMode=false&hidden=false&asdocument=false&descrition=招聘信息,jobs&sort=5',''),('1448802265545','access','admin','/demo/admin',NULL,'/demo/admin/channel/update/1445934468960','POST','id=1445934468960&channelTemplete=defaultApp/jobs&parentIds=&documentId=&parentId=&name=招聘信息&code=jobs&keyword=招聘信息,jobs&linkAddr=channel/jobs&openMode=false&hidden=false&asdocument=false&descrition=招聘信息,jobs&sort=5',''),('1448808012409','access','admin','/demo/admin',NULL,'/demo/admin/channel/update/1445934468960','POST','id=1445934468960&channelTemplete=defaultApp/jobs&parentIds=&documentId=&parentId=&name=招聘信息&code=jobs&keyword=招聘信息,jobs&linkAddr=channel/jobs&openMode=false&hidden=false&asdocument=false&descrition=招聘信息,jobs&sort=5',''),('1448808086369','access','admin','/demo/admin',NULL,'/demo/admin/channel/update/1445934468960','POST','id=1445934468960&channelTemplete=defaultApp/jobs&parentIds=&documentId=&parentId=&name=招聘信息&code=jobs&keyword=招聘信息,jobs&linkAddr=channel/jobs&openMode=false&hidden=false&asdocument=false&descrition=招聘信息,jobs&sort=5',''),('1448808398744','access','admin','/demo/admin',NULL,'/demo/admin/channel/update/1445934468960','POST','id=1445934468960&channelTemplete=&parentIds=&documentId=&parentId=&name=招聘信息&code=jobs&keyword=招聘信息,jobs&linkAddr=channel/jobs&openMode=false&hidden=false&asdocument=false&descrition=招聘信息,jobs&sort=5',''),('1448842462178','access','admin','/demo/admin',NULL,'/demo/admin/channel/create','POST','channelTemplete=&documentId=&parentIds=1445934468960&parentId=1445934468960&name=市场部招聘&code=market&keyword=&linkAddr=channel/jobs/market&openMode=false&hidden=false&asdocument=false&descrition=&sort=',''),('1448842587872','access','admin','/demo/admin',NULL,'/demo/admin/document/create','POST','editorValue=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">spring初始化的bean,能够修改属性,并让修改后的bean能立即被其&channelId=1448842462004&documentTemplete=&keyword=&sourceAddr=&recommend=false&assetsIds=&size=&content=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">spring初始化的bean,能够修改属性,并让修改后的bean能立即被其&author=&title=市场调研员&source=&color=&titleImage=&hidden=true&priority=&fileAddr=&fileName=',''),('1448843009959','access','admin','/demo/admin',NULL,'/demo/admin/document/update/1448842587443','POST','id=1448842587443&assetsIds=&documentTemplete=doc.jsp&channelId=1448842462004&title=市场调研员&author=&color=&keyword=&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">spring初始化的bean,能够修改属性,并让修改后的bean能立即被其&fileName=&fileAddr=&size=&recommend=false&editorValue=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">spring初始化的bean,能够修改属性,并让修改后的bean能立即被其',''),('1448843740679','access','admin','/demo/admin',NULL,'/demo/admin/channel/create','POST','channelTemplete=&documentId=&parentIds=1448842462004&parentId=1448842462004&name=华南区市场调研员&code=southmarket&keyword=&linkAddr=channel/jobs/market/southmarket&openMode=false&hidden=false&asdocument=false&descrition=&sort=',''),('1448851374960','access','admin','/demo/admin',NULL,'/demo/admin/document/create','POST','editorValue=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">官网地址:http://commons.apache.org/proper&channelId=1448843740500&documentTemplete=&keyword=&sourceAddr=&recommend=false&assetsIds=&size=&content=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">官网地址:http://commons.apache.org/proper&author=&title=华南调研员&source=&color=&titleImage=&hidden=true&priority=&fileAddr=&fileName=',''),('1448851821240','access','admin','/demo/admin',NULL,'/demo/admin/document/deleteById','POST','idstring=1448842587443',''),('1448852934187','access','admin','/demo/admin',NULL,'/demo/admin/channel/deleteById','POST','idstring=1445933614530',''),('1448866299301','access','admin','/demo/admin',NULL,'/demo/admin/document/create','POST','editorValue=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">server.slaves里维护所有的slave列表，slave.repl&channelId=1448843740500&documentTemplete=&keyword=华南区采购员&sourceAddr=&recommend=false&assetsIds=&size=&content=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">server.slaves里维护所有的slave列表，slave.repl&author=华南区采购员&title=华南区采购员&source=&color=&titleImage=&hidden=true&priority=&fileAddr=&fileName=',''),('1448867836259','access','admin','/demo/admin',NULL,'/demo/admin/document/update/1448866298907','POST','id=1448866298907&contentShort=server.slaves里维护所有的slave列表，slave.replstate里记录着每个slave当前的同步状态.1.当master接受到slave发来的sync/psync命令时，将该sla&assetsIds=&documentTemplete=&channelId=1448843740500&title=华南区采购员&author=华南区采购员&color=&keyword=华南区采购员&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">server.slaves里维护所有的slave列表，slave.repl&fileName=&fileAddr=&size=&recommend=false&editorValue=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">server.slaves里维护所有的slave列表，slave.repl',''),('1448868080326','access','admin','/demo/admin',NULL,'/demo/admin/document/update/1448866298907','POST','id=1448866298907&contentShort=server.slaves里维护所有的slave列表，slave.replstate里记录着每个slave当前的同步状态.1.当master接受到slave发来的sync/psync命令时，将该sla&assetsIds=&documentTemplete=&channelId=1448843740500&title=master状态变迁&author=华南区采购员&color=&keyword=华南区采购员&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">server.slaves里维护所有的slave列表，slave.repl&fileName=&fileAddr=&size=&recommend=false&editorValue=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">server.slaves里维护所有的slave列表，slave.repl',''),('1448868235542','access','admin','/demo/admin',NULL,'/demo/admin/document/update/1448851374598','POST','id=1448851374598&contentShort=官网地址:http://commons.apache.org/proper/commons-dbcp/configuration.htmlinitialSize：默认0,初始化连接:连接池启动时创建的&assetsIds=&documentTemplete=&channelId=1448843740500&title=整个集群fgc严重，导致无法为用户提供服务&author=华南调研员&color=&keyword=华南调研&hidden=true&priority=&source=&sourceAddr=&titleImage=&content=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">官网地址:http://commons.apache.org/proper&fileName=&fileAddr=&size=&recommend=false&editorValue=<p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">官网地址:http://commons.apache.org/proper',''),('1448871781289','access','admin','/demo/admin',NULL,'/demo/admin/channel/update/1448842462004','POST','id=1448842462004&channelTemplete=&parentIds=1445934468960&documentId=&parentId=1445934468960&name=市场部招聘&code=market&keyword=&linkAddr=channel/jobs/market&openMode=false&hidden=false&asdocument=false&descrition=&sort=',''),('1448872233747','access','admin','/demo/admin',NULL,'/demo/admin/channel/update/1448842462004','POST','id=1448842462004&channelTemplete=&parentIds=,1445934468960&documentId=&parentId=1445934468960&name=市场部招聘&code=market&keyword=&linkAddr=channel/jobs/market&openMode=false&hidden=false&asdocument=false&descrition=市场部招聘&sort=',''),('1448872345707','access','admin','/demo/admin',NULL,'/demo/admin/channel/update/1448843740500','POST','id=1448843740500&channelTemplete=&parentIds=,1445934468960,1448842462004&documentId=&parentId=1448842462004&name=华南区市场调研员&code=southmarket&keyword=&linkAddr=channel/jobs/market/southmarket&openMode=false&hidden=false&asdocument=false&descrition=&sort=',''),('1448876309080','access','admin','/demo/admin',NULL,'/demo/admin/channel/create','POST','channelTemplete=&documentId=&parentIds=1446965194084&linkAddrZh=&parentId=1446965194084&name=国际新闻&code=internalnews&keyword=国际新闻&linkAddr=channel/news/internalnews&openMode=false&hidden=false&asdocument=false&descrition=&sort=',''),('1448876769103','access','admin','/demo/admin',NULL,'/demo/admin/channel/create','POST','channelTemplete=&documentId=&parentIds=1446965194084&linkAddrZh=&parentId=1446965194084&name=国内新闻&code=innernews&keyword=innernews&linkAddr=channel/news/innernews&openMode=false&hidden=false&asdocument=false&descrition=innernews&sort=',''),('1448877803635','access','admin','/demo/admin',NULL,'/demo/admin/channel/create','POST','channelTemplete=&documentId=&parentIds=1446965194084,1448876768973&linkAddrZh=&parentId=1448876768973&name=娱乐新闻&code=entertaiment&keyword=entertaiment&linkAddr=channel/news/innernews/entertaiment&openMode=false&hidden=false&asdocument=false&descrition=entertaiment&sort=','');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_qunhu_info`
--

LOCK TABLES `t_qunhu_info` WRITE;
/*!40000 ALTER TABLE `t_qunhu_info` DISABLE KEYS */;
INSERT INTO `t_qunhu_info` VALUES (1,'1',NULL,NULL,NULL,NULL,NULL,NULL,1),(2,'1',NULL,NULL,NULL,NULL,NULL,NULL,2),(3,'2',NULL,NULL,NULL,NULL,NULL,NULL,1),(4,'2',NULL,NULL,NULL,NULL,NULL,NULL,2),(5,'3',NULL,NULL,NULL,NULL,NULL,NULL,1),(6,'3',NULL,NULL,NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `t_qunhu_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_assets`
--

DROP TABLE IF EXISTS `tb_assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_assets` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `path` varchar(1200) DEFAULT NULL,
  `url` varchar(120) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_assets`
--

LOCK TABLES `tb_assets` WRITE;
/*!40000 ALTER TABLE `tb_assets` DISABLE KEYS */;
INSERT INTO `tb_assets` VALUES ('1447078926018','20151109_102205.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\\\upload\\1\\20151109_102205.jpg','/upload/1/20151109_102205.jpg','2015-11-09 22:22:06',NULL,NULL),('1447083013186','20151109_113013.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\\\upload\\1\\20151109_113013.jpg','/upload/1/20151109_113013.jpg','2015-11-09 23:30:13',NULL,NULL),('1447083480982','20151109_113800.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\\\upload\\1\\20151109_113800.jpg','/upload/1/20151109_113800.jpg','2015-11-09 23:38:01',NULL,NULL),('1447083499131','20151109_113819.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\\\upload\\1\\20151109_113819.jpg','/upload/1/20151109_113819.jpg','2015-11-09 23:38:19',NULL,NULL),('1447502268742','20151114_075748.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151114_075748.jpg','/upload/1/20151114_075748.jpg','2015-11-14 19:57:49',NULL,NULL),('1447502638620','20151114_080358.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151114_080358.jpg','/upload/1/20151114_080358.jpg','2015-11-14 20:03:59',NULL,NULL),('1447502700691','20151114_080500.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151114_080500.jpg','/upload/1/20151114_080500.jpg','2015-11-14 20:05:01',NULL,NULL),('1447502727148','20151114_080527.png','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151114_080527.png','/upload/1/20151114_080527.png','2015-11-14 20:05:27',NULL,NULL),('1447634062641','20151116_083422.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151116_083422.jpg','/upload/1/20151116_083422.jpg','2015-11-16 08:34:23',NULL,NULL),('1447634224837','20151116_083704.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151116_083704.jpg','/upload/1/20151116_083704.jpg','2015-11-16 08:37:05',NULL,NULL),('1447634301705','20151116_083821.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151116_083821.jpg','/upload/1/20151116_083821.jpg','2015-11-16 08:38:22',NULL,NULL),('1447634377568','20151116_083937.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151116_083937.jpg','/upload/1/20151116_083937.jpg','2015-11-16 08:39:38',NULL,NULL),('1447639253865','20151116_100053.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151116_100053.jpg','/upload/1/20151116_100053.jpg','2015-11-16 10:00:54',NULL,NULL),('1447639355125','20151116_100235.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151116_100235.jpg','/upload/1/20151116_100235.jpg','2015-11-16 10:02:35',NULL,NULL),('1447662907538','20151116_043507.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151116_043507.jpg','/upload/1/20151116_043507.jpg','2015-11-16 16:35:08',NULL,NULL),('1447990985292','20151120_114304.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst3_module\\upload\\1\\20151120_114304.jpg','/upload/1/20151120_114304.jpg','2015-11-20 11:43:05',NULL,NULL),('1447993341525','20151120_122221.jpg','D:\\Program Files (x86)\\MyEclipse Professional\\plugins\\com.genuitec.eclipse.easie.tomcat7.myeclipse_11.0.0.me201305151620\\tomcat\\bin\\webapp\\upload\\20151120_122221.jpg','/upload/1/20151120_122221.jpg','2015-11-20 12:22:22',NULL,NULL),('1447993438811','20151120_122348.jpg','/alidata/apachapache-tomcat-7.0.65/webapps/syst/upload/20151120_122348.jpg','/upload/1/20151120_122348.jpg','2015-11-20 12:23:59',NULL,NULL),('1447995460184','20151120_125739.jpg','D:\\Program Files\\apache-tomcat-7.0.59\\webapps\\syst\\upload\\20151120_125739.jpg','/upload/1/20151120_125739.jpg','2015-11-20 12:57:40',NULL,NULL),('1447995867580','20151120_010357.jpg','D://workspace//jcincms_base//syst3_module//src//main//webapp//upload//20151120_010357.jpg','/upload/1/20151120_010357.jpg','2015-11-20 13:04:28',NULL,NULL),('1447996348316','20151120_011215.jpg','D://workspace//jcincms_base//syst3_module//src//main//webapp//upload//20151120_011215.jpg','/upload/1/20151120_011215.jpg','2015-11-20 13:12:28',NULL,NULL),('1447998572022','20151120_014931.jpg','D://workspace//.metadata//.me_tcat7//webapps//syst//upload//20151120_014931.jpg','/upload/1/20151120_014931.jpg','2015-11-20 13:49:32',NULL,NULL),('1447998802063','20151120_015310.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151120_015310.jpg','/upload/1/20151120_015310.jpg','2015-11-20 13:53:22',NULL,NULL),('1447999133900','20151120_015850.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151120_015850.jpg','/upload/1/20151120_015850.jpg','2015-11-20 13:58:54',NULL,NULL),('1447999374906','20151120_020254.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst//upload\\20151120_020254.jpg','/upload/1/20151120_020254.jpg','2015-11-20 14:02:55',NULL,NULL),('1447999562740','20151120_020602.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\20151120_020602.jpg','/upload/1/20151120_020602.jpg','2015-11-20 14:06:03',NULL,NULL),('1447999660911','20151120_020740.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151120_020740.jpg','/upload/1/20151120_020740.jpg','2015-11-20 14:07:41',NULL,NULL),('1447999837785','20151120_021037.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151120_021037.jpg','/upload/1/20151120_021037.jpg','2015-11-20 14:10:38',NULL,NULL),('1448006922435','20151120_040842.jpg','D:\\workspace\\.metadata\\.me_tcat7\\webapps\\syst\\upload\\1\\20151120_040842.jpg','/upload/1/20151120_040842.jpg','2015-11-20 16:08:42',NULL,NULL);
/*!40000 ALTER TABLE `tb_assets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_db_backup`
--

DROP TABLE IF EXISTS `tb_db_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_db_backup` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL COMMENT '名称',
  `path` varchar(120) DEFAULT NULL COMMENT '存放路径',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据库备份表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_db_backup`
--

LOCK TABLES `tb_db_backup` WRITE;
/*!40000 ALTER TABLE `tb_db_backup` DISABLE KEYS */;
INSERT INTO `tb_db_backup` VALUES ('00ea3581-b53c-44f0-82db-2784f7caf669','20151116_050901.sql','D:\\MySQl\\20151116_050901.sql','2015-11-16 17:09:09'),('1e905c3f-1767-4aec-a9ca-77f4fcd54632','20151120_120000.sql','D:\\MySQl\\20151120_120000.sql','2015-11-20 12:00:09'),('3f7ec99f-cac3-4adc-bbb5-5faf5fb9f109','20151121_120801.sql','D:\\MySQl\\20151121_120801.sql','2015-11-21 12:08:05'),('5ad31d88-6b8e-4eca-987e-2b39d999efbd','20151114_120000.sql','D:\\MySQl\\20151114_120000.sql','2015-11-14 12:00:08'),('6d65a193-5b54-4820-9d1c-f33b34b7397f','20151124_102626.sql','D:\\MySQl\\20151124_102626.sql','2015-11-24 10:26:34'),('71315119-2ed6-45e9-9817-ab8b23b7695e','20151117_120000.sql','D:\\MySQl\\20151117_120000.sql','2015-11-17 12:00:07'),('99ce74a7-5d7d-44fd-9cb4-b6ea564de1f2','20151111_113314.sql','D:\\MySQl\\20151111_113314.sql','2015-11-11 11:33:16'),('9bb2a074-dbb5-4df9-9c4b-fb4014e6651f','20151128_120000.sql','D:\\MySQl\\20151128_120000.sql','2015-11-28 12:00:09'),('a1281737-822a-42bf-a57f-511e0bcf7d51','20151111_120000.sql','D:\\MySQl\\20151111_120000.sql','2015-11-11 12:00:02'),('a46ac729-f2fd-46ff-a403-35072c969e99','20151117_021327.sql','D:\\MySQl\\20151117_021327.sql','2015-11-17 14:13:31'),('aa7742fe-53de-4f87-92be-a8bb9437d3bb','20151130_120000.sql','D:\\MySQl\\20151130_120000.sql','2015-11-30 12:00:07'),('b2384290-1fd9-4920-88f5-eacf8a77deb3','20151122_025007.sql','D:\\MySQl\\20151122_025007.sql','2015-11-22 14:50:39'),('c55350ed-49e9-4d6f-a8a0-bd555b0daff2','20151121_120000.sql','D:\\MySQl\\20151121_120000.sql','2015-11-21 12:00:05'),('e06680b4-6716-4cdb-b635-0ce2c6377772','20151112_025608.sql','D:\\MySQl\\20151112_025608.sql','2015-11-12 14:56:15'),('fa520109-d3ac-42f9-a6a4-0769b59d0c8d','20151113_120000.sql','D:\\MySQl\\20151113_120000.sql','2015-11-13 12:00:14');
/*!40000 ALTER TABLE `tb_db_backup` ENABLE KEYS */;
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
INSERT INTO `tb_dictionary` VALUES ('1444633076622','available','是','true'),('1444633285663','available','否','false'),('1444635718573','sex','男','true'),('1444635730059','sex','女','false'),('1445084486206','openMode','是','true'),('1445084504313','openMode','否','false'),('1445567200072','hidden','是','true'),('1445567211523','hidden','否','false'),('1445740433805','asdocument','是','true'),('1445740454594','asdocument','否','false'),('1447471583389','recommend','是','true'),('1447471593870','recommend','否','false');
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
INSERT INTO `tb_organization` VALUES ('1444636328008','公司',NULL,NULL,1,'2015-10-12 15:52:08',NULL),('1444636521670','财务部','1444636328008','1444636328008',1,'2015-10-12 15:55:22',NULL),('1444636560192','市场部','1444636328008','1444636328008',0,NULL,'2015-10-15 14:52:00'),('1444636575952','研发部','1444636328008','1444636328008',1,'2015-10-12 15:56:16',NULL),('1444636666661','研发一部','1444636575952','1444636328008,1444636575952',1,'2015-10-12 15:57:47',NULL),('1444636687117','研发二部','1444636575952','1444636328008,1444636575952',1,'2015-10-12 15:58:07',NULL),('1444890482058','研发三部','1444636575952','1444636328008,1444636575952',1,'2015-10-15 14:28:02',NULL);
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
INSERT INTO `tb_organization_resource` VALUES ('0f9d93eb-11e8-4a60-b0a9-ded22fbbc250','1444636328008','2'),('12392a7c-251f-4ba9-b58e-c599cfe4bfa4','1444636328008','1444987149377'),('3ac842dd-658a-4097-ac91-78128b453972','1444636328008','14'),('3e45459a-b500-4803-b7ec-ff028d2a89fa','1444636328008','1444573378567'),('4795b80e-2d0d-42ee-8cf1-ef78a847dae6','1444636328008','15'),('5351f315-922d-4e6d-9853-171c1dee7eaf','1444636328008','1444548142152'),('66abf7f8-b73f-45c3-ab15-8a124841715a','1444636328008','7'),('6d3421f6-4769-4760-99d8-1e0ae547d6a7','1444636328008','5'),('7207372f-d4f2-41fa-afe8-6aabfb4c6d07','1444636328008','1445075669752'),('75560d18-ad7c-4052-b675-225c1ee3e6ee','1444636328008','9'),('837653a2-4795-445e-8d7c-2119e7d3719f','1444636328008','1444987225918'),('84a441d3-a794-4dd3-9f21-f5910d8f7243','1444636328008','17'),('8bd40b78-2103-48d1-a8e9-6ddd1051b51a','1444636328008','6'),('91618d1d-92a1-4d34-b63a-50b8cc79d6c5','1444636328008','16'),('9b9e3d97-fb15-4165-bd93-e5515d6550f8','1444636328008','1444631314253'),('a36a55f5-4726-41dd-a45f-27a495b0a905','1444636328008','13'),('a4443347-7ca7-444a-b7d2-0051cfba93a3','1444636328008','3'),('b052209b-fe23-47d6-8ebd-2c03cfe1abe4','1444636328008','1444459418042'),('b2ba56d4-5db6-4b2b-91fa-e0d7d0648571','1444636328008','4'),('bbb185df-a91c-4bde-9161-b3dd02320446','1444636328008','12'),('cc07ba67-2833-45ad-a5a0-57098fc0eeb6','1444636560192','1444573378567'),('d1d152b4-0e7a-46b7-9fc0-8c418dc0867a','1444636328008','1445075702637'),('d4a303a3-a4c5-49e9-b3af-7cdaf1694f76','1444636328008','1444573320799'),('d8041cc7-9bd1-42bf-a01d-6b901a9f0952','1444636328008','10'),('df33aac9-cfac-4039-abbf-cf98aac377f3','1444636328008','11'),('ee0e640d-2787-4aae-9dbf-d07d6ae12c0b','1444636328008','8'),('ff58c11c-1fcb-42c5-9b3b-cf7363880aa6','1444636560192','1444573320799');
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
INSERT INTO `tb_resource` VALUES ('10','角色管理删除','2,8','8','role:delete',NULL,'button'),('11','角色管理修改','2,8','8','role:update',NULL,'button'),('12','角色管理查询','2,8','8','role:view',NULL,'button'),('13','资源管理','2','2','resource:*','/resource','menu'),('14','资源管理新增','2,13','13','resource:create',NULL,'button'),('1444459418042','日志管理','2','2','log:*','/log','menu'),('1444548142152','组织管理','2','2','organization:*','/organization','menu'),('1444573320799','关于系统',NULL,NULL,'','','menu'),('1444573378567','产品信息','1444573320799','1444573320799','','/user/productInfo','menu'),('1444631314253','字典管理','2','2','dictionary:*','/dictionary','menu'),('1444987149377','数据库',NULL,NULL,'','','menu'),('1444987225918','数据库备份管理','1444987149377','1444987149377','dbBackup:*','/dbBackup','menu'),('1445075669752','栏目',NULL,NULL,'channel:*','/channel','menu'),('1445075702637','文档',NULL,NULL,'document:*','/document','menu'),('1448077430572','栏目新增','1445075669752','1445075669752','channel:create','','button'),('1448077501999','栏目修改','1445075669752','1445075669752','channel:update','','button'),('1448077536293','栏目删除','1445075669752','1445075669752','channel:delete','','button'),('1448077557959','栏目查询','1445075669752','1445075669752','channel:view','','button'),('1448078024172','文档新增','1445075702637','1445075702637','document:create','','button'),('1448078045387','文档修改','1445075702637','1445075702637','document:update','','button'),('1448078495058','文档删除','1445075702637','1445075702637','document:delete','','button'),('15','资源管理删除','2,13','13','resource:delete',NULL,'button'),('16','资源管理修改','2,13','13','resource:update',NULL,'button'),('17','资源管理查询','2,13','13','resource:view',NULL,'button'),('2','系统管理',NULL,NULL,NULL,NULL,'menu'),('3','用户管理','2','2','user:*','/user','menu'),('4','用户管理新增','2,3','3','user:create',NULL,'button'),('5','用户管理删除','2,3','3','user:delete',NULL,'button'),('6','用户管理修改','2,3','3','user:update',NULL,'button'),('7','用户管理查询','2,3','3','user:view',NULL,'button'),('8','角色管理','2','2','role:*','/role','menu'),('9','角色管理新增','2,8','8','role:create',NULL,'button');
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
INSERT INTO `tb_role` VALUES ('1','admin'),('1444806243281','test1'),('2','test');
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
INSERT INTO `tb_role_resource` VALUES ('037e0219-b03d-435f-a881-f03d0ebe5f45','1','1444987149377'),('08dc030f-e110-4696-9a43-a5d2f850a141','1','1444573320799'),('0c0af711-580c-40c3-b2b6-80a7f97b88df','1','3'),('10cc1c5d-3640-43f0-bf83-57a099873b00','2','1444573378567'),('242a3333-44dc-4d2a-8e6f-18683de83686','1','1445075669752'),('25d13b57-a5aa-4015-ad93-80818a276328','1','8'),('26f06a16-cd2b-499b-bc5a-f998561394af','1','2'),('4556d2b9-22a4-4660-a47d-7029aa3ee04c','1444806243281','17'),('4605eb8b-ea6e-4d9b-83bb-f62e0929b644','1444806243281','1444573378567'),('4a213add-1a1d-4f85-b9d6-491bec7ee97d','1','7'),('502256b8-207d-40a9-96fc-3ba93f36d43f','1','1444987225918'),('510f47c1-394a-45b3-9c8d-6163871e7687','2','1444459418042'),('630f60b0-7f69-4f4d-88a4-ec9b351f8294','1','4'),('64aac495-e2ef-4c3e-828d-374d1b67b9da','1','12'),('6654fa90-1f8b-453f-91b5-80c857b1aa3a','1','1444631314253'),('710ef466-8ad4-46f2-bdde-0392bcae5a99','1','1445075702637'),('73a3488a-ded5-4327-b173-9fb4846da8bf','1','9'),('7ca269dd-155a-4e99-8cdd-0fcd84f60198','1','1444548142152'),('816b83be-6355-4ddc-9c22-f04169cd1eee','1','1444573378567'),('8a634877-bec7-4449-8fde-87151ac60e87','1','6'),('9143a8b9-1087-4e61-b240-3dac246b5f5c','1','15'),('967712d6-34ba-4f82-9d2a-347b8ed22210','1','5'),('b3f19e5b-2fcd-4b7c-83e2-6581c60232c6','1','1444459418042'),('b4088fde-1b81-478b-acfb-c296161adaf5','2','1444573320799'),('bc2c0199-9d0c-4354-b90d-e248002ead9d','1444806243281','1444573320799'),('c6cc6d99-7a6c-4820-811d-c70beaf86bd0','1','14'),('dd7eb0e8-56db-4717-992c-7dde4c36f06e','1','13'),('e66c73f6-b7e8-438a-95c5-30fda7d72765','1','17'),('e6c55cc7-1e72-45dc-94c3-e4e9612a61ae','1','16'),('eeb6ba51-11f3-4f8d-b448-89326388df93','1','11'),('f4fa842c-9c29-40a4-9630-f5b244a8dbd0','1','10');
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
INSERT INTO `tb_user` VALUES ('1','admin','ea48576f30be1669971699c09ad05c94',NULL,NULL,'2015-11-21',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1444658591291','123','123',NULL,'2015-10-12','2015-10-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1444876158506','ewew','weew',NULL,'2015-10-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1446339647047','huangjixin','huangjixin',NULL,'2015-11-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1447323828505','黄记新','123456',NULL,'2015-11-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1448013926333','superAdmin','12478e7ad0e39aa9c35be4b9a694ba9b',NULL,'2015-11-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('2','test','test',NULL,'2015-10-04','2015-10-13',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
INSERT INTO `tb_user_organization` VALUES ('1444658593922','1444658591291','1444636560192'),('1444705754985','2','1444636560192'),('1444707160835','1','1444636521670'),('1444876158913','1444876158506','1444636328008');
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
INSERT INTO `tb_user_role` VALUES ('1','1','1'),('1444658593667','1444658591291','2'),('1444876158742','1444876158506','1'),('1446339647680','1446339647047','2'),('1447323828839','1447323828505','2'),('1448013926514','1448013926333','1'),('2','2','1');
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

-- Dump completed on 2015-11-30 20:49:33
