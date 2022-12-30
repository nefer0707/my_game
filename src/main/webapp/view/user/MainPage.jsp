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
		<div class="row border  bg-success p-2 text-striped bg-opacity-10">
			<div class="col-5 border offset-md-2">
				<div class="row">
					<table class="table table table-success table-striped">
						<tr>
							<td>角色名稱：
							<td>${mychar.char_name}
						<tr>
							<td>職業名稱：
							<td>${myjob.job_name}
						<tr>
							<td>等級：
							<td>${mychar_q.lv}
						<tr>
							<td>職業等級：
							<td>${mychar_q.job_lv}
						<tr>
							<td>HP：
							<td>${mychar_q.hp}/${mychar_q.max_hp}
						<tr>
							<td>MP：
							<td>${mychar_q.mp}/${mychar_q.max_mp}
						<tr>
							<td>經驗值：
							<td>${mychar_q.exp}
						<tr>
							<td>職業經驗值：
							<td>${mychar_q.job_exp}
						<tr>
							<td>持有金錢：
							<td>${mychar.money}
					</table>
				</div>
				<div class="row">
					<table class="table table table-success table-striped">
						<tr>
							<td>能力
							<td>數值
						<tr>
							<td>力量：
							<td>${mychar_q.str}
						<tr>
							<td>智力:
							<td>${mychar_q.inte}
						<tr>
							<td>靈巧：
							<td>${mychar_q.dex}
						<tr>
							<td>敏捷：
							<td>${mychar_q.agi}
						<tr>
							<td>幸運：
							<td>${mychar_q.luk}
						<tr>
							<td>體力：
							<td>${mychar_q.vit}
						<tr>
							<td>剩餘數值點：
							<td>${mychar_q.points}
					</table>
				</div>


			</div>
			<div class="col-3 offset-md-1 mt-5 me-5">
				<div class="row border border-5 mx-auto">
					<img src="${mychar.img}">
				</div>
				<div class="row mt-5 mx-auto">
					<ul class="list-inline">
						<li>選單
						<li><form method="post" action="/MyGame/Battle">
								<select name="battlemap_name">
									<option>選擇戰鬥地圖</option>
									<option>新手村</option>
									<option>中階地圖</option>
									<option>高階地圖</option>
								</select> <input type="submit" value="戰鬥"
									class="btn btn-outline-secondary">
							</form>
						<li class="mt-3"><form method="post"
								action="/MyGame/MySkillAndJob">
								<input type="submit" value="職業與技能"
									class="btn btn-outline-secondary">
							</form>
						<li class="mt-2"><form method="post"
								action="/MyGame/Myquality">
								<input type="submit" value="詳細素質"
									class="btn btn-outline-secondary">
							</form>
						<li class="mt-2"><form method="post" action="/MyGame/Bag">
								<input type="submit" value="背包"
									class="btn btn-outline-secondary">
							</form>
						<li class="mt-2"><form method="post" action="/MyGame/Rest">
								<input type="submit" value="休息"
									class="btn btn-outline-secondary">
							</form>
						<li class="mt-2"><form method="post" action="/MyGame/Logout">
								<input type="submit" value="登出"
									class="btn btn-outline-secondary">
							</form>
					</ul>
				</div>
			</div>


		</div>
	</div>
</body>
</html>