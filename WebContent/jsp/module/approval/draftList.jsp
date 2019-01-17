<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/approval.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Approval <span>결재 관련 내용을 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">문서 결재</li>
					</ul>
				</div>
			</div>
		</div>
	
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- sch_top -->
			<div class="sch_wrap">
				<p class="tit">등록된 리스트</p>
				<div class="sch_toggle_wrap">
					<div class="">
						<a href="insertExpence.do">지출결의서</a>
						<p></p>
						<a href="휴가서">휴가서</a>
					</div>
				</div>
			</div>
		
			<!-- list -->
			<div class="contents">
				<!-- 목록 보기 -->
				<table class="contents_tb" id="contTb">
					<tr>
						<th>기안서 번호 </th>
						<th>기안서 제목</th>
						<th>기안서 양식 번호</th>
						<th>등록 날짜</th>
					</tr>
					
					
					<c:forEach var="ApprovalDraft" items="${list}">
						<tr>
							<td >${ApprovalDraft.draftId }</td>
							<td><a href = "DetailDraft.do?draftId=${ApprovalDraft.draftId }" >${ApprovalDraft.draftName}</a></td>
							<td>${ApprovalDraft.formId}</td>
							<td>${ApprovalDraft.draftDt }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/approval.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>