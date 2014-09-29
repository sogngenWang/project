package com.dream.constants;

public interface Constant {
	
	
	String COMMA = ",";
	
	//*********************************json相关
	String JSON_LIST = "list";
	String JSON_OBJ = "obj";
	String SUCCESS = "SUCCESS";
	String ERROR = "ERROR" ;
	String FAILED = "FAILED";
	String JSON_IMG_PATH = "img";
	
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

	// 文件上传，前台所使用的name，后台根据这个变量名字来获取文件
	String UPLOAD_PARAM_NAME = "uploadImg";
	// 文件上传后保存的文件路径
	String UPLOAD_FILE_UPLOAD_PATH = "D://JAVA//SERVER//apache-tomcat-7.0.33//webapps//Photography//uploads//";
//	String UPLOAD_FILE_UPLOAD_PATH = "uploads//";
	// 定义允许上传的图片类型
	String UPLOAD_IMG_TYPE = "jpg|jpeg|bmp|gif|png";

}
