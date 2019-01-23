<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/employees.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>
						Employees <span id="subTitSpan">인사 정보를 등록 할 수 있습니다.</span>
						<span class="req"> (&nbsp;*는 필수 입력 사항입니다.)</span>
					</h2>
					<ul class="sub_nav">
						<li>홈 > 인사 관리 > </li>
						<li class="on" id="subTitLi">인사 정보 등록</li>
					</ul>
				</div>
			</div>
		</div>
	
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- write -->
			<form action="" id="empForm" method="post" enctype="multipart/form-data">
				<input type="hidden" name="mode" id="mode" value="${param.mode}" />
				<input type="hidden" name="empId" id="empId" value="${emp.empId}" />
				<input type="hidden" name="fileYn" id="fileYn" value="${emp.empImg}" />
				<input type="hidden" name="managerId" id="managerId" value="" />
				<input type="hidden" name="empJobId" id="empJobId" value="${emp.jobId}" />
				<input type="hidden" name="retirementDt" id="retirementDt" value="${emp.retirementDt}" />
				<input type="hidden" name="empStDt" id="empStDt" value="${emp.startDt}" />
				<input type="hidden" name="empEnDt" id="empEnDt" value="${emp.endDt}" />

				<div class="contents">
					<!-- 등록 -->
					<table class="contents_tb wr" id="contTb">
						<colgroup>
							<col width="20%">
							<col width="30%">
						</colgroup>
						<tbody id="contentsTbBody">
							<tr>
								<th scope="col">
									<span class="req">* </span>한글 명
								</th>
								<td class="left">
									<input type="text" name="korNm" id="korNm" value="${emp.korNm}" />
								</td>
								<th scope="col">
									<span class="req">* </span>영문 명
								</th>
								<td class="left">
									<input type="text" name="engNm" id="engNm" value="${emp.engNm}" />
								</td>
							</tr>
							<tr>
								<th scope="col">
									<span class="req">* </span>이메일
								</th>
								<td class="left">
									<input type="text" name="email" id="email" value="${emp.email}" />
								</td>
								<th scope="col">
									<span class="req">* </span>핸드폰 번호
								</th>
								<td class="left">
									<input type="text" name="cellPhone" id="cellPhone" value="${emp.cellPhone}" />
								</td>
							</tr>
							<tr>
								<th scope="col">
									<span class="req">* </span>입사 일
								</th>
								<td class="left">
									<input type="text" name="hireDt" id="hireDt" value="${emp.hireDt}" readonly=readonly />
								</td>
								<th scope="col">
									<span class="req">* </span>부서 &amp; 직업
								</th>
								<td class="left">
									<select name="deptId" id="deptId" >
										<option value="">전체</option>
										<c:forEach var="deptList" items="${deptList}">
											<option value="${deptList.deptId}" ${deptList.deptId eq emp.deptId ? 'selected=selected' : ''}>${deptList.deptNm}</option>
										</c:forEach>
									</select>
									<select name="jobId" id="jobId" >
										<option value="">전체</option>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="col">
									<span class="req">* </span>직책
								</th>
								<td class="left">
									<select name="positionId" id="positionId">
										<option value="">전체</option>
										<c:forEach var="positionList" items="${positionList}">
											<option value="${positionList.positionId}" ${positionList.positionId eq emp.positionId ? 'selected=selected' : ''}>${positionList.positionNm}</option>
										</c:forEach>
									</select>
								</td>
								<th scope="col">
									<span class="req">* </span>권한
								</th>
								<td class="left">
									<select name="authority" id="authority">
										<option value="" ${"" eq emp.authority ? 'selected=selected' : ''}>전체</option>
										<option value="10" ${10 == emp.authority ? 'selected=selected' : ''}>사원</option>
										<option value="99" ${99 == emp.authority ? 'selected=selected' : ''}>관리자</option>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="col">사진</th>
								<td class="left" id="fileArea">
									<input type="file" name="fileNm" id="fileNm" class="fileInput" />
									<span id="fileTit" class="cursorP">${emp.empImg}</span>
								</td>
								<th scope="col">
									<span class="req">* </span>급여
								</th>
								<td class="left">
									<input type="text" name="salary" id="salary" value="${emp.salary}" />
								</td>
							</tr>
							<c:if test="${'edit' eq param.mode}">
							<tr>
								<th scope="col">재직 상태</th>
								<td class="left" colspan="3">
									<select name="state" id="state">
										<option value="" ${"" eq emp.state ? 'selected=selected' : ''}>전체</option>
										<option value="stay" ${"stay" eq emp.state ? 'selected=selected' : ''}>재직</option>
										<option value="loa" ${"loa" eq emp.state ? 'selected=selected' : ''}>휴직</option>
										<option value="retirement" ${"retirement" eq emp.state ? 'selected=selected' : ''}>퇴직</option>
									</select>
									<input type="text" name="startDt" id="startDt" value="" class="dp_none" readonly=readonly />
									<input type="text" name="endDt" id="endDt" value="" class="dp_none" readonly=readonly />
								</td>
							</tr>
							</c:if>
						</tbody>
					</table>
				</div>
			</form>
			
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<input type="button" class="list_btn" id="listBtn" value="목록" />
						<c:if test="${param.mode eq 'write'}">
							<input type="button" class="write_btn" id="writeProCBtn" value="등록" />
						</c:if>
						<c:if test="${param.mode eq 'edit'}">
							<input type="button" class="edit_btn" id="editProCBtn" value="수정" />
						</c:if>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/employees.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>