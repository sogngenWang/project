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
		// 拦截a标签超链接的跳转 
		$("#activeCompany").mousedown(function(e){
			return false;
		});
		$("#logOffCompany").mousedown(function(e){
			return false;
		});
	 
	});
	
	function activeCompanyAjax(uid){
		$.ajax({  
          	type: "post",//使用post方法访问后台  
            dataType: "json",//返回json格式的数据  
            url: "${pageContext.request.contextPath}/activeCompany.action?uid="+uid,//要访问的后台地址  
            contentType: "application/json;charset=utf-8",  
            data: {"uid":uid}, //要发送的数据  
            success: function(json){//data为返回的数据，在这里做数据绑定  
            	if(json.isSuccess)
           		{
            		alert("Active company success");
           		}else
       			{
       				alert("Active company error!");
       			}
            	
            },
            error: function(){
            	alert("ajax error....");
            }
			
	     });
	}	
	
	function logOffCompanyAjax(uid){
		$.ajax({  
          	type: "post",//使用post方法访问后台  
            dataType: "json",//返回json格式的数据  
            url: "${pageContext.request.contextPath}/logOffCompany.action?uid="+uid,//要访问的后台地址  
            contentType: "application/json;charset=utf-8",  
            data: {"uid":uid}, //要发送的数据  
            success: function(json){//data为返回的数据，在这里做数据绑定  
            	if(json.isSuccess){
            		alert("Log off company success");
            	}
            	else{
       				alert("Log off company error!");
            	}
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
	<c:forEach items="${companyInfo.companyInfoList}" var="companyInfoList">
			
			<div class="companyUserInfo_detail" id="companyUserInfo_detail_${companyInfoList.uid}" >
				<div>
				uid : ${companyInfoList.uid}
				<br/>
				公司id : ${companyInfoList.companyId}
				<br/>
				公司名称 : ${companyInfoList.companyName}
				<br/>
				最大用户数量 : ${companyInfoList.maxUsers}
				<br/>
				公司地址 : ${companyInfoList.companyAddress}
				<br/>
				公司联系方式 : ${companyInfoList.companyContact}
				<br/>
				公司描述 : ${companyInfoList.companyDescribe}
				</div>
				<br/>
				<a id="activeUser" href="#" onclick="activeCompanyAjax('${companyInfoList.uid}')">激活</a>
				&nbsp;&nbsp;&nbsp;
				<a id="logOffUser" href="#" onclick="logOffCompanyAjax('${companyInfoList.uid}')">注销</a>
			</div>

		<br/>
	</c:forEach>
</body>
</html>