<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${rootPath}/static/css/w3css.css">
<style>
.w3-container {
	width: 60%;
	margin: 30px auto !important;
	padding : 30px;
}
</style>
<title>상세페이지</title>
</head>
<body>
<div class="w3-container  w3-card-2">
<h1 class="w3-center">상세화면</h1>
<table class="w3-table w3-striped w3-border w3-centered ">
	<tr>
		<th>SEQ</th>
		<td>${ADDR.a_seq}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${ADDR.a_name}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${ADDR.a_tel}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${ADDR.a_address}</td>
	</tr>
</table>
	<a href="${rootPath}/update?seq=${ADDR.a_seq}">수정하기</a>
	<a href="${rootPath}/delete?seq=${ADDR.a_seq}">삭제하기</a>
	<a href="${rootPath}/">HOME</a>

</div>

</body>
</html>