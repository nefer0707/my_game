<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>
</head>
<body>
	<div align="center">
		<form method="post" action="/MyGame/Login">
			帳號：<input type="text" name="account" onfocus="LoginMsg()"><span
				id="login_span">${requestScope.text}</span>
			<p>
				密碼：<input type="text" name="password">
				<p>
				<input type="submit" value="登入"> <a
					href="/MyGame/view/acc/Register.jsp"><input type="button" value="註冊會員"></a>
		
		</form>
		</div>
		<script type="text/javascript">
			function LoginMsg() {
				var spanELe = document.getElementById("login_span");
				spanEle.innerHTML = "";
			}
		</script>
</body>
</html>