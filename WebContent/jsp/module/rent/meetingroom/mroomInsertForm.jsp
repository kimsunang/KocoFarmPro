<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/rent.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>MeetingRoom <span>회의실을 등록할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">회의실 등록</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="contents_wrap">
		
			<div class="contents">
				<!-- 등록 -->
				<form action="mroomInsert.do" method="post">
					<table class="contents_tb wr" id="contTb">
						<colgroup>
							<col width="15%">
						</colgroup>
						<tbody id="contentsTbBody">
							<tr>
								<th scope="col">회의실 번호</th>
								<td class="left">
									<input type="text" name="mId" />
								</td>
							</tr>
							<tr>
								<th scope="col">회의실 이름</th>
								<td class="left">
									<input type="text" name="mName">
								</td>
							</tr>
							<tr>
								<th scope="col">인원</th>
								<td class="left">
									<input type="text" name="pNum">
									<input type="hidden" name="regDt">
								</td>
							</tr>
						</tbody>
					</table>
					<div class="btn_wrap">
						<div class="flt_r">
							<input type="submit" class="auto_wth_btn_b" value="등록">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<!-- <script type="text/javascript" src="/Kocofarm/js/module/rent.js"></script> -->
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>