<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>차량번호: ${rentCarDetail.car_id }</li>
		<li>차량모델명 : ${rentCarDetail.modelName }</li>
		<li>차종: ${rentCarDetail.carModel }</li>
		<li>구입조건: ${rentCarDetail.condition }</li>
		<li>가격: ${rentCarDetail.price } 만원</li>
		<li>연식: ${rentCarDetail.year} 년</li>
		<li>유종: ${rentCarDetail.oil_Type }</li>

	</ul>
	<br> 
	<a href="rentCarDetailEditForm.do?car_id=${rentCarDetail.car_id}">수정하기</a> <!-- 주소값 넣어주기 -->
	<a href="rentCarDetailDelAction.do?car_id=${rentCarDetail.car_id} %>">삭제하기</a> <!-- 주소값 넣어주기 -->
	
	

</body>
</html>