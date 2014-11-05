package com.dream.constants;

import java.util.HashMap;
import java.util.Map;

public interface Constant {
	// MAC校验字段
	public final static String[] CHECK_FIELDS = new String[] { };
	// 返回报文是list类型的时候，使用的key名字
	public static final String JSON_LIST = "list";

	// 加密/解密规则
	public static final Map<String, String> keyMap = new HashMap<String, String>() {
		/**
		 * TODO 初始化加密规则
		 */
		private static final long serialVersionUID = 1L;

		{
			put(CONSTATN_USERNAME, FIELED_IMEI);
			put(CONSTATN_PASSWORD, FIELED_IMSI);
		}
	};
	
	
	//*********字段名字映射常量
	public static final String CONSTATN_USERNAME = "username";
	public static final String CONSTATN_PASSWORD = "password";
	public static final String FIELED_IMEI = "imei";
	public static final String FIELED_IMSI = "imsi";
	
	
	//校验码的位数
	public static final int CHECKCODE_LENGTH = 6;
	//默认的时间格式化模版
	public static final String DEFAULT_DATEFORMAT = "yyyy-MM-dd HH:mm:ss,SSS";

	//校验码过期时间(分钟)
	public static final int CHECKCODE_EXPIRE_MINUTE = 30;
	//校验码过期时间(毫秒)，自动根据上个参数计算
	public static final long CHECKCODE_EXPIRE_MILLISECOND  = CHECKCODE_EXPIRE_MINUTE * 60 * 1000;

	
	//*************业务代码
	public static final String CODE_0000="成功";
	public static final String CODE_0001="业务异常";
	public static final String CODE_0002="用户名或者密码错误，登录失败";
	public static final String CODE_0003="用户已经存在，注册失败";
	public static final String CODE_0004="校验码错误";
	public static final String CODE_0005="校验码已过期，过期时间为"+CHECKCODE_EXPIRE_MINUTE+"分钟";
	public static final String CODE_0006="用户还未签到，列出已签到用户失败";
	public static final String CODE_0007="用户已经报名过";
	public static final String CODE_0008="报名人数已经达到上限";
	public static final String CODE_0009="该活动还未开始报名或者已经停止报名";
	public static final String CODE_0010="用户已赞过.";
	public static final String CODE_0011="";
	public static final String CODE_0012="";
	public static final String CODE_0013="";
	
	public static final String ACTIVITY_PICTURE_HEADER_NAME = "header.jpg";
	
	//二维码的宽以及高
	public static final int QRCODE_WIDTH = 200;
	public static final int QRCODE_HEIGHT = 200;
	
	//数据库默认常量值
	//普通用户
	public static final String USER_NORMAL_TYPE = "3";
	//用户激活状态
	public static final String USER_ACTIVE = "1";
	//活动已签到用户
	public static final Integer REGISTERACTIVITY_SIGN = 1;
	//每页显示多少条记录，默认值
	public static final Integer PAGE_RECORD_PER_PAGE_DEFAULT = 3;
	public static final String ACTIVITY_REGISTER_STATUS = "2";
	
	//
	public static final Integer PRAISE_TYPE_ACTIVITY = 1;
	//
	public static final Integer PRAISE_TYPE_THEME = 2;
	//
	public static final Integer PRAISE_TYPE_USER = 3;
	
	//用户活动还未点赞
	public static final String USER_ACTIVITY_NOT_PRAISE = "0";
	//用户活动已经点赞
	public static final String USER_ACTIVITY_HAS_PRAISE = "1";
	
}
