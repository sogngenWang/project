package junitbean;

import junitbase.JUnitControllerBase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;

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
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setServletPath("/addUser");
		request.addParameter("request", "{\"content\":{\"username\":\"5CFFFFFFF238FFFFFFB67547FFFFFFC223\"},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		request.setMethod(RequestMethod.POST.toString());
		this.excuteAction(request, response);
		System.out.println(response.getContentAsString());
	}
	
	@Test
	public void detailUserController() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setServletPath("/detailUser");
		request.addParameter("request", "{\"content\":{\"username\":\"5CFFFFFFF238FFFFFFB67547FFFFFFC223\"},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		request.setMethod(RequestMethod.POST.toString());
		this.excuteAction(request, response);
		System.out.println(response.getContentAsString());
	}
	
	@Test
	public void listUserController() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setServletPath("/listUser");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		request.setMethod(RequestMethod.POST.toString());
		this.excuteAction(request, response);
		System.out.println(response.getContentAsString());
	}
	
}
