package junitbase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

/**
 * JUnit测试action时使用的基类
 * 
 * @author wsg
 * 
 */
@SuppressWarnings("deprecation")
public class JUnitControllerBase {

	public static final Log LOG = LogFactory.getLog(JUnitControllerBase.class);
	
	private static HandlerMapping handlerMapping;
	private static HandlerAdapter handlerAdapter;
	
	//request response
	protected static MockHttpServletRequest request ;
	protected static MockHttpServletResponse response ;
	

	/**
	 * 读取配置文件
	 */
	@BeforeClass
	public static void setUp() {
		if (handlerMapping == null) {
			String[] configs = {
					"classpath:applicationContext.xml",
					"file:src/main/webapp/WEB-INF/spring-servlet.xml"
					};
			XmlWebApplicationContext context = new XmlWebApplicationContext();
			context.setConfigLocations(configs);
			MockServletContext msc = new MockServletContext();
			context.setServletContext(msc);
			context.refresh();
			msc.setAttribute( WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
			handlerMapping = (HandlerMapping) context.getBean(DefaultAnnotationHandlerMapping.class);
			handlerAdapter = (HandlerAdapter) context.getBean(context.getBeanNamesForType(AnnotationMethodHandlerAdapter.class)[0]);

		}
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		
		request.setMethod(RequestMethod.POST.toString());
	}
	
	/**
	 * 此方法在Test方法全部执行完毕之后才会调用
	 * @throws Exception 
	 */
	@AfterClass
	public static void after() throws Exception {
		LOG.info("******************************************************************************");
		LOG.info("******************************************************************************");
		//打印出返回报文内容
		LOG.info("response="+response.getContentAsString());
		LOG.info("******************************************************************************");
		LOG.info("******************************************************************************");
	}

	/**
	 * 执行request请求的action
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView excuteAction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 这里需要声明request的实际类型，否则会报错
		request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
		HandlerExecutionChain chain = handlerMapping.getHandler(request);
		ModelAndView model = null;
		try {
			model = handlerAdapter.handle(request, response, chain.getHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
