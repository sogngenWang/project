package com.dream.service;

import java.util.List;

import com.dream.bean.Theme;

public interface ThemeService {

	List<Theme> listTheme(Theme theme);
	
	Theme detailTheme(Theme theme);

	int updateTheme(Theme theme);
	
	int deleteTheme(int uid);
	
	int addTheme(Theme theme);
	
	int countTheme(Theme theme);

	List<Theme> listThemeInclueCommentCount(Theme theme);
}
