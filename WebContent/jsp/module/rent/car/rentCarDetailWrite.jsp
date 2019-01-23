<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/rent.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Rent <span id="subTitSpan">차량을 등록 할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > 공지사항 > </li>
						<li class="on" id="subTitLi">등록</li>
					</ul>
				</div>
			</div>
		</div>
	
		<div class="contents_wrap">
			<!-- write -->
			<form action="" method="post" id = "rentCarWriteForm">
				<input type="hidden" name="mode" id="mode" value="write" />
				
				<div class="contents">
					<!-- 등록 -->
					<table class="contents_tb wr" id="contTb">
						<colgroup>
							<col width="15%">
							<col width="35%">
							<col width="15%">
							<col width="35%">
						</colgroup>
						<tbody id="contentsTbBody">
							<tr>
								<th scope="col">차량 번호</th>
								<td class="left">
									<input type="text" name="car_id" id = "car_id">
									<input type = "button" id = "checkCar_Id" class="btn_y" value="중복확인">
								</td>
								<th scope="col">차량 모델 명</th>
								<td class="left">
									<input type="text" name="modelName" id = "modelName" >
								</td>
							</tr>
							<tr>
								<th scope="col">차종</th>
								<td class="left">
									<input type = "radio" class="radio_btn" name="carModel" value = "싼타페">싼타페
									 <input type = "radio" class="radio_btn" name="carModel" value = "레이">레이
									 <input type = "radio" class="radio_btn" name="carModel" value = "SM3">SM3
									 <input type = "radio" class="radio_btn" name="carModel" value = "k3">k3	
								</td>
								<th scope="col">구입 조건</th>
								<td class="left">
									<input type = "radio" class="radio_btn" name="condition" value="신차" >신차
									<input type = "radio" class="radio_btn" name="condition" value="중고차">중고차	
								</td>
							</tr>
							<tr>
								<th scope="col">가격</th>
								<td class="left">
									<input type="text" name="price" id = "price">	
								</td>
								<th scope="col">연식</th>
								<td class="left">
									<input type="text" name="year" id = "year">
								</td>
							</tr>
							<tr>
								<th scope="col">유종</th>
								<td class="left" colspan="3">
									<input type = "radio" class="radio_btn" name="oil_Type" value="휘발유">휘발유
				 					<input type = "radio" class="radio_btn" name="oil_Type" value="경유">경유	
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
			
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<input type="button" class="list_btn" id="listBtn" value="목록" onclick="location.href = 'rentCarDetailList.do'" />
<%-- 					 <c:if test="${param.mode eq 'write'}"> --%>
						 <input type="button" class="write_btn" value="등록" id = "enroll" >
					<%-- </c:if>
					<c:if test="${param.mode eq 'edit'}">
						<input type="button" class="edit_btn" id="editProCBtn" value="수정" />
					</c:if>  --%>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/rent.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>