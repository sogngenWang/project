package com.dream.weddingexpo.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public class DownloadAction extends ActionSupport {

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
		 if(null == fileName){
			 fileName = "join";
		 }
		 return ServletActionContext.getServletContext().getResourceAsStream("/text/association/"+fileName);  
	}
	

	@Override
	public String execute() throws Exception {
		System.out.println(fileName+"***********");
		return SUCCESS;
	}
}
