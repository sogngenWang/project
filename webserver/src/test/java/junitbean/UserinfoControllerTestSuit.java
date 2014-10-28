package junitbean;

import junitbase.JUnitControllerBase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dream.service.UserinfoService;

/**
 * action测试列子
 * 
 * @author wsg
 * 
 */
public class UserinfoControllerTestSuit extends JUnitControllerBase {
	@Autowired
	UserinfoService service;

	@Test
	public void addUserinfoController() throws Exception {
		request.setServletPath("/addUserinfo");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		this.excuteAction(request, response);
	}
	
	@Test
	public void detailUserinfoController() throws Exception {
		request.setServletPath("/detailUserinfo");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		this.excuteAction(request, response);
	}
	
	@Test
	public void listUserinfoController() throws Exception {
		request.setServletPath("/listUserinfo");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		this.excuteAction(request, response);
	}
	
}
