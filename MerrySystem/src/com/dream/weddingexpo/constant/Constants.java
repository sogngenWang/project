package com.dream.weddingexpo.constant;

public interface Constants {

	/**
	 * store 表
	 */
	String STORE_STOREID = "storeId";
	String STORE_STORENAME = "storeName";
	String STORE_STOREADDRESS = "storeAddress";
	String STORE_STOREPOSITION = "storePosition";
	
	/**
	 * message 表
	 */
	String MESSAGE_MESSAGEID = "messageId";
	String MESSAGE_STOREID = "storeId";
	String MESSAGE_MESSAGECONTENTPATH = "messageContentPath";
	String MESSAGE_MESSAGETITLE = "messageTitle";
	
	/**
	 * messageTitle 表
	 */
	String MESSAGETITLE_MESSAGEID = "messageId";
	String MESSAGETITLE_MESSAGETITLE = "messageTitle";
	
	
	/**
	 * kinds 表
	 */
	String KINDS_KINDSID = "kindsId";
	String KINDS_KINDSNAME = "kindsName";
	String KINDS_KINDSSTORE = "kindsStore";
	/**
	 * 提交富文本框编辑器需要使用的密码
	 */
	String PASSWD = "admin123";
	/**
	 * 新闻流文件存放路径
	 */
	String IMG_PATH_PRE = "//opt//data//";
	
	/**
	 * 关于展会所使用的messageId
	 */
	String ABOUT_EXPO_MESSAGEID="9999999";
	/**
	 * 参加展会所使用的messageId
	 */
	String VISIT_EXPO_MESSAGEID="9999998";
	
	
	

}
