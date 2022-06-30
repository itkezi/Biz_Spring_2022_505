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
<link rel="stylesheet" href="${rootPath}/static/main.css">
<title>User / login</title>

</head>
<body>
	<div class="login-box">
		<h1>myMEMO</h1>
		<span>SELECT * FROM kezi_memo</span> <br> <span>WHERE ID =
			&#35;&#123;</span>
		<form method="POST">
			<input name="username">
		</form>
		<span>&#125;</span>
	</div>
</body>
</html>