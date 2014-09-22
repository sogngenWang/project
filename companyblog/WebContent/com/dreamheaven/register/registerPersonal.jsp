<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.js"></script>
<script src="${pageContext.request.contextPath}/js/dateJs/WdatePicker.js"></script>
<script type="text/javascript">

	$(function() {
		/* 
		$("#uploadHeadFile").change(function(e) {
			
			alert($("#uploadHeadFile").value);
			
			var obj= window.document.getElementById("uploadHeadFile");
			alert(obj);
			alert(getFullPath(obj)+"---------------");
			
			$("#displayHeadImg").attr("src", "file:///" + getFullPath(obj));
		});
		
		*/
		$("#uploadHeadFile").change(function(e) {
				$("#displayHeadImg").attr("src", $("#uploadHeadFile").val());
			});
	
		});

	function getFullPath(obj) {
		if (obj) {
			//ie 
			if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
				obj.select();
				return document.selection.createRange().text;
			}
			//firefox 
			else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
				for ( var number in obj.files) {
					alert(number + "**********" + obj[number]);
				}
				if (obj.files) {
					alert(obj.files.item(0).getAsDataURL());
					return obj.files.item(0).getAsDataURL();
				}

				return obj.value;
			}

			return obj.value;
		}
	}
</script>
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
#button {
	margin: auto;	
}
</style>


</head>
<body>
	<div id="pageFrame">
		<form action="com/dreamheaven/register/addPersonalUser.action" method="post" enctype="MULTIPART/FORM-DATA" >
			<div class="field">
				<div class="textDiv">用户名：</div>
				<div class="valueDiv">
					<input type="text" name="user.userName" required ></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">密码：</div>
				<div class="valueDiv">
					<input type="password" name="user.password" required ></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">昵称：</div>
				<div class="valueDiv">
					<input type="text" name="userInfo.nickName" required ></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">头像：</div>
				<div class="valueDiv">
					<input type="file" name="userInfo.headFile" id="uploadHeadFile"></input>
				</div>
				<div id="displayHeadImgDiv">
					<img id="displayHeadImg" src="${pageContext.request.contextPath}/userheadimg/default.gif"  style="width: 150px;height: 150px;" />
				</div>
			</div>
			<div class="field">
				<div class="textDiv">年龄：</div>
				<div class="valueDiv">
					<input type="text" name="userInfo.age"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">性别：</div>
				<div class="valueDiv">
					<input type="text" name="userInfo.sex"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">出生年月：</div>
				<div class="valueDiv">
					<input type="text" class="Wdate" name="userInfo.birthday"
						onclick="WdatePicker();"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">兴趣爱好：</div>
				<div class="valueDiv">
					<input type="text"></input>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">所属公司：</div>
				<div class="valueDiv">
					<select name="userInfo.companyId">
						<option value="0">--请选择--</option>
						<c:if test="${not empty companyInfoList}">
							<c:forEach items="${companyInfoList}" var="companyInfo">
								<option value="${companyInfo.companyId}">${companyInfo.companyName}</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
			</div>
			<div id="button">
			<input type="submit" value="确定">
			<input type="reset" value="重置">
			</div>
		</form>
	</div>

</body>
</html>