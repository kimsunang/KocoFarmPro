<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="rentCarDetailEdit.do" method="post"> <!-- 주소 수정해주기 -->
		<input type="hidden" name="car_id" value="${rentCarDetail.car_id }">
			
		
		차량모델명 : <input type = "text" name = "modelName" value="${rentCarDetail.modelName }"><br>
		차종 : <input type = "text" name = "carModel" value="${rentCarDetail.carModel }"><br>
		<!-- 여기서 input type을 text가 아닌, check box로 넣기 -->
		
		구입조건 : <input type = "text" name = "condition" value="${rentCarDetail.condition }"><br>
		가격 : <input type = "text" name = "price" value="${rentCarDetail.price }"><br>
		연식 :<input type = "text" name = "year" value="${rentCarDetail.year }"><br>
		유종 : <input type = "text" name = "oil_Type" value="${rentCarDetail.oil_Type }"><br>
		
		<input type="submit" value="수정완료">
	</form>
</body>
</html>