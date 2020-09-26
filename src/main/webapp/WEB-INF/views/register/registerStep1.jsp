<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<spring:message code="register.term" />
			</h4>
			
			<form class="form-signin" method="post"
				action="${pageContext.request.contextPath}/register/step2"
				onsubmit="return clickEvent()">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<div class="input-group-text">
							
							<!--  RegisterController registerStep2 메소드 @RequestParam(value = "agree", required = true) 일 때 에러발생 -->
							<input type="checkbox" name="agree"
								aria-label="Checkbox for following text input">
								
						</div>
					</div>
					<div class="input-group-prepend">
						<div class="input-group-text">
							<spring:message code="register.term.agree" />
						</div>
					</div>

				</div>
				<hr class="mb-4">
				<button id="btn_register" class="btn btn-primary btn-lg btn-block"
					type="submit">
					<spring:message code="register.next.btn" />
				</button>
			</form>
			 
			 
			 <!--  
			 <form:form cssClass="form-signin" method="post"
				action="${pageContext.request.contextPath}/register/step2"
				onsubmit="return clickEvent()" modelAttribute="checkbox">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<div class="input-group-text">
						
							<form:checkbox path="agree"/>
								
						</div>
					</div>
					<div class="input-group-prepend">
						<div class="input-group-text">
							<spring:message code="register.term.agree" />
						</div>
					</div>

				</div>
				<hr class="mb-4">
				<button id="btn_register" class="btn btn-primary btn-lg btn-block"
					type="submit">
					<spring:message code="register.next.btn" />
				</button>
			</form:form>
		-->
		</div>

	</div>
</html>