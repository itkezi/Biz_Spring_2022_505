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
			FC서울 홈구장: <span>서울 월드컵 경기장</span>
		</p>
	</article>
	<img src="${rootPath}/static/images/seoul.jpg" />
	<div class="month-container">
		<div class="month-table">
			<div class="month-text">
				<p>6월 경기 일정</p>
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
							<td>날짜</td>
							<td>시간</td>
							<td>매치업</td>
						</tr>
					</thead>

					<tbody>
					<%-- 	<c:forEach items="${FOOTBALL}" var="FB">
							<tr>
								<td>${FB.fb_st_date}</td>
								<td>${FB.fb_st_time}</td>
								<td>${FB.fb_st_match}</td>
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