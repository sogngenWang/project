<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理页面</title>
<link rel="stylesheet" type="text/css" href="./js/frontModule/style.css" />
<script type="text/javascript" src="./js/frontModule/clockp.js"></script>
<script type="text/javascript" src="./js/frontModule/clockh.js"></script> 
<script type="text/javascript" src="./js/frontModule/jquery.min.js"></script>
<script type="text/javascript" src="./js/frontModule/ddaccordion.js"></script>
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
	togglehtml: ["suffix", "<img src='./js/frontModule/images/plus.gif' class='statusicon' />", "<img src='./js/frontModule/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
});
</script>

<script type="text/javascript" src="./js/frontModule/jconfirmaction.jquery.js"></script>
<script type="text/javascript" src="./js/manage.js" />

<script language="javascript" type="text/javascript" src="./js/frontModule/niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="./js/frontModule/niceforms-default.css" />

<style type="text/css">
	#errorMessage {
		display: none;
	}
	
</style>
</head>
<body>
	<div id="main_container">

		<div class="header">
			<!-- 标题栏logo -->
			<div class="logo">
				<a href="#"><img src="./js/frontModule/images/logo.gif"
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
					<li><a class="current" href="#">帐号管理</a>
					</li>
				</ul>
			</div>
		 	<div class="center_content">
				<div class="left_content">

					<div class="sidebarmenu">
						<a class="menuitem menuitem_green submenuheader" href="">用户管理</a>
						<div class="submenu">
							<ul>
								<li><a href="javascript:void(0); " id="listUserManu">用户查询</a></li>
								<li><a href="javascript:void(0);" id="addUserManu">用户添加</a></li>
							</ul>
						</div>
						<a class="menuitem menuitem_green submenuheader" href="">区域管理</a>
						<div class="submenu">
							<ul>
								<li><a href="javascript:void(0);" id="listAreaManu">区域查询</a></li>
								<li><a href="javascript:void(0);" id="addAreaManu">区域添加</a></li>
							</ul>
						</div>
						<a class="menuitem menuitem_green submenuheader" href="">商品管理</a>
						<div class="submenu">
							<ul>
								<li><a href="javascript:void(0);" id="listCommodityManu" >商品查询</a></li>
								<li><a href="javascript:void(0);" id="addCommodityManu" >商品添加</a></li>
							</ul>
						</div>
						<a class="menuitem menuitem_green submenuheader" href="">商家管理</a>
						<div class="submenu">
							<ul>
								<li><a href="javascript:void(0);" id="listStoreManu" >商家查询</a></li>
								<li><a href="javascript:void(0);" id="addStoreManu" >商家添加</a></li>
							</ul>
						</div>
						<a class="menuitem menuitem_green submenuheader" href="">评论管理</a>
						<div class="submenu">
							<ul>
								<li><a href="javascript:void(0);" id="listCommentManu" >评论查询</a></li>
								<li><a href="javascript:void(0);" id="addCommentManu" >评论添加</a></li>
							</ul>
						</div>
					</div>
					
					
					<div class="sidebar_box">
						<div class="sidebar_box_top"></div>
						<div class="sidebar_box_content">
							<h3>notice</h3>
							<img src="./js/frontModule/images/info.png" class="sidebar_icon_right" />
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
					<!-- ******************************************************************** -->
					<div id="listUser" class="right_div_clazz">
						<h2>用户查询</h2>
						<div class="sidebar_search">
							<form>
								<input type="text" name="" class="search_input" value="搜索用户" onclick="this.value=''" />
								<input type="image" class="search_submit"  src="./js/frontModule/images/search.png" />
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
									<th scope="col" class="rounded">编辑</th>
									<th scope="col" class="rounded">删除</th>
								</tr>
							</thead>
							<!-- 表格内容<tr><td></td><td></td></tr> -->
							<tbody></tbody>
						</table>

						<!-- 分页 -->
						<div class="pagination">
							<span class="disabled"><< prev</span>
							<span class="current">1</span>
							<a href="">2</a>
							<a href="">3</a>
							...
							<a href="">5</a>
							...
							<a href="">10</a>
							<a href="">11</a>
							<a href="">next >></a>
						</div>
					</div>
					<!-- ******************************************************************** -->
					<div id="editUser" class="right_div_clazz" >
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
									 <td><a href="#"><img src="./js/frontModule/images/user_edit.png"
										alt="" title="" border="0" /></a></td>
									 <td><a href="#" class="ask"><img src="./js/frontModule/images/trash.png"
										alt="" title="" border="0" /></a></td>
								</tr>
							</tbody>
						</table>

						<!-- 分页 -->
						<div class="pagination">
							<span class="disabled"><< prev</span>
							<span class="current">1</span>
							<a href="">2</a>
							<a href="">3</a>
							...
							<a href="">5</a>
							...
							<a href="">10</a>
							<a href="">11</a>
							<a href="">next >></a>
						</div>
					</div>
					<!-- ******************************************************************** -->
					<div id="addUser" class="right_div_clazz">
					<h2>添加用户</h2>
					<div class="form">
						<form action="" method="post" >
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
										<input type="radio" name="type"  value="1" /><label class="check_label">管理员</label>
										<input type="radio" name="type"  value="2" /><label class="check_label">商家</label>
										<input type="radio" name="type"  value="3" checked="checked"/><label class="check_label">普通会员</label>
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
										<input type="radio" name="active" id="" value="1" checked="checked"/><label class="check_label">激活</label>
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
					<!-- ******************************************************************** -->
					<div id="listArea" class="right_div_clazz">
						<h2>区域查询</h2>
						<div class="sidebar_search">
							<form>
								<input type="text" name="" class="search_input" value="搜索区域" onclick="this.value=''" />
								<input type="image" class="search_submit"  src="./js/frontModule/images/search.png" />
							</form>
						</div>
						<table id="rounded-corner">
							<thead>
								<tr>
									<th scope="col" class="rounded">区域名</th>
									<th scope="col" class="rounded">编辑</th>
									<th scope="col" class="rounded">删除</th>
								</tr>
							</thead>
							<!-- 表格内容<tr><td></td><td></td></tr> -->
							<tbody></tbody>
						</table>

						<!-- 分页 -->
						<div class="pagination">
							<span class="disabled"><< prev</span>
							<span class="current">1</span>
							<a href="">2</a>
							<a href="">3</a>
							...
							<a href="">5</a>
							...
							<a href="">10</a>
							<a href="">11</a>
							<a href="">next >></a>
						</div>
					</div>
					<!-- ******************************************************************** -->
					<div id="addArea" class="right_div_clazz">
					<h2>添加区域</h2>
					<div class="form">
						<form action="" method="post" >
							<fieldset>
								<dl>
									<dt>
										<label for="areaname">区域名:</label>
									</dt>
									<dd>
										<input type="text" name="areaname" id="" size="54" />
									</dd>
								</dl>
								<dl class="submit">
									<input type="submit" name="submit" id="submit" value="创建区域" />
								</dl>
							</fieldset>
						</form>
						</div>
					</div>
					<!-- ******************************************************************** -->
					<div id="listCommodity" class="right_div_clazz">
						<h2>商品查询</h2>
						<div class="sidebar_search">
							<form>
								<input type="text" name="" class="search_input" value="搜索商品" onclick="this.value=''" />
								<input type="image" class="search_submit"  src="./js/frontModule/images/search.png" />
							</form>
						</div>
						<table id="rounded-corner">
							<thead>
								<tr>
									<th scope="col" class="rounded">商品名</th>
									<th scope="col" class="rounded">详细信息</th>
									<th scope="col" class="rounded">编辑</th>
									<th scope="col" class="rounded">删除</th>
								</tr>
							</thead>
							<!-- 表格内容<tr><td></td><td></td></tr> -->
							<tbody></tbody>
						</table>

						<!-- 分页 -->
						<div class="pagination">
							<span class="disabled"><< prev</span>
							<span class="current">1</span>
							<a href="">2</a>
							<a href="">3</a>
							...
							<a href="">5</a>
							...
							<a href="">10</a>
							<a href="">11</a>
							<a href="">next >></a>
						</div>
					</div>
					
					<!-- ******************************************************************** -->
					<div id="addCommodity" class="right_div_clazz">
					<h2>添加商品</h2>
					<div class="form">
						<form action="" method="post" >
							<fieldset>
								<dl>
									<dt>
										<label for="commodityname">商品名:</label>
									</dt>
									<dd>
										<input type="text" name="commodityname" id="" size="54" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="commodityprice">商品价格:</label>
									</dt>
									<dd>
										<input type="commodityprice" id="" size="54" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="type">用户类型:</label>
									</dt>
									<dd>
										<input type="radio" name="kindsid"  value="1" /><label class="check_label">婚纱摄影</label>
										<input type="radio" name="kindsid"  value="2" /><label class="check_label">儿童摄影</label>
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="suggestlev">推荐指数:</label>
									</dt>
									<dd>
										<input type="text" name="suggestlev" id="" size="54" />
									</dd>
								</dl>
								<!--   TODO    商品图片，商品详情 
								<dl>
									<dt>
										<label for="commoditypic">商品图片:</label>
									</dt>
									<dd>
										<input type="text" name="commoditypic" id="" size="54" />
									</dd>
								</dl>
								 -->
								
								<dl class="submit">
									<input type="submit" name="submit" id="submit" value="创建商品" />
								</dl>
							</fieldset>
						</form>
						</div>
					</div>
					
					<!-- ******************************************************************** -->
					<div id="listStore" class="right_div_clazz">
						<h2>商品查询</h2>
						<div class="sidebar_search">
							<form>
								<input type="text" name="" class="search_input" value="搜索商品" onclick="this.value=''" />
								<input type="image" class="search_submit"  src="./js/frontModule/images/search.png" />
							</form>
						</div>
						<table id="rounded-corner">
							<thead>
								<tr>
									<th scope="col" class="rounded">商品名</th>
									<th scope="col" class="rounded">详细信息</th>
									<th scope="col" class="rounded">编辑</th>
									<th scope="col" class="rounded">删除</th>
								</tr>
							</thead>
							<!-- 表格内容<tr><td></td><td></td></tr> -->
							<tbody></tbody>
						</table>

						<!-- 分页 -->
						<div class="pagination">
							<span class="disabled"><< prev</span>
							<span class="current">1</span>
							<a href="">2</a>
							<a href="">3</a>
							...
							<a href="">5</a>
							...
							<a href="">10</a>
							<a href="">11</a>
							<a href="">next >></a>
						</div>
					</div>
					
					<!-- ******************************************************************** -->
					<div id="addStore" class="right_div_clazz">
					<h2>添加商品</h2>
					<div class="form">
						<form action="" method="post" >
							<fieldset>
								<dl>
									<dt>
										<label for="commodityname">商家名:</label>
									</dt>
									<dd>
										<input type="text" name="commodityname" id="" size="54" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="commodityprice">商品价格:</label>
									</dt>
									<dd>
										<input type="commodityprice" id="" size="54" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="type">用户类型:</label>
									</dt>
									<dd>
										<input type="radio" name="kindsid"  value="1" /><label class="check_label">婚纱摄影</label>
										<input type="radio" name="kindsid"  value="2" /><label class="check_label">儿童摄影</label>
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="suggestlev">推荐指数:</label>
									</dt>
									<dd>
										<input type="text" name="suggestlev" id="" size="54" />
									</dd>
								</dl>
								<!--   TODO    商品图片，商品详情 
								<dl>
									<dt>
										<label for="commoditypic">商品图片:</label>
									</dt>
									<dd>
										<input type="text" name="commoditypic" id="" size="54" />
									</dd>
								</dl>
								 -->
								
								<dl class="submit">
									<input type="submit" name="submit" id="submit" value="创建商品" />
								</dl>
							</fieldset>
						</form>
						</div>
					</div>
					<!-- ******************************************************************** -->
					<div id="listComment" class="right_div_clazz">
						<!-- 分页 -->
						<div class="pagination">
							<span class="disabled"><< prev</span>
							<span class="current">1</span>
							<a href="">2</a>
							<a href="">3</a>
							...
							<a href="">5</a>
							...
							<a href="">10</a>
							<a href="">11</a>
							<a href="">next >></a>
						</div>
					</div>
					
					<!-- ******************************************************************** -->
					<!-- 此处填写错误信息 -->
					<div class="error_box" id="errorMessage"> 无(无的时候该div应该为display:none)</div>
				</div>
				<!-- end of right content-->
			</div>
			<!--end of center content -->
			<div class="clear"></div>
		</div>
		<!--end of main content-->
		<div class="footer">
			<div class="left_footer">
				IN ADMIN PANEL | Powered by <a href="#">INDEZINER</a>
			</div>
			<div class="right_footer">
				<a href="#"><img src="./js/frontModule/images/indeziner_logo.gif"
					alt="" title="" border="0" /></a>
			</div>
		</div>

	</div>
</body>
</html>