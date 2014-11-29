package com.dream.weddingexpo.action;

import org.springframework.context.annotation.Scope;

import com.dream.weddingexpo.bean.ProjectFile;
import com.dream.weddingexpo.service.ProjectFileService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public class ProjectFileAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectFile projectFile;
	private ProjectFileService projectFileService;

	public ProjectFileService getProjectFileService() {
		return projectFileService;
	}

	public void setProjectFileService(ProjectFileService projectFileService) {
		this.projectFileService = projectFileService;
	}

	public ProjectFile getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(ProjectFile projectFile) {
		this.projectFile = projectFile;
	}

}
