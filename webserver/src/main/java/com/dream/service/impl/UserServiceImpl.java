package com.dream.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.basebean.PageBase;
import com.dream.bean.Friends;
import com.dream.bean.Registeractivity;
import com.dream.bean.User;
import com.dream.constants.Constant;
import com.dream.dao.UserMapper;
import com.dream.service.FriendsService;
import com.dream.service.RegisteractivityService;
import com.dream.service.UserService;
import com.dream.utils.CommonUtils;

@Repository(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao;
	@Autowired
	private RegisteractivityService registeractivityService;
	@Autowired
	private FriendsService friendsService;
	

	@Override
	public List<User> listUser(User user) {

		return userDao.listUser(user);
	}

	@Override
	public User detailUser(User user) {

		return userDao.detailUser(user);
	}

	@Override
	public int updateUser(User user) {

		return userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public int deleteUser(int uid) {

		return userDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addUser(User user) {

		return userDao.insert(user);

	}

	@Override
	public int countUser(User user) {

		return userDao.countUser(user);
	}

	@Override
	public int updateByTelephone(User user) {
		
		return userDao.updateByTelephone(user);
	}

	@Override
	public int addNormalUser(User user) {
		//设置用户状态等等
		user.setIsactive(Constant.USER_ACTIVE);
		user.setRegistertime(CommonUtils.getSYSDate());
		user.setType(Constant.USER_NORMAL_TYPE);
		return userDao.insert(user);
	}

	@Override
	public User loginUser(User user) {

		user.setIsactive(Constant.USER_ACTIVE);
		user.setType(Constant.USER_NORMAL_TYPE);
		
		user = userDao.detailUser(user);
		
		return user;
	}

	@Override
	public User detailUserForFriends(Friends friendsTmp) {
		User user = new User();
		user.setUserid(friendsTmp.getFriendid());
		user = userDao.detailUser2Friends(user);
		
		return user;
	}

	@Override
	public List<User> listOnceUser(User user, PageBase pageBase) {
		Integer userid = user.getUserid();
		Set<Integer> useridSet = new HashSet<Integer>();
		List<User> userList = new ArrayList<User>();
		// 先咧出所有参加过的活动的id
		Registeractivity registeractivity = new Registeractivity();
		registeractivity.setSignstatus(Constant.REGISTERACTIVITY_SIGN);
		registeractivity.setUserid(user.getUserid());
		List<Registeractivity> registeractivitiesOwnList = registeractivityService.listRegisteractivity(registeractivity);
		List<Registeractivity> registeractivitiesOthersList = null;
		for (Registeractivity registeractivityTmp : registeractivitiesOwnList) {			
			//查询每个活动id，有签到过的用户的id
			registeractivity.setUserid(null);
			registeractivity.setActivityid(registeractivityTmp.getActivityid());
			
			registeractivitiesOthersList = registeractivityService.listRegisteractivity(registeractivity);
			for (Registeractivity registeractivityOthersTmp : registeractivitiesOthersList) {
				if(registeractivityOthersTmp.getUserid() != userid) {
					useridSet.add(registeractivityOthersTmp.getUserid());
				}
			}
		}
		List<Object> objList = Arrays.asList(useridSet.toArray());
		List<?>  returnUseridList = CommonUtils.createListPage(objList,pageBase);
		//运行到这里，set里存放的即是所有的一度人脉的用户
		for (Object object : returnUseridList) {
			user.setUserid((Integer)object);
			User newUser = userDao.detailUser2Friends(user);
			//查询该好友与本人的关系|已经是好友，待确认中还是未添加状态
			Friends friends = new Friends();
			//该id为自身id
			friends.setUserid(userid);
			//该id为好友id
			friends.setFrienduserid(user.getUserid());
			friends = friendsService.detailFriendsStatus(friends);
			newUser.setIsbefriend(friends == null ? null : friends.getIsbefriend());
			userList.add(newUser);
			
		}
		
		return userList;
	}

}
