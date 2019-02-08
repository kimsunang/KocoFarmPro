/* 일정 추가, 수정 시 저장 데이터 */
var add_project_id = 0;			// 프로젝트 아이디
var add_category_id = 0;		// 카테고리 아이디
var add_calender_id = 0;		// 일정 아이디
var add_calender_color_value;	// color


/* 일정 이동 시 사용되는 변수 */
var drag_before_calender_category_id;	// 이동 전 일정의 카테고리 id
var drag_before_calender_id;			// 이동 전 일정 id
var drag_before_calender_y;				// 이동 전 일정 y
var drag_before_calender_index;			// 이동 전 일정 index

/* 카테고리 이동 시 사용되는 변수 */
var drag_category_class;				// 이동하는 카테고리의 class
var drag_category_x;					// 이동하는 카테고리의 x
var drag_category_projectId;			// 이동하는 카테고리의 프로젝트 id
var drag_category_categoryId;			// 이동하는 카테고리의 id


(function($) {
	
	
    var elmDrag, replacerSet = $();
    var eventStack = ['dragstart', 'dragend', 'selectstart', 'dragover', 'dragenter', 'drop'];
    
    $.fn.dropme = function(options) {
        var userOpt = options.toString();

        options = $.extend({
            linkTo: false
        }, options);

        if (options.contId) {
            //var elmes = '<ul class="sortable">';
            var elmes = '';
            var lnth = options.elem.length;
            var i;
            for (i = 0; i < lnth; i++) {
                elmes += '<li id=' + options.elem[i].id + '>' + options.elem[i].title + '</li>';
            }
            // elmes += '</ul>';
            $('#' + options.contId + ' .dropme').html(elmes);
        }

        return this.each(function() {
            var regEx = new RegExp("/^enable|disable|destroy$/");
            if (userOpt.match(regEx)) {

                var itemInOpt = $(this).data('items');

                var items = $(this).children(itemInOpt);

                if (userOpt == 'enable') {
                    items.attr('draggable', true);
                } else {
                    items.attr('draggable', false);
                }

                if (userOpt == 'destroy') {
                    items.add(this).removeData('linkTo items').off(JSON.stringify(eventStack));
                }
                return;
            }
            var index, items = $(this).children(options.items);

            var replacer = $('<' + (this.tagName.match(/^ul|ol|div$/i) ? 'li' : 'div') + ' class="drop-replacer">');

            $(this).data('items', options.items);

            replacerSet = replacerSet.add(replacer);

            if (options.linkTo) {
                $(options.linkTo).add(this).data('linkTo', options.linkTo);
            }

            items.attr('draggable', 'true').on(eventStack[0], function(e) {
            	var h = $(this).css("height");
				$(replacerSet).css("height", h);	// 이동시킬 때 그림자 높이
				var thisClass = $(this).attr('class');
				if('calender_info' == thisClass){
					drag_category_class = thisClass;
					drag_category_x = $(this).children('.this_category_x').val();
					drag_category_categoryId = $(this).children('.this_category_id').val();
				}else{
					// 초기화
					drag_category_class = "";
					drag_category_x = "";
					drag_category_projectId = "";
					drag_category_categoryId = "";
				}
				
            	drag_before_calender_category_id = $(this).parent().children(".calender_info").children(".this_category_id").val();
            	drag_before_calender_id = $(this).children(".this_calender_id").val();
            	
            	drag_before_calender_y = $(this).children(".this_calender_yPos").val();
            	drag_before_calender_index = $(this).parent().eq($(this).index());
            	
            	var dataTrnsfr = e.originalEvent.dataTransfer;
                dataTrnsfr.effectAllowed = 'move';
                dataTrnsfr.setData('Text', 'dummy');
                elmDrag = $(this);
                index = (elmDrag).addClass('drop-elmDrag').index();
            }).on(eventStack[1], function() { 
            	
            	// 일정 이동 시
            	if("" == drag_category_class){
            		calenderMoveAjax(this);
            	}else{
            		categoryMoveAjax(this);
            	}
   	
                (elmDrag = $(this)).removeClass('drop-elmDrag').show();
                replacerSet.detach();
                if (index != elmDrag.index()) {
                    items.parent().trigger('sortupdate', {
                        item: elmDrag
                    });
                }
                elmDrag = null;
                
            }).not('a[href], img').on(eventStack[2], function() {
                this.dragDrop && this.dragDrop();
                return false;
            }).end().add([this, replacer]).on('dragover dragenter drop', function(event) {
                if (!items.is(elmDrag) && options.linkTo !== $(elmDrag).parent().data('linkTo')) {
                    return true;
                }
                if (event.type == 'drop') {
                	
                    event.stopPropagation();
                    replacerSet.filter(':visible').after(elmDrag);
                    return false;
                }
                event.preventDefault();
                event.originalEvent.dataTransfer.dropEffect = 'move';
                if (items.is(this)) {
                    if (options.replacerSize) {
                        replacer.height(elmDrag.outerHeight());
                    }
                    /* 이부분이 이동하는 카테고리의 그림자 보이는 곳 */
                    elmDrag.hide();
                    $(this)[replacer.index() < $(this).index() ? 'after' : 'before'](replacer);
                    replacerSet.not(replacer).detach();
                } else if (!replacerSet.is(this) && !$(this).children(options.items).length) {
                    replacerSet.detach();
                    $(this).append(replacer);
                }
                return false;
            });
        });
    };
})(jQuery);

function categoryMoveAjax(moveCategory){
	// 카테고리 이동 시
    var categoryList = $(moveCategory).parent().children('.calender_info');
    var size = $(moveCategory).parent().children('.calender_info').length;
    var x = 0;
    var categoryId = 0;
    
    $.each(categoryList, function(index, category){
      	var tempCategoryId = $(category).children('.this_category_id').val();
     	// 이동한 카테고리 정보 저장
     	if(tempCategoryId != drag_category_categoryId ){
     		categoryId = tempCategoryId;
     		x = $(category).children('.this_category_x').val();
     	}
    });
    
    // ajax 요청
    var data = { projectId:add_project_id, moveCategoryId:drag_category_categoryId, moveCategoryX:drag_category_x, oriCategoryId:categoryId, oriCategoryX:x };
    var url = "editCategoryMove.do";
 
    ajaxRequest(url, data);
}

// this를 moveCategory로 받음
function calenderMoveAjax(moveCalender){
	var drag_after_calender_category_id = 0;// 이동 후 일정의 카테고리 id
	var drag_after_calender_id = 0;			// 이동 후 일정 id
	var drag_after_calender_y = 0;			// 이동 후 일정 y
	var drag_after_calender_index = 0;		// 이동 후 일정 index
	var isSameCategory = 0;					// 이동전 후 비교해서 같은 카테고리인지
	
	
	$(moveCalender).children(".this_category_id").val(drag_after_calender_category_id);
	drag_after_calender_index = $(moveCalender).index();
	// 카테고리 id 갱신
	drag_after_calender_category_id = $(moveCalender).parent().children(".calender_info").children(".this_category_id").val()
	if(drag_before_calender_category_id == drag_after_calender_category_id)
		isSameCategory = 1;
	var data = "";
	if(1 == isSameCategory){
		var size = $(moveCalender).parent().children().length - 1; // 인덱스는 길이보다 1작다
		var y = 0;
		for(var index = size; index >= 1; --index){
    	    var calenderId = $(moveCalender).parent().children().eq(index).children(".this_calender_id").val();
    	    if(undefined == calenderId)
    			continue;
    	    	            	    
    	    data += drag_before_calender_category_id+",";
    	    data += calenderId+",";
    	    data += y + "|";
    		$(moveCalender).parent().children().eq(index).children(".this_calender_yPos").val(y++);
    	}            		
	}else{
		// y값 갱신
    	//이동한 곳 밑에 노드가 있으면 y값 구하고 1 더해줌. 아니면 0넣어줌
    	if(null == $(moveCalender).parent().children().eq($(moveCalender).index()+1)){
    		drag_after_calender_y = $(moveCalender).parent().children().eq($(moveCalender).index()+1).children(".this_calender_yPos")+1;
    	}
    	
    	// 이동한 곳 처리. y값 전체 재설정
    	var size = $(moveCalender).parent().children().length - 1; // 인덱스는 길이보다 1작다
    	var otherY = 0;
    	for(var index = size; index >= 1; --index){
    	    var calenderId = $(moveCalender).parent().children().eq(index).children(".this_calender_id").val();
    	    if(undefined == calenderId)
    			continue;
    	    
    	    data += drag_after_calender_category_id+",";
    	    data += calenderId+",";
    	    data += otherY + "|";
    		$(moveCalender).parent().children().eq(index).children(".this_calender_yPos").val(otherY++);	            		
    	}
    
    	var list =  $(".this_category_id").filter("input[value="+drag_before_calender_category_id+"]").parent().parent();	//이동하기 전 원래 있던 카테고리
    	var beforeSize = $(list).children().length - 1;	// 인덱스는 길이보다 1작다
    	var beforeY = 0;
    	for(var index = beforeSize; index >= 1; --index){
    		var calenderId = $(".this_category_id").filter("input[value="+drag_before_calender_category_id+"]").parent().parent().children().eq(index).children(".this_calender_id").val();
    		if(undefined == calenderId)
    			continue;
    		
    		data += drag_before_calender_category_id+",";
        	data += calenderId+",";
        	data += beforeY+"|";            	    
    		$(list).parent().children().eq(index).children(".this_calender_yPos").val(beforeY++);
    	}
	}
		
		// 변경된 값 전달하기
	$.ajax({
        url: "editCalenderPos.do",
        type: "POST",
        data: {data_parameter:data},
        dataType: "text",
        success: function(data) {
        },
        error:function(data){
        }
    });
}

/* 드래그 창 */
$('.dropme').dropme('enable');
$('.exclude').dropme({
				items: ':not(.disabled)'
			});
			$('.connected').dropme({
				linkTo: '.connected'
			});

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

// 일정 추가 버튼 '+', 수정, 삭제 눌렀을 때
function calenderButtonClick(projectId, categoryId, calenderId){

	add_project_id = projectId;				
 	add_category_id = categoryId;
 	add_calender_id = calenderId;
}

function addDynamicHtml(data){
	 $(".con").empty();
	 
	var html = "";
	var categoryId = -1;			// 카테고리 아이디 저장
	
	var projectId = 0;
    for(var i=0; i<data.length; i++){		      	
      	// 카테고리 id가 다르면 새로운 카테고리생성
      	if(categoryId != data[i].categoryId){
      		if(0 != i){
      			add_project_id = data[i].projectId;
      			projectId = data[i].projectId;
      			html += '</ul>';
      		}
      		
      		html += '<ul class="connected li1">';
      		html += '<li class="calender_info">';
      		html += '<input class="category-name-input" type="text" readonly="true" value="'+data[i].categoryName+'"></input>';
      		html += '<img src="/KocoFarmPro/img/schedule/dustbin.png" class="category-delete-btn" data-toggle="modal" data-target="#categoryDeleteModal"/>';
			html += '<button type="button" class="btn  btn-primary calenderWriteBtn btn-block" data-toggle="modal" data-target="#calenderAddModal">새 일정 추가</button>';
			html += '<input type="hidden" class="this_project_id" value='+data[i].projectId+' />';
      		html += '<input type="hidden" class="this_category_id" value='+data[i].categoryId+' />';
      		html += '<input type="hidden" class="this_category_x" value='+data[i].xPos+' />';
      		html += '</li>';
    		categoryId = data[i].categoryId;
      		
      	}
      	
      	// 캘린더 id가 0이 아니라면
      	if(0 != data[i].calenderId){
            html += '<li class="calender_detail">';
            
            if("" != data[i].backgroundColor ){
            	html += '<div class="calender-detail-color" style="background-color:#'+data[i].backgroundColor +'";>'+'&nbsp;'+'</div>';
            }
            
            html += '<div><img src="/KocoFarmPro/img/schedule/settings.png" class="calender-modify-btn" data-toggle="modal" data-target="#calenderModify"/></div>';
            html += '<div class="calender_detail_title ">'+data[i].title+'</div>';
            /*html += '<div>calender:id'+data[i].calenderId+'</div>';*/
            html += '<input type="hidden" class="this_calender_id" value='+data[i].calenderId+' />';
            html += '<input type="hidden" class="this_calender_yPos" value='+data[i].yPos+' />';            
            var startDt = data[i].startDt;
            var endDt = data[i].endDt;
            if("" != startDt || "" != endDt ){
	            html += '<span class="calender_detail_startDt">'+ startDt.substring(0,10)+'</span><span> - </span>';
	            html += '<span class="calender_detail_endDt">'+endDt.substring(0,10)+'</span>';
            }
            html += '<input type="hidden" class="calender_detail_completionPer" value="'+ data[i].completionPer+'"></input>';
            html += '<div class="calender-progress-bar">';
            html += '<div style=" height: 20px; background-color: #4CAF50; border-radius:10px; width:'+data[i].completionPer+'%" >'+data[i].completionPer+'</div>'
            html += '</div>';
            
            html += '</li>';	      		
      	}
    }//for문

		// 동적으로 생성된 element 이벤트 붙이기
		html += '</ul>';
	    
    	// 새  카테고리
		html += '<ul class="connected li1">';
		html += '<li class="calender_info">';
  		html += '<div><input class="category-name-input add-category-name-input" type="text"></input><div>';
        html += '<button type="button" class="btn btn-light btn-block add-category-button">새 카테고리 추가</button>';
		html += '<input type="hidden" class="this_project_id" value='+projectId+' />';
		html += '</li>';
		html += '</ul>';
		
		$(".con").append(html); 
	    
	    $('.dropme').dropme('enable');
	    $('.exclude').dropme({
	    	items: ':not(.disabled)'
	    });
	    $('.connected').dropme({
	    	linkTo: '.connected'
	    });

	    // 일정 추가 버튼 클릭
	   $(document).on("click", ".calenderWriteBtn", function(){	
		   // eq로 찾는거 자꾸 위치가 바뀌므로 좋지 않다
			var par = $(this).parent();	// calender_info
			var project_id = par.children(".this_project_id").val();
			var category_id = par.children(".this_category_id").val();
			calenderButtonClick(project_id, category_id, 0);
		});
	   
	    // 세팅 버튼에 이벤트 추가
	   $(document).on("click", ".calender-modify-btn", function(){	   
		   var par = $(this).parent().parent(); //calender_detail
		   var parpar = par.parent().children('.calender_info'); 
		   
		   var project_id = parpar.children(".this_project_id").val();
		   var category_id = parpar.children(".this_category_id").val();
		   var calender_id = par.children('.this_calender_id').val();
		   
		   // 정보 추출
		   var color 		= $(par).children(".calender-detail-color").css("background-color");
		   var title 		= $(par).children(".calender_detail_title").html();
		   var startDt 		= $(par).children(".calender_detail_startDt").html();
		   var endDt 		= $(par).children(".calender_detail_endDt").html();
		   var completionPer= $(par).children(".calender_detail_completionPer").val();
		   

		 	var val = $("#calenderModify").children(".modal-dialog").children(".modal-content").children(".modal-body");
			
			// 값 넣기
			val.children("input[name=write]").val(title);
			val.children("input[name=editDatepickerStart]").val(startDt);
			val.children("input[name=editDatepickerEnd]").val(endDt);
			$("#editCalenderCompletionPerVal").val(completionPer);

			calenderButtonClick(project_id, category_id, calender_id);
	   });
	   
	   /* 카테고리 값 체인지 이벤트 */
	   $('.category-name-input').on("dblclick", function(){
		   $(this).attr("readonly", false);
	   });
	   
	   $('.category-name-input').on("focusout", function(){
		   $(this).attr("readonly", true);
		   
		   var par = $(this).parent();
		   var categoryId = par.children('.this_category_id').val();
		   var categoryName = par.children('.category-name-input').val();
		   
		   var data =  { "categoryId":categoryId, "categoryName":categoryName };
		   var url = "editCategoryName.do";
		   ajaxRequest(url, data);		   
	   });
	   
	   $('.add-category-button').on("click", function(){
		   var text = $('.add-category-name-input').val(); 
		  if("" == text){
			  alert("카테고리 이름이 없습니다");
			  return;
		  }
		  
		  var xPos = $('.category-name-input').length+1;
		  var data = { "projectId":add_project_id, "xPos":xPos, "categoryName":text };
		  var url = "insertCategory.do";
		  		   
		  ajaxRequest(url, data);
	   });
	   
	   // 카테고리 삭제 버튼
	   $('.category-delete-btn').on("click", function(){
		   var parent = $(this).parent();
		   add_category_id = parent.children(".this_category_id").val();
		   add_project_id = parent.children(".this_project_id").val();
	   });
}

function ajaxRequest(sendUrl, sendData){
	$.ajax({
	    type:"POST",
	    data : sendData,
	    dataType:"text",
	    url:sendUrl,
	    success: function(data) {
	    	calenderList();
	    },
	    error : function(error) {
	    },	// error
	  });// ajax
}

function calenderList(){
	$.ajax({
	    type:"POST",
	    data : {"projectId":add_project_id},
	    dataType:"json",
	    url:"listCalender.do",
	    success: function(data) {
	    	addDynamicHtml(data);
	    },
	    error : function(error) {
	    },	// error
	  });// ajax
}

// 카테고리 삭제 모달 버튼
$('#delete-project-button').click(function(){
	var url = "delCategory.do";
	var data = {projectId:add_project_id, categoryId:add_category_id};

    ajaxRequest(url, data);

});

//일정 추가 버튼 눌렀을 때
$('#calender_add').click(function() {
	
	 var write 			= $("input[name=write]").val();
	 var color 			= add_calender_color_value;
	 var completion_per = $("input[name=addCompletionPer]").val();
	 var tag 			= $("input[name=tag]").val();
	 var category		= $("input[value="+add_category_id+"]").parent();	// 선택한 카테고리 클릭
	 var y 				= category.parent().children().last().index()+1;	// 마지막 자식 노드 인덱스, 카테고리 때문에 1더함
	 var startDt 		= $("input[name=addDatepickerStart]").val();
	 var endDt 			= $("input[name=addDatepickerEnd]").val();
 
	 if(null == write || "" == write){
		 alert("일정 정보가 없습니다");
		 return;
	 }
	 
	 $('#calenderAddModal').modal('toggle');
	 clearAddDlg($(this).parent());
	 
	 var data = { projectId:add_project_id, categoryId:add_category_id, write:write,color:color, completionPer:completion_per,tag:tag,y:y,startDt:startDt,endDt:endDt  };
	 var url = "insertCalender.do";
	 
	 ajaxRequest(url, data);
  
});//click


$('#calender_edit').click(function(){
	 var par 			=  $(this).parent();	// modal-body
	 var write 			= par.children("input[name=write]").val();	 
	 var color 			= add_calender_color_value;
	 var completion_per = $("#editCalenderCompletionPerVal").val();
	 var startDt 		= par.children("input[name=editDatepickerStart]").val();
	 var endDt 			= par.children("input[name=editDatepickerEnd]").val();
	 var tag 			= par.children("input[name=tag]").val();

	 var data = { projectId:add_project_id, categoryId:add_category_id,calenderId:add_calender_id ,write:write,color:color, completionPer:completion_per,tag:tag,startDt:startDt,endDt:endDt  };
	 var url = "editCalender.do";
	  
	 $('#calenderModify').modal('toggle');
	  
	 ajaxRequest(url, data);
});

// 일정 삭제
$('#calender_del').click(function(){
	
	$('#calenderModify').modal('toggle');
	var data = { calenderId:add_calender_id };
	var url = "delCalender.do";
	
	 ajaxRequest(url, data);	
});

/* 일정 추가 후 데이터 초기화 */
function clearAddDlg(this_parent){
	$("input[name=write]").val("");
	add_calender_color_value = "ffffff";
	$("input[name=addCompletionPer]").val(0);
	$("input[name=addDatepickerStart]").val("");
	$("input[name=addDatepickerEnd]").val("");
}

/* 배경 rgb값을 16진수로 convert */
function hexc(colorval) {
	
    var parts = colorval.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
    delete(parts[0]);
    for (var i = 1; i <= 3; ++i) {
        parts[i] = parseInt(parts[i]).toString(16);
        if (parts[i].length == 1) parts[i] = '0' + parts[i];
    }
   
    color = parts.join('');
    return color;
}

/* 일정 컬러색 가져오기 */
$(document).on("click", ".tag-important, .tag-approve, .tag-quickly, .tag-request", function(){
	var color = $(this).css('background-color');
	add_calender_color_value = hexc(color);
});