/* 일정 데이터 전달 */
var add_project_id = 0;			// 프로젝트 아이디
var add_category_id = 0;		// 카테고리 아이디
var add_calender_id = 0;		// 일정 아이디
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
                var dataTrnsfr = e.originalEvent.dataTransfer;
                dataTrnsfr.effectAllowed = 'move';
                dataTrnsfr.setData('Text', 'dummy');
                elmDrag = $(this);
                index = (elmDrag).addClass('drop-elmDrag').index();
            }).on(eventStack[1], function() {
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

/* 드래그 창 */
$('.dropme').dropme('enable');
$('.exclude').dropme({
				items: ':not(.disabled)'
			});
			$('.li_common_style').dropme({
				linkTo: '.li_common_style'
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
	
    for(var i=0; i<data.length; i++){		      	
      	// 카테고리 id가 다르면 새로운 카테고리생성
      	if(categoryId != data[i].categoryId){
      		if(0 != i)
	      		html += '</ul>';

      		html += '<ul class="li_common_style li1">';
      		html += '<li class="calender_info">';
      		html += data[i].categoryName+'<button type="button" class="btn  btn-primary calenderWriteBtn" data-toggle="modal" data-target="#calenderAddModal">+</button>';
      		//console.log(data[i].projectId);
      		//console.log(data[i].categoryId);
      		//console.log(data[i].calenderId);
    		html += '<input type="hidden" class="this_project_id" value='+data[i].projectId+' />';
      		html += '<input type="hidden" class="this_category_id" value='+data[i].categoryId+' />';
      		html += '</li>';
    		categoryId = data[i].categoryId;
      		
      	}
      	
      	// 캘린더 id가 0이 아니라면
      	if(0 != data[i].calenderId){
            html += '<li class="calender_detail">'+data[i].title+"<br>";
            html += '<input type="hidden" class="this_calender_id" value='+data[i].calenderId+' />';
            html += '<button type="button" class="btn btn-info btn-lg calenderModifyBtn" data-toggle="modal" data-target="#calenderModify">설정</button>';
            html += '시작일 :'+ data[i].startDt+"<br>";
            html += '종료일 :'+ data[i].endDt+"<br>";
			html += '</li>';	      		
      	}
    }//for문

		// 동적으로 생성된 element 이벤트 붙이기
		html += '</ul>';
	    $(".con").append(html); 
	    
	    $('.dropme').dropme('enable');
	    $('.exclude').dropme({
	    	items: ':not(.disabled)'
	    });
	    $('.li_common_style').dropme({
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
		
			console.log('project_id:'+project_id);
			console.log('category_id:'+category_id);
			console.log('calender_id:'+calender_id);
			
			calenderButtonClick(project_id, category_id, calender_id);
	   });
}

//일정 추가 버튼 눌렀을 때
$('#calender_add').click(function() {
	
	 var write = $("input[name=write]").val();
	 var color = $("input[name=color]").val();
	 var completion_per = $("input[name=completion_per]").val();
	 var tag = $("input[name=tag]").val();
	 var category = $("input[value="+add_category_id+"]").parent();		// 선택한 카테고리 클릭
	 var y = category.parent().children().last().index()+1;				// 마지막 자식 노드 인덱스, 카테고리 때문에 1더함 
	 
	 $('#calenderAddModal').modal('toggle');
	 
	 $.ajax({
	    type:"POST",
	    data : { projectId:add_project_id, categoryId:add_category_id, write:write,color:color, completionPer:completion_per,tag:tag,y:y  },
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
	
	 var par =  $(this).parent();	// modal-body
	 console.log(par);
	 var write = par.children("input[name=write]").val();	 
	 var color = par.children("input[name=color]").val();
	 var completion_per = par.children("input[name=completion_per]").val();
	 var tag = par.children("input[name=tag]").val();
	 var y = 0;					// 위치 바꾸는게 아니므로 0 넣어준다
	 
	 $('#calenderModify').modal('toggle');
	 console.log(write+",color:"+color+",completion_per:"+completion_per+",y:"+y);
	 $.ajax({
		    type:"POST",
		    data : { projectId:add_project_id, categoryId:add_category_id,calenderId:add_calender_id ,write:write,color:color, completionPer:completion_per,tag:tag,y:y  },
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