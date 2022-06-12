<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<section class="schedule-content">

	<div class="month-table">
		<div class="month-text">
			<p>경상북도의 관광지</p>
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
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${GSBD}" var="GSBD">
						<tr>
							<td>${GSBD.title}</td>
							<td>${GSBD.addr1}</td>
							<td>${GSBD.addr2}</td>
							<td>${GSBD.tel}</td>
							<td>${GSBD.contentid}</td>
							<td>${GSBD.firstimage}</td>
							<td>${GSBD.mapx}</td>
							<td>${GSBD.mapy}</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>

		</article>
	</div>
	
</section>