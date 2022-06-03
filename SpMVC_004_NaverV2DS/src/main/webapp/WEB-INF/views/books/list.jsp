<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<%@ include file="/WEB-INF/views/books/head.jsp"%>

<style>
.bo {
	width: 80%;
	margin: 0 auto;
}

.ad {
	text-align: right;
}

table {
margin : 40px auto !important;
}

.add {
background: skyblue;
color : black;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<div class='bo'>
		<table class="list2">
			<thead>
				<tr>
					<th>No.</th>
					<th>ISBN</th>
					<th>도서명</th>
					<th>출판사</th>
					<th>가격</th>
					<th>할인가액</th>
					<th>저자</th>
					<th>출판일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${BOOKS}" var="BOOK" end="10" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${BOOK.isbn}</td>
						<td>${BOOK.title}</td>
						<td>${BOOK.publisher}</td>
						<td>${BOOK.price}</td>
						<td>${BOOK.discount}</td>
						<td>${BOOK.author}</td>
						<td>${BOOK.pubdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class='ad'>
			<a class="add" href="${rootPath}/books/insert2">도서정보추가</a>
		</div>
	</div>
</body>
</html>