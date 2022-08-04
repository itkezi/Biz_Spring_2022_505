<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<form:form>
		<input name="username" placeholder="ID 입력" />
		<input name="password" type="password" placeholder="비밀번호 입력"/>
		<input name="re_password" type="password" placeholder="비밀번호 확인"/>
		<input name="realname" placeholder="실명 입력" />
		<input name="nickname" placeholder="닉네임 입력"/>
		<input name="email" placeholder="이메일 입력"/>
		<button>회원가입</button>
	</form:form>

</body>
</html>