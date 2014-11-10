package com.dream.listerner;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dream.annotation.ScanPackage;

@ScanPackage("com.dream.controller")
public class AppStartListener implements ServletContextListener {
	
	public static final Log LOG = LogFactory.getLog(AppStartListener.class);
	public static Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			getClasses();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	/**
	 * 从包package中获取所有的Class
	 * 
	 * @param pack
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void getClasses() throws ClassNotFoundException, IOException {
		// 从奔雷的注解中获取
		ScanPackage scanPackage = AppStartListener.class.getAnnotation(ScanPackage.class);
		String pack = scanPackage.value();
		// 获取包的名字 并进行替换
		String packageName = pack;
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things
		Enumeration<URL> dirs;
		dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
		// 循环迭代下去
		while (dirs.hasMoreElements()) {
			// 获取下一个元素
			URL url = dirs.nextElement();
			// 得到协议的名称
			String protocol = url.getProtocol();
			// 如果是以文件的形式保存在服务器上
			if ("file".equals(protocol)) {
				// 获取包的物理路径
				String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
				// 以文件的方式扫描整个包下的文件 并添加到集合中
				File file = new File(filePath);
				String[] fileList = file.list();
				for (String fileName : fileList) {
					// 获得类
					Class<?> clazz = Class.forName(pack + "." + fileName.substring(0, fileName.lastIndexOf(".")));
					// 获取该类的所有方法
					Method[] methods = clazz.getDeclaredMethods();
					for (Method method : methods) {
						LOG.info("methodName="+method.getName()+"|||classname="+clazz);
						classMap.put(method.getName(), clazz);
					}
				}
			}
		}

	}

}
