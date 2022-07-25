<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />


<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<meta charset="UTF-8">
<style>
section {
	flex-direction: column;
}
table {
	width: 80%;
	margin: 0 auto;
	border-collapse: collapse;
}

th {
background-color: #eee;

}

th, td {
	border: 1px solid #ccc;
	padding: 5px;
	cursor: pointer;
}

div.botton-box {
	width: 80%;
	margin: 5px auto;
	text-align: right;
	padding: 5px 0;
}

div.botton-box a {
	display: inline-block;
	padding: 12px 16px;
	text-decoration: none;
	color: white;
	background-color: blue;
	border-radius: 5px;
}

div.botton-box a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.6)
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp"%>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<section>

		<table>
			<tr>
				<th>학번</th>
				<td>20210001</td>
				<th>전공</th>
				<td>컴퓨터공학</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>홍길동</td>
				<th>학년</th>
				<td>1</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan='3'>서울특별시</td>
			</tr>

		</table>
		
		<div class="botton-box">
			<a href="#">학생정보 수정</a>
		</div>

	</section>

	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>

</body>
</html>