<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> -->
<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- </head> -->
<body >
<form action="" id ="rentCarDetailForm" >
	<input type = "hidden" name = "mode" id = "mode" value = "${param.mode} }"/> 
	<input type = "hidden" name = "car_id" id = "car_id" value = "${rentCarDetail.carId}"/>
	<table class = "conentsView" id = "rentCarDetailView">
			<colgroup>
					<col width="20%">
					<col width="*">
			</colgroup>
				<tbody>
					<tr>
						<th scope="col">차량번호 </th>
						<td class="left">${rentCarDetail.carId }</td>
					</tr>
					<tr>
						<th scope="col">차량모델명</th>
						<td class="left">${rentCarDetail.modelName }</td>
					</tr>
					<tr>
						<th scope="col">차종</th>
						<td class="left">${rentCarDetail.carModel }</td>
					</tr>
					<tr>
						<th scope="col">구입조건</th>
						<td class="left">${rentCarDetail.condition }</td>
					</tr>
					<tr>
						<th scope="col">가격</th>
						<td class="left">${rentCarDetail.price } 만원</td>
					</tr>
					<tr>
						<th scope="col">연식</th>
						<td class="left">${rentCarDetail.year} 년</td>
					</tr>
					<tr>
						<th scope="col">유종</th>
						<td class="left">${rentCarDetail.oilType }</td>
					</tr>					
		</table>

</form>	

	<br> 
	<input type="button" value="수정" id = "updateForm">
	<input type="button" value="삭제" id = "delete">
	
<script type="text/javascript" src="/KocoFarmPro/js/module/rent.js"></script>
</body>
<!-- </html> -->