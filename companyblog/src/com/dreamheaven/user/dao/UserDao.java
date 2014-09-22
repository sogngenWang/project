package com.dreamheaven.user.dao;

import java.util.List;

import com.dreamheaven.user.domain.User;

public interface UserDao {
	
		List<User> searchUser(User user);
		
		void update(User user);
		
		void delete(User user);
		
		void create(User user);
		
		int count(User user);

		User detailUser(User user);
}
