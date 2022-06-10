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
<title>user/mypage.jsp</title>
<style>
.ubox {
	width: 50%;
	margin: 40px auto;
}

.tt {
	padding-bottom: 10px;
	border-bottom: 1px solid black;
	margin-bottom: 20px;
}

.inbox {
	padding: 20px;
}

.inin {
	flex-direction: column;
}

ininin {
	display: flex
}

.tl {
	flex: 1;
	text-align: center;
}


.tr {
	flex: 3;
}

.usertb {
	font-size: 20px;
}

.usertb th, .usertb td {
	padding: 16px;
}
.usertb td {

}
</style>
</head>
<body>
	<div class="w3-container w3-card-4 ubox">
		<div class="inbox">
			<h1 class="w3-text-black tt">${USER.name}님 회원정보</h1>
			<!-- 			<div class="inin"> -->
			<!-- 				<div class="ininin"> -->
			<!-- 					<h3 class="w3-text-blue tl">아이디</h3> -->
			<%-- 					<h3 class="w3-text-blue tr">${USER.username}</h3> --%>
			<!-- 				</div> -->
			<!-- 				<div class="ininin"> -->
			<!-- 					<h3 class="w3-text-blue tl">이메일</h3> -->
			<%-- 					<h3 class="w3-text-blue tr">${USER.email}</h3> --%>
			<!-- 				</div> -->
			<!-- 				<div class="ininin"> -->
			<!-- 					<h3 class="w3-text-blue tl">이름</h3> -->
			<%-- 					<h3 class="w3-text-blue tr">${USER.name}</h3> --%>
			<!-- 				</div> -->
			<!-- 				<div class="ininin"> -->
			<!-- 					<h3 class="w3-text-blue tl">별명</h3> -->
			<%-- 					<h3 class="w3-text-blue tr">${USER.nickname}</h3> --%>
			<!-- 				</div> -->
			<!-- 				<div class="ininin"> -->
			<!-- 					<h3 class="w3-text-blue tl">권한</h3> -->
			<%-- 					<h3 class="w3-text-blue tr">${USER.role}</h3> --%>
			<!-- 				</div> -->
			<!-- 			</div> -->

			<table class="usertb">
				<tr>
					<th>권한</th>
					<td>${USER.role}</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${USER.username}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${USER.name}</td>
				</tr>
				<tr>
					<th>별명</th>
					<td>${USER.nickname}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${USER.email}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>