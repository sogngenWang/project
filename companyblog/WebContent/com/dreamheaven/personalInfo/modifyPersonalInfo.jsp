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
<script
	src="${pageContext.request.contextPath}/js/dateJs/WdatePicker.js"></script>

<script type="text/javascript">
	$(function() {
		$("#uploadHeadFile").change(function(e) {
			var obj = window.document.getElementById("uploadHeadFile");
			var filePathInLocal = getFullPath(obj);
			alert(filePathInLocal + "***************");
			$("#displayHeadImg").attr("src", "file:///" + filePathInLocal);
		});
	});

	//获得上传文件的路径
	function getFullPath(obj) {
		if (obj) {
			//ie 
			if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
				obj.select();
				return document.selection.createRange().text;
			}
			//firefox 
			else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {

				if (obj.files) {
					alert(obj.files.item(0).getAsDataURL());
					return obj.files.item(0).getAsDataURL();
				}
				return obj.value;
			}
			return obj.value;
		}
	}
	
	function initCompany(companyId)
	{

		$("#companySelect option[value='"+ companyId +"']").attr("selected","selected");
	}
</script>
<style>
* {
	
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
.buttonGroup {
	margin: auto;
	padding: auto;
}
</style>


</head>
<body onload="initCompany(${userInfo.companyId})">
	<div id="pageFrame">

		<form action="com/dreamheaven/register/addPersonalUser.action"
			method="post" >

			<div class="field">
				<div class="textDiv">旧密码：</div>
				<div class="valueDiv">
					<input type="text" name="user.password"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">新密码：</div>
				<div class="valueDiv">
					<input type="text" name="user.password"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">新密码：</div>
				<div class="valueDiv">
					<input type="text" name="user.password"></input>
				</div>
			</div>
			<div class="buttonGroup">
				<input type="submit" value="确定" /> <input type="reset" value="重置" />
				<input type="reset" value="返回" />
			</div>
		</form>
		<form id="modifyMyPersonalUserForm"
			action="com/dreamheaven/register/modifyMyPersonalUser.action"
			method="post">
			<div class="field">
				<div class="textDiv">昵称：</div>
				<div class="valueDiv">
					<input type="text" name="userInfo.nickName"
						value="${userInfo.nickName}"></input>
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
					<input type="text" class="Wdate" name="userInfo.birthday"
						value="${userInfo.birthday}" onclick="WdatePicker();"></input>
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

			<div class="buttonGroup">
				<input type="submit" value="确定" /> <input type="reset" value="重置" />
				<input type="reset" value="返回" />
			</div>
		</form>

		<form id="modifyMyPersonalUserHeadImg"
			action="com/dreamheaven/register/modifyMyPersonalUserHeadImg.action"
			enctype="MULTIPART/FORM-DATA">
			<div class="field">
				<div class="textDiv">头像：</div>
				<div class="valueDiv">
					<input type="file" name="userInfo.headFile" id="uploadHeadFile" />
				</div>
				<div id="displayHeadImgDiv">
					<img id="displayHeadImg"
						src="${pageContext.request.contextPath}/userheadimg/default.gif"
						style="width: 150px; height: 150px;" />
				</div>
			</div>

			<div class="buttonGroup">
				<input type="submit" value="确定" /> <input type="reset" value="重置" />
				<input type="reset" value="返回" />
			</div>
		</form>

	</div>

</body>
</html>