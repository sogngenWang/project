package junitbean;

import junitbase.JUnitControllerBase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dream.service.UserService;

/**
 * action测试列子
 * 
 * @author wsg
 * 
 */
public class UserControllerTestSuit extends JUnitControllerBase {
	@Autowired
	UserService service;

	@Test
	public void addUserController() throws Exception {
		request.setServletPath("/addUser");
		request.addParameter("request", "{\"content\":{\"username\":\"5CFFFFFFF238FFFFFFB67547FFFFFFC223\",\"nickname\":\"测试a昵v称哦123\"},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		this.excuteAction(request, response);
	}
	
	@Test
	public void detailUserController() throws Exception {
		request.setServletPath("/detailUser");
		request.addParameter("request", "{\"content\":{\"username\":\"5CFFFFFFF238FFFFFFB67547FFFFFFC223\"},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		this.excuteAction(request, response);
	}
	
	@Test
	public void listUserController() throws Exception {
		request.setServletPath("/listUser");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		this.excuteAction(request, response);
	}
	@Test
	public void loginUserController() throws Exception {
		request.setServletPath("/loginUser");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		this.excuteAction(request, response);
	}
}
