/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : bingya

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2014-01-23 23:28:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_article`
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` varchar(120) NOT NULL,
  `title` varchar(120) DEFAULT NULL,
  `author` varchar(120) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `tb_category_id` varchar(120) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `source` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_id` (`tb_category_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`tb_category_id`) REFERENCES `tb_category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_article
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_asset`
-- ----------------------------
DROP TABLE IF EXISTS `tb_asset`;
CREATE TABLE `tb_asset` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `path` varchar(4500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_asset
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_category`
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `parentId` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_category
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` varchar(120) NOT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `tb_article_id` varchar(120) DEFAULT NULL,
  `parentId` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbartilce` (`tb_article_id`),
  KEY `fk_tb_comment_tb_comment1` (`parentId`),
  CONSTRAINT `fk_tbartilce` FOREIGN KEY (`tb_article_id`) REFERENCES `tb_article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_comment_tb_comment1` FOREIGN KEY (`parentId`) REFERENCES `tb_comment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` varchar(120) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `path` varchar(120) DEFAULT NULL,
  `parentId` varchar(120) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_menu_menu1` (`parentId`),
  CONSTRAINT `fk_menu_menu1` FOREIGN KEY (`parentId`) REFERENCES `tb_menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '系统管理', null, null, null, null);
INSERT INTO `tb_menu` VALUES ('2', '用户管理', null, null, '1', null);
INSERT INTO `tb_menu` VALUES ('3', '菜单管理', null, null, '1', null);
INSERT INTO `tb_menu` VALUES ('4', '角色管理', null, null, '1', null);
INSERT INTO `tb_menu` VALUES ('5', 'test顶级菜单', null, null, null, null);
INSERT INTO `tb_menu` VALUES ('6', 'test顶级菜单1', null, null, '5', null);
INSERT INTO `tb_menu` VALUES ('7', 'test顶级菜单2', null, null, '5', null);
INSERT INTO `tb_menu` VALUES ('8', '菜单管理', null, null, '1', null);

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` varchar(120) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', 'superAdmin', null, null);
INSERT INTO `tb_role` VALUES ('2', 'admin', null, null);

-- ----------------------------
-- Table structure for `tb_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `role_id` varchar(120) DEFAULT NULL,
  `menu_id` varchar(120) DEFAULT NULL,
  `id` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_table1_role1` (`role_id`),
  KEY `fk_table1_menu1` (`menu_id`),
  KEY `fk_role_menu_menu1` (`menu_id`),
  KEY `fk_role_menu_role1` (`role_id`),
  CONSTRAINT `fk_role_menu_role1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_menu_menu1` FOREIGN KEY (`menu_id`) REFERENCES `tb_menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES ('1', '1', '1');
INSERT INTO `tb_role_menu` VALUES ('2', '7', '10');
INSERT INTO `tb_role_menu` VALUES ('1', '8', '11');
INSERT INTO `tb_role_menu` VALUES ('1', '2', '2');
INSERT INTO `tb_role_menu` VALUES ('1', '3', '3');
INSERT INTO `tb_role_menu` VALUES ('1', '4', '4');
INSERT INTO `tb_role_menu` VALUES ('1', '5', '5');
INSERT INTO `tb_role_menu` VALUES ('2', '5', '6');
INSERT INTO `tb_role_menu` VALUES ('1', '6', '7');
INSERT INTO `tb_role_menu` VALUES ('1', '7', '8');
INSERT INTO `tb_role_menu` VALUES ('2', '6', '9');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(120) NOT NULL,
  `username` varchar(120) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `status` smallint(6) DEFAULT '1',
  `description` varchar(120) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'superAdmin', '123qweasdzxc', '1', null, null, null);
INSERT INTO `tb_user` VALUES ('2', 'admin', '123', '1', null, null, null);

-- ----------------------------
-- Table structure for `tb_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` varchar(120) NOT NULL,
  `user_id` varchar(120) NOT NULL,
  `role_id` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_user` (`user_id`),
  KEY `fk_user_role_role1` (`role_id`),
  CONSTRAINT `fk_user_role_role1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '1', '1');
INSERT INTO `tb_user_role` VALUES ('2', '2', '2');
