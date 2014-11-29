<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>merry</title>


<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Bootstrap theme -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.2.0/dist/css/bootstrap-theme.min.css"
	rel="stylesheet">

<script
	src="${pageContext.request.contextPath}/bootstrap-3.2.0/docs/assets/js/ie-emulation-modes-warning.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="${pageContext.request.contextPath}/bootstrap-3.2.0/docs/assets/js/ie10-viewport-bug-workaround.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		    <![endif]-->
<style type="text/css">
#weibodimensionCode {
	float: right;
	display: block;
	font-size: medium;
	width: 80px;
}

#weixindimensionCode {
	float: right;
	font-size: medium;
	display: block;
	width: 80px;
	height: 100px;
}

#head img {
	height: 100px;
	width: 500px;
	display: inline;
}

#head div img {
	margin: 20px auto 0 auto;
	text-align: center;
	display: inline;
	height: 50px;
	width: 50px;
}

#head div p {
	margin: 0px auto;
}
</style>

		<script type="text/javascript">
	$(document).ready(function() {
	
						$("#centerFrame").attr("src","${pageContext.request.contextPath}/mainAction.action");

						$("#firstPageButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
							window.parent.reflushIframe("${pageContext.request.contextPath}/mainAction.action");
						});
						$("#newsButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
							window.parent.reflushIframe("${pageContext.request.contextPath}/listMessageNoContentAction.action");
						});
						$("#exhibitButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
							window.parent.reflushIframe("${pageContext.request.contextPath}/listKindsAction.action");
						});
						$("#associationDynaButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
						});
						$("#announceFileButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
						});
						$("#trainButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
						});
						$("#aboutAssociationButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
						});
						$("#partnersButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
						});
						$("#servePlatformButton").click(function() {
							$(".nav li").attr("class", "");
							$(this).parent().attr("class","active");
						});
					});
</script>
</head>

<body role="document">

	<div class="navbar navbar-default " role="navigation" >
		<div class="container">
			<!-- 公司的一些宣传等等重要信息，新闻等等，应该为一个单独的页面，后期需要抽离出来 -->
			<div id="head">
				<div style="color: balck;font-size:xx-large;">摄彩中国</div>
				<div style="color: balck;font-size: x-large;font-style: oblique;">福建省摄影行业协会网</div>
			</div>

			<div class="container">
				<div class="navbar-header">
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="javascript:void(0);" id="firstPageButton">首页</a></li>
						<li><a href="javascript:void(0);" id="newsButton">新闻活动</a></li>
						<li><a href="javascript:void(0);" id="exhibitButton">作品</a></li>
						<li><a href="javascript:void(0);" id="associationDynaButton">协会动态</a>
						<li><a href="javascript:void(0);" id="announceFileButton">通知文件</a>
						<li><a href="javascript:void(0);" id="trainButton">培训</a>
						<li><a href="javascript:void(0);" id="aboutAssociationButton">关于协会</a>
						<li><a href="javascript:void(0);" id="partnersButton">合作伙伴</a>
						<li><a href="javascript:void(0);" id="servePlatformButton">服务平台</a>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

</body>
</html>
