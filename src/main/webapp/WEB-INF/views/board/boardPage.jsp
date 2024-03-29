<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width , initial-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<style>
#main {
	width: 40%;
	margin-top: 50px;
}

a, a:hover {
	color: #000000;
	text-decoration: none;
	'
}
</style>
<title><spring:message code="board.title"/></title>
</head>

<body>
	<c:import url="../included/top.jsp">
		<c:param value="board" name="type" />
	</c:import>
	
	<div class="container" style="margin-top: 60px">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th
							style="background-color: #eeeeee; text-align: center; width: 15%"><spring:message code="board.post.no"/></th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 55%"><spring:message code="board.title"/></th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 10%"><spring:message code="board.student.name"/></th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 20%"><spring:message code="board.postingdate"/></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="post" items="${postList}">
						<tr>
							<td>${post.postNo}</td>
							<td><a href="../from/post?postNo=${post.postNo}">${fn:replace(fn:replace(fn:replace(fn:replace(fn:replace(post.title, ' ', '&nbsp;'), '<', '&lt;'), '>', '&gt;'), '\\n', ''), '\"', '&quot;')}
							</a></td>
							<td>${post.sid}</td>
							<td>${fn:split(fn:substring(post.postingdate, 0, 10),'-')[0]}년
								${fn:split(fn:substring(post.postingdate, 0, 10),'-')[1]}월
								${fn:split(fn:substring(post.postingdate, 0, 10),'-')[2]}일</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>



		</div>
		<div style="float: left">

			<c:choose>
				<c:when test="${pageNumber ne 1}">
					<a
						href="${pageContext.request.contextPath}/from/board?pageNumber=${pageNumber - 1}"
						class="btn btn-secondary" style="margin-left: 20px">◀</a>
				</c:when>
				<c:when test="${nextPage}">
					<a
						href="${pageContext.request.contextPath}/from/board?pageNumber=${pageNumber + 1}"
						class="btn btn-secondary" style="margin-left: 20px">▶</a>
				</c:when>
			</c:choose>

		</div>

		<div style="float: right">
			<a href="${pageContext.request.contextPath}/from/postingpage"
				class="btn btn-primary pull-right"><spring:message code="board.go.post"/></a>
		</div>

		<div style="float: right" align="center">
			<form action="${pageContext.request.contextPath}/from/board"
				class="form-inline">
				<div class="form-group mx-sm-3 mb-2">
					<label for="title" class="sr-only">제목</label> <input type="text"
						name="title" id="title" class="form-control" placeholder="제목">
					<input type="hidden" name="pageNumber" value="${pageNumber}">
					<button type="submit" class="btn btn-primary pull-right"><spring:message code="board.search"/></button>
				</div>

			</form>

		</div>
	</div>
</body>

</html>