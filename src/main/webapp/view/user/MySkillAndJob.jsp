<%@page import="model.bean.chars.CharsBean,java.util.List"%>
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
<title>主頁面</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col mt-2">
				<div class="row">
					<div>
						<img src="${mychar.img}" width="300">
					</div>
				</div>
				<div class="row ">
					<table class="table border-1">
						<tr>
							<td>基本數值/職業
							<td>
						<tr>
							<td>角色名稱：
							<td>${mychar.char_name}
						<tr>
							<td>當前職業：
							<td>${myjob.job_name}
						<tr>
							<td>等級：
							<td>${mychar_q.lv}
						<tr>
							<td>職業等級：
							<td>${mychar_q.job_lv}
					</table>
				</div>
			</div>
			<div class="col">
				<div class="row">轉職列表</div>
				<table class="table border-1">
					<tr>
						<th>職業名稱
						<th>職業階級
						<th>職業類型
						<th><c:forEach items="${jobs}" var="job">
								<tr>
									<td>${job.job_name}
									<td>${job.job_lavel}
									<td>${job.job_type_name}
									<td>
										<form method="post" action="ChangeJob">
											<input type="text" name="job_id" value="${job.job_id}"
												style="display: none;"> <input
												class="btn btn-outline-secondary" type="submit" value="轉職">
										</form>
							</c:forEach>
					<tr>
						<td colspan="3">${job_msg}

				</table>
				<div class="row">當前職業可學習技能</div>
				<table class="table border-1">
					<tr>
						<th>技能名稱
						<th>需要等級
						<th>威力
						<th>說明
						<th><c:forEach items="${skills}" var="skill">
								<tr>
									<td>${skill.skill_name}
									<td>${skill.need_job_lv}
									<td>${skill.power}
									<td>${skill.caption}
									<td>
										<form method="post" action="Study">
											<input type="text" name="skill_id" value="${skill.skill_id}"
												style="display: none;"> <input
												class="btn btn-outline-secondary" type="submit" value="學習">
										</form>
							</c:forEach>
					<tr>
						<td colspan="4">${msg}
		
				</table>
				<div class="row">
					<form method="post" action="/MyGame/Backhome">
						<input class="btn btn-outline-secondary" type="submit"
							value="回主畫面">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>