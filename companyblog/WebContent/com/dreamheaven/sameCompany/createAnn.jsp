<?xml version="1.0" encoding="UTF-8" ?> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>main page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/firstPage.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/firstPage.js"></script>
<script type="text/javascript">
function clearText() {
	announceMsgTextArea = document.getElementById("announceMsgTextArea");
	announceMsgTextAreaValue = announceMsgTextArea.value;
	if (announceMsgTextAreaValue == "请输入你想要发布的公告") {
		announceMsgTextArea.value = "";
		announceMsgTextArea.style.color = "#000";
	}

}
function restoreText() {
	announceMsgTextArea = document.getElementById("announceMsgTextArea");
	if (announceMsgTextArea.value == "") {
		announceMsgTextArea.value = "请输入你想要发布的公告";
		announceMsgTextArea.style.color = "#999";
	}
}
</script>
<style>
#submitAnn {
	float: left;
}
</style>
</head>
<body>
	<div id="announcement">
		<form id="announceMsg" action="${pageContext.request.contextPath}/createAnn.action" method="post">
			<div id="announceMsgAreaDiv">
				<textarea id="announceMsgTextArea" rows="5" cols="76" name="messageText"
					onclick="clearText();" onblur="restoreText()">请输入你想要发布的公告</textarea>
			</div>
			<div id="submitAnn">
				<input type="submit" value="发布" />
				<div class="divNbspRight" />
			</div>
		</form>
	</div>
</body>
</html>