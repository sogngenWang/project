package com.dream.weddingexpo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main3(String[] args) {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session s=sf.openSession();
		
		
		
	}
	
	public static void main(String[] args) {
			
		 Calendar ca = Calendar.getInstance();
		 ca.setTimeInMillis(1417622408163L);
		 System.out.println(ca.getTime());
	}
	
	public static void main34324(String[] args) {
		List<String> strList = new ArrayList<String>();
		
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		strList.add("5");
		strList.add("6");
		
		strList.remove("1");
		
		strList.add(5, "11");
		System.out.println(strList.size());
		
	}
	public static void mainx(String[] args) throws Exception {

		String path = "D://java//project//gitproject//MerrySystem//WebRoot//text//association//about"; 
//				"D://tmp//1410938559284";
		BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
		String temp = reader.readLine();
		StringBuffer sb = new StringBuffer();
		while(null != temp){
			sb.append(temp);
			temp = reader.readLine();
		}
		System.out.println(sb);
		

	}

	public static void main1(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");

		System.out.println(map.toString());

		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");

		System.out.println(map.toString());

//		List<Store> storeList = new ArrayList<Store>();
//		Store storeTmp = new Store();
//		storeTmp.setStoreId("1");
//		storeTmp.setStoreAddress("1");
//		storeTmp.setStorePosition("1");
//		storeTmp.setStoreName("1");
//		storeList.add(storeTmp);
//
//		storeTmp = new Store();
//		storeTmp.setStoreId("2");
//		storeTmp.setStoreAddress("2");
//		storeTmp.setStorePosition("2");
//		storeTmp.setStoreName("2");
//		storeList.add(storeTmp);
//
//		storeTmp = new Store();
//		storeTmp.setStoreId("3");
//		storeTmp.setStoreAddress("3");
//		storeTmp.setStorePosition("3");
//		storeTmp.setStoreName("3");
//		storeList.add(storeTmp);
//
//		storeTmp = new Store();
//		storeTmp.setStoreId("4");
//		storeTmp.setStoreAddress("4");
//		storeTmp.setStorePosition("4");
//		storeTmp.setStoreName("4");
//		storeList.add(storeTmp);

		JSONArray obj = new JSONArray();
		// String[] strArray = new String[3];
		// strArray[0]="1";
		// strArray[1]="2";
		// strArray[2]="3";

//		obj.add(storeList.toArray());
		// obj.put("storeId",1);
		// obj.put("storeName",2);
		// obj.put("storeAddress",3);
		// obj.put("storePosition",4);
		// obj.put("isSuccess", true);
		System.out.println(obj);

	}
}
