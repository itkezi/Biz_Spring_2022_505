<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="logo_event.js"></script>
<title>Season + ing</title>
<link rel="stylesheet" href= "${rootPath}/static/css/main.css"/>
<link rel="stylesheet" href="${rootPath}/static/css/ball.css" />
<link rel="stylesheet" href="${rootPath}/static/css//logo.css" />
<style>
</style>
</head>
<body>
	<div class="main"></div>

	<div class="main_button">
		<img class="logo_img" src="${rootPath}/static/images/로고1.png" />

		<button class="football" onclick="location.href = '${rootPath}/football/football-seoul'">
			<img class="button_img" src="${rootPath}/static/images/football_text.png" /><br />
			<p class="m_b_text">K-리그</p>
			<p class="button_text">
				정보보러가기 <b id="button_text_arrow"> &#10095;</b>
			</p>
		</button>
		<img class="football_img" src="${rootPath}/static/images/football.png" />

		<button class="baseball" onclick="">
			<img class="button_img" src="${rootPath}/static/images/baseball_text.png" /><br />
			<p class="m_b_text">KBO-리그</p>
			<p class="button_text">
				정보보러가기 <b id="button_text_arrow"> &#10095;</b>
			</p>
		</button>
		<img class="baseball_img" src="${rootPath}/static/images/baseball.png" />

		<button class="volleyball"onclick="">
			<img class="button_img" src="${rootPath}/static/images/volleyball_text.png" /><br />
			<p class="m_b_text">V-리그</p>
			<p class="button_text">
				정보보러가기 <b class="button_text_arrow"> &#10095;</b>
			</p>
		</button>
		<img class="volleyball_img" src="${rootPath}/static/images/volleyball.png" />
	</div>

	<footer>footer 부분입니다.</footer>

</body>
</html>