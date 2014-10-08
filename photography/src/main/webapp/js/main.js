/**
 * 
 */

/**
 * 传入参数名字，即可获取到该参数所对应的参数值
 */
function getParameter(sProp) {
	var re = new RegExp(sProp + "=([^\&]*)", "i");
	var a = re.exec(document.location.search);
	if (a == null)
		return null;
	return a[1];
};

/**
 * 刷新某个iframe的action,同时是得这个iframe的高度自适应增长
 * @param attraction
 */
function reflushIframe(iframeID,action){
	$("#"+iframeID).attr("src",action);		
	var framheight = document.getElementById(iframeID).contentWindow.document.body.scrollWidth;
	$("#"+iframeID).css("height",framheight);
}



/**
 * 传入json格式的数据，然后解析该数据
 * @param type(obj还是list),json, struct(对象/list中的属性列表,用逗号隔开)
 */
function resolveJSON(type,json,struct){
	//如{"state":"SUCCESS","data":{"list":[{"areaid":1,"areaname":"福州"},{"areaid":2,"areaname":"泉州"},{"areaid":3,"areaname":"厦门"},{"areaid":4,"areaname":"漳州"},{"areaid":5,"areaname":"宁德"},{"areaid":6,"areaname":"莆田"}]},"code":"0"}
	//如{"state":"SUCCESS","data":{"obj":{"areaid":2,"areaname":"泉州"}},"code":"0"}
	var state = json.state;
	var code = json.code;
	var data = json.data;
	if(state == "SUCCESS"){
		if(type == "list"){
//			alert("xx");
			//创建一个数组
			var Objs = data.list;
			var objStruct = struct.split(",");
			var array1 = [];
			var array2 = [];
			
			
//			alert(Objs.length);
			for (var int = 0; int < Objs.length; int++) {
				var array_element = Objs[int];
//				alert(array_element.areaname+"|A");
//				alert(array_element.length+"|B");
				for (var int2 = 0; int2 < objStruct.length; int2++) {
					alert(array_element[objStruct[int2]]+"|C");
				}
				
			}
			
		}
		//成功
		//alert(data.list);
		
		//alert(data.obj);
		
	}else if (state == "BusinessException"){
		//业务异常
		alert(code);
	}else{
		//其他非业务异常
		alert(code);
	}
	
}

var kinds;
$(document).ready(function() {
		//前台框架需要调用
		$('.ask').jConfirmAction();
		
	//获取参数值
	kinds = getParameter("kinds");
	if(typeof kinds == "undefined"){
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
	
		//先校验两次密码输入是否正确，如果错误则不提交
		var passwd1 = $("#newPasswd").val();
		var passwd2 = $("#reNewPasswd").val();
		alert(passwd1+"|"+passwd2);
		if(null != passwd1 && null !== passwd2){
			if(passwd1 == passwd2 ){
				userRegister();
			}
		}
		
		
		//userRegister();
	});
	
	$("#leftBarCommodity").click(function(){
		$("#listCommodity").css("display","inline-block");
		//隐藏显示商家
		$("#listStore").css("display","none");
	});
	
	
	$("#leftBarStore").click(function(){
		displayStore();
		//显示商家
		$("#listStore").css("display","inline-block");
		//隐藏商品信息
		$("#listCommodity").css("display","none");
		
	});
	
});

function displayArea() {
	//获取到所有的区域Area，通过ajax后台查询
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/listArea",//要访问的后台地址  
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
				$("#areaUl").html("");
				for (var int = 0; int < Objs.length; int++) {
					var array_element = Objs[int];
					// 加入到页面的标签元素中
					string+="<li><a href=\"javascript:void(0);\" attr=\""+array_element.areaid+"\" class=\"areaclassli\">";
					string+=array_element.areaname;
					string+="</a></li>";
					// areaid  areaname
				}
				
				$("#areaUl").append(string);
				//添加完之后才可以注册事件
				$(".areaclassli").click(function(){
					displayStore($(this).attr("attr"));
					//显示该地区的所有商家
					$("#listStore").css("display","inline-block");
					$("#listCommodity").css("display","none");
				});
				
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
		url : "./api/listAndOrderCommodity?kindsid="+kinds+"&order="+order,//要访问的后台地址  
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
					string += "<a href=\"javascript:void(0);\"><img src=\""+array_element.commoditypic +"\" class=\"commodityImg\"/></a>";
					string += "<div>"+array_element.commodityprice +"￥</div>";
					string += "<div>"+array_element.commodityname +"</div>";
					string += "</div>";
					//  加入到页面的标签元素中
				}
				
				$("#listCommodity").append(string);
				
				//注册点击事件
				$(".commodityImg").click(function(){
					//页面跳转
					var commodityid = $(this).parent().parent().attr("attr");
					window.location.href="listCommodity.jsp?commodityid="+commodityid;
				});
				
				
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
		action = "./listStore";
	}else{
		action = "./listStore?areaid="+areaid;
	}
	//如果没有选择地区，则不进行过滤
	
	//获取到所有的商品信息，通过kindsId过滤掉部分
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/listStore",//要访问的后台地址  
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
		url : "./api/login?username="+username+"&passwd="+passwd,//要访问的后台地址  
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
				alert("xxxxxxx");
				$("#welcome").val("欢迎回来  " + username);
				$("#welcome").css("visibility","visible");
				$("#logoutLink").css("visibility","visible");
				
				$("#loginLink").css("visibility","hidden");
				$("#registerLink").css("visibility","hidden");
				
				
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
	var username = $("#registerWindow [name='username']").val();
	var passwd = $("#registerWindow [name='passwd']").val();
	var telephone = $("#registerWindow [name='telephone']").val();
	var email = $("#registerWindow [name='email']").val();
	
	//用户注册
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "text",//返回json格式的数据  
		url : "./register?username="+username+"&passwd="+passwd +"&telephone="+telephone+"&email="+email,//要访问的后台地址  
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
	//用户注销
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "text",//返回json格式的数据  
		url : "./logout" ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		cache : 'false', 
		beforeSend : function() { //数据发送前报告

		},
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			//清空该标签下的所有数据	
			if(json.state == "SUCCESS"){
				alert("注销成功!");
				//隐藏已经登录的用户标签
				//  页面刷新.去掉用户信息,
				$("#welcome").css("visibility","hidden");
				$("#logoutLink").css("visibility","hidden");
				
				$("#loginLink").css("visibility","visible");
				$("#registerLink").css("visibility","visible");
				
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
