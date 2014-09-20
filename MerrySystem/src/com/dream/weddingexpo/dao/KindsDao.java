package com.dream.weddingexpo.dao;

import java.util.List;

import com.dream.weddingexpo.bean.Kinds;

public interface KindsDao {
	
	List<Kinds> kindsList(Kinds kinds);

	Kinds detailKinds(Kinds kinds);

	void deleteKinds(Kinds kinds);

	Kinds updateKinds(Kinds kinds);
	
	void addKinds(Kinds kinds);
	
}
