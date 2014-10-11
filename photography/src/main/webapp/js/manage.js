/**
 * 
 */


$(document).ready(function() {
		//删除按钮点击的时候，返回是否提交的提示框
		//$('.ask').jConfirmAction();
		
		displayUser();
		$(".right_div_clazz").css("display","none");
		$("#listUser").css("display","block");
		
		$("#listUserManu").click(function(){
			$(".right_div_clazz").css("display","none");
			displayUser();
			$("#listUser").css("display","block");
		});
		
		$("#addUserManu").click(function(){
			$(".right_div_clazz").css("display","none");
			$("#addUser").css("display","block");
		});
		
		$("#listAreaManu").click(function(){
			$(".right_div_clazz").css("display","none");
			displayArea();
			$("#listArea").css("display","block");
		});
		
		$("#addAreaManu").click(function(){
			$(".right_div_clazz").css("display","none");
			$("#addArea").css("display","block");
		});
		$("#listCommodityManu").click(function(){
			$(".right_div_clazz").css("display","none");
			displayCommodity();
			$("#listCommodity").css("display","block");
		});
		
		$("#addCommodityManu").click(function(){
			$(".right_div_clazz").css("display","none");
			$("#addCommodity").css("display","block");
		});
		
		$("#listStoreManu").click(function(){
			$(".right_div_clazz").css("display","none");
			displayCommodity();
			$("#listStore").css("display","block");
		});
		
		$("#addStoreManu").click(function(){
			$(".right_div_clazz").css("display","none");
			$("#addStore").css("display","block");
		});
		
		$("#listCommentManu").click(function(){
			$(".right_div_clazz").css("display","none");
			displayCommodity();
			$("#listComment").css("display","block");
		});
		
		$("#addCommentManu").click(function(){
			$(".right_div_clazz").css("display","none");
			$("#addComment").css("display","block");
		});
		
});
	
function displayUser(){
		//获取到所有的区域Area，通过ajax后台查询
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "./api/listUser" ,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					var string = "";
					$("#listUser table tbody").html("");
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// 加入到页面的标签元素中
						string+="<tr attr=\""+array_element.userid+"\" class=\"userid\">";
						string+="<td>"+ array_element.username + "</td>";
						//用户类型判断
						string+="<td>";
						if(null != array_element.type){
							if("1" == array_element.type){
								string+="管理员";
							}else if("2" == array_element.type){
								string+="商家";
							}else if("3" == array_element.type){
								string+="会员";
							}
						}
						string+="</td>";
						string+="<td>"+ array_element.telephone + "</td>";
						string+="<td>"+ array_element.email + "</td>";
						//用户是否激活判断
						string+="<td>";
						if(null != array_element.active){
							if("1" == array_element.active){
								string+="激活";
							}else if("2" == array_element.active){
								string+="未激活";
							}
						}
						string+="</td>";
						string+="<td><a href=\"javascript:void(0);\" class=\"user_edit\"><img src=\"./js/frontModule/images/user_edit.png\" border=\"0\" /></a></td>";
						string+="<td><a href=\"javascript:void(0);\" class=\"user_delete\"><img src=\"./js/frontModule/images/trash.png\" border=\"0\" /></a></td>";
						string+="</tr>";
					}
					
					$("#listUser table tbody").append(string);

					
					// 注册事件
					$(".user_edit").click(function(){
						userid = $(this).parent().parent().attr("attr");
						editUser(userid);
					});
					$(".user_delete").click(function(){
						userid = $(this).parent().parent().attr("attr");
						alert(userid);
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



function displayArea(){
		//获取到所有的区域Area，通过ajax后台查询
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "./api/listArea" ,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			
			success : function(json) {//data为返回的数据，在这里做数据绑定
				//var jsonobj = resolveJSON("list",json,"areaid,areaname");
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					var string = "";
					$("#listArea table tbody").html("");
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// 加入到页面的标签元素中
						string+="<tr attr=\""+array_element.areaid+"\" class=\"userid\">";
						string+="<td>"+ array_element.areaname + "</td>";
						string+="<td><a href=\"javascript:void(0);\"><img src=\"./js/frontModule/images/user_edit.png\" border=\"0\" /></a></td>";
						string+="<td><a href=\"javascript:void(0);\" class=\"ask\"><img src=\"./js/frontModule/images/trash.png\" border=\"0\" /></a></td>";
						string+="</tr>";
						// areaid  areaname
					}
					
					$("#listArea table tbody").append(string);
										
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
	
function displayCommodity(){
		//获取到所有的区域Area，通过ajax后台查询
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "json",//返回json格式的数据  
			url : "./api/listCommodity" ,//要访问的后台地址  
			contentType : "application/json;charset=utf-8",
			data : "", //要发送的数据  
			beforeSend : function() { //数据发送前报告
				//alert("ajax发送消息前。。。");
			},
			
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				
				if(json.state == "SUCCESS"){
					var Objs = json.data.list;
					var string = "";
					$("#listCommodity table tbody").html("");
					for (var int = 0; int < Objs.length; int++) {
						var array_element = Objs[int];
						// 加入到页面的标签元素中 
						string+="<tr attr=\""+array_element.commodityid+"\" class=\"userid\">";
						string+="<td>"+ array_element.commodityname + "</td>";
						string+="<td><a href=\"javascript:void(0);\"><img src=\"./js/frontModule/images/info.png\" border=\"0\" /></a></td>";
						string+="<td><a href=\"javascript:void(0);\"><img src=\"./js/frontModule/images/user_edit.png\" border=\"0\" /></a></td>";
						string+="<td><a href=\"javascript:void(0);\" class=\"ask\"><img src=\"./js/frontModule/images/trash.png\" border=\"0\" /></a></td>";
						string+="</tr>";
						// areaid  areaname
					}
					
					$("#listCommodity table tbody").append(string);
										
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

function displayStore(){
	//获取到所有的区域Area，通过ajax后台查询
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/listStore" ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				// TODO
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


function displayComment(){
	//获取到所有的区域Area，通过ajax后台查询
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/listComment" ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				// TODO
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


function displayCommodityOrStoreComment(storeid,commodityid){
	//获取到所有的区域Area，通过ajax后台查询
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/listCommodityOrStoreComment?storeid="+storeid+"&commodityid="+commodityid ,//要访问的后台地址 
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				// TODO
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


function deleteUser(userid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/deleteUser?userid="+userid ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("delete success");
				// TODO
				
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


function deleteArea(areaid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/deleteArea?areaid="+areaid ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("delete success");
				// TODO
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


function deleteStore(storeid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/deleteStore?storeid="+storeid ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("delete success");
				//TODO
				
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

function deleteCommodity(commodityid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/deleteStore?commodityid="+commodityid ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("delete success");
				//TODO
				
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

function deleteComment(commentid,storeid,commodityid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/deleteStore?commentid="+commentid + " &storeid="+storeid+"&commodityid="+commodityid,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("delete success");
				//TODO
				
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


	