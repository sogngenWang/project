<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<script type="text/javascript">
	$(document).ready(function() {
		$(".messageTitleDiv a").click(function() {
			var action = $(this).parent().attr("action");
			window.parent.reflushIframe(action);
		});
	});
</script>
<!-- 800px高*1600px宽 -->
<style>
body {
	margin: 0 auto;
	width: 980px;
	height: 800px;
}

#left {
	float: left;
	display: block;
	width: 66%;
	height: 100%;
}

#right {
	float: left;
	width: 34%;
	height: 100%;
}

#picDisplay {
	margin: auto;
	width: 100%;
	height: 35%;
}

#dispalyPicture {
	margin: auto;
	width: 100%;
	height: 100%;
}

#ad_1 {
	margin: 1%;
	width: 30%;
	height: 8%;
}

#kinds {
	width: 100%;
	height: 20%;
}

#kinds a {
	background-image: url("./img/button1.gif");
	background-repeat: no-repeat;
	font-size: 25px;
	padding: 10%;
	display: block;
	text-decoration: none;
}

#ad_2 {
	margin: 4% auto;
	width: 100%;
	height: 20%;
}

#ad_3 {
	margin: 4% auto;
	width: 100%;
	height: 20%;
}

#dynamic {
	width: 100%;
	height: 34%%;
}

a img {
	width: 100%;
	height: 100%;
}

#mainFrameNews {
	width: 100%;
	height: 100%;
}

.messageTitleDiv {
	
}
</style>
</head>
<body>
<div id="left">
	<!-- 展示图片区域  -->
	<div id="picDisplay">
		<img id="dispalyPicture" alt="展示图片" src="./img/dispalyPicture.png" />
	</div>
	<!-- 广告栏1 -->
	<div id="ad_1">
		<a href="javascript:void(0);"> <img src="./img/AD.gif" />
		</a>
	</div>
	<!-- 新闻栏 -->

	<div id="news" class="row">
		<div class="col-md-10">
			<table class="table">
				<thead>
					<tr>
						<th colspan="2">序号</th>
						<th colspan="8">新闻标题</th>
					</tr>
				</thead>
				<c:forEach items="${message.messageList}" var="messageInfo"
					varStatus="vs">
					<tbody>
						<td colspan="2">${vs.count}</td>
						<td colspan="8">
							<div class="messageTitleDiv" id="${messageInfo.messageId}" action="${pageContext.request.contextPath}/detailMessageAction.action?message.messageId=${messageInfo.messageId}">
								<a href="javascript:void(0);">${messageInfo.messageTitle}</a>
							</div>
						</td>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>

</div>
<div id="right">
	<div id="kinds">
		<button type="button" class="btn btn-lg btn-primary"
			style="margin:20px 10px 10px 100px;">关于展会</button>
		<br />
		<button type="button" class="btn btn-lg btn-primary"
			style="margin:20px 10px 10px 100px;">参加展会</button>
	</div>
	<div id="ad_2">
		<a href="javascript:void(0);"> <img alt="广告图片" src="./img/AD.gif" />
		</a>
	</div>
	<div id="ad_3">
		<a href="javascript:void(0);"> <img src="./img/AD.gif" />
		</a>
	</div>
	<div id="dynamic">协会动态:</div>
</div>


</body>
</html>
