package com.dream.weddingexpo.action;

import java.io.InputStream;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public class DownloadAction extends ActionSupport {
	
	public static final Log LOG = LogFactory.getLog(DownloadAction.class);
	private static final long serialVersionUID = 1L;
	
	private String fileName ;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public InputStream getDownloadFile() throws Exception {  
		//getDownloadFile()方法返回的必须是InputStream。getResourceAsStream()方法可以通过流的方式将资源输出
		 if(StringUtils.isBlank(fileName)){
			LOG.error("getDownloadFile | filename is null  ");
			return null;
		 }
		 HttpServletRequest request = ServletActionContext.getRequest();
		 request.setCharacterEncoding("utf8");
		 fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		 LOG.info("fileName="+fileName);
		 LOG.info("getDownloadFile | "+ServletActionContext.getServletContext().getContextPath()+"/text/association/"+fileName);
		 
		 return ServletActionContext.getServletContext().getResourceAsStream("/text/association/"+fileName);  
	}
	

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
