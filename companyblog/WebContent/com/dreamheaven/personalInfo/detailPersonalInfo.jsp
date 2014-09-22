<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.js"></script>
<script src="${pageContext.request.contextPath}/js/dateJs/WdatePicker.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
			$("#pageFrame").find("*").not("#backButton").each(function(){
				$(this).attr("disabled","disabled");
			});
			
			$("#backButton").click(function(){
				window.back();
			});
			
			
	});
	
	function initCompany(companyId)
	{

		$("#companySelect option[value='"+ companyId +"']").attr("selected","selected");
	}
	
	

</script>
<style>
*{
	
}
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
#button {
	margin: auto;	
}
</style>


</head>
<body onload="initCompany(${userInfo.companyId})">
	<div id="pageFrame" style="disabled:true">
			<div class="field">
				<div class="textDiv">昵称：</div>
				<div class="valueDiv">
					<input type="text" name="userInfo.nickName" value="${userInfo.nickName}"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">头像：</div>
				<div id="displayHeadImgDiv">
					<img id="displayHeadImg" src="${pageContext.request.contextPath}/userheadimg/${userInfo.headImgPath}"  style="width: 150px;height: 150px;" />
				</div>
			</div>
			<div class="field">
				<div class="textDiv">年龄：</div>
				<div class="valueDiv">
					<input type="text" name="userInfo.age" value="${userInfo.age}"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">性别：</div>
				<div class="valueDiv">
					<input type="text" name="userInfo.sex" value="${userInfo.sex}"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">出生年月：</div>
				<div class="valueDiv">
					<input type="text" class="Wdate" name="userInfo.birthday" value="${userInfo.birthday}"
						onclick="WdatePicker();"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">兴趣爱好：</div>
				<div class="valueDiv">
					<input type="text" name="userInfo.hoby" value="${userInfo.hoby}"></input>
				</div>
			</div>
		<div class="field">
			<div class="textDiv">所属公司：</div>
			<div class="valueDiv">
				<select name="userInfo.companyId" id="companySelect">
					<option value="0">--请选择--</option>
					<c:if test="${not empty companyInfoList}">
						<c:forEach items="${companyInfoList}" var="companyInfo">
							<option value="${companyInfo.companyId}">${companyInfo.companyName}</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
		</div>
		<div>
			<input id="backButton" type="button" value="返回">
		</div>
	</div>

</body>
</html>