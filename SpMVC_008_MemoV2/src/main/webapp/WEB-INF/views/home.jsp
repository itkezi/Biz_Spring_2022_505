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
<link rel="stylesheet" href="${rootPath}/static/main.css">
</head>
<body class="home-body">
	<div class="home-box">
		<c:if test="${not empty USERNAME}">
			<h2>${USERNAME}'sMEMO</h2>
			<div class="table">
				<table class="memo">
					<tr>
						<th class="t-seq">SEQ</th>
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
							<td>${MEMO.m_date}/ ${MEMO.m_time}</td>
							<td>${MEMO.m_memo}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<div class="a-box">
			<c:if test="${empty USERNAME}">
				<h2>KEZI_MEMO_V1</h2>
				<a class="home-login" href="${rootPath}/user/login">LOGIN</a>
			</c:if>
			<c:if test="${not empty USERNAME}">
				<a href="${rootPath}/memo/insert">INSERT</a>
				<a href="${rootPath}/user/logout">LOGOUT</a>
			</c:if>
		</div>
	</div>
</body>
</html>