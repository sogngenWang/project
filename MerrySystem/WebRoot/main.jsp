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


<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Bootstrap theme -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.2.0/dist/css/bootstrap-theme.min.css"
	rel="stylesheet">

<script
	src="${pageContext.request.contextPath}/bootstrap-3.2.0/docs/assets/js/ie-emulation-modes-warning.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="${pageContext.request.contextPath}/bootstrap-3.2.0/docs/assets/js/ie10-viewport-bug-workaround.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		    <![endif]-->
		    

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
						$("#news table tbody").html("");
						for (var i = 0; i < Objs.length; i++) {
							var array_element = Objs[i];
							if(null != array_element){
								// 加入到页面的标签元素中 
								string+="<tr attr=\""+ array_element.messageId+"\" class=\"messageId\" >";
								string+="<td colspan=\"4\">"+ i + "</td>";
								string+="<td colspan=\"6\"><a href=\"javascript:void(0);\" class=\"detailMessageFirst\">"+ array_element.messageTitle+"</a></td>";
								string+="<td colspan=\"4\">"+ array_element.createTime +"</td>";
								if(null != array_element.isTop && array_element.isTop == 1){
									string+="<td colspan=\"4\">(置顶新闻)</td>";
								}else{
									string+="<td colspan=\"4\"></td>";
								}
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
				$("#clickNewsDiv div table tbody").html("");
				for (var i = 0; i < Objs.length; i++) {
					var array_element = Objs[i];
					if(null != array_element){
						// 加入到页面的标签元素中 
						string+="<tr attr=\""+ array_element.messageId+"\" class=\"messageId\" >";
						string+="<td colspan=\"3\">"+ i + "</td>";
						string+="<td colspan=\"4\"><a href=\"javascript:void(0);\" class=\"detailMessage\">"+ array_element.messageTitle+"</a></td>";
						string+="<td colspan=\"4\">"+ array_element.createTime +"</td>";
						if(null != array_element.isTop && array_element.isTop == 1){
							string+="<td colspan=\"4\">(置顶新闻)</td>";
						}else{
							string+="<td colspan=\"4\"></td>";
						}
						string+="</tr>";
					}
				}
				$("#clickNewsDiv div table tbody").append(string);
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
	height: 100%;
}

#ad_1 {
	margin: 1%;
	width: 30%;
	height: 8%;
}

#kinds {
	width: 100%;
	height: 20%;
}

#ad_2 {
	margin: 4% auto;
	width: 100%;
	height: 20%;
}

#ad_3 {
	margin: 4% auto;
	width: 100%;
	height: 20%;
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

#mainFrameNews {
	width: 100%;
	height: 100%;
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
</style>
</head>
<body>
<!-- *********************************************** -->

<!-- header 区域 -->
<div class="navbar navbar-default">
		<div class="container">
			<!-- 公司的一些宣传等等重要信息，新闻等等，应该为一个单独的页面，后期需要抽离出来 -->
			<div id="head">
				<div style="color: balck;font-size:xx-large;">摄彩中国</div>
				<div style="color: balck;font-size: x-large;font-style: oblique;">福建省摄影行业协会网</div>
			</div>

			<div class="container">
				<div class="navbar-header">
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
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
				<!--/.nav-collapse -->
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
			<a href="javascript:void(0);"> <img src="./img/AD.gif" />
			</a>
		</div>
		<!-- 新闻栏 -->

		<div id="news" class="row">
			<table id="rounded-corner">
				<thead>
					<tr>
						<th colspan="4">序号</th>
						<th colspan="6" style="text-align: center;">新闻标题</th>
						<th colspan="4">新闻发布时间</th>
						<th colspan="4">是否置顶新闻</th>
					</tr>
				</thead>
				<!-- 表格内容<tr><td></td><td></td></tr> -->
				<tbody></tbody>
			</table>
				<!-- 
			<div class="col-md-10">
				<table class="table">
					<thead>
						<tr>
							<th colspan="2">序号</th>
							<th colspan="8">新闻标题</th>
						</tr>
					</thead>
					<c:forEach items="${message.messageList}" var="messageInfo" varStatus="vs">
						<tbody>
							<td colspan="2">${vs.count}</td>
							<td colspan="8" style="background-color: yellow;">
								<div class="messageTitleDiv" id="${messageInfo.messageId}" action="${pageContext.request.contextPath}/detailMessageAction.action?message.messageId=${messageInfo.messageId}">
									<a href="javascript:void(0);">${messageInfo.messageTitle}</a>
								</div>
							</td>
						</tbody>
					</c:forEach>
				</table>
			</div>
			-->
			</div>

		</div>
	<div id="right">
		<div id="kinds">
			<button id="aboutExpo">关于协会</button>
			<button id="visitExpo">加入协会</button>
		</div>
		<!-- 
		<div id="ad_2">
			<a href="javascript:void(0);" onclick="window.location.href='http://www.baidu.com'"> <img alt="广告图片" src="./img/AD.gif" />
			</a>
		</div>
		<div id="ad_3">
			<a href="javascript:void(0);"> <img src="./img/AD.gif" />
			</a>		
		</div>
		<div id="dynamic"></div>
		 -->
	</div>
</div>
<!-- 点击首页的时候显示  END-->

<!-- *********************************************** -->
<!-- 点击新闻活动的时候显示 -->
<div id="clickNewsDiv" class="clickDiv">
	<div id="left">
		<table id="rounded-corner">
			<thead>
				<tr>
					<th colspan="3">序号</th>
					<th colspan="4" style="text-align: center;">新闻标题</th>
					<th colspan="4">新闻发布时间</th>
					<th colspan="4">是否置顶新闻</th>
				</tr>
			</thead>
			<!-- 表格内容<tr><td></td><td></td></tr> -->
			<tbody></tbody>
		</table>
	</div>
	<div id="right">
	</div>
		
</div>
<!-- 点击新闻活动的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击作品的时候显示 -->
<div id="clickExhibitDiv" class="clickDiv">

</div>
<!-- 点击作品的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击协会动态的时候显示 -->
<div id="clickAssociationDynaDiv" class="clickDiv">

</div>
<!-- 点击协会动态的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击通知文件的时候显示 -->
<div id="clickAnnounceFileDiv" class="clickDiv">
	<a href="javascript:void(0);" onclick="javascript:window.location='downloadAction.action?fileName=about';" >点我下载</a>

</div>
<!-- 点击通知文件的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击培训的时候显示 -->
<div id="clickTrainDiv" class="clickDiv">


</div>
<!-- 点击培训的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击关于协会的时候显示 -->
<div id="clickAboutAssociationDiv" class="clickDiv">


</div>
<!-- 点击关于协会的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击合作伙伴的时候显示 -->
<div id="clickPartnersDiv" class="clickDiv">


</div>
<!-- 点击合作伙伴的时候显示 END -->

<!-- *********************************************** -->

<!-- 点击服务平台的时候显示 -->
<div id="clickServePlatformDiv" class="clickDiv">


</div>
<!-- 点击服务平台的时候显示 END -->

<!-- *********************************************** -->


<!-- 点击新闻详情的时候显示 -->
<div id="clickNewsDetailDiv" class="clickDiv">
	<div id="messageContentDetail"></div>
</div>
<!-- 点击新闻详情的时候显示 END -->


<!-- bottom 区域 -->
<div class="navbar" style="z-index: -1" >
	<div class="navbar-default">
		<div class="container">

			<table style="display: inline; margin: 10px;">
				<tr>
					<td>&nbsp;</td>
					<td>福建省摄影行业协会网</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>版权所有：福建省摄影行业协会</td>
					<td>&nbsp;</td>
					<td>网站运营：福州中天创信网络技术有限公司</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>闽ICP备14016797号</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<!-- bottom 区域 END -->
</body>
</html>
