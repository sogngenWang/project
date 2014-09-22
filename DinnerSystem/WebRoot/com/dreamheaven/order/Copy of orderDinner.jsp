<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script src="${pageContext.request.contextPath}/js/main.js"></script>
		<script>
	function onManuButtonClick(t){
		alert(t);
	}
</script>
		<style>
* {
	color: black;
}
</style>

	</head>
	<body>
		<img id="imgDiv" alt=""
			src="${pageContext.request.contextPath}/img/mainBackGround.gif" />

		<div id="contain">
			<!--页面内容 -->
			<div id="bodyPage">
				<!--侧边栏，用于显示主要操作-->
				<div id="leftSideBar">
					
				</div>
				<!--内容显示-->
				<div id="bodyContent">
					<c:forEach items="${manu.manuList}" var="manuList" varStatus="vs1">

						<div class="message">
							<div class="className" id="className_${manuList.classId}">
								<button name="className_bt" value="${manuList.className}" onclick="onManuButtonClick(${manuList.classId})"/>
							</div>
							<c:forEach items="${manuList.dishList}" var="dishList"
								varStatus="vs2">
								<div class="message">
									<div class="dishId">
										dishId:${dishList.dishId}
									</div>
									<br />
									<div class="dishName">
										dishName:${dishList.dishName}
									</div>
									<div class="dishCash"> 
										dishCash:${dishList.dishCash}
									</div>
									<c:forEach items="${dishList.ingredientList}" var="ingredientList"
										varStatus="vs3">
										<div class="message">
											<div class="ingredientId">
												ingredientId:${ingredientList.ingredientId}
											</div>
											<br />
											<div class="ingredientName">
												ingredientName:${ingredientList.ingredientName}
											</div>
											<div class="ingredientCash">
												ingredientCash:${ingredientList.ingredientCash}
											</div>

											<br />
											<br />
										</div>
									</c:forEach>
									<br />
									<br />
								</div>
							</c:forEach>

							<br />
							<br />
						</div>
					</c:forEach>

				</div>
				<!--虚线-->
				<div id="dottedLine"></div>
				<!--页脚-->
				<div id="foot"></div>
			</div>
	</body>
</html>
