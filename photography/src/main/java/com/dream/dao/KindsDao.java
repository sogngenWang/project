package com.dream.dao;

import java.util.List;

import com.dream.bean.Kinds;

public interface KindsDao {
	
	Kinds detailKinds(Kinds kinds);

	List<Kinds> listKinds(Kinds kinds);

	Kinds updateKinds(Kinds kinds);

	void addKinds(Kinds kinds);

	void deleteKinds(Kinds kinds);
}
