<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/comm/top.jsp" flush="false"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/KocoFarmPro/css/module/notice.css" />
	<!-- SubTitle Area -->
<%-- 	<% System.out.println("forward"); %>  --%>
	<div class="sub_title">
		<div class="sub_title_top">
			<div class="sub_title_inner">
				<h2>
					자료실 <span id="subTitSpan">파일을 올릴 수 있습니다.</span>
				</h2>
				<ul class="sub_nav">
					<li>홈 > 자료실 ></li>
					<li class="on" id="subTitLi">등록</li>
				</ul>
			</div>
	</div>
	<!-- Contents Area -->
	<div class="contents_wrap">
		<!-- write -->
		<form action="insertFile.do" id="fileForm" method="post" enctype="multipart/form-data">
			파일22 : <input type="file" name="file_name"> <br> 
		</form>
		<input type="button" id="writeProCBtn" value="등록">
		<!-- btn -->
<!-- 		<div class="btn_wrap"> -->
<!-- 			<div class="flt_r"> -->
<!-- 				<input type="button" class="list_btn" id="listBtn" value="목록" /> <input -->
<!-- 					type="button" class="write_btn" id="writeProCBtn" value="등록" />  -->

<!-- 			</div> -->
<!-- 		</div> -->
	</div>
</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/fileRoom.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false"></jsp:include>