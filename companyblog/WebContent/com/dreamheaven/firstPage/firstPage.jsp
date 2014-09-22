<?xml version="1.0" encoding="UTF-8" ?> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>main page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/firstPage.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/firstPage.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		//跳转页面之前先ajax刷新主页面的微博数
		renderParent();
		
		$("#myWeiboContent a").mousedown(function(e){
			var ahref = $(this).attr("href");
			window.location.href="${pageContext.request.contextPath}/detailUserInfoByAHref.action?uid="+ahref;
			return false;
		});
		
	});
	
	function ajaxGetRelyMessage(messageId)
	{
		//隐藏所有的回复内容
		$(".toggleRelyMessageContent").css("display","none");
		//通过ajax从后台查询当前messageId的 多有回复信息
		$.ajax({  
          	type: "post",//使用post方法访问后台  
            dataType: "json",//返回json格式的数据  
            url: "${pageContext.request.contextPath}/queryRelyMessage.action?messageId="+messageId,//要访问的后台地址  
            contentType: "application/json;charset=utf-8",  
            data: {"messageId":messageId}, //要发送的数据  
            success: function(json){//data为返回的数据，在这里做数据绑定  
            	//alert("ajax success....");
            	//刷新之前先清楚所有的子标签 
            	$(".relyContentDiv").remove();
            	$(".relyTimeDiv").remove();
				//返回的json是一个list，需要遍历取值，然后调用javascript方法innerHtml  
				for(var number in json)
				{
					for(var name in json[number]) {
						//取到每一个对象，对象按顺序插入到响应的div中 
    					//alert( "name:" + name + " value:" + json[number][name] );
						if(name == "relyContent")
						{
							var relyContent = json[number][name];
						}
						if(name == "relyTime")
						{
							var relyTime = "<div class='relyTimeDiv'>"+ json[number][name] +"</div> ";
						}
						if(name == "relyUserNickName")
						{
							var relyUserNickName = json[number][name];
						}
						if(name == "relyUserPath")
						{
							var relyUserPath = json[number][name];
						}
						//每次取完最后一个值之后说明当前对象结束，然后统一加载  
						if(name == "uid")
						{
							var uid = json[number][name];

							var relyContentDiv = "<div class='relyContentDiv'>" + 
												"<img class='userImg' id='headImg_"+uid+"' src='${pageContext.request.contextPath}/userheadimg/"+relyUserPath +"' />" +
												relyUserNickName + ":" + 
												relyContent + 
												"</div>";
							
							$("#toggleRelyMessageContent_"+messageId).append(relyContentDiv);

							$("#toggleRelyMessageContent_"+messageId).append(relyTime);
							
							
						}
						
					}

				}
				$("#toggleRelyMessageContent_"+messageId).slideToggle(500);

				//jquery对头像增加脚本
				$(".userImg").click(function(){
					var imgid = $(this).attr("id");
					window.location.href="${pageContext.request.contextPath}/detailUserInfoByImgId.action?uid="+imgid;
				});
				$(".relyContentDiv a").mousedown(function(e){
					//e.which  1 = 鼠标左键 left; 2 = 鼠标中键; 3 = 鼠标右键
					var ahref = $(this).attr("href");
					window.location.href="${pageContext.request.contextPath}/detailUserInfoByAHref.action?uid="+ahref;
					return false; //阻止链接跳转
				});
				
            },
            error: function(){
            	alert("ajax error....");
            }
		
         });
		
	}
	function deleteMessage(messageId){
		$.ajax({  
          	type: "post",//使用post方法访问后台  
            dataType: "json",//返回json格式的数据  
            url: "${pageContext.request.contextPath}/deleteMessage.action?messageId="+messageId,//要访问的后台地址  
            contentType: "application/json;charset=utf-8",  
            data: {"messageId":messageId}, //要发送的数据  
            success: function(json){//data为返回的数据，在这里做数据绑定 
            	$("#message_"+messageId).hide();
            	alert("Delete success.");
            },
            error: function(){
            	alert("ajax error....");
            }
		
         });
	}
</script>
<style>
.deleteMessageLink {
	display: inline;
	margin-left: 500px;
	margin-right: 20px;
}
</style>
</head>
<body>
	<div id="annWeibo">
		<form id="announceMsg" action="createMessage.action" method="post">
			<div id="announceMsgAreaTitle">有什么新鲜事想告诉大家？</div>
			<div id="announceMsgAreaDiv">
				<textarea id="announceMsgTextArea" rows="5" cols="76" name="messageText"
					onclick="clearText();" onblur="restoreText()">请输入你想要发布的微博</textarea>
			</div>
			<div id="submitAnn">
				<input type="submit" value="发布" />
				<div class="divNbspRight" />
			</div>
		</form>
	</div>
	<br/><br/>
	<div id="myWeiboContent">
		<c:forEach items="${user.messageList}" var="message" varStatus="vs">
			<div id="message_${message.mid}">
			<div class="message">
				<div class="myMessage">${message.mcontent}</div>
				<div class="createTime">${message.createTime}</div>
				<br/>
				<c:if test="${message.relyFlag == '1'}">
					<div class="toggleRelyMessage" id="toggleRelyMessage_${message.mid}" onclick="displayRelyMessage(${message.mid})">display</div>
					<div class="toggleRelyMessageContent" id="toggleRelyMessageContent_${message.mid}" >
					</div>
					<br/>
				</c:if>
			</div>
			<div class="relyMessageAction">
				<div class="deleteMessageLink" onclick="deleteMessage('${message.mid}')">delete&nbsp;</div> 
				
				<div class="relyMessageLink" onclick="displayRelyMessageInput(${message.mid});">rely</div>
				<div class="relyMessageInput" id="relyMessageInput_${message.mid}">
					<form id="relyMsg" action="createRelyMessage.action?messageId=${message.mid}" method="post">
						<textarea id="relyMsgTextArea" rows="3" cols="76" name="relyMessage.relyContent"></textarea>
						<div class="relyMessageSubmit">
						<input type="submit" value="回复" />
						</div>
					</form>
				</div>
			</div>
			<br/>
			</div>
		</c:forEach>
	</div>
</body>
</html>