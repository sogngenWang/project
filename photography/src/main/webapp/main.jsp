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
<!-- Bootstrap core CSS -->
    <link href="./js/bootstrap-3.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
<script language="javascript" type="text/javascript" src="./js/frontModule/niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="./js/frontModule/niceforms-default.css" />

<script type="text/javascript" src="./js/main.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
/* 设置遮罩层 */
#page_mask {
	visibility: hidden;
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0px;
	left: 0px;
	display: block;
	z-index: 10;
	background-color: rgb(0, 0, 0);
	opacity: 0.3;
}

.commodity {
	text-align: center;
	width: 145px;
	height: 200px;
	background-color: yellow;
	display: inline-block;
	margin: 10px 10px 0 0;
}

.commodityImg {
	width: 145px;
	height: 150px;
}

.store {
	text-align: center;
	width: 145px;
	height: 170px;
	background-color: yellow;
	display: inline-block;
	margin: 10px 10px 0 0;
}

.storeImg {
	width: 145px;
	height: 150px;
}


.center{
	top: 20%;
	left: 40%;
}

#loginWindow {
	visibility: hidden;
	max-width: 330px;
	padding: 15px;
	position: fixed;
	z-index: 100;
	width: 210px;
	background-color: #eee;
}

#registerWindow {
	visibility: hidden;
	max-width: 330px;
	padding: 15px;
	position: fixed;
	z-index: 100;
	width: 210px;
	background-color: #eee;
}



.form-signin-heading {
	margin-bottom: 10px;
	font-size: large;
}

.form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

 .form-control:focus {
	z-index: 2;
}

 input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

 input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
	<!-- 遮罩层 -->
	<div id="page_mask"></div>
	
	<div class="container">
			<!-- 显示登录窗口 -->
			<div id="loginWindow" class="center">
			<h2 class="form-signin-heading">登录</h2>
			<input type="text" class="form-control" placeholder="用户名"  name="username" required autofocus />
			<input type="password" class="form-control" placeholder="密码"   name="passwd" required  /> 
			<button class="btn btn-lg btn-primary btn-block" type="submit" id="login">登录</button>
			<button class="btn btn-lg btn-primary btn-block back" >返回</button>
			<div id="loginMessage"></div>
		</div>
	
		<!-- 显示注册窗口 -->
		<div id="registerWindow" class="center">
				<h2 class="form-signin-heading">用户注册</h2>
				<input type="text" class="form-control" placeholder="用户名"  name="username" required autofocus />
				<input type="password" class="form-control" placeholder="密码" id="newPasswd" required  /> 
				<input type="password" class="form-control" placeholder="再次输入密码" id="reNewPasswd" name="passwd" required /> 
				<input type="text" class="form-control" placeholder="手机"  name="telephone" required />
				<input type="text" class="form-control" placeholder="邮箱"  name="email" required />
				<button class="btn btn-lg btn-primary btn-block" type="submit" id="register">注册</button>
				<button class="btn btn-lg btn-primary btn-block back" >返回</button>
				<div id="loginMessage"></div>
			<div id="registerMessage"></div>
		</div>
	</div>
	
	<div id="main_container">
		<div class="header">
			<!-- 标题栏logo -->
			<div class="logo">
				<a href="#"><img src="./js/frontModule/images/logo.gif" alt="" title="" border="0" /></a>
			</div>
			<!-- 已登录用户以及用户注销 -->
			<div class="right_header">
				<span id="welcome">欢迎回来   Admin |</span><a href="javascript:void(0);" id="loginLink">登录|</a><a id="registerLink" href="javascript:void(0);">注册|</a><a href="javascript:void(0);" id="logoutLink">注销</a>
			</div>
			<div id="clock_a"></div>
		</div>

		<!--  // TODO 图片轮转的照片墙   -->
		
	

		<!-- 标题栏 -->
		<div class="main_content">
		 
			<div class="menu">
				<ul>
					<li><a class="current" href="javascript:void(0);">摄影协会</a>
					</li>
				</ul>
			</div>
		 
		 	<div class="center_content">
				<div class="left_content">
					<div class="sidebarmenu">
					
						<div class="sidebar_search">
							<form>
								<input type="text" name="" class="search_input" value="搜索商品" onclick="this.value=''" /> <input
									type="image" class="search_submit"
									src="./js/frontModule/images/search.png" />
							</form>
						</div>
						
						<a class="menuitem menuitem_green submenuheader" href="">地区</a>
						<div class="submenu">
							<ul id="areaUl"></ul>
						</div>
						<a class="menuitem_green" href="javascript:void(0);" id="leftBarCommodity">商品</a>
						  <a class="menuitem_green" href="javascript:void(0);" id="leftBarStore">商家</a>
						  <a class="menuitem_green" href="javascript:void(0);">联系我们</a>
					 </div>
					
					<div class="sidebar_box">
						<div class="sidebar_box_top"></div>
						<div class="sidebar_box_content">
							<h3>notice</h3>
							<img src="./js/frontModule/images/info.png"
								alt="" title="" class="sidebar_icon_right" />
							<ul>
								<li>故障联系人:王松根</li>
								<li>联系电话:15159628259</li>
								<li>用户须知:</li>
								<li>1.</li>
								<li>2.</li>
								<li>3.</li>
							</ul>
						</div>
						<div class="sidebar_box_bottom"></div>
					</div>
				</div>
				
				<div class="right_content">
					<div id="listCommodityDiv" >
						<h2>商品</h2>
						
						<!-- 显示商家 -->
						<div id="listStore"></div>
						<!-- 显示商品 -->
						<div id="listCommodity"></div>
						
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
				<a href="http://indeziner.com"><img src="./js/frontModule/images/indeziner_logo.gif"
					alt="" title="" border="0" /></a>
			</div>

		</div>

	</div>
</body>
</html>