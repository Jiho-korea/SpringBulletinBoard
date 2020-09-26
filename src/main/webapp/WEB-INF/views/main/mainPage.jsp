<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width , initial-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
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
<title>메인페이지</title>

</head>
<body>
	<%--
	<c:import url="included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
 	--%>
 
	<div class="container" style="margin-top: 60px">
		<div class="jumbotron">
			<div class="container">
				<h1>웹 사이트 소개</h1>
				<p>Spring Framework를 이용하여 만든 게시판 입니다.</p>
				<p>
					<a class="btn btn-primary btn-pull" href="#">Github</a>
				<p>
			</div>
		</div>
	</div>

</body>
</html>