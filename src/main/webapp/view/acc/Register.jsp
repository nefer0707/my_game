<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF">
<title>Insert title here</title>
</head>
<body>
<div>
	<form method="post" action="/MyGame/Register">
		帳號：<input type="text" name="account"><p>
		密碼：<input type="password" name="password"><p>
		<input type="submit" value="註冊">
		<a href="/MyGame/view/acc/Login.jsp"><input type="button" value="回登入畫面"></a>
	</form>
</div>
</body>
</html>