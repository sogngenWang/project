package com.dream.service;

import java.util.List;

import com.dream.bean.Registeractivity;

public interface RegisteractivityService {

	List<Registeractivity> listRegisteractivity(Registeractivity registeractivity);
	
	Registeractivity detailRegisteractivity(Registeractivity registeractivity);

	int updateRegisteractivity(Registeractivity registeractivity);
	
	int deleteRegisteractivity(int uid);
	
	int addRegisteractivity(Registeractivity registeractivity);
	
	int countRegisteractivity(Registeractivity registeractivity);
}
