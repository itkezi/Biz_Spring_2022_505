<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<section class="schedule-content">
	<article class="sch-title">
		<p>
			FC서울 홈구장: <span>서울 월드컵 경기장</span>
		</p>
	</article>
	<img src="" />
	<div class="month-container">
		<div class="month-btn-box">
			<button class="month-btn-prev">&#10094;</button>
			<button class="month-btn-next">&#10095;</button>
		</div>
		<div class="month-table">
			<div class="month-text">
				<p>5월 경기 일정</p>
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
						<c:forEach items="${FB}" var="FB">
							<tr>
								<td>${FB.fb_st_date}</td>
								<td>${FB.fb_st_time}</td>
								<td>${FB.fb_st_match}</td>
							</tr>
						</c:forEach>

						<!--                 <tr>
                  <td>R11 K리그1</td>
                  <td>05.08(일)</td>
                  <td>16:30</td>
                  <td>FC서울 &nbsp; VS &nbsp; 수원FC</td>
                </tr>
                <tr>
                  <td>R12 K리그1</td>
                  <td>05.15(일)</td>
                  <td>19:30</td>
                  <td>FC서울 &nbsp; VS &nbsp; 포항 스틸러스</td>
                </tr>
                <tr>
                  <td>R14 K리그1</td>
                  <td>05.21(토)</td>
                  <td>16:30</td>
                  <td>FC서울 &nbsp; VS &nbsp; 성남FC</td>
                </tr>
                <tr>
                  <td>4라운드 FA컵</td>
                  <td>05.25(수)</td>
                  <td>19:30</td>
                  <td>FC서울 &nbsp; VS &nbsp; 제주UNT</td>
                </tr>
                <tr>
                  <td>R15 K리그1</td>
                  <td>05.28(토)</td>
                  <td>16:30</td>
                  <td>FC서울 &nbsp; VS &nbsp; 김천 상무</td>
                </tr> -->
					</tbody>
				</table>
				<a href="https://www.fcseoul.com/tickets/reserveSingleTicket">
					<div id="ticket-link">티켓 예매하러 가기</div>
				</a>
			</article>
		</div>
	</div>
</section>