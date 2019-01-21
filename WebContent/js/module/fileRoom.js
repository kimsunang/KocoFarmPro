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
		
		/* 검색 필수 값 체크 */
		if((schTypeVal == "" && schWordVal != "")){
			alert("검색 타입을 선택 해 주세요.");
			$("#schType").focus();
			return false;
		}else if(schWordVal == "" && schTypeVal != ""){
			alert("검색어를 입력 해 주세요.");
			$("#schWord").focus();
			return false;
		}else if((schWordVal != "" && schTypeVal != "") || (schTypeVal == "" && schWordVal == "")){
			$("#noticeForm").submit();
			return false;
		}
	});
	/* 검색 E */
	
	/* 목록 이동*/
	$("#listBtn").click(function(){
		location.href="fileList.do";
		return false;
	});
	
	/* 등록 페이지 이동 */
	$("#writeBtn").click(function(){
		location.href="noticeWrite.do?mode=write";
		return false;
	});
	
	/* 등록 */
	$("#writeProCBtn").click(function(){
		alert("등록버튼 클릭");
		$("#fileForm").submit();
		return false;
	});
	
	
	
	/* 삭제 */
	$("#delProCBtn").click(function(){
		if(confirm("삭제 하시겠습니까?")){
			location.href="FileDelProC.do?fileId="+$("#fileId").val();
			return false;
		}
	});
	
	if("edit" == $("#mode").val()){
		/* 네비 설정 */
		$("#subTitSpan").html("파일을 수정 할 수 있습니다.");
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

