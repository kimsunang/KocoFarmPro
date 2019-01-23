<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/employees.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Employees <span>인사 관련 정보를 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > 인사 관리 > </li>
						<li class="on">인사 정보</li>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- sch_top -->
			<form action="empList.do" id="empForm">
				<input type="hidden" name="mode" id="mode" value="list" />
				<input type="hidden" id="paramSchType" value="${param.schType}" />
				<input type="hidden" id="paramSchWord" value="${param.schWord}" />
				
				<div class="sch_wrap">
					<p class="tit">검색</p>
					<div class="sch_slide_btn">
						<img id="slideBtnImg" class="upBtn" src="/KocoFarmPro/img/comm/list_up_btn.png" alt="메뉴 접기" />
					</div>
					<div class="sch_toggle_wrap">
						<div class="sch_box_wrap">
							<div class="right">
								<select name="schType" id="schType">
									<option value="">전체</option>
									<option value="empId" ${"empId" eq param.schType ? "selected='selected'" : ""}>사원번호</option>
									<option value="korNm" ${"korNm" eq param.schType ? "selected='selected'" : ""}>이름</option>
									<option value="cellphone" ${"cellphone" eq param.schType ? "selected='selected'" : ""}>전화 번호</option>
									<option value="state" ${"state" eq param.schType ? "selected='selected'" : ""}>재직 상태</option>
								</select>
								<span class="sch_span">
									<input type="text" name="schWord" id="schWord" value="${param.schWord != null ? param.schWord : ''}" placeholder="검색어를 입력 해 주세요" />
								</span>
								<input type="button" class="schBtn" id="schBtn" value="검색" />
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
						<col width="5.45454%">
						<col width="20%">
						<col width="14%">
						<col width="10%">
						<col width="10%">
						<col width="15%">
						<col width="10%">
						<col width="15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">NO</th>
							<th scope="col">사원번호</th>
							<th scope="col">이름</th>
							<th scope="col">재직 상태</th>
							<th scope="col">부서</th>
							<th scope="col">직업</th>
							<th scope="col">직책</th>
							<c:if test="${99 == loginVO.authority}">
								<th scope="col">기능</th>
							</c:if>
						</tr>
					</thead>
					<tbody id="contentsTbBody">
						<c:choose>
							<c:when test="${not empty empList.list}">
								<c:forEach var="list" items="${empList.list}" varStatus="status">
									<tr>
										<td>
											${(empList.totalCount-status.index)-((empList.requestPage-1)*empList.pageSize)}
										</td>
										<td class="cursorP"><a href="empView.do?mode=view&empId=${list.empId}">${list.empId}</a></td>
										<td class="cursorP"><a href="empView.do?mode=view&empId=${list.empId}">${list.korNm}</a></td>
										<td>${list.stateNm}</td>
										<td>${list.deptNm}</td>
										<td>${list.jobNm}</td>
										<td>${list.positionNm}</td>
										<c:if test="${99 == loginVO.authority}">
											<td>
												<input type="button" class="resetPwBtn" id="resetPw_${list.empId}" value="비밀번호 초기화" />
											</td>
										</c:if>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<c:choose>
										<c:when test="${99 == loginVO.authority}">
											<td colspan="8">데이터가 없습니다.</td>
										</c:when>
										<c:otherwise>
											<td colspan="7">데이터가 없습니다.</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			
			<!-- 페이징 -->
			<div class="paging_div">
				<!-- 이전 -->
				<c:if test="${empList.startPage > 10}">
					<span><a href="empList.do?pageNum=${empList.startPage-10}&schTye=${param.schType}&schWord=${param.schWord}">&lt;</a></span>
				</c:if>
				<!-- 페이지 목록 -->
				<c:forEach var="pageNo" begin="${empList.startPage}" end="${empList.endPage}">
					<c:if test="${empList.requestPage == pageNo}"><b></c:if>
						<span><a href="empList.do?pageNum=${pageNo}&schTye=${param.schType}&schWord=${param.schWord}">${pageNo}</a></span>
					<c:if test="${empList.requestPage == pageNo}"></b></c:if>
				</c:forEach>
				<!-- 이후 -->
				<c:if test="${empList.endPage < empList.totalPageCount}">
					<span><a href="empList.do?pageNum=${empList.startPage+10}&schTye=${param.schType}&schWord=${param.schWord}">&gt;</a></span>
				</c:if>
			</div>
			
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<c:if test="${loginVO.authority == 99}">
						<input type="button" class="write_btn" id="writeBtn" value="등록" />
					</c:if>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/employees.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>