package com.dream.constants;

import java.util.HashMap;
import java.util.Map;

public interface Constant {
	// MAC校验字段
	public final static String[] CHECK_FIELDS = new String[] { "threadId",
			"username", "job" };
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

}
