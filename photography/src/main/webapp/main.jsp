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
			//显示登录窗口，以及遮罩层
			$("#loginWindow").show();
			
		});
		$("#registerLink").click(function(){
			//显示登录窗口，以及遮罩层
			$("#registerWindow").show();
			
		});
		$("#logoutLink").click(function(){
			//  用户注销
			userLogout();
		});
		$(".back").click(function(){
			//隐藏登录窗口，以及遮罩层
			$("#loginWindow").hide();
			$("#registerWindow").hide();
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
				$("#listArea").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// TODO 加入到页面的标签元素中
						//alert(array_element.areaid+"|"+array_element.areaname);
					}
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

	// TODO 按照某种排序列出所有商品信息
	function displayCommodity() {
		//获取到所有的商品信息，通过kindsId过滤掉部分
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/listCommodity?kindsid="+kinds,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
				$("#listCommodity").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						var string = "";
						string += "<div id=\"commodityid_"+ array_element.commodityid + "\" class=\"commodity\">";
						string += "<img src=\""+array_element.commoditypic +"\"/>";
						string += "<div>"+array_element.commodityprice +"</div>";
						string += "<div>"+array_element.commodityname +"</div>";
						string += "</div>";
						// TODO 加入到页面的标签元素中
						// commodityid commodityname commodityprice commoditydetail commoditypic committime lastupdatetime kindsid);
					}
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
	

	// TODO 按照某种排序列出所有商品信息
	function displayCommodity(order) {
		//获取到所有的商品信息，通过kindsId过滤掉部分
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/listAndOrderCommodity?kindsid="+kinds+"&order="+order,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
				$("#listCommodity").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						var string = "";
						string += "<div id=\"commodityid_"+ array_element.commodityid + "\" class=\"commodity\">";
						string += "<img src=\""+array_element.commoditypic +"\"/>";
						string += "<div>"+array_element.commodityprice +"</div>";
						string += "<div>"+array_element.commodityname +"</div>";
						string += "</div>";
						// TODO 加入到页面的标签元素中
						// commodityid commodityname commodityprice commoditydetail commoditypic committime lastupdatetime kindsid);
					}
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
		var usrename = $("#loginWindow [name='username']").val();
		var passwd = $("#loginWindow [name='passwd']").val();
		//用户登录 
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/login?usrename="+usrename+"&passwd="+passwd ,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告

			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据	
				if(json.state == "SUCCESS"){
					$("#loginMessage").html("");
					$("#loginMessage").append("登录成功!");
				}else if(state == "FAILED"){
					$("#loginMessage").html("");
					$("#loginMessage").append("登录失败!用户名或者密码错误");
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
	
	function userRegister() {
		//用户注册
		var usrename = $("#registerWindow [name='username']").val();
		var passwd = $("#registerWindow [name='passwd']").val();
		var telephone = $("#registerWindow [name='telephone']").val();
		var email = $("#registerWindow [name='email']").val();
		
		//用户注册
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "${pageContext.request.contextPath}/register?usrename="+usrename+"&passwd="+passwd +"&telephone="+telephone+"&email="+email,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
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
</script>
<style type="text/css">
	#loginWindow{
		display: none;
	}
	#registerWindow{
		display: none;
	}
	
</style>

</head>

<body>
	<div id="listArea">
		<div id=""></div>
	</div>
	<!-- 最好用到分页插件 -->
	<div id="listCommodity">
	
	</div>

	<div id="loginWindw">
		<a id="loginLink" href="javascript:void(0);">登录</a>
		<a id="registerLink" href="javascript:void(0);">注册</a>
		<a id="logoutLink" href="javascript:void(0);">注销</a>
	</div>
	<!-- 显示登录窗口 -->
	<div id="loginWindow">
		用户名	:<input type="text"  name="username" />
		密码:<input type="password"  name="password"/> 
		<button id="login">登录</button> 
		<button class="back">返回</button>
		<div id="loginMessage"></div>
	</div>
	<!-- 显示注册窗口 -->
	<div id="registerWindow">
		用户名	:<input type="text"  name="username" />
		密码:<input type="password" name="passwd"/> 
		手机:<input type="text"  name="telephone"/>
		邮箱:<input type="text"  name="email"/>
		<button id="register">注册</button> 
		<button class="back">返回</button>
		<div id="registerMessage"></div>
	</div>
	显示所有地区listArea 显示所有商品listCommodity


</body>
</html>
