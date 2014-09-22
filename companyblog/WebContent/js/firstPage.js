var announceMsgTextAreaValue;


function renderParent() {
	//调用父类的方法，更新页面上的微博总数 
	window.parent.ajaxRenderWeiboCount();
}

function clearText() {
	announceMsgTextArea = document.getElementById("announceMsgTextArea");
	announceMsgTextAreaValue = announceMsgTextArea.value;
	if (announceMsgTextAreaValue == "请输入你想要发布的微博") {
		announceMsgTextArea.value = "";
		announceMsgTextArea.style.color = "#000";
	}

}
function restoreText() {
	announceMsgTextArea = document.getElementById("announceMsgTextArea");
	if (announceMsgTextArea.value == "") {
		announceMsgTextArea.value = "请输入你想要发布的微博";
		announceMsgTextArea.style.color = "#999";
	}
}

function displayRelyMessage(messageId) {
	//显示当前点击的这条message的回复内容
	ajaxGetRelyMessage(messageId);
}

function displayRelyMessageInput(messageId) {
	$("#relyMessageInput_" + messageId).css("display", "block");
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