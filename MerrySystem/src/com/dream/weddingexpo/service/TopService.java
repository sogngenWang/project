package com.dream.weddingexpo.service;

import java.util.List;

import com.dream.weddingexpo.bean.Top;

public interface TopService {

	Top detailTop(Top top);

	List<Top> listTop(Top top);

	void addTop(Top top) ;
	
	List<Top> listTopNoContent(Top top);
	
	void deleteTop(Top top);

	Top updateTop(Top top);

}
