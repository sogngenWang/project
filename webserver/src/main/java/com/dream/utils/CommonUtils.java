package com.dream.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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
	 * 根据传入的对象，去解密相关字段
	 * @param object
	 * @throws Exception 
	 * @throws  
	 */
	public static void decriptObject(Object object, String imei , String imsi) throws Exception{
		if(null == object || Constant.CHECK_FIELDS == null || Constant.CHECK_FIELDS.length == 0){
			return ;
		}
		
		for (int i = 0; i < Constant.CHECK_FIELDS.length; i++) {
			List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
			
			if(fields.contains(Constant.CHECK_FIELDS[i])){
				boolean flag = false;
				//字段中包含加密字段，需要解密然后回传
				String getMethodName = "";
				String setMethodName = "";
				Method getMethod = object.getClass().getMethod(getMethodName);
				Method setMethod = object.getClass().getMethod(setMethodName);
				Object getValue = getMethod.invoke(object);
				//把非String转成字符串
				if(getValue instanceof String){

				}else if(getValue instanceof Integer){
					flag = true;
					getValue = Integer.toString((Integer) getValue);
				}
				
				
				String key = Constant.keyMap.get(getValue);
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
		StringBuffer sb = new StringBuffer();
		for (Field field : fields) {
			sb.append("get");
			sb.append(field.getName().substring(0, 1).toUpperCase());
			sb.append(field.getName().substring(1, field.getName().length()));
			Method method = object.getClass().getMethod(sb.toString());
			Object result = method.invoke(object);
			if(null == result){
				// nothing to do ...
			}else if(result instanceof String){
				map.put(field.getName(), (String) method.invoke(object));
			}else if(result instanceof Integer){
				map.put(field.getName(), (Integer) method.invoke(object));
			}
			sb.setLength(0);
		}

		return map;
	}

}
