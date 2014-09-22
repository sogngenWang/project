package com.dreamheaven.at.dao;

import java.util.List;

import com.dreamheaven.at.domain.At;

public interface AtDao {
	
	List<At> queryAt(At at);
	
	void createAt(At at);

	void deleteAt(At at);
	
}
