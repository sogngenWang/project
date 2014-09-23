/*
Navicat MySQL Data Transfer

Source Server         : own
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : photography

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-09-23 15:06:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `areaId` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域id号',
  `areaName` varchar(255) DEFAULT NULL COMMENT '区域名字',
  PRIMARY KEY (`areaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------

-- ----------------------------
-- Table structure for `commodity`
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `commodityId` int(11) NOT NULL COMMENT '商品id',
  `commodityName` varchar(255) DEFAULT NULL COMMENT '商品名字',
  `commodityPrice` varchar(255) DEFAULT NULL COMMENT '商品价格',
  `commodityDetail` varchar(255) DEFAULT NULL COMMENT '商品详细信息',
  `commodityPic` varchar(255) DEFAULT NULL COMMENT '商品的相关图片(仅供标题使用)',
  `commitTime` varchar(255) DEFAULT NULL COMMENT '提交时间(即创建商品时间)',
  `lastUpdateTime` varchar(255) DEFAULT NULL COMMENT '商品最后修改时间',
  `kindsId` varchar(255) DEFAULT NULL COMMENT '该商品所属的大的分类的ID',
  PRIMARY KEY (`commodityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `kinds`
-- ----------------------------
DROP TABLE IF EXISTS `kinds`;
CREATE TABLE `kinds` (
  `kindsId` int(11) NOT NULL COMMENT '分类id',
  `kindsName` varchar(255) DEFAULT NULL COMMENT '分类名字',
  PRIMARY KEY (`kindsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kinds
-- ----------------------------

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `storeId` int(11) NOT NULL COMMENT '商家ID',
  `storeName` varchar(255) DEFAULT NULL COMMENT '商家名字',
  `storeDetail` varchar(255) DEFAULT NULL COMMENT '商家详细描述',
  `areaId` int(11) DEFAULT NULL COMMENT '关联的区域id',
  `storePic` varchar(255) DEFAULT NULL COMMENT '商家商标',
  PRIMARY KEY (`storeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `passwd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `type` varchar(3) DEFAULT NULL COMMENT '用户类型(1,管理员 2.商家 3.普通会员)',
  `telephone` varchar(255) DEFAULT NULL COMMENT '用户手机',
  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `active` varchar(3) DEFAULT NULL COMMENT '账户的状态   1.激活 2.禁用',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
