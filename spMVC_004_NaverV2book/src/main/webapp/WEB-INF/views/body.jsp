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
<title>Insert title here</title>
</head>
<body>
	<section class='main'>
		<div class='book'>
			<table>
				<tr>
					<th>No.</th>
					<th>ISBN</th>
					<th>도서명</th>
					<th>출판사</th>
					<th>저자</th>
					<th>출판일자</th>
				</tr>
				<tr>
					<td>1</td>
					<td>${BOOK.isbn}</td>
					<td>${BOOK.title}</td>
					<td>${BOOK.publisher}</td>
					<td>${BOOK.author}</td>
					<td>${BOOK.pubdate}</td>
				</tr>
			</table>
			<div class='add'>
				<a href="${rootPath}/book_add">도서정보추가</a>
			</div>
			<div class='num'>
				<a>1</a> <a>2</a> <a>3</a>
			</div>
		</div>

	</section>
</body>
</html>