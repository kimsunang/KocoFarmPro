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
            	console.log("6");
                $(options.linkTo).add(this).data('linkTo', options.linkTo);
            }

            items.attr('draggable', 'true').on(eventStack[0], function(e) {
            	console.log("7");
            	console.log("category_id:"+$(this).parent().children(".calender_info").children(".this_category_id").val());
            	console.log("category_id"+"선택한 일정 타이틀:"+$(this).children(".calender_detail_title").html() +"calender_id:"+$(this).children(".this_calender_id").val() +"yPos:"+ $(this).children(".this_calender_yPos").val());

            	console.log($(this).parent());
            	console.log($(this).parent().children(".calender_info"));
            	drag_before_calender_category_id = $(this).parent().children(".calender_info").children(".this_category_id").val();
            	console.log('drag_before_calender_category_id:'+drag_before_calender_category_id);
            	drag_before_calender_id = $(this).children(".this_calender_id").val();
            	
            	drag_before_calender_y = $(this).children(".this_calender_yPos").val();
            	drag_before_calender_index = $(this).parent().eq($(this).index());
            	console.log('현재 index:'+drag_before_calender_index);
            	
            	var dataTrnsfr = e.originalEvent.dataTransfer;
                dataTrnsfr.effectAllowed = 'move';
                dataTrnsfr.setData('Text', 'dummy');
                elmDrag = $(this);
                index = (elmDrag).addClass('drop-elmDrag').index();
            }).on(eventStack[1], function() {
            	console.log("8");
            	//console.log($(this).index());
            	
            	var drag_after_calender_category_id = 0;// 이동 후 일정의 카테고리 id
            	var drag_after_calender_id = 0;			// 이동 후 일정 id
            	var drag_after_calender_y = 0;			// 이동 후 일정 y
            	var drag_after_calender_index = 0;		// 이동 후 일정 index
            	var isSameCategory = 0;					// 이동전 후 비교해서 같은 카테고리인지
            	
            	
            	$(this).children(".this_category_id").val(drag_after_calender_category_id);
            	drag_after_calender_index = $(this).index();
            	// 카테고리 id 갱신
            	drag_after_calender_category_id = $(this).parent().children(".calender_info").children(".this_category_id").val()
            	if(drag_before_calender_category_id == drag_after_calender_category_id)
            		isSameCategory = 1;
            	var data = "";
            	if(1 == isSameCategory){
            		// 같은 카테고리 내 이동
            		// 순서대로 y값을 준다
            		var size = $(this).parent().children().length - 1; // 인덱스는 길이보다 1작다
            		var y = 0;
            		console.log('같은카테고리 이동:'+size);
            		for(var index = size; index >= 1; --index){
	            	    var calenderId = $(this).parent().children().eq(index).children(".this_calender_id").val();
	            	    if(undefined == calenderId)
	            			continue;
	            	    
	            	    console.log(drag_before_calender_category_id);
	            	    
	            	    data += drag_before_calender_category_id+",";
	            	    data += calenderId+",";
	            	    data += y + "|";
	            		$(this).parent().children().eq(index).children(".this_calender_yPos").val(y++);
	            		
	            		console.log(data);
	            	}            		
            	}else{
            		// y값 갱신
	            	//이동한 곳 밑에 노드가 있으면 y값 구하고 1 더해줌. 아니면 0넣어줌
                	if(null == $(this).parent().children().eq($(this).index()+1)){
	            		drag_after_calender_y = $(this).parent().children().eq($(this).index()+1).children(".this_calender_yPos")+1;
	            	}
	            	
	            	// 이동한 곳 처리. y값 전체 재설정
	            	var size = $(this).parent().children().length - 1; // 인덱스는 길이보다 1작다
	            	//console.log('이동한 카테고리의 자식개수 :'+size);
	            	var otherY = 0;
	            	for(var index = size; index >= 1; --index){
	            	    var calenderId = $(this).parent().children().eq(index).children(".this_calender_id").val();
	            	    if(undefined == calenderId)
	            			continue;
	            	    
	            	    data += drag_after_calender_category_id+",";
	            	    data += calenderId+",";
	            	    data += otherY + "|";
	            		$(this).parent().children().eq(index).children(".this_calender_yPos").val(otherY++);
	            		
	            		//console.log(data);
	            	}
	            
	            	var list =  $(".this_category_id").filter("input[value="+drag_before_calender_category_id+"]").parent().parent();	//이동하기 전 원래 있던 카테고리
	            	var beforeSize = $(list).children().length - 1;	// 인덱스는 길이보다 1작다
	            	//console.log('이동 전 카테고리의 자식개수 :'+beforeSize);
	            	var beforeY = 0;
	            	for(var index = beforeSize; index >= 1; --index){
	            		var calenderId = $(".this_category_id").filter("input[value="+drag_before_calender_category_id+"]").parent().parent().children().eq(index).children(".this_calender_id").val();
	            		if(undefined == calenderId)
	            			continue;
	            		
	            		data += drag_before_calender_category_id+",";
	                	data += calenderId+",";
		            	data += beforeY+"|";            	    
	            		$(list).parent().children().eq(index).children(".this_calender_yPos").val(beforeY++);
	            		//console.log(data);
	            	}
            	}
            		
           		// 변경된 값 전달하기
            	$.ajax({
                    url: "editCalenderPos.do",
                    type: "POST",
                    data: {data_parameter:data},
                    dataType: "text",
                    success: function(data) {
                   	 console.log('edit pos 성공');
                    },
                    error:function(data){
                   	 console.log('edit pos 실패');
                    }
                });

            	//console.log("카테고리 id:"+$(this).parent().children(".calender_info").children(".this_category_id").val());
            	//console.log($(this).children(".calender_detail_title").html());
            	//console.log($(this).children(".this_calender_id").val());
            	
                (elmDrag = $(this)).removeClass('drop-elmDrag').show();
                replacerSet.detach();
                if (index != elmDrag.index()) {
                    items.parent().trigger('sortupdate', {
                        item: elmDrag
                    });
                }
                elmDrag = null;
                
                //console.log('내가 확인해야할 것');
                //console.log($(".this_category_id").filter("input[value="+drag_before_calender_category_id+"]").parent());
                //console.log("이동전 size:"+$(".this_category_id").filter("input[value="+drag_before_calender_category_id+"]").parent().parent().children().length+"이동 후 size:"+$(this).parent().children().length);
            }).not('a[href], img').on(eventStack[2], function() {
            	console.log(this);
                this.dragDrop && this.dragDrop();
                return false;
            }).end().add([this, replacer]).on('dragover dragenter drop', function(event) {
                if (!items.is(elmDrag) && options.linkTo !== $(elmDrag).parent().data('linkTo')) {
                    return true;
                }
                if (event.type == 'drop') {
                	
                    event.stopPropagation();
                    replacerSet.filter(':visible').after(elmDrag);
                    console.log(this);
                    console.log('성공');
                    return false;
                }
                event.preventDefault();
                event.originalEvent.dataTransfer.dropEffect = 'move';
                if (items.is(this)) {
                    if (options.replacerSize) {
                        replacer.height(elmDrag.outerHeight());
                    }
                    elmDrag.hide();
                    $(this)[replacer.index() < $(this).index() ? 'after' : 'before'](replacer);
                    replacerSet.not(replacer).detach();
                } else if (!replacerSet.is(this) && !$(this).children(options.items).length) {
                    replacerSet.detach();
                    $(this).append(replacer);
                }
                //console.log("8");
                return false;
            });
        });
    };
})(jQuery);

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
      			projectId = data[i].projectId;
      			html += '</ul>';
      		}
      		
      		html += '<ul class="connected li1">';
      		html += '<li class="calender_info">';
      		html += '<div class="category-name-box"><input class="category-name-input" type="text" readonly="true" value="'+data[i].categoryName+'"></input></div>';
      		html += '<div><button type="button" class="btn  btn-primary calenderWriteBtn btn-block" data-toggle="modal" data-target="#calenderAddModal">새 일정 추가하기</button></div>';
      		//console.log(data[i].projectId);
      		//console.log(data[i].categoryId);
      		//console.log(data[i].calenderId);
    		html += '<input type="hidden" class="this_project_id" value='+data[i].projectId+' />';
      		html += '<input type="hidden" class="this_category_id" value='+data[i].categoryId+' />';
      		html += '<input type="hidden" class="this_category_x" value='+data[i].xPos+' />';
      		html += '</li>';
    		categoryId = data[i].categoryId;
      		
      	}
      	
      	// 캘린더 id가 0이 아니라면
      	if(0 != data[i].calenderId){
            html += '<li class="calender_detail">';
            html += '<div class="calender_detail_color" style="background-color:#'+data[i].backgroundColor +'";>'+'&nbsp;'+'</div>';
            html += '<div class="calender_detail_title">'+data[i].title+'</div>';
            html += '<div>calender:id'+data[i].calenderId+'</div>';
            html += '<input type="hidden" class="this_calender_id" value='+data[i].calenderId+' />';
            html += '<input type="hidden" class="this_calender_yPos" value='+data[i].yPos+' />';            
            html += '<button type="button" class="btn btn-info btn-lg calenderModifyBtn" data-toggle="modal" data-target="#calenderModify">설정</button>';
            html += '<p>시작일 :</p><p class="calender_detail_startDt">'+ data[i].startDt+"</p>";
            html += '<p>종료일 :</p><p class="calender_detail_endDt">'+ data[i].endDt+"</p>";
            html += '완료상황:<p class="calender_detail_completionPer">'+ data[i].completionPer+"</p>";
			html += '</li>';	      		
      	}
    }//for문

		// 동적으로 생성된 element 이벤트 붙이기
		html += '</ul>';
	    
    	// 새  카테고리
		html += '<ul class="connected li1">';
		html += '<li class="calender_info">';
  		html += '<div><input class="add-category-name-input" type="text"></input><div>';
        html += '<button type="button" class="btn btn-warning btn-lg btn-xs addCategoryButton">새 카테고리 추가</button>';
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
			console.log('project_id:' + project_id);
			console.log('category_id:' + category_id);
			
			calenderButtonClick(project_id, category_id, 0);
		});
	   
	    // 세팅 버튼에 이벤트 추가
	   $(document).on("click", ".calenderModifyBtn", function(){
		   console.log('수정 버튼 클릭');		   
		   var par = $(this).parent(); //calender_detail
		   var parpar = par.parent().children('.calender_info'); 
		   
		   var project_id = parpar.children(".this_project_id").val();
		   var category_id = parpar.children(".this_category_id").val();
		   var calender_id = par.children('.this_calender_id').val();
		   
		   console.log(par);
		   // 정보 추출
		   var color 		= $(par).children(".calender_detail_color").css("background-color");
		   var title 		= $(par).children(".calender_detail_title").html();
		   var startDt 		= $(par).children(".calender_detail_startDt").html();
		   var endDt 		= $(par).children(".calender_detail_endDt").html();
		   var completionPer= $(par).children(".calender_detail_completionPer").html();

		   //completionPer = completionPer.replace("/[^0-9]/g");
		   
			console.log('project_id:'+project_id);
			console.log('category_id:'+category_id);
			console.log('calender_id:'+calender_id);
			
			console.log("color:"+color+"title:"+title+"startDt:"+startDt+"endDt:"+endDt+"completionPer:"+completionPer);
			
			//var parent = $("#calenderModify").children(".modal-dialog").children(".modal-body");
			var val = $("#calenderModify").children(".modal-dialog").children(".modal-content").children(".modal-body");
			console.log(completionPer);
			
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
	   
	   $('.category-name-input').on("change", function(){
		   $(this).attr("readonly", true);
		   
		   //ajax
		   
	   });
	   
	   $('.addCategoryButton').on("click", function(){
		  var text = $('.add-category-name-input').val(); 
		  if("" == text){
			  alert("카테고리 이름이 없습니다");
			  return;
		  }
		  
		  var xPos = $('.category-name-input').length+1;
		  
		 $.ajax({
		    type:"POST",
		    data : { categoryName:text, projectId:projectId, xPos:xPos  },
		    dataType:"text",
		    url:"insertCategory.do",
		    success: function(project_id) { 	
		 	
		 	$.ajax({
				url:'listCalender.do',
				data: {"projectId":project_id},
				dataType:'json',
				success:function(data){	
					
				 addDynamicHtml(data);
				}// success function
			});// ajax
		    },
		    error : function(error) {
		    	console.log("state:"+error.state()+"ajax 실패:"+error.responseText+"html:"+error.result_html);
		    },	// error
		  });// ajax
		  
	   });
}

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
	 
	 //console.log($(".this_category_id").filter("input[value="+add_category_id+"]"));
	 //console.log("startDt:"+startDt+"endDt:"+endDt);
	 //console.log("completion_per:"+completion_per);
	 $('#calenderAddModal').modal('toggle');
	 clearAddDlg($(this).parent());
	 
	 $.ajax({
	    type:"POST",
	    data : { projectId:add_project_id, categoryId:add_category_id, write:write,color:color, completionPer:completion_per,tag:tag,y:y,startDt:startDt,endDt:endDt  },
	    dataType:"text",
	    url:"insertCalender.do",
	    success: function(project_id) { 	
	 	
	 	$.ajax({
			url:'listCalender.do',
			data: {"projectId":add_project_id},
			dataType:'json',
			success:function(data){	
				
			 addDynamicHtml(data);
			}// success function
		});// ajax
	    },
	    error : function(error) {
	    	console.log("state:"+error.state()+"ajax 실패:"+error.responseText+"html:"+error.result_html);
	    },	// error
	  });// ajax
	  
	});//click


$('#calender_edit').click(function(){
	console.log('일정 수정');
	
	 var par 			=  $(this).parent();	// modal-body
	 var write 			= par.children("input[name=write]").val();	 
	 var color 			= add_calender_color_value;
	 var completion_per = $("#editCalenderCompletionPerVal").val();
	 var startDt 		= par.children("input[name=editDatepickerStart]").val();
	 var endDt 			= par.children("input[name=editDatepickerEnd]").val();
	 var tag 			= par.children("input[name=tag]").val();
	 
	 console.log("write:"+write+"startDt:"+startDt+"endDt:"+endDt+"color:"+color);
	 console.log("completion_per:"+completion_per);

	 $('#calenderModify').modal('toggle');
	 $.ajax({
		    type:"POST",
		    data : { projectId:add_project_id, categoryId:add_category_id,calenderId:add_calender_id ,write:write,color:color, completionPer:completion_per,tag:tag,startDt:startDt,endDt:endDt  },
		    dataType:"text",
		    url:"editCalender.do",
		    success: function(project_id) {
		     console.log("ajax 수정 성공!!!!!!!!");
		 	
		 	
		 	$.ajax({
				url:'listCalender.do',
				data: {"projectId":add_project_id},
				dataType:'json',
				success:function(data){			
				 addDynamicHtml(data);
				}// success function
			});// ajax
		    },
		    error : function(error) {
		    	console.log("state:"+error.state()+"ajax 실패:"+error.responseText+"html:"+error.result_html);
		    },	// error
		  });// ajax
});

$('#calender_del').click(function(){
	console.log('일정 삭제');
	
	$('#calenderModify').modal('toggle');
	console.log("add_calender_id:"+add_calender_id);
	
	$.ajax({
		    type:"POST",
		    data : { calenderId:add_calender_id  },
		    dataType:"text",
		    url:"delCalender.do",
		    success: function(project_id) {
		     console.log("일정 삭제 성공!!!!!!!!");
		 	
		 	$.ajax({
				url:'listCalender.do',
				data: {"projectId":add_project_id},
				dataType:'json',
				success:function(data){			
					addDynamicHtml(data);	
				}// success function

			});// ajax
		    },
		    error : function(error) {
		    	console.log("state:"+error.state()+"ajax 실패:"+error.responseText+"html:"+error.result_html);
		    },	// error
		  });// ajax
	
	
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
	console.log(colorval);
    var parts = colorval.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
    delete(parts[0]);
    for (var i = 1; i <= 3; ++i) {
        parts[i] = parseInt(parts[i]).toString(16);
        if (parts[i].length == 1) parts[i] = '0' + parts[i];
    }
   
    color = parts.join('');
    return color;
}

/* 배경색에 따른 index 전달 */


/* 일정 컬러색 가져오기 */
$(document).on("click", ".tag-important, .tag-approve, .tag-quickly, .tag-request", function(){
	var color = $(this).css('background-color');
	add_calender_color_value = hexc(color);
});

/* 일정 추가 진행상황% 슬라이더  */
var calenderCompletionSlider = document.getElementById("calenderCompletionPerRang");
var calenderCompletionOutput = document.getElementById("calenderCompletionPerVal");

calenderCompletionSlider.oninput = function() {
	calenderCompletionOutput.value = this.value;
}

/* 일정 추가 진행상황% textbox */
$('#calenderCompletionPerVal').change(function(){
	var value = $(calenderCompletionOutput).val() ;
	if(false == isNaN(value)){
		if(0 > value) value = 0;
		if(100 < value) value = 100;
		$(calenderCompletionSlider).val($(this).val());
		$(calenderCompletionOutput).val($(this).val());
	}else{
		$(calenderCompletionSlider).val(0);
		$(calenderCompletionOutput).val(0);
	}
});


/* 일정 수정 진행상황% 슬라이더  */
var editCalenderCompletionSlider = document.getElementById("editCalenderCompletionPerRang");
var editCalenderCompletionOutput = document.getElementById("editCalenderCompletionPerVal");

editCalenderCompletionSlider.oninput = function() {
	editCalenderCompletionOutput.value = this.value;
}

/* 일정 수정 진행상황% textbox */
$('#editCalenderCompletionPerVal').change(function(){
	var value = $(editCalenderCompletionOutput).val() ;
	if(false == isNaN(value)){
		if(0 > value) value = 0;
		if(100 < value) value = 100;
		
		$(editCalenderCompletionSlider).val($(this).val());
		$(editCalenderCompletionOutput).val($(this).val());
		
	}else{
		$(editCalenderCompletionSlider).val(0);
		$(editCalenderCompletionOutput).val(0);
	}
});