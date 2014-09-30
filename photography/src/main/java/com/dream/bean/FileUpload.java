package com.dream.bean;

import org.springframework.stereotype.Repository;

@Repository(value = "fileUpload")
public class FileUpload {

	private String fileNewName;

	private String filePath;

	public String getFileNewName() {
		return fileNewName;
	}

	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
