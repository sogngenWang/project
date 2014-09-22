package com.dreamheaven.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.dreamheaven.domain.Dish;
import com.dreamheaven.domain.Order;
import com.dreamheaven.domain.User;

public class CommonUtils {
	
	private static Pattern referer_pattern = Pattern.compile("@([^@^\\s^:]{1,})([\\s\\:\\,\\;]{0,1})");// @.+?[\\s:]

	public static void setCriteria(Map<String, String> paramMap,
			Criteria criteria) {
		if (null != paramMap && !paramMap.isEmpty()) {
			Set<String> paramKeySet = paramMap.keySet();
			paramKeySet.isEmpty();
			Iterator<String> itrator = paramKeySet.iterator();
			while (itrator.hasNext()) {
				String itratorTempKey = itrator.next();
				String tempValue = paramMap.get(itratorTempKey);
				if (StringUtils.isNotBlank(tempValue)) {
					criteria.add(Restrictions.eq(itratorTempKey, tempValue));
				}

			}
		}

	}

	// get random number
	public static int[] getRandomNumber(int randomNumber) {
		int[] result = new int[randomNumber];
		//初始化随机数数组
		for (int i = 0; i < randomNumber; i++) 
		{
			result[i] = i;
		}
		//在数组中的随机数排序
		for (int j = randomNumber-1 ; j > 0; j--) {
			int index = (int) (Math.random() * j);
			int temp = result[index];
			result[index] = result[j];
			result[j] = temp;
		}
		return result;
		
	}
	
	public static String getNowTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String nowTime = dateFormat.format(new Date());
		return nowTime;
	}


	public static void generateJson(JSONObject json)
	{

		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createJson(Class<?> clazz,JSONObject json) 
			throws NoSuchMethodException, SecurityException
	{
		Field[] fields = clazz.getDeclaredFields();
		for(Field fieldTemp : fields)
		{
			json.put(fieldTemp.getName(),
					(String)clazz.getDeclaredMethod(
							"get"+fieldTemp.getName().substring(0, 1).toUpperCase()+fieldTemp.getName().substring(1)).getDefaultValue());
		}
		
	}
	
	/**
	 * 生成唯一session主键
	 * @param user
	 * @return
	 */
	public static String generateKeyByUser(User user) {
		Random random  = new Random();
		if(null != user.getUid()){
			return Long.valueOf(user.getUid())*random.nextLong()+"";
		}
		return "";
	}
	
	/**
	 * 生成格式化好的日期
	 */
	public static String generateDateString(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(calendar.getTime());
	}
	
	public static String generateOrder(Order order){
		StringBuffer sb = new StringBuffer();
				
		return sb.toString();
	}
	
	public static  void printPageByString(String str){
//		File file = new File("D:/hadoop-metrics.properties"); // 获取选择的文件
		// 构建打印请求属性集
		HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		MediaSize ms = new MediaSize(74, 1000, 1000, MediaSizeName.ISO_A7);
		pras.add(MediaSizeName.ISO_A7);
		// 设置打印格式，因为未确定类型，所以选择autosense
		DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		// 查找所有的可用的打印服务
		// PrintService printService[] =
		// PrintServiceLookup.lookupPrintServices(flavor, pras);
		// 定位默认的打印服务
		PrintService defaultService = PrintServiceLookup
				.lookupDefaultPrintService();
		try {
			
			DocPrintJob job = defaultService.createPrintJob(); // 创建打印作业
			Reader reader = new StringReader(str); // 构造待打印的文件流
			
			File file = new File("../tmpFileForPrint");
			if(file.exists()){
				file.delete();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(str);
			writer.close();
			FileInputStream fis = new FileInputStream(file);
			DocAttributeSet das = new HashDocAttributeSet();
			Doc doc = new SimpleDoc(fis, flavor, das);
			job.print(doc, pras);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("print success...printData is : "+str);
		
	}

	public static List<Dish> generateDishListFromMessage(String dishMessage) {
		List<Dish> dishList = new ArrayList<Dish>();
		StringTokenizer stringTokenizer = new StringTokenizer(dishMessage,"\n");
		while(stringTokenizer.hasMoreTokens()){
			StringTokenizer line = new StringTokenizer(stringTokenizer.nextToken(),"\t");
			Dish dish = new Dish();
			dish.setDishName(line.nextToken());
			dish.setDishCash(line.nextToken());
			dishList.add(dish);
		}
		return dishList;
	}
	
}
