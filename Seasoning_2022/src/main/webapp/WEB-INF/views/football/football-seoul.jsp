<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Season + ing ㅣ soccer-seoul</title>
    <link rel="stylesheet" href="${rootPath}/static/css/nav.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/k-league-box.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/area-view.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/schedule.css" />
    <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
  />
  <script
    scr="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/js/all.min.js"
  ></script>
  
  </head>
  <body>
    <header>
      <nav id="nav-menu">
 
        <div id="drop">
          <ul id="menu">
            <li id="logo"><a href="${rootPath}/"><img src="../images/logo.png"></a></li>
            <li id="soccer">
              <a href="../html/soccer-seoul.html">축구</a>
              <ul class="drop-menu drop-soccer">
                <li><a>김천 상무</a></li>
                <li><a>인천 UNT</a></li>
                <li><a>전북 현대</a></li>
                <li><a>수원 삼성</a></li>
                <li><a>성남 FC</a></li>
                <li><a>FC 서울</a></li>
                <li><a>제주 UNT</a></li>
                <li><a>대구 FC</a></li>
                <li><a>강원 FC</a></li>
                <li><a>수원 FC</a></li>
                <li><a>울산 현대</a></li>
                <li><a>포항 스틸러스</a></li>
              </ul>
            </li>
            <li id="baseball">
              <a href="baseball-kia.html">야구</a>
              <ul class="drop-menu drop-baseball">
                <li><a>KT 위즈</a></li>
                <li><a>두산 베어스</a></li>
                <li><a>삼성 라이온즈</a></li>
                <li><a>LG 트윈스</a></li>
                <li><a>키움 히어로즈</a></li>
                <li><a>SSG 랜더스</a></li>
                <li><a>NC 다이노스</a></li>
                <li><a>롯데 자이언츠</a></li>
                <li><a>KIA 타이거즈</a></li>
                <li><a>한화 이글스</a></li>
              </ul>
            </li>
            <li id="volleyball">
              <a>배구</a>
              <ul class="drop-volleyball">
                <li>
                  <ul id="volleyman">
                    <li>남자부</li>
                    <li><a>대한항공 점보스</a></li>
                    <li><a>KB손해보험 스타즈</a></li>
                    <li><a>한국전력 빅스톰</a></li>
                    <li><a>삼성화재 블루팡스</a></li>
                    <li><a>우리카드 우리WON</a></li>
                    <li><a>OK금융그룹 읏맨</a></li>
                    <li><a>현대캐피탈 스카이워커스</a></li>
                  </ul>
                </li>
                <li>
                  <ul id="volleywoman">
                    <li>여자부</li>
                    <li><a>GS 칼텍스 KIXX</a></li>
                    <li><a>IBK 기업은행 알토스</a></li>
                    <li><a>KGC인삼공사 프로배구단</a></li>
                    <li><a>페퍼저축은행 AI 페퍼스</a></li>
                    <li><a>흥국생명 핑크스파이더스</a></li>
                    <li><a>한국도로공사 하이패스</a></li>
                    <li><a>현대건설 힐스테이트</a></li>
                  </ul>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
    </header>
    <section>
      <article>
        <h1>케이리그</h1>
        <div id="k-league-box">
          <div id="korea-map"><img src="${rootPath}/static/images/korea-map.png" /></div>
          
          <div id="ticket-book">
          	<!-- 경기일정 부분 따로 뺌 -->
          	<%@ include file="/WEB-INF/views/football/fb-schedule.jsp" %>
          </div>
          
        </div>
        <a><div class="map-point seoul" style="  font-size: 18px;
          background-color: rgb(0, 24, 65);">FC 서울</div></a>
        <a><div class="map-point gangwon1">강원 FC</div></a>
        <a><div class="map-point gangwon2">강원 FC</div></a>
        <a><div class="map-point gimcheon">김천 상무</div></a>
        <a><div class="map-point deagu">대구 FC</div></a>
        <a><div class="map-point seongnam">성남 FC</div></a>
        <a><div class="map-point suwon1">수원 삼성</div></a>
        <a><div class="map-point suwon2">수원 FC</div></a>
        <a><div class="map-point ulsan">울산 현대</div></a>
        <a><div class="map-point incheon">인천 UNT</div></a>
        <a><div class="map-point jeonbuk">전북 현대</div></a>
        <a><div class="map-point jeju">제주 UNT</div></a>
        <a><div class="map-point pohang">포항 스틸러스</div></a>
      </article>
      <article>
        <h1 id="around-tour-text">주변 관광지</h1>
        <div id="around-tour-box">
          
          <div id="map" style="width: 780px; height: 700px"></div>
          
          

          <div id="tour-list">
            <div id="choice-tour-menu">
              <a><div id="choice-all">전체</div></a>
              <a><div>식당</div></a>
              <a><div>숙박</div></a>
            </div>
            <p>총 <span>100</span>개의 결과가 있습니다</p>
            <div id="list-detail">
              
              <div class="tour-detail">
                <div class="detail-img"><img src="" /></div>
                <div>
                  <p>[숙박]</p>
                  <p>
                  </p>
                  <a><div class="detail-watch"></href>자세히 보러가기</div></a>
                </div>
              </div>
              
            </div>
          </div>
        </div>
      </article>
      <div class="popular_view">
        
      <!-- 지역별 관광지 부분 -->
      <h4 class="view-title">지역별 관광지</h4>
      <div class="area-view">
        <div class="area-container">
          <ul class="area-menu">
            <li><a>서울</a></li>
            <li><a>인천</a></li>
            <li><a>대전</a></li>
            <li><a>대구</a></li>
            <li><a>광주</a></li>
            <li><a>부산</a></li>
            <li><a>울산</a></li>
            <li><a>세종</a></li>
            <li><a>경기</a></li>
            <li><a>강원</a></li>
            <li><a>충북</a></li>
            <li><a>충남</a></li>
            <li><a>경북</a></li>
            <li><a>경남</a></li>
            <li><a>전북</a></li>
            <li><a>전남</a></li>
            <li><a>제주</a></li>
          </ul>
        </div>
      </div>
      <h4 class="attraction">명소 관광지</h4>
      <div class="container-view">
          <div class="attraction-view">
              <div class="slides">
                
                <div class="slide">
                  <div class="attr-container">
                    <span class="img">
                      <img src="" />
                    </span>
                    <span>[명소]&nbsp; <b>장소</b></span>
                    <span class="content">
                    </span>
                  </div>
                </div>
                <div class="slide">
                  <div class="attr-container">
                    <span class="img">
                      <img src="" />
                    </span>
                    <span>[명소]&nbsp; <b>장소</b></span>
                    <span class="content">
                    </span>
                  </div>
                </div>
                <div class="slide">
                  <div class="attr-container">
                    <span class="img">
                      <img src="" />
                    </span>
                    <span>[명소]&nbsp; <b>장소</b></span>
                    <span class="content">
                    </span>
                  </div>
                </div>
                <div class="slide">
                  <div class="attr-container">
                    <span class="img">
                      <img src="" />
                    </span>
                    <span>[명소]&nbsp; <b>장소</b></span>
                    <span class="content">
                    </span>
                  </div>
                </div>
              </div>
            </div>
            <div class="btn-box">
                <button class="btn prev">&#10094;</button>
                <button class="btn next">&#10095;</button>
            </div>
          </div>
        </div>
      </div>
    </section>
    <footer></footer>
  </body>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=be01097258cdbbe3042dc5464adc574e&libraries=services,clusterer">
  </script>
  <script src="${rootPath}/static/js/map.js"></script>
</html>
