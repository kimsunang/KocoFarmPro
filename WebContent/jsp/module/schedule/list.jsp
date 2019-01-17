<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/schedule.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Schedule <span>일정 관련 내용을 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">일정 관리</li>
					</ul>
				</div>
			</div>
		</div>
	
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- sch_top -->
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
						<tr>
							<td>project_id</td>
							<td>title</td>
							<td>project_leader</td>
							<td>emp_id</td>
							<td>project_start_dt</td>
							<td>project_end_dt</td>
							<td>project_reg_dt</td>
							<td>project_completion</td>
							<td>public_project</td>							
						</tr>
						
					<c:forEach var="project" items="${projectList}">
						<!-- 링크를 post방식으로 전달하기 위해 사용 -->
				
						<tr>
							<td>${project.projectId}</td>
							<td>
								<form id="responeProjectId" action="sendProjectId.do" method="POST">
							 	<button type="submit" form="responeProjectId" value="Submit"> ${project.title}</button>
								<input type="hidden" name="projectId" value="${project.projectId}" />
							</form>
							</td>
							<td>${project.projectLeader}</td>
							<td>${project.empId}</td>
							<td>${project.projectStartDt}</td>
							<td>${project.projectEndDt}</td>
							<td>${project.projectRegDt}</td>
							<td>${project.projectCompletion}</td>
							<td>${project.publicProject}</td>
						</tr>
					</c:forEach>
				
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
<script type="text/javascript" src="/KocoFarmPro/js/module/schedule.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>