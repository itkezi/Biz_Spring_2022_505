<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home.jsp</title>
<link rel="icon" href="${rootPath}/static/Images/favicon.ico"
	type="image/x-icon" />

<style>
table {
	width: 60%;
	border : solid 1px green;
	border-collapse: collapse;
	text-align: center;
	margin : 10px auto;
}

.lime {
background-color: lime;
}

.blue {
	background-color: skyblue;
}

table td, table th {
	border : solid 1px green;
}
.b {
text-align: center;
margin : 50px;
}
.b a {
border: 1px solid red;
cursor: pointer;
padding : 10px;
}


</style>
</head>
<body>
	<div class="b">
	<a>라임팀 보기</a>
	<a>파란팀 보기</a>
	</div>
	<c:choose>
	<c:when test="${name eq 'lime'}">
	<table class="lime">
		<tr>
			<th>일시</th>
			<th>시간</th>
			<th>상대팀</th>
		</tr>
		<tr>
			<td>6월2일</td>
			<td>18:00</td>
			<td>수원FC</td>
		</tr>
		<tr>
			<td>6월2일</td>
			<td>18:00</td>
			<td>수원FC</td>
		</tr>
		<tr>
			<td>6월2일</td>
			<td>18:00</td>
			<td>수원FC</td>
		</tr>
	</table>
	</c:when>
	<c:when test="${name eq 'blue'}">
		<h1>${USER.name}님</h1>
	<table class="blue">
		<tr>
			<th>일시</th>
			<th>시간</th>
			<th>상대팀</th>
		</tr>
		<tr>
			<td>6월2일</td>
			<td>18:00</td>
			<td>수원FC</td>
		</tr>
		<tr>
			<td>6월2일</td>
			<td>18:00</td>
			<td>수원FC</td>
		</tr>
		<tr>
			<td>6월2일</td>
			<td>18:00</td>
			<td>수원FC</td>
		</tr>
	</table>
	</c:when>
	</c:choose>
</body>
</html>