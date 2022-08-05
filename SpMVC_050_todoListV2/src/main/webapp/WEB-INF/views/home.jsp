<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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

	<H1>나의 Todo List</H1>

	<sec:authorize access="isAnonymous()">
		<a href="${rootPath}/login">로그인</a>
		<a href="${rootPath}/user/join">회원가입</a>
	</sec:authorize>

	<sec:authorize access="isAuthenticated() AND hasRole('ROLE_ADMIN')">
		<a href="${rootPath}/admin/home">관리자화면</a>
	
	</sec:authorize>
	
	
	<sec:authorize access="isAuthenticated() AND hasRole('ROLE_USER')">
		<a href="${rootPath}/user/mypage">마이페이지</a>
		<form:form class="logout" action="${rootPath}/logout">
			<button>로그아웃</button>
		</form:form>
	</sec:authorize>

</body>
</html>