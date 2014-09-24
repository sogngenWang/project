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
