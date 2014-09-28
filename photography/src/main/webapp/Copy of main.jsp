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
<meta charset="utf-8">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/dream.js"></script>

<title>拍的好!拍的好</title>
<script type="text/javascript">
	var kinds;
 	$(document).ready(function() {
		//获取参数值
		kinds = getParameter("kinds");
		if (null == kinds) {
			kinds = 1;
		}
		//显示所有区域
		displayArea();
		//显示所有商品信息
		displayCommodity();
		
		//注册相关事件
		$("#loginLink").click(function(){
			//清空原来的数据
			$(".windowSecond input").val("");
			$("#loginMessage").text("");
			//显示登录窗口，以及遮罩层
			$("#loginWindow").css("visibility","visible");
			$("#page_mask").css("visibility","visible");
			
		});
		$("#registerLink").click(function(){
			//清空原来的数据
			$(".windowSecond input").val("");
			$("#registerMessage").text("");
			//显示登录窗口，以及遮罩层
			$("#registerWindow").css("visibility","visible");
			$("#page_mask").css("visibility","visible");
			
		});
		$("#logoutLink").click(function(){
			//  用户注销
			userLogout();
		});
		$(".back").click(function(){
			//隐藏登录窗口，以及遮罩层
			$("#loginWindow").css("visibility","hidden");
			$("#registerWindow").css("visibility","hidden");
			$("#page_mask").css("visibility","hidden");
		});
		$("#login").click(function(){
			userLogin();
		});
		$("#register").click(function(){
			userRegister();
		});
		
		
		
		
	});

	function displayArea() {
		//获取到所有的区域Area，通过ajax后台查询
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/listArea",//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定  
				//json = eval(json);
				//清空该标签下的所有数据
				
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					var string = "";
					$("#selectArea").html("<option select=\"selected\" attr=\"-1\">--显示商品--</option>");
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// 加入到页面的标签元素中
						string+="<option attr=\""+array_element.areaid+"\">";
						string+=array_element.areaname;
						string+="</option>";
						// areaid  areaname
					}
					$("#selectArea").append(string);
				}else if (state == "BusinessException"){
					//业务异常
					alert("业务异常:"+code);
				} else {
					//其他非业务异常
					alert("系统异常:"+code);
				}

			},
			error : function() {
				alert("ajax error....");
			}
		});
	}


	// 按照某种排序列出所有商品信息
	function displayCommodity(order) {
		
		//如果order为undifined,则使用默认排序
		if(typeof order == "undefined"){
			order = null;
		}
		//如果没有选择地区，则不进行过滤
		
		//获取到所有的商品信息，通过kindsId过滤掉部分
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/listAndOrderCommodity?kindsid="+kinds+"&order="+order,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			cache : 'false', 
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
				$("#listCommodity").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					var string = "";
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// commodityid commodityname commodityprice commoditydetail commoditypic committime lastupdatetime kindsid);
						string += "<div attr=\""+ array_element.commodityid + "\" class=\"commodity\">";
						string += "<img src=\""+array_element.commoditypic +"\" class=\"commodityImg\"/>";
						string += "<div>"+array_element.commodityprice +"￥</div>";
						string += "<div>"+array_element.commodityname +"</div>";
						string += "</div>";
						//  加入到页面的标签元素中
					}
					
					$("#listCommodity").append(string);
				}else if (state == "BusinessException"){
					//业务异常
					alert("业务异常:"+code);
				} else {
					//其他非业务异常
					alert("系统异常:"+code);
				}
			},
			error : function() {
				alert("ajax error....");
			}
		});
		
	}
	
	function displayStore(areaid){
		//如果areaid为undifined,不传输areaid
		if(typeof areaid == "undefined"){
			areaid = null;
		}
		//如果没有选择地区，则不进行过滤
		
		//获取到所有的商品信息，通过kindsId过滤掉部分
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/listStore?areaid="+areaid,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			cache : 'false', 
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
				$("#listStore").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					var string = "";
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// storeid storename storedetail areaid storepic
						string += "<div attr=\""+ array_element.storeid + "\" class=\"store\">";
						string += "<img src=\""+array_element.storepic +"\" class=\"storeImg\"/>";
						string += "<div>"+array_element.storename +"</div>";
						string += "</div>";
						//  加入到页面的标签元素中
					}
					
					$("#listStore").append(string);
				}else if (state == "BusinessException"){
					//业务异常
					alert("业务异常:"+code);
				} else {
					//其他非业务异常
					alert("系统异常:"+code);
				}
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
	
	
	
	function userLogin() {
	//	var params = 
	//	{
	//		usrename : $("#loginWindow [name='username']").val(),
	//		password : $("#loginWindow [name='passwd']").val()
	//	};
		var username = $("#loginWindow [name='username']").val();
		var passwd  = $("#loginWindow [name='passwd']").val();
		//用户登录 
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据
			url : "${pageContext.request.contextPath}/login?username="+username+"&passwd="+passwd,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "" , //要发送的数据 
			cache : 'false',
			beforeSend : function() { //数据发送前报告

			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据	
				if(json.state == "SUCCESS"){
					$("#loginMessage").html("");
					$("#loginMessage").append("登录成功!");
				}else if(json.state == "FAILED"){
					$("#loginMessage").html("");
					$("#loginMessage").append("登录失败!用户名或者密码错误");
				}else if (json.state == "BusinessException"){
					//业务异常
					alert("业务异常:"+json.code);
				} else {
					alert("系统异常:"+json.code);
				}
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
	
	function userRegister() {
		//用户注册
		var usrename = $("#registerWindow [name='username']").val();
		var passwd = $("#registerWindow [name='passwd']").val();
		var telephone = $("#registerWindow [name='telephone']").val();
		var email = $("#registerWindow [name='email']").val();
		
		//用户注册
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "text",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/register?usrename="+usrename+"&passwd="+passwd +"&telephone="+telephone+"&email="+email,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			cache : 'false', 
			beforeSend : function() { //数据发送前报告

			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据	
				if(json.state == "SUCCESS"){
					$("#registerMessage").html("");
					$("#registerMessage").append("注册成功!");
				}else if(state == "FAILED"){
					$("#registerMessage").html("");
					$("#registerMessage").append("注册失败!用户名已存在");
				}else if (state == "BusinessException"){
					//业务异常
					alert("业务异常:"+code);
				} else {
					alert("系统异常:"+code);
				}
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
	
	function userLogout(){
		// TODO 用户注销
		
	}
	
	function selectArea(){
		var areaid = $("#selectArea  option:selected").attr("attr");
		if(areaid == "-1"){
			//值为-1则说明显示商品不显示商家
			$("#listCommodity").css("display","inline-block");
			//隐藏显示商家
			$("#listStore").css("display","none");
		}else{
			displayStore(areaid);
			//显示该地区的所有商家
			$("#listStore").css("display","inline-block");
			$("#listCommodity").css("display","none");
		}
	}
	function selectOrder(){
		var order = $("#selectOrder option:selected").val();
		displayCommodity(order);
		
	}
</script>
<style type="text/css">
/* 设置输入框长度 */
input {
	width: 130px;
}

/* 设置登录框 */
#loginWindow {
	visibility: hidden;
	position: fixed;
	z-index: 100;
	top: 40%;
	left: 40%;
	height: 20%;
	width: 210px;
	background-color: gray;
}
/* 设置注册窗 */
#registerWindow {
	visibility: hidden;
	position: fixed;
	z-index: 100;
	top: 40%;
	left: 40%;
	height: 20%;
	width: 210px;
	background-color: gray;
}
/* 设置登录，注册框下的行长度 */
.line{
	width: 200px;
}
/* 设置登录，注册框下的行第一个div长度 */
.windowFirst {
	width: 70px;
	display: inline-block;
}
/* 设置登录，注册框下的行第二个div长度 */
.windowSecond {
	width: 70px;
	display: inline-block;
}
/* 设置遮罩层 */
#page_mask {
	visibility: hidden;
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0px;
	left: 0px;
	display: block;
	z-index: 10;
	background-color: rgb(0, 0, 0);
	opacity: 0.3;
}

/* 登录注册超链接 */
#loginWindw {
	float: right;
}

#loginUsername {
	display: none;
}

/* 商品栏     */
#listCommodity {
	margin: 0 auto;
	width: 1050px;
	height:1000px;
	background-color: rgb(100,100,100);
	
}

.commodity{
	text-align:center;
	width: 200px;
	height: 250px;
	background-color: yellow;
	display: inline-block;
	margin: 10px 10px 0  0;
}




.commodityImg{
	width: 200px;
	height: 200px;
} 

/* 商家栏 */
#listStore {
	display:none;
	margin: 0 auto;
	width: 1050px;
	height:1000px;
	background-color: rgb(100,100,100);
	
}

.store {
	text-align:center;
	width: 200px;
	height: 220px;
	background-color: yellow;
	display: inline-block;
	margin: 10px 10px 0  0;
}

.storeImg{
	width: 200px;
	height: 200px;
}

#content {
	width:1050px;
	margin: 0 auto;
	background-color: rgb(150,150,150);
}
#listArea {
	width:1050px;
	display: block;
}
#listOrder {
	width:1050px;
	display: block;
}

#buttom{
	width: 100%;
	height: 200px;
	border: none;
}

</style>

</head>

<body>

	<!-- 登录窗以及注册窗口为固定布局，不会影响整体布局 -->
	
	<!-- 遮罩层 -->
	<div id="page_mask"></div>
	<!-- 显示登录窗口 -->
	<div id="loginWindow">
		<div class="line"><div class="windowFirst">用户名:</div><div class="windowSecond"><input type="text"  name="username" /></div></div>
		<div class="line"><div class="windowFirst">密码:</div><div class="windowSecond"><input type="password"  name="passwd"/></div></div>
		<div class="line"><div class="windowFirst"><button id="login">登录</button></div><div class="windowSecond"><button class="back">返回</button></div></div>
		<div id="loginMessage"></div>
	</div>
	<!-- 显示注册窗口 -->
	<div id="registerWindow">
		<div class="line"><div class="windowFirst">用户名:</div><div class="windowSecond"><input type="text"  name="username" /></div></div>
		<div class="line"><div class="windowFirst">密码:</div><div class="windowSecond"><input type="password" name="passwd"/></div></div>
		<div class="line"><div class="windowFirst">手机:</div><div class="windowSecond"><input type="text"  name="telephone"/></div></div>
		<div class="line"><div class="windowFirst">邮箱:</div><div class="windowSecond"><input type="text"  name="email"/></div></div>
		<div class="line"><div class="windowFirst"><button id="register">注册</button></div><div class="windowSecond"><button class="back">返回</button></div></div>
		<div id="registerMessage"></div>
	</div>


	<div id="header">
		<div id="loginWindw">
			<a id="loginUsername" href="javascript:void(0);"></a> <a
				id="loginLink" href="javascript:void(0);">登录</a> <a
				id="registerLink" href="javascript:void(0);">注册</a> <a
				id="logoutLink" href="javascript:void(0);">注销</a>
		</div>
	</div>


	<div id="content">
		<div id="orderBy">
			<select id="selectOrder" onchange="selectOrder()">
				<option value="committime" selected="selected">商品创建时间</option>
				<option value="commodityname">商品名字</option>
				<option value="lastupdatetime">商品最后修改时间</option>
				<option value="commodityprice">商品价格</option>				
			</select>
		</div>
		<div id="listArea">
			<!-- 地区选择 -->
			<select id="selectArea" onchange="selectArea()"></select>
		</div>
		<!-- 显示商家 -->
		<div id="listStore"></div>
		<!-- 最好用到分页插件 -->
		<div id="listCommodity"></div>
		<div id="pageDiv"></div>
	</div>

	<iframe id="buttom" src="${pageContext.request.contextPath}/bottom.jsp"	></iframe>
		
</body>
</html>
