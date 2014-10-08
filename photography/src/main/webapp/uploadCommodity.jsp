<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>新闻添加页</title>
<!-- 以下1行为upload空间  -->
<script src="./js/jquery-1.9.1.js" type="text/javascript"></script>

<script type="text/javascript">
	    $(document).ready(function() {
			$("#submit").click(function(){
				$("formAction").submit(test());
			});
			
		});
	    function test(){
	    	alert($("#myiframe body pre").html());
	    }
	    
	    function uploadCallBack(message){
	    	alert(message);
	    }
	    
</script>
</head>
<body>
	<iframe id="myiframe" style="display: none"></iframe>
	<div style="color: red;">${message.messageInfo}</div>
	<!-- 上传用户头像  -->
	<form action="./upload" method="post" enctype="multipart/form-data" id="formAction" target="myiframe">
		<div id="queue"></div>
		<input id="uploadImg" name="uploadImg" type="file" multiple="true">
		<button id="submit">222</button>
	</form>
</body>
</html>