/*
Navicat MySQL Data Transfer

Source Server         : online
Source Server Version : 50173
Source Host           : 121.40.99.112:3306
Source Database       : merrysystem

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2014-11-29 16:28:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT COMMENT '信息的id',
  `userId` int(11) DEFAULT NULL COMMENT '发布该消息的用户id',
  `messageContentPath` varchar(256) DEFAULT NULL COMMENT '消息正文',
  `messageTitle` varchar(256) DEFAULT NULL,
  `createTime` varchar(11) DEFAULT NULL COMMENT '新闻创建时间',
  `lastUpdateTime` varchar(255) DEFAULT NULL COMMENT '最后修改时间',
  `fileId` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `fileUrl` varchar(255) DEFAULT NULL,
  `mapUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='新闻信息表';

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO message VALUES ('1', null, '//opt//data//1416994107316', 'ceshi', null, null, null, null, null, null);
INSERT INTO message VALUES ('2', null, '//opt//data//1416995079676', 'xxxxx', null, null, null, null, null, null);
INSERT INTO message VALUES ('3', null, '//opt//data//1417050889340', '2015 “建设银行杯”敢于发现·平民英雄 马拉松摄影大赛', null, null, null, null, null, null);
INSERT INTO message VALUES ('4', null, '//opt//data//1417088272695', 'asdfasdf', null, null, null, null, null, null);
INSERT INTO message VALUES ('5', null, '//opt//data//1417088952890', 'asdfasdf', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `projectfile`
-- ----------------------------
DROP TABLE IF EXISTS `projectfile`;
CREATE TABLE `projectfile` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL COMMENT '1.关于协会 2.加入协会 3.培训  4.通知文件 5.',
  `fileUrl` varchar(255) NOT NULL COMMENT '文件在服务器上的URL',
  `mapUrl` varchar(255) DEFAULT NULL COMMENT '该图片映射的URL(只有在该文件为图片的时候才有效)',
  PRIMARY KEY (`fileId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='文件路径存放表';

-- ----------------------------
-- Records of projectfile
-- ----------------------------

-- ----------------------------
-- Table structure for `top`
-- ----------------------------
DROP TABLE IF EXISTS `top`;
CREATE TABLE `top` (
  `topId` int(11) NOT NULL AUTO_INCREMENT COMMENT '置顶表id',
  `messageId` int(11) NOT NULL COMMENT '新闻id',
  PRIMARY KEY (`topId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='置顶表';

-- ----------------------------
-- Records of top
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识符',
  `userName` varchar(30) NOT NULL COMMENT '用户名字',
  `userType` varchar(2) NOT NULL COMMENT '用户类型(0.维护人员 1.网站管理员 2.新闻编辑 )',
  `passwd` varchar(30) NOT NULL COMMENT '用户登录密码',
  `isActive` varchar(1) DEFAULT NULL COMMENT '是否激活(0.否  1.是)',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'wsg', '0', 'wsg.96321', '1');
INSERT INTO user VALUES ('2', 'admin', '1', 'merrySyste.96321', '1');
INSERT INTO user VALUES ('3', 'edit', '2', 'edit.96321', '1');
