package com.dream.utils;


public class Test {
	
	//测试DES算法
	public static void main(String[] args) throws Exception {
//		byte[] tmp1 = DesUtil.getEncCode("wangsonggen1");
		String byteTmp = CommonUtils.getEncodeStr("wangsonggen");
		System.out.println(CommonUtils.getDecodeStr(byteTmp));
		
//		byte[] tmp2 = DesUtil.getEncCode("wangsonggen2");
//		byte[] tmp3 = DesUtil.getEncCode("wangsonggen3");
//		byte[] tmp4 = DesUtil.getEncCode("wangsonggen4");
//		byte[] tmp5 = DesUtil.getEncCode("wangsonggen5");
		
//		System.out.println(Arrays.toString(tmp1));
//		
//		String encodeStr = new String(tmp1,"utf8");
//		System.out.println(encodeStr);
//		
//		System.out.println(Arrays.toString(DesUtil.byteArr2HexStr(tmp1).getBytes("utf8")));
//		String hexStr = CommonUtils.byteArr2Str(tmp1);
//		System.out.println(Arrays.toString(tmp1));
//		System.out.println(Arrays.toString(CommonUtils.str2ByteArr(hexStr)));
//		
//		System.out.println(new String(DesUtil.getDesCode(CommonUtils.str2ByteArr(hexStr))));
//		System.out.println(new String(DesUtil.getDesCode(tmp3)));
//		System.out.println(new String(DesUtil.getDesCode(tmp2)));
//		System.out.println(new String(DesUtil.getDesCode(tmp4)));
//		System.out.println(new String(DesUtil.getDesCode(tmp5)));
//		System.out.println(new String(DesUtil.getDesCode(tmp1)));
	}
}
