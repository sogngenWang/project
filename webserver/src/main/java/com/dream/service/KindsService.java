package com.dream.service;

import java.util.List;

import com.dream.bean.Kinds;

public interface KindsService {

	List<Kinds> listKinds(Kinds kinds);
	
	Kinds detailKinds(Kinds kinds);

	int updateKinds(Kinds kinds);
	
	int deleteKinds(int uid);
	
	int addKinds(Kinds kinds);
	
	int countKinds(Kinds kinds);
}
