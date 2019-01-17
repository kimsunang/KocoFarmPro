<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/comm/top.jsp" flush="false"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/Kocofarm/css/module/notice.css" />

<div class="cont_wrap">

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

	<!-- 좌측 사이드 메뉴 만들고 파일 바둑판 식으로 배열되기 하고 파일 업로드 기능 부여 -->
	<ul class="gnb">

		<!--문서도 확장자 여러게 지정 가능  -->
		<div class="contents_wrap">
			<!-- view -->
			<form action="" id="noticeForm">
				<input type="hidden" name="mode" id="mode" value="${param.mode}" />
				<input type="hidden" name="noticeId" id="noticeId"
					value="${notice.noticeId}" />

				<div class="contents">
					<!-- 상세 정보 -->
					<table class="contents_tb vw" id="contTb">
						<colgroup>
							<col width="20%">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
							<th>
							<div>파일올리기	<input type="file" name="file_id" id="file_id">
								<input type = "submit" value="업로드"></input></div>
							</a></th>
							<td class="left"></td>
							</tr>
							<tr>
							<th><a href="fileUpload.do">파일 업로드</a></th>
							<td class="left"></td>
							</tr>
							<tr>
							<th><a href="rent.do">파일 리스트</a></th>
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
							<%--<tr>
								<th scope="col">파일 올리기</th>
							<td class="left"></td>
							</tr>
							<tr>
								<th scope="col">제목</th>
								<td class="left">${notice.title}</td>
							</tr>
							 <tr>
								<th scope="col">내용</th>
								<td class="left">${notice.contents}</td>
							</tr>
							<tr>
								<th scope="col">파일</th>
								<td class="left"> --%><c:choose>
										<c:when test="${not empty notice.fileNm}">
											<a href="jsp/comm/download.jsp?filename=${notice.fileNm}">${notice.fileNm}</a>
										</c:when>
										<c:otherwise>
											첨부 파일이 없습니다.
										</c:otherwise>
									</c:choose></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>






			<script type="text/javascript" src="/Kocofarm/js/module/notice.js"></script>
			<jsp:include page="/jsp/comm/bottom.jsp" flush="false"></jsp:include>