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
		<script >
			$(document).ready(function(){
				//点击支付
				$(".payment").click(function(){
					var id = $(this).attr("id");
					$("#stateHidden").val(id);
					$("#sureForm").submit();
				});
				
				
			});
			
			//点击分类按钮的时候
			function onManuButtonClick(classId) {
			   //隐藏该分类id对应的所有的菜肴
				$("#divOfBodyRight_right").children().css("display","none");
			
				//显示该分类id对应的所有菜肴
				$("#divOfBodyRight_right .dish_"+classId).css("display","block");
				
			}
			//点击点菜按钮的时候
			function onAddClick(dishId,dishName,dishCash){
				var htmlText = $("#divOfBodyHead").html();
				//添加的时候先往左侧栏添加该菜单
				$("#divOfBodyHead").html(htmlText+
				"<div class='orderDish_"+dishId+"' style='height: 20px; display:block'>"+
				dishName + "  "+ 
				"<div class='dishCash' style='display:inline;'>" + dishCash  + "</div>" +
				"<p id='cencle_dish_"+dishId+"' style='text-align: right; display:inline;' class='cencle_dish' onclick='onDelOrderDish($(this));' >  删除</p>"
				 + "</div>");
				//重新计算总价格
				calculate(dishCash);
				var message = $("#dishHidden").val();
				$("#dishHidden").val(message+dishName+"\t"+dishCash+"\n");
			}
			
			//计算当前所点的菜的总价格
			function calculate(dishCash){
				var value = parseFloat($(".allCash").text());
				value =	value + parseFloat(dishCash);
				$(".allCash").text(value);
				$("#cashHidden").val(value);
			}
			
			function onShowIngredientClick(dishId){
			  	$(".divOfRightHead").children().css("display","none");
				//除了点击的该项之外其他全部隐藏
				$(".ingredient_"+dishId).css("display","block");
			}
			
			function onDelOrderDish(obj){
				value = $(obj).parent().find(".dishCash").text() ;
				calculate("-"+value);
				$(obj).parent().remove();
			}
			
			
			
		</script>
		<style>
		* {
			color: black;
		}
		</style>
	</head>
	<body>
		<div style="width:100%; text-align: right; height: 20px; background-color: #fff; padding: 0; display: block;"
			class="banner" id="banner">
			<!-- 最上栏，显示当前用户登录信息，以及注销超链接 -->
			你好，用户${user}
			<a href="${pageContext.request.contextPath}/logout.action">注销</a>
		</div>
		<div style="height: 600px; background-color: #000 padding: 0; display: block;">
			<div class="trigger1"
				style="height: 100%; border: none; padding: 0; background-color: #eee; display: block;">
				      
				<div class="trigger2"
					style="height: 100%; border: none; padding: 0; background-color: #ddd;">
					<!-- 左侧栏 -->
					<div class="leftBar"
						style="width: 30%; height: 100%; background-color: #ded; padding: 0; display: block;">
						<div class="divOfLeftHead" id="divOfBodyHead"
							style="width: 100%; height: 70%; background-color: #ccc; padding: 0; display: block;">
							<!-- 左上栏，上用来显示当前已定菜信息 -->
						</div>
						<div class="divOfBodyLeft" id="divOfBodyLeft"
							style="width: 100%; height: 30%; background-color: #bbb; padding: 0; display: block;">
							<!-- 左下角用来显示生成订单等信息 -->
							<form id="sureForm" action="${pageContext.request.contextPath}/sureOrder.action" method="post">
								<input type="hidden" id="cashHidden" name="order.orderCash" value="" />
								<input type="hidden" id="stateHidden" name="order.orderState" value="" />
								<input type="hidden" id="dishHidden" name="dishMessage" value="" />
								<div class="payment" id="1" style="width: 100%; height: 15%;">现金支付</div>
								<div class="payment" id="2" style="width: 100%; height: 15%;">信用卡支付</div>
								<div class="payment" id="3" style="width: 100%; height: 15%;">优惠卷支付</div>
							</form>
							总金额：<div class="allCash" style="display: inline;" >0</div>
							<!-- 
							<div class="payment" id="1" style="width: 100%; height: 20%;">
							现金支付</div>
							<div class="payment" id="2" style="width: 100%; height: 20%;">
							<a href="${pageContext.request.contextPath}/sureOrder.action?order.orderState=2">
							信用卡支付</a></div>
							<div class="payment" id="3" style="width: 100%; height: 20%;">
							<a href="${pageContext.request.contextPath}/sureOrder.action?order.orderState=3">
							优惠卷支付</a></div>
							 -->
						</div>
					</div>
					<!-- 右侧栏 -->
					<div class="rightBar"
						style="left: 30%; top: -100%; width: 70%; height: 100%; padding: 0; background-color: #aaa; position: relative; display: block;">

						<div class="divOfRightHead" id="divOfRightHead"
							style="width: 100%; height: 20%; padding: 0; background-color: #999; position: relative; display: block;">
							<!-- 右上栏，用来显示配菜信息 -->
							<c:forEach items="${manu.manuList}" var="manuList" varStatus="vs1">
								<c:forEach items="${manuList.dishList}" var="dishList" varStatus="vs2">
									<div class="ingredient_${dishList.dishId}" style="display: none;">
										<c:forEach items="${dishList.ingredientList}" var="ingredientList" varStatus="vs3">
												<div class="ingredientName_${ingredientId}">
													ingredientName:${ingredientList.ingredientName}
												</div>
												<div class="ingredientCash_${ingredientId}">
													ingredientCash:${ingredientList.ingredientCash}
												</div>
										</c:forEach>
									</div>
								</c:forEach>
							</c:forEach>
						</div>
						<div class="divOfBodyRight" id="divOfBodyRight"
							style="width: 100%; height: 100%; padding: 0; display: block;">
							<!-- 左侧用来显示分类信息 -->
							<div class="divOfBodyRight_left" id="divOfBodyRight_left"
								style="width: 30%; height: 80%; padding: 0; background-color: #777; display: block;">
									<c:forEach items="${manu.manuList}" var="manuList" varStatus="vs1">
										<div class="className" id="className_${manuList.classId}">
											<button name="className_bt" id="className_bt_${manuList.classId}" onclick="onManuButtonClick('${manuList.classId}')" >${manuList.className}</button>
										</div>
									</c:forEach>
							</div>
							<!-- 右侧用来显示菜单信息 -->
							
							<div class="divOfBodyRight_right" id="divOfBodyRight_right"
								style="top: -80%; left: 30%; width: 70%; height: 80%; padding: 0; background-color: #888; position: relative; display: block;">
								<c:forEach items="${manu.manuList}" var="manuList" varStatus="vs1">
									<c:forEach items="${manuList.dishList}" var="dishList" varStatus="vs2">
									<div class="dish_${manuList.classId}" style="display: none;border: thin; border-color: black;">
										<div class="dishName_${manuList.classId}" style="height: 20px; display:block;">
											dishName:${dishList.dishName}
										</div>
										<div class="dishCash_${manuList.classId}" style="height: 20px; display:block;"> 
												dishCash:${dishList.dishCash}
										</div>
										<p style="display:inline;" id="add_dish_${manuList.classId}_${dishList.dishId}" class="add_dish" onclick="onAddClick('${dishList.dishId}','${dishList.dishName}','${dishList.dishCash}')">添加</p>
										<p style="display:inline;" id="show_ingredient_${dishList.dishId}" class="show_ingredient" onclick="onShowIngredientClick('${dishList.dishId}')">&nbsp;&nbsp;&nbsp;配菜</p>
										
									</div>
									</c:forEach>
								</c:forEach>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</body>
</html>