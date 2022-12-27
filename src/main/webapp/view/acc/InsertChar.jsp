<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<meta charset="UTF-8">
<title>創建角色</title>
</head>
<body>
	<div class='container'>
		<div class='row align-items-center vh-100 w-25 mx-auto '>
			<div class='col'>
				<form method="POST" action="/MyGame/InsertChar"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>角色名稱：
							<td><input type="text" name="char_name">
						<tr>
							<td>角色圖像：
							<td><input type="file" name="img">
						<tr>
							<td>
							<td><input class="btn btn-outline-secondary" type="submit" value="創建角色">
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>