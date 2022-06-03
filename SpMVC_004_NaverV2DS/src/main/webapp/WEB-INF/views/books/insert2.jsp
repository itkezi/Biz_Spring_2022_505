<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<%@ include file="/WEB-INF/views/books/head.jsp" %>

<style>
.bo {
/* width : 80%; */
margin : 20px auto;
text-align: right;
}

.in {
display: block;

}

input {
width:100%;
margin : 5px 0;
height:30px;

}
.li, button {
padding : 10px;
border:1px solid skyblue;
background: skyblue;
color : black;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<div class='bo'>
	<form method="POST">
	<div class='in'>
		<input name="isbn" id="isbn" placeholder="ISBN"> 
		<input name="title" id="title" placeholder="도서명 입력">
		<input name="author" placeholder="저자"> 
		<input name="publisher"	placeholder="출판사"> 
		<input name="pubdate" placeholder="출판일">
		<input name="price" type="number" placeholder="가격">
		<input name="link" placeholder="자세히보기"> 
		<input name="image"	placeholder="이미지경로">
		<input name="discount"	placeholder="할인가격"> 
		<input name="description" placeholder="내용을 입력하세요">
		</div>
</form>
	<a class='li' href="${rootPath}/books/list">리스트보기</a>
		<button type="submit">저장</button>
	</div>
	
<%-- 	<a href="${rootPath}/books/insert">저장</a> --%>
<%-- 	<a href="${rootPath}/books/detail">새로작성</a> --%>
</body>
</html>