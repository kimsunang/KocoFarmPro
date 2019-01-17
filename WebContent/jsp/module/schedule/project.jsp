
<%@ page import="kosta.model.module.vo.ScheduleCategory" %>
<%@ page import="kosta.model.module.vo.ScheduleCalender" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.lang.Integer"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>jQuery dropMe Plugin Examples</title>


  
<link href="/KocoFarmPro/css/module/schedule.css" rel="stylesheet" type="text/css">
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
<script type="text/javascript">
	
$(function(){
	console.log('들어온다?');
	console.log("${projectId}");
	var projectId = "${projectId}";
	console.log('출력');
	$.ajax({
		url:'listCalender.do',
		data: {"projectId":projectId},
		dataType:'json',
		success:function(data){
		console.log("성공");
		

		var html = "";
		var categoryId = -1;			// 카테고리 아이디 저장
		
	    for(var i=0; i<data.length; i++){
	      	//console.log(data[i]);
	      	
	      	// 카테고리 id가 다르면 새로운 카테고리생성
	      	if(categoryId != data[i].categoryId){
	      		if(0 != i)
		      		html += '</ul>';
	
	      		html += '<ul class="li_common_style li1">';
	      		html += '<li class="calender_info">';
	      		html += '<button type="button" class="calenderWriteBtn">버튼 </button>';
	      		html += data[i].categoryName+'<button type="button" class="btn  btn-primary calenderWriteBtn">+</button>';
	      		console.log(data[i].projectId);
	      		console.log(data[i].categoryId);
	      		console.log(data[i].calenderId);
	    		html += '<input type="hidden" class="this_project_id" value='+data[i].projectId+' />';
	      		html += '<input type="hidden" class="this_category_id" value='+data[i].categoryId+' />';
	      		html += '</li>';
	    		categoryId = data[i].categoryId;
	      		
	      	}
	      	
	      	// 캘린더 id가 0이 아니라면
	      	if(0 != data[i].calenderId){
	            html += '<li class="calender_text">'+data[i].title+"<br>";
	            html += '시작일 :'+ data[i].startDt+"<br>";
	            html += '종료일 :'+ data[i].endDt+"<br>";
				html += '</li>';	      		
	      	}
	    }//for문

			// 동적으로 생성된 element 이벤트 붙이기
			html += '</ul>';
		    $(".con").append(html); 
		    
		    $('.dropme').dropme('enable');
		    $('.exclude').dropme({
		    	items: ':not(.disabled)'
		    });
		    $('.li_common_style').dropme({
		    	linkTo: '.connected'
		    });

		    // 일정 추가 버튼 클릭
		   $(document).on("click", ".calenderWriteBtn", function(){				   
				var par = $(this).parent();	// ul태그 선택
				add_project_id = $(par).children().eq(2).val();
				add_category_id = $(par).children().eq(3).val();

				console.log('project_id:'+add_project_id);
				console.log('category_id:'+add_category_id);
				
			   calenderAddButtonClick(add_project_id,add_category_id);
			});
	    
		}// success function

	});// ajax
});

</script>
</head>
<body>

<div class="con">

</div>

<!-- 일정추가 창 -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
  
<!-- <form> -->
 <div class="form-group">
    <label>새 일정 추가</label>
    <input type="text" name="write"></input>
  </div>
	<div><button type="button" class="btn btn-success">날짜 선택</button></div>
	<div><label>칼라 입력</label></div>
	<input type="text" name="color"></input>
	<div><label>완료도 설정</label></div>
	<input type="text" name="completion_per"></input>
	<div><button class="btn btn-warning" name="tag">태그 선택</button></div>
	<div><button class="btn btn-secondary" name="worker_list">작업자 선택</button></div>
<!--  <div class="form-check">-->
  <Button class="btn btn-primary" id="calender_add">일정 추가</Button>
<!--    </div>-->
  
<!--</form> -->
</div>
  
</div>
<script src="http://code.jquery.com/jquery-1.12.2.min.js"></script> 
<script src="/KocoFarmPro/js/module/schedule.js"></script>
</body>
</html>
