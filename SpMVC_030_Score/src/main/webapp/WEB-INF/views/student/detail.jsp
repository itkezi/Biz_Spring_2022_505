<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<div class="detail">

	<table class="st-detail w3-table ">
		<tr>
			<th colspan="2">학생정보</th>
		</tr>
		<tr>
			<th>학번</th>
			<td>${ST.st_num}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${ST.st_name}</td>
		</tr>
		<tr>
			<th>학과</th>
			<td>${ST.st_dept}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${ST.st_tel}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${ST.st_addr}</td>
		</tr>
	</table>

	<table class="sc-detail w3-table " >
		<tr>
			<th colspan="2">성적정보</th>
		</tr>
		<c:forEach items="${ST.scoreList}" var="SC">
			<tr>
				<th>${SC.sb_name}</th>
				<td>${SC.sc_score}</td>
			</tr>
		</c:forEach>
	</table>
	
</div>
<div class="w3-center w3-margin">
	<a class="w3-button w3-border" href="${rootPath}/student/input?st_num=${ST.st_num}">수정</a>
	<a class="w3-button w3-border" href="${rootPath}/student/">리스트로</a>
</div>

