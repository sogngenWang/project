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
		$("#atBody  a").mousedown(function(e){
			var ahref = $(this).attr("href");
			window.location.href="${pageContext.request.contextPath}/detailUserInfoByAHref.action?uid="+ahref;
			return false;
		});
	});
	
	function toggleRelyMessage(messageId){
		$(".relyeMessageBlock").hide();
		$("#relyeMessageBlock_"+messageId).slideToggle(1500);
	}
	function displayRelyMessageInput(messageId) {
		$("#relyMessageInput_" + messageId).css("display", "block");
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
.relyMessageInput {
	display: none;
}
.relyMessageLink {
	float: right;
}
</style>
</head>
<body>
	<div id="atBody">
		<c:if test="${not empty at.atMeMessageList}">
			<!-- 取出每一条@信息 -->

			<c:forEach items="${at.atMeMessageList}" var="message">
				<div class="messageContent">
					<img class="userImg" id="headImg_${message.mid}"
						src="${pageContext.request.contextPath}/userheadimg/${message.headPath}" />
					<div class="messageNickName">${message.nickName}:</div>
					<fmt:parseDate value="${message.createTime}" type="date" var="createTime" pattern="yyyyMMdd HH:mm:ss" />
					<div class="messageCreateTime"><fmt:formatDate value="${createTime}" pattern="yyyy年MM月dd日  HH点mm分ss秒"/></div>
					<div class="messageMContent">${message.mcontent}</div>
				</div>
				<!-- 取出每一条信息下的回复信息 -->
				<c:if test="${not empty message.relyMessageList}">
					<div class="toggleRelyMessage" onclick="toggleRelyMessage(${message.mid})"
						id="toggleRelyMessage_${message.mid}">display</div>
					<div class="relyeMessageBlock" id="relyeMessageBlock_${message.mid}">
					<c:forEach items="${message.relyMessageList}" var="relyMessage">
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
				<div class="relyMessageAction">
				<div class="relyMessageLink" onclick="displayRelyMessageInput(${message.mid});">rely</div>
				<div class="relyMessageInput" id="relyMessageInput_${message.mid}">
					<form id="relyMsg" action="${pageContext.request.contextPath}/createRelyMessage.action?messageId=${message.mid}" method="post">
						<textarea id="relyMsgTextArea" rows="3" cols="76" name="relyMessage.relyContent"></textarea>
						<div class="relyMessageSubmit">
						<input type="submit" value="回复" />
						</div>
					</form>
				</div>
				</div>
			<br/>
			</c:forEach>

		</c:if>
	</div>
</body>
</html>