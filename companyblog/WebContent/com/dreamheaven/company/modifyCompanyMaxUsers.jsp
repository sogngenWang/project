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

	 
	});
</script>
<style>
.userImg{
	width: 60px; 
	height: 60px;
	display: inline;
}
.companyUserInfoClass{
	height: 80px;
}
.companyUserInfo_detail{
	display:block;
}
.companyUserInfoClass{
	display: block;
}

</style>
</head>
<body>
	<c:forEach items="${companyInfo.companyInfoList}" var="companyInfoList">
			
			<div class="companyUserInfo_detail" id="companyUserInfo_detail_${companyInfoList.uid}">
				<div>
				uid : ${companyInfoList.uid}
				<br/>
				公司id : ${companyInfoList.companyId}
				<br/>
				公司名称 : ${companyInfoList.companyName}
				<br/>
				公司地址 : ${companyInfoList.companyAddress}
				<br/>
				公司联系方式 : ${companyInfoList.companyContact}
				<br/>
				公司描述 : ${companyInfoList.companyDescribe}
				<br/>
				最大用户数量 : 
				<form action="${pageContext.request.contextPath}/modifyCompanyMaxUsers.action" method="post" >
					<input type="hidden" value="${companyInfoList.uid}" name="uid" />
					<input type="text" value="${companyInfoList.maxUsers}" name="maxUsers" />
					<input type="submit" value="确定修改">
				</form>
				
				</div>
				<br/>
				</div>

		<br/>
	</c:forEach>
</body>
</html>