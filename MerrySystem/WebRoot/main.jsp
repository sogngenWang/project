<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>merry</title>

<script type="text/javascript">
	$(document).ready(function() {
		//初始化的时候    通过ajax 查询后台，获取活动图片以及相关的URL 然后设置dispalyPicture的src属性以及a属性
		//定时器，3s时间改变图片内容
		timerPic();
			
		$("#firstPageButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickFirstPageDiv");
			listNewsOnFirstPage();
		});
		$("#newsButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickNewsDiv");
			listNews();
		});
		$("#exhibitButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickExhibitDiv");
		});
		$("#associationDynaButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickAssociationDynaDiv");
		});
		$("#announceFileButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickAnnounceFileDiv");
			dispalyFileList();
		});
		$("#trainButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickTrainDiv");
		});
		$("#aboutAssociationButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickAboutAssociationDiv");
			displayAboutAssociation();
		});
		$("#partnersButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickPartnersDiv");
		});
		$("#servePlatformButton").click(function() {
			$(".nav li").attr("class", "");
			$(this).parent().attr("class","active");
			displayExcept("clickServePlatformDiv");
		});

		//标题栏 按钮单击事件
		$("#firstPageButton").click();
		//首页关于协会按钮等同主题栏关于协会的按钮
		$("#aboutExpo").click(function(){
			$("#aboutAssociationButton").click();
		});
	});
	
	
	/**
	function reflushIframe(action){
		$("#centerFrame").attr("src",action);		
		var framheight = document.getElementById("centerFrame").contentWindow.document.body.scrollWidth;
		$("#centerFrame").css("height",framheight);
	}
	
	*/
	//隐藏除了 div id 为"divid" 之外的div ，同时显示该div
	function displayExcept(divid){
		$(".clickDiv[id='" + divid + "']").show();			
		$(".clickDiv[id!='" + divid + "']").hide();
	}
	
	/**
		ajax 查询表获取	主要新闻图片以及URL
	*/
	function listNewsOnFirstPage(){
		request = "";
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "text",//返回json格式的数据  
			// url : "../testController?request="+request,//要访问的后台地址  
			url : "listMessageAction.action",
			contentType : "application/text;charset=utf-8",
			data : {request:request}, //要发送的数据 
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				json = eval('(' + json + ')');   
			//	alert("||||"+json.messageList.size);
				//alert(json.messageList[0].messageId);
				//alert(json.messageList[0].messageTitle);
				//alert(json.messageList[0].createTime);
				//if(json.state == "SUCCESS"){
						var Objs = json.messageList;
						var string = "";
						$("#news").html("");
						for (var i = 0; i < Objs.length; i++) {
							var array_element = Objs[i];
							if(null != array_element){
								// 加入到页面的标签元素中 
								string+="<tr attr=\""+ array_element.messageId+"\" class=\"messageId\" >";
								string+="<td colspan=\"6\"><a href=\"javascript:void(0);\" class=\"detailMessageFirst\">"+ array_element.messageTitle+"</a></td>";
								string+="<td colspan=\"4\">"+ array_element.createTime +"</td>";
								string+="</tr>";
							}
						}
						$("#news table tbody").append(string);
						$(".detailMessageFirst").click(function(){
							detailMessage($(this).parent().parent().attr("attr"));
							displayExcept("clickNewsDetailDiv");
						});
				//}
			},
			error : function() {
				alert("ajax error....");
			}
		});
		
	}
	
	/**
		ajax 获取新闻列表
	*/
	function listNews(){
		request = "";
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "text",//返回json格式的数据  
			// url : "../testController?request="+request,//要访问的后台地址  
			url : "listMessageAction.action",
			contentType : "application/text;charset=utf-8",
			data : {request:request}, //要发送的数据 
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				json = eval('(' + json + ')');   
				var Objs = json.messageList;
				var string = "";
				$("#clickNewsDiv #left").html("");
				for (var i = 0; i < Objs.length; i++) {
					var array_element = Objs[i];
					if(null != array_element){
						// 加入到页面的标签元素中 
						string+="<div><a href=\"javascript:void(0);\" class=\"detailMessage\" attr=\""+ array_element.messageId+"\">"+ array_element.messageTitle+"</a></div>";
						string+="<div style=\"display:inline;\">"+ array_element.createTime +"</div>";
						string+="</tr>";
					}
				}
				$("#clickNewsDiv #left").append(string);
				$(".detailMessage").click(function(){
					detailMessage($(this).parent().parent().attr("attr"));
					displayExcept("clickNewsDetailDiv");
				});
			},
			error : function() {
				alert("ajax error....");
			}
		});
		
	}
	/**
	 显示关于协会页面
	*/
	function displayAboutAssociation(){
		request = "";
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "text",//返回json格式的数据  
			// url : "../testController?request="+request,//要访问的后台地址  
			url : "aboutAssociationAction.action",
			contentType : "application/text;charset=utf-8",
			data : {request:request}, //要发送的数据 
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				json = eval('(' + json + ')');   
				$("#clickAboutAssociationDiv").html("");
				$("#clickAboutAssociationDiv").append(json.aboutAssociation);
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
	
	/**
		显示提供下载的文件，同时生成超链接
	*/
	function dispalyFileList(){
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "text",//返回json格式的数据  
			// url : "../testController?request="+request,//要访问的后台地址  
			url : "listFileNameAction.action",
			contentType : "application/text;charset=utf-8",
			data : {}, //要发送的数据 
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				json = eval('(' + json + ')');   
				$("#clickAnnounceFileDiv").html("");
				var Objs = json.fileList;
				var string = "";
				for (var i = 0; i < Objs.length; i++) {
					var array_element = Objs[i];
					// 加入到页面的标签元素中 
					string+="<div>下载文件:<a href='javascript:void(0); ' onclick=\"javascript:window.location='downloadAction.action?fileName=" + array_element + "';\" >"+array_element+"</a></div>";
				}
				$("#clickAnnounceFileDiv").append(string);
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
	
	/**
		定时器，不断改变图片 3s一次
	*/
	function timerPic(){
		window.setInterval("changePic()",3000);
	}
	
	var num = 0;
	function changePic(){
		num ++;
		$("#dispalyPicture").attr("src","./img/activePic/"+ num % 3 + ".jpg");
	}
	
	/**
		显示新闻详细信息
	*/
		    
	function detailMessage(messageId){
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "text",//返回json格式的数据  
			// url : "../testController?request="+request,//要访问的后台地址  
			url : "detailMessageAction.action?message.messageId="+messageId,
			contentType : "application/text;charset=utf-8",
			data :"", //要发送的数据 
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				json = eval('(' + json + ')'); 
				//新闻标题
				$("#messageContentDetail").html(json.messageContent);
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}

	/**

	*/
</script>

<!-- 800px高*1600px宽 -->
<style>
body {
	background-color:#eee;
	margin: 0 auto;
	width: 980px;
	height: 800px;
}

#left {
	float: left;
	display: block;
	width: 66%;
	height: 100%;
}

#right {
	float: left;
	width: 34%;
	height: 100%;
}

#picDisplay {
	margin: auto;
	width: 100%;
	height: 35%;
}

#dispalyPicture {
	margin: auto;
	width: 100%;
	height: 280px;
}

#ad_1 {
	margin-top: 1%;
	width: 100%;
	height: 64px;
}

#ad_2 {
	margin: 4% auto;
	width: 100%;
	height: 160px;
}

#ad_3 {
	margin: 4% auto;
	width: 100%;
	height: 160px;
}

#kinds {
	width: 100%;
	height: 160px;
}


#dynamic {
	width: 100%;
	height: 34%%;
}

/* 设置图片的透明度  */
a img {
	width: 100%;
	height: 100%;
	opacity: 0.1;
}


.messageTitleDiv {
	
}

#aboutExpo {
	margin: 10px;
	display: inline;
}

#visitExpo {
	margin: 10px;
	display: inline;
}



#manu ul{
	background-color: white;
}
#manu li{
	margin-right: 30px;
	display: inline;
}
#manu li a {
	color:black;
	text-decoration:none;
}

#manu li a:hover{
	color:blue;
}

#kinds{
	/* border: 1px solid #777; */
}

#kinds a { 
	color:black;
	text-decoration:none;
} 

#kinds a:hover{
	color:red;
}



</style>
</head>
<body>
<!-- *********************************************** -->

<!-- header 区域 -->
<div>
	<div>
		<!-- 公司的一些宣传等等重要信息，新闻等等，应该为一个单独的页面，后期需要抽离出来 -->
		<div id="head">
			<div style="color: balck;font-size:xx-large;font-family:'隶书';">摄彩中国</div>
			<div style="color: balck;font-size: x-large;font-family:'隶书';">福建省摄影行业协会网</div>
		</div>

		<div>
			<ul class="nav navbar-nav" id="manu">
				<li class="active"><a href="javascript:void(0);" id="firstPageButton">首页</a></li>
				<li><a href="javascript:void(0);" id="newsButton">新闻活动</a></li>
				<li><a href="javascript:void(0);" id="exhibitButton">作品</a></li>
				<li><a href="javascript:void(0);" id="associationDynaButton">协会动态</a>
				<li><a href="javascript:void(0);" id="announceFileButton">通知文件</a>
				<li><a href="javascript:void(0);" id="trainButton">培训</a>
				<li><a href="javascript:void(0);" id="aboutAssociationButton">关于协会</a>
				<li><a href="javascript:void(0);" id="partnersButton">合作伙伴</a>
				<li><a href="javascript:void(0);" id="servePlatformButton">服务平台</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- header 区域  END-->

<!-- *********************************************** -->

<!-- 点击首页的时候显示 -->
<div id="clickFirstPageDiv" class="clickDiv" >
	<div id="left">
		<!-- 主要活动新闻图片区域  -->
		<div id="picDisplay">
			<img id="dispalyPicture" alt="展示图片" src="./img/dispalyPicture.png" />
		</div>
		<!-- 广告栏1 -->
		<div id="ad_1">
			<a href="javascript:void(0);"> <img src="./img/ad/ad_1.jpg" /></a>
		</div>
		<!-- 新闻栏 -->

		<div id="news" class="row">
			<table id="rounded-corner">
				<tr>
				</tr>
			</table>
			</div>
		</div>
	<div id="right">
		<div id="kinds">
				<div style="border-bottom:1px dashed #cccccc; line-height:30px;padding-left:60px;">
					<a href="javascript:void(0)" id="aboutExpo">关于协会</a>
				</div>
				<div style="border-bottom:1px dashed #cccccc; line-height:30px;padding-left:60px;	">
					<a href="javascript:void(0)" id="visitExpo">加入协会</a>
				</div>
		</div>
		
		<div id="ad_2">
			<a href="javascript:void(0);" onclick="window.location.href='http://www.baidu.com'"> <img alt="广告图片" src="./img/ad/ad_2.jpg" />
			</a>
		</div>
		<div id="ad_3">
			<a href="javascript:void(0);"> <img src="./img/ad/ad_3.jpg" />
			</a>		
		</div>
		<div id="dynamic"></div>
	</div>
</div>
<!-- 点击首页的时候显示  END-->

<!-- *********************************************** -->
<!-- 点击新闻活动的时候显示 -->
<div id="clickNewsDiv" class="clickDiv">
	<div id="left">
	</div>
	<div id="right">
	</div>
</div>
<!-- 点击新闻活动的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击作品的时候显示 -->
<div id="clickExhibitDiv" class="clickDiv">
	<div id="left">
	</div>
	<div id="right">
	</div>
</div>
<!-- 点击作品的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击协会动态的时候显示 -->
<div id="clickAssociationDynaDiv" class="clickDiv">
	<div id="left">
	</div>
	<div id="right">
	</div>
</div>
<!-- 点击协会动态的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击通知文件的时候显示 -->
<div id="clickAnnounceFileDiv" class="clickDiv">
	<div id="left">
		<a href="javascript:void(0);" onclick="javascript:window.location='downloadAction.action?fileName=about';" >点我下载</a>
	</div>
	<div id="right">
	</div>
</div>
<!-- 点击通知文件的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击培训的时候显示 -->
<div id="clickTrainDiv" class="clickDiv">
	<div id="left">
	</div>
	<div id="right">
	</div>
</div>
<!-- 点击培训的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击关于协会的时候显示 -->
<div id="clickAboutAssociationDiv" class="clickDiv">
	<div id="left">
	</div>
	<div id="right">
	</div>
</div>
<!-- 点击关于协会的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击合作伙伴的时候显示 -->
<div id="clickPartnersDiv" class="clickDiv">
	<div id="left">
	</div>
	<div id="right">
	</div>
</div>
<!-- 点击合作伙伴的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击服务平台的时候显示 -->
<div id="clickServePlatformDiv" class="clickDiv">
	<div id="left">
	</div>
	<div id="right">
	</div>
</div>
<!-- 点击服务平台的时候显示 END -->

<!-- *********************************************** -->


<!-- 点击新闻详情的时候显示 -->
<div id="clickNewsDetailDiv" class="clickDiv">
	<div id="messageContentDetail"></div>
</div>
<!-- 点击新闻详情的时候显示 END -->


<!-- bottom 区域 -->
<div style="text-align: center;float: clear;">
<span style="font-size: 40px;font-family: '隶书';">福建省摄影行业协会网</span>
<br />
<span style="font-size: 20px;font-family: '隶书';margin-top: 5px;">版权所有：福建省摄影行业协会    网站运营：福州中天创信网络技术有限公司</span>
<br />
<span style="font-size: 20px;font-family: '隶书';margin-top: 5px;">Copyright 2008-2014 shecaichina.cn. All Rights Reserved</span>
<br />
<span style="font-size: 20px;font-family: '隶书';margin-top: 5px;">闽ICP备14016797号</span>
<br />
</div>
<!-- bottom 区域 END -->
</body>
</html>
