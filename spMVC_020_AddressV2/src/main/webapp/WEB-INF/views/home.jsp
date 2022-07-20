<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/script/addr.js?ver=220720011"></script>
<link rel="stylesheet" href="${rootPath}/static/css/w3css.css">
<link rel="stylesheet" href="${rootPath}/static/css/hjcss.css">
<title>HOME</title>
</head>
<body>
	<video class="hj-v" autoplay muted loop>
		<source src="${rootPath}/static/image/00.mp4" type="video/mp4">
	</video>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>