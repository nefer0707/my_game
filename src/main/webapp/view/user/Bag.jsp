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
<title>角色背包</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="row">
					<table class="table border-1">
						<tr>
							<td>HP
							<td>${mychar_q.hp}/${mychar_q.max_hp}
						<tr>
							<td>MP
							<td>${mychar_q.mp}/${mychar_q.max_mp}
						<tr>
							<td>Lv
							<td>${mychar_q.lv}
						<tr>
							<td>JobLv
							<td>${mychar_q.job_lv}
						<tr>
							<td>Exp
							<td>${mychar_q.exp}
						<tr>
							<td>JobExp
							<td>${mychar_q.job_exp}
						<tr>
							<td>力量
							<td>${mychar_q.str}
						<tr>
							<td>智力
							<td>${mychar_q.inte}
						<tr>
							<td>敏捷
							<td>${mychar_q.agi}
						<tr>
							<td>靈巧
							<td>${mychar_q.dex}
						<tr>
							<td>幸運
							<td>${mychar_q.luk}
						<tr>
							<td>體力
							<td>${mychar_q.vit}
						<tr>
							<td>剩餘素質點
							<td>${mychar_q.points}
					</table>
				</div>
			</div>
			<div class="col">
				<div class="row">
					<table class="table border-1">
						<th>裝備名稱
						<th>類型
						<th><c:forEach items="${myequipments}" var="equipment">
								<tr>
									<td>${equipment.item_name}
									<td>${equipment.item_type_name}
									<td>
										<form method="post" action="/MyGame/Take_off">
											<input type="text" name="item_id" style="display: none"
												value="${equipment.item_id}"> <input class="btn btn-outline-secondary" type="submit"
												value="脫下">
										</form>
							</c:forEach>
					</table>

				</div>
				<div class="row">
					<table class="table border-1">
						<th>物品名稱
						<th>類型
						<th>說明
						<th>數量
						<th><c:forEach items="${myitems}" var="item">
								<tr>
									<td>${item.item_name}
									<td>${item.item_type_name}
									<td>${item.caption}
									<td>${item.count}
									<td>
										<form method="post" action="/MyGame/Useitem">
											<input type="text" name="item_id" style="display: none"
												value="${item.item_id}"> <input class="btn btn-outline-secondary" type="submit"
												value="使用/裝備">
										</form>
							</c:forEach>
					</table>
				</div>
				<div class="row-1">
					<form method="post" action="/MyGame/Backhome">
						<input class="btn btn-outline-secondary" type="submit" value="回主頁面">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>