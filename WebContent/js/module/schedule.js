/* 일정 데이터 전달 */
var add_project_id = 0;			// 프로젝트 아이디
var add_category_id = 0;		// 카테고리 아이디

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

/* 모달 창 */
//Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
// 엘레먼트가 동적 생성되어서 이벤트를 나중에 넣어준다
//var btn = document.getElementById("calenderWriteBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
/*btn.onclick = function() {
  modal.style.display = "block";
}*/

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
	modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
$(function(event){
  if (event.target == modal) {
    modal.style.display = "none";
  }
  
  
  
});
// 일정 추가 버튼 '+' 눌렀을 때
function calenderAddButtonClick(projectId, categoryId){

	// 모달 창 띄우기
    var modal = document.getElementById("myModal");
	modal.style.display = "block";
		   
	add_project_id = projectId;				
 	add_category_id = categoryId;
}

function jsFriendlyJSONStringify (s) {
	return JSON.stringify(s).
	    replace(/\\r/g, '\r').
	    replace(/\\n/g, '\n')
	}

//일정 추가 버튼 눌렀을 때
$('#calender_add').click(function() {
	
	 var write = $("input[name=write]").val();
	 var color = $("input[name=color]").val();
	 var completion_per = $("input[name=completion_per]").val();
	 var tag = $("input[name=tag]").val();
	 var category = $("input[value="+add_category_id+"]").parent();		// 선택한 카테고리 클릭
	 var y = category.parent().children().last().index()+1;				// 마지막 자식 노드 인덱스, 카테고리 때문에 1더함 
	 modal.style.display = "none";
	 
	 $.ajax({
	    type:"POST",
	    data : { projectId:add_project_id, categoryId:add_category_id,write:write,color:color, completionPer:completion_per,tag:tag,y:y  },
	    dataType:"text",
	    url:"insertCalender.do",
	    success: function(project_id) {
	     console.log("ajax 성공 다시 전달");
	 	
	 	
	 	$.ajax({
			url:'listCalender.do',
			data: {"projectId":add_project_id},
			dataType:'json',
			success:function(data){
			console.log("성공");
			

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
		      		html += '<button type="button" class="calenderWriteBtn">버튼 </button>';
		      		html += data[i].categoryName+'<button type="button" class="btn  btn-primary calenderWriteBtn">+</button>';
		      		console.log(data[i].projectId);
		      		console.log(data[i].categoryId);
		      		console.log(data[i].calenderId);
		    		html += '<input type="hidden" class="this_project_id" value='+data[i].projectId+' />';
		      		html += '<input type="hidden" class="this_category_id" value='+data[i].categoryId+' />';
		      		html += '</li>';
		    		categoryId = data[i].categoryId;
		      		
		      	}
		      	
		      	// 캘린더 id가 0이 아니라면
		      	if(0 != data[i].calenderId){
		            html += '<li class="calender_text">'+data[i].title+"<br>";
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
					var par = $(this).parent();	// ul태그 선택
					add_project_id = $(par).children().eq(2).val();
					add_category_id = $(par).children().eq(3).val();

					console.log('project_id:'+add_project_id);
					console.log('category_id:'+add_category_id);
					
				   calenderAddButtonClick(add_project_id,add_category_id);
				});
		    
			}// success function

		});// ajax
	    },
	    error : function(error) {
	    	console.log("state:"+error.state()+"ajax 실패:"+error.responseText+"html:"+error.result_html);
	    },
	  });
	  
	});