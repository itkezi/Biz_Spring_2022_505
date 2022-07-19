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
<link rel="stylesheet" href="${rootPath}/static/css/hjcss.css">
<title>상세페이지</title>
</head>
<body>
<div class="box  w3-card-4">
<h1 class="w3-text-flat-midnight-blue w3-center">${ADDR.a_name}</h1>
<table class="w3-table w3-bordered w3-centered ">
	<tr>
		<th>SEQ</th>
		<td>${ADDR.a_seq}</td>
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
	<div class="w3-center">
		<a href="${rootPath}/update?seq=${ADDR.a_seq}" class="de-a w3-button hj-c-main">수정하기</a>
		<a href="${rootPath}/delete?seq=${ADDR.a_seq}"class="de-a w3-button hj-c-main">삭제하기</a>
		<a href="${rootPath}/" class="de-a w3-button w3-blue-grey">HOME</a>
	</div>

</div>

</body>
</html>