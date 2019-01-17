<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>


	$(function() {

		$('#Startdatepicker').datepicker({
			onSelect : function(dateText, inst) {
				$("input[name='vacationStartDt']").val(dateText);
			},
			dateFormat :'yy-m-dd'
			
		})
	});

	$(function() {
		$("#Enddatepicker").datepicker({
			onSelect : function(dateText, inst) {
				$("input[name='vacationEndDt']").val(dateText);
			},
			dateFormat :'yy-m-dd'
		})
	});
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
			<style>
				td {
					text-align: center;
				}
				
				h1 {
					text-align: center;
				}
			</style>
			<div class="contents">
				<!-- 기안서 보기 -->
				<form action="" method="post">
				<div class="expence_wrap">
					<div class="title" align="center">
						<h1>지 출 결 의 서</h1>
					</div>
					<!-- 지출결의서 내용 -->
					<div class="exp_table">
						<table width=600 height="800" border=1 cellpadding=5 cellspacing=0
							align="center">
							<tr>
								<td colspan="3">기안서 번호</td>
								<td><input type="text" style="text-align: center"></td>
								<td colspan="3">기안서 이름</td>
								<td><input type="text" style="text-align: center"></td>
							</tr>
		
							<tr>
								<td colspan="3">기안서 제목</td>
								<td><input type="text" style="text-align: center"></td>
								<td colspan="3">등록 날짜</td>
								<td><input type="text" value="sysdate"
									style="text-align: center"></td>
							</tr>
		
							<tr>
								<td colspan="3">기안서 양식</td>
								<td style="text-align: center"><select name="schType"
									value="schType">
										<option value='' selected>-- 양식 --</option>
										<option value="all">지출명세서</option>
										<option value="2">히잇</option>
										<option value="3">헤엣</option>
										<option value="4">휴가신청서</option>
										<option value="5">유급휴가신청서</option>
		
								</select></td>
								<td colspan="3">보존년한</td>
								<td><input type="text"></td>
							</tr>
		
							<tr>
								<td colspan="3">소속부서</td>
								<td style="text-align: center"><select name="" value=""
									style="text-align: center">
										<option value='' selected>-- 부서 --</option>
										<option value="11">기술부</option>
										<option value="22">인사부</option>
										<option value="33">순두부</option>
										<option value="44">대두부</option>
										<option value="55">국두부</option>
		
								</select></td>
		
		
								<td colspan="3">직급</td>
								<td><select name="" value="">
										<option value='' selected>-- 직급 --</option>
										<option value="111">사원</option>
										<option value="222">대리</option>
										<option value="333">과장</option>
										<option value="444">차장</option>
										<option value="555">부장</option>
										<option value="666">팀장</option>
										<option value="777">상무</option>
		
								</select></td>
		
							</tr>
		
							<tr>
								<td colspan="3">이름</td>
								<td><input type="text" style="text-align: center"></td>
								<td colspan="3">결제날짜</td>
								<td><input type="text" id="datepicker"
									style="text-align: center"></td>
							</tr>
		
							<tr>
								<td colspan="8" align="center">내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;역</td>
		
							</tr>
		
		
							<tr style="text-align: center">
								<td width="200" colspan="3">거래처이름</td>
								<td colspan="1">결제금액</td>
								<td width="200" colspan="3">수수료여부</td>
								<td colspan="1">수수료금액</td>
		
							</tr>
		
		
							<tr height="300" valign="top">
								<td colspan="3"><input type="text" size="20"
									style="text-align: center"> <input type="text" size="20"
									style="text-align: center"> <input type="text" size="20"
									style="text-align: center"> <input type="text" size="20"
									style="text-align: center"> <input type="text" size="20"
									style="text-align: center"></td>
								<td><input type="text" size="20" style="text-align: right">
									<input type="text" size="20" style="text-align: right"> <input
									type="text" size="20" style="text-align: right"> <input
									type="text" size="20" style="text-align: right"> <input
									type="text" size="20" style="text-align: right"></td>
								<td colspan="3"><select>
										<option value='' selected>-- Y or N --</option>
										<option value="1111">Y
										<option value="2222">N
								</select></td>
								<td><input type="text" style="text-align: right"> <input
									type="text" style="text-align: right"> <input type="text"
									style="text-align: right"> <input type="text"
									style="text-align: right"> <input type="text"
									style="text-align: right"></td>
							</tr>
		
							<tr style="text-align: center">
								<td colspan="4">합계</td>
								<td colspan="4"><input type="text"></td>
		
							</tr>
							<tr>
								<td height="150" colspan="8">
									<div align="center">
										<p>위 금액을 영수(청구) 합니다.</p>
										<p>
											<input type="text" id="datepicker1">
										</p>
										<p>
											영수자 :&nbsp;<input type="text" size="10"> (인)
										</p>
									</div>
								</td>
		
							</tr>
		
						</table>
		
					</div>
				</div>
			</form>
			</div>
		
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/approval.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>