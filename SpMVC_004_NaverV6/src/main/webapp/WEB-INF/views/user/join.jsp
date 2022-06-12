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
<title>user/join.jsp</title>
<style>
form.join {
	width:70%;
	margin: 20px auto;
	padding: 20px;
	}
form.join input {
	margin-bottom: 15px;
}

form.join label {
font-weight: bold;
}
.error {
padding : 0 !important;
}
</style>

<script src="${rootPath}/static/js/join.js?ver=220610-022"></script>

</head>

<body>
<form method=POST class="w3-container w3-card-4 join">

	<h2>회원가입</h2>

	<label class="w3-text-blue">아이디</label>
	<div class="w3-container error"></div>
	<input name="username" id="username" placeholder="ID" class="w3-input w3-border">
	
	<label class="w3-text-blue">비밀번호</label>
	<div class="w3-container error"></div>
	<input name="password" id="password" placeholder="PASSWORD" class="w3-input w3-border">
	
	<label class="w3-text-blue">비밀번호 확인</label>
	<div class="w3-container error"></div>
	<input name="re-password" id="re-password" placeholder="RE_PASSWORD" class="w3-input w3-border">
	
	<label class="w3-text-blue">이메일</label>
	<div class="w3-container error"></div>
	<input name="email" id="email" placeholder="EMAIL" class="w3-input w3-border">
	
	<label class="w3-text-blue">이름</label>
	<div class="w3-container error"></div>
	<input name="name" id="name" placeholder="NAME" class="w3-input w3-border">
	
	<label class="w3-text-blue">별명</label>
	<div class="w3-container error"></div>
	<input name="nickname" id="nickname" placeholder="NICKNAME" class="w3-input w3-border">
	
	<button id="btn-join" class="w3-button w3-blue" type="button">회원가입</button>
</form>

</body>
</html>