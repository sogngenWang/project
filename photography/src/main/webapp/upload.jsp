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
<link href="./js/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="./js/uploadify/jquery.uploadify.js"></script>

<!--ready事件-->
<script type="text/javascript">
    $(document).ready(function() {
    	
    	
        $("#uploadify").uploadify({
            'uploader' : 'js/uploadify/uploadify.swf',
            'script' : 'UploadFileServlet',//后台处理的请求
            'cancelImg' : 'js/uploadify/uplodify-cancel.png',
            'folder' : 'upload',//您想将文件保存到的路径
            'queueID' : 'fileQueue',//与下面的id对应
            'queueSizeLimit' : 5,
            'fileDesc' : 'rar文件或zip文件',
            'fileExt' : '*.rar;*.zip', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc
            'auto' : false,
            'multi' : true,
            'simUploadLimit' : 2,
            'buttonText' : '选择上传文件',
            'method': 'GET'
        });
        
    });
    
    
	function UpladFile() {
		
        var fileObj = document.getElementById("uploadFileInput").files[0]; // js 获取文件对象
        var FileController = "upload";                    // 接收上传文件的后台地址 
        
        // FormData 对象
        var form = new FormData();
        form.append("file", fileObj);  
        
        // XMLHttpRequest 对象
        var xhr = new XMLHttpRequest();
        xhr.open("post", FileController, true);
        xhr.onload = function () {
            alert("上传完成!");
        };
	};
        
</script>
</head>

<body>

    <div id="fileQueue"></div>
    <input type="file" name="uploadify" id="uploadify" />
    <p>
        <a href="javascript:jQuery('#uploadify').uploadify('upload')">开始上传</a>&nbsp;
        <a href="javascript:jQuery('#uploadify').uplaodify('cancel','*')">取消所有上传</a>
    </p>
  
    
    <!-- 此处的method必须为post 
    <form action="upload" enctype="multipart/form-data" method="post" target="frameFile" >
   		 <input type="file" name="uploadImg" id="uploadFileInput"/>
   		 <button type="submit">submit</button>
    </form>
    
   <iframe id="frameFile" name="frameFile" style="display:none;"></iframe>
-->
</body>
</html>