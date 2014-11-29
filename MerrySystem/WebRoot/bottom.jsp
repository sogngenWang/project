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
<title>merry</title>
<style type="text/css">
body {
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
						<td>&nbsp;</td>
						<td>福建省摄影行业协会网</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>版权所有：福建省摄影行业协会</td>
						<td>&nbsp;</td>
						<td>网站运营：福州中天创信网络技术有限公司</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>闽ICP备14016797号</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
