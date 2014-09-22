function getTime() {
	var d = new Date();
	document.getElementById("bannerDate").innerHTML = d.getFullYear() + "年"
			+ (d.getMonth() + 1) + "月" + d.getDate() + "日" + d.getHours() + "点"
			+ d.getMinutes() + "分" + d.getSeconds() + "秒";
	setTimeout("getTime()", 500);
}

function setBackGroundImg() {
	var width = document.body.clientWidth;
	var height = document.body.clientHeight;
	$("#imgDiv").css({
		"width" : width,
		"height" : height
	});
}

var mentionOfMeFlag = false;
var commentFlag = false;

function changeDivColor(divId) {
	$("#" + divId).mouseover(function() {
		$("#" + divId).toggleClass("divBlockChange");
	});
	$("#" + divId).mouseleave(function() {
		$("#" + divId).toggleClass("divBlockChange");
	});

}

function moreBig(id) {
	$("#" + id).animate({
		height : '150px',
		width : '150px'
	});
}
function recover(id) {
	$("#" + id).animate({
		height : '60px',
		width : '60px'
	});
}
