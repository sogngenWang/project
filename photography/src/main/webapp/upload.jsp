<%@ page language="java" contentType="text/html; charset=utf-8"%>
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
<title>Upload</title>

<!--装载文件-->
<link href="./js/uploadify/uploadify.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="./js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="./js/uploadify/jquery.uploadify.js"></script>

<!--ready事件-->
<script type="text/javascript">
	$(function() {
		//隐藏图片
		$("#previewImgs").hide();
		//图片上传事件
		$("#file_upload").uploadify({
			'auto' : false,
			'swf' : 'js/uploadify/uploadify.swf',
			'uploader' : '/Photography/api/uploadFile', 
			'fileObjName' : 'file',
			'onUploadSuccess' : function(file, data, response) {
				//data是一个json的字符串
				if(true == response){
					displayUploadImg(data);
				}else{
					alert("upload failed ....");
				}
				
			}
		});
	});
	
	
	function displayUploadImg(data){
		var jsonObj = eval('('+ data + ')');
		if(jsonObj.state == "SUCCESS"){
			var Objs = jsonObj.data.obj;
			$("#previewImgs").attr("src",Objs);
			$("#previewImgs").show();
		}
	}
	
</script>

<style type="text/css">
#previewImgs{
	width: 100px;
	height: 100px;
}
</style>

</head>

<body>
	<form>
		<div id="queue"></div>
		<input type="file" name="file_upload" id="file_upload" /> 
		<a href="javascript:$('#file_upload').uploadify('upload','*')">Upload Files</a>
		
	</form>
	
	<img src="" id="previewImgs" >

</body>
</html>