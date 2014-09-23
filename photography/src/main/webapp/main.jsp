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
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/dream.js"></script>

<title>拍的好!拍的好</title>
<script type="text/javascript">
	var kinds;
	$(document).ready(function() {
		//获取参数值
		kinds = getParameter("kinds");
		if (null == kinds) {
			kinds = 1;
		}
		displayArea();
	});

	function displayArea() {
		//获取到所有的区域Area，通过ajax后台查询
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/listArea",//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定  
				//json = eval(json);// 注意options，如果不写Options ，下面的写法就是json.options.length
				//清空该标签下的所有数据
				$("#listArea").html("");
				alert(json.data.list[5].areaid);
				//for ( var i = 0; i < json.length; i++) {
				//	$("#listArea").append(  "地区id:"+json[i].areaid + "<br/>" + "地区名称:" + json[i].areaname);
				//}
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}

	function displayCommodity() {
		//获取到所有的商品信息，通过kindsId过滤掉部分

	}
</script>


</head>

<body>
	<div id="listArea"></div>
	<div id="listCommodity"></div>


	显示所有地区listArea 显示所有商品listCommodity


</body>
</html>
