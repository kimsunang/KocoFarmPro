<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/comm/top.jsp" flush="false"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/Kocofarm/css/module/file_Room.css" />



	<!-- SubTitle Area -->
	<div class="sub_title">

		<div class="sub_title_top">
			<div class="sub_title_inner">
				<h2>
					자료실 <span>파일을 올릴수 있습니다.</span>
				</h2>
				<ul class="sub_nav">
					<li>홈 > 자료실 ></li>
					<li class="on">상세정보</li>
				</ul>
			</div>
		</div>
	</div>
	<form action="fileList.do" id="FileForm">
		<input type="hidden" name="mode" id="mode" value="" />

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
							<option value="title"
								${param.schType eq "title" ? "selected='selected'" : ""}>제목</option>
							<option value="contents"
								${param.schType eq "contents" ? "selected='selected'" : ""}>내용</option>
						</select> <input type="text" name="schWord" id="schWord"
							value="${param.schWord != null ? param.schWord : ''}"
							placeholder="검색어를 입력 해 주세요" /> <input type="button"
							class="schBtn" id="schBtn" value="검색" />
					</div>
					
					<jsp:include page="/jsp/module/file_room/fileUpload.jsp" flush="false"></jsp:include>
				</div>
			</div>
			
		</div>
	</form>
	<!-- 좌측 사이드 메뉴 만들고 파일 바둑판 식으로 배열되기 하고 파일 업로드 기능 부여 -->







	<script type="text/javascript" src="/Kocofarm/js/module/fileRoom.js"></script>
	<jsp:include page="/jsp/comm/bottom.jsp" flush="false"></jsp:include>