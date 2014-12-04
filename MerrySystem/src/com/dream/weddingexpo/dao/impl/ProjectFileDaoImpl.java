package com.dream.weddingexpo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dream.weddingexpo.bean.ProjectFile;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.ProjectFileDao;
import com.dream.weddingexpo.utils.CommonUtils;

public class ProjectFileDaoImpl implements ProjectFileDao {

	private Session session;
	private Criteria criteria;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public ProjectFileDaoImpl() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	private Map<String, String> getProjectFileParamMap(ProjectFile projectFile) {
		paramMap.put(Constants.MESSAGE_MESSAGEID, projectFile.getFileId());
		paramMap.put(Constants.MESSAGE_USERID, projectFile.getFileUrl());
		paramMap.put(Constants.MESSAGE_MESSAGECONTENTPATH, projectFile.getMapUrl());
		paramMap.put(Constants.MESSAGE_MESSAGETITLE, projectFile.getType());
		return paramMap;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectFile> projectFileList(ProjectFile projectFile) {
		criteria = session.createCriteria(projectFile.getClass());
		CommonUtils.setCriteria(getProjectFileParamMap(projectFile), criteria);
		
		List<ProjectFile> projectFileList = criteria.list();
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ProjectFile detailProjectFile(ProjectFile projectFile) {
		criteria = session.createCriteria(projectFile.getClass());
		CommonUtils.setCriteria(getProjectFileParamMap(projectFile), criteria);
		List<ProjectFile> projectFileList = criteria.list();
		if(null != projectFileList && !projectFileList.isEmpty()){
			return projectFileList.get(0);
		}
		
		return null;
	}

	@Override
	public void addProjectFile(ProjectFile projectFile) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		projectFile = (ProjectFile)session.merge(projectFile);
		session.save(projectFile);
		transaction.commit();
	}

	@Override
	public void deleteProjectFile(ProjectFile projectFile) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		projectFile = (ProjectFile)session.merge(projectFile);
		session.delete(projectFile);
		transaction.commit();
	}

	@Override
	public ProjectFile updateProjectFile(ProjectFile projectFile) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		projectFile = (ProjectFile)session.merge(projectFile);
		session.save(projectFile);
		transaction.commit();
		return projectFile;
	}


}
