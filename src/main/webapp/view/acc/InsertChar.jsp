<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>創建角色</title>
</head>
<body>
<div>
<form method="post" action="/MyGame/InsertChar">
	角色名稱：<input type="text" name="char_name"><p>
	角色圖像：<input type="file" name="img"><p>
	<input type="submit" value="創建角色">
</form>
</div>
</body>
</html>