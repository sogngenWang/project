package com.dreamheaven.dao;

import java.util.List;

import com.dreamheaven.domain.Manu;



public interface ManuDao {

	int countManu(Manu Manu);

	void deleteManu(Manu Manu);

	void createManu(Manu Manu);
	
	void updateManu(Manu Manu);
	
	Manu detailManu(Manu Manu);
	
	List<Manu> queryManu(Manu Manu) ;
	
	
}
