<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<section class="schedule-content">

	<div class="month-table">
		<div class="month-text">
			<p>대구 경기장 주변</p>
		</div>
		<article class="table-container">
			<table>
				<colgroup>
					<col width="300px">
					<col width="300px">
					<col width="300px">
				</colgroup>
				<thead>
					<tr>
						<td>이름</td>
						<td>주소</td>
						<td>주소상세</td>
						<td>전화번호</td>
						<td>콘텐츠ID</td>
						<td>대표이미지</td>
						<td>좌표x</td>
						<td>좌표y</td>
						<td>거리반경</td>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${DEAGUAROUND}" var="DEAGUAROUND">
						<tr>
							<td>${DEAGUAROUND.title}</td>
							<td>${DEAGUAROUND.addr1}</td>
							<td>${DEAGUAROUND.addr2}</td>
							<td>${DEAGUAROUND.tel}</td>
							<td>${DEAGUAROUND.contentid}</td>
							<td>${DEAGUAROUND.firstimage}</td>
							<td>${DEAGUAROUND.mapx}</td>
							<td>${DEAGUAROUND.mapy}</td>
							<td>${DEAGUAROUND.dist}</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>

		</article>
	</div>
	
</section>