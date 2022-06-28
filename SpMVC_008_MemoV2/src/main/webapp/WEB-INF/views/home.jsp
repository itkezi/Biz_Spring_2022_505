<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/memo.js?ver=220627004"></script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	text-align: center;
}

table {
	margin: 15px auto;
	width: 80%;
	border: 1px solid black;
	width: 80%;
}

table th, table td {
	border: 1px solid black;
	padding: 5px;
}

table td {
	cursor: pointer;
}

.t-seq {
	width: 30px;
}

.t-time, .t-date {
	width: 100px;
}

/* table td:hover{ */
/* background-color: blue; */
/* color: white; */
/* } */
a {
	text-decoration: none;
	color: inherit;
	border: 1px solid black;
	padding: 5px;
}

a:hover {
	background-color: blue;
	color: white;
}
</style>
</head>
<body>
	<h1>MEMO</h1>
	<c:if test="${not empty USERNAME}">
		<h2>${USERNAME}님의메모목록</h2>
		<table class="memo">
			<tr>
				<th class="t-seq">SEQ</th>
				<th class="t-date">작성일자</th>
				<th class="t-time">작성시간</th>
				<th class="t-memo">내용</th>
			</tr>
			<c:if test="${empty MEMOS}">
				<tr>
					<td colspan="4">메모가 없습니다</td>
				</tr>
			</c:if>
			<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
				<tr data-seq="${MEMO.m_seq}">
					<td>${INDEX.count}</td>
					<td>${MEMO.m_date}</td>
					<td>${MEMO.m_time}</td>
					<td>${MEMO.m_memo}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div class="a-box">
		<c:if test="${empty USERNAME}">
			<a href="${rootPath}/user/login">로그인하기</a>
		</c:if>
		<c:if test="${not empty USERNAME}">
			<a href="${rootPath}/memo/insert">메모작성하기</a>
			<a href="${rootPath}/user/logout">로그아웃하기</a>
		</c:if>
	</div>
</body>
</html>