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
body{
	height: 66px;
}

td {
	margin: 3px;
	padding: 1px 5px 1px 1px;
}
</style>


</head>
<body role="document">
	<div class="navbar " role="navigation">
		<div class="navbar navbar-default">
			<div class="container">

				<table style="display: inline; margin: 10px;">
					<tr>
						<td>指导单位:</td>
						<td>中国社会工作协会婚庆行业委员会</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>福建省闽台经济合作促进委员会</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>福建省民政厅</td>
					</tr>
				</table>

				<table style="display: inline;margin: 10px;">
					<tr>
						<td>主办单位:</td>
						<td>福建省商务厅</td>
						<td>福建省贸促会</td>
					</tr>
					<tr>
						<td>协办单位:</td>
						<td>福州市民政局</td>
						<td>福州市旅游局</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>福建省闽台经济合作促进委员会</td>
						<td>福州市商贸服务业局</td>
					</tr>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
