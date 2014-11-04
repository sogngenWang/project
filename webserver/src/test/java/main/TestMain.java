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
		//话题页面——列出所有的该活动的话题 | 1.分页 
//		test.Test("listThemeController");
		

//		test.Test("addActivityController");
//		test.Test("listActivityController");
//		test.Test("detailActivityController");
//		test.Test("detailCommentController");
//		test.Test("detailPraiseController");
//		test.Test("detailUserinfoController");
//		test.Test("addCommentController");
//		test.Test("listCommentController");
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
