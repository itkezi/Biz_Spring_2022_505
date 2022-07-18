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
<link rel="stylesheet" href="${rootPath}/static/css/w3css.css">
<style>
.w3-container {
	width: 60%;
	margin: 30px auto !important;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<form method="POST" class="w3-container w3-card-2">
		<h2 class="w3-center w3-text-indigo w3-section">새로운 정보</h2>
		<input type="hidden" value='<c:out value= "${ADDR.a_seq}" default="0"/>'/>
		<input name="a_name" class="w3-input  w3-border w3-section" placeholder="이름" value="${ADDR.a_name}"> 
		<input name="a_tel" class="w3-input w3-border w3-section" placeholder="전화번호" value="${ADDR.a_tel}"> 
		<input name="a_address" class="w3-input w3-border w3-section" placeholder="주소"  value="${ADDR.a_address}">
		<button class="w3-button w3-block w3-section w3-indigo w3-ripple w3-padding">저장하기</button>
	</form>

	<table class="w3-container w3-table w3-bordered  w3-centered w3-card-2">
		<thead>
			<tr class="">
				<th>SEQ</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>상세</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ADDR}" var="addr">
				<tr>
					<td>${addr.a_seq}</td>
					<td>${addr.a_name}</td>
					<td>${addr.a_tel}</td>
					<td>${addr.a_address}</td>
					<td><a class="w3-button w3-indigo" href="${rootPath}/detail?seq=${addr.a_seq}">+</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>