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
<base href="<%=basePath%>">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<meta charset="utf-8">
<title>merry</title>

<script type="text/javascript">
	$(document).ready(function() {
		listNews();
	}); 
	
	/**
		ajax 获取新闻列表
	*/
	function listNews(){
		request = "";
		$.ajax({
			type : "post",//使用post方法访问后台  
			dataType : "text",//返回json格式的数据  
			// url : "../testController?request="+request,//要访问的后台地址  
			url : "listMessageAction.action",
			contentType : "application/text;charset=utf-8",
			data : {request:request}, //要发送的数据 
			success : function(json) {//data为返回的数据，在这里做数据绑定 
				json = eval('(' + json + ')');   
				var Objs = json.messageList;
				var string = "";
				$("#clickNewsDiv table tbody").html("");
				for (var i = 0; i < Objs.length; i++) {
					var array_element = Objs[i];
					if(null != array_element){
						// 加入到页面的标签元素中 
						string+="<tr attr=\""+ array_element.messageId+"\" class=\"messageId\" >";
						string+="<td colspan=\"4\">"+ i + "</td>";
						string+="<td colspan=\"6\"><a href=\"javascript:void(0);\" class=\"messageTitle\">"+ array_element.messageTitle+"</a></td>";
						string+="<td colspan=\"4\">"+ array_element.createTime +"</td>";
						if(null != array_element.isTop && array_element.isTop == 1){
							string+="<td colspan=\"4\">(置顶新闻)</td>";
						}else{
							string+="<td colspan=\"4\"></td>";
						}
						string+="</tr>";
					}
				}
				$("#clickNewsDiv table tbody").append(string);
				$(".messageTitle").click(function(){
					window.location.href="updateMessage.jsp?messageId="+$(this).parent().parent().attr("attr");
				});
			},
			error : function() {
				alert("ajax error....");
			}
		});
	}
		
</script>
<!-- 800px高*1600px宽 -->
<style>
body {
	margin: 0 auto;
	width: 900px;
}

.messageTitleDiv {
	
}
</style>

</head>

<body>
	<h3>单击新闻标题进入修改页面</h3>
	<!-- 列出所有的message title -->
	<div id="clickNewsDiv" class="clickDiv">
		<table id="rounded-corner">
			<thead>
				<tr>
					<th colspan="4">新闻id</th>
					<th colspan="6" style="text-align: center;">新闻标题</th>
					<th colspan="4">新闻发布时间</th>
					<th colspan="4">是否置顶新闻</th>
				</tr>
			</thead>
			<!-- 表格内容<tr><td></td><td></td></tr> -->
			<tbody></tbody>
		</table>
	</div>
</body>
</html>
