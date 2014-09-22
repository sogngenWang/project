package com.dreamheaven.dao;

import java.util.List;

import com.dreamheaven.domain.User;



public interface UserDao {

	int countUser(User user);

	void deleteUser(User user);

	void createLogin(User user);
	
	User detailUser(User user);
	
	List<User> queryUser(User user) ;

	void updateUser(User user);
	
}
