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
		
		<div>
			支付成功，订单详情如下：
		</div>
		<div>
			=============
			<pre>
			${order.orderDetail}
			</pre>
			=============
		</div>
		<a href="${pageContext.request.contextPath}/com/dreamheaven/manu/manu.jsp">确定</a>
		<a href="${pageContext.request.contextPath}/printOrder.action?order.orderDetail=${order.orderDetail}">打印订单</a>
		
		
</body>
</html>