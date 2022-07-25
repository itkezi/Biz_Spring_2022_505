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
<link rel="stylesheet" href="${rootPath}/static/css/w3css.css">
<link rel="stylesheet" href="${rootPath}/static/css/hjcss.css">

<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${ADDR.a_seq > 0 }">
			<h1 class="w3-text-white w3-center">UPDATE</h1>
		</c:when>
		<c:otherwise>
			<h1 class="w3-text-white w3-center">NEW</h1>
		</c:otherwise>
	</c:choose>
	<video class="hj-v" autoplay muted loop>
		<source src="${rootPath}/static/image/00.mp4" type="video/mp4">
	</video>
	<form method="POST" class="box <c:if test='${empty ADDR}'>box-f </c:if>w3-card-4">
		<input name="a_seq" type="hidden" value='<c:out value="${ADDR.a_seq}" default="0"/>'/>
		<input name="a_name" class="hj-in  w3-border <c:if test='${ADDR.a_seq > 0 }'>w3-input</c:if>" 
			placeholder="Name" value="${ADDR.a_name}"> 
		<input name="a_tel" class="hj-in w3-border <c:if test='${ADDR.a_seq > 0 }'>w3-input</c:if>" 
			placeholder="Tel" value="${ADDR.a_tel}"> 
		<input name="a_address" class="ad hj-in w3-border <c:if test='${ADDR.a_seq > 0 }'>w3-input</c:if>" 
			placeholder="Addr"  value="${ADDR.a_address}">
		<button class="w3-button hj-c-main <c:if test='${ADDR.a_seq > 0 }'>w3-block</c:if>">저장</button>
	</form>
	<c:if test="${empty ADDR}">
		<table class="box hj-ta w3-table w3-bordered  w3-centered w3-card-4">
			<thead>
				<tr class="">
					<th>No.</th>
					<th>Name</th>
					<th>Tel</th>
					<th>Addr</th>
					<th>Detail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ADDRS}" var="addr" varStatus="index">
					<tr>
						<td>${addr.a_seq}</td>
						<td>${addr.a_name}</td>
						<td>${addr.a_tel}</td>
						<td>${addr.a_address}</td>
						<td><a class="hj-pl w3-button hj-c-main" href="${rootPath}/detail?seq=${addr.a_seq}">+</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">
						<%@ include file="/WEB-INF/views/pagenation.jsp"  %>
					</td>
				</tr>
			</tfoot>
		</table>
	</c:if>
</body>
<footer>
	<h6 class="w3-text-white w3-center">CopyRight</h6>
</footer>
</html>