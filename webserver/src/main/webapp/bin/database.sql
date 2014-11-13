
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `passwd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `type` varchar(3) DEFAULT NULL COMMENT '用户类型(1.管理员 2.企业顾问3.普通会员4.讲师5.嘉宾6.临时会员)',
  `telephone` varchar(255) DEFAULT NULL COMMENT '用户手机',
  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `active` varchar(3) DEFAULT NULL COMMENT '账户的状态   1.激活 2.禁用',
  `register` varchar(20) DEFAULT NULL COMMENT '注册时间'
  
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8



CREATE TABLE `comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `commentcontent` text NOT NULL COMMENT '评论内容',
  `userid` int(11) NOT NULL COMMENT '发这条评论的用户id',
  `commenttype` int(4) NOT NULL COMMENT '评论类型(1.好评 2.中评 3.差评)',
  `storeid` int(11) DEFAULT NULL COMMENT '该评论是针对商家的评论(否则为空)',
  `commodityid` int(11) DEFAULT NULL COMMENT '该评论是针对商家的评论(否则为空)',
  `commentseq` int(11) NOT NULL COMMENT '评论顺序',
  `commenttime` varchar(255) NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`commentid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8


#用户表，评论表，活动主题表，活动参与人表
