package junitbase;

import java.lang.reflect.Method;

import junitbean.ControllerTestSuit;
import annotation.RequestParameter;
import annotation.RequestServletPath;

public class JUnitTest  extends JUnitControllerBase {
	
	/***
	 * 传入需要解析的类名，自动解析
	 * @param clazz
	 * @throws Exception
	 */
	public void Test(String methodName) throws Exception{
		Method m = ControllerTestSuit.class.getMethod(methodName);
		RequestServletPath requestServletPath = m.getAnnotation(RequestServletPath.class);
		request.setServletPath(requestServletPath.value());
		RequestParameter requestParameter = m.getAnnotation(RequestParameter.class);
		request.addParameter(requestParameter.name(), requestParameter.value());
		this.excuteAction(request, response);
	}
	
}
