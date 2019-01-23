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
					<h2>MeetingRoom <span>회의실 목록</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">회의실 목록</li>
					</ul>
				</div>
			</div>
		</div>
		
	<!--회의실 예약 목록 -->
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
					<c:choose>
						<c:when test="${not empty list}">
							<c:forEach var="mroom" items="${list}" varStatus="status">
								<tr>
									<td>${mroom.mId}</td>
									<td class="cursorP">
										<a href="mroomdetail.do?mId=${mroom.mId}">${mroom.mName}</a>
									</td>
									<td>${mroom.pNum}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3">데이터가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			
			<div class="btn_wrap">
				<div class="flt_r">
					<c:if test="${loginVO.authority == 99}">
						<a href="mroomInsertForm.do">
							<input type="button" class="auto_wth_btn_b" value="회의실 등록" />
						</a>
					</c:if>
				</div>
			</div>
	
		</div>
	</div>
		
<!-- <script type="text/javascript" src="/Kocofarm/js/module/rent.js"></script> -->
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>