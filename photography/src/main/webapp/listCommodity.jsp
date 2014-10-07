<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<base href="<%=basePath%>">
<script src="./js/jquery-1.9.1.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>merry</title>

<script type="text/javascript" src="./js/dream.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//获取参数值
		var commodityid = getParameter("commodityid");
		if(typeof commodityid == "undefined"){
			window.location.href="main.jsp?kinds=1";
		}
		
		//显示商品详情
		
		
	});
	
	function detailCommodity(commodityid){
		//如果commodityid为undifined,则不进行任何操作
		if(typeof commodityid == "undefined"){
			return  ;
		}
		
		//获取商品信息
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "./detailCommodity?commodityid="+commodityid ,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			cache : 'false', 
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
				$("#detailCommodity").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var obj = json.data.obj;
					var string = "";
					// commodityid commodityname commodityprice commoditydetail commoditypic committime lastupdatetime kindsid);
					string += "<div attr=\""+ obj.commodityid + "\" class=\"commodity\">";
					string += "<a href=\"javascript:void(0);\"><img src=\""+obj.commoditypic +"\" class=\"commodityImg\"/></a>";
					string += "<div>"+obj.commodityprice +"￥</div>";
					string += "<div>"+obj.commodityname +"</div>";
					string += "</div>";
					//  加入到页面的标签元素中
					$("#detailCommodity").append(string);
					
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
	
	function listComment(commodityid){
		//如果order为undifined,则使用默认排序
		if(typeof commodityid == "undefined"){
			return ;
		}
		//如果没有选择地区，则不进行过滤
		
		//获取到所有的商品信息，通过kindsId过滤掉部分
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "./listComment?commodityid="+commodityid,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			cache : 'false', 
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				//清空该标签下的所有数据
				$("#listComment").html("");
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					var string = "";
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// commodityid commodityname commodityprice commoditydetail commoditypic committime lastupdatetime kindsid);
						string += "<div attr=\""+ array_element.commodityid + "\" class=\"commodity\">";
						string += "<a href=\"javascript:void(0);\"><img src=\""+array_element.commoditypic +"\" class=\"commodityImg\"/></a>";
						string += "<div>"+array_element.commodityprice +"￥</div>";
						string += "<div>"+array_element.commodityname +"</div>";
						string += "</div>";
						//  加入到页面的标签元素中
					}
					
					$("#listComment").append(string);
					
					//注册点击事件
					
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
	
	
</script>
<!-- 800px高*1600px宽 -->
<style>
</style>

</head>

<body>

<div id="detailCommodity">
	
</div>

<div id="listComment">

</div>


</body>
</html>
