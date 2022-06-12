<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<section class="schedule-content">

	<div class="month-table">
		<div class="month-text">
			<p>경기도의 관광지</p>
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
					<c:forEach items="${GGD}" var="GGD">
						<tr>
							<td>${GGD.title}</td>
							<td>${GGD.addr1}</td>
							<td>${GGD.addr2}</td>
							<td>${GGD.tel}</td>
							<td>${GGD.contentid}</td>
							<td>${GGD.firstimage}</td>
							<td>${GGD.mapx}</td>
							<td>${GGD.mapy}</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>

		</article>
	</div>
	
</section>