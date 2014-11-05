package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Activity;
import com.dream.bean.Comment;
import com.dream.bean.Praise;
import com.dream.bean.Registeractivity;
import com.dream.bean.Theme;
import com.dream.constants.Constant;
import com.dream.dao.ActivityMapper;
import com.dream.dao.CommentMapper;
import com.dream.dao.PraiseMapper;
import com.dream.dao.RegisteractivityMapper;
import com.dream.dao.ThemeMapper;
import com.dream.service.ActivityService;

@Repository(value = "activityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityMapper activityDao;
	@Autowired
	private PraiseMapper praiseDao;
	@Autowired
	private CommentMapper commentDao;
	@Autowired
	private ThemeMapper themeDao;
	@Autowired
	private RegisteractivityMapper registeractivityDao; 
	
	

	@Override
	public List<Activity> listActivity(Activity activity) {

		return activityDao.listActivity(activity);
	}

	@Override
	public Activity detailActivity(Activity activity) {
		return activityDao.detailActivity(activity);
	}

	@Override
	public int updateActivity(Activity activity) {

		return activityDao.updateByPrimaryKeySelective(activity);
	}

	@Override
	public int deleteActivity(int uid) {

		return activityDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addActivity(Activity activity) {

		return activityDao.insert(activity);

	}

	@Override
	public int countActivity(Activity activity) {
		
		return activityDao.countActivity(activity);
		
	}

	@Override
	public Activity detailActivityPage(Activity activity) {
		//先从数据库中查询出该跳记录的详细信息
		activity = activityDao.detailActivity(activity);
		int commentCount = 0;
		int praiseCount = 0;
//		int caredegree = 0;
		int registerCount = 0;
		//计算评论数量
		//先计算该活动所拥有的话题，然后分别计算每个话题下有多少个评论
		Theme theme = new Theme();
		theme.setActivityid(activity.getActivityid());
		Comment comment = new Comment();
		List<Theme> themeList = themeDao.listTheme(theme);
		for(Theme themeTmp : themeList){
			comment.setThemeid(themeTmp.getThemeid());
			commentCount+=commentDao.countComment(comment);
		}
		//计算点赞数量
		Praise praise = new Praise();
		praise.setOtherid(activity.getActivityid());
		praise.setPraisetype(Constant.PRAISE_TYPE_ACTIVITY);
		praiseCount = praiseDao.countPraise(praise);
		//判断用户是否已经点赞
		praise = new Praise();
		praise.setUserid(activity.getUserid());
		praise.setOtherid(activity.getActivityid());
		praise.setPraisetype(Constant.PRAISE_TYPE_ACTIVITY);
		if(null != praiseDao.detailPraise(praise)){
			activity.setIsuserpraise(Constant.USER_ACTIVITY_HAS_PRAISE);
		}else{
			activity.setIsuserpraise(Constant.USER_ACTIVITY_NOT_PRAISE);
		}
		
		//TODO 计算关注度  关注度暂时仅仅使用评论的50%+点赞的50%
//		caredegree = (int) (commentCount * 1.0 / 2 + praiseCount * 1.0 / 2);
		
		//设置已经报名人数 
		Registeractivity registeractivity = new Registeractivity();
		registeractivity.setActivityid(activity.getActivityid());
		registerCount = registeractivityDao.countRegisteractivity(registeractivity);
		
		//设置活动头图片位置
		activity.setActivitypicture(activity.getActivitypicturedir()+Constant.ACTIVITY_PICTURE_HEADER_NAME);
		activity.setActivitypicturedir(null);
		//活动的具体信息不返回
		activity.setActivitydetail(null);		
		activity.setCommentcount(commentCount);
		activity.setPraisecount(praiseCount);
//		activity.setCaredegree(caredegree);
		activity.setRegistercount(registerCount);
		activity.setViewcount(activity.getViewcount()+1);
		// 每次查询完，都需要把该活动的查阅数+1
		activityDao.addActivityViewcount(activity);
		
		return activity;
	}

	@Override
	public boolean isRegistering(Integer activityid) {
		Activity activity = new Activity();
		activity.setActivityid(activityid); 
		activity = activityDao.detailActivity(activity);
		if(null != activity && Constant.ACTIVITY_REGISTER_STATUS.equals(activity.getActivitystatus())){
			return true;
		}
		return false;
	}
	
}
