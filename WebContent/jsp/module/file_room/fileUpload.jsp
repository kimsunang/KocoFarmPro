<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/comm/top.jsp" flush="false"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/KocoFarmPro/css/module/notice.css" />


	<!-- SubTitle Area -->
	<div class="sub_title">
		<div class="sub_title_top">
			<div class="sub_title_inner">
				<h2>
					자료실 <span id="subTitSpan">파일을 올릴 수 있습니다.</span>
				</h2>
				<ul class="sub_nav">
					<li>홈 > 공지사항 ></li>
					<li class="on" id="subTitLi">등록</li>
				</ul>
			</div>
	</div>
	

		<div class="contents">
			<!-- 상세 정보 -->
			<table class="contents_tb vw" id="contTb">
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td class="left"></td>
					</tr>
					<tr>
						<th><a href="fileUpload.do">파일 업로드</a></th>
						<td class="left"></td>
					</tr>
					<tr>
						<th><a href="fileList.do">파일 리스트</a></th>
						<td class="left"></td>
					</tr>
					<tr>
						<th><a href="schedule.do">동영상</a></th>
						<td class="left"></td>
					</tr>
					<tr>
						<th><a href="schedule.do">문서</a></th>
						<td class="left"></td>
					</tr>

					</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
	<!-- Contents Area -->
	<div class="contents_wrap">
		<!-- write -->
		<form action="insertFile.do" method="post"
			enctype="multipart/form-data">
			파일 : <input type="file" name="fname"> <br> <input
				type="submit" value="등록">
		</form>
		<!-- btn -->
		<div class="btn_wrap">
			<div class="flt_r">
				<input type="button" class="list_btn" id="listBtn" value="목록" /> <input
					type="button" class="write_btn" id="writeProCBtn" value="등록" /> <input
					type="button" class="edit_btn" id="editProCBtn" value="수정" />

			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/notice.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false"></jsp:include>