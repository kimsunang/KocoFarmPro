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
						<li>홈 > </li>
						<li class="on">공지 사항</li>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- sch_top -->
			<form action="noticeList.do" id="noticeForm">
				<input type="hidden" name="mode" id="mode" value="" />
				
				<div class="sch_wrap">
					<p class="tit">검색</p>
					<div class="sch_slide_btn">
						<img id="slideBtnImg" class="upBtn" src="/KocoFarmPro/img/comm/list_up_btn.png" alt="메뉴 접기" />
					</div>
					<div class="sch_toggle_wrap">
						<div class="sch_box_wrap">
							<div class="right">
								<select name="schType" id="schType">
									<option value="">전체</option>
									<option value="title" ${param.schType eq "title" ? "selected='selected'" : ""}>제목</option>
									<option value="contents" ${param.schType eq "contents" ? "selected='selected'" : ""}>내용</option>
								</select>
								<input type="text" name="schWord" id="schWord" value="${param.schWord != null ? param.schWord : ''}" placeholder="검색어를 입력 해 주세요" />
								<input type="button" class="schBtn" id="schBtn" value="검색" />
							</div>
						</div>
					</div>
				</div>
			</form>
			
			<!-- list -->
			<div class="contents">
				<!-- 목록 보기 -->
				<table class="contents_tb" id="contTb">
					<colgroup>
						<col width="5.45454%">
						<col width="74.5454%">
						<col width="10.90909%">
						<col width="*">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">NO</th>
							<th scope="col">제목</th>
							<th scope="col">등록 일</th>
							<th scope="col">조회 수</th>
						</tr>
					</thead>
					<tbody id="contentsTbBody">
						<c:choose>
							<c:when test="${not empty noticeList.list}">
								<c:forEach var="list" items="${noticeList.list}" varStatus="status">
									<tr>
										<td>
											${(noticeList.totalCount-status.index)-((noticeList.requestPage-1)*noticeList.pageSize)}
										</td>
										<td class="cursorP"><a href="noticeView.do?mode=view&noticeId=${list.noticeId}">${list.title}</a></td>
										<td>${list.regDt}</td>
										<td>${list.hitCnt}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="4">데이터가 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			
			<!-- 페이징 -->
			<div class="paging_div">
				<!-- 이전 -->
				<c:if test="${noticeList.startPage > 10}">
					<span><a href="noticeList.do?pageNum=${noticeList.startPage-10}&schTye=${param.schType}&schWord=${param.schWord}">&lt;</a></span>
				</c:if>
				<!-- 페이지 목록 -->
				<c:forEach var="pageNo" begin="${noticeList.startPage}" end="${noticeList.endPage}">
					<c:if test="${noticeList.requestPage == pageNo}"><b></c:if>
						<span><a href="noticeList.do?pageNum=${pageNo}&schTye=${param.schType}&schWord=${param.schWord}">${pageNo}</a></span>
					<c:if test="${noticeList.requestPage == pageNo}"></b></c:if>
				</c:forEach>
				<!-- 이후 -->
				<c:if test="${noticeList.endPage < noticeList.totalPageCount}">
					<span><a href="noticeList.do?pageNum=${noticeList.startPage+10}&schTye=${param.schType}&schWord=${param.schWord}">&gt;</a></span>
				</c:if>
			</div>
			
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<c:if test="${loginVO.authority == 99}">
						<input type="button" class="write_btn" id="writeBtn" value="등록" />
					</c:if>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/module/notice.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>