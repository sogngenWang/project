package com.dream.weddingexpo.service;

import java.util.List;

import com.dream.weddingexpo.bean.ProjectFile;

public interface ProjectFileService {

	ProjectFile detailProjectFile(ProjectFile projectFile);

	List<ProjectFile> listProjectFile(ProjectFile projectFile);

	void addProjectFile(ProjectFile projectFile) ;
	
	List<ProjectFile> listProjectFileNoContent(ProjectFile projectFile);
	
	void deleteProjectFile(ProjectFile projectFile);

	ProjectFile updateProjectFile(ProjectFile projectFile);

}
