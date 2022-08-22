<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>home.jsp</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}
html {
	width: 100vw;
	height: 100vh;
}
body {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
}
section {
/* 	flex: 1; */
}



</style>
<script>
	const rootPath = "${rootPath}"
</script>
<link rel="stylesheet"
	href="${rootPath}/static/basic.css?ver=2022-08-22-002">
<script src="${rootPath}/static/basic.js?ver=2022-08-22-003"></script>

</head>
<body>
	<header>
		<h1>도서정보관리</h1>
	</header>
	<section>
<form method="POST" class="w3-container">
	<div >
		<input class="w3-input" name="isbn" id="isbn" placeholder="ISBN" value="${BOOK.isbn}"
			<c:if test="${not empty BOOK.isbn}"> readonly="readonly" </c:if>> 
		<input class="" name="title" id="title" placeholder="도서명 입력후 Enter" value="${BOOK.title}">
		<input class="" name="author" placeholder="저자"  value="${BOOK.author}"> 
		<input class="" name="publisher" placeholder="출판사"  value="${BOOK.publisher}"> 
		<input class="" name="link" placeholder="자세히보기"  value="${BOOK.link}"> 
		<input class="" name="image" placeholder="이미지경로"  value="${BOOK.image}">
		<input class="" name="description" placeholder="설명"  value="${BOOK.description}">
	</div>
	<button class="w3-button w3-indigo book-save"  type="button">저장</button>
</form>
	</section>
	<footer>
		<address>CopyRight &copy; itkezi@naver.com</address>
	</footer>
	<div class="w3-modal modal-result">
		<div class="w3-modal-content w3-card-4">
			<header class="w3-container w3-teal">
				<span class="w3-button w3-display-topright modal-close">&times;</span>
				<h2>도서 검색 정보</h2>
			</header>
			<div class="w3-container search-content">
				<p>여기는 검색 결과가 보여지는 곳       
			</div>
			<footer class="w3-container w3-teal">
				<address>CopyRight &copy; callor@callor.com</address>
			</footer>
		</div>
	</div>
</body>
<script type="text/javascript">

document.querySelector("span.modal-close")?.addEventListener("click",()=> {
	document.querySelector("div.w3-modal.modal-result").style.display='none'	
})
	
</script>


</html>