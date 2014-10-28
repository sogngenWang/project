package junitbean;

import junitbase.JUnitControllerBase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dream.service.CommentService;

/**
 * action测试列子
 * 
 * @author wsg
 * 
 */
public class CommentControllerTestSuit extends JUnitControllerBase {
	@Autowired
	CommentService service;

	@Test
	public void addCommentController() throws Exception {
		request.setServletPath("/addComment");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		this.excuteAction(request, response);
	}
	
	@Test
	public void detailCommentController() throws Exception {
		request.setServletPath("/detailComment");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
		request.setMethod(RequestMethod.POST.toString());
		this.excuteAction(request, response);
	}
	
	@Test
	public void listCommentController() throws Exception {
		request.setServletPath("/listComment");
		request.addParameter("request", "{\"content\":{},\"head\":{\"brand\":\"HTC\",\"imei\":\"356871046099762\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Evo 3D GSM\",\"netype\":\"NETWORK_TYPE_WIFI\",\"platform\":\"Android\",\"release\":\"4.2.2\",\"sdk\":\"17\",\"serial\":\"HT22PV203276\",\"time\":\"2014-10-24 13:51:55,611\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"mac\":\"F4F26357424C5C61\"}");
	}
	
}
