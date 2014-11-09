package main;

import junitbase.JUnitControllerBase;
import junitbase.JUnitTest;

import org.junit.Test;

public class TestMain extends JUnitControllerBase {

	@Test
	public void test() throws Exception {
		JUnitTest test = new JUnitTest();
		//活动详情页——点击在线提问的时候，提交  | 分页
//		test.Test("listOnlinequestionController");
		//找回密码页面提交，会校验之前方法发送的短信验证码  
//		test.Test("resetPasswdUserController"); 
		//找回密码的时候，调用该方法，发送短信验证码
//		test.Test("findbackUserController");
		//注册新用户  TODO 1.通过注册用户的资料生成个人名片
//		test.Test("registerUserController");
		//用户登录
//		test.Test("loginUserController");
		//活动详情页——列出所有的活动嘉宾信息 | 分页   TODO 1.嘉宾是否需要头像图片 
//		test.Test("listActivityvipController");
		//活动详情页——已签到的用户数量
//		test.Test("countRegisterSignController");
		//活动详情页——已签到的用户列表  
//		test.Test("listRegisterSignUserController");
		//活动详情页——用户点赞操作 
//		test.Test("addActivityPraiseController");
		//注册新用户 —— 获取验证码并显示
//		test.Test("generateCheckcodeController");
		//某个具体的活动页面详细信息——活动页面的首页  TODO 需要解决活动状态要如何自动改变?还是人工改变?或者说，只有从预定状态到报名状态需要人工干涉，其他状态需要数据库存储过程自动实现吗?
//		test.Test("detailActivityController");
		//活动详情页——立即预定(TODO 状态改变成报名状态之后，提示用户?新建一个message表来提示消息)
		
		//活动详情页——立即报名 
//		test.Test("addRegisteractivityController");
		// 话题里面的评论也需要允许点赞
//		test.Test("addThemePraiseController");
		// TODO 总结功能额外做

		//话题页面——列出所有的该活动的话题 以及每个话题的评论总数| 分页  
//		test.Test("listThemeController");
		//活动详情页面——列出当前主题的所有评论，以及每个评论的点赞数量，对于每个评论都还需要返回自己是否已经点赞
//		test.Test("listCommentController");
		// 显示所有的未读消息|显示所有的消息
//		test.Test("listMessageController");
		//列出当前所有的活动,活动按照创建时间的倒序显示
//		test.Test("listActivityController");
		//显示某条消息，同时设置消息未已读状态
//		test.Test("detailMessageController");
		//添加好友| 添加的前提是两个人均参加过一个活动
//		test.Test("addANewFriendsController");
		//显示好友添加消息|我发送的消息
//		test.Test("listFriendsSendMessageController");
		//显示好友添加消息|我收到的消息
//		test.Test("listFriendsReceiveMessageController");
		//列出用户所有的好友
//		test.Test("listFriendsController");
		//列出一度人脉，对于还未加为好友的，无isbefriends值，需要前台进行判断
		test.Test("listOnceUserController");
		//处理好友添加消息，(同意1/拒绝2)
//		test.Test("manageFriendsAddController");
		//TODO 显示所有中奖信息
//		test.Test("");
		//TODO 显示 "我"界面,应该包含1.未读消息的数量2.未处理好友消息的数量3.我的活动数量4.我的话题数量5.抽奖结果——抽奖次数/中奖次数6.名片完善程度6.当前城市7.我的相关信息
//		test.Test("");
		
		
		
		
//		test.Test("addActivityController");
//		test.Test("detailCommentController");
//		test.Test("detailPraiseController");
//		test.Test("detailUserinfoController");
//		test.Test("addCommentController");
//		test.Test("addUserController");
//		test.Test("detailUserController");
//		test.Test("listPraiseController");
//		test.Test("listUserController");
//		test.Test("addPraiseController");
//		test.Test("detailThemeController");
//		test.Test("addThemeController");
//		test.Test("addUserinfoController");
//		test.Test("listUserinfoController");

	}

	
	
//	public static void main(String[] args) {
//		Method[] methods = ControllerTestSuit.class.getMethods();
//		for (int i = 0; i < methods.length; i++) {
//			if(methods[i].getName().endsWith("Controller"))
//			System.out.println("test.Test(\""+methods[i].getName()+"\");");
//		}
//	}
}
