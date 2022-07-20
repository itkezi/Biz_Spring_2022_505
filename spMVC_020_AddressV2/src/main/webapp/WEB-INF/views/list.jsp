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

<title>Insert title here</title>
</head>
<body>
<div class="box-main">
	<c:if test="${empty ADDR}">
	<% // form에 한 개의 input box만 있을 경우 input box text를 입력한 후
		// Enter를 누르면 input box 담긴 문자열을 서버로 전송하는 기능이 활성화된다
	%>
		<table class="hj-ta w3-table w3-bordered w3-hoverable w3-centered">
			<thead>
				<tr class="hj-ta-f">
					<td colspan="3">
						<form>
							<input name="search" class="w3-left w3-border w3-input" placeholder="검색어 입력 후 Enter">
						</form>
					</td>
					<td colspan="1"> <a class="w3-button w3-right hj-c-main" href="${rootPath}/insert">주소추가</a></td>
				</tr>
				<tr>
					<th>SEQ</th>
					<th>Name</th>
					<th>Tel</th>
					<th>Addr</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ADDRS}" var="addr" varStatus="index">
					<tr data-seq="${addr.a_seq}">
						<td>${addr.a_seq}</td>
						<td>${addr.a_name}</td>
						<td>${addr.a_tel}</td>
						<td>${addr.a_address}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/WEB-INF/views/pagenation.jsp"  %>
	</c:if>
</div>

</body>
</html>