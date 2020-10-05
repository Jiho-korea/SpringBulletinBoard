<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			<h4 class="mb-4">
				<spring:message code="go.register" />
			</h4>
			<form:form action="${pageContext.request.contextPath}/register/step3"
				method="post" cssClass="form-signin"
				modelAttribute="registerRequest" onsubmit="return clickEvent()">
				<label><spring:message code="name" /> <form:input
						path="name" cssClass="form-control" /> <form:errors path="name" /></label>
				<br class="mb-4" />
				<label><spring:message code="sid" /><form:input
						path="sid" cssClass="form-control" />
				<form:errors path="sid" /></label>

				<br class="mb-4" />

				<div class="row">
					<div class="col-md-6 mb-1">
						<label><spring:message code="password" /> <form:password
								path="password" cssClass="form-control" /> <form:errors
								path="password" /></label>


					</div>
					<div class="col-md-6 mb-1">
						<label><spring:message code="confirmPassword" /> <form:password
								path="confirmPassword" cssClass="form-control" />
							<form:errors path="confirmPassword" /></label>
					</div>
				</div>

				<br class="mb-4" />
				<label><spring:message code="grade" /> <form:input
						path="grade" cssClass="form-control" />
				<form:errors path="grade" /></label>
				<br class="mb-4">
				<label> <spring:message code="subject" /> <form:input
						path="subject" cssClass="form-control" />
					<form:errors path="subject" />
				</label>


				<br class="mb-4" />

				<hr class="mb-4" />
				<button id="btn_register" class="btn btn-primary btn-lg btn-block"
					type="submit">
					<spring:message code="go.register" />
				</button>
			</form:form>
		</div>
	</div>
</body>
<script defer type="text/javascript" charset="utf-8">
	//	function clickEvent() {
	//		var password = $("#password").val();
	//		var confirmPassword = $("#confirmPassword").val();
	//		if (password != confirmPassword) {
	//			alert("비밀번호를 다시 확인해주세요.");
	//			return false;
	//		} else if ($("#name").val() == "") {
	//			alert("이름을 입력해주세요.");
	//			return false;
	//		} else if ($("#sid").val() == "") {
	//			alert("학번을 입력해주세요.");
	//			return false;
	//		} else if ($("#password").val() == "") {
	//			alert("비밀번호를 입력해주세요.");
	//			return false;
	//		} else if ($("#grade").val() == "") {
	//			alert("학년을 입력해주세요.");
	//			return false;
	//		} else if ($("#subject").val() == "") {
	//			alert("학과를 입력해주세요.");
	//			return false;
	//		}
	//	}
</script>
</html>