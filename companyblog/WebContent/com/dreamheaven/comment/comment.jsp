<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>main page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		//拦截超链接跳转，同时获取超链接中存的uid然后传到后台，这样就可以实现由后台控制跳转 
		$(".messageMContent a").mousedown(function(e){
			var ahref = $(this).attr("href");
			window.location.href="${pageContext.request.contextPath}/detailUserInfoByAHref.action?uid="+ahref;
			return false;
		});
	});
	
	function toggleRelyMessage(messageId){
		$(".relyeMessageBlock").hide();
		$("#relyeMessageBlock_"+messageId).slideToggle(1500);
	}
	
</script>
<style>
.userImg {
	width: 60px;
	height: 60px;
	display: inline;
}

#atBody {
	margin: 5px;
}

.messageContent {
	margin-top: 20px;
	display: block;
}

.messageNickName {
	display: inline-block;
}

.messageCreateTime {
	float: right;
	display: inline-block;
}

.messageMContent {
	clear: both;
	display: inline-block;
	text-indent: 2em;
}

.relyMessage {
	display: block;
	margin: 0px auto 10px 60px;
}

.relyeMessageBlock {
	display: none;
}

.relyMessageNickName {
	display: inline;
}

.relyMessageTime {
	display: inline;
	float: right;
}

.relyMessageContent {
	clear: both;
}

.toggleRelyMessage {
	height: 15px;
}
</style>
</head>
<body>
	<div id="atBody">
		<c:if test="${not empty message.messageList}">
			<!-- 取出每一条@信息 -->
			<c:forEach items="${message.messageList}" var="messageInfo">
				<div class="messageContent">
					<img class="userImg" id="headImg_${messageInfo.mid}"
						src="${pageContext.request.contextPath}/userheadimg/${messageInfo.headPath}" />
					<div class="messageNickName">${messageInfo.nickName}:</div>
					<fmt:parseDate value="${messageInfo.createTime}" type="date" var="createTime" pattern="yyyyMMdd HH:mm:ss" />
					<div class="messageCreateTime"><fmt:formatDate value="${createTime}" pattern="yyyy年MM月dd日  HH点mm分ss秒"/></div>
					<div class="messageMContent">${messageInfo.mcontent}</div>
				</div>
				<!-- 取出每一条信息下的回复信息 -->
				<c:if test="${not empty messageInfo.relyMessageList}">
					<div class="toggleRelyMessage" onclick="toggleRelyMessage(${messageInfo.mid})"
						id="toggleRelyMessage_${messageInfo.mid}">display</div>
					<div class="relyeMessageBlock" id="relyeMessageBlock_${messageInfo.mid}">
					<c:forEach items="${messageInfo.relyMessageList}" var="relyMessage">
						<div class="relyMessage">
							<img class="userImg" id="headImg_${relyMessage.uid}" align="left"
								src="${pageContext.request.contextPath}/userheadimg/${relyMessage.relyUserPath}" />
							<div class="relyMessageNickName">${relyMessage.relyUserNickName}</div>
							<fmt:parseDate value="${relyMessage.relyTime}" type="date" var="relyTime" pattern="yyyyMMdd HH:mm:ss" />
							<div class="relyMessageTime"><fmt:formatDate value="${relyTime}" pattern="yyyy年MM月dd日  HH点mm分ss秒"/></div>
							<div class="relyMessageContent">${relyMessage.relyContent}</div>
							<br />
						</div>
					</c:forEach>
					</div>
				</c:if>
			</c:forEach>

		</c:if>
	</div>
</body>
</html>