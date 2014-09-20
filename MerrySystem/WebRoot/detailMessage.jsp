<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

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



	</head>

	<body role="document">
		<div class="container">
			<div class="row">
				<div class="span6">
					<!-- 显示标题 message tiltle -->
					<!-- 列出message Content -->
					${message.messageContent}
				</div>
			</div>
		</div>
	</body>
</html>
