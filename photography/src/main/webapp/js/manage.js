/**
 * 
 */



function displayUploadImg(data){
	var jsonObj = eval('('+ data + ')');
	if(jsonObj.state == "SUCCESS"){
		var Objs = jsonObj.data.obj;
		$("#commodityImg").attr("src",Objs);
		$("#commodityImg").show();
	}
}

//根据传入的名字name，来提交表单
function addForm(name){
	//获取表单的所有参数以及值
	var dataJS = $("#add"+name+"Form").serialize(); 
	
	$.post("./api/add"+name, dataJS , function(data){
		var json = eval('('+ data + ')');
		if(json.state == "SUCCESS"){
			alert("add success..");
		}
	});	
}
	
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
						detailUser(userid);
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

function setImgUrl(imgSrc){
	imgSrc
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
		url : "./api/deleteCommodity?commodityid="+commodityid ,//要访问的后台地址  
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
		url : "./api/deleteComment?commentid="+commentid + " &storeid="+storeid+"&commodityid="+commodityid,//要访问的后台地址  
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

function detailUser(userid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/detailUser?userid="+userid ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("detail success");
				var array_element = json.data.obj;
				// TODO
				//隐藏右侧所有
				$(".right_div_clazz").css("display","none");
				var string = "";
				string += "<div><span>用户名<span><input type=\"text\" >"
				string += array_element.username
				string += "</input></div>"
				string += "<div><span>用户类型<span><input type=\"text\" >"
				if(null != array_element.type){
					if("1" == array_element.type){
						string+="管理员";
					}else if("2" == array_element.type){
						string+="商家";
					}else if("3" == array_element.type){
						string+="会员";
					}
				}
				string += "</input></div>"
				string += "<div><span>手机号<span><input type=\"text\" >"
				string += array_element.telephone
				string += "</input></div>"
				string += "<div><span>邮箱<span><input type=\"text\" >"
				string += array_element.email
				string += "</input></div>"
				string += "<div><span>账户状态<span><input type=\"text\" >"
				if(null != array_element.active){
					if("1" == array_element.active){
						string+="激活";
					}else if("2" == array_element.active){
						string+="未激活";
					}
				}			
				string += "</input></div>"
				
				//添加到右侧栏中
					
					
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


function detailArea(areaid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/detailArea?areaid="+areaid ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("detail success");
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


function detailStore(storeid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/detailStore?storeid="+storeid ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("detail success");
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

function detailCommodity(commodityid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/detailStore?commodityid="+commodityid ,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("detail success");
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

function detailComment(commentid,storeid,commodityid){
	$.ajax({
		type : "post",//使用post方法访问后台  
		dataType : "json",//返回json格式的数据  
		url : "./api/detailStore?commentid="+commentid + " &storeid="+storeid+"&commodityid="+commodityid,//要访问的后台地址  
		contentType : "application/json;charset=utf-8",
		data : "", //要发送的数据  
		beforeSend : function() { //数据发送前报告
			//alert("ajax发送消息前。。。");
		},
		success : function(json) {//data为返回的数据，在这里做数据绑定 
			
			if(json.state == "SUCCESS"){
				alert("detail success");
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
	