package com.dream.service;

import java.util.List;

import com.dream.bean.Registeractivity;
import com.dream.bean.User;

public interface RegisteractivityService {

	List<Registeractivity> listRegisteractivity(Registeractivity registeractivity);
	
	Registeractivity detailRegisteractivity(Registeractivity registeractivity);

	int updateRegisteractivity(Registeractivity registeractivity);
	
	int deleteRegisteractivity(int uid);
	
	int addRegisteractivity(Registeractivity registeractivity);
	
	int countRegisteractivity(Registeractivity registeractivity);

	int countRegisterSign(Registeractivity registeractivity);

	List<User> listRegisterSignUser(Registeractivity registeractivity);

	boolean isUserSign(Registeractivity registeractivity);

}
