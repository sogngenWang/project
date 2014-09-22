package com.dreamheaven.at.service;

import java.util.List;

import com.dreamheaven.at.domain.At;

public interface AtService {
	
	List<At> queryAt(At at);
	
	void createAt(At at);

	void deleteAt(At at);
}
