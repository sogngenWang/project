package com.dreamheaven.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.dreamheaven.common.constant.CommonConstant;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.message.domain.Message;
import com.dreamheaven.relymessage.domain.RelyMessage;
import com.dreamheaven.user.domain.User;
import com.dreamheaven.userinfo.domain.UserInfo;
import com.dreamheaven.userinfo.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;

public class CommonUtils {


	private static Pattern referer_pattern = Pattern.compile("@([^@^\\s^:]{1,})([\\s\\:\\,\\;]{0,1})");// @.+?[\\s:]

	private static Set<String> atSet = new HashSet<String>();
	
	private static UserInfoService userInfoService ;
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		CommonUtils.userInfoService = userInfoService;
	}

	public static User getUserFromSession() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> userMap = actionContext.getSession();
		return (User) userMap.get(CommonConstant.LOGINUSER);
	}
	
	public static CompanyInfo getCompanyInfoFromSession() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> companyInfoMap = actionContext.getSession();
		return (CompanyInfo) companyInfoMap.get(CommonConstant.LOGINCOMPANYINFO);
	}

	public static Map<String, Object> getSession() {
		ActionContext actionContext = ActionContext.getContext();

		return actionContext.getSession();
	}

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
//		List list = Arrays.asList(result);
//		Collections.shuffle(list);
//		return list;
		
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
	
	public static Set<String>  generateAtAndMContent(Message message) {


		String msg = message.getMcontent();

		if (StringUtils.isBlank(msg)) {
			return new HashSet<String>();
		}

		msg = generateAtUser(msg);
		
		message.setMcontent(msg);
		
		return atSet;
	}
	
	public static Set<String>  generateAtAndRContent(RelyMessage relyMessage) {

		String msg = relyMessage.getRelyContent();

		if (StringUtils.isBlank(msg)) {
			return new HashSet<String>();
		}
		
		msg = generateAtUser(msg);
		
		relyMessage.setRelyContent(msg);
		
		return atSet;
	}

	private static String generateAtUser(String msg) {
		

		if (StringUtils.isBlank(msg)) {
			return null;
		}

		Matcher matchr = referer_pattern.matcher(msg);
		UserInfo currentUserInfo = new UserInfo();
		//at的时候只能@自己公司的员工，对于其他公司的员工不产生超链接
		currentUserInfo.setUid(getUserFromSession().getUid());
		currentUserInfo = userInfoService.detailUserInfo(currentUserInfo);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setCompanyId(currentUserInfo.getCompanyId());
		List<UserInfo> userInfoList = userInfoService.queryUserInfo(userInfo);

		while (matchr.find()) {
			//带@的表达式名字
			String stringMatch = matchr.group();
			//不带@的用户名
			String str = stringMatch.substring(1, stringMatch.length()).trim();
			// 如果@的用户名在用户中，把用户信息变成超链接的形式
			for (UserInfo userInfoTemp : userInfoList) {
				if (str.equals(userInfoTemp.getNickName())) {
					msg = msg.replace(stringMatch,"<a href='" + userInfoTemp.getUid() + "'>"
									+ stringMatch.trim() + "</a>");
					// 把at到的用户的ID存到Set中(去掉重复项)
					atSet.add(userInfoTemp.getUid());
					break;
				}
			}

		}
		return msg;
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
	
}
