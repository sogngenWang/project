<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" /> 
<!--  Style of the component -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<noscript>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleNoJS.css" />
</noscript>
</head> 
<body>

	<div id="loginDiv"></div>

	<div class="container" style="margin: 0px;">
		<div id="va-accordion" class="va-container" style="margin-top: 0px;">
			<div class="va-nav">
				<span class="va-nav-prev" style="top: 10px;">Previous</span> <span
					class="va-nav-next" style="bottom: 10px;">Next</span>
			</div>
			<div class="va-wrapper">
				<div class="va-slice va-slice-color-1">
					<h3 class="va-title">User Login</h3>
					<div class="va-content">
						<p>Company User Login</p>
						<br/>
						<p>As a stuff of a company.You can login weibo managerment if
							your company permit your register.</p>
						<br/>
						<ul>
							<li><a href="${pageContext.request.contextPath}/forward.action?actionFlag=1"> Forword </a>
							</li>
						</ul>
					</div>
				</div>
				<div class="va-slice va-slice-color-2">
					<h3 class="va-title">Company Login</h3>
					<div class="va-content">
						<p>Company Login</p>
						<br/>
						<p>As a company user, you must have your company account , or you can register by manager permit.</p>
						<br/>
						<ul>
							<li><a href="${pageContext.request.contextPath}/forward.action?actionFlag=2"> Forword </a>
							</li>
						</ul>
					</div>
				</div>
				<div class="va-slice va-slice-color-3">
					<h3 class="va-title">Manager Login</h3>
					<div class="va-content">
						<p>Manager Login</p>
						<br/>
						<p>As a manager, you have max competence on this system, and you can manage company user and stuff user.</p>
						<br/>
						<ul>
							<li><a href="${pageContext.request.contextPath}/forward.action?actionFlag=3"> Forword </a>
							</li>
						</ul>
					</div>
				</div>

				<div class="va-slice va-slice-color-5">
					<h3 class="va-title">Help</h3>
					<div class="va-content">
						<p>Manager Login</p>
						<br/>
						<p>If you need help , please call 15155445597 for more help.
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mousewheel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.vaccordion.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#va-accordion').vaccordion({
				accordionW : $(window).width(),
				accordionH : $(window).height(),
				visibleSlices : 5,
				expandedHeight : 450,
				animOpacity : 0.1,
				contentAnimSpeed : 100
			});
		});
	</script>
</body>
</html>