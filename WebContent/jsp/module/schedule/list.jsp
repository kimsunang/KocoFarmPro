<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/comm/top.jsp" flush="false"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/KocoFarmPro/css/module/schedule.css" />
<div class="cont_wrap">
	<!-- SubTitle Area -->
	<div class="sub_title">
		<div class="sub_title_top">
			<div class="sub_title_inner">
				<h2>
					Schedule <span>일정 관련 내용을 확인할 수 있습니다.</span>
				</h2>
				<ul class="sub_nav">
					<li>홈 ></li>
					<li class="on">일정 관리</li>
				</ul>
			</div>
		</div>
	</div>

	<a href="fileList.do">파일 저장소</a>

	<!-- Contents Area -->
	<div class="contents_wrap">
		<!-- sch_top -->
		<div class="sch_wrap">
			<p class="tit">검색</p>
			<div class="sch_slide_btn">
				<img id="slideBtnImg" class="upBtn"
					src="/KocoFarmPro/img/comm/list_up_btn.png" alt="메뉴 접기" />
			</div>
			<div class="sch_toggle_wrap">
				<div class="sch_box_wrap">
					<div class="right">
						<select name="schType" id="schType">
							<option value="">전체</option>
							<option value="title">제목</option>
							<option value="contents">내용</option>
						</select> <input type="text" name="schWord" id="schWord"
							placeholder="검색어를 입력 해 주세요" /> <input type="button"
							class="schBtn" id="schBtn" value="검색" />
					</div>
				</div>
			</div>
		</div>

		<!-- Tab -->
		<div class="tab_wrap">
			<ul class="tab_ul">
				<li class="tab_li on" id="rvTab">목록 보기</li>
				<li class="tab_li" id="photoTab">달력 보기</li>
			</ul>
		</div>

		<!-- project list -->
		<div class="contents">
				
		</div>
		<!-- btn -->
		<div class="btn_wrap">
			<div class="flt_r">
				<input type="button" class="list_btn" value="목록" /> <input
					type="button" class="view_btn" value="상세보기" /> <input
					type="button" class="write_btn" value="등록" /> <input type="button"
					class="edit_btn" value="수정" /> <input type="button"
					class="del_btn" value="삭제" />
			</div>
		</div>	<!-- btn_wrap -->
		
		<!-- 생성 -->
		<div class="modal fade" id="create-project-modal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">프로젝트 생성</h4>
					</div>
					<div class="modal-body">
						<p>프로젝트 이름</p>
						<input type="text" id="create-project-input"></input>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="create-project-button">생성</button>
					</div>
				</div>

			</div>
		</div> <!-- create-project-modal -->
		
		<!-- 삭제 -->
		<div class="modal fade" id="delete-project-modal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">프로젝트 삭제</h4>
					</div>
					<div class="modal-body">
						<p>정말 삭제하시겠습니까?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="delete-project-button">delete</button>
					</div>
				</div>

			</div>
		</div> <!-- delete-project-modal -->
		
		<!-- 수정 -->
		<div class="modal fade" id="modify-project-modal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">프로젝트 수정</h4>
					</div>
					<div class="modal-body">
						<p>프로젝트 이름 수정</p>
						<input type="text" id="modify-project-input"></input>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="modify-project-button">수정</button>
					</div>
				</div>

			</div>
		</div> <!-- modify-project-modal -->

	</div>	<!-- contents_wrap -->
</div>
<!-- cont_wrap -->
<script>
// 변수 모음
var selectProjectId = 0;

$(function(){
	projectListAjaxRequest();
});

// modal 창의 create 버튼
$("#create-project-button").on("click", function(){
	var sendData = {projectName:$('#create-project-input').val()};
	ajaxListRequest("insertProject.do",sendData);
	$("#create-project-input").val("");
});

//modal 창의 delete 버튼
$("#delete-project-button").on("click", function(){	
	var sendUrl = "deleteProject.do";
	var sendData = {projectId:selectProjectId};
	ajaxListRequest(sendUrl, sendData);
});

// modal 창의 modify 버튼
$("#modify-project-button").on("click", function(){	
	var title = $("#modify-project-input").val();
	var sendUrl = "editProject.do";	
	var sendData = {projectId:selectProjectId, title:title};
	
	ajaxListRequest(sendUrl, sendData);
});


function ajaxListRequest(sendUrl, sendData){
	$.ajax({
	    type:"POST",
	    data : sendData,
	    dataType:"text",
	    url:sendUrl,
	    success: function(data) {
	    	projectListAjaxRequest();
	    },
	    error : function(error) {
	    },	// error
	  });// ajax
}

function projectListAjaxRequest(){
	$.ajax({
	    type:"POST",
	    data : {},
	    dataType:"json",
	    url: "listProjectAjax.do",
	    success: function(data) {
	    	projectList(data);
	    },
	    error : function(error) {
	    },	// error
	  });// ajax
}

function projectList(data){
	 $('.contents').empty();
     $.each(data, function(index, project){
    	 
         $('.contents').append(        	
         	'<div class="project-info-style">'+
         	'<form name="enterProject" method="post" action="sendProjectId.do">'+	
	         	'<input type="hidden" name ="project_id" value='+project.projectId+' />'+
				'<div name="projectId" class="sub_title_inner h4 responeProjectId">'+project.title+'</div>'+				
					/*'<button type="submit" name="projectId" form="responeProjectId" class="sub_title_inner h2" value="'+ project.projectId +'">'+project.title+'</button>'+*/
				/* 	'</form>'+ */
					/* '</div>'+ */
					/* '<div>projectLeader:'+project.projectLeader+'</div>'+
					'<div>projectStartDt:'+project.projectStartDt+'</div>'+
					'<div>projectEndDt:'+project.projectEndDt+'</div>'+
					'<div>projectRegDt:'+project.projectRegDt+'</div>'+
					'<div>projectCompletion:'+project.projectCompletion+'</div>'+
					'<div>publicProject:'+project.publicProject+'</div>'+
					 */
			'</form>'+
			'<div>'+
			'<img src ="/KocoFarmPro/img/schedule/settings.png" class="project-setting" id="project-modify-modal-button" data-toggle="modal" data-target="#modify-project-modal" />'+
			'</div>'+	
			'<div>'+
			'<img src = "/KocoFarmPro/img/schedule/dustbin.png" id="project-delete-modal-button" class="project-setting" data-toggle="modal" data-target="#delete-project-modal" />'+	
			'</div>'+
			'</div>'
         );
     });
     
     $('.contents').append('<div>'+
     	'<button type="button" class="btn project-info-style h3" data-toggle="modal" data-target="#create-project-modal">create'+
			'project..</button>'+
			'</div>');
     
      $(document).on("click", "#project-delete-modal-button", function(event){    	
     	var parent = $(this).parent().parent().children('form[name=enterProject]');
     	var projectId = parent.children("input[name=project_id]").val();
     	selectProjectId = projectId;
     	
     	event.stopPropagation();
      });
     
     $(document).on("click", "#project-modify-modal-button", function(event){
    	 var parent = $(this).parent().parent().children('form[name=enterProject]');
      	 var projectId = parent.children("input[name=project_id]").val();
      	 selectProjectId = projectId;
      	 
      	event.stopPropagation();

     });
     
     $(document).on("click", ".project-info-style", function(){
       	 $(this).children("form").submit();
     });
}

</script>
<script type="text/javascript" src="/KocoFarmPro/js/module/schedule.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false"></jsp:include>