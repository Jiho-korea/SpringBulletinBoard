<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>회원가입 페이지</title>
</head>
<body class="text-center">
	<div class="container" id="main">
		<div class="jumbotron">
			<h4 class="mb-4">약관</h4>
			<form class="form-signin" method="post"
				action="${pageContext.request.contextPath}/register/step2"
				onsubmit="return clickEvent()">
				<div class="input-group mb-3" >
					<div class="input-group-prepend">
						<div class="input-group-text">
							<input type="checkbox" name="agree"
								aria-label="Checkbox for following text input">
						</div>
					</div>
					<div class="input-group-prepend">
						<div class="input-group-text">
						약관동의
						</div>
					</div>
					
				</div>
				<hr class="mb-4">
				<button id="btn_register" class="btn btn-primary btn-lg btn-block"
					type="submit">다음단계</button>
			</form>
		</div>

	</div>
	</script>
</html>