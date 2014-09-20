#创建数据库
CREATE DATABASE IF NOT EXISTS MerrySystem default charset utf8 COLLATE utf8_general_ci;

use MerrySystem;
#创建表

#用户表
CREATE TABLE `user` (
  `userId` int(11) NOT NULL auto_increment COMMENT '用户唯一标识符',
  `userName` varchar(30) NOT NULL COMMENT '用户名字',
  `userType` varchar(2) NOT NULL COMMENT '用户类型',
  `passwd` varchar(30) NOT NULL COMMENT '用户登录密码',
  `isactive` varchar(1) default NULL COMMENT '是否激活',
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `store` (
  `storeId` int(11) NOT NULL auto_increment COMMENT '商家id',
  `storeName` varchar(30) default NULL COMMENT '商家名字',
  `storeAddress` varchar(200) default NULL COMMENT '商家地址',
  `storePosition` varchar(200) default NULL,
  PRIMARY KEY  (`storeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `message` (
  `messageId` int(11) NOT NULL auto_increment COMMENT '信息的id',
  `storeId` int(11) default NULL COMMENT '与信息想关联的商家Id',
  `messageContentPath` varchar(256) COMMENT '消息正文',
  `messageTitle` varchar(256) default NULL COMMENT '消息图片相对路径，多个图片路径用","隔开',
  PRIMARY KEY  (`messageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `kinds` (
  `kindsId` int(11) NOT NULL auto_increment COMMENT '分类id',
  `kindsName` varchar(255) default NULL COMMENT '分类名字',
  `kindsStore` varchar(255) default NULL COMMENT '商家id',
  PRIMARY KEY  (`kindsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
