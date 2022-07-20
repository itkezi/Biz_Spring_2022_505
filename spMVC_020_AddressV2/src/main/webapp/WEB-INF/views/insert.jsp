<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<form method="POST" class="box w3-card-4">
	<c:choose>
		<c:when test="${ADDR.a_seq > 0 }">
			<h1 class="w3-center">UPDATE</h1>
		</c:when>
		<c:otherwise>
			<h1 class="w3-center">NEW</h1>
		</c:otherwise>
	</c:choose>
	<input name="a_seq" type="hidden" value='<c:out value="${ADDR.a_seq}" default="0"/>' /> 
		<input name="a_name" class="hj-in  w3-border  w3-input" placeholder=" Name" 	value="${ADDR.a_name}"> 
		<input name="a_tel" class="hj-in w3-border  w3-input" placeholder=" Tel" value="${ADDR.a_tel}"> 
		<input name="a_address" class="hj-in w3-border  w3-input" placeholder=" Addr" value="${ADDR.a_address}">
	<button class="save w3-button w3-block hj-c-main" type="button">저장</button>
</form>