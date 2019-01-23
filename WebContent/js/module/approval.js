$(function() {
		/*$('#Startdatepicker').datepicker({
			onSelect : function(dateText, inst) {
				$("input[name='vacationStartDt']").val(dateText);
			},
			dateFormat :'yy-m-dd'
			
		});
	
		$("#Enddatepicker").datepicker({
			onSelect : function(dateText, inst) {
				$("input[name='vacationEndDt']").val(dateText);
			},
			dateFormat :'yy-m-dd'
		});

		$("#modifyBtn").click(function(){
			location.href="UpdateDraft.do?draftId=${draft.draftId}";
			return false;
		});
		
		$("#deleteBtn").click(function(){
			location.href="DeleteDraft.do?draftId=${draft.draftId}";
			return false;
		});*/


		/* datePicker */
		$("#Startdatepicker, #Enddatepicker, #expenceDt").datepicker({
			showMonthAfterYear : true,
			showButtonPanel : true,
			changeMonth : true,
			changeYear : true,
			nextText : '다음 달',
			prevText : '이전 달',
			currentText : '오늘 일',
			closeText : '닫기',
			dateFormat : 'yy-mm-dd',
			dayNames : ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],
			dayNamesMin : ['일','월','화','수','목','금','토'],
			monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			monthNamesShort : ['1','2','3','4','5','6','7','8','9','10','11','12'],
		});
		
});		