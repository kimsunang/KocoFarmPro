$(function(){
	/* datePicker */
	$("#hireDt, #startDt, #endDt").datepicker({
		showMonthAfterYear : true,
		showButtonPanel : true,
		changeMonth : true,
		changeYear : true,
		nextText : '다음 달',
		prevText : '이전 달',
		currentText : '오늘 일',
		closeText : '닫기',
		dateFormat : 'yy-mm-dd',
		dayNames : ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],
		dayNamesMin : ['일','월','화','수','목','금','토'],
		monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNamesShort : ['1','2','3','4','5','6','7','8','9','10','11','12'],
	});
	
	/* 탭 이동 */
	$(".tab_li").click(function(){
		var tabId = $(this).attr("id")
		$(".tab_ul li").removeClass("on");
		$(this).addClass("on");
		
		// 탭에 따른 페이지
		if("basicTab" == tabId){
			$("#basicTable").show();
			$("#historyTable").hide();	
			
			$(".contents").removeClass("scrollTb");
		}else{
			$("#historyTable").removeClass("dp_none");
			$("#basicTable").hide();
			$("#historyTable").show();
			
			$(".contents").addClass("scrollTb");
			
			// 인사 이동 정보
			getAjax("getJobHistory", $("#empId").val());
		}
	})
	
	/* 검색 S */
	$(".sch_slide_btn").click(function(){
		// 검색 영역 Show || Hide
		$(".sch_toggle_wrap").toggle();
		
		// 검색 영역 Up || Down 이미지
		var $slideBtnImg = $("#slideBtnImg");
		
		if($slideBtnImg.attr("class") == "upBtn"){
			$slideBtnImg.removeClass();
			$slideBtnImg.addClass("downBtn");
			$("#slideBtnImg").attr("src", "/KocoFarmPro/img/comm/list_down_btn.png");
			$("#slideBtnImg").attr("alt", "메뉴 펼치기");
		}else{
			$slideBtnImg.removeClass();
			$slideBtnImg.addClass("upBtn");
			$("#slideBtnImg").attr("src", "/KocoFarmPro/img/comm/list_up_btn.png");
			$("#slideBtnImg").attr("alt", "메뉴 접기");
		}
	});
	
	$("#schBtn").click(function(){
		var schTypeVal = $("#schType").val();
		var schWordVal = $("#schWord").val();
		
		/* 검색 필수 값 체크 */
		if(("" == schTypeVal && "" != schWordVal)){
			alert("검색 타입을 선택 해 주세요.");
			$("#schType").focus();
			return false;
		}else if("" == schWordVal && "" !=  schTypeVal){
			alert("검색어를 입력 해 주세요.");
			$("#schWord").focus();
			return false;
		}else if(("" != schWordVal && "" != schTypeVal) || ("" == schTypeVal && "" == schWordVal)){
			$("#empForm").submit();
			return false;
		}
	});
	
	var schWord = $("#paramSchWord").val() != null ? $("#paramSchWord").val() : "";
	if(null != $("#paramSchType").val() && "state" == $("#paramSchType").val()){
		var txt = ""
		txt += "<select name='schWord' id='schWord'>";
		txt += "<option value='stay'";
			if("stay" == schWord){
				txt += "selected=selected";
			}
		txt += ">재직</option>";
		txt += "<option value='loa'";
			if("loa" == schWord){
				txt += "selected=selected";
			}
		txt += ">휴직</option>";
		txt += "<option value='retirement'";
			if("retirement" == schWord){
				txt += "selected=selected";
			}
		txt += ">퇴직</option>";
		txt += "</select>";
	}else{
		var txt = ""
			txt += "<input type='text' name='schWord' id='schWord' value='";
		if(null != schWord && "" != schWord){
			txt += schWord;
		}
		txt += "' placeholder='검색어를 입력 해 주세요' />";
	}
	$(".sch_span").html(txt);
	
	$("#schType").change(function(){
		if("" == $(this).val()){
			$("#schWord").val("");
		}
		
		var txt = "";
		if("state" == $(this).val()){
			txt += "<select name='schWord' id='schWord'>";
			txt += "<option value='stay'>재직</option>";
			txt += "<option value='loa'>휴직</option>";
			txt += "<option value='retirement'>퇴직</option>";
			txt += "</select>";
		}else{
			txt += "<input type='text' name='schWord' id='schWord' value='";
			txt += "' placeholder='검색어를 입력 해 주세요' />";
		}
		$(".sch_span").html(txt);
	});
	/* 검색 E */
	
	/* 목록 이동*/
	$("#listBtn").click(function(){
		location.href="empList.do";
		return false;
	});
	
	/* 등록 페이지 이동 */
	$("#writeBtn").click(function(){
		location.href="empWrite.do?mode=write";
		return false;
	});
	
	/* 등록 */
	$("#writeProCBtn").click(function(){
		if(confirm("등록 하시겠습니까?")){
			// 필수 값 체크
			chkReq();
		}
		return false;
	});
	
	/* 수정 페이지 이동 */
	$("#editBtn").click(function(){
		location.href="empEdit.do?mode=edit&empId="+$("#empId").val();
		return false;
	});
	
	/* 수정 */
	$("#editProCBtn").click(function(){
		if(confirm("수정 하시겠습니까?")){
			// 필수 값 체크
			chkReq();
		}
		return false;
	});
	
	/* 삭제 */
	$("#delProCBtn").click(function(){
		if(confirm("삭제 하시겠습니까?")){
			location.href="empDelProC.do?empId="+$("#empId").val();
			return false;
		}
	});
	
	/* 부서에 따른 직업 */
	$("#deptId").change(function(){
		getAjax("getJobId", $(this).val());
	});
	
	/* 재직 상태에 따른 값 */
	$("#state").change(function(){
		showDtInput();
	});
	
	if("edit" == $("#mode").val()){
		/* 네비 설정 */
		$("#subTitSpan").html("인사 정보를 수정 할 수 있습니다.");
		$("#subTitLi").html("수정");
		
		/* 파일 설정 */
		if(null != $("#fileYn").val() && "" != $("#fileYn").val()){
			$("#fileNm").hide();
			$("#fileTit").show();
		}else{
			$("#fileNm").show();
			$("#fileTit").hide();
		}
		
		$("#fileTit").click(function(){
			$("#fileNm").click();
			return false;
		});
		
		$("input[type='file']").change(function(){
			var orgFile = $(this).val();
			var orgPath = "C:\\fakepath\\";
			
			$("#fileTit").html(orgFile.substring(orgPath.length));
		});
		
		// 부서에 따른 직업 목록 호출
		getAjax("getJobId", $("#deptId").val());
		
		// 재직 상태에 따른 값
		showDtInput();
	}else{
		$("#fileTit").hide();
	}
	
	/* 등록 / 수정 정규식 호출 */
	$("#korNm, #engNm, #email, #cellPhone, #salary").change(function(){
		var myId = $(this).attr("id");

		if("korNm" == myId){
			chkReg("kor", $(this));
		}else if("engNm" == myId){
			chkReg("eng", $(this));
		}else if("email" == myId){
			chkReg("email", $(this));
		}else if("cellPhone" == myId){
			chkReg("cellPhone", $(this));
		}else if("salary" == myId){
			chkReg("int", $(this));
		}
	});
	
	$(".resetPwBtn").click(function(){
		var id = $(this).attr("id")
		id = id.substring(id.indexOf("EMP_"));
		getAjax("resetPw", id);
	});
	
});

/* 정규식 */
function chkReg(type, my){
	var reg = "";
	var value = my.val();
	if("kor" == type){
		reg = /^[가-힣]*$/;
		
		if(!reg.test(value)){
			alert("한글만 입력 가능 합니다.");
			my.focus();
		}
	}else if("eng" == type){
		reg = /^[a-zA-Z]*$/;
		
		if(!reg.test(value)){
			alert("영어만 입력 가능 합니다.");
			my.focus();
		}
	}else if("email" == type){
		reg = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
		
		if(!reg.test(value)){
			alert("이메일 형식을 다시 확인 해 주세요.");
			my.focus();
		}
	}else if("cellPhone" == type){
		reg =  /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		
		if(!reg.test(value)){
			alert("전화번호를 확인 해 주세요.");
			my.focus();
		}
	}else if("int" == type){
		reg = /^[0-9]*$/;
		
		if(!reg.test(value)){
			alert("숫자만 입력 가능합니다.");
			my.focus();
		}
	}
};

/* 재직 상태에 따른 날짜 입력 영역 */
function showDtInput(){
	if("loa" == $("#state").val()){
		$("#startDt").val($("#empStDt").val());
		$("#startDt").show();
		$("#endDt").val($("#empEnDt").val());
		$("#endDt").show();
	}else if("retirement" == $("#state").val()){
		$("#endDt").val($("#retirementDt").val());
		$("#endDt").show();
		$("#startDt").val("");
		$("#startDt").hide();
	}else{
		$("#startDt").val("");
		$("#endDt").val("");
		$("#startDt").hide();
		$("#endDt").hide();
	}
}

/* 등록, 수정 필수 값 체크 */
function chkReq(){
	var mode = $("#mode").val();

	if(null == $("#korNm").val() || "" == $("#korNm").val()){
		alert("한글 이름을 입력 해 주세요.");
		$("#korNm").focus();
		return false;
	}
	
	if(null == $("#engNm").val() || "" == $("#engNm").val()){
		alert("영문 이름을 입력 해 주세요.");
		$("#engNm").focus();
		return false;
	}
	
	if(null == $("#email").val() || "" == $("#email").val()){
		alert("이메일을 입력 해 주세요.");
		$("#email").focus();
		return false;
	}
	
	if(null == $("#cellPhone").val() || "" == $("#cellPhone").val()){
		alert("핸드폰 번호를 입력 해 주세요.");
		$("#cellPhone").focus();
		return false;
	}
	
	if(null == $("#hireDt").val() || "" == $("#hireDt").val()){
		alert("입사일을 입력 해 주세요.");
		$("#hireDt").focus();
		return false;
	}
	
	if(null == $("#deptId").val() || "" == $("#deptId").val()){
		alert("부서를 선택 해 주세요.");
		$("#deptId").focus();
		return false;
	}
	
	if(null == $("#jobId").val() || "" == $("#jobId").val()){
		alert("직업을 선택 해 주세요.");
		$("#jobId").focus();
		return false;
	}
	
	if(null == $("#positionId").val() || "" == $("#positionId").val()){
		alert("직책을 선택 해 주세요.");
		$("#positionId").focus();
		return false;
	}
	
	if(null == $("#authority").val() || "" == $("#authority").val()){
		alert("권한을 선택 해 주세요.");
		$("#authority").focus();
		return false;
	}
	
	if(null == $("#salary").val() || "" == $("#salary").val()){
		alert("급여를 입력 해 주세요.");
		$("#salary").focus();
		return false;
	}
	
	if("write" == mode){
		$("#empForm").attr("action", "empWriteProC.do");
		$("#empForm").submit();
	}else{
		$("#empForm").attr("action", "empEditProC.do");
		$("#empForm").submit();
	}
}

/* Ajax 호출 */
function getAjax(ajaxMode, id){
	if("getJobId" == ajaxMode){
		if("" == id || null == id){
			$("#jobId").html("<option value=''>전체</option>");
		}
	}
	
	$.ajax({
		"url" : "getAjaxData.do"
	,	"data" : {
				"id" : id
			,	"ajaxMode" : ajaxMode
		}
	,	dataType : "json"
	,	success : function(data){
			if("getJobId" == ajaxMode){
				showJobData(data);
			}else if("getJobHistory" == ajaxMode){
				showJobHistory(data);
			}else if("resetPw" == ajaxMode){
				if(0 < data[0].re){
					alert("비밀번호가 1234로 초기화 됐습니다.");
				}else{
					alert("비밀번호 초기화에 실패 했습니다.");
				}
			}
		}
	});
}

/* 부서에 따른 직업 목록 */
function showJobData(data){
	var txt = "";
	if(0 < data.length){
		for(var i=0; i<data.length; i++){
			txt += "<option value='"+data[i].jobId+"'";
			if(data[i].jobId == $("#empJobId").val()){
				txt += "selected=selected";
			}
			txt +=">";
			txt += data[i].jobNm+"</option>";
		}
		$("#managerId").val(data[0].managerId);
	}else{
		txt += "<option value=''>전체</option>";
	}
	$("#jobId").html(txt);
};

/* JOB_HISTORY List */
function showJobHistory(data){
	var txt = "";
	
	if(0 < data.length){
		for(var i=0; i<data.length; i++){
			txt += "<tr>";
			txt += "<td>"+data[i].deptNm+"</td>";
			txt += "<td>"+data[i].jobNm+"</td>";
			txt += "<td>"+data[i].positionNm+"</td>";
			txt += "<td>"+data[i].stateNm+"</td>";
			txt += "<td>"+data[i].regDt+"</td>";
			
			if(null == data[i].startDt || "" == data[i].startDt){
				txt += "<td> - </td>";
			}else{
				txt += "<td>"+data[i].startDt+"</td>";
			}
			
			if(null == data[i].endDt || "" == data[i].endDt){
				txt += "<td> - </td>";
			}else{
				txt += "<td>"+data[i].endDt+"</td>";
			}
			txt += "</tr>";
		}
	}else{
		txt += "<td colspan='7'>데이터가 없습니다.</td>"
	}
	$("#historyTbBody").html(txt);
};