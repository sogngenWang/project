/*
Navicat MySQL Data Transfer

Source Server         : own
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : merrysystem

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2014-12-01 01:43:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `kinds`
-- ----------------------------
DROP TABLE IF EXISTS `kinds`;
CREATE TABLE `kinds` (
  `kindsId` int(11) NOT NULL auto_increment,
  `kindsName` varchar(255) default NULL,
  `kindsStore` varchar(255) default NULL,
  PRIMARY KEY  (`kindsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `messageId` int(11) NOT NULL auto_increment COMMENT '信息的id',
  `userId` int(11) default NULL COMMENT '发布该消息的用户id',
  `messageContentPath` varchar(256) default NULL COMMENT '消息正文',
  `messageTitle` varchar(256) default NULL,
  `createTime` varchar(255) default NULL COMMENT '新闻创建时间',
  `lastUpdateTime` varchar(255) default NULL COMMENT '最后修改时间',
  `fileId` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  `fileUrl` varchar(255) default NULL,
  `mapUrl` varchar(255) default NULL,
  PRIMARY KEY  (`messageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻信息表';

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `projectfile`
-- ----------------------------
DROP TABLE IF EXISTS `projectfile`;
CREATE TABLE `projectfile` (
  `fileId` int(11) NOT NULL auto_increment,
  `type` varchar(255) NOT NULL COMMENT '1.关于协会 2.加入协会 3.培训  4.通知文件 5.',
  `fileUrl` varchar(255) NOT NULL COMMENT '文件在服务器上的URL',
  `mapUrl` varchar(255) default NULL COMMENT '该图片映射的URL(只有在该文件为图片的时候才有效)',
  PRIMARY KEY  (`fileId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='文件路径存放表';

-- ----------------------------
-- Records of projectfile
-- ----------------------------

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `storeId` int(11) NOT NULL auto_increment COMMENT 'id',
  `storeName` varchar(30) default NULL,
  `storeAddress` varchar(200) default NULL,
  `storePosition` varchar(200) default NULL,
  PRIMARY KEY  (`storeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------

-- ----------------------------
-- Table structure for `top`
-- ----------------------------
DROP TABLE IF EXISTS `top`;
CREATE TABLE `top` (
  `topId` int(11) NOT NULL auto_increment COMMENT '置顶表id',
  `messageId` int(11) NOT NULL COMMENT '新闻id',
  PRIMARY KEY  (`topId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='置顶表';

-- ----------------------------
-- Records of top
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL auto_increment COMMENT '用户唯一标识符',
  `userName` varchar(30) NOT NULL COMMENT '用户名字',
  `userType` varchar(2) NOT NULL COMMENT '用户类型(0.维护人员 1.网站管理员 2.新闻编辑 )',
  `passwd` varchar(30) NOT NULL COMMENT '用户登录密码',
  `isActive` varchar(1) default '1' COMMENT '是否激活(0.否  1.是)',
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'wsg', '0', 'wsg.96321', '1');
INSERT INTO user VALUES ('2', 'admin', '1', 'merrySyste.96321', '1');
INSERT INTO user VALUES ('3', 'edit', '2', 'edit.96321', '1');
