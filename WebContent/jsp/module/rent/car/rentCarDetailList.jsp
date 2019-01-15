<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/Kocofarm/css/module/rent.css" />

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
			<ul>
				<li><a href="rentCarDetailWriteForm.do">차량등록</a> <!-- ///////////////////////////////////나중에 바꾸기 -->
				
			</ul>
			<!-- sch_top -->
			<div class="sch_wrap">		
				<p class="tit">차량목록</p>
				<!-- 
				<div class="sch_slide_btn">
					<img id="slideBtnImg" class="upBtn" src="/Kocofarm/img/comm/list_up_btn.png" alt="메뉴 접기" />
				</div>
				<div class="sch_toggle_wrap">
					<div class="sch_box_wrap">
						<div class="right">
							<select name="schType" id="schType">
								<option value="">전체</option>
								<option value="title">제목</option>
								<option value="contents">내용</option>
							</select>
							<input type="text" name="schWord" id="schWord" placeholder="검색어를 입력 해 주세요" />
							<input type="button" class="schBtn" id="schBtn" value="검색" />
						</div>
					</div>
				</div>
				 -->
				 
				 <table width="700" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>차량번호</td>			
			<td>차량모델명</td>
			<td>차종</td>
			<td>구입조건</td>
			<td>가격</td>
			<td>연식</td>
			<td>유종</td>
			<td>등록일자</td>
			<td>수정일자</td>
			
		</tr>
		<%-- 
		<c:forEach var="rentCar_Detail" items="${list }"> <!-- 원래 list만 있었엉 -->
			<tr>
				<td>${board.seq }</td>
							
				<td><a href="setCardetail.do?seq=${rentCar_Detail.car_id }">${rentCar_Detail.carModel }</a></td>
				<td>${board.writer }</td>
				<td>
					<fmt:parseDate var="dateString" value="${rentCar_Detail.regdate }" pattern="yyyy-MM-dd" />
					<fmt:formatDate value="${dateString }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${board.hitcount }</td>
			</tr>
		</c:forEach> 
		  --%>
	</table>	
	<br><br>
	
	<form action="list.jsp" method="post">
		<input type="checkbox" name="area" value="car_id">차량번호
		<input type="checkbox" name="area" value="carModel">차량모델명
		<input type="text" name="searchKey" size="10"></input>
		<input type="submit" value="검색">
	</form>
				 
			</div>
			
			<!-- Tab -->
			<!-- 
			<div class="tab_wrap">
				<ul class="tab_ul">
					<li class="tab_li on" id="rvTab">목록 보기</li>
					<li class="tab_li" id="photoTab">달력 보기</li>
				</ul>
			</div>
			 -->
		
			<!-- list -->
			<div class="contents">
				<!-- 목록 보기 -->
				<table class="contents_tb" id="contTb">
				</table>
			</div>
						
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<input type="button" class="list_btn" value="목록" />
					<input type="button" class="view_btn" value="상세보기" />
					<input type="button" class="write_btn" value="등록" />
					<input type="button" class="edit_btn" value="수정" />
					<input type="button" class="del_btn" value="삭제" />
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/Kocofarm/js/module/rent.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>