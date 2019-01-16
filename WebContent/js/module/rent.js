$(function(){
	
	//차량등록 - rentCarDetailWrite 체크박스 중복설정 제거
	$('input[type = "checkbox"][name = "carModel"]').click(function(){
		//클릭이벤트 발생한 요소가 체크 상태인 경우 - 
		if($(this).prop('checked')){
			//체크박스 그룹의 요소 전체를 체크 해제한 후 클릭한 요소 체크 상태 지정
			$('input[type="checkbox"][name="carModel"]').prop('checked', false);
            $(this).prop('checked', true);
		}
		
	})
	
})