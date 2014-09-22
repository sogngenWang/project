<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
	
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script> 
<script>

$(document).ready(function(){
	//设置body背景图片的宽度
	setBackGroundImg();
	
	$("#attentionLink").click(function(){
		
		 $("#centerFrame").attr("src","${pageContext.request.contextPath}/queryAttention.action");
	});
	
	$("#fansLink").click(function(){
		
		 $("#centerFrame").attr("src","${pageContext.request.contextPath}/queryFans.action");
	});
	
	$("#weiboLink").click(function(){
		
		 $("#centerFrame").attr("src","${pageContext.request.contextPath}/com/dreamheaven/firstPage/firstPage.jsp");
	});
	
	$("#headPage").click(function(){
		$("#headPage").css("display","hide");
	});
	 $("#mentionOfMe").click(function(){
		 commentFlag = false;
		 $("#commentArrow").attr("src","${pageContext.request.contextPath}/img/arrow_right.gif");
		 if(mentionOfMeFlag){
			 mentionOfMeFlag = false;
			 $("#mentionOfMeArrow").attr("src","${pageContext.request.contextPath}/img/arrow_right.gif");
		 }
		 else{
			 mentionOfMeFlag = true;
			 $("#mentionOfMeArrow").attr("src","${pageContext.request.contextPath}/img/arrow_down.gif");
			 
		 }
		 $("#commentToggle").hide();
		 $("#mentionOfMeToggle").slideToggle(1200);
	 });
	 
	 $("#comment").click(function(){
		 mentionOfMeFlag = false;
		 $("#mentionOfMeArrow").attr("src","${pageContext.request.contextPath}/img/arrow_right.gif");
		 if(commentFlag){
			 commentFlag = false;
			 $("#commentArrow").attr("src","${pageContext.request.contextPath}/img/arrow_right.gif");
		 }
		 else{
			 commentFlag = true;
			 $("#commentArrow").attr("src","${pageContext.request.contextPath}/img/arrow_down.gif");
		 }
		 $("#mentionOfMeToggle").hide();
		 $("#commentToggle").slideToggle(1200);
	 });
	 
	 changeDivColor("firstPage");
	 changeDivColor("mentionOfMe");
	 changeDivColor("comment");
	 changeDivColor("mentionOfMeWeibo");
	 changeDivColor("mentionOfMeComment");
	 changeDivColor("recieveComment");
	 changeDivColor("sentComment");
	 
	
	 $("#mentionOfMeWeibo").click(function(){
		 $("#centerFrame").attr("src","${pageContext.request.contextPath}/queryAtMeMessage.action");
	 });
	 
	 $("#mentionOfMeComment").click(function(){

		 $("#centerFrame").attr("src","${pageContext.request.contextPath}/queryAtMeRelyMessage.action");
	 });
	 
	 $("#recieveComment").click(function(){

		 $("#centerFrame").attr("src","${pageContext.request.contextPath}/recieveComment.action");
	 });
	 
	 $("#sentComment").click(function(){

		 $("#centerFrame").attr("src","${pageContext.request.contextPath}/sentComment.action");
	 });
	 
	 $("#firstPage").click(function(){
		 $("#centerFrame").attr("src","${pageContext.request.contextPath}/queryMessageAndRely.action");
		// window.frames["centerFrame"].firstPageReady();
	 });
	 
	$("#searchUser").mousedown(function(e){
		$("#centerFrame").attr("src","${pageContext.request.contextPath}/toSearchUser.action"); 
		return false;
	});
	
	$("#personalInfo").mousedown(function(e){
		$("#centerFrame").attr("src","${pageContext.request.contextPath}/detailMyInfo.action"); 
		return false;
	});
	 
	 getTime();
	 
});

function ajaxRenderWeiboCount()
{
	//刷新当前页面上的weiboCount
	$.ajax({  
      	type: "post",//使用post方法访问后台  
        dataType: "json",//返回json格式的数据  
        url: "${pageContext.request.contextPath}/countMessage.action",//要访问的后台地址  
        contentType: "application/json;charset=utf-8",  
        data: "", //要发送的数据  
        success: function(json){//data为返回的数据，在这里做数据绑定  
        	//var jsonData = eval("(" + json + ")");
        	if(json.isSuccess)
       		{
       			var weiboCount = json.weiboCount;
       			$("#weiboLink").html(weiboCount);
       		}
        },
        error: function(){
        	alert("ajax error....");
        }
	
     });    
}

function ajaxRenderFansCount()
{
	//刷新当前页面上的fansCount
	$.ajax({  
      	type: "post",//使用post方法访问后台  
        dataType: "json",//返回json格式的数据  
        url: "${pageContext.request.contextPath}/countFans.action",//要访问的后台地址  
        contentType: "application/json;charset=utf-8",  
        data: "", //要发送的数据  
        success: function(json){//data为返回的数据，在这里做数据绑定  
        	if(json.isSuccess)
       		{
       			var fansCount = json.fansCount;
       			$("#fansLink").html(fansCount);
       		}
        },
        error: function(){
        	alert("ajax error....");
        }
	
     });   
}

function ajaxRenderAttentionCount()
{
	//刷新当前页面上的attentionCount
	$.ajax({  
      	type: "post",//使用post方法访问后台  
        dataType: "json",//返回json格式的数据  
        url: "${pageContext.request.contextPath}/countAttention.action",//要访问的后台地址  
        contentType: "application/json;charset=utf-8",  
        data: "", //要发送的数据  
        success: function(json){//data为返回的数据，在这里做数据绑定  
        	//var jsonData = eval("(" + json + ")");
        	if(json.isSuccess)
       		{
       			var attentionCount = json.attentionCount;
       			$("#attentionLink").html(attentionCount);
       		}
        },
        error: function(){
        	alert("ajax error....");
        }
	
     });   
}

</script>
<style>
*{
	color:black;
	
}


</style>

</head>
<body>
	<img id="imgDiv" alt="" src="${pageContext.request.contextPath}/img/mainBackGround.gif" />
		
	<div id="contain">
		<!--头部-->
		<div id="headPage">
			<!--索引链接,横幅图片以及日期显示-->
			<div id="banner">
				<ul id="indexUl">
					<li><div id="bannerLeft"></div></li>
				<!-- <li><a id="personalInfo" href="#">个人信息</a></li> -->
					<li><div id="bannerLeft"></div></li>
					<li><a id="searchUser" href="#">搜索用户</a></li>
				</ul>
				<div id="welcome">欢迎回来 用户${user.userInfo.nickName}</div>
					
				<a href="${pageContext.request.contextPath}/logout.action">退出登录</a>
				<!-- 显示当前日期 -->
				<div id="bannerDate"></div>
			</div>
		</div>
		<!--虚线-->
		<div id="dottedLine"></div>
		<!--页面内容 -->
		<div id="bodyPage">
			<!--侧边栏，用于显示主要操作-->

			<div id="leftSideBar">
				<div class="divBlock" id="firstPage">首页</div>

				<br />

				<div class="divBlock" id="mentionOfMe">
					<img id="mentionOfMeArrow"
						src="${pageContext.request.contextPath}/img/arrow_right.gif" />@提到我的
				</div>
				<div id="mentionOfMeToggle">
					<div id="mentionOfMeWeibo" class="divBlock">@提到我的微博</div>
					<br />
					<div id="mentionOfMeComment" class="divBlock">@提到我的评论</div>
				</div>

				<br />
				<div class="divBlock" id="comment">
					<img id="commentArrow"
						src="${pageContext.request.contextPath}/img/arrow_right.gif" />评论
				</div>
				<div id="commentToggle">
					<div id="recieveComment" class="divBlock">收到的评论</div>
					<br />
					<div id="sentComment" class="divBlock">发出的评论</div>
				</div>


			<br />
				<!-- 推荐同公司好友 -->
				<div id="othersInCompany">
					看看公司其他人：
					<div id="othersInfo">
						<c:forEach items="${user.userInfoList}" var="othersUserInfo" varStatus="vs">
							<div class="othersCompany">
								<img class="userImg" id="headImg_${othersUserInfo.uid}" src="${pageContext.request.contextPath}/userheadimg/${othersUserInfo.headImgPath}" 
										onclick="moreBig('headImg_${othersUserInfo.uid}')" onmouseout="recover('headImg_${othersUserInfo.uid}')"/>
							</div>
							<div class="othersNickName">${othersUserInfo.nickName}</div>
							<a class="listen" href="${pageContext.request.contextPath}/addListenUser.action?listenedId=${othersUserInfo.uid}">收听</a>
							
							<!-- 每个人都可以收听 -->
							<br/><br/>
						</c:forEach>
					</div>
				</div>

			</div>
			<!--内容显示-->
			<div id="bodyContent">
				<iframe id="centerFrame" name="centerFrame" frameborder="0"
					allowtransparency="true" src="${pageContext.request.contextPath}/queryAnnouncement.action"> </iframe>
			</div>
			<!-- 右侧栏，显示用户数据，分别显示用户名，用户头像，关注人数，粉丝数以及发布的微博数-->
			<div id="rightSideBar">
				<div id="userHeadImg">
					<img class="userImg" id="headImg_${user.userInfo.uid}" src="${pageContext.request.contextPath}/userheadimg/${user.userInfo.headImgPath}" 
										onclick="moreBig('headImg_${user.userInfo.uid}')" onmouseout="recover('headImg_${user.userInfo.uid}')"/>

				</div>
				<div id="userNickName">
					<a href="#">${user.userInfo.nickName}</a>
				</div>
				<br />
				<div id="attentionCount">收听：<u id="attentionLink">${user.attentionCount}</u></div>
				<div id="fansCount">粉丝：<u id="fansLink" >${user.fansCount}</u></div>
				<div id="weiblogCount">微博：<u id="weiboLink" >${user.messageCount}</u></div>
			</div>
		</div>
		<!--虚线-->
		<div id="dottedLine"></div>
		<!--页脚-->
		<div id="foot"></div>
	</div>
</body>
</html>
