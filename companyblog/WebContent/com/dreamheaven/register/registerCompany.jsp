<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.js"></script>
<script
	src="${pageContext.request.contextPath}/js/dateJs/WdatePicker.js"></script>

<style>
#pageFrame {
	margin: 10px auto 10px auto;
}

.field {
	width: 400px;
	margin: 10px auto 10px auto;
}

.textDiv {
	margin: 0px 0px 0px 0px;
	display: inline-block;
	width: 80px;
}

.valueDiv {
	display: inline-block;
	margin: 0px 0px 0px 60px;
}
</style>


</head>
<body>
	<div id="pageFrame">
		<form action="${pageContext.request.contextPath}/addCompany.action" method="post">
			<div class="field">
				<div class="textDiv">用户名：</div>
				<div class="valueDiv">
					<input type="text" name="user.userName" required></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">密码：</div>
				<div class="valueDiv">
					<input type="password" name="user.password" required></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">公司名字：</div>
				<div class="valueDiv">
					<input type="text" name="companyInfo.companyName" required ></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">公司地址：</div>
				<div class="valueDiv">
					<input type="text" name="companyInfo.companyAddress"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">公司联系方式：</div>
				<div class="valueDiv">
					<input type="text" name="companyInfo.companyContact"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">公司描述</div>
				<div class="valueDiv">
					<input type="text" name="companyInfo.companyDescribe"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">公司最大用户数：</div>
				<div class="valueDiv">
					<input type="text" name="companyInfo.maxUsers" required></input>
				</div>
			</div>
			
			<input type="submit" value="确定">
			<input type="reset" value="取消">
		</form>
	</div>
</body>
</html>