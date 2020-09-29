<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#main {
	width: 40%;
	margin-top: 50px;
}

a, a:hover {
	color: #000000;
	text-decoration: none;
}
</style>
<title><spring:message code="main.title" /></title>

</head>
<body>

	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>


	<div class="container" style="margin-top: 60px">
		<div class="jumbotron">
			<div class="container">
				<h1>
					<spring:message code="main.banner" />
				</h1>
				<p>
					<spring:message code="main.description" />
				</p>
				<p>
					<a class="btn btn-primary btn-pull" href="#"><spring:message
							code="main.link" /></a>
				<p>
			</div>
		</div>
	</div>

</body>
</html>