<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/approval.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Approval <span>결재 관련 내용을 확인할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">문서 결재</li>
					</ul>
				</div>
			</div>
		</div>
	
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- basic draft input  -->
			<div class="draft_wrap">
				<p class="basic_info">기본 정보</p>
				<div class ="inf_wrap_box">
					<p class="name"> <b>이름 </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;김선행
					<p class="position"> <b>직위 </b>&nbsp;&nbsp;&nbsp;사원
					<p class="dep"> <b> 부서 </b> &nbsp;&nbsp;&nbsp;&nbsp;개발1
					<p class="form"> <b> 양식 </b>&nbsp;&nbsp;&nbsp;&nbsp; 뭐겡		 
				</div>
					<p></p>
					<p></p>
			</div>
		</div>
		
			<!-- list -->
			<style>
				td {
					text-align: center;
				}
				
				h1 {
					text-align: center;
				}
			</style>
			<div class="contents">
				
				<!-- 기안서 보기 -->
				<form action="insertDraft.do" method="post">
					<div class="vacation_wrap">
						<div class="title">
							<h1>휴 가 신 청 서</h1>
						</div>
						
						<!-- vacation table 시작 -->
						<div class="vac_table">
							<table width = 54% height = 80% border=1 cellpadding=0 cellspacing=0 align="center">
								<tr>
									<td rowspan="3" width = 15%>기안서 정보</td>
									<td width = 15%>기안서 번호</td>
									<td colspan="3">${draft.draftId}</td>
									<td>기안서 양식</td>
									<td colspan="3" >${draft.formId }</td>
			
			
								</tr>
								<tr>
									
									<td width = 15%>기안서 제목</td>
									<td colspan="3">${draft.draftTitle }</td>
									<td>등록 날짜</td>
									<td colspan="3" >${draft.draftDt }</td>
			
			
								</tr>
								<tr>
									<!-- 기안서 정보 -->
									<td>기안서 양식</td>
									<td colspan="3"></td>
									<td>보존년한</td>
									<td colspan="3">${draft.draftYear }</td>
								</tr>
			
								<tr>
									<td rowspan="3">인적 사항</td>
									<td>소속 부서</td>
									<td colspan="7">소속이름</td>
								</tr>
								<tr>
			
									<td>직위</td>
									<td colspan="7">직위이름</td>
								</tr>
								<tr>
			
									<td>성명</td>
									<td colspan="7">emp_name</td>
								</tr>
								<tr>
									<td rowspan="4">신청내용</td>
									<td rowspan="3">휴가신청</td>
									<td width = 7%>휴가종류</td>
									<td colspan="6">${vacation.vacationType }</td>
								</tr>
								
								<tr>
									<!-- 신청내용   -->
									<!-- 휴가신청   -->
									<td>휴가 일정</td>
									<td width = 5%>시작 날짜</td>
									<td>${vacation.vacationStartDt}</td>
			
									<td width = 5%>끝 날짜</td>
									<td>${vacation.vacationStartDt}</td>
									<td width = 5%>총 일 수</td>
									<td>${vacation.vacationDays }</td>
								</tr>
			
								<tr>
									<!-- 신청내용   -->
									<!-- 휴가신청   -->
									<td>대체근무자</td>
									<td>ID</td>
									<td>${vacation.replacementId }</td>
									<td>이름</td>
									<td>대체근무자 이름</td>
									<td>직위</td>
									<td>직위라능</td>
								</tr>
								<tr>
									<!-- 신청내용   -->
									<td>신 청 사 유 <Br>(세부 내용)
									</td>
									<!-- 세부내용기재   -->
									<td colspan="7">${vacation.vacationReason}</td>
			
								</tr>
								<tr height = "400px" > 
									<td colspan = 9>
									<p class="last_msg">위와 같이 휴가를 신청하오니 허가하여 주시기 바랍니다 .</p><br><br><br>
									<p class="sysdate">
										<fmt:parseDate var = "dateString" value ="${draft.draftDt}"  pattern = "yyyy-MM-dd"/>
										<fmt:formatDate value="${dateString }" pattern = "yyyy년  MM월  dd일"/>
									</p><br><br>
									<p class="sign">	(인)</p>
								</tr>

			
							</table>
						</div>
						<!-- vacation table 끝 -->
			
			
						<div class= flt_r align=center style="float:none; margin:auto; width:54%; margin-top : 10px; margin-bottom : 50px;">
							<!-- <input type = "submit" value = "저장하기" > -->
							<input type="submit" value="제출" style="float:right;">
						</div>
			
			
			
			
			
						<div class= "btn_wrap" align = "center">
							<br><br>
							<a href = "UpdateForm.do?draftId=${draft.draftId}" >수정하기</a>
							<!-- <input type="button" class="modifyBtn" value="수정하기" /> -->
							<a href = "DeleteAction.do?draftId=${draft.draftId}" >삭제하기</a>

							<br><br>
						</div>
					</div>
				</form>
			</div>
		
		</div>
<!-- 댓글달기 -->
<!-- 댓글 부분 -->
    <div id="comment" align="center" >
    <!-- 댓글 목록 -->    
   	<div id = "ListComment" style="width: 54%; text-align: left;">
   		<c:forEach var="item" items="${draftList }" varStatus="status">
   		<table style="border: 1px solid #A4A4A4; border-radius : 3px; width : 100%; margin-top: 5px; font-size:12px;">
   			<tr style="height : 15px; background-color : #F6E3CE; ">
   				<td>
   					작성자 &nbsp; ${item.empId }
   				</td>
   				<td style="text-align: right !important ;">
   					작성일 &nbsp; ${item.commentDt }
   				</td>
   			</tr>
   			<tr>
   				<td style="width:15%;">
   					댓글내용
   				</td>
   				<td >
   					<div style=" height: 40px; overflow:auto;">${item.commentContents }</div>
   				</td>
   			</tr>
   		</table>
   		</c:forEach>
   	</div>
	<div id="commentPaging">
	
	
	
	
	</div>   	
	<!-- 로그인 했을 경우만 댓글 작성가능 -->
            
		<!--  댓글작성창 -->
		<form id="commentForm" style="margin-top : 10px;">
			<div class=re_writer style="width:54%;">
					<input type="hidden" name="draftId" id="draftId" value="${draft.draftId}" />
					<textarea id="commentContents" name="commentContents" style="height: 60; width: 90%; vertical-align: middle; border : 1px solid #A4A4A4; border-radius:3px; resize:none;"></textarea>
					<input type="button" id="setCommentBtn" value="댓글등록" style="vertical-align: middle; width:76px;height: 60px; line-height: 33px; border : 1px solid #A4A4A4; border-radius:3px;"
					 >
			</div>
			<div style="padding-left: 800;">
			
			</div>
		</form>
		<!-- 댓글목록들 -->
	
</div>
<script>
	$(function() {
			 $("#setCommentBtn").click(function(){
					var draftId = $("#draftId").val();
					var commentContents = $("#commentContents").val();
					commentContents = commentContents.replace(/(?:\r\n|\r|\n)/g, '<br />');
					var commentId = 1;
					var data = {
							draftId : draftId,
							commentContents : commentContents,
							commentId : commentId
					}
					
					$.ajax({
						url : "/KocoFarmPro/insertComment.do",
						type : "GET",
						data : data,
						success : function(){
							var today = new Date();
							var dd = today.getDate();
							var mm = (today.getMonth()+1).toString();
							if (mm.length < 2) {
								mm = '0' + mm;
							}
							var yyyy = today.getFullYear();
							var hour = today.getHours();
							var min = today.getMinutes();
							var sec = today.getSeconds();
							
							var date = yyyy+'-'+mm+'-'+dd+' '+hour+':'+min+':'+sec;
							var html = '<table style="border: 1px solid #A4A4A4; width : 100%; font-size:12px; margin-top:5px; border-radius:5px;">';
								html += '<tr style="height:15px;  background-color : #F6E3CE; "><td>작성자 &nbsp; '+commentId+'</td><td style="text-align:right !important ;"> 작성일 &nbsp; '+ date + '</td></tr>';
								html += '<tr><td style="width:15%;">댓글내용</td><td><div style=" height: 40px; overflow:auto;">'+commentContents+'</div></td></tr></table>';
								
							$('#ListComment').append(html);
							if ($('#ListComment table').length > 5) {
								$('#ListComment').children()[0].remove();
								 $("#commentContents").val("");
							}
						}
					});
			}); 
		});
		
</script>

<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>