<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<style>
.schedule-content img{
  height: 272px;
  width: 560px;
  margin: 10px 20px 0 20px;
}
</style>

<section class="schedule-content">
	<article class="sch-title">
		<p>
			두산 홈구장: <span>두산</span>
		</p>
	</article>
	<img src="${rootPath}/static/images/seoul.jpg" />
	<div class="month-container">
		<div class="month-btn-box">
			<button class="month-btn-prev">&#10094;</button>
			<button class="month-btn-next">&#10095;</button>
		</div>
		<div class="month-table">
			<div class="month-text">
				<p>6월 경기 일정</p>
			</div>
			<article class="table-container">
				<table>
					<colgroup>
						<col width="300px">
						<col width="300px">
					</colgroup>
					<thead>
						<tr>
							<td>날짜</td>
							<td>매치업</td>
						</tr>
					</thead>

					<tbody>
					<%-- 	<c:forEach items="${BASEBALL}" var="BB">
							<tr>
								<td>${BB.st_date}</td>
								<td>${BB.st_match}</td>
							</tr>
						</c:forEach>
						
						<c:forEach items="${BASEBALL2}" var="BB2">
							<tr>
								<td>${BB2.st_date}</td>
								<td>${BB2.st_match}</td>
							</tr>
						</c:forEach>

						<c:forEach items="${BASEBALL3}" var="BB3">
							<tr>
								<td>${BB3.st_date}</td>
								<td>${BB3.st_match}</td>
							</tr>
						</c:forEach>

						<c:forEach items="${BASEBALL4}" var="BB4">
							<tr>
								<td>${BB4.st_date}</td>
								<td>${BB4.st_match}</td>
							</tr>
						</c:forEach> --%>
					</tbody>
				</table>
				<a href="https://www.fcseoul.com/tickets/reserveSingleTicket">
					<div id="ticket-link">티켓 예매하러 가기</div>
				</a>
			</article>
		</div>
	</div>
</section>