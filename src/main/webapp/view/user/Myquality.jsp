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
<title>角色詳細素質</title>
</head>
<body>
	<div class="container mt-5">
		<form method="post" action="/MyGame/Backhome">
			<input class="btn btn-outline-secondary" type="submit" value="回主畫面">
		</form>
		<div class="row">
			<div class="col">
				<div class="row">
					<div>
						<img src="${mychar.img}">
					</div>
				</div>
				<div class="row">
					<table class="table border-1">
						<tr>
							<td>職業信息
							<td>
						<tr>
							<td>職業名稱:
							<td>${myjob.job_name}
						<tr>
							<td>職業類型:
							<td>${myjob.job_type_name}
						<tr>
							<td>職業層級:
							<td>${myjob.job_lavel}
					</table>
				</div>
				<div class="row">
					<table class="table border-1">
						<tr>
							<td>裝備
							<td>
						<tr>
							<th>裝備名稱
							<th>裝備類型 <c:forEach items="${myequipments}"
									var="myequipment">
									<tr>
										<td>${myequipment.item_name}
										<td>${myequipment.item_type_name}
								</c:forEach>
					</table>
				</div>
			</div>

			<div class="col">
				<form method="post" action="/MyGame/AddPoints">
					<table class="table border-1" id="q">
						<tr>
							<td>詳細能力
							<td>
							<td>
						<tr>
							<td>角色名稱：
							<td>${mychar.char_name}
							<td>
						<tr>
							<td>等級：
							<td>${mychar_q.lv}
							<td>
						<tr>
							<td>職業等級：
							<td>${mychar_q.job_lv}
						<tr>
							<td>經驗值：
							<td>${mychar_q.exp}
						<tr>
							<td>職業經驗值：
							<td>${mychar_q.job_exp}
						<tr>
							<td>HP：
							<td>${mychar_q.hp}/${mychar_q.max_hp}
						<tr>
							<td>MP：
							<td>${mychar_q.mp}/${mychar_q.max_mp}
						<tr>
							<td>力量：
							<td>${mychar_q.str}<input type="text" value="0"
								name="add_str" size=1>
						<tr>
							<td>智力：
							<td>${mychar_q.inte}<input type="text" value="0"
								name="add_inte" size=1>
						<tr>
							<td>敏捷：
							<td>${mychar_q.agi}<input type="text" value="0"
								name="add_agi" size=1>
						<tr>
							<td>靈巧：
							<td>${mychar_q.dex}<input type="text" value="0"
								name="add_dex" size=1>
						<tr>
							<td>幸運：
							<td>${mychar_q.luk}<input type="text" value="0"
								name="add_luk" size=1>
						<tr>
							<td>體力:
							<td>${mychar_q.vit}<input type="text" value="0"
								name="add_vit" size=1>
						<tr>
							<td>剩餘數值點：
							<td>${mychar_q.points}<input type="text"
								value="${mychar_q.points}" name="points" size=1>
						<tr>
							<td>金錢：
							<td>${mychar.money}
						<tr>
							<td>${requestScope.text}
							<td><input class="btn btn-outline-secondary" type="submit" value="確定">
					</table>
				</form>
			</div>
			<div class="col">
				<table class="table border-1">
					<tr>
						<td>持有技能信息
						<tr><th>技能名稱
					<c:forEach items="${myskill}" var="skill">
					<tr>
						<td>${skill.skill_name}
						</c:forEach>
	
				</table>
			</div>
		</div>
	</div>
</body>
</html>