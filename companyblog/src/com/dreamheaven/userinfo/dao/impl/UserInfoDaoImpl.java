package com.dreamheaven.userinfo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.userinfo.constant.UserInfoConstant;
import com.dreamheaven.userinfo.dao.UserInfoDao;
import com.dreamheaven.userinfo.domain.UserInfo;
import com.dreamheaven.userinfo.utils.UserInfoUtils;

public class UserInfoDaoImpl implements UserInfoDao {


	private Session session;
	
	private Map<String,String> paramMap = new HashMap<String,String>();
	
	public UserInfoDaoImpl()
	{
		session = HibernateSessionFactory.getSession();
	}
	
	private Map<String,String> getParamMap(UserInfo userInfo)
	{
		paramMap.put(UserInfoConstant.USERINFO_UID, userInfo.getUid());
		paramMap.put(UserInfoConstant.USERINFO_NICKNAME, userInfo.getNickName());
		paramMap.put(UserInfoConstant.USERINFO_AGE, userInfo.getAge());
		paramMap.put(UserInfoConstant.USERINFO_SEX, userInfo.getSex());
		paramMap.put(UserInfoConstant.USERINFO_BIRTHDAY, userInfo.getBirthday());
		paramMap.put(UserInfoConstant.USERINFO_HOBY, userInfo.getHoby());
		paramMap.put(UserInfoConstant.USERINFO_COMPANYID, userInfo.getCompanyId());
		paramMap.put(UserInfoConstant.USERINFO_HEADIMGPATH, userInfo.getHeadImgPath());
		
		return paramMap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> queryExceptUser(UserInfo userInfo) {
		//不仅仅除了自己，还要剔除掉已经收听过的人
//		UserInterest userInterest = new UserInterest();
//		Criteria criteria = session.createCriteria(userInfo.getClass());
//		criteria.add(Expression.ne(UserInfoConstant.USERINFO_UID, userInfo.getUid()));
		
		StringBuffer sql = new StringBuffer();
		sql=sql.append("select distinct t.nuid,t.snickname,t.nage,t.nsex,t.sbirthday,t.shoby,t.ncompanyid,t.sheadimgpath ")
				.append("from t_user_info t,t_User_Interest i ")
				.append("where t.nuid not in (select ti.nlistenedid  from t_user_interest ti where nuid = '"+userInfo.getUid()+"')")
				.append(" and t.nuid != '" + userInfo.getUid() + "' and t.ncompanyId ='" + userInfo.getCompanyId() + "' ");
		SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
		List<Object[]> tempList = sqlQuery.list();
		
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		
		try
		{
			for(Object[] objArrayTemp : tempList)
			{
				UserInfo userInfoTemp = new UserInfo();
				
				UserInfoUtils.copyPropertiesUserInfo(userInfoTemp, objArrayTemp);
				
				userInfoList.add(userInfoTemp);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		
//		Query queryForUserInterest = session.createQuery("select ti.UserInterestPK.listenedid from UserInterest ti  where ti.UserInterestPK.uid = ?");
//		queryForUserInterest.setString(0, userInfo.getUid());
//		List<UserInterest> userInterestList = queryForUserInterest.list();
//		
//		
//		Query queryForUserInfo = session.createQuery(" from UserInfo t where t.uid not in (" +
//				"select ti.listenedid from UserInterest ti  where ti.uid = ?" +
//				") and t.uid != ? ");
//		queryForUserInfo.setString(0, "1");
//		queryForUserInfo.setString(1, "1");
//		
//		
//		List<UserInfo> userInfoListTTT = queryForUserInfo.list();
//		
//		
//		List<UserInfo> userInfoListTemp = new ArrayList<UserInfo> ();
//		for(UserInfo UserInfoTemp : userInfoList)
//		{
//			UserInfo userInfoTest = new UserInfo();
//			
//			try {
//				
//				BeanUtils.copyProperties(userInfoTest, UserInfoTemp);
//				
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				e.printStackTrace();
//			}
//			
//			userInfoListTemp.add(userInfoTest);
//		}
		
		return userInfoList;
	}

	@Override
	public UserInfo detailUserInfo(UserInfo userInfo) {
		Criteria criteria = session.createCriteria(userInfo.getClass());
		CommonUtils.setCriteria(getParamMap(userInfo), criteria);
		
		if(null !=criteria.list() && criteria.list().size() > 0)
		{
			return (UserInfo) criteria.list().get(0);
		}
		
		return  null ;
	}

	@Override
	public void createUserInfo(UserInfo userInfo) {
		Transaction transaction = session.beginTransaction();
		userInfo = (UserInfo)session.merge(userInfo);
		session.save(userInfo);
		transaction.commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> queryUserInfo(UserInfo userInfo) {
		Criteria criteria = session.createCriteria(userInfo.getClass());
		CommonUtils.setCriteria(getParamMap(userInfo), criteria);
		return criteria.list();
	}


}
