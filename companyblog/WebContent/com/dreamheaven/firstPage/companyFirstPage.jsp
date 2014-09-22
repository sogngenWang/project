<?xml version="1.0" encoding="UTF-8" ?> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>main page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript">

</script>
<style>

</style>
</head>
<body>
	公告信息：
	<div id="myAnnContent">
		<c:forEach items="${companyAnnouncement.companyAnnouncementList}" var="companyAnnouncementList" varStatus="vs">
			<div class="message">
				<div class="aid">公告 编号：${companyAnnouncementList.aid}</div>
				<br/>
				<div class="annContent">${companyAnnouncementList.annContent}</div>
				<br/><br/>
			</div>
		</c:forEach>
	</div>
</body>
</html>