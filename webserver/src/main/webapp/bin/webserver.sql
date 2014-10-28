/*
Navicat MySQL Data Transfer

Source Server         : 121.40.99.112
Source Server Version : 50173
Source Host           : 121.40.99.112:3306
Source Database       : webserver

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2014-10-28 10:56:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activityid` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `activityname` varchar(255) DEFAULT NULL COMMENT '活动名字',
  `activitystarttime` varchar(255) DEFAULT NULL COMMENT '活动开始时间',
  `activityendtime` varchar(255) DEFAULT NULL COMMENT '活动结束时间',
  `activitystatus` varchar(2) DEFAULT NULL COMMENT '活动状态(1.预定中 2.报名中 3.报名结束 4.活动中 5.活动结束)',
  `activityquota` varchar(30) DEFAULT NULL COMMENT '活动人数上线',
  `activityaddress` varchar(255) DEFAULT NULL COMMENT '活动地点',
  `activitycreatetime` varchar(255) DEFAULT NULL COMMENT '活动创建时间',
  PRIMARY KEY (`activityid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='活动表，记录了活动的相关信息';

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `commentcontent` text COMMENT '评论内容',
  `userid` int(11) NOT NULL COMMENT '发这条评论的用户id',
  `themeid` int(11) NOT NULL COMMENT '该评论对应的话题id',
  `commentseq` int(11) NOT NULL COMMENT '评论顺序',
  `commenttime` varchar(20) NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`commentid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `praise`
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise` (
  `praiseid` int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `praiseiduserid` int(11) NOT NULL COMMENT '点赞的用户id',
  `praiseidactivityid` int(11) NOT NULL COMMENT '点赞的活动id',
  PRIMARY KEY (`praiseid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户点赞表';

-- ----------------------------
-- Records of praise
-- ----------------------------

-- ----------------------------
-- Table structure for `theme`
-- ----------------------------
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme` (
  `themeid` int(11) NOT NULL COMMENT '话题id',
  `themename` varchar(255) DEFAULT NULL COMMENT '话题名字',
  `activityid` int(11) NOT NULL COMMENT '话题所属活动id',
  PRIMARY KEY (`themeid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='活动跟话题关系表';

-- ----------------------------
-- Records of theme
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户真实姓名',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `type` varchar(2) DEFAULT NULL COMMENT '用户类型(1.管理员 2.企业顾问3.普通会员4.讲师5.嘉宾6.临时会员)',
  `isactive` varchar(1) DEFAULT NULL COMMENT '账户的状态   1.激活 2.禁用',
  `registertime` varchar(20) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户登录信息表';

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL COMMENT '用户id',
  `telephone` varchar(15) DEFAULT NULL COMMENT '用户手机',
  `email` varchar(25) DEFAULT NULL COMMENT '用户邮箱',
  `company` varchar(50) DEFAULT NULL COMMENT '所在公司',
  `department` varchar(30) DEFAULT NULL COMMENT '所属部门',
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户个人信息表——以及名片相关资料';

-- ----------------------------
-- Records of userinfo
-- ----------------------------
