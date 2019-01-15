<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/Kocofarm/css/module/rent.css" />
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    var dateFormat = "yyyy-mm-dd",
      from = $( "#from" )
        .datepicker({
          defaultDate: "+1w",
          changeMonth: true,
          numberOfMonths: 3
        })
        .on( "change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $( "#to" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 3
      })
      .on( "change", function() {
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
 
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


	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>MeetingRoom Reservation<span>회의실을 예약할 수 있습니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">회의실 예약</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="contents_wrap">
			<!-- 회의실 수정 -->
			<form action="reservInsert.do" method="post" >
			<div class="sch_wrap">
				회의 제목 : <input type="text" name="m_title"><br>
				부서 : <input type="text" name="dept"><br>
				<label for="from">예약날짜</label><input type="text" id="from" name="start_dt"><br>
				<label for="to">종료날짜</label><input type="text" id="to" name="end_dt"><br>
				사용자 : <input type="text" name="rv_user"><br>
				예약자 : <input type="text" name="rv_writer"><br>
				<input type="hidden" name="reg_dt" /> 
			</div>
			<input type="submit" value="예약">
			</form>
		</div>
	
		<!-- Contents Area -->
		<div class="contents_wrap">
			<!-- sch_top -->
			<div class="sch_wrap">
				<p class="tit">검색</p>
				<div class="sch_slide_btn">
					<img id="slideBtnImg" class="upBtn" src="/Kocofarm/img/comm/list_up_btn.png" alt="메뉴 접기" />
				</div>
				<div class="sch_toggle_wrap">
					<div class="sch_box_wrap">
						<div class="right">
							<select name="schType" id="schType">
								<option value="">전체</option>
								<option value="title">제목</option>
								<option value="contents">내용</option>
							</select>
							<input type="text" name="schWord" id="schWord" placeholder="검색어를 입력 해 주세요" />
							<input type="button" class="schBtn" id="schBtn" value="검색" />
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
				<table class="contents_tb" id="contTb">
				</table>
			</div>
						
			<!-- btn -->
			<div class="btn_wrap">
				<div class="flt_r">
					<input type="button" class="list_btn" value="목록" />
					<input type="button" class="view_btn" value="상세보기" />
					<input type="button" class="write_btn" value="등록" />
					<input type="button" class="edit_btn" value="수정" />
					<input type="button" class="del_btn" value="삭제" />
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/Kocofarm/js/module/rent.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>