<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>首页</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/main.css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script src="${pageContext.request.contextPath}/js/main.js"></script>
		<script>
			
			function onManuButtonClick(manuId) {
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
		<div
			style="text-align: right; height: 20px; background-color: lime; padding: 0; display: block;"
			class="banner" id="banner">
			<!-- 最上栏，显示当前用户登录信息，以及注销超链接 -->
			你好，用户${user}
			<a href="logout.action">注销</a>
		</div>
		<div
			style="height: 600px; background-color: olive; padding: 0; display: block;">
			<div class="trigger1"
				style="height: 100%; border: none; padding: 0; background-color: white; display: block;">
				      
				<div class="trigger2"
					style="height: 100%; border: none; padding: 0; background-color: blue;">
					<!-- 左侧栏 -->
					<div class="leftBar"
						style="width: 30%; height: 100%; background-color: green; padding: 0; display: block;">
						<div class="divOfLeftHead" id="divOfBodyHead"
							style="width: 100%; height: 70%; background-color: navy; padding: 0; display: block;">
							<!-- 左上栏，上用来显示当前已定菜信息 -->
						</div>
						<div class="divOfBodyLeft" id="divOfBodyLeft"
							style="width: 100%; height: 30%; background-color: maroon; padding: 0; display: block;">
							<!-- 左下角用来显示生成订单等信息 -->
						</div>
					</div>
					<!-- 右侧栏 -->
					<div class="rightBar"
						style="left: 30%; top: -100%; width: 70%; height: 100%; padding: 0; background-color: gray; position: relative; display: block">

						<div class="divOfRightHead" id="divOfRightHead"
							style="width: 100%; height: 20%; padding: 0; background-color: yellow; position: relative; display: block;">
							<!-- 右上栏，用来显示配菜信息 -->
						</div>
						<div class="divOfBodyRight" id="divOfBodyRight"
							style="width: 100%; height: 100%; padding: 0;; display: block;">
							<!-- 左侧用来显示分类信息 -->
							<div class="divOfBodyRight_left" id="divOfBodyRight_left"
								style="width: 30%; height: 80%; padding: 0; background-color: purple; display: block;">
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
							<!-- 右侧用来显示菜单信息 -->
							<div class="divOfBodyRight_right" id="divOfBodyRight_right"
								style="top: -80%; left: 30%; width: 70%; height: 80%; padding: 0; background-color: red; position: relative; display: block;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</body>
</html>