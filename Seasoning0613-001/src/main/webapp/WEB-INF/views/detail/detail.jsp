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
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}/static/css/nav.css" />

<style>

body {

}
section {
width: 100vw;
}
.hj-detail-title {
width: 80%;
text-align: center;
margin : 20px auto;
padding :10px 0;
border-bottom: 2px red solid;
}
.hj-detail-main {
margin : 0 auto;
width: 80%;
display: flex;
border-bottom: 1px solid black;
padding-bottom: 20px;
}

.hj-detail-mainpic {
width: 65%;
}

.hj-detail-righttext {
margin-left : 20px;
display: flex;
flex-direction: column;
}

.hj-detail-h2 {
padding-bottom : 5px;
margin-bottom: 5px;
border-bottom: 1px solid red;
}

.hj-detail-h3 {
padding-bottom : 5px;
margin-bottom: 5px;
border-bottom: 1px solid red;
}

</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/detail/nav.jsp" %>

<section>
<h1 class="hj-detail-title">관광지 정보</h1>
<div class="hj-detail-main">
<img class="hj-detail-mainpic" src="${COMMONDETAIL.firstimage}">
<div class="hj-detail-righttext">
<h2 class="hj-detail-h2">${COMMONDETAIL.title}</h2>
<p>장소 : ${COMMONDETAIL.addr1} </p>
<p>전화번호 : ${COMMONDETAIL.tel}</p>
<h3 class="hj-detail-h3">상세설명</h3>
<p>${COMMONDETAIL.overview}</p>
<div>

</div>


</div>


</div>
</section>

</body>
</html>