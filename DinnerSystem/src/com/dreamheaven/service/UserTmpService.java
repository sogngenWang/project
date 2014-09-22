package com.dreamheaven.service;

import java.util.List;

import com.dreamheaven.domain.UserTmp;

public interface UserTmpService {

	UserTmp detailUserTmp(UserTmp userTmp);

	boolean createUserTmp(UserTmp userTmp);

	boolean deleteUserTmp(UserTmp userTmp);

	boolean updateUserTmp(UserTmp userTmp);

	List<UserTmp> queryAllUsersTmps(UserTmp userTmp);

}
