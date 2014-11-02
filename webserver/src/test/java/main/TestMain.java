package main;

import junitbase.JUnitControllerBase;
import junitbase.JUnitTest;

import org.junit.Test;

public class TestMain extends JUnitControllerBase {

	@Test
	public void test() throws Exception {
		JUnitTest test = new JUnitTest();
//		test.Test("resetPasswdUserController");
//		test.Test("findbackUserController");
//		test.Test("registerUserController");
//		test.Test("loginUserController");
//		test.Test("addActivityController");
//		test.Test("listActivityController");
		test.Test("detailActivityController");
//		test.Test("listActivityvipController");
//		test.Test("detailCommentController");
//		test.Test("	detailPraiseController");
//		test.Test("detailUserinfoController");
//		test.Test("addCommentController");
//		test.Test("listCommentController");
//		test.Test("addUserController");
//		test.Test("detailUserController");
//		test.Test("listThemeController");
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
