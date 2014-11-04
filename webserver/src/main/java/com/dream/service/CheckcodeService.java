package com.dream.service;

import java.util.List;

import com.dream.bean.Checkcode;

public interface CheckcodeService {

	List<Checkcode> listCheckcode(Checkcode checkcode);
	
	Checkcode detailCheckcode(Checkcode checkcode);

	int updateCheckcode(Checkcode checkcode);
	
	int deleteCheckcode(int uid);
	
	int addCheckcode(Checkcode checkcode);
	
	int countCheckcode(Checkcode checkcode);

	String addCheckcodeAndSendMobile(String telephone);
}
