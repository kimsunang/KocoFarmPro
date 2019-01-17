<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/Kocofarm/css/module/rent.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> 

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
	<table class="table table-hover" border="1">
		<thead>
			<tr>
				<td scope="col">회의실 번호</td>
				<td>회의실 이름</td>
				<td>총 인원</td>
			</tr>
		</thead>
		<c:forEach var="mroom" items="${list}">
			<tr>
				<td>${mroom.m_id}</td>
				<td><a href="mroomdetail.do?m_id=${mroom.m_id}">${mroom.m_name}</a></td>
				<td>${mroom.p_num}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	<div class="btn_wrap">
				<div class="flt_r">
					<c:choose>
						<c:when test="${loginVO.authority == 99}">
						<a href="mroomInsertForm.do">회의실 등록</a>
							<input type="button" class="write_btn" id="writeBtn" value="등록" />
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<br><br>
	</div>
	
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- sch_top -->
			<div class="sch_wrap">
				<p class="tit">검색</p>
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
			</div>
			
			<!-- Tab -->
			<div class="tab_wrap">
				<ul class="tab_ul">
					<li class="tab_li on" id="rvTab">목록 보기</li>
					<li class="tab_li" id="photoTab">달력 보기</li>
				</ul>
			</div>
		
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