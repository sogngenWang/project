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
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定  
				//json = eval(json);
				//清空该标签下的所有数据
				alert("ajax success....");
				$("#listArea").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// TODO 加入到页面的标签元素中
						alert(array_element.areaid+"|"+array_element.areaname);
					}
				}else if (state == "BusinessException"){
					//业务异常
					alert("业务异常:"+code);
				} else {
					//其他非业务异常
					alert("系统异常:"+code);
				}

			},
			error : function() {
				alert("ajax error....");
			}
		});
	}

	function displayCommodity() {
		//获取到所有的商品信息，通过kindsId过滤掉部分
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/listCommodity",//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
				alert("ajax success....");
				$("#listCommodity").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// TODO 加入到页面的标签元素中
						alert(array_element.commodityid+"|"+array_element.commodityname+"|"+array_element.commodityprice+"|"+array_element.commoditydetail+"|"+array_element.commoditypic+"|"+array_element.committime+"|"+array_element.lastupdatetime+"|"+array_element.kindsid);
					}
				}else if (state == "BusinessException"){
					//业务异常
					alert("业务异常:"+code);
				} else {
					//其他非业务异常
					alert("系统异常:"+code);
				}
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
</script>


</head>

<body>
	<div id="listArea"></div>
	<div id="listCommodity"></div>

	显示所有地区listArea 显示所有商品listCommodity


</body>
</html>
