package com.dream.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		MyBean bean = new MyBean();
		bean.setId("001");
		bean.setName("银行卡");
		bean.setDate(new Date());

		List cardNum = new ArrayList();
		cardNum.add("农行");
		cardNum.add("工行");
		cardNum.add("建行");
		// cardNum.add(new Person("test"));

		bean.setCardNum(cardNum);

		JSONObject jsonObject = JSONObject.fromObject(bean);
		System.out.println(jsonObject);
	}
}
