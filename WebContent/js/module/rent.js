$(function(){
	
	
	//차량등록
	$("#enroll").click(function() {
		if(confirm("등록하시겠습니까?")){
			//여기에 유효성 겁사 - 함수 만들기
			chkReq();				
									
		}
		return false;
	})
	
	//수정버튼 눌렀을 떄
	$("#updateForm").click(function() {
		/*위치이동*/
		location.href = "rentCarDetailEditForm.do?car_id="+$("#car_id").val()
		
		/*여기에 삽입해 봄*/
		
		
		return false;
	})
	
	
	

	//수정시, 체크박스 값 유지 -- 이거 할지, 말지 고민해 보기(시간관계상)
	function test(){
	
		
		$("input[name = 'carModel']").each(function() {
			var thisVal = $(this).val();
			if(thisVal.length>0){
				$(this).attr("checked", true)
			}
		})
		
		$("input[name = 'condition']").each(function() {
			var thisVal = $(this).val();
			if(thisVal.length>0){
				$(this).attr("checked", true)
			}
		})
		
		$("input[name = 'oil_Type']").each(function() {
			var thisVal = $(this).val();
			if(thisVal.length>0){
				$(this).attr("checked", true)
			}
		})
		
		
	}
	
	
	//수정내용 등록
	$("#Upenroll").click(function() {
		if(confirm("수정완료 하시겠습니까?")){
			
			chkReq2();
		}
		return false;
	})
	
		
	
	
	//삭제
	$("#delete").click(function() {
		if(confirm("삭제하시겠습니까?")){
			/*페이지 이동*/
			location.href = "rentCarDetailDelAction.do?car_id=" +$("#car_id").val()
			
		}	
	})
	
	
	
	/*
	//차량번호 - 중복확인(ajax 이용)
	$("#checkCar_Id").click(function() {
		$.ajax({
			type : "POST",
			url : 'KocoFarmPro/rentCarDetailWriteForm.do',
			dataType : "json",
			error : function(){
				alert("통신실패");
			},
			success : function() {
				alert('통신성공')
			}
		})
		
	})*/
	
	/*Ajax 호출*/
	$("#checkCar_Id").click(function(){
		var ajaxMode = "getCarId";
		$.ajax({
			"url" : "getCarAjaxData.do",
			"data" : {
					"id" : $("#car_id").val(),
					"ajaxMode" : ajaxMode
			},
			dataType : "json",
			success : function(data){
				
				if(1 == data[0]){
					alert("이미 존재하는 아이디 입니다.\n 새로운 아이디를 입력 해 주세요.");
					$("#car_id").val("");
					$("#car_id").focus();
				}
				

			}	
		})

		
	}
	
	
	)


});/*전체function 괄호*/





//등록 필수 값 체크
function chkReq(){
	if($("#car_id").val() == null || $("#car_id").val() == "" ){
		alert("차량번호를 입력해주세요.");
		$("#car_id").focus();
		return false;
	}
	
	//차량번호 유효성 검사
	if($("#car_id").val() != '^[가-힣\s]+$')
	
	if($("#modelName").val() == null || $("#modelName").val() == "" ){
		alert("차량모델명을 입력해주세요.");
		$("#modelName").focus();
		return false;
	}
	
	
	if($('input[name = "carModel"]:checked').val() == null || $('input[name = "carModel"]:checked').val() == "" ){
		alert("차종을 선택해주세요.");
		$("#carModel").focus();
		return false;
	}
	
	
	if($('input[name = "condition"]:checked').val() == null || $('input[name = "condition"]:checked').val() == "" ){
		alert("구입조건을 선택해주세요.");
		$("#condition").focus();
		return false;
	}
	
	if($("#price").val() == null || $("#price").val() == "" ){
		alert("가격을 입력해주세요.");
		$("#price").focus();
		return false;
	}
	
	if($("#year").val() == null || $("#year").val() == "" ){
		alert("연식을 입력해주세요.");
		$("#year").focus();
		return false;
	}
	
	if($('input[name = "oil_Type"]:checked').val() == null || $('input[name = "oil_Type"]:checked').val() == "" ){
		alert("유종을 선택해주세요.");
		$("#oil_Type").focus();
		return false;
	}
	
	
	/*if( $("#car_id").val() == null && $("#modelName").val() == null
			&& $('input[name = "carModel"]:checked').val() == null
			&& $('input[name = "condition"]:checked').val() == null
			&& $("#price").val() == null
			&& $("#year").val() == null
			&& $('input[name = "oil_Type"]:checked').val() == null
	){
		location.href= "rentCarDetailWrite.do"	
	}*/
	
	
	
	var mode = $("#mode").val();
	if("write" == mode){
		$('#rentCarWriteForm').attr("action", "rentCarDetailWrite.do")
		$("#rentCarWriteForm").submit()
	
	}
	
	
}

//수정 필수값 체크
function chkReq2(){
	
	if($("#modelName").val() == null || $("#modelName").val() == "" ){
		alert("차량모델명을 입력해주세요.");
		$("#modelName").focus();
		return false;
	}
	
	
	if($('input[name = "carModel"]:checked').val() == null || $('input[name = "carModel"]:checked').val() == "" ){
		alert("차종을 선택해주세요.");
		$("#carModel").focus();
		return false;
	}
	
	
	if($('input[name = "condition"]:checked').val() == null || $('input[name = "condition"]:checked').val() == "" ){
		alert("구입조건을 선택해주세요.");
		$("#condition").focus();
		return false;
	}
	
	if($("#price").val() == null || $("#price").val() == "" ){
		alert("가격을 입력해주세요.");
		$("#price").focus();
		return false;
	}
	
	if($("#year").val() == null || $("#year").val() == "" ){
		alert("연식을 입력해주세요.");
		$("#year").focus();
		return false;
	}
	
	if($('input[name = "oil_Type"]:checked').val() == null || $('input[name = "oil_Type"]:checked').val() == "" ){
		alert("유종을 선택해주세요.");
		$("#oil_Type").focus();
		return false;
	}
	
	var mode = $("#mode").val();
	if (mode == "edit" ) { 
		$('#rentCarEditForm').attr("action", "rentCarDetailEdit.do")
		$("#rentCarEditForm").submit()
	}
}

//유효성검사 함수 - 예외처리
function isvalid(){
	var car_id = //
	//차량번호
	functop
	
	//차량이름
	
}