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
<meta charset="utf-8">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<title>拍得好</title>
<style type="text/css">
body {
	background-color: black;
	margin: 0 auto;
}

#firstPageImg {
	width: 1100px;
	margin: 0 10% auto 10%;
}

body div img {
	width: 100%;
}

#button1 {
	display: inline;
	position: relative;
	top: -220px;
	left: 240px;
	z-index: 100;
	width: 100px;
	font-size: 20px;
}

#button2 {
	display: inline;
	position: relative;
	top: -220px;
	left: 780px;
	z-index: 100;
	width: 100px;
	font-size: 20px;
}

.buttonDiv a:link,.buttonDiv a:hover,.buttonDiv a:visited,.buttonDiv a:active
	{
	color: white;
	text-decoration: none;
}

.class {
	color: white;
	text-decoration: none;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#button1").click(function() {
			window.location.href="main.jsp?kinds=1";
		});
		$("#button2").click(function() {
			window.location.href="main.jsp?kinds=2";
		});
	});
</script>
</head>

<body>
	<div id="firstPageImg">
		<img alt="首页" src="./images/firstPage.gif">
		<div id="button1" class="buttonDiv">
			<a href="javascript:void(0);" class="inter">INTER</a>
		</div>
		<div id="button2" class="buttonDiv">
			<a href="javascript:void(0);" class="inter">INTER</a>
		</div>
	</div>
</body>
</html>