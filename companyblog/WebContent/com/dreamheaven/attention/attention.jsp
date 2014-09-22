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
			$(this).siblings(".attentionInfo_detail").show().css({top:e.pageY,left:e.pageX});
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
		
		$("#attentionInfo_" + id).animate({
			height : '120px'
		});
		
		$("#attentionInfo_detail_" + id).show();

	}
	function recover(id) {


		$("#headImg_"+id).animate({
			height : '60px',
			width : '60px'
		});
		
		$("#attentionInfo_" + id).animate({
			height : '80px'
		});
		
		$("#attentionInfo_detail_" + id).hide();

	}
</script>
<style>
.userImg{
	width: 60px; 
	height: 60px;
	display: inline;
}
.attentionInfoClass{
	height: 80px;
}
.attentionInfo_detail{
	position:absolute;
	display:none;
	z-index:999;
	background-color: white;
}

</style>
</head>
<body>
	<c:forEach items="${user.attentionInfoList}" var="attentionInfo">
		<div class="attentionInfoClass" id="attentionInfo_${attentionInfo.uid}">
			<img class="userImg" id="headImg_${attentionInfo.uid}"
				align="left"
				src="${pageContext.request.contextPath}/userheadimg/${attentionInfo.headImgPath}"
				onclick="moreBig('${attentionInfo.uid}')"
				onmouseout="recover('${attentionInfo.uid}')" />
			<div class="attentionInfo_detail" id="attentionInfo_detail_${attentionInfo.uid}" style="display: none;">
				<div>
				性别:
					<c:if test="${attentionInfo.sex eq 1}">
					男
					</c:if>
					<c:if test="${attentionInfo.sex eq 2}">
					女
					</c:if>
				</div>
				年龄:${attentionInfo.age}
				<fmt:parseDate value="${attentionInfo.birthday}" type="date" var="birthday" pattern="yyyyMMdd" />
				<br/>
				出生年月:<fmt:formatDate value="${birthday}" pattern="yyyy年MM月dd日"/>
				<br/>
				兴趣爱好:${attentionInfo.hoby}
				<br/>
			</div>
		</div>
		<div class="attentionNickName">${attentionInfo.nickName}</div>
		
		<c:if test="${attentionInfo.listenFlag == '0'}">
		<a  href="${pageContext.request.contextPath}/com/dreamheaven/attention/addListenUser.action?listenedId=${attentionInfo.uid}">收听</a>
		</c:if>
		
		
		<c:if test="${attentionInfo.listenFlag == '1'}">
		<a  href="${pageContext.request.contextPath}/com/dreamheaven/attention/deleteListenUser.action?listenedId=${attentionInfo.uid}">取消收听</a>
		</c:if>
		
	</c:forEach>
</body>
</html>