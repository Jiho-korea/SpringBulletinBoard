<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			<form:form action="${pageContext.request.contextPath}/login/login"
				method="post" cssClass="form-signin" modelAttribute="loginRequest">
				<h1 class="h3 mb-3 font-weight-bold">
					<spring:message code="login.banner" />
				</h1>
				<form:errors />

				<label style="margin-top: 20px"><spring:message code="sid" />
					<form:input path="sid" cssClass="form-control" /> <form:errors
						path="sid" /> </label>

				<label><spring:message code="password" /> <form:password
						path="password" cssClass="form-control" /> <form:errors
						path="password" /> </label>

				<div class="checkbox mb-3">
					<form:checkbox path="memory"/>
					<spring:message code="login.memory" />
				</div>

				<button class="btn btn-lg btn-primary btn-block" type="submit">
					<spring:message code="go.login" />
				</button>
				<a href="${pageContext.request.contextPath}/register/step1"><spring:message
						code="go.register" /></a>
				<p class="mt-5 mb-3 text-muted">
					<spring:message code="login.right" />
				</p>
			</form:form>

		</div>
	</div>

</body>
</html>