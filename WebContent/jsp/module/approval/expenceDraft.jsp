<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/approval.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
var no = 1;
function expenceAdd() {
		  var table = document.getElementById("expenceCont");
		  var row = table.insertRow(-1);
		  var contId = row.insertCell(0);
		  var customerName = row.insertCell(1);
		  var expencePrice = row.insertCell(2);
		  var commOpt = row.insertCell(3);
		  var commPrice = row.insertCell(4);
		 
		  contId.innerHTML =  "<input type='text' name='expence' value='"+no+"'>";
		  customerName.innerHTML = "<input type='text' name='expence'>";
		  expencePrice.innerHTML = "<input type='text' name='expence'>";
		  commOpt.innerHTML = "<input type='radio' name = 'vacationType"+no+"' checked value='yes'>yes</input><input type='radio' name = 'vacationType"+no+"' value='no'>no</input>";
		  commPrice.innerHTML = "<input type='text' name='expence'>";
		  no++;
		}

</script>

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
					<form action="insertDraft.do " method="post">
						<div class="expence_wrap">
							<div class="title" align="center">
								<h1 class="txt_c">지 출 결 의 서</h1>
							</div>
							
							<!-- 입력 폼 시작 -->
							<div class="input_wrap">
								<div class = "input_draft">
									<h2 class="txt_c">기안서 정보</h2>
								
								 	<table class="draft" border = 0px >
								 	<colgroup>
								 		<col width="25%" />
								 		<col width="*" />
								 	</colgroup>
								 	<tr>
								 		<th class="inputText" scope="col">기안서 제목</th>
								 		<td><input type="text" name="draftTitle"> </td>
								 	</tr>
								 	
								 	<tr>
								 		<th class="inputText" scope="col">보존 년한</th>
								 		<td> <input type="text" name="draftYear"> </td>
								 	</tr>
								 	</table>
									
									<h2 class="txt_c"> 지출 신청 내용 </h2>
									
									<table class="draft" border = 0px>
										<colgroup>
									 		<col width="25%" />
									 		<col width="*" />
									 	</colgroup>
										<tr>
											<th class="inputText" scope="col">결제 종류</th>
											<td>
											<select name="expenceType" value="formId">
												<option selected>-- 양식 --</option>
												<option value="법인카드 1">법인 카드 1</option>
												<option value="법인카드 2">법인 카드 2</option>
												<option value="개인카드">개인 카드</option>
											</select>
											</td>
											<th class="inputText" scope="col">결제 날짜</th>
	<!-- 										<td><input type="text" id="datepicker" name="expenceDt"></td> -->
											<td><input type="text" id="expenceDt" name="expenceDt" class="date" readonly=readonly /></td>
										</tr>
									</table>
									
									<h2 class="txt_c">지출 내역</h2>
									<input type=button value=expenceAdd onclick=expenceAdd() />			
									<table id="expenceCont" class="draft" border = 0px>
										<tr>
											<th class="inputText">번호</th>
											<th class="inputText">거래처 이름</th>
											<th class="inputText">결재 금액</th>
											<th class="inputText">수수료 여부</th>
											<th class="inputText">수수료 금액</th>
										</tr>
									</table>
															
									
									<table id="expenceCont" class="draft" border=0px>
										<tr>
											<th class="inputText">총 금액</th>
											<td colspan="2"> <input type = "text" name="sumPrice"></td>
										</tr>
									</table>
				
								</div>
							</div>

						</div>
						<div class= flt_r align="center">
							<br><br>
							<!-- <input type = "submit" value = "저장하기" > -->
							<input type="submit" class="submitBtn" value="제출">
							<br><br>
						</div>
						
						</form>		
				</div>	
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/approval.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>