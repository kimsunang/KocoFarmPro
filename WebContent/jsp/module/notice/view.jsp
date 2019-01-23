<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/notice.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Notice <span>공지사항을 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > 공지사항 > </li>
						<li class="on">상세정보</li>
					</ul>
				</div>
			</div>
		</div>
	
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- view -->
			<form action="noticeView.do" id="noticeForm">
				<input type="hidden" name="mode" id="mode" value="${param.mode}" />
				<input type="hidden" name="noticeId" id="noticeId" value="${notice.noticeId}" />
				
				<div class="contents">
					<!-- 상세 정보 -->
					<table class="contents_tb vw" id="contTb">
						<colgroup>
							<col width="20%">
							<col width="*">
						</colgroup>
						<tbody>
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
								<td class="left">
									<c:choose>
										<c:when test="${not empty notice.fileNm}">
											<a href="jsp/comm/download.jsp?filename=${notice.fileNm}">${notice.fileNm}</a>
										</c:when>
										<c:otherwise>
											첨부 파일이 없습니다.
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
			
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<input type="button" class="list_btn" id="listBtn" value="목록" />
						<c:if test="${loginVO.authority == 99}">
							<input type="button" class="edit_btn" id="editBtn" value="수정" />
							<input type="button" class="del_btn" id="delProCBtn" value="삭제" />
						</c:if>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/notice.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>