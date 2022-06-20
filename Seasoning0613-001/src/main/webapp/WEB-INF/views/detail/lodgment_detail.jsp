<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<title>Season + ing</title>

</head>
<body>
<section class="schedule-content">

	<div class="month-table">
		<div class="month-text">
			
		</div>
		<article class="table-container">
		
		<p>공통정보</p>
			<table>
				<colgroup>
					<col width="300px">
					<col width="300px">
					<col width="300px">
				</colgroup>
				<thead>
					<tr>
						<td>콘텐츠 id</td>
						<td>관광타입</td>
						<td>홈페이지 주소</td>
						<td>이름</td>
						<td>전화번호</td>
						<td>썸네일</td>
						<td>주소</td>
						<td>개요</td>
					</tr>
				</thead>

				<tbody>
						<tr>
							<td>${COMMONDETAIL.contentid}</td>
							<td>${COMMONDETAIL.contenttypeid}</td>
							<td>${COMMONDETAIL.homepage}</td>
							<td>${COMMONDETAIL.title}</td>
							<td>${COMMONDETAIL.tel}</td>
							<td><img src="${COMMONDETAIL.firstimage}"></td>
							<td>${COMMONDETAIL.addr1}</td>
							<td>${COMMONDETAIL.overview}</td>							
						</tr>
				


				</tbody>
			</table>
			<p>관광지 리스트 상세</p>
			<table>
				<colgroup>
					<col width="300px">
					<col width="300px">
					<col width="300px">
				</colgroup>
				<thead>
					<tr>
						<td>콘텐츠 id</td>
						<td>관광타입</td>
						<td>수용인원</td>
						<td>입실시간</td>
						<td>퇴실시간</td>
						<td>객실내 취사여부</td>
						<td>식음료장</td>
						<td>문의및 안내</td>
						<td>주차시설</td>
						<td>픽업서비스</td>
						<td>예약안내</td>
						<td>예약 홈페이지</td>
						<td>객실유형</td>
						<td>규모</td>
						<td>환불규정</td>
					</tr>
				</thead>

				<tbody>
						<tr>
							<td>${LODGMENTDETAIL.contentid}</td>
							<td>${LODGMENTDETAIL.contenttypeid}</td>
							<td>${LODGMENTDETAIL.accomcountlodging}</td>
							<td>${LODGMENTDETAIL.checkintime}</td>
							<td>${LODGMENTDETAIL.checkouttime}</td>
							<td>${LODGMENTDETAIL.chkcooking}</td>
							<td>${LODGMENTDETAIL.foodplace}</td>
							<td>${LODGMENTDETAIL.infocenterlodging}</td>
							<td>${LODGMENTDETAIL.parkinglodging}</td>
							<td>${LODGMENTDETAIL.pickup}</td>
							<td>${LODGMENTDETAIL.reservationlodging}</td>
							<td>${LODGMENTDETAIL.reservationurl}</td>
							<td>${LODGMENTDETAIL.roomtype}</td>
							<td>${LODGMENTDETAIL.scalelodging}</td>
							<td>${LODGMENTDETAIL.refundregulation}</td>
						</tr>
				


				</tbody>
				
			</table>
		

		</article>
	</div>
	
</section>
	
</body>
</html>
