	/* 탭 이동 */
 $(".tab_li").click(function(){
  var tabId = $(this).attr("id")
  $(".tab_ul li").removeClass("on");
  $(this).addClass("on");
  
// 파일 확장자명 자르기
  
 


 });

/* 분양 리뷰 정보 가져오기 */
function getRvInfo(){
 $.ajax({
   "url" : "fileList.do"
  , "data" : {
     "schType" : $("#schType :selected").val()
    , "schWord" : $("#schWord").val()
    , "tabId"  : $("li.tab_li.on").attr("id")
   }
  , dataType : "json"
  , success : function(data){
    var html = "";
    var tabId = $("li.tab_li.on").attr("id");
    
    if("rvTab" == tabId){
    
     if(data != null && data != ""){
      /* 포토 리뷰 */
      for(var i=0; i<data.length; i++){
       html += "<li>";
       html += "<a><img src='..../img/extention_image/"+data[i].imgNm+".jpg' /></a></li>";
      }
     }else{
      html = "<div class='txtC txtB fontC666'>데이터가 없습니다.</div>"
     }
     $(".img_contents_ul").html(html);
    }
  }
 });
};