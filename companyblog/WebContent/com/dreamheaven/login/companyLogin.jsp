<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		//设置body背景图片的宽度
		setBackGroundImg();
	});

	function cancleAll() {
		$("#userName").val("");
		$("#password").val("");
	}

	function setBackGroundImg() {
		var width = document.body.clientWidth;
		var height = document.body.clientHeight; 
		$("#imgDiv").css({
			"width" : width
		});
	}
</script>
<style type="text/css">
*{
	
}
body{
	background-position: center;
}
#imgDiv{
	position:absolute;
	float:left;
	top:0px;
	z-index: -1;
}

#loginDiv {
	margin-top:300px;
	margin-left: auto;
	margin-right: auto;
	width: 400px;
}

.colorFont{
	color:black;
	display: inline;
}


</style>
</head>
<body>
	<img id="imgDiv" alt="" src="${pageContext.request.contextPath}/img/userLoginPic.jpg" />
	<div id="loginDiv">
	
	<form action="login.action" method="post">
		userName: <input type="text" id="userName" name="user.userName" required placeholder="用户名不能为空" />  
		<br/><br/>
		password: <input type="password" id="password" name="user.password" required placeholder="密码不能为空" />
		
		<div id="passwordRelation">
			<input type="submit" value="sure" />
			<input type="button" value="cancle" onclick="cancleAll();" />
			<a href="${pageContext.request.contextPath}/com/dreamheaven/register/registerCompany.jsp">注册企业用户</a>
		</div>
		<div style="color: red;">${user.errorInfo}</div>
		
	</form>
	
	</div>
</body>
</html>