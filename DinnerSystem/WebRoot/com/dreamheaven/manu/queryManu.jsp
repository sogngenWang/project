<?xml version="1.0" encoding="UTF-8" ?> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.js"></script>

<script type="text/javascript">
</script>
<style type="text/css">
*{
	
}

</style>
</head>
<body>

xxx
	<c:forEach items="${manu.manuList}" var="manuList" varStatus="vs1">
						<div id="dottedLine"></div>
						<div class="message">
							<div class="orderId">
								classId:${manuList.classId}
							</div>
							<br />
							<div class="orderState">
								className:${manuList.className}
							</div>
							<c:forEach items="${manuList.dishList}" var="dishList"
								varStatus="vs2">
								<div class="message">
									<div class="dishId">
										dishId:${dishList.dishId}
									</div>
									<br />
									<div class="dishName">
										dishName:${dishList.dishName}
									</div>
									<div class="dishCash"> 
										dishCash:${dishList.dishCash}
									</div>
									<c:forEach items="${dishList.ingredientList}" var="ingredientList"
										varStatus="vs3">
										<div class="message">
											<div class="ingredientId">
												ingredientId:${ingredientList.ingredientId}
											</div>
											<br />
											<div class="ingredientName">
												ingredientName:${ingredientList.ingredientName}
											</div>
											<div class="ingredientCash">
												ingredientCash:${ingredientList.ingredientCash}
											</div>

											<br />
											<br />
										</div>
									</c:forEach>
									<br />
									<br />
								</div>
							</c:forEach>

							<br />
							<br />
						</div>
					</c:forEach>

</body>
</html>