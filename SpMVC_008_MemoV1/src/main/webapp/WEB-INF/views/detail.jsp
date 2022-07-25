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
margin : o;
padding:0;
}
body {
	width: 95vw;
	height: 95vh;
	text-align: center;
}

section {
	width: 80%;
	height: 80%;
	display: flex;
	flex-wrap: wrap;
	margin : 20px auto;
}

ul {

border: 1px solid black;
width: 300px;
}

li {
list-style: none;
}

img {
width: 80%;
}

a {
font-size:15px;
	background-color: purple;
	color: white;
	text-decoration:none;
	cursor: poiner;
	padding: 20px 50px;
	border: 1px solid black;
}
</style>
</head>
<body>
	<section>
			<table>
				<tr>
					<td>일련번호 : ${MEMO.m_seq}</td>
				</tr>
				<tr>
					<td>작성자 : ${MEMO.m_author}</td>
				</tr>
				<tr>
					<td>${MEMO.m_date}/ ${MEMO.m_time}</td>
				</tr>
				<tr>
					<td>메모내용 : ${MEMO.m_memo}</td>
				</tr>
				<tr>
					<td class="img-td"><img
						src="${rootPath}/upload/${MEMO.m_image}"></td>
				</tr>
			</table>
	</section>
		<a href="${rootPath}/delete/${MEMO.m_seq}"> 삭제</a>
		<a href="${rootPath}/update/${MEMO.m_seq}"> 수정</a>
		<a href="${rootPath}/"> 홈으로</a>
</body>
</html>