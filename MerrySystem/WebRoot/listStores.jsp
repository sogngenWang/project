<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		    <![endif]-->

		<script type="text/javascript">
	$(document).ready(function() {

	});

	function displayStoreInfo(objects) {

		//获取到所有的storeId，通过ajax后台查询
		$
				.ajax( {
					type : "post",//使用post方法访问后台  
					dataType : "json",//返回json格式的数据  
					url : "${pageContext.request.contextPath}/listStoreByKindsStoreAction.action?kindsStore="
							+ objects,//要访问的后台地址  
					contentType : "application/json;charset=utf-8",
					data : "", //要发送的数据  
					success : function(json) {//data为返回的数据，在这里做数据绑定  
						json = eval(json.storeList);// 注意options，如果不写Options ，下面的写法就是json.options.length
					//清空该标签下的所有数据
					$("#right").html("");
					for ( var i = 0; i < json.length; i++) {
						$("#right").append(
									"<li id=\"storeId_" + json[i].storeId + "\">"
											+ "公司名称:" + json[i].storeName
											+ "<br/>公司地址:"
											+ json[i].storeAddress
											+ "<br/>展会位置:"
											+ json[i].storePosition  +"</li>");
					}

					$("#right li").attr("class", "list-group-item");

				},
				error : function() {
					alert("ajax error....");
				}
				});
	}
</script>
		<style type="text/css">
body {
	width: 800px;
	margin: 0 auto;
}

#mainDiv {
	margin: 0 50px auto 20px;
}
</style>
	</head>

	<body role="document">

		<div class="container">
			<div class="row">
				<div class="col-sm-3" id="mainDiv">
					<ul class="list-group">
						<c:forEach items="${kinds.kindsList}" var="kindsInfo"
							varStatus="vs">
							<li class="list-group-item">
								${vs.count}&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:void(0);" id="${kindsInfo.kindsId}"
									onclick="displayStoreInfo('${kindsInfo.kindsStore}');">${kindsInfo.kindsName}</a>
							</li>
						</c:forEach>
					</ul>
				</div>

				<div class="col-sm-3">
					<ul class="list-group" id="right">
					</ul>
				</div>
			</div>
		</div>


	</body>
</html>
