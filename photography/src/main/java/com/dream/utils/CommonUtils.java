package com.dream.utils;

import com.dream.constants.Constant;

public class CommonUtils {

	/**
	 * 把一个byte[]数组转成字符串 用4个字符表示一个字节，0 开头的为正，1开头的为负
	 * 
	 * @param arrB
	 * @return
	 * @throws Exception
	 */
	public static String byteArr2Str(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 判断正负然后加前缀
			if (intTmp < 0) {
				sb.append("1");
			} else {
				sb.append("0");
			}

			// 小于0F的数需 要在前面补00
			if (intTmp > -10 && intTmp < 10) {
				sb.append("00");
			}else if(intTmp > -100 && intTmp < 100){
				//两位数的也补0
				sb.append("0");
			}
			
			sb.append(Math.abs(intTmp));
		}
		return sb.toString();
	}

	/**
	 * 把一个字符串转成byte[]
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static byte[] str2ByteArr(String str) throws Exception {
		byte[] arr = new byte[str.length() / 4];
		StringBuffer sbTmp = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sbTmp.setLength(0);
			if ('1' == (str.charAt(0))) {
				// 负数
				sbTmp.append("-");
			}
			sbTmp.append(str.substring(1, 4));
			arr[i] = new Byte(sbTmp.toString());
			str = str.substring(4, str.length());
		}
		return arr;
	}

	/**
	 * 返回一个加密字符串
	 * 
	 * @throws Exception
	 */
	public static String getEncodeStr(String str) throws Exception {
		return byteArr2Str(DesUtil.getEncCode(str+Constant.ENCODE_SUFFIX));
	}

	/**
	 * 返回一个解密字符串
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getDecodeStr(String needDecodeStr) throws Exception {
		return new String(DesUtil.getDesCode(str2ByteArr(needDecodeStr)));
	}
	
	/**
	 * 传入未解码的字符串，判断是否是正确的用户
	 * @param needDecodeStr
	 * @return
	 * @throws Exception 
	 */
	public static boolean isValidUser(String needDecodeStr) throws Exception{
		String strTmp = new String(DesUtil.getDesCode(str2ByteArr(needDecodeStr)));
		if(strTmp.endsWith(Constant.ENCODE_SUFFIX)){
			return true;
		}
		return false;
	}
	

}
