package com.dream.service;

import java.util.List;

import com.dream.bean.Onlinequestion;

public interface OnlinequestionService {

	List<Onlinequestion> listOnlinequestion(Onlinequestion onlinequestion);
	
	Onlinequestion detailOnlinequestion(Onlinequestion onlinequestion);

	int updateOnlinequestion(Onlinequestion onlinequestion);
	
	int deleteOnlinequestion(int uid);
	
	int addOnlinequestion(Onlinequestion onlinequestion);
	
	int countOnlinequestion(Onlinequestion onlinequestion);
}
