<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/rent.css" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />  -->

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>MeetingRoom <span>회의실 정보를 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">회의실 정보</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="contents_wrap">		
			<div class="contents">
				<!-- 목록 보기 -->
				<table class="contents_tb" id="contTb">
					<colgroup>
						<col width="15%">
						<col width="60%">
						<col width="15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">회의실 번호</th>
							<th scope="col">회의실 이름</th>
							<th scope="col">수용 인원</th>
						</tr>
					</thead>
					<tbody id="contentsTbBody">
						<tr>
							<td>${mroom.mId}</td>
							<td>${mroom.mName}</td>
							<td>${mroom.pNum}</td>
						</tr>
					</tbody>
				</table>
				
				<div class="btn_wrap">
					<div class="flt_r">
						<c:if test="${loginVO.authority == 99}">
							<a href="mroomUpdateForm.do?mId=${mroom.mId}">
								<input type="button" class="auto_wth_btn_y" value="수정" />
							</a>
							<a href="mroomDelete.do?mId=${mroom.mId}">
								<input type="button" class="auto_wth_btn_r" value="삭제" />
							</a>
						</c:if>
						<a href="reservInsertForm.do?mId=${mroom.mId}">
							<input type="button" class="auto_wth_btn_b" value="회의실 예약" />
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- <script type="text/javascript" src="/Kocofarm/js/module/rent.js"></script> -->
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>