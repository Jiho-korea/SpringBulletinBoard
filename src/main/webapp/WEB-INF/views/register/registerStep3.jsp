<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width , initial-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<style>
#main {
	width: 40%;
	margin-top: 50px;
}
</style>
<script defer src="https://code.jquery.com/jquery-3.1.1.min.js"
	charset="utf-8"></script>
<script defer
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"
	charset="utf-8"></script>
<title><spring:message code="register.title" /></title>
</head>
<body class="text-center">
	<div class="container" id="main">
		<div class="jumbotron">
			<h4 class="mb-4"><spring:message code="register.done.banner" /></h4>
			<p>
				<spring:message code="register.done" >
					<spring:argument value="${registerRequest.name}"/>
					<spring:argument value="${registerRequest.sid}"/>
				</spring:message>
				
			</p>
			<br class="mb-4" />
			<hr class="mb-4" />
			 <a class="btn btn-primary"
				href="<c:url value='/login/login'/>" role="button"><spring:message code="go.login"/></a>

		</div>

	</div>
</html>