<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/Kocofarm/css/module/rentCar.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Rent <span id="subTitSpan">차량을 예약 할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > 공지사항 > </li>
						<li class="on" id="subTitLi">예약</li>
					</ul>
				</div>
			</div>
		</div>
	
	
		<!-- Contents Area -->
		 <%--<div class="contents_wrap">
			<!-- write -->
			<form action="" id="noticeForm" method="post" enctype="multipart/form-data">
				<input type="hidden" name="mode" id="mode" value="${param.mode}" />
				<input type="hidden" name="noticeId" id="noticeId" value="${notice.noticeId}" />
				<input type="hidden" name="fileYn" id="fileYn" value="${notice.fileNm}" />
				
				<div class="contents">
					<!-- 등록 -->
					<table class="contents_tb wr" id="contTb">
						<colgroup>
							<col width="20%">
							<col width="*">
						</colgroup>
						<tbody id="contentsTbBody">
							<tr>
								<th scope="col">제목</th>
								<td class="left">
									<input type="text" name="title" id="title" class="tit" value="${notice.title}" />
								</td>
							</tr>
							<tr>
								<th scope="col" colspan="2">내용</th>
							</tr>
							<tr>
								<td colspan="2">
									<textarea name="contents" id="contents">${notice.contents}</textarea>
								</td>
							</tr>
							<tr>
								<th scope="col">파일 첨부</th>
								<td class="left" id="fileArea">
									<input type="file" name="fileNm" id="fileNm" />
									<span id="fileTit">${notice.fileNm}</span>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form> --%>
		<!-- 삽입한 부분 -->	 <!-- action="rentCarDetailWrite.do" -->
			<form action="" method="post" id = "CarResWrite"> 
				<input type="hidden" name="mode" id="mode" value="write" />
				
			사용자 : <input type="text" name="RES_USER" id = "RES_USER"><br>
			예약차량 : <input type="text" name="CAR_ID" id = "CAR_ID" ><br>
			예약시간 : <input type = "text" name = "time"><br>
			출발지 주소 : <input type = "text" name = "St_Addr">	<br>
			도착지 주소 : <input type = "text" name = "De_Addr">	<br>
			사용 목적 : <input type="text" name="purpose" id = "purpose"><br>			
			<input type="button" value="등록" id = "enroll"><br>
			
		</form>
			<!-- 삽입한 부분 -->
			
			
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<input type="button" class="list_btn" id="listBtn" value="목록" onclick="location.href = 'rentCarDetailList.do'" />
					 <c:if test="${param.mode eq 'write'}">
						<input type="button" class="write_btn" id="writeProCBtn" value="등록" />
					</c:if>
					<c:if test="${param.mode eq 'edit'}">
						<input type="button" class="edit_btn" id="editProCBtn" value="수정" />
					</c:if> 
				</div>
			</div>
		</div>
		
		
		
	
<script type="text/javascript" src="/KocoFarmPro/js/module/rent.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>