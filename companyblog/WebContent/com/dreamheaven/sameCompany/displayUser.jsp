<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>main page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#activeUser").mousedown(function(e){
			return false;
		});
		$("#logOffUser").mousedown(function(e){
			return false;
		});
		//$("#deleteUser").mousedown(function(e){
		//	return false;
		//});
	
	});
	
	function activeUserAjax(uid){
		$.ajax({  
          	type: "post",//使用post方法访问后台  
            dataType: "json",//返回json格式的数据  
            url: "${pageContext.request.contextPath}/activeUser.action?uid="+uid,//要访问的后台地址  
            contentType: "application/json;charset=utf-8",  
            data: {"uid":uid}, //要发送的数据  
            success: function(json){//data为返回的数据，在这里做数据绑定  
            	if(json.isSuccess)
           		{
            		alert("Active user success");
           		}else
       			{
       				alert("Company employees have reached maximum");
       			}
            },
            error: function(){
            	alert("ajax error....");
            }
	     });
	}	
	
	function logOffUserAjax(uid){
		$.ajax({  
          	type: "post",//使用post方法访问后台  
            dataType: "json",//返回json格式的数据  
            url: "${pageContext.request.contextPath}/logOffUser.action?uid="+uid,//要访问的后台地址  
            contentType: "application/json;charset=utf-8",  
            data: {"uid":uid}, //要发送的数据  
            success: function(json){//data为返回的数据，在这里做数据绑定  
            	alert("Log off user success");
            },
            error: function(){
            	alert("ajax error....");
            }
			
	     });
	}	
 
	function deleteUserAjax(uid){
		$.ajax({  
          	type: "post",//使用post方法访问后台  
            dataType: "json",//返回json格式的数据  
            url: "${pageContext.request.contextPath}/deleteUser.action?uid="+uid,//要访问的后台地址  
            contentType: "application/json;charset=utf-8",  
            data: {"uid":uid}, //要发送的数据  
            success: function(json){//data为返回的数据，在这里做数据绑定  
            	alert("Delete user success");
            },
            error: function(){
            	alert("ajax error....");
            }
			
	     });
	}	

	function moreBig(id) {
		
		$("#headImg_"+id).animate({
			height : '100px',
			width : '100px'
		});
		
	}
	function recover(id) {


		$("#headImg_"+id).animate({
			height : '60px',
			width : '60px'
		});
		
	}
</script>
<style>
.userImg{
	width: 60px; 
	height: 60px;
	display: inline;
}
.companyUserInfoClass{
	height: 80px;
}
.companyUserInfo_detail{
	display:block;
}
.companyUserInfoClass{
	display: block;
}

</style>
</head>
<body>
	<c:forEach items="${userInfo.userInfoList}" var="userInfoList">
		<div class="companyUserInfoClass" id="companyUserInfo_${userInfoList.uid}">
			<img class="userImg" id="headImg_${userInfoList.uid}"
				align="left"
				src="${pageContext.request.contextPath}/userheadimg/${userInfoList.headImgPath}"
				onclick="moreBig('${userInfoList.uid}')"
				onmouseout="recover('${userInfoList.uid}')" />
			<div class="companyUserInfo_detail" id="companyUserInfo_detail_${userInfoList.uid}" >
				<div>
				性别:
					<c:if test="${userInfoList.sex eq 1}">
					男
					</c:if>
					<c:if test="${userInfoList.sex eq 2}">
					女
					</c:if>
				</div>
				年龄:${userInfoList.age}
				<fmt:parseDate value="${userInfoList.birthday}" type="date" var="birthday" pattern="yyyyMMdd" />
				<br/>
				出生年月:<fmt:formatDate value="${birthday}" pattern="yyyy年MM月dd日"/>
				<br/>
				兴趣爱好:${userInfoList.hoby}
				<br/>
			</div>
		</div>
		<div class="companyUserInfoNickName">${userInfoList.nickName}</div>
		<div class="userManager">
		<a id="activeUser" href="#" onclick="activeUserAjax('${userInfoList.uid}')">激活</a>

		<a id="logOffUser" href="#" onclick="logOffUserAjax('${userInfoList.uid}')">注销</a>
		
		<!-- <a id="deleteUser" href="#" onclick="deleteUserAjax('${userInfoList.uid}')">删除</a> -->
		</div>
		<br/>
	</c:forEach>
</body>
</html>