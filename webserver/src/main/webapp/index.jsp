<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript" src="./js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#testbutton").click(function() {
			display();
		});
	});

	function display() {
		//获取到所有的区域Area，通过ajax后台查询
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "string",//返回json格式的数据  
			url : "./testController",//要访问的后台地址  
			contentType : "application/string;charset=utf-8",
			data : "", //要发送的数据 
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				alert(json);
				//json = eval(json);
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
</script>
</head>
<body>
	<button id="testbutton" value="test">button</button>
</body>
</html>
