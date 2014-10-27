package com.dream.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.baidu.security.TDESUtils;
import com.dream.constants.HttpConst;
import com.google.gson.Gson;

public class CommonUtils {

	/**
	 * 根据传入的content去读取相关字段，然后根据key进行加密
	 * 
	 * @param content
	 * @param key
	 * @return
	 */
	public static String calculateMac(Map<String, String> content, String key) {
		// 计算MAC校验信息
		String data;
		Gson gson = new Gson();
		if (HttpConst.CHECK_FIELDS == null
				|| HttpConst.CHECK_FIELDS.length == 0) {
			data = gson.toJson(content);
		} else {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < HttpConst.CHECK_FIELDS.length; i++) {
				String value = content.get(HttpConst.CHECK_FIELDS[i]);
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
	 * 把一个普通的bean对象转化为Map对象
	 * @param object
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */

	public static Map<String, String> objectToMap(Map<String,String> map , Object object)
			throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if(null == map ){
			map = new HashMap<String, String>();
		}
		Field[] fields = object.getClass().getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		for (Field field : fields) {
			System.out.println(field.getName());
			sb.append("get");
			sb.append(field.getName().substring(0, 1).toUpperCase());
			sb.append(field.getName().substring(1, field.getName().length()));
			Method method = object.getClass().getMethod(sb.toString());
			map.put(field.getName(), (String) method.invoke(object));
			sb.setLength(0);
		}

		return map;
	}

}
