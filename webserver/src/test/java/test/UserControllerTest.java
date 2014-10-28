package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dream.controller.UserController;
import com.dream.service.UserService;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath:applicationContext.xml",  "classpath:mybatis-config.xml", "classpath:com/dream/mapper/*" })
// "file:src/main/webapp/WEB-INF/spring-servlet.xml" })

public class UserControllerTest {
	private MockMvc mockMvc;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	// @Resource
	// private WebApplicationContext webApplicationContext;

	@Before
	public void before() throws Exception {
		MockitoAnnotations.initMocks(this); // 初始化mock对象
		Mockito.reset(userService); // 重置mock对象
		/*
		 * 如果要使用完全默认Spring Web Context, 例如不需要对Controller注入,则使用
		 * WebApplicationContext mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 */
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//		mockMvc = QMockMvcBuilders.standaloneSetup(userController).build();
	}

	/**
	 * 课程分类管理测试
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCategoryManage() throws Exception {
		// 构建测试数据
//		Category c1 = new CategoryBuilder().id(1).name("cat1").build();
//		Category c2 = new CategoryBuilder().id(2).name("cat2").build();

		// 定义方法行为
//		when(mockCategoryService.fetchAllCategories()).thenReturn(
//				ImmutableList.of(c1, c2));

		// 构造http请求及期待响应行为
//		mockMvc.perform(get("/listUser"))
//				.andDo(print())
//				// 输出请求和响应信息
//				.andExpect(status().isOk());
//		verify(mockCategoryService, times(1)).fetchAllCategories();
//		verifyNoMoreInteractions(mockCategoryService);
	}
}
