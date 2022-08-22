<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="${rootPath}/static/basic.css?ver=2022-08-22-001">
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/basic.js?ver=2022-08-22-001"></script>
<section class="modal-content">
	<article class="ch-container ch-teal">
		<span
			onclick="document.getElementById('modal_box').style.display='none'"
			class="ch-button ch-display-top-right">&times;</span>

		<h2>네이버 검색 서비스</h2>
	</article>

	<article class="ch-container">
		<table class="ch-table">
			<colgroup>
				<col width="300px">
				<col width="100px">
				<col width="100px">
			</colgroup>
			<thead>
				<tr>
					<th>도서명</th>
					<th>출판사</th>
					<th>저자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${BOOKS}" var="BOOK">
					<tr data-isbn="${BOOK.isbn}">
						<td>${BOOK.title}</td>
						<td>${BOOK.publisher}</td>
						<td>${BOOK.author}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</article>
</section>