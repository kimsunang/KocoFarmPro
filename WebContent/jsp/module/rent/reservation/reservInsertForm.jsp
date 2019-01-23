 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/rent.css" />
  <script>
  $( function() {
    var 
      from = $( "#startDt" ).datepicker({
	    	  dateFormat: 'yy/mm/dd' //Input Display Format 변경
	          ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	          ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
	          ,changeYear: true //콤보박스에서 년 선택 가능
              ,changeMonth: true //콤보박스에서 월 선택 가능                
              ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
              ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
              ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
              ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
              ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
              ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
              ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
              ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
              ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
              ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
              ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)       
        })
        .on( "change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $( "#endDt" ).datepicker({
    	  dateFormat: 'yy/mm/dd' //Input Display Format 변경
	          ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	          ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
	          ,changeYear: true //콤보박스에서 년 선택 가능
              ,changeMonth: true //콤보박스에서 월 선택 가능                
              ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
              ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
              ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
              ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
              ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
              ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
              ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
              ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
              ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
              ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
              ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)     
      })
      .on( "change", function() {
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
    
    $('#startDt').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
    //To의 초기값을 내일로 설정
    $('#endDt').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
  } );

</script>
</body>
</html>

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Reservation<span>회의실을 예약할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">회의실 예약</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="contents_wrap">
			<!-- 회의실 수정 -->
			<div class="contents">
				<!-- 등록 -->
				<form action="reservInsert.do" method="post" >
					<h1 class="txt_c">${mroom.mName}</h1>
					<table class="contents_tb wr" id="contTb">
						<colgroup>
							<col width="15%">
						</colgroup>
						<tbody id="contentsTbBody">
							<tr>
								<th scope="col">회의 제목</th>
								<td class="left">
									<input type="text" name="mTitle">
								</td>
								<th scope="col">부서</th>
								<td class="left">
									<select class="form-control" name="dept" >
										<c:forEach items="${deptList }" var="dept" >
										  <option value="${dept.deptId}">${dept.deptNm }</option>
										 </c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="col">예약 날짜</th>
								<td class="left">
									<input type="text" id="startDt" name="startDt" readonly=readonly />
								</td>
								<th scope="col">종료 날짜</th>
								<td class="left">
									<input type="text" id="endDt" name="endDt" readonly=readonly />
								</td>
							</tr>
							<tr>
								<th scope="col">사용자</th>
								<td class="left">
									<select class="form-control" name="rvUser" >
										<c:forEach items="${empList }" var="emp" varStatus="status">
										  <option value="${emp.empId}">${emp.korNm}</option>
										 </c:forEach>
									</select>
								</td>
								<th scope="col">예약자</th>
								<td class="left">
									<select class="form-control" name="rvWriter">
										<c:forEach items="${empList}" var="emp2">
										  <option value="${emp.empId}">${emp2.korNm}</option>
										 </c:forEach>
									</select>
								</td>
								<input type="hidden" name="mId" value="${mroom.mId }" >
							</tr>
						</tbody>
					</table>
					<div class="btn_wrap">
						<div class="flt_r">
							<input class="auto_wth_btn_b" type="submit" value="예약">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<!-- <script type="text/javascript" src="/Kocofarm/js/module/rent.js"></script> -->
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>