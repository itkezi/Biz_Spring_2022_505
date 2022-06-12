var container = document.getElementById("map"), //지도를 담을 영역의 DOM 레퍼런스
  options = {
    //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(37.5682320566392, 126.89728895889323), //지도의 중심좌표.
    level: 5, //지도의 레벨(확대, 축소 정도)
  };

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
kakao.maps.event.addListener(map, "dragend", function () {
  // 지도 중심좌표를 얻어옵니다
  var latlng = map.getCenter();
});
// 마커가 표시될 위치입니다
var markerPosition = new kakao.maps.LatLng(
  37.5682320566392,
  126.89728895889323
);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
  position: markerPosition,
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 마커를 표시할 위치와 title 객체 배열입니다
var positions = [
  {
    title: "임시",
    latlng: new kakao.maps.LatLng(37.5685697835858, 126.90242746486415),
  },
  {
    title: "임시",
    latlng: new kakao.maps.LatLng(37.566363091949704, 126.90333586185338),
  },
  {
    title: "임시",
    latlng: new kakao.maps.LatLng(37.57434922130049, 126.89661266669978),
  },
  {
    title: "임시",
    latlng: new kakao.maps.LatLng(37.5617679245245, 126.90322861617548),
  },
  {
    title: "임시",
    latlng: new kakao.maps.LatLng(37.56337720514317, 126.91019875000214),
  },
  {
    title: "임시",
    latlng: new kakao.maps.LatLng(37.56013222991391, 126.90839175819526),
  },
  {
    title: "임시",
    latlng: new kakao.maps.LatLng(37.55974568332285, 126.89845504341308),
  },
  {
    title: "임시",
    latlng: new kakao.maps.LatLng(37.579308336813504, 126.89066231573184),
  },
];

// 마커 이미지의 이미지 주소입니다
var imageSrc =
  "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

for (var i = 0; i < positions.length; i++) {
  // 마커 이미지의 이미지 크기 입니다
  var imageSize = new kakao.maps.Size(24, 35);

  // 마커 이미지를 생성합니다
  var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

  // 마커를 생성합니다
  var marker = new kakao.maps.Marker({
    map: map, // 마커를 표시할 지도
    position: positions[i].latlng, // 마커를 표시할 위치
    title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
    image: markerImage, // 마커 이미지
  });
}
// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TORIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(zoomControl, kakao.maps.ControlPosition.BOTTOMRIGHT);

// 마커를 표시할 위치입니다
var position = new kakao.maps.LatLng(37.5685697835858, 126.90242746486415);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
  position: position,
});

// 마커를 지도에 표시합니다.
marker.setMap(map);

// 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
var iwContent = '<div style="padding:5px;">Hello World!</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
  content: iwContent,
});

// 마커에 마우스오버 이벤트를 등록합니다
kakao.maps.event.addListener(marker, "mouseover", function () {
  // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
  infowindow.open(map, marker);
});

// 마커에 마우스아웃 이벤트를 등록합니다
kakao.maps.event.addListener(marker, "mouseout", function () {
  // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
  infowindow.close();
});
