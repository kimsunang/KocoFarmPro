<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import=" java.io.File"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/fileRoom.css" />

</head>
<body>
	<!-- Tab -->
	<div class="tab_wrap">
		<ul class="tab_ul">
			<div class="left">
				<li class="tab_li on" id="file_uload">업로드</li>
				<li class="tab_li" id="photo_file">사진</li>
				<li class="tab_li" id="text_file">문서</li>
				<li class="tab_li" id="movie_file">동영상</li>
			</div>
		</ul>
	</div>

	<!-- list -->
	<div class="contents">
		<!-- 일반 리뷰 -->
		<table class="contents_tb" id="contTb">
			<colgroup>
				<col width="5.45454%">
				<col width="74.5454%">
				<col width="10.90909%">
				<col width="*">
			</colgroup>
			<thead>
				<div id="left bar">
					<tr>
						<th scope="col">NO</th>
						<th scope="col">제목</th>
						<th scope="col">글쓴이</th>
						<th scope="col">등록 일</th>
					</tr>
				</div>
			</thead>
			<tbody id="contentsTbBody">
			</tbody>
		</table>

		<!-- 포토 리뷰 -->
		<div class="dpInB wth100p dp_none" id="contImg">
			<ul class="img_contents_ul"></ul>

		</div>
	</div>


</body>
</html>