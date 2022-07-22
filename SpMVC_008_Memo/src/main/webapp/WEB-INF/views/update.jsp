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
<title>메모추가</title>
</head>
<body>

<form method="POST">

	<div>
		<input name="m_date" id="date" type="hidden">
		<input name="m_time" id="date" type="hidden">
		<input name="m_author" id="author" placeholder="작성자">
		<input name="m_memo" id="memo" placeholder="메모내용">
		<input type="file" accept="image/*" name="m_image" id="image">
		<button>보내기보내기</button>
	</div>


</form>

</body>
</html>