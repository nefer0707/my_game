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
<title>選擇角色</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:forEach items="${mychars}" var="mychar">
				<div class="col">
					角色名稱：
					<p>${mychar.char_name}
					<p>角色頭像：
					<p>
						<img src="${mychar.img}" width="200" height="200">
					<p>角色金錢：
					<p>${mychar.money}
					<p>
					<form method="post" action="/MyGame/ChooseChar">
						<input type="text" name="char_id" value="${mychar.char_id}"
							style="display: none"> <input
							class="btn btn-outline-secondary" type="submit" value="選擇此角色">
					</form>
					<input type="button" value="刪除角色" class="btn btn-outline-secondary"
						onclick="DeleteChar(${mychar.char_id})">
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<div class="col">
				<a href="/MyGame/view/acc/InsertChar.jsp"><input
					class="btn btn-outline-secondary" type="button" value="創建角色"
					onfocus="InsertMsg()"></a><span id="Insert_text">${requestScope.text}</span>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function DeleteChar(param) {
			if (confirm("是否確定刪除？") == true) {
				document.location = "http://localhost:8080/MyGame/DeleteChar?char_id="
						+ param;
			} else {
				return false;
			}
		}

		function InsertMsg() {
			var spanELe = document.getElementById("Insert_text");
			spanEle.innerHTML = "";
		}
	
</script>
	</ body>
</html>