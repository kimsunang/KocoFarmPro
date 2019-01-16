<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
</script>
<script>
	$(function() {
		$("#datepicker1").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="insertExpenceAction.do" method="post">
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
						<td><input type="text" style="text-align: center" name="draftId"></td>
						<td colspan="3" >기안서 이름</td>
						<td><input type="text" style="text-align: center" name="draftName"></td>
					</tr>

					<tr>
						<td colspan="3">기안서 제목</td>
						<td><input type="text" style="text-align: center" name="draftTitle"></td>
						<td colspan="3">등록 날짜</td>
						<td><input type="text" value="sysdate"
							style="text-align: center" name="draftDt"></td>
					</tr>

					<tr>
						<td colspan="3">기안서 양식</td>
						<td style="text-align: center"><select name="formId" value="formId" style="text-align: center">
								<option selected>-- 양식 --</option>
								<option value="1">지출명세서</option>
								<option value="2">히잇</option>
								<option value="3">헤엣</option>
								<option value="4">휴가신청서</option>
								<option value="5">유급휴가신청서</option>

						</select></td>
						<td colspan="3">보존년한</td>
						<td><input type="text" name="draftYear"></td>
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
							style="text-align: center" name="expenceDt"></td>
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
							style="text-align: center" name="customerName" > </td>
						<td><input type="text" size="20" style="text-align: right" name="expencePrice"></td>
						<td colspan="3"><select name="commissionOption">
								<option value='' selected>-- Y or N --</option>
								<option value="Y">Y
								<option value="N">N
						</select></td>
						<td>
						<input type="text" style="text-align: right" name="commissionPrice"> 
							</td>
					</tr>

					<tr style="text-align: center">
						<td colspan="6">합계</td>
						<td colspan="2"><input type="text" name="sumPrice"></td>

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
		<div class= flt_r align="center">
						<br><br>
							<!-- <input type = "submit" value = "저장하기" > -->
							<input type="submit" value="제출">
							<br><br>
						</div>
		
		</form>		
	
		

	

</body>
</html>