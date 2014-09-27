<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IN ADMIN PANEL | Powered by INDEZINER</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/frontModule/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/frontModule/clockp.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/frontModule/clockh.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/frontModule/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/frontModule/ddaccordion.js"></script>
<script type="text/javascript">
ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='${pageContext.request.contextPath}/js/frontModule/images/plus.gif' class='statusicon' />", "<img src='${pageContext.request.contextPath}/js/frontModule/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/frontModule/jconfirmaction.jquery.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$('.ask').jConfirmAction();
	});
	
</script>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/frontModule/niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/js/frontModule/niceforms-default.css" />

</head>
<body>
	<div id="main_container">

		<div class="header">
			<!-- 标题栏logo -->
			<div class="logo">
				<a href="#"><img src="${pageContext.request.contextPath}/js/frontModule/images/logo.gif"
					alt="" title="" border="0" /></a>
			</div>
			<!-- 已登录用户以及用户注销 -->
			<div class="right_header">
				欢迎回来   Admin | <a href="#" class="logout">Logout</a>
			</div>
			<div id="clock_a"></div>
		</div>

		<!-- 标题栏 -->
		<div class="main_content">
			<div class="menu">
				<ul>
					<li><a class="current" href="${pageContext.request.contextPath}/js/frontModule/indexPage.jsp">用户管理</a>
					</li>
				</ul>
			</div>
			<div class="center_content">
				<div class="left_content">

					<div class="sidebarmenu">
						<a class="menuitem menuitem_green submenuheader" href="">用户管理</a>
						<div class="submenu">
							<ul>
								<li><a href="">用户查询</a></li>
								<li><a href="">用户添加</a></li>
								<li><a href="">用户修改</a></li>
								<li><a href="">用户删除</a></li>
							</ul>
						</div>
						<a class="menuitem menuitem_green submenuheader" href="">区域管理</a>
						<div class="submenu">
							<ul>
								<li><a href="">区域查询</a></li>
								<li><a href="">区域添加</a></li>
								<li><a href="">区域修改</a></li>
								<li><a href="">区域删除</a></li>
							</ul>
						</div>
						<a class="menuitem menuitem_green submenuheader" href="">商品管理</a>
						<div class="submenu">
							<ul>
								<li><a href="">商品查询</a></li>
								<li><a href="">商品添加</a></li>
								<li><a href="">商品修改</a></li>
								<li><a href="">商品删除</a></li>
							</ul>
						</div>
					</div>
					
					<div class="sidebar_box">
						<div class="sidebar_box_top"></div>
						<div class="sidebar_box_content">
							<h3>notice</h3>
							<img src="${pageContext.request.contextPath}/js/frontModule/images/info.png"
								alt="" title="" class="sidebar_icon_right" />
							<ul>
								<li>故障联系人:王松根</li>
								<li>联系电话:15159628259</li>
								<li>管理员须知:</li>
								<li>1.</li>
								<li>2.</li>
								<li>3.</li>
							</ul>
						</div>
						<div class="sidebar_box_bottom"></div>
					</div>
				</div>




				<div class="right_content">
					<div id="listUser" >
						<h2>用户查询</h2>
						<div class="sidebar_search">
							<form>
								<input type="text" name="" class="search_input"
									value="搜索用户" onclick="this.value=''" /> <input
									type="image" class="search_submit"
									src="${pageContext.request.contextPath}/js/frontModule/images/search.png" />
							</form>
						</div>
						<table id="rounded-corner">
							<thead>
								<tr>
									<th scope="col" class="rounded">用户名</th>
									<th scope="col" class="rounded">用户类型</th>
									<th scope="col" class="rounded">用户手机</th>
									<th scope="col" class="rounded">用户邮箱</th>
									<th scope="col" class="rounded">用户状态</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="username">admin</td>
									<td class="type">管理员</td>
									<td class="telephone">15159628259</td>
									<td class="email">wangsonggen@126.com</td>
									<td class="active">active</td>
								</tr>
							</tbody>
						</table>

						<!-- 分页 -->
						<div class="pagination">
							<span class="disabled"><< prev</span>
							<span class="current">1</span>
							<a href="">2</a>
							<a href="">3</a>
							<a href="">4</a>
							<a href="">5</a>
							...
							<a href="">10</a>
							<a href="">11</a>
							<a href="">12</a>
							...
							<a href="">100</a>
							<a href="">101</a>
							<a href="">next >></a>
						</div>

					</div>

					<div id="editUser" >
						<h2>编辑用户</h2>
						<table id="rounded-corner">
							<thead>
								<tr>
									<th scope="col" class="rounded">用户名</th>
									<th scope="col" class="rounded">用户类型</th>
									<th scope="col" class="rounded">用户手机</th>
									<th scope="col" class="rounded">用户邮箱</th>
									<th scope="col" class="rounded">用户状态</th>
									<th scope="col" class="rounded">编辑</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="username">admin</td>
									<td class="type">管理员</td>
									<td class="telephone">15159628259</td>
									<td class="email">wangsonggen@126.com</td>
									<td class="active">active</td>
									 <td><a href="#"><img src="${pageContext.request.contextPath}/js/frontModule/images/user_edit.png"
										alt="" title="" border="0" /></a></td>
								</tr>
							</tbody>
						</table>

						<!-- 分页 -->
						<div class="pagination">
							<span class="disabled"><< prev</span><span class="current">1</span><a
								href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>...<a
								href="">10</a><a href="">11</a><a href="">12</a>...<a href="">100</a><a
								href="">101</a><a href="">next >></a>
						</div>
					</div>

					<div id="deleteUser">
							<h2>删除用户</h2>
							<table id="rounded-corner">
								<thead>
									<tr>
										<th scope="col" class="rounded">用户名</th>
										<th scope="col" class="rounded">用户类型</th>
										<th scope="col" class="rounded">用户手机</th>
										<th scope="col" class="rounded">用户邮箱</th>
										<th scope="col" class="rounded">用户状态</th>
										 <th scope="col" class="rounded">删除</th> 
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="username">admin</td>
										<td class="type">管理员</td>
										<td class="telephone">15159628259</td>
										<td class="email">wangsonggen@126.com</td>
										<td class="active">active</td>
										 <td><a href="#" class="ask"><img src="${pageContext.request.contextPath}/js/frontModule/images/trash.png"
										alt="" title="" border="0" /></a></td>
									</tr>
								</tbody>
							</table>

							<!-- 分页 -->
							<div class="pagination">
								<span class="disabled"><< prev</span><span class="current">1</span><a
									href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>...<a
									href="">10</a><a href="">11</a><a href="">12</a>...<a href="">100</a><a
									href="">101</a><a href="">next >></a>
							</div>

					</div>
						
					<div id="addUser">
					<h2>添加用户</h2>
					<div class="form">
						<form action="" method="post" class="niceform">
							<fieldset>
								<dl>
									<dt>
										<label for="email">用户名:</label>
									</dt>
									<dd>
										<input type="text" name="username" id="" size="54" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="password">密码:</label>
									</dt>
									<dd>
										<input type="password" id="" size="54" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="password">再次输入密码:</label>
									</dt>
									<dd>
										<input type="password" name="passwd" id="" size="54" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="type">用户类型:</label>
									</dt>
									<dd>
										<input type="radio" name="type" id="" value="1" /><label class="check_label">管理员</label>
										<input type="radio" name="type" id="" value="2" /><label class="check_label">商家</label>
										<input type="radio" name="type" id="" value="3" checked="checked"/><label class="check_label">普通会员</label>
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="email">邮箱地址:</label>
									</dt>
									<dd>
										<input type="text" name="email" id="" size="54" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="telephone">手机号:</label>
									</dt>
									<dd>
										<input type="text" name="telephone" id="" size="54" />
									</dd>
								</dl>

								<dl>
									<dt>
										<label for="active">用户状态:</label>
									</dt>
									<dd>
										<input type="radio" name="active" id="" value="1"checked="checked"/><label class="check_label">激活</label>
										<input type="radio" name="active" id="" value="2" /><label class="check_label">禁用</label>
									</dd>
								</dl>

								<dl class="submit">
									<input type="submit" name="submit" id="submit" value="创建用户" />
								</dl>

							</fieldset>
						</form>
						</div>
						
					</div>
					<!-- 此处填写错误信息 -->
					<div class="error_box"> 无(无的时候该div应该为display:none)</div>
					
				</div>
				<!-- end of right content-->


			</div>
			<!--end of center content -->




			<div class="clear"></div>
		</div>
		<!--end of main content-->


		<div class="footer">

			<div class="left_footer">
				IN ADMIN PANEL | Powered by <a href="http://indeziner.com">INDEZINER</a>
			</div>
			<div class="right_footer">
				<a href="http://indeziner.com"><img src="${pageContext.request.contextPath}/js/frontModule/images/indeziner_logo.gif"
					alt="" title="" border="0" /></a>
			</div>

		</div>

	</div>
</body>
</html>