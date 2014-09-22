<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>main page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		//跳转页面之前先ajax刷新主页面的fans数
		renderParent();
		
		$(".userImg").mousemove(function(e)
		{
			$(this).siblings(".fansInfo_detail").show().css({top:e.pageY,left:e.pageX});
		});
	
	});
	
	function renderParent()
	{
		window.parent.ajaxRenderAttentionCount();
	}
	

	function moreBig(id) {
		
		$("#headImg_"+id).animate({
			height : '100px',
			width : '100px'
		});
		
		$("#fansInfo_" + id).animate({
			height : '120px'
		});
		
		$("#fansInfo_detail_" + id).show();

	}
	function recover(id) {


		$("#headImg_"+id).animate({
			height : '60px',
			width : '60px'
		});
		
		$("#fansInfo_" + id).animate({
			height : '80px'
		});
		
		$("#fansInfo_detail_" + id).hide();

	}
</script>
<style>
.userImg{
	width: 60px; 
	height: 60px;
	display: inline;
}
.fansInfoClass{
	height: 80px;
}
.fansInfo_detail{
	position:absolute;
	display:none;
	z-index:999;
	background-color: white;
}

</style>
</head>
<body>
	<c:forEach items="${user.fansInfoList}" var="fansInfo">
		<div class="fansInfoClass" id="fansInfo_${fansInfo.uid}">
			<img class="userImg" id="headImg_${fansInfo.uid}"
				align="left"
				src="${pageContext.request.contextPath}/userheadimg/${fansInfo.headImgPath}"
				onclick="moreBig('${fansInfo.uid}')"
				onmouseout="recover('${fansInfo.uid}')" />
			<div class="fansInfo_detail" id="fansInfo_detail_${fansInfo.uid}" style="display: none;">
				<div>
				性别:
					<c:if test="${fansInfo.sex eq 1}">
					男
					</c:if>
					<c:if test="${fansInfo.sex eq 2}">
					女
					</c:if>
				</div>
				年龄:${fansInfo.age}
				<fmt:parseDate value="${fansInfo.birthday}" type="date" var="birthday" pattern="yyyyMMdd" />
				<br/>
				出生年月:<fmt:formatDate value="${birthday}" pattern="yyyy年MM月dd日"/>
				<br/>
				兴趣爱好:${fansInfo.hoby}
				<br/>
			</div>
		</div>
		<div class="fansNickName">${fansInfo.nickName}</div>
		
		<c:if test="${fansInfo.listenFlag == '0'}">
		<a  href="${pageContext.request.contextPath}/com/dreamheaven/fans/addListenUser.action?listenedId=${fansInfo.uid}">收听</a>
		</c:if>
		
		
		<c:if test="${fansInfo.listenFlag == '1'}">
		<a  href="${pageContext.request.contextPath}/com/dreamheaven/fans/deleteListenUser.action?listenedId=${fansInfo.uid}">取消收听</a>
		</c:if>
		
	</c:forEach>
</body>
</html>