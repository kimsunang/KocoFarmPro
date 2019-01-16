<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/KocofarmPro/css/common.css" />
<link rel="stylesheet" type="text/css" href="/KocofarmPro/css/approval.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
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

</head>
<body>
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style>
td {
	text-align: center;
}

h1 {
	text-align: center;
}
</style>
	<form action="insertDraft.do" method="post">
		<div class="vacation_wrap">
			<div class="title">
				<h1>�� �� �� û ��</h1>
			</div>
			
			<!-- vacation table ���� -->
			<div class="vac_table">
				<table width=1200 border=1 cellpadding=0 cellspacing=0
					align="center">

					<tr>
						<td rowspan="2">��ȼ� ����</td>
						<td>��ȼ� ����</td>
						<td colspan="3"><input type="text" name="draftTitle" size=65></td>
						<td>��� ��¥</td>
						<td colspan="3">draft_date</td>


					</tr>
					<tr>
						<!-- ��ȼ� ���� -->
						<td>��ȼ� ���</td>
						<td colspan="3"><select name="formId" value="formId">
								<option value="1">�������</option>
								<option value="2">����</option>
								<option value="3">�쿧</option>
								<option value="4">�ް���û��</option>
								<option value="5">�����ް���û��</option>

						</select></td>
						<td>��������</td>
						<td colspan="3"><input type="text" name="draftYear"></td>
					</tr>

					<tr>
						<td rowspan="3">���� ����</td>
						<td>�Ҽ� �μ�</td>
						<td colspan="7">�Ҽ��̸�</td>
					</tr>
					<tr>

						<td>����</td>
						<td colspan="7">�����̸�</td>
					</tr>
					<tr>

						<td>����</td>
						<td colspan="7">emp_name</td>
					</tr>
					<tr>
						<td rowspan="4">��û����</td>
						<td rowspan="3">�ް���û</td>
						<td>�ް�����</td>
						<td colspan="6">
						<input type="radio" name = "vacation" checked value="sick">����
						<input type="radio" name = "vacation" value="beforenoon"> ���� ����
						<input type="radio" name = "vacation" value="afternoon"> ���� ����
						<input type="radio"	name = "vacation" value="allday"> ����
						</td>
					</tr>
					
					<tr>
						<!-- ��û����   -->
						<!-- �ް���û   -->
						<td>�ް� ����</td>
						<td>���۳�¥</td>
						<td><input type="text" id="Startdatepicker" name = "vacationStartDt" data-date-format='yy-mm-dd' >

						<td>�� ��¥</td>
						<td><input type="text" id="Enddatepicker" name = "vacationEndDt" data-date-format='yy-mm-dd' 	>
						<td>�� �� ��</td>
						<td><input type="text" name="vacationDays"></td>
					</tr>

					<tr>
						<!-- ��û����   -->
						<!-- �ް���û   -->
						<td>��ü�ٹ���</td>
						<td>id</td>
						<td><input type="text" name="replaceId">
						<td>�̸�</td>
						<td><input type="text" name="replaceName">
						<td>����</td>
						<td><input type="text" name="replacedeg">
					</tr>
					<tr>
						<!-- ��û����   -->
						<td>�� û �� �� <Br>(���� ���� ����)
						</td>
						<!-- ���γ������   -->
						<td colspan="7"><textarea rows="6" cols="120"
								name="vacationReason">
							���� ���� ����
							</textarea></td>

					</tr>


				</table>
			</div>
			<!-- vacation table �� -->

			<div>
				<!-- <input type = "submit" value = "�����ϱ�" > -->
				<CENTER><input type="submit" value="����"></CENTER>
			</div>
		</div>
	</form>
</body>
</html>
</body>
</html>