package com.dream.weddingexpo.service.impl;

import java.util.List;

import com.dream.weddingexpo.bean.ProjectFile;
import com.dream.weddingexpo.dao.ProjectFileDao;
import com.dream.weddingexpo.service.ProjectFileService;

public class ProjectFileServiceImpl implements ProjectFileService {
	
	private ProjectFileDao projectFileDao;
	
	public ProjectFileDao getProjectFileDao() {
		return projectFileDao;
	}

	public void setProjectFileDao(ProjectFileDao projectFileDao) {
		this.projectFileDao = projectFileDao;
	}

	@Override
	public void addProjectFile(ProjectFile projectFile){
		
	}

	@Override
	public List<ProjectFile> listProjectFile(ProjectFile projectFile) {
		List<ProjectFile> projectFileList = projectFileDao.projectFileList(projectFile);
		
		return projectFileList;
	}

	@Override
	public ProjectFile detailProjectFile(ProjectFile projectFile) {
		projectFile = projectFileDao.detailProjectFile(projectFile);
		return projectFile;
	}

	@Override
	public List<ProjectFile> listProjectFileNoContent(ProjectFile projectFile) {
		List<ProjectFile> projectFileList = projectFileDao.projectFileList(projectFile);
		return projectFileList;
	}

	@Override
	public void deleteProjectFile(ProjectFile projectFile) {
		projectFileDao.deleteProjectFile(projectFile);
	}

	@Override
	public ProjectFile updateProjectFile(ProjectFile projectFile) {
		
		return projectFileDao.updateProjectFile(projectFile);
	}


	
	

}
