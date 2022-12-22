<%@page import="model.bean.chars.CharsBean,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>
</head>
<body>
	<div align="center">
		<c:forEach items="${mychars}" var="mychar">
			<div style="width: 300px; border: 2px solid">
				角色名稱：
				<p>${mychar.char_name}
				<p>角色頭像：
				<p><img src="${mychar.img}" width="200" height="200">
				<p>角色金錢：
				<p>${mychar.money}
				<p>
				<form method="post" action="/MyGame/ChooseChar">
					<input type="text" name="char_id" value="${mychar.char_id}"
						style="display: none"> <input type="submit" value="選擇此角色">
				</form>
				<input type="button" value="刪除角色"
					onclick="DeleteChar(${mychar.char_id})">
			</div>
		</c:forEach>
		<a href="/MyGame/view/acc/InsertChar.jsp"><input type="button" value="創建角色"
			onfocus="InsertMsg()"></a><span id="Insert_text">${requestScope.text}</span>
	</div>
	<script type="text/javascript">
	function DeleteChar(param) {
		if(confirm("是否確定刪除？")==true){
	    	document.location="http://localhost:8080/MyGame/DeleteChar?char_id="+param;
	    }else{
	    	return false;
	    }
	}
	
	function InsertMsg() {
		var spanELe = document.getElementById("Insert_text");
		spanEle.innerHTML = "";
	}
	</script>
</body>
</html>