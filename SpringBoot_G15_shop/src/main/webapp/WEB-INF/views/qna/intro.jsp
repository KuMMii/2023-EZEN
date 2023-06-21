<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter/header.jsp"%>
<%@ include file="../include/sub04/sub_image_menu.jsp" %>

<article>

<h2>회사 소개</h2>
Shoews Shop은 어쩌고 저쩌고

<h2>오시는 길</h2>
- 서울특별시 서대문구 신촌로 141 (은하빌딩 1층 101호)<br>
- 전화 02)393-4321<br>
- 팩스 02)345-4321

<h3>버스</h3>
- 신촌 오거리

<h3>지하철</h3>
- 2호선 신촌역 4번 출구 200M직전 또는 이대역 1번 출구 100M 직진

<h3>위치 안내</h3>
<div>
<!-- * 카카오맵 - 지도퍼가기 -->
<!-- 1. 지도 노드 -->
<div id="daumRoughmapContainer1687325159953" class="root_daum_roughmap root_daum_roughmap_landing"></div>

<!--
	2. 설치 스크립트
	* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
-->
<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

<!-- 3. 실행 스크립트 -->
<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1687325159953",
		"key" : "2f9tg",
		"mapWidth" : "640",
		"mapHeight" : "360"
	}).render();
</script>
</div>

</article>


<%@ include file="../include/headerfooter/footer.jsp"%>