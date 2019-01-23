<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 --><head>
<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> <!-- onload = "javascript:test()" --> 
	<!-- <form action="rentCarDetailEdit.do" method="post"> --> <!-- 주소 수정해주기 -->
	<form action="" method = "post" id = "rentCarEditForm">
		<input type="hidden" name="mode" id="mode" value="edit" />
		<input type="hidden" name="car_id" value="${rentCarDetail.carId }">
			
		
		차량모델명 : <input type = "text" name = "modelName" id="modelName" value="${rentCarDetail.modelName }"><br>
		차종 : <%-- <input type = "hidden" name = "carModel" value="${rentCarDetail.carModel }"> --%>
		<!-- 여기서 input type을 text가 아닌, check box로 넣기 -->
				<input type = "radio" name="carModel" value = "싼타페">싼타페
				 <input type = "radio" name="carModel" value = "레이">레이
				 <input type = "radio" name="carModel" value = "SM3">SM3
				 <input type = "radio" name="carModel" value = "k3">k3				 				 			 			
			<br>
		
		구입조건 : <%-- <input type = "hidden" name = "condition" value="${rentCarDetail.condition }"> --%>
				<input type = "radio" name="condition" value="신차" >신차
				<input type = "radio" name="condition" value="중고차">중고차			
			<br>
		
		가격 : <input type = "text" name = "price" id="price"  value="${rentCarDetail.price }"><br>
		연식 : <input type = "text" name = "year" id = "year" value="${rentCarDetail.year }"><br>
		유종 : <%-- <input type = "hidden" name = "oil_Type" value="${rentCarDetail.oil_Type }"> --%>	
			 <input type = "radio" name="oil_Type" value="휘발유">휘발유
			 <input type = "radio" name="oil_Type" value="경유">경유
			<br>
				
		<input type="button" value="수정완료" id = "Upenroll">
	</form>
	
	<script type="text/javascript" src="/KocoFarmPro/js/module/rent.js"></script>	
</body>
<!-- </html> -->
