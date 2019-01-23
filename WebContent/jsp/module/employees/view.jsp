<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/employees.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Employees <span>인사 정보를 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > 인사관리 > </li>
						<li class="on">인사 상세 정보</li>
					</ul>
				</div>
			</div>
		</div>
			
		<!-- Contents Area -->
		<div class="contents_wrap">
		
			<!-- Tab -->
			<div class="tab_wrap">
				<ul class="tab_ul">
					<li class="tab_li on" id="basicTab">기본 정보</li>
					<li class="tab_li" id="historyTab">인사 이동 정보</li>
				</ul>
			</div>
		
			<!-- view -->
			<form action="" id="empForm">
				<input type="hidden" name="mode" id="mode" value="${param.mode}" />
				<input type="hidden" name="empId" id="empId" value="${emp.empId}" />

				<div class="contents">
					<!-- 상세 정보 -->
					<table class="contents_tb vw" id="basicTable">
						<colgroup>
							<col width="15%">
							<col width="35%">
						</colgroup>
						<tbody>
							<tr>
								<th scope="col" rowspan="3">사진</th>
								<td class="txt_c" rowspan="3">
									<c:choose>
										<c:when test="${not empty emp.empImg}">
											<img src="upload/${emp.empImg}" class="emp_img" alt="${emp.empId}_img">
										</c:when>
										<c:otherwise>
											<img src="img/comm/user.png" class="emp_img" alt="no_img">
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<th scope="col">한글 명</th>
								<td colspan="3">${emp.korNm}</td>
							</tr>
							<tr>
								<th scope="col">영문 명</th>
								<td colspan="3">${emp.engNm}</td>
							</tr>
							<tr>
								<th scope="col">이메일</th>
								<td>${emp.email}</td>
								<th scope="col">핸드폰 번호</th>
								<td colspan="3">${emp.cellPhone}</td>
							</tr>
							<tr>
								<th scope="col">재직 상태</th>
								<td>${emp.stateNm}</td>
								<c:choose>
									<c:when test="${'retirement' eq emp.state}">
										<th scope="col">퇴직 일</th>
										<td>${emp.retirementDt}</td>
									</c:when>
									<c:otherwise>
										<th scope="col">입사 일</th>
										<td>${emp.hireDt}</td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<th scope="col">부서</th>
								<td>${emp.deptNm}</td>
								<th scope="col">직업</th>
								<td>${emp.jobNm}</td>
							</tr>
							<tr>
								<c:choose>
									<c:when test="${'retirement' eq emp.state}">
										<th scope="col">직책</th>
										<td>${emp.positionNm}</td>
										<th scope="col">입사 일</th>
										<td>${emp.hireDt}</td>
									</tr>
										<c:if test="${99 == loginVO.authority or emp.empId eq loginVO.empId}">
											<tr>
												<th scope="col">연봉</th>
												<td colspan="3">${emp.salary}</td>
											</tr>
										</c:if>
									</c:when>
									<c:when test="${'stay' eq emp.state or 'loa' eq emp.state}">
										<c:choose>
											<c:when test="${99 == loginVO.authority or emp.empId eq loginVO.empId}">
												<th scope="col">직책</th>
												<td>${emp.positionNm}</td>
												<th scope="col">연봉</th>
												<td>${emp.salary}</td>
											</tr>
											</c:when>
											<c:otherwise>
												<th scope="col">직책</th>
												<td colspan="3">${emp.positionNm}</td>
											</tr>
											</c:otherwise>
										</c:choose>
										<c:if test="${'loa' eq emp.state}">
											<tr>
												<th scope="col">휴직 시작 일</th>
												<td>${emp.startDt}</td>
												<th scope="col">휴직 종료 일</th>
												<td>${emp.endDt}</td>
											</tr>
										</c:if>
									</c:when>
								</c:choose>
						</tbody>
					</table>
					
					<!-- 인사 이동 정보 -->
					<table class="contents_tb vw dp_none" id="historyTable">
						<colgroup>
							<col width="10%">
							<col width="15%">
							<col width="15%">
							<col width="15%">
							<col width="15%">
							<col width="15%">
							<col width="15%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">부서</th>
								<th scope="col">직업</th>
								<th scope="col">직책</th>
								<th scope="col">재직 상태</th>
								<th scope="col">등록 일</th>
								<th scope="col">시작 일</th>
								<th scope="col">종료 일</th>
							</tr>
						</thead>
						<tbody id="historyTbBody">
						</tbody>
					</table>
				</div>
			</form>
			
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<input type="button" class="list_btn" id="listBtn" value="목록" />
						<c:if test="${loginVO.authority == 99}">
							<input type="button" class="edit_btn" id="editBtn" value="수정" />
							<input type="button" class="del_btn" id="delProCBtn" value="삭제" />
						</c:if>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/employees.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>