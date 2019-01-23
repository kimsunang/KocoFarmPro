$(function(){
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
	
	/* 전체 선택 시 검색 값 */
	$("#schType").change(function(){
		if("" == $(this).val()){
			$("#schWord").val("");
		}
	});
	
	$("#schBtn").click(function(){
		var schTypeVal = $("#schType").val();
		var schWordVal = $("#schWord").val();
		
		/* 검색 필수 카테고리 체크 */
		if(("" == schTypeVal && "" != schWordVal)){
			alert("검색 타입을 선택 해 주세요.");
			$("#schType").focus();
			return false;
		}else if("" == schWordVal && "" != schTypeVal){
			alert("검색어를 입력 해 주세요.");
			$("#schWord").focus();
			return false;
		}else if(("" != schWordVal && "" != schTypeVal) || ("" == schTypeVal && "" == schWordVal)){
			$("#noticeForm").submit();
			return false;
		}
	});
	/* 검색 E */
	
	/* 목록 이동*/
	$("#listBtn").click(function(){
		location.href="noticeList.do";
		return false;
	});
	
	/* 등록 페이지 이동 */
	$("#writeBtn").click(function(){
		location.href="noticeWrite.do?mode=write";
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
		location.href="noticeEdit.do?mode=edit&noticeId="+$("#noticeId").val();
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
			location.href="noticeDelProC.do?noticeId="+$("#noticeId").val();
			return false;
		}
	});
	
	if("edit" == $("#mode").val()){
		/* 네비 설정 */
		$("#subTitSpan").html("공지사항을 수정 할 수 있습니다.");
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
	}else{
		$("#fileTit").hide();
	}
	
});

/* 등록, 수정 필수 값 체크 */
function chkReq(){
	var mode = $("#mode").val();

	if(null == $("#title").val() || "" == $("#title").val()){
		alert("제목을 입력 해 주세요.");
		$("#title").focus();
		return false;
	}
	
	if(null == $("#contents").val() || "" == $("#contents").val()){
		alert("내용을 입력 해 주세요.");
		$("#contents").focus();
		return false;
	}
	
	if("write" == mode){
		$("#noticeForm").attr("action", "noticeWriteProC.do");
		$("#noticeForm").submit();
	}else{
		$("#noticeForm").attr("action", "noticeEditProC.do");
		$("#noticeForm").submit();
	}
}