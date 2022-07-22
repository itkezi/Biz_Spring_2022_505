<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<div>
	<form method="POST" enctype="multipart/form-data">
		<input name="m_date" id="date" type="hidden">
		<input name="m_time" id="time" type="hidden">
		<input name="m_author" id="author" placeholder="작성자">
		<textarea name="m_memo" id="author" placeholder="메모내용"></textarea>
		<input type="file" accept="image/*" name="file" id="image">
		<button>보내기보내기</button>
	</form>
	</div>
	
<!-- 	<div> -->
<%-- 	<form:form modelAttribute="memoVO" enctype="multipart/form-data"> --%>
<%-- 		<form:input path="m_date"/> --%>
<%-- 		<form:input path="m_time"/> --%>
<%-- 		<form:input path="m_author" id="author" placeholder="작성자"/> --%>
<%-- 		<form:textarea path="m_memo" id="author" placeholder="메모내용"/> --%>
<!-- 		<input type="file" accept="image/*" name="file" id="image"> -->
<!-- 		<button>보내기보내기</button> -->
<%-- 	</form:form> --%>
<!-- 	</div> -->

</body>
</html>