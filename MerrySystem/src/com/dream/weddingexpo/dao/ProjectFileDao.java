package com.dream.weddingexpo.dao;

import java.util.List;

import com.dream.weddingexpo.bean.ProjectFile;

public interface ProjectFileDao {
	
	List<ProjectFile> projectFileList(ProjectFile projectFile);

	ProjectFile detailProjectFile(ProjectFile projectFile);

	void addProjectFile(ProjectFile projectFile);

	void deleteProjectFile(ProjectFile projectFile);

	ProjectFile updateProjectFile(ProjectFile projectFile);

}
