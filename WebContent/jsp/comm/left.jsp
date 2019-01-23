<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/comm/left.css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="dp_in_b wth100p">

	<c:if test="${null != moduleNm and '' ne moduleNm}">
		<div class="left_wrap">
			<div class="left_bar">
				<div class="menu_t">
					<nav>
						<ul>
							<c:choose>
								<c:when test="${'employees' eq moduleNm}">
									<li><a href="empList.do">인사 관리</a></li>
									<li><a href="">인사 고과</a></li>
									<li><a href="">급여 관리</a></li>
									<li><a href="">근태 관리</a></li>
								</c:when>
								<c:when test="${'rent' eq moduleNm}">
									<li><a href="rentCarDetailList.do">차량 관리</a></li>
									<li><a href="">차량 예약</a></li>
									<li><a href="">차량 운행 일지</a></li>
									<li><a href="">차량 정비 일지</a></li>
									<li><a href="mroomlist.do">회의실</a></li>
									<li><a href="reservList.do">회의실 예약 목록</a></li>
								</c:when>
								<c:when test="${'schedule' eq moduleNm}">
									<li><a href="schedule.do">일정 관리</a></li>
									<li><a href="fileList.do">파일 보관함</a></li>
								</c:when>
							</c:choose>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</c:if>