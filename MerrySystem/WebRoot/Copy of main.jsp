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
<title>merry</title>
<script type="text/javascript">
	$(document).ready(function() {
		//初始化的时候    通过ajax 查询后台，获取活动图片以及相关的URL 然后设置dispalyPicture的src属性以及a属性
		
		
		
	});
	
	function reflushIframe(action){
		$("#centerFrame").attr("src",action);		
		var framheight = document.getElementById("centerFrame").contentWindow.document.body.scrollWidth;
		$("#centerFrame").css("height",framheight);
	}
	
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

/*
#kinds a {
	background-image: url("./img/button1.gif");
	background-repeat: no-repeat;
	font-size: 25px;
	padding: 10%;
	display: block;
	text-decoration: none;
}
*/
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

/* 设置图片的透明度  */
a img {
	width: 100%;
	height: 100%;
	opacity: 0.1;
}

#mainFrameNews {
	width: 100%;
	height: 100%;
}

.messageTitleDiv {
	
}

#aboutExpo {
	margin: 10px;
	display: inline;
}

#visitExpo {
	margin: 10px;
	display: inline;
}
</style>
</head>
<body>

<!-- 
<iframe src="${pageContext.request.contextPath}/header.jsp" style="width: 100%;height: 200px;border: none;"></iframe>
 -->
 <jsp:include page="header.jsp" flush="true" />

<div id="left">
		<!-- 主要活动新闻图片区域  -->
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
							<td colspan="8" style="background-color: yellow;">
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
			<button id="aboutExpo">关于协会</button>
			<button id="visitExpo">加入协会</button>
		</div>
		<!-- 
		<div id="ad_2">
			<a href="javascript:void(0);" onclick="window.location.href='http://www.baidu.com'"> <img alt="广告图片" src="./img/AD.gif" />
			</a>
		</div>
		<div id="ad_3">
			<a href="javascript:void(0);"> <img src="./img/AD.gif" />
			</a>		
		</div>
		<div id="dynamic"></div>
		 -->
	</div>
<iframe src="${pageContext.request.contextPath}/bottom.jsp" style="width: 100%;height: 200px;border: none;"></iframe>


</body>
</html>
