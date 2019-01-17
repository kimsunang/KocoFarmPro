$(function() {
		$('#Startdatepicker').datepicker({
			onSelect : function(dateText, inst) {
				$("input[name='vacationStartDt']").val(dateText);
			},
			dateFormat :'yy-m-dd'
			
		})
	
		$("#Enddatepicker").datepicker({
			onSelect : function(dateText, inst) {
				$("input[name='vacationEndDt']").val(dateText);
			},
			dateFormat :'yy-m-dd'
		})
	});