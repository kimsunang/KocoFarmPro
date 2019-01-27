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

		<!-- list -->
		<div class="contents">
			<!-- 목록 보기 -->
			<c:forEach var="project" items="${projectList}">
				<div class="project-info-style">
					<div>${project.projectId}</div>
					<div>
						<form id="responeProjectId" action="sendProjectId.do"
							method="POST">
							<button type="submit" name="projectId" form="responeProjectId"
								value="${project.projectId}">${project.title}</button>
						</form>
					</div>
					<div>projectLeader:${project.projectLeader}</div>
					<div>projectStartDt:${project.projectStartDt}</div>
					<div>projectEndDt:${project.projectEndDt}</div>
					<div>projectRegDt:${project.projectRegDt}</div>
					<div>projectCompletion:${project.projectCompletion}</div>
					<div>publicProject:${project.publicProject}</div>
					<div>
						<button type="button">수정</button>
					</div>
					<div>
						<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#delete-project-modal">삭제</button>
					</div>
				</div>
			</c:forEach>
			<div class="project-info-style">
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#create-project-modal">create
					project..</button>
			</div>
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
						<button type="button" class="btn btn-default" data-dismiss="modal" id="delete-project-button">삭제</button>
					</div>
				</div>

			</div>
		</div> <!-- create-project-modal -->

	</div>	<!-- contents_wrap -->
</div>
<!-- cont_wrap -->
<script>
$("#create-project-button").on("click", function(){
	console.log('프로젝트 생성');
	var sendData = {projectName:$('#create-project-input').val()};
	ajaxRequest("insertProject.do",sendData);
});

$("#delete-project-button").on("click", function(){
	console.log('프로젝트 삭제');
});

function ajaxRequest(sendUrl, sendData){
	console.log(sendUrl + ", "+ sendData);
	$.ajax({
	    type:"POST",
	    data : sendData,
	    dataType:"text",
	    url:sendUrl,
	    success: function() {
	    
	 	$.ajax({
			url:'schedule.do',
			data: {},
			dataType:'json',
			success:function(data){			
				console.log('성공');
			}// success function

		});// ajax
	    },
	    error : function(error) {
	    },	// error
	  });// ajax
}

</script>
<script type="text/javascript" src="/KocoFarmPro/js/module/schedule.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false"></jsp:include>