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
<title>user/login.jsp</title>
<style>
form.login {
	width:60%;
	margin: 20px auto;
	padding: 20px;
	}
form.login input {
	margin-bottom: 15px;
}
forn.login button {
	text-align: right;
	margin-left: auto;
}
.red {
padding-left : 16px; 
margin-bottom: 10px;
}
</style>
<script src="${rootPath}/static/js/login.js?ver=2022-06-09-070"></script>
</head>

<body>
<form method=POST class="w3-container w3-card-4 login">
	<h2 class="w3-text-blue">로그인</h2>
	<c:if test="${error == 'LOGIN_NEED'}">
	<div class="w3-red w3-padding-16 red">로그인이 필요한 서비스입니다</div>
	</c:if>
	<c:if test="${error == 'USERNAME_FAIL'}">
	<div class="w3-red w3-padding-16 red">없는 ID입니다 회원가입해주세요</div>
	</c:if>
	<c:if test="${error == 'PASSWORD_FAIL'}">
	<div class="w3-red w3-padding-16 red">비밀번호가 틀렸습니다</div>
	</c:if>
	
	<label class="w3-text-blue"><strong>아이디</strong></label>
	<input name="username" id="username" placeholder="ID" class="w3-input w3-border">
	
	<label class="w3-text-blue">비밀번호</label>
	<input name="password" id="password" placeholder="PASSWORD" class="w3-input w3-border">
	
	<button class="w3-button w3-green btn-login" type="button">로그인</button>
</form>

</body>
</html>