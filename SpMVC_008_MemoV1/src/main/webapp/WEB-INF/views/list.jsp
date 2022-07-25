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
<title>홈화면</title>
<style>
* {
	margin: o;
	padding: 0;
}

body {
	width: 95vw;
	height: 95vh;
	text-align: center;
}

section {
	width: 90%;
	height: 95%;
	display: flex;
	flex-wrap: wrap;
	margin: 20px auto;
	overflow-y: scroll;
	overflow-x: hidden;
}

::-webkit-scrollbar {
	display: none;
}

table {
	border: 1px solid black;
	width: 300px;
	height: 350px;
	padding: 10px;
	margin: 10px;
}

img {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.img-td {
	height: 170px;
	margin-bottom: 10px;
}

.insert {
	font-size: 15px;
	background-color: purple;
	color: white;
	text-decoration: none;
	cursor: poiner;
	padding: 20px 50px;
	border: 1px solid black;
}

.detail {
	text-decoration : none;
	cursor: poiner;
	border: 1px solid black;
	color: inherit;
	text-decoration: none;
}
</style>
</head>
<body>
	<section>
		<c:forEach items="${MEMOS}" var="MEMOS">
			<table>
				<tr>
					<td>일련번호 : ${MEMOS.m_seq}</td>
				</tr>
				<tr>
					<td>작성자 : ${MEMOS.m_author}</td>
				</tr>
				<tr>
					<td>${MEMOS.m_date}/ ${MEMOS.m_time}</td>
				</tr>
				<tr>
					<td>메모내용 : ${MEMOS.m_memo}</td>
				</tr>
				<tr>
					<td class="img-td"><img
						src="${rootPath}/upload/${MEMOS.m_image}"></td>
				</tr>
				<tr>
					<td><a class="detail" href="${rootPath}/detail/${MEMOS.m_seq}">자세히보기</a></td>
				</tr>
			</table>
		</c:forEach>
	</section>
	<a class="insert" href="${rootPath}/insert">추가하기</a>
</body>
</html>