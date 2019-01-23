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
		
			<!-- list -->
			<div class="contents">
				 <div class = "tab_menu">
				 	<input id = "tab1" type = "radio" name = "tabs" checked>
				 	<label for  = "tab1"> 전체 보기</label>
				 	
				 	<input id = "tab2" type = "radio" name = "tabs">
				 	<label for  = "tab2"> 기안 중</label>
				 	
				 	<input id = "tab3" type = "radio" name = "tabs" >
				 	<label for  = "tab3"> 결재 중</label>
				 	
				 	<input id = "tab4" type = "radio" name = "tabs" >
				 	<label for  = "tab4"> 반려 </label>
				 	
				 	<input id = "tab5" type = "radio" name = "tabs" >
				 	<label for  = "tab5"> 결재 완료</label>
				 
				 	<br><br>
				 	<table class="contents_tb" id="contTb">
							<tr>
								<th width = 10%>기안서 번호 </th>
								<th width = 40%>기안서 제목</th>
								<th width = 10%>기안서 양식 번호</th>
								<th width = 20%>등록 날짜</th>
								<th width = 10%>결재 상태 </th>
							</tr>
					</table>
				 	<section id = "content1">
				 		<table class="contents_tb" id="contTb">
							<c:forEach var="ApprovalDraft" items="${list }">
								<tr>
									<td width = 10%>${ApprovalDraft.draftId }</td>
									<td width = 40%><a href = "DetailDraft.do?draftId=${ApprovalDraft.draftId }" >${ApprovalDraft.draftName}</a></td>
									<td width = 10%>${ApprovalDraft.formId}</td>
									<td width = 20%>${ApprovalDraft.draftDt }</td>
									<td width = 10%>${ApprovalDraft.approveState }</td>
								</tr>
							</c:forEach>
						</table>
				 	</section>
				 
				 	<section id = "content2">
				 		<table class="contents_tb" id="contTb">
							<c:forEach var="ApprovalDraft" items="${list }">
								<c:if test = "${ApprovalDraft.approveState eq '기안중' }">
								<tr>
									<td width = 10%>${ApprovalDraft.draftId }</td>
									<td width = 40%><a href = "DetailiDraft.do?draftId=${ApprovalDraft.draftId }" >${ApprovalDraft.draftName}</a></td>
									<td width = 10%>${ApprovalDraft.formId}</td>
									<td width = 20%>${ApprovalDraft.draftDt }</td>
									<td width = 10%>${ApprovalDraft.approveState }</td>
								</tr>
								</c:if>
							</c:forEach>
						</table>
				 	</section>
				 	
				 	<section id = "content3">
				 		<table class="contents_tb" id="contTb">
							<c:forEach var="ApprovalDraft" items="${list }">
								<c:if test = "${ApprovalDraft.approveState eq '결재중' }">
								<tr>
									<td width = 10%>${ApprovalDraft.draftId }</td>
									<td width = 40%><a href = "DetailDraft.do?draftId=${ApprovalDraft.draftId }" >${ApprovalDraft.draftName}</a></td>
									<td width = 10%>${ApprovalDraft.formId}</td>
									<td width = 20%>${ApprovalDraft.draftDt }</td>
									<td width = 10%>${ApprovalDraft.approveState }</td>
								</tr>
								</c:if>
							</c:forEach>
						</table>
				 	</section>	
				 	
				 	<section id = "content4">
				 		<table class="contents_tb" id="contTb">
							<c:forEach var="ApprovalDraft" items="${list }">
								<c:if test = "${ApprovalDraft.approveState eq '반려' }">
								<tr>
									<td width = 10%>${ApprovalDraft.draftId }</td>
									<td width = 40%><a href = "DetailDraft.do?draftId=${ApprovalDraft.draftId }" >${ApprovalDraft.draftName}</a></td>
									<td width = 10%>${ApprovalDraft.formId}</td>
									<td width = 20%>${ApprovalDraft.draftDt }</td>
									<td width = 10%>${ApprovalDraft.approveState }</td>
								</tr>
								</c:if>
							</c:forEach>
						</table>
				 	</section>
				 	
				 	<section id = "content5">
				 		<table class="contents_tb" id="contTb">
							<c:forEach var="ApprovalDraft" items="${list }">
								<c:if test = "${ApprovalDraft.approveState eq '결재완료' }">
								<tr>
									<td width = 10%>${ApprovalDraft.draftId }</td>
									<td width = 40%><a href = "DetailDraft.do?draftId=${ApprovalDraft.draftId }" >${ApprovalDraft.draftName}</a></td>
									<td width = 10%>${ApprovalDraft.formId}</td>
									<td width = 20%>${ApprovalDraft.draftDt }</td>
									<td width = 10%>${ApprovalDraft.approveState }</td>
								</tr>
								</c:if>
							</c:forEach>
						</table>
				 	</section>
				
				 </div>

				<!-- 목록 보기 -->
			
			</div>
		
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/approval.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>