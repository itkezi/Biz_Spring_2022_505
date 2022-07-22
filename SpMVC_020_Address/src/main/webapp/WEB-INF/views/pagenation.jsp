<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<style>


</style>

<div class="page-box">
	<ul class="page-body">
		<c:if test="${PAGE.startPageNo>1}">
		<li class="page-item"><a href="${rootPath}?pageno=${PAGE.currentPageNo -1}" class="page-link">&lt;</a></li>
		<li><a class="page-link">&middot;&middot;&middot;&middot;</a></li>
		<li class="page-item"><a href="${rootPath}?pageno=1"  class="page-link">1</a></li>
		</c:if>
		
		<c:forEach begin="${PAGE.startPageNo}" end="${PAGE.endPageNo}" var="page">
			<li class="page-item <c:if test='${PAGE.currentPageNo == page}'>active</c:if>"><a href="${rootPath}?pageno=${page}" class="page-link">${page}</a></li>
		</c:forEach>
		
		<c:if test="${PAGE.endPageNo != PAGE.finalPageNo}">
		<li class="page-item"><a href="${rootPath}?pageno=${PAGE.currentPageNo +1}" class="page-link">&gt;</a></li>
		<li><a class="page-link">&middot;&middot;&middot;&middot;</a></li>
		<li class="page-item"><a href="${rootPath}?pageno=${PAGE.finalPageNo}" class="page-link">${PAGE.finalPageNo}</a></li>
		</c:if>
	</ul>
</div>