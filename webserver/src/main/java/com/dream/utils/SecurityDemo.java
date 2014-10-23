package com.dream.utils;

import com.baidu.security.DESUtils;
import com.baidu.security.MD5Utils;
import com.baidu.security.TDESUtils;


public class SecurityDemo {
	public static void main(String[] args) {
		// 密钥
		String key = "866723016902223";
		// 测试数据（简体繁体英文数字字符全角）
		String data = "汉字漢字123abcABC!@#１２３ａｂｃＡＢＣ！＠#";

		// DES算法
		String des_encrypt = DESUtils.encrypt(data, key);
		System.out.println("【DES加密】" + des_encrypt);
		String des_decrypt = DESUtils.decrypt(des_encrypt, key);
		System.out.println("【DES解密】" + des_decrypt);
		// TDES算法
		String tdes_encrypt = TDESUtils.encrypt(data, key);
		System.out.println("【TDES加密】" + tdes_encrypt);
		String tdes_decrypt = TDESUtils.decrypt(tdes_encrypt, key);
		System.out.println("【TDES解密】" + tdes_decrypt);
		// MAC计算
		String mac_pboc_tdes = TDESUtils.MAC_PBOC_TDES(data, key);
		System.out.println("【MAC_PBOC_TDES】" + mac_pboc_tdes);
		String mac_ecb = TDESUtils.MAC_ECB(data, key);
		System.out.println("【MAC_ECB】" + mac_ecb);
		// MD5计算
		String md5 = MD5Utils.getMD5(data);
		System.out.println(md5);
		System.out.println("【MD5】" + mac_ecb);
	}
}
