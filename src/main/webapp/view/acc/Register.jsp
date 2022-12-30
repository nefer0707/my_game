<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<meta charset="UTF">
<title>註冊</title>
</head>
<body>
	<div class="container">
		<div class="row align-items-center vh-100 w-25 mx-auto ">
			<div class='col'>
				<form method="post" action="/MyGame/Register">
					<table>
					<tr><th>會員註冊
						<tr>
							<td>帳號：
							<td><input type="text" name="account">
						<tr>
							<td>密碼：
							<td><input type="password" name="password">
						<tr>
							<td>
							<td>${requestScope.text}
						<tr>
							<td><a href="/MyGame/view/acc/Login.jsp"><input
									class="btn btn-outline-secondary" type="button" value="回登入畫面"></a>
							<td><input class="btn btn-outline-secondary" type="submit" value="註冊">
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>