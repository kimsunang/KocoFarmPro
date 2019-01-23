<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/rent.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>RentCarDetail <span>등록된 차량 정보를 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">차량관리</li>
					</ul>
				</div>
			</div>
		</div>
	
		<!-- Contents Area -->
		<div class="contents_wrap">
			<form action="rentCarDetailList.do" method="post">
				<div class="sch_wrap">
					<p class="tit">검색</p>
					<div class="sch_slide_btn">
						<img id="slideBtnImg" class="upBtn" src="/KocoFarmPro/img/comm/list_up_btn.png" alt="메뉴 접기" />
					</div>
					<div class="sch_toggle_wrap">
						<div class="sch_box_wrap">
							<div class="right">
								<input type="checkbox" class="chk_box" name="area" id="carIdChk" value="car_id">차량번호
								<input type="checkbox" class="chk_box" name="area" value="carModel">차량모델명
								<input type="text" name="searchKey" size="10"></input>
								<input type="submit" class="schBtn" value="검색"/>
							</div>
						</div>
					</div>
				</div>
			</form>
			
			<!-- list -->
			<div class="contents">
				<!-- 목록 보기 -->
				<table class="contents_tb" id="contTb">
					<colgroup>
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">차량번호</th>			
							<th scope="col">차량모델명</th>
							<th scope="col">차종</th>
							<th scope="col">구입조건</th>
							<th scope="col">가격</th>
							<th scope="col">연식</th>
							<th scope="col">유종</th>
							<th scope="col">등록일자</th>
							<th scope="col">수정일자</th>
						</tr>
					</thead>
					<tbody id="contentsTbBody">
						<c:forEach var="RCdetail" items="${rentCarDetailListModel.list}"> 
						<!-- RentCarDetailService에서 RentCarDetailListModel 중에서 list만 불러오는 것이다. -->
							<tr>
								<td>${RCdetail.carId }</td> 
								<td><a href="rentCarDetailView.do?carId=${RCdetail.carId}">${RCdetail.modelName }</a></td>
								<td>${RCdetail.carModel }</td>
								<td>${RCdetail.condition }</td>
								<td>${RCdetail.price }</td>
								<td>${RCdetail.year}</td>
								<td>${RCdetail.oilType }</td>
								<td>
									<fmt:parseDate var ="dateString" value="${RCdetail.regDt }"	pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${dateString}" pattern="yyyy-MM-dd"/>
								</td>
								<td>
									<fmt:parseDate var ="dateString" value="${RCdetail.upDt }"	pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${dateString }" pattern="yyyy-MM-dd"/>
								</td> 
							</tr>
						</c:forEach> 
					</tbody>
				</table>
			</div>
			
		<div class="paging_div">
			<!-- 이전 -->
			<c:if test="${ listModel.startPage>5}">
				<span><a href = "list.do?pageNum =${listModel.startPage-5 }">&lt;</a></span>	
			</c:if>
			<!-- 페이지 목록 -->
			<c:forEach var= "pageNo" begin="${listModel.startPage }" end ="${listModel.endPage }">
				<c:if test="${listModel.requestPage == pageNo }"><b></c:if>
					<span><a href="list.do?pageNum=${pageNo }">${pageNo}</a></span>	
				<c:if test="${listModel.requestPage == pageNo }"></b></c:if>
			</c:forEach>
			<!-- 이후 -->
			<c:if test="${ listModel.endPage < listModel.totalPageCount}">
				<span><a href = "list.do?pageNum =${listModel.startPage+5 }">&gt;</a></span>	
			</c:if>
		</div>
	
		<!-- btn -->
		<div class="btn_wrap">
			<div class="flt_r">
				<!-- <input type="button" class="list_btn" value="목록" />
				<input type="button" class="view_btn" value="상세보기" /> -->
				<a href="rentCarDetailWriteForm.do">
					<input type="button" class="auto_wth_btn_b" value="차량등록" id = writeBtn />
				</a>
				<!-- <input type="button" class="edit_btn" value="수정" />
				<input type="button" class="del_btn" value="삭제" /> -->
			</div>
		</div>
			
		</div>
	</div>

<script type="text/javascript" src="/KocoFarmPro/js/module/rent.js"></script>

<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>