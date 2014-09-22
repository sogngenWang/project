<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			//设置显示的文本控件等为只读
			$("#pageFrame").find("*").each(function(){
				$(this).attr("disabled","disabled");
			});
			//隐藏所有除了searchButton之外的div(body的子元素 )
			$("body>div").not("#searchButton").each(function(){
				$(this).hide();
			});
			$("#displayAllUser").show();
			
			$("#search").click(function(){
				//先判断输入框内是否有值，如果没有则显示全部的List，如果有则ajax查询
				var searchUser = document.getElementById("searchUserName");
				var searchUserName = searchUser.value;
				if(searchUserName==null || searchUserName=="" ){
					//显示本公司的所有员工
					$("body>div").not("#searchButton").each(function(){
						$(this).hide();
					});
					$("#displayAllUser").show();
				}
				else
				{
					//调用ajax方法
					ajaxSubmit(searchUserName);
				}
			});
			
	});
	function ajaxSubmit(searchUserName)
	{
		$.ajax({  
	      	type: "post",//使用post方法访问后台  
	        dataType: "json",//返回json格式的数据  
	        url: "${pageContext.request.contextPath}/searchUser.action?searchUserName="+searchUserName,//要访问的后台地址  
	        contentType: "application/json;charset=utf-8",  
	        data: {"searchUserName":searchUserName}, //要发送的数据  
	        success: function(json){//data为返回的数据，在这里做数据绑定  
	        	if(json.flag == 1)
	        	{
	        		//查询不到结果，显示提示信息	
	    			$("body>div").not("#tipsAfterNoPerson").each(function(){
	    				$(this).hide();
	    			});
	        		$("#tipsAfterNoPerson").show();
	        		return ;
	        	}
	        	//获得所有信息
				$("#displayAllUser").hide();
				$("#pageFrame").show();
				
				$("#nickName_detail").val(json.nickName);
				$("#age_detail").val(json.age);
				$("#sex_detail").val(json.sex);
				$("#birthday_detail").val(json.birthday);
				$("#hoby_detail").val(json.hoby);
				
				$("#headImg_detail").attr("src","${pageContext.request.contextPath}/userheadimg/" + json.headImgPath);
	        	
	        	alert("success......Test");
	        },
	        error: function(){
	        	alert("ajax error....");
	        }
		
	     });    
	}
	
	function initCompany(companyId)
	{
		$("#companySelect option[value='"+ companyId +"']").attr("selected","selected");
	}
	
	function moreBig(id) {
		
		$("#headImg_"+id).animate({
			height : '100px',
			width : '100px'
		});
		
		$("#userInfo_" + id).animate({
			height : '120px'
		});
		
		$("#userInfo_detail_" + id).show();

	}
	
	function recover(id) {
		
		$("#headImg_"+id).animate({
			height : '60px',
			width : '60px'
		});
		
		$("#userInfo_" + id).animate({
			height : '80px'
		});
		
		$("#userInfo_detail_" + id).hide();

	}
</script>
<style>
*{
	
}
#pageFrame {
	margin: 10px auto 10px auto;
	display: none;
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
#tipsAfterNoPerson{
	display: none;
}
.userImg{
	width: 60px; 
	height: 60px;
	display: inline;
}
.userInfoClass{
	height: 80px;
}

</style>

</head>
<body onload="initCompany(${userInfo.companyId})">
	<div id="searchButton">
		<div>
			请输入用户名(只能搜索当前公司下的员工)
		</div>
		<input type="text" id="searchUserName"/>
		<input type="button" id="search" value="搜索"/>
	</div>
	<div id="detailUser">
	
	</div>
	<!-- 首先显示当前公司的所有用户 -->
	<div id="displayAllUser">
		显示全部员工信息:
		<c:forEach items="${userInfo.userInfoList}" var="userInfoTemp" >
			<div id="userInfoBy${userInfoTemp.uid}">
				<div class="userInfoClass" id="userInfoTemp_${userInfoTemp.uid}">
					<img class="userImg" id="headImg_${userInfoTemp.uid}" align="left"
						src="${pageContext.request.contextPath}/userheadimg/${userInfoTemp.headImgPath}"
						onclick="moreBig('${userInfoTemp.uid}')"
						onmouseout="recover('${userInfoTemp.uid}')" />
					${userInfoTemp.nickName}<br />
					<div class="userInfo_detail"
						id="userInfo_detail_${userInfoTemp.uid}" style="display: none;">
						<div>
							性别:
							<c:if test="${userInfoTemp.sex eq 1}">
					男
					</c:if>
							<c:if test="${userInfoTemp.sex eq 2}">
					女
					</c:if>
						</div>
						年龄:${userInfoTemp.age}
						<fmt:parseDate value="${userInfoTemp.birthday}" type="date"
							var="birthday" pattern="yyyyMMdd" />
						<br /> 出生年月:
						<fmt:formatDate value="${birthday}" pattern="yyyy年MM月dd日" />
						<br /> 兴趣爱好:${userInfoTemp.hoby}
					</div>

				</div>
				<br />
				<br />
			</div>
		</c:forEach>
	</div>

	<!-- 如果点搜索之后，搜索框内非空，但是本公司没有此人信息则显示该提示信息 -->
	<div id="tipsAfterNoPerson">
		error. 无该用户信息
	</div>
	
	<!-- 点搜索之后如果为非空并且该用户是本公司的员工则显示员工详细信息 -->
	<div id="pageFrame" >
			<div class="field">
				<div class="textDiv">昵称：</div>
				<div class="valueDiv">
					<input type="text" id="nickName_detail" readonly="readonly"/>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">头像：</div>
				<div id="displayHeadImgDiv">
					<img id="headImg_detail" src=""  style="width: 150px;height: 150px;" /> 
				</div>
			</div>
			<div class="field">
				<div class="textDiv">年龄：</div>
				<div class="valueDiv">
					<input type="text" id="age_detail" readonly="readonly"/>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">性别：</div>
				<div class="valueDiv">
					<input type="text" id="sex_detail" readonly="readonly"/>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">出生年月：</div>
				<div class="valueDiv">
					<input type="text" id="birthday_detail" readonly="readonly"/>
				</div>
			</div>
			<div class="field">
				<div class="textDiv">兴趣爱好：</div>
				<div class="valueDiv">
					<input type="text" id="hoby_detail" readonly="readonly"/>
				</div>
			</div>

	</div>

</body>
</html>