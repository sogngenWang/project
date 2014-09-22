<?xml version="1.0" encoding="UTF-8" ?> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		//设置body背景图片的宽度
		setBackGroundImg();
	});

	function cancleAll() {
		$("#userName").val("");
		$("#password").val("");
	}

	function setBackGroundImg() {
		var width = document.body.clientWidth;
		var height = document.body.clientHeight; 
		$("#imgDiv").css({
			"width" : width
		});
	}
</script>
<style type="text/css">
*{
	
}
body{
	background-position: center;
}
#imgDiv{
	position:absolute;
	float:left;
	top:0px;
	z-index: -1;
}

#loginDiv {
	margin-top:300px;
	margin-left: auto;
	margin-right: auto;
	width: 400px;
}

.colorFont{
	color:black;
	display: inline;
}


</style>
</head>
<body>
		<img id="imgDiv" alt="" src="${pageContext.request.contextPath}/img/userLoginPic.jpg" />
		<div>请输入查询订单的日期：
			<form action="${pageContext.request.contextPath}/queryOrderByDate.action">
				<input style="display: inline;" name="order.orderTime" type="text"></input>
				<input value="sure"  type="submit"/>
			</form>
		</div>
		<c:forEach items="${order.orderList}" var="list" varStatus="vs">
			<div class="message">
				<div class="orderId">orderId:${list.orderId}</div>
				<pre>${list.orderDetail}</pre>
				<br/>
			</div>
		</c:forEach>
		
		
</body>
</html>