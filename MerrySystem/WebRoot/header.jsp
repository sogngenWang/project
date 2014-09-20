<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>merry</title>
		<link
			href="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/css/bootstrap.css"
			rel="stylesheet">
		<style type="text/css">
/* Sticky footer styles
      -------------------------------------------------- */
html,body {
	height: 100%;
	/* The html and body elements cannot have any padding or margin. */
}

/* Wrapper for page content to push down footer */
#wrap {
	min-height: 100%;
	height: auto !important;
	height: 100%;
	/* Negative indent footer by it's height */
	margin: 0 auto -60px;
}

/* Set the fixed height of the footer here */
#push,#footer {
	height: 60px;
}

#footer {
	background-color: #f5f5f5;
}

/* Lastly, apply responsive CSS fixes as necessary */
@media ( max-width : 767px) {
	#footer {
		margin-left: -20px;
		margin-right: -20px;
		padding-left: 20px;
		padding-right: 20px;
	}
}

/* Custom page CSS
      -------------------------------------------------- */
	/* Not required for template or sticky footer method. */
#wrap>.container {
	padding-top: 60px;
}

.container .credit {
	margin: 20px 0;
}

code {
	font-size: 80%;
}

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
		<link href="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/css/bootstrap-responsive.css" rel="stylesheet">

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/html5shiv.js"></script>
    <![endif]-->

		<!-- Fav and touch icons -->
		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114"
			href="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72"
			href="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed"
			href="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/ico/apple-touch-icon-57-precomposed.png">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/ico/favicon.png">

		<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#centerFrame")
								.attr("src",
										"${pageContext.request.contextPath}/mainAction.action");

						$("#firstPageButton")
								.click(
										function() {
											$(".nav li").attr("class", "");
											$(this).parent().attr("class",
													"active");
											window.parent

													.reflushIframe("${pageContext.request.contextPath}/mainAction.action");

										});
						$("#newsButton")
								.click(
										function() {
											$(".nav li").attr("class", "");
											$(this).parent().attr("class",
													"active");
											window.parent
													.reflushIframe("${pageContext.request.contextPath}/listMessageNoContentAction.action");
										});
						$("#exhibitorsButton")
								.click(
										function() {
											$(".nav li").attr("class", "");
											$(this).parent().attr("class",
													"active");
											window.parent
													.reflushIframe("${pageContext.request.contextPath}/listKindsAction.action");
										});
						$("#expoMapButton")
								.click(
										function() {
											$(".nav li").attr("class", "");
											$(this).parent().attr("class",
													"active");
											window.parent
													.reflushIframe("${pageContext.request.contextPath}/expoMap.jsp");
										});

					});
</script>
	</head>
	<body role="document">
		<div id="wrap">
			<!-- Fixed navbar -->
			<div class="navbar navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container">
						<button type="button" class="btn btn-navbar"
							data-toggle="collapse" data-target=".nav-collapse">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="brand" href="javascript:void(0);">Merrry</a>
						<div class="nav-collapse collapse">
							<ul class="nav">
								<li class="active">
									<a href="javascript:void(0);" id="firstPageButton">首页</a>
								</li>
								<li>
									<a href="javascript:void(0);" id="newsButton">新闻</a>
								</li>
								<li>
									<a href="javascript:void(0);" id="exhibitorsButton">参展单位</a>
								</li>
								<li>
									<a href="javascript:void(0);" id="expoMapButton">展会地图</a>
								</li>
							</ul>
						</div>
						<!--/.nav-collapse -->
					</div>
				</div>
			</div>
			<div class="container theme-showcase" role="main">
				<!-- 公司的一些宣传等等重要信息，新闻等等，应该为一个单独的页面，后期需要抽离出来 -->
				<div id="head">
					<img alt="" src="./img/titleOfHaixia.gif">
					<!--  2014&nbsp;&nbsp;&nbsp;第2届   <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;海峡婚博会-->
					<div id="weibodimensionCode">
						<img alt="微博二维码" src="./img/weibodimensionCode.jpg" />
						<p>
							官方微博
						</p>
					</div>
					<div id="weixindimensionCode">
						<img alt="微信二维码" src="./img/weixindimensionCode.jpg" />
						<div>
							官方微信
						</div>
					</div>
				</div>
			</div>
		</div>



		<!-- Le javascript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/jquery.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-transition.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-alert.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-modal.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-dropdown.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-scrollspy.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-tab.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-tooltip.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-popover.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-button.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-collapse.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-carousel.js"></script>
		<script
			src="${pageContext.request.contextPath}/bootstrap-2.3.2/docs/assets/js/bootstrap-typeahead.js"></script>
	</body>
</html>
