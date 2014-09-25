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
<title>merry</title>


<!-- Bootstrap core CSS -->

<style type="text/css">
body {
	height: 66px;
}

body>div {
	width:1000px;
	margin: 0 auto;
}

td {
	margin: 3px;
	padding: 1px 5px 1px 1px;
}
</style>


</head>
<body>

	<div>
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
</body>
</html>
