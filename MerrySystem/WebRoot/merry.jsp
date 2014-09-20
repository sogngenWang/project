<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>merry</title>


<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Bootstrap theme -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.2.0/dist/css/bootstrap-theme.min.css"
	rel="stylesheet">

<script
	src="${pageContext.request.contextPath}/bootstrap-3.2.0/docs/assets/js/ie-emulation-modes-warning.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="${pageContext.request.contextPath}/bootstrap-3.2.0/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
<!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
    <![endif]-->
    
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		      <script src="${pageContext.request.contextPath}/bootstrap-3.2.0/js/html5shiv.min.js"></script>
		      <script src="${pageContext.request.contextPath}/bootstrap-3.2.0/js/respond.min.js"></script>
		    <![endif]-->

<style type="text/css">
#centerFrame {
	margin: 4px auto; 
	width: 1000px;
	width: 100%;
	border: none;
}
</style>


<script type="text/javascript">
	$(document).ready(function() {
		reflushIframe("${pageContext.request.contextPath}/mainAction.action");
		
		$("#firstPageButton").click(function(){
			$(".nav li").attr("class","");
			$(this).parent().attr("class","active");
			reflushIframe("${pageContext.request.contextPath}/mainAction.action");
		});
		$("#newsButton").click(function(){
			$(".nav li").attr("class","");
			$(this).parent().attr("class","active");
			reflushIframe("${pageContext.request.contextPath}/listMessageNoContentAction.action");
		});
		$("#exhibitorsButton").click(function(){
			$(".nav li").attr("class","");
			$(this).parent().attr("class","active");
			reflushIframe("${pageContext.request.contextPath}/listKindsAction.action");
		});
		$("#expoMapButton").click(function(){
			$(".nav li").attr("class","");
			$(this).parent().attr("class","active");
			reflushIframe("${pageContext.request.contextPath}/expoMap.jsp");
		});
	});
	
	function reflushIframe(action){
		$("#centerFrame").attr("src",action);		
		var framheight = document.getElementById("centerFrame").contentWindow.document.body.scrollWidth;
		$("#centerFrame").css("height",framheight);
	}
	
</script>
</head>
<body role="document">
      
	<iframe src="${pageContext.request.contextPath}/header.jsp"
		style="width: 100%;height: 200px;border: none;"></iframe>

	<div id="content">
		<iframe id="centerFrame"></iframe>
	</div>

	<iframe src="${pageContext.request.contextPath}/bottom.jsp"
		style="width: 100%;height: 200px;border: none;"></iframe>
</body>
</html>
