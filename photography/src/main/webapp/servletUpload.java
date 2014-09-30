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
import javax.servlet.http.Part;

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
 * 
 * @author sean
 */
@WebServlet(name = "UploadFileServlet", urlPatterns = "/UploadFileServlet")
@MultipartConfig(location = "/", maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String SAVE_PATH = "/data/";
	private static final Logger logger = LogFactory.getLogger(L.FileCenter);

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String sid = request.getParameter("sid");
			String filename = request.getParameter("filename");
			if (sid != null && !sid.isEmpty() && filename != null
					&& !filename.isEmpty()) {
				long userId = this.getUserId(sid);
				if (userId != 0) {
					Part part = request.getPart("file");

					// ����Ŀ¼
					filename = this.getTargetName(userId, filename);
					part.write(filename);

					String json = "{'state':'Success', data:{'url':'$(url)'}}";
					String filepath = filename.substring(filename
							.indexOf("filecenter") + 10);

					json = json.replace("$(url)", filepath);
					PrintWriter pw = response.getWriter();
					pw.write(json);
					pw.flush();
					pw.close();

					logger.debug("�û�: " + userId + " �ϴ��ļ� : " + json);
				}
			}
		}

		catch (Exception e) {
			
		}
	}
}
