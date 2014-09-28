package com.dream.constants;

public interface Constant {
	
	
	String COMMA = ",";
	
	//*********************************json相关
	String JSON_LIST = "list";
	String JSON_OBJ = "obj";
	String SUCCESS = "SUCCESS";
	String ERROR = "ERROR" ;
	String FAILED = "FAILED";
	
	//*********************************json返回码
	String SUCCESS_CODE = "0";
	String FAILED_CODE = "1";
	String SERVER_ERROR_CODE = "9999";

	//*********************************DES加密算法需要用到的KEY
	String DES_ENCRIPT_KEY = "PhotographySystemDES";

	//*********************************DES加密算法传入的字符串后缀
	String ENCODE_SUFFIX = "_VALID";

	String SESSION_USER_INFO = "userinfo";
	/**
	 * 新闻流文件存放路径
	 */
	//	String IMG_PATH_PRE = "//opt//data//";
	//dev
	String FILE_PATH_PRE = "D://tmp/";
	
	
}
