<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>add store</title>

<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		showStore();
		
		$("#submit").click(function(){
			var kindsId = $("#kindsSelect  option:selected").attr("attr");
			if(kindsId == "-1"){
				$("#storeInfo").html("请选择kinds类别");
			}else{
				submitAction();
			}
		});
		
	});
	

	function showStore() {
		//获取到所有的区域Area，通过ajax后台查询
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/listKindsAjaxAction",//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
					var Objs = json.list;
					var string = "";
					$("#kindsSelect").html("<option select=\"selected\" value=\"-1\">--请选择商家分类--</option>");
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// 加入到页面的标签元素中
						string+="<option value=\""+array_element.kindsId+"\">";
						string+=array_element.kindsName;
						string+="</option>";
					}
					$("#kindsSelect").append(string);
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
	
	function submitAction() {
		
		//获取到所有的区域Area，通过ajax后台查询
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/addStoreAjaxAction.action?passwd="+ $("#passwd").val() + 
			"&store.storeName=" +  $("#storeName").val() +
			"&store.storeAddress=" + $("#storeAddress").val() +
			"&store.storePosition="+  $("#storePosition").val() +
			"&kindsId=" + $("#kindsSelect  option:selected").val() ,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
				$("#storeInfo").html(json.info);
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
	
	
	
</script>
</script>
</head>


<body>
	添加商家
	<!-- <form id="addStore" method="post" action="${pageContext.request.contextPath}/addStoreAction.action"> -->
		<p style="margin:3px;">管理员密码:</p>
		<input id="passwd" name="passwd" type="text" />
		<p style="margin:3px;">商家名字:</p>
		<input id="storeName" name="store.storeName" type="text" />
		<p style="margin:3px;">商家地址:</p>
		<input id="storeAddress" name="store.storeAddress" type="text" />
		<p style="margin:3px;">商家位置信息:</p>
		<input id="storePosition" name="store.storePosition" type="text" /> 
		<div><select id="kindsSelect" name="kindsId"></select></div>
		<div><input id="submit" type="button" value="提交"></div>
	<!-- 	</form> -->

	<div style="color: red;" id="storeInfo">${store.storeInfo}</div>
</body>
</html>
