<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
			<!-- basic draft input  -->
			<div class="draft_wrap">
				<h1 class="txt_c">기본 정보</h1>
				<div class ="inf_wrap_box">
					<p class="name"><b>이름</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;김선행
					<p class="position"><b>직위</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사원
					<p class="dep"><b>부서</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<p class="form"><b>양식</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${form.modeName }		 
				</div>
				<p></p>
				<p></p>
			</div>
		
			<!-- list -->
			<div class="contents">
				<!-- 기안서 보기 -->
				<form action="insertDraft.do" method="post">
					<div class="vacation_wrap">
						<div class="title">
							<h1 class="txt_c">휴 가 신 청 서</h1>
						</div>
						
						<!-- 입력 폼 시작 -->
						<div class="input_wrap">
							<div class = "input_draft">
							<h2 class="txt_c">기안서 정보</h2>
							
							 <table class="draft" border = "0" width = "1000">
							 	<colgroup>
							 		<col width="25%" />
							 		<col width="*" />
							 	</colgroup>
							 	<tr>
							 		<th class="inputText" scope="col"> 기안서 제목 </th>
							 		<td><input type="text" name="draftTitle"> </td>
							 	</tr>
							 	<tr>
							 		<th class="inputText" scope="col"> 보존 년한 </th>
							 		<td> <input type="text" name="draftYear"> </td>
							 	</tr>
							 </table>
							 
							 <h2 class="txt_c">휴가 신청 내용</h2>
							 <table class ="draft">
								 <colgroup>
							 		<col width="20%" />
							 		<col width="20%" />
							 		<col width="20%" />
							 		<col width="20%" />
							 	</colgroup>
							 	<tr>
							 		<th class="inputText">휴가 종류</th>
							 		<td colspan="3">
								 		<input type="radio" name = "vacationType" checked value="병가">병가
										<input type="radio" name = "vacationType" value="오전반차"> 오전 반차
										<input type="radio" name = "vacationType" value="오후반차"> 오후 반차
										<input type="radio"	name = "vacationType" value="연차"> 연차
									</td>
							 	</tr>
							 	
							 	<tr>
							 		<th class="inputText">시작 날짜</th>
							 		<td><input type="text" id="Startdatepicker" name = "vacationStartDt" class="date" readonly=readonly /> </td>
							 		<th class="inputText">종료 날짜</th>
							 		<td><input type="text" id="Enddatepicker" name = "vacationEndDt" class="date" readonly=readonly /></td>
							 	</tr>
							 	<tr>
							 		<th class="inputText">총 일수 </th>
							 		<td colspan="3"><input type="text" name="vacationDays"></td>
							 	</tr>
							 	
							 	<tr>
							 		<th colspan="4" class="inputText txt_c" >신청 사유<span class="sub_txt"> (세부 내용을 기재 해 주세요.)</span></th>
							 	</tr>
							 	
							 	<tr>
							 		<td colspan="4" class="inputText txt_c">
							 			<textarea rows="6" cols="120" name="vacationReason" class="wth100p"></textarea>
									</td>
							 	</tr>
							 	</table>
							 	
							 	<h2 class="txt_c">대체 근무자 정보</h2>
							 	<table class ="draft">
								 	<colgroup>
								 		<col width="20%" />
								 		<col width="*%" />
								 	</colgroup>
								 	<tr>
								 		<th class="inputText" scope="col">이름</th>
								 		<td><input type=text name="replacementId"></td>
								 	</tr>
								 	
								 	<tr>
								 		<th class="inputText" scope="col">직위</th>
								 		<td>자동 입력</td>
								 	</tr>
								 	
								 	<tr>
								 		<th class="inputText" scope="col">핸드폰 번호</th>
								 		<td>자동 입력</td>
								 	</tr>
							 	</table>
							
							</div><!-- input_draft -->
						
						</div><!-- input_wrap -->
						<!-- vacation table 끝 -->
			
						<div class= flt_r>
						<br><br>
							<!-- <input type = "submit" value = "저장하기" > -->
							<input type="submit" class="submitBtn" value="제출">
							<br><br>
						</div>
					</div>
				</form>
			</div>
		
		</div>

<script type="text/javascript" src="/KocoFarmPro/js/module/approval.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>