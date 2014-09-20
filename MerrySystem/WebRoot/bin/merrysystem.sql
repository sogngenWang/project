/*
Navicat MySQL Data Transfer

Source Server         : own
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : merrysystem

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-09-18 00:34:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `kinds`
-- ----------------------------
DROP TABLE IF EXISTS `kinds`;
CREATE TABLE `kinds` (
  `kindsId` int(11) NOT NULL AUTO_INCREMENT,
  `kindsName` varchar(255) DEFAULT NULL,
  `kindsStore` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kindsId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kinds
-- ----------------------------
INSERT INTO kinds VALUES ('1', '婚恋', '2;3;4;1;');
INSERT INTO kinds VALUES ('2', '摄影', '1;2;');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT COMMENT '信息的id',
  `storeId` int(11) DEFAULT NULL COMMENT '与信息想关联的商家Id',
  `messageContentPath` varchar(256) DEFAULT NULL COMMENT '消息正文',
  `messageTitle` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO message VALUES ('4', null, 'D://tmp//1410938367158', '4444');
INSERT INTO message VALUES ('5', null, 'D://tmp//1410938401922', '5555');
INSERT INTO message VALUES ('6', null, 'D://tmp//1410938559284', '6666');
INSERT INTO message VALUES ('7', null, 'D://tmp//1410940274408', '777');
INSERT INTO message VALUES ('8', null, 'D://tmp//1410940292757', '88882');
INSERT INTO message VALUES ('9', null, 'D://tmp//1410959831817', '2222222');
INSERT INTO message VALUES ('10', null, 'D://tmp//1410959831817', '111111');
INSERT INTO message VALUES ('11', null, 'D://tmp//1410960628664', '123');
INSERT INTO message VALUES ('12', null, 'D://tmp//1410960690470', '123');
INSERT INTO message VALUES ('13', null, 'D://tmp//1410960718762', '123');
INSERT INTO message VALUES ('14', null, 'D://tmp//1410960730126', '123');
INSERT INTO message VALUES ('15', null, 'D://tmp//1410960737209', '123');
INSERT INTO message VALUES ('16', null, 'D://tmp//1410960880062', '123');
INSERT INTO message VALUES ('17', null, 'D://tmp//1410961448602', 'ceshi');
INSERT INTO message VALUES ('18', null, 'D://tmp//1410961569370', '草草草草');
INSERT INTO message VALUES ('19', null, 'D://tmp//1410961588817', '111');
INSERT INTO message VALUES ('20', null, 'D://tmp//1410968779444', 'xxxx');
INSERT INTO message VALUES ('21', null, 'D://tmp//1410969006430', 'asdf');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `storeId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `storeName` varchar(30) DEFAULT NULL,
  `storeAddress` varchar(200) DEFAULT NULL,
  `storePosition` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`storeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO store VALUES ('1', '摄影协会', '福建省福州市', 'YT-306');
INSERT INTO store VALUES ('2', '婚庆协会', '福建省长乐市', 'YT-305');
INSERT INTO store VALUES ('3', 'test1', '呵呵 ', 'YT-360');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识符',
  `userName` varchar(30) NOT NULL COMMENT '用户名字',
  `userType` varchar(2) NOT NULL COMMENT '用户类型',
  `passwd` varchar(30) NOT NULL COMMENT '用户登录密码',
  `isactive` varchar(1) DEFAULT NULL COMMENT '是否激活',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
