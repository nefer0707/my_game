<%@page import="model.bean.chars.CharsBean,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主頁面</title>
</head>
<body>
	<div>
		<div style="width: 300px; border: 2px solid">
			<div>
				頭像<p>
				<img src="${mychar.img}"  width="200" height="200">
				<p>
			</div>
			<div>
				選單
				<p>
				<ul>
					<li><form method="post" action="/MyGame/Battle">
							<select name="battleMap">
								<option>選擇戰鬥地圖</option>
								<option>新手村</option>
								<option>中階地圖</option>
								<option>高階地圖</option>
							</select> <input type="submit" value="戰鬥">
						</form>
					<li><a href=""><input type="button" value="職業與技能"></a>
					<li><a href=""><input type="button" value="詳細素質"></a>
					<li><form method="post" action="/MyGame/Bag"><input type="submit" value="背包"></form>
					<li><form method="post" action="/MyGame/Rest"><input type="submit" value="休息"></form>
				</ul>
			</div>
		</div>
		<div style="width: 300px; border: 2px solid">
			數值
			<p>角色名稱：${mychar.char_Name}
			<p>職業名稱：${mychar.job_ID}
			<p>等級：${mychar_q.lv}
			<p>職業等級：${mychar_q.jobLv}
			<p>HP：${mychar_q.hp}/${mychar_q.maxHp}
			<p>MP：${mychar_q.mp}/${mychar_q.maxMp}
			<p>經驗值：${mychar_q.exp}
			<p>職業經驗值：${mychar_q.jobExp}
			<p>持有金錢：${mychar.money}
			<p>
		</div>
		<div style="width: 300px; border: 2px solid">
			能力
			<p>力量：${mychar_q.str}
			<p>智力:${mychar_q.inte}
			<p>靈巧：${mychar_q.dex}
			<p>敏捷：${mychar_q.agi}
			<p>幸運：${mychar_q.luk}
			<p>體力：${mychar_q.vit}
			<p>剩餘素質點：${mychar_q.points}
			<p>
		</div>
	</div>
</body>
</html>