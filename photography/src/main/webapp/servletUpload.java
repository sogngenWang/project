package com.sean.filecenter.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax
.servlet.http.Part;

import org.apache.avro.AvroRemoteException;
import org.apache.log4j.Logger;

import com.sean.common.util.TimeUtil;
import com.sean.config.core.Config;
import com.sean.ds.pool.FixedPool;
import com.sean.ds.service.ServiceSubscriber;
import com.sean.filecenter.constant.L;
import com.sean.log.core.LogFactory;
import com.sean.usercenter.api.UserService;

/**
 * �ϴ��ļ�Servlet
 * @author sean
 */
@WebServlet(name = "UploadFileServlet", urlPatterns = "/UploadFileServlet")
@MultipartConfig(locati
on = "/", maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)
public class UploadFileServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private static String SAVE_PATH = "/data/";
	private static final Logger logger = LogFactory.getLogger(L.FileCenter);
	static
	{
		try
		{
			InputStream is = UploadFileServlet.class.getResourceAsStream("/config.properties");
			Properties props = new Properties();
			props.load(is);
			is.close();
			SAVE_PATH = props.getProperty
("upload.path");
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.setCharacterEncoding("utf-8");
			String sid = request.getParameter("sid");
			String filename = request.getParameter("filename");
			if (sid != null && !sid.isEmpty() && filename != null && !filename.isEmpty())
			{
				long userId = this.getUserId(sid);
				if (userId 
!= 0)
				{
					Part part = request.getPart("file");

					// ����Ŀ¼
					filename = this.getTargetName(userId, filename);
					part.write(filename);

					String json = "{'state':'Success', data:{'url':'$(url)'}}";
					String filepath = filename.substring(filename.indexOf("filecenter") + 10);

					json = json.replace("$(url)", filepath);
					PrintWriter pw = response.getWriter();
					pw.write(json);
					pw.flush();
					pw.close();

					logger.debug("�û�: " + userId + " �ϴ��ļ� : " + json);
				}
			}
		}

		catch (Exception e)
		{
			logger.error("�ϴ��ļ�����: " + e.getMessage(), e);

			String json = "{'state':'Failure'}";
			PrintWriter pw = response.getWriter();
			pw.write(json);
			pw.flush();
			pw.close();
		}
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException
	{
		try
		{
			Config.readConfiguration();
			ServiceSubscriber.subscribeService(UserService.class, new FixedPool(5));
		}
		catch (Exception e)
		{
			logger.error("�ļ����ĳ�ʼ��servlet����: " + e.getMessage(), e);
		}
	}

	/**
	
 * ��sid��ȡ�û�ID
	 * @param sid
	 * @return
	 * @throws AvroRemoteException 
	 * @throws TException 
	 */
	private long getUserId(String sid) throws Exception
	{
		UserService userService = ServiceSubscriber.getServiceClient(UserService.class);
		return userService.getUserId(sid);
	}

	/**
	 * ��ȡĿ���ļ������޺�׺ /savepath/partition/userId/year/time/attach/time_filename
	 * @param userId
	 */
	private String getTargetName(long userId, String filename)
	{
		StringBuilder path = new StringBuilder(SAVE_PATH);
		this.conf
irm(path.toString());

		// ����2048������������: hash(userId, 2048)
		long partition = userId % 2048;
		path.append(String.valueOf(partition)).append("/");
		this.confirm(path.toString());

		path.append(String.valueOf(userId)).append("/");
		this.confirm(path.toString());

		path.append(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))).append("/");
		this.confirm(path.toString());

		path.append(String.valueOf(TimeUtil.getYYYYMMDDLong())).append("/");
		this.confirm(path.toString());

		path.append("attach/");
		this.confirm(path.toString());

		return path.append(String.valueOf(System.currentTimeMillis())).append('_').append(filename).toString();
	}

	/**
	 * ȷ���ļ��д���
	 * @param path
	 */
	private void confirm(String path)
	{
		File file = new File(path);
		if (!file.exists())
		{
			file.mkdir();
		}
		else if (file.isFile())
		{
			file.delete();
			file.mkdir();
		}
		file = null;
	}
}
