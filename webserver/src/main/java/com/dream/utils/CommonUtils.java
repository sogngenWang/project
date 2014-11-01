package com.dream.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.baidu.security.TDESUtils;
import com.dream.constants.Constant;
import com.google.gson.Gson;

public class CommonUtils {

	public static final Log LOG = LogFactory.getLog(CommonUtils.class);
	
	/**
	 * 根据传入的content去读取相关字段，然后根据key进行加密
	 * 
	 * @param content
	 * @param key
	 * @return
	 */
	public static String calculateMac(Map<String, Object> content, String key) {
		// 计算MAC校验信息
		String data;
		Gson gson = new Gson();
		if (Constant.CHECK_FIELDS == null || Constant.CHECK_FIELDS.length == 0) {
			data = gson.toJson(content);
		} else {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < Constant.CHECK_FIELDS.length; i++) {
				String value = (String)content.get(Constant.CHECK_FIELDS[i]);
				if (StringUtils.isNotBlank(value)) {
					buffer.append(value);
				}
			}
			data = buffer.toString();
			if (StringUtils.isBlank(data)) {
				data = gson.toJson(content);
			}
		}
		return TDESUtils.MAC_ECB(data, key);
	}
	
	/**
	 * 根据传入的对象，去解密相关字段|注意：当前只支持String，Integer类型的字段
	 * @param object
	 * @throws Exception 
	 * @throws  
	 */
	public static void decriptObject(Object object, String imei , String imsi) throws Exception{
		if(null == object || Constant.CHECK_FIELDS == null || Constant.CHECK_FIELDS.length == 0){
			return ;
		}

		List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
		List<String> fieldsName = new ArrayList<String>();
		//取出所有字段的字段名
		for (int i = 0; i < fields.size() ; i++) {
			fieldsName.add(fields.get(i).getName());
		}
		
		for (int i = 0; i < Constant.CHECK_FIELDS.length; i++) {
			if(fieldsName.contains(Constant.CHECK_FIELDS[i])){
				boolean flag = false;
				//字段中包含加密字段，需要解密然后回传
				String getMethodName = getStringMethodName(Constant.CHECK_FIELDS[i]);
				String setMethodName = setStringMethodName(Constant.CHECK_FIELDS[i]);
				Method getMethod = object.getClass().getMethod(getMethodName);
				Method setMethod = null;
				Object getValue = getMethod.invoke(object);
				//把非String转成字符串
				if(getValue instanceof String){

				}else if(getValue instanceof Integer){
					flag = true;
					getValue = Integer.toString((Integer) getValue);
				}
				//使用反射前需要判断字段类型
				if(flag){
					setMethod = object.getClass().getMethod(setMethodName,Integer.class);
				}else{
					setMethod = object.getClass().getMethod(setMethodName,String.class);
				}
				
				
				String key = Constant.keyMap.get(Constant.CHECK_FIELDS[i]);
				if(null == key ){
					LOG.error("加密key的map设置与加密字段不匹配...请检查");
					return;
				}else if(Constant.FIELED_IMEI.equals(key)){
					if(flag){
						Integer setValueInteger = Integer.valueOf(TDESUtils.decrypt((String) getValue , imei));
						setMethod.invoke(object, setValueInteger);
					}else{
						String setValueString = TDESUtils.decrypt((String) getValue , imei);
						setMethod.invoke(object, setValueString);
					}
				}else if(Constant.FIELED_IMSI.equals(key)){
					if(flag){
						Integer setValueInteger = Integer.valueOf(TDESUtils.decrypt((String) getValue , imsi));
						setMethod.invoke(object, setValueInteger);
					}else{
						String setValueString = TDESUtils.decrypt((String) getValue , imsi);
						setMethod.invoke(object, setValueString);
					}
				}
			}		
		}
	}
	
	/**
	 * 针对list类型数据进行加密
	 * @param content
	 * @param key
	 * @return
	 */
	public static String caculateList(ArrayList<Object> content, String key) {
		// 计算MAC校验信息
		String data;
		Gson gson = new Gson();
		data = gson.toJson(content);
		LOG.info("arrayList to json is "+ data);
		return TDESUtils.MAC_ECB(data, key);
	}
	/**
	 * 把一个普通的bean对象转化为Map对象
	 * @param object
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Map<String, Object> objectToMap(Map<String,Object> map , Object object)
			throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if(null == map ){
			map = new HashMap<String, Object>();
		}
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			Method method = object.getClass().getMethod(getStringMethodName(field.getName()));
			Object result = method.invoke(object);
			if(null == result){
				// nothing to do ...
			}else if(result instanceof String){
				map.put(field.getName(), (String) method.invoke(object));
			}else if(result instanceof Integer){
				map.put(field.getName(), (Integer) method.invoke(object));
			}
		}

		return map;
	}


	/**
	 * 传入字段名字，返回该字段对应的get方法名
	 * @param fieldName
	 * @return
	 */
	public static String getStringMethodName(String fieldName){
		StringBuffer sb = new StringBuffer("get");
		sb.append(fieldName.substring(0,1).toUpperCase());
		sb.append(fieldName.substring(1,fieldName.length()));
		return sb.toString();
	}
	

	/**
	 * 传入字段名字，返回该字段对应的set方法名
	 * @param fieldName
	 * @return
	 */
	public static String setStringMethodName(String fieldName){
		StringBuffer sb = new StringBuffer("set");
		sb.append(fieldName.substring(0,1).toUpperCase());
		sb.append(fieldName.substring(1,fieldName.length()));
		return sb.toString();
	}
	
	/**
	 * 通过传入手机号以及相关的校验码，把该校验码发送到该手机上
	 * @param telephone
	 * @param checkCode
	 * @return
	 */
	public static boolean sendCheckCode(String telephone , String checkCode){
		// TODO 接入手机短信功能 
		LOG.info("验证码"+checkCode+"发送到手机"+ telephone );
		return true;
	}
	

	/**
	 * 指定校验码长度，随机生成一个校验码
	 * @param codeLength
	 * @return
	 */
	public static String createCheckCode(int codeLength){
		long checkCode = (long) ( Math.random() * Math.pow(10, codeLength));
		return String.valueOf(checkCode);
	}

	/**
	 * 根据传入的时间格式来格式化一个时间，返回字符串
	 * @return
	 */
	public static String getSYSDate(String ...formatString) {
		SimpleDateFormat sdf = null ;
		String format = null;
		//如果没有传入格式化规范，则按照默认的规范来
		if(null == formatString || formatString.length == 0){
			format = Constant.DEFAULT_DATEFORMAT;
		}else{
			format = formatString[0];
		}
		
		sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	/**
	 * 根据传入的Checkcode时间参数，判断校验码是否过期
	 * 如果过期则返回true，没有过期返回false
	 * @param checkCodeTime
	 * @return
	 * @throws ParseException
	 */
	public static boolean isCheckCodeExpire(String checkCodeTime) throws ParseException{
		long checkCodeLongTime = -1;
		long nowLongTime = System.currentTimeMillis();
		checkCodeLongTime = transferStrDate2Long(checkCodeTime);
		long expireLongTime = Constant.CHECKCODE_EXPIRE_MILLISECOND;
		LOG.info("nowLongTime = "+ nowLongTime +"|checkCodeLongTime = "+ checkCodeLongTime + "|expireLongTime = "+ expireLongTime);
		if(expireLongTime > (nowLongTime - checkCodeLongTime)){
			//没有超时
			return false;
		}else{
			//超时了
			return true;
		}
	}
	
	/**
	 * 把字符串类型的日期，根据传入的模版解析，然后返回该日期的Long型时间
	 * 如果没有传入格式化的模版，则默认调用系统自带的模版
	 * @param date
	 * @param formatString
	 * @return
	 * @throws ParseException
	 */
	public static long transferStrDate2Long(String date,String ...formatString) throws ParseException{
		SimpleDateFormat sdf = null ;
		String format = null;
		//如果没有传入格式化规范，则按照默认的规范来
		if(null == formatString || formatString.length == 0){
			format = Constant.DEFAULT_DATEFORMAT;
		}else{
			format = formatString[0];
		}
		sdf = new SimpleDateFormat(format);
		return sdf.parse(date).getTime();
	}
	
}
