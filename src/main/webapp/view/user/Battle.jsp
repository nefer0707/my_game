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
<title>戰鬥頁面</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				怪物
				<table>
					<tr>
						<td>怪物名稱
						<td>${battle_monster.monster_name}
					<tr>
						<td>怪物等級
						<td>${battle_monster.lv}
					<tr>
						<td>HP
						<td>${battle_monster.hp}/${battle_monster.max_hp}
					<tr>
						<td>MP
						<td>${battle_monster.mp}/${battle_monster.max_mp}
				</table>
			</div>
			<div class="col">
				角色
				<table>
					<tr>
						<td>角色名稱
						<td>${mychar.char_name}
					<tr>
						<td>角色等級
						<td>${mychar_q.lv}
					<tr>
						<td>角色職業
						<td>${myjob.job_name}
					<tr>
						<td>HP
						<td>${mychar_q.hp}/${mychar_q.max_hp}
					<tr>
						<td>MP
						<td>${mychar_q.mp}/${mychar_q.max_mp}
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
				戰鬥方針 ${msg}
				<form method="post" action="/MyGame/Att">
					<table>
						<tr>
							<td><input class="att btn btn-outline-secondary"
								type="submit" value="攻擊">
						<tr>
							<td><input class="myskill btn btn-outline-secondary"
								type="button" value="技能">
					</table>
				</form>
				<form method="post" action="/MyGame/Backhome">
					<table>
						<tr>
							<td><input class="mybag btn btn-outline-secondary"
								type="button" value="背包">
						<tr>
							<td><input class="quit btn btn-outline-secondary"
								type="submit" value="逃跑">
					</table>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="showskill">
					<tr>
						<th>技能名稱
						<th>威力
						<th>消耗mp
						<td><c:forEach items="${myskill}" var="skill">
								<tr>
									<td>${skill.skill_name}
									<td>${skill.power}
									<td>${skill.mp}
									<td><form method="post" action="MySkill_Battle">
											<input type="text" name="skill_id" value="${skill.skill_id}"
												style="display: none;"> <input
												class="btn btn-outline-secondary" type="submit" value="使用">
										</form>
							</c:forEach>
				</table>

			</div>
			<div class="col">

				<table class="showbag">
					<tr>
						<th>物品名稱
						<th>類型
						<th>說明
						<td><c:forEach items="${myitems}" var="item">
								<tr>
									<td>${item.item_name}
									<td>${item.item_type_name}
									<td>${item.caption}
									<td><form method="post" action="MyBag_Battle">
											<input type="text" name="item_id" value="${item.item_id}"
												style="display: none;"> <input
												class="btn btn-outline-secondary" type="submit" value="使用">
										</form>
							</c:forEach>
				</table>

			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="/MyGame/view/js/jquery-3.6.1.min.js"></script>
	<script type="text/javascript">
		$(".showskill").hide();
		$(".showbag").hide();
		$(".myskill").click(function() {
			$(".showskill").show();
		});
		$(".mybag").click(function() {
			$(".showbag").show();
		});
	</script>
</body>
</html>