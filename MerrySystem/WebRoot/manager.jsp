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
<meta charset="utf-8">
<title>merry</title>

<script type="text/javascript">
	$(document).ready(function() {
		$("#addNews").click(function() {
			window.location.href="addMessage.jsp";
		});
		
		$("#updateNews").click(function() {
			window.location.href="listMessagesBeforeUpdate.jsp";
		});
		
		$("#deleteNews").click(function() {
			window.location.href="listMessagesBeforeDelete.jsp";
		});
		
	});
	
	
	/**
	 显示关于协会页面
	*/
	function displayAboutAssociation(){
		request = "";
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "text",//返回json格式的数据  
			// url : "../testController?request="+request,//要访问的后台地址  
			url : "aboutAssociationAction.action",
			contentType : "application/text;charset=utf-8",
			data : {request:request}, //要发送的数据 
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				json = eval('(' + json + ')');   
				$("#clickAboutAssociationDiv").html("");
				$("#clickAboutAssociationDiv").append(json.aboutAssociation);
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
	

</script>

<!-- 800px高*1600px宽 -->
<style>
body {
	margin: 0 auto;
	width: 980px;
	height: 800px;
}
</style>
</head>
<body>

<button id="addNews">添加新闻</button>
<button id="deleteNews">删除新闻</button>
<button id="updateNews">修改新闻</button>

</body>
</html>
