package com.dream.service;

import java.util.List;

import com.dream.bean.Praise;

public interface PraiseService {

	List<Praise> listPraise(Praise praise);
	
	Praise detailPraise(Praise praise);

	int updatePraise(Praise praise);
	
	int deletePraise(int uid);
	
	int addPraise(Praise praise);
	
}
