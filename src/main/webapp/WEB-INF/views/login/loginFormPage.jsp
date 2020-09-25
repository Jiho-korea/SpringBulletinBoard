<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width , initial-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<style>
#main {
	width: 30%;
	margin-top: 50px;
}
</style>
<script defer src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script defer src="js/bootstrap.js"></script>
<title><spring:message code="login.title" /></title>
</head>
<body class="text-center">

	<div class="container" id="main">
		<div class="jumbotron">
			<form action="${pageContext.request.contextPath}/login"
				class="form-signin" method="post">
				<h1 class="h3 mb-3 font-weight-bold">
					<spring:message code="login.banner" />
				</h1>
				<c:choose>
					<c:when test="${empty sessionScope.login1}">
						<input type="number" name="sid" class="form-control"
							placeholder="<spring:message code="sid"/>" autofocus="autofocus"
							style="margin-top: 50px">
						<input type="password" name="password" class="form-control"
							placeholder="<spring:message code="password"/>">
						<div class="checkbox mb-3">
							<input type="checkbox" name="memory" value="memory">
							<spring:message code="login.memory" />
						</div>
					</c:when>

					<c:otherwise>
						<input type="number" name="sid" class="form-control"
							placeholder="<spring:message code="sid"/>" value="${sessionScope.login1}"
							autofocus="autofocus" style="margin-top: 50px">
						<input type="password" name="password" class="form-control"
							placeholder="<spring:message code="password"/>">
						<div class="checkbox mb-3">
							<input type="checkbox" name="memory" value="memory" checked>
							<spring:message code="login.memory" />
						</div>
					</c:otherwise>
				</c:choose>

				<button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="go.login" /></button>
				<a href="${pageContext.request.contextPath}/register/step1"><spring:message code="go.register" /></a>
				<p class="mt-5 mb-3 text-muted"><spring:message code="login.right"/></p>
			</form>
		</div>
	</div>

</body>
</html>