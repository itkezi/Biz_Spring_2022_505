<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>220425</title>

<style>
section {
	flex-direction: column;
}

#a {
margin : 40px 0 40px 0;
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
</head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp"%>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
		<section>
	<h1 id="a">학생정보 자세히보기</h1>
	<table>
		<tr>
			<th>학번</th>
			<td>${ST.stNum}</td>
			<th>이름</th>
			<td>${ST.stName}</td>
		</tr>
		<tr>
			<th>학과</th>
			<td>${ST.stDept}</td>
			<th>학년</th>
			<td>${ST.intGrade}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${ST.stTel}</td>
			<th>주소</th>
			<td>${ST.stAddr}</td>
		</tr>

	</table>
			<div class="botton-box">
			<a href="#">학생정보 수정</a>
		</div>
		</section>
		<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>

</body>
</html>