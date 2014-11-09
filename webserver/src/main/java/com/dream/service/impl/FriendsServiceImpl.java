package com.dream.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.basebean.PageBase;
import com.dream.bean.Activity;
import com.dream.bean.Friends;
import com.dream.bean.Registeractivity;
import com.dream.bean.User;
import com.dream.constants.Constant;
import com.dream.dao.FriendsMapper;
import com.dream.exception.BussinessException;
import com.dream.service.ActivityService;
import com.dream.service.FriendsService;
import com.dream.service.RegisteractivityService;
import com.dream.service.UserService;
import com.dream.utils.CommonUtils;

@Repository(value = "friendsService")
public class FriendsServiceImpl implements FriendsService {

	@Autowired
	private FriendsMapper friendsDao;
	@Autowired
	private UserService userService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private RegisteractivityService registeractivityService;

	@Override
	public List<Friends> listFriends(Friends friends) {

		return friendsDao.listFriends(friends);
	}

	@Override
	public Friends detailFriends(Friends friends) {

		return friendsDao.detailFriends(friends);
	}

	@Override
	public int updateFriends(Friends friends) {

		return friendsDao.updateByPrimaryKeySelective(friends);
	}

	@Override
	public int deleteFriends(int uid) {

		return friendsDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addFriends(Friends friends) {

		return friendsDao.insert(friends);

	}

	@Override
	public int countFriends(Friends friends) {

		return friendsDao.countFriends(friends);
	}

	@Override
	public List<Friends> listSendFriends(Friends friends, PageBase pageBase) {
		
		List<Friends> friendsList = friendsDao.listFriends(friends);
		List<?> friends4Return = CommonUtils.createListPage(friendsList, pageBase);
		friendsList = new ArrayList<Friends>();
		for (Object object : friends4Return) {
			//对象转换
			Friends friendsTmp = (Friends)object;
			User user = new User();
			user.setUserid( friendsTmp.getFrienduserid());
			user = userService.detailUserForFriends(friendsTmp);
			//需要返回的有：
			//好友userid，好友username，好友公司，好友职位，时间(生成这条记录的时间)，状态(已添加，拒绝，等待验证)|好友头像地址
			
			friendsTmp.setUsername(user.getUsername());
			friendsTmp.setCompany(user.getCompany());
			friendsTmp.setPosition(user.getPosition());
			
			friendsList.add(friendsTmp);
			
		}
		return friendsList;
	}


	@Override
	public List<Friends> listReceiveFriends(Friends friends, PageBase pageBase) {
		
		List<Friends> friendsList = friendsDao.listFriends(friends);
		List<?> friends4Return = CommonUtils.createListPage(friendsList, pageBase);
		friendsList = new ArrayList<Friends>();
		for (Object object : friends4Return) {
			//对象转换
			Friends friendsTmp = (Friends)object;
			User user = new User();
			user.setUserid(friendsTmp.getUserid());
			user = userService.detailUserForFriends(friendsTmp);
			//需要返回的有：
			//好友userid，好友username，好友公司，好友职位，时间(生成这条记录的时间)，状态(已添加，拒绝，等待验证)|好友头像地址
			
			friendsTmp.setUsername(user.getUsername());
			friendsTmp.setCompany(user.getCompany());
			friendsTmp.setPosition(user.getPosition());
			
			friendsList.add(friendsTmp);
			
		}
		return friendsList;
	}

	@Override
	public Activity addANewFriends(Friends friends) throws BussinessException {
		// 判断是否有添加还有的先决条件，即是否一起报名参加过某个活动
		//list用户参加过的所有活动
//		Registeractivity registeractivity = new Registeractivity();
//		registeractivity.setUserid(friends.getUserid());
//		registeractivity.setSignstatus(Constant.REGISTERACTIVITY_SIGN);
//		List<Registeractivity> registeractivityList = registeractivityService.listRegisteractivity(registeractivity);
//		StringBuffer sb = new StringBuffer();
//		for (Registeractivity registeractivityTmp : registeractivityList) {
//			sb.append(Constant.TAB);
//			sb.append(registeractivityTmp.getActivityid());
//			sb.append(Constant.TAB);
//		}
//		String userListStr = sb.toString();
//		//list所添加的好友参加过的所有活动
//		registeractivity.setUserid(friends.getFrienduserid());
//		registeractivityList = registeractivityService.listRegisteractivity(registeractivity);
//		//判断两个list中是否至少有一个/一个以上相同的
//		for (Registeractivity registeractivityTmp : registeractivityList) {
//			if(userListStr.contains(Constant.TAB+registeractivityTmp.getActivityid()+Constant.TAB)){
//				//给好友发送添加好友的请求
//				friends.setAccesstime(CommonUtils.getSYSDate());
//				friends.setIsbefriend(Constant.FRIENDS_NOT_CONFIRM);
//				friendsDao.insert(friends);
//				//查询活动名字并返回
//				Activity activityTmp =  new Activity();
//				activityTmp.setActivityid(registeractivityTmp.getActivityid());
//				Activity activity = activityService.detailActivity(activityTmp);
//				activityTmp.setActivityname(registeractivityTmp == null ? null : activity.getActivityname());
//				return activityTmp ;
//			}
//		}
		//如果返回空则说明没有交集
		Integer id = isIntersection(friends.getUserid(), friends.getFrienduserid());
		if(-1 != id){
			//给好友发送添加好友的请求
			friends.setAccesstime(CommonUtils.getSYSDate());
			friends.setIsbefriend(Constant.FRIENDS_NOT_CONFIRM);
			friendsDao.insert(friends);
			//查询活动名字并返回
			Activity activityTmp =  new Activity();
			activityTmp.setActivityid(id);
			Activity activity = activityService.detailActivity(activityTmp);
			activityTmp.setActivityname(activity.getActivityname());
			return activityTmp ;
		}
		
		//相同的则发送请求，否则失败
		throw new BussinessException();
	}
	
	//判断两个人是否有交集，如果有返回一个有交集的活动id，如果没有则返回空
	public Integer isIntersection(Integer firstOneId , Integer SecondOneId){
		//list用户参加过的所有活动
		Registeractivity registeractivity = new Registeractivity();
		registeractivity.setSignstatus(Constant.REGISTERACTIVITY_SIGN);
		
		registeractivity.setUserid(firstOneId);
		List<Registeractivity> registeractivityListOne = registeractivityService.listRegisteractivity(registeractivity);
		registeractivity.setUserid(SecondOneId);
		List<Registeractivity> registeractivityListTwo = registeractivityService.listRegisteractivity(registeractivity);
		StringBuffer sb = new StringBuffer();
		for (Registeractivity registeractivityTmp : registeractivityListOne) {
			sb.append(Constant.TAB);
			sb.append(registeractivityTmp.getActivityid());
			sb.append(Constant.TAB);
		}
		String userListStr = sb.toString();
		for (Registeractivity registeractivityTmp : registeractivityListTwo) {
			if(userListStr.contains(Constant.TAB+registeractivityTmp.getActivityid()+Constant.TAB)){
				return registeractivityTmp.getActivityid();
			}	
		}
		return -1;
		
	}

	
	@Override
	public void manageFriendsAdd(Friends friends) {
		//同意/拒绝好友
		friendsDao.updateFriendsStatus(friends);
	}

	@Override
	public List<User> listAllFriends(Friends friends,PageBase pageBase) {
		Integer userid = friends.getUserid();
		List<Integer> userListStr = new ArrayList<Integer>();
		List<User> userList = new ArrayList<User>();
		
		
		friends.setIsbefriend(Constant.FRIENDS_BE_FRIENDS);
		friends.setFrienduserid(null);
		List<Friends> friendsList = friendsDao.listFriends(friends);
		for (Friends friendsTmp : friendsList) {
			userListStr.add(friendsTmp.getFrienduserid());
//			User user = new User();
//			user.setUserid(friendsTmp.getFrienduserid());
//			userTmp = userService.detailUser(user);
//			user.setUsername(userTmp.getUsername());
//			user.setCompany(user.getCompany());
//			user.setPosition(user.getPosition());
//			userList.add(user);
		}
		friends.setUserid(null);
		friends.setFrienduserid(userid);
		friendsList = friendsDao.listFriends(friends);
		for (Friends friendsTmp : friendsList) {
			userListStr.add(friendsTmp.getUserid());
//			User user = new User();
//			user.setUserid(friendsTmp.getUserid());
//			userTmp = userService.detailUser(user);
//			user.setUsername(userTmp.getUsername());
//			user.setCompany(user.getCompany());
//			user.setPosition(user.getPosition());
//			userList.add(user);
		}
		Friends friendsTmp = new Friends();
		List<?> returnList = CommonUtils.createListPage(userListStr, pageBase);
		for (Object object : returnList) {
			Integer useridToQuery = (Integer)object;
			friendsTmp.setUserid(useridToQuery);
//			user.setUsername(userTmp.getUsername());
//			user.setCompany(user.getCompany());
//			user.setPosition(user.getPosition());
			userList.add(userService.detailUserForFriends(friendsTmp));
		}
		
		return userList;
	}

	@Override
	public Friends detailFriendsStatus(Friends friends) {
		//  根据传入的userid去查询
		Friends friendsTmp = null;
		Integer userid = friends.getUserid();
		Integer friendsid = friends.getFriendid();
		friendsTmp = friendsDao.detailFriends(friends);
		if(null == friendsTmp){
			//为空则判断另一种可能
			friends.setUserid(friendsid);
			friends.setUserid(userid);
			friendsTmp = friendsDao.detailFriends(friends);
//			也可能为空，空则不返回对象
//			if(null == friendsTmp){
//				
//			}
//			
//			return friendsTmp;
		}
		
		return friendsTmp;
	}
	
}
