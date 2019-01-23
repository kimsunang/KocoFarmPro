<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/rent.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Rent <span>대여 관련 내용을 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">대여 관리</li>
					</ul>
				</div>
			</div>
		</div>
		
		
		<!-- 대여 목록 -->
		
		
		<div class="contents_wrap">		
			<ul>
			    <li><a href="rentCarDetailList.do">차량목록(관리자)</a>
				<li><a href="">차량정비일지</a>
				<li><a href="">차량예약</a>
				<li><a href="">차량운행일지</a>
				<hr>
			  	<li><a href="mroomlist.do">회의실 목록</a></li>
			  	<li><a href="reservList.do">회의실 예약 목록</a></li>
			</ul>
		</div>
	</div>

<script type="text/javascript" src="/KocoFarmPro/js/module/rent.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>