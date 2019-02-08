
<%@ page import="kosta.model.module.vo.ScheduleCategory"%>
<%@ page import="kosta.model.module.vo.ScheduleCalender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/jsp/comm/top.jsp" flush="false"></jsp:include>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.lang.Integer"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
var jb = jQuery.noConflict();
$( function() {
	 jb.datepicker.setDefaults({
	        dateFormat: 'yy-mm-dd',
	        prevText: '이전 달',
	        nextText: '다음 달',
	        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	        showMonthAfterYear: true,
	        yearSuffix: '년'
	    });
	 
	  jb( "#addDatepickerStart").datepicker({
		  dateFormat: "yy-mm-dd"
	  });
	  jb( "#addDatepickerEnd").datepicker({
		  dateFormat: "yy-mm-dd"
	  });
	  jb( "#editDatepickerStart").datepicker({
		  dateFormat: "yy-mm-dd"
	  });
	  jb( "#editDatepickerEnd").datepicker({
		  dateFormat: "yy-mm-dd"
	  });
});
</script>

<link href="/KocoFarmPro/css/module/schedule.css" rel="stylesheet"
	type="text/css">
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {		
		/* 일정 추가 진행상황% 슬라이더  */
		var calenderCompletionSlider = document.getElementById("calenderCompletionPerRang");
		var calenderCompletionOutput = document.getElementById("calenderCompletionPerVal");

		calenderCompletionSlider.oninput = function() {
			calenderCompletionOutput.value = this.value;
		}
		/* 일정 추가 진행상황% textbox */
		$('#calenderCompletionPerVal').change(function(){
			var value = $(calenderCompletionOutput).val() ;
			if(false == isNaN(value)){
				if(0 > value) value = 0;
				if(100 < value) value = 100;
				$(calenderCompletionSlider).val($(this).val());
				$(calenderCompletionOutput).val($(this).val());
			}else{
				$(calenderCompletionSlider).val(0);
				$(calenderCompletionOutput).val(0);
			}
		});


		/* 일정 수정 진행상황% 슬라이더  */
		var editCalenderCompletionSlider = document.getElementById("editCalenderCompletionPerRang");
		var editCalenderCompletionOutput = document.getElementById("editCalenderCompletionPerVal");

		editCalenderCompletionSlider.oninput = function() {
			editCalenderCompletionOutput.value = this.value;
		}

		/* 일정 수정 진행상황% textbox */
		$('#editCalenderCompletionPerVal').change(function(){
			var value = $(editCalenderCompletionOutput).val() ;
			if(false == isNaN(value)){
				if(0 > value) value = 0;
				if(100 < value) value = 100;
				
				$(editCalenderCompletionSlider).val($(this).val());
				$(editCalenderCompletionOutput).val($(this).val());
				
			}else{
				$(editCalenderCompletionSlider).val(0);
				$(editCalenderCompletionOutput).val(0);
			}
		});
			
		var projectId = "${projectId}";
		add_project_id = projectId;
		$.ajax({
			url : 'listCalender.do',
			data : {
				"projectId" : projectId
			},
			dataType : 'json',
			success : function(data) {

				addDynamicHtml(data);
			}// success function

		});// ajax
	});
</script>

	<div class="con">
	</div>
	
	<!-- 일정 추가 -->
	<div class="modal fade" id="calenderAddModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">일정추가</h4>
				</div>				
				<div class="modal-body">
					<label>새 일정 추가</label> <input type="text" name="write"></input>
					<div>
						<div>시작날짜 <input type="text" name="addDatepickerStart" id="addDatepickerStart"/></div>
						<div>종료날짜 <input type="text" name="addDatepickerEnd" id="addDatepickerEnd"/></div>	
					</div>
					<div>
						<label>캘린더 칼라</label>
					</div>
					<div>
					 	<input type="button" class="tag-important btn btn-xs" value="red"/>
					  	<input type="button" class="tag-approve btn btn-xs" value="green" />
					   	<input type="button" class="tag-quickly btn btn-xs" value="blue" />
					   	<input type="button" class="tag-request btn btn-xs" value="yellow" />
					</div>
					<div>
						<label>진행상황</label>
						<div class="add-calender-slidecontainer">
						  <input type="range" min="1" max="100" value="50" class="add-calender-slider" id="calenderCompletionPerRang">
  						  <input type="text" name="addCompletionPer" id="calenderCompletionPerVal"></input>
						</div>
					</div>
					<div>
						<button class="btn btn-warning" name="tag">태그 선택</button>
					</div>
					<div>
						<button class="btn btn-secondary" name="worker_list">작업자
							선택</button>
					</div>
					<button class="btn btn-primary" id="calender_add">일정 추가</Button>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- 일정 수정 -->
	<div class="modal fade" id="calenderModify" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">일정수정</h4>
				</div>
				<div class="modal-body">
					<label>일정 내용</label> <input type="text" name="write"></input>
					<div></div>
						시작날짜 <input type="text" name="editDatepickerStart" id="editDatepickerStart"/>
					<div></div>
						종료날짜 <input type="text" name="editDatepickerEnd" id="editDatepickerEnd"/>	
					<div>
						<label>캘린더 칼라</label>
					</div>
					<div>
					 	<input type="button" class="tag-important btn btn-xs" value="red"/>
					  	<input type="button" class="tag-approve btn btn-xs" value="green" />
					   	<input type="button" class="tag-quickly btn btn-xs" value="blue" />
					   	<input type="button" class="tag-request btn btn-xs" value="yellow" />
					</div>
						<label>진행상황</label>
						<div class="edit-calender-slidecontainer">
						  <input type="range" min="1" max="100" value="50" class="edit-calender-slider" id="editCalenderCompletionPerRang">
  						  <input type="text" name="editCompletionPer" id="editCalenderCompletionPerVal"></input>
						</div>
					<div>
						<button class="btn btn-warning" name="tag">태그 선택</button>
					</div>
					<div><button class="btn btn-secondary" name="worker_list">작업자 선택</button></div>
					<button class="btn btn-primary" id="calender_edit">일정 수정</Button>
					<button type="button" class="btn btn-danger" id="calender_del">일정 삭제</button>
				</div><!-- myBody -->
				<!-- body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div><!-- body -->	
			</div><!-- modal-content -->
		</div><!-- modal-dialog -->
	</div>
	
	<!-- 카테고리 삭제. 하위 일정도 같이 삭제됨 -->
	<div class="modal fade" id="categoryDeleteModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">카테고리 삭제</h4>
				</div>
				<div class="modal-body">
					<p>카테고리 하위 일정이 전부 삭제됩니다.</p>
					<p>정말 삭제하시겠습니까?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal" id="delete-project-button">삭제</button>
				</div>
			</div>
		</div>
	</div>
	<script src="/KocoFarmPro/js/module/schedule.js"></script>
</html>
