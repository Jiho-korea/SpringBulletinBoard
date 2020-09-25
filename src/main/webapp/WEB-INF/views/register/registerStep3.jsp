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
<script defer src="https://code.jquery.com/jquery-3.1.1.min.js" charset="utf-8"></script>
<script defer
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
<title>회원가입 페이지</title>
</head>
<body class="text-center">
	<div class="container" id="main">
		<div class="jumbotron">
			<h4 class="mb-4">약관</h4>
			<form class="form-signin" method="post"
				action="${pageContext.request.contextPath}/register/step2"
				onsubmit="return clickEvent()">
				<input type="text" class="form-control" name="name" placeholder="이름"
					id="name" /> <br class="mb-4"> <input type="number"
					class="form-control" name="sid" placeholder="학번" id="sid" />

				<br class="mb-4">

				<div class="row">
					<div class="col-md-6 mb-3">

						<input type="password" class="form-control" name="password"
							id="userPassword" placeholder="비밀번호" />
					</div>
					<div class="col-md-6 mb-3">
						<input type="password" class="form-control" id="checkPassword"
							placeholder="비밀번호 확인" />

					</div>
				</div>

				<br class="mb-1"> <input type="number" class="form-control"
					name="grade" id="grade" placeholder="학년" /> <br
					class="mb-4"> <input type="text" class="form-control"
					name="subject" id="subject" placeholder="학과" /> <br
					class="mb-4">

				<hr class="mb-4">
				<button id="btn_register" class="btn btn-primary btn-lg btn-block"
					type="submit">회원가입</button>
			</form>
		</div>

	</div>

</html>