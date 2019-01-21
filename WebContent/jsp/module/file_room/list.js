var req = new XMLHTTPRequest();
req.open("GET", "./json/image_list.json");

/* 분양 리뷰 정보 가져오기 */
function getRvInfo() {
	$.ajax({
		"url" : "reviewInfo.jsp",
		"data" : {
			"schType" : $("#schType :selected").val(),
			"schWord" : $("#schWord").val(),
			"tabId" : $("li.tab_li.on").attr("id")
		},
		dataType : "json",
		success : function(data) {
			var html = "";
			var tabId = $("li.tab_li.on").attr("id");

			if ("rvTab" == tabId) {
				if (data != null && data != "") {
					/* 일반 리뷰 */
					for (var i = data.length; i > 0; i--) {
						html += "<tr>";
						html += "<td>" + i + "</td>";
						html += "<td class='left'><a>";

						if (data[i - 1].type == "notice") {
							html += "<span class='notice'>[공지] "
									+ data[i - 1].title + "</span>";
						} else {
							html += data[i - 1].title;
						}

						html += "</a></td>";
						html += "<td>" + data[i - 1].writer + "</td>";
						html += "<td>" + data[i - 1].regDate + "</td>";
						html += "</tr>";
					}
				} else {
					html = "<td colspan='4' class='txtC txtB'>데이터가 없습니다.</td>";
				}
				$("#contentsTbBody").html(html);
			} else {
				if (data != null && data != "") {
					/* 포토 리뷰 */
					for (var i = 0; i < data.length; i++) {
						html += "<li>";
						html += "<a><img src='../img/dog/" + data[i].imgNm
								+ ".jpg' /></a></li>";
					}
				} else {
					html = "<div class='txtC txtB fontC666'>데이터가 없습니다.</div>"
				}
				$(".img_contents_ul").html(html);
			}
		}
	});
};