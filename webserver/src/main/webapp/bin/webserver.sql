/*
Navicat MySQL Data Transfer

Source Server         : own
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : webserver

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-11-12 01:48:57
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
  `activitystatus` varchar(2) DEFAULT '1' COMMENT '活动状态(1.预定中 2.报名中 3.报名结束 4.活动中 5.活动结束)',
  `activityquota` int(11) DEFAULT NULL COMMENT '活动人数上限',
  `activityaddress` varchar(255) DEFAULT NULL COMMENT '活动地点',
  `activitycreatetime` varchar(255) DEFAULT NULL COMMENT '活动创建时间',
  `activitypicturedir` varchar(255) DEFAULT NULL COMMENT '活动图片目录，活动相关的所有图片都存放在该目录下，该目录下以head开头的为活动主图片',
  `kindsid` int(11) DEFAULT NULL COMMENT '活动所属分类的id',
  `secondkindsid` int(11) DEFAULT NULL COMMENT '活动所属的二级分类id',
  `activityabout` text COMMENT '活动概要',
  `activitydetail` text COMMENT '活动详情介绍',
  `viewcount` int(11) unsigned DEFAULT '0' COMMENT '已查阅数',
  PRIMARY KEY (`activityid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='活动表，记录了活动的相关信息';

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO activity VALUES ('1', '大数据时代', '2014-02-02 23:29:37', '2014-10-24 23:29:58', '2', '100', '福建省福州市鼓楼区', '2014-01-29 23:30:17', 'http://localhost:8080/webserver/imgs/activity/1/', '1', '2', '测试活动概要内容~', '活动详情。。。', '22');
INSERT INTO activity VALUES ('2', '机器学习算法', '2014-10-21 23:30:42', '2014-11-29 23:30:52', '2', '1000', '福建省福州市仓山区', '2014-10-20 23:31:21', 'http://localhost:8080/webserver/imgs/activity/2/', '1', '2', '3322222', '2222222222222222', '0');
INSERT INTO activity VALUES ('3', '测试1', '2014-11-07 14:17:05', '2014-11-07 14:17:18', '2', '10000', '地区1', '2014-11-07 14:17:59', 'http://localhost:8080/webserver/imgs/activity/3/', '1', '2', '23333', '333333333333333333333333', '0');
INSERT INTO activity VALUES ('5', '测试2', '2014-11-07 14:17:09', '2014-11-07 14:17:23', '2', '10', '地区2', '2014-11-07 14:18:01', 'http://localhost:8080/webserver/imgs/activity/4/', '1', '2', '44444', '444444444444444444444444444444', '0');
INSERT INTO activity VALUES ('6', '测试3', '2014-11-07 14:17:12', '2014-11-07 14:17:26', '3', '1', '地区3', '2014-11-07 14:18:04', 'http://localhost:8080/webserver/imgs/activity/5/', '1', '2', '55555', '555555555555555555555555555555', '0');

-- ----------------------------
-- Table structure for `activityvip`
-- ----------------------------
DROP TABLE IF EXISTS `activityvip`;
CREATE TABLE `activityvip` (
  `activityid` int(11) NOT NULL COMMENT '活动id',
  `userid` int(11) NOT NULL COMMENT '活动的嘉宾用户id',
  PRIMARY KEY (`activityid`,`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='活动嘉宾关系表';

-- ----------------------------
-- Records of activityvip
-- ----------------------------
INSERT INTO activityvip VALUES ('1', '1');
INSERT INTO activityvip VALUES ('1', '36');
INSERT INTO activityvip VALUES ('1', '37');

-- ----------------------------
-- Table structure for `checkcode`
-- ----------------------------
DROP TABLE IF EXISTS `checkcode`;
CREATE TABLE `checkcode` (
  `checkcodeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '校验码id',
  `checkcode` varchar(20) NOT NULL COMMENT '校验码',
  `telephone` varchar(255) DEFAULT NULL COMMENT '该校验码对应的手机号',
  `createtime` varchar(255) DEFAULT NULL COMMENT '校验码生成时间',
  PRIMARY KEY (`checkcodeid`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户校验码';

-- ----------------------------
-- Records of checkcode
-- ----------------------------
INSERT INTO checkcode VALUES ('1', '248724', '15159628259', '2014-11-01 11:25:18,502');
INSERT INTO checkcode VALUES ('2', '704477', '15159628259', '2014-11-01 12:02:04,879');
INSERT INTO checkcode VALUES ('3', '511007', '15159628259', '2014-11-01 12:02:23,878');
INSERT INTO checkcode VALUES ('4', '601515', '15159628259', '2014-11-01 12:02:33,078');
INSERT INTO checkcode VALUES ('5', '600074', '15159628259', '2014-11-04 21:09:01,306');
INSERT INTO checkcode VALUES ('6', '977708', '15155105527', '2014-11-05 00:35:23,258');
INSERT INTO checkcode VALUES ('7', '198858', '15159628259', '2014-11-05 00:26:25,466');
INSERT INTO checkcode VALUES ('8', '896066', '15159628259', '2014-11-10 14:23:48,359');
INSERT INTO checkcode VALUES ('9', '430626', '15159628259', '2014-11-10 15:09:57,511');
INSERT INTO checkcode VALUES ('10', '574777', '15159628259', '2014-11-11 21:52:43,347');

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
  `commenttime` varchar(30) NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`commentid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO comment VALUES ('1', '第一条评论', '1', '1', '1', '');
INSERT INTO comment VALUES ('2', '第二条评论', '1', '2', '1', '');
INSERT INTO comment VALUES ('3', '第二条评论', '1', '1', '2', '');
INSERT INTO comment VALUES ('4', 'xxxxx', '2', '2', '2', '');
INSERT INTO comment VALUES ('5', 'hehe ', '1', '1', '3', '');

-- ----------------------------
-- Table structure for `friends`
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `friendid` int(11) NOT NULL AUTO_INCREMENT COMMENT '朋友关系id',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `frienduserid` int(11) NOT NULL COMMENT '用户好友id',
  `isbefriend` varchar(2) NOT NULL DEFAULT '0' COMMENT '是否已经互为好友(0.待确认 1.是 2.拒绝)',
  `accesstime` varchar(30) DEFAULT NULL COMMENT '成为好友的时间——只有同意之后才有值',
  PRIMARY KEY (`friendid`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='好友关系表';

-- ----------------------------
-- Records of friends
-- ----------------------------
INSERT INTO friends VALUES ('1', '1', '2', '1', null);
INSERT INTO friends VALUES ('2', '1', '5', '1', null);
INSERT INTO friends VALUES ('3', '4', '1', '1', null);
INSERT INTO friends VALUES ('4', '5', '1', '1', null);
INSERT INTO friends VALUES ('9', '2', '1', '1', '2014-11-09 17:09:42,587');
INSERT INTO friends VALUES ('10', '4', '5', '0', '2014-11-12 01:35:35,814');

-- ----------------------------
-- Table structure for `kinds`
-- ----------------------------
DROP TABLE IF EXISTS `kinds`;
CREATE TABLE `kinds` (
  `kindsid` int(11) NOT NULL COMMENT '分类id',
  `kindsname` varchar(255) DEFAULT NULL COMMENT '分类名字',
  `secondkindsid` varchar(255) DEFAULT NULL COMMENT '二级分类id,如果该分类id属于二级分类，则该字段为-1',
  PRIMARY KEY (`kindsid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='活动分类表';

-- ----------------------------
-- Records of kinds
-- ----------------------------
INSERT INTO kinds VALUES ('1', 'it行业', null);
INSERT INTO kinds VALUES ('2', '金融', null);
INSERT INTO kinds VALUES ('3', '建筑', null);
INSERT INTO kinds VALUES ('4', '互联网', '1');
INSERT INTO kinds VALUES ('5', '大数据', '1');
INSERT INTO kinds VALUES ('6', '移动互联网', '1');

-- ----------------------------
-- Table structure for `lottery`
-- ----------------------------
DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery` (
  `drawid` int(11) NOT NULL AUTO_INCREMENT COMMENT '抽奖唯一标识符',
  `lotteryid` int(11) NOT NULL COMMENT '抽奖活动的id(一个活动可能有多次抽奖)',
  `activityid` int(11) NOT NULL COMMENT '活动id',
  `lotterydate` varchar(30) NOT NULL COMMENT '抽奖日期',
  `prizelevel` varchar(30) NOT NULL COMMENT '奖品等级(一等奖，二等奖...以此类推)',
  `prizetype` int(11) NOT NULL COMMENT '奖项类型(1.中奖人数固定 2.按照总人数的百分比抽奖)',
  `prizecount` int(11) DEFAULT NULL COMMENT '奖项总人数',
  `prizepercentrate` float DEFAULT NULL COMMENT '中奖率',
  PRIMARY KEY (`drawid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='抽奖配置表';

-- ----------------------------
-- Records of lottery
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageid` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `messagecontent` text COMMENT '消息内容',
  `userid` int(11) DEFAULT NULL COMMENT '接收该消息的用户id',
  `isread` varchar(3) DEFAULT NULL COMMENT '用户是否已读该消息0.未读 1.已读',
  `messagedate` varchar(30) DEFAULT NULL COMMENT '消息日期',
  PRIMARY KEY (`messageid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO message VALUES ('1', '测试留言信息·~~~1 - -！', '1', '1', '2014-11-08 15:14:30');
INSERT INTO message VALUES ('2', '测试信息2', '1', '1', '2014-11-07 12:43:45');
INSERT INTO message VALUES ('3', '123', '2', '1', '2014-11-07 12:44:02');
INSERT INTO message VALUES ('4', '测试是', '1', '0', '2014-11-07 12:44:18');
INSERT INTO message VALUES ('5', '11111', '1', '0', '2014-11-07 13:09:48');

-- ----------------------------
-- Table structure for `onlinequestion`
-- ----------------------------
DROP TABLE IF EXISTS `onlinequestion`;
CREATE TABLE `onlinequestion` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `userid` int(11) NOT NULL COMMENT '提问用户的id',
  `asktime` varchar(20) DEFAULT NULL COMMENT '问题提问的时间',
  `question` varchar(255) DEFAULT NULL COMMENT '已注册用户提问的问题',
  `answer` varchar(255) DEFAULT NULL COMMENT '活动人员/管理员回答的答案',
  PRIMARY KEY (`questionid`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='在线提问列表';

-- ----------------------------
-- Records of onlinequestion
-- ----------------------------
INSERT INTO onlinequestion VALUES ('1', '1', '2014-11-03 21:55:55', '什么时候开始', '2014年11月3日');
INSERT INTO onlinequestion VALUES ('2', '1', '2014-11-03 21:56:17', '有谁参加', '参照以上嘉宾');
INSERT INTO onlinequestion VALUES ('3', '1', '2014-11-04 20:41:18', 'question1', '1');
INSERT INTO onlinequestion VALUES ('4', '1', '2014-11-04 20:41:22', 'question2', '2');
INSERT INTO onlinequestion VALUES ('5', '1', '2014-11-04 20:41:24', 'question3', '3');
INSERT INTO onlinequestion VALUES ('6', '1', '2014-11-04 20:41:25', 'question4', '4');
INSERT INTO onlinequestion VALUES ('7', '1', '2014-11-04 20:41:27', 'question5', '5');
INSERT INTO onlinequestion VALUES ('8', '1', '2014-11-04 20:41:28', 'question6', '6');
INSERT INTO onlinequestion VALUES ('9', '1', '2014-11-04 20:41:31', 'question7', '7');
INSERT INTO onlinequestion VALUES ('10', '1', '2014-11-04 20:41:32', 'question8', '8');
INSERT INTO onlinequestion VALUES ('11', '1', '2014-11-04 20:41:33', 'question9', '9');
INSERT INTO onlinequestion VALUES ('12', '2', '2014-11-04 20:41:34', 'question10', '10');

-- ----------------------------
-- Table structure for `praise`
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise` (
  `praiseid` int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `userid` int(11) NOT NULL COMMENT '点赞的用户id',
  `otherid` int(11) NOT NULL COMMENT '被点赞的id',
  `praisetype` int(11) NOT NULL COMMENT '被点赞的类型(1.活动 2.主题 3.对方用户id )',
  PRIMARY KEY (`praiseid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户点赞表';

-- ----------------------------
-- Records of praise
-- ----------------------------
INSERT INTO praise VALUES ('1', '1', '1', '0');
INSERT INTO praise VALUES ('2', '1', '2', '0');
INSERT INTO praise VALUES ('3', '2', '1', '0');
INSERT INTO praise VALUES ('4', '1', '1', '0');
INSERT INTO praise VALUES ('5', '1', '1', '1');
INSERT INTO praise VALUES ('12', '1', '2', '2');
INSERT INTO praise VALUES ('7', '1', '2', '3');
INSERT INTO praise VALUES ('8', '1', '1', '4');
INSERT INTO praise VALUES ('9', '1', '3', '4');
INSERT INTO praise VALUES ('10', '2', '1', '4');
INSERT INTO praise VALUES ('11', '3', '1', '4');
INSERT INTO praise VALUES ('13', '5', '1', '1');

-- ----------------------------
-- Table structure for `prize`
-- ----------------------------
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize` (
  `prizeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '中奖id',
  `lotteryid` int(11) DEFAULT NULL COMMENT '抽奖活动的id(一个活动可能有多次抽奖)',
  `userid` int(11) DEFAULT NULL COMMENT '中奖用户的id',
  `prizelevel` varchar(30) DEFAULT NULL COMMENT '奖品等级(一等奖，二等奖...以此类推)',
  `prizetime` varchar(30) DEFAULT NULL COMMENT '中奖时间',
  PRIMARY KEY (`prizeid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='中奖人员表';

-- ----------------------------
-- Records of prize
-- ----------------------------

-- ----------------------------
-- Table structure for `registeractivity`
-- ----------------------------
DROP TABLE IF EXISTS `registeractivity`;
CREATE TABLE `registeractivity` (
  `registrationid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户报名id',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `activityid` int(11) DEFAULT NULL COMMENT '活动id',
  `signstatus` int(11) DEFAULT '0' COMMENT '签到状态(0.未签到 1.已签到2.已预定)',
  PRIMARY KEY (`registrationid`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户活动关系表';

-- ----------------------------
-- Records of registeractivity
-- ----------------------------
INSERT INTO registeractivity VALUES ('1', '1', '1', '1');
INSERT INTO registeractivity VALUES ('2', '2', '1', '1');
INSERT INTO registeractivity VALUES ('3', '2', '2', '1');
INSERT INTO registeractivity VALUES ('4', '1', '2', '1');
INSERT INTO registeractivity VALUES ('7', '5', '1', '1');
INSERT INTO registeractivity VALUES ('8', '4', '1', '1');
INSERT INTO registeractivity VALUES ('9', '3', '2', '1');
INSERT INTO registeractivity VALUES ('10', '4', '2', '0');
INSERT INTO registeractivity VALUES ('11', '1', '3', '0');
INSERT INTO registeractivity VALUES ('12', '5', '3', '0');

-- ----------------------------
-- Table structure for `theme`
-- ----------------------------
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme` (
  `themeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '话题id',
  `themename` varchar(255) DEFAULT NULL COMMENT '话题名字',
  `activityid` int(11) NOT NULL COMMENT '话题所属活动id',
  PRIMARY KEY (`themeid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='活动跟话题关系表';

-- ----------------------------
-- Records of theme
-- ----------------------------
INSERT INTO theme VALUES ('1', '关于大数据', '1');
INSERT INTO theme VALUES ('2', 'hadoop平台', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `telephone` varchar(15) NOT NULL COMMENT '手机号_主键的唯一识别',
  `username` varchar(20) DEFAULT NULL COMMENT '用户真实姓名',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `type` varchar(2) DEFAULT '3' COMMENT '用户类型(1.管理员 2.企业顾问3.普通会员4.讲师5.嘉宾6.临时会员)',
  `isactive` varchar(1) DEFAULT '1' COMMENT '账户的状态   1.激活 2.禁用',
  `registertime` varchar(30) DEFAULT NULL COMMENT '注册时间',
  `email` varchar(25) DEFAULT NULL COMMENT '电子邮箱',
  `company` varchar(100) DEFAULT NULL COMMENT '所属公司',
  `position` varchar(30) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='用户登录信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', '15155445597', '王松根', 'dream', 'wsg96321', '1', '1', '2014-10-28 11:25:04', 'wangsonggen@126.com', '博远无线', '研发工程师');
INSERT INTO user VALUES ('2', '15155221122', '测试', '测试昵称', '123', '3', '1', '2014-10-28 11:25:31', 'test@163.com', '腾讯', '总工程师');
INSERT INTO user VALUES ('3', '13067266273', 'Jack', '测试a昵v称哦123', 'dream', '2', '1', '2014-11-03 21:57:31', 'heh@qq.com', '百度', '美工');
INSERT INTO user VALUES ('36', '18211112333', 'Jack2123', 'zxc', '123', '1', '0', '', '', '', '');
INSERT INTO user VALUES ('40', '15159628259', 'xxx', '测试22', 'test321', '3', '1', '2014-11-10 15:25:47,203', null, '福富', null);
INSERT INTO user VALUES ('38', '15155005597', '123', '测试', 'w321', '3', '1', '2014-11-04 21:18:22,289', null, '网龙', null);
INSERT INTO user VALUES ('4', '15305852142', 'cece', 'zxdf', '4444', '3', '1', null, null, null, null);
INSERT INTO user VALUES ('5', '11111111111', 'd', '3', '34', '3', '1', null, null, null, null);

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
