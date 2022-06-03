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

<title>나의 API App</title>

<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=2022-06-02-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/home.css?ver=2022-06-02-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/table.css?ver=2022-05-31-001">
	
	
<link rel="stylesheet"
	href="${rootPath}/static/css/modal.css?ver=2022-05-31-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/input.css?ver=2022-05-31-001">
	
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/input.js?ver=2022-05-31-005"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/head.jsp" %>
	<section class='add'>
<form method="POST" >
	<div>
		<input name="isbn" id="isbn" placeholder="ISBN"> 
		<input name="title" id="title" placeholder="도서명 입력 후 Enter">
	</div>
	<div>
	<input name="author" placeholder="저자"> 
		<input name="publicher" placeholder="출판사"> 
		<input name="pubdate" placeholder="출판일"> 
		<input name="price" placeholder="가격" type="number">
	</div>
	<div>
		<input name="link" placeholder="자세히보기" /> 
		<input name="image" placeholder="이미지경로" />
	</div>
	<textarea rows="10"></textarea>
	<button type="submit">저장</button>
</form>
	</section>
	<footer>
		<address>CopyRight &copy; itkezi@naver.com</address>
	</footer>

</body>
</html>