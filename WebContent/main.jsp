<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/module/main.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>KocoFarm <span>그룹웨어에 오신 것을 환영 합니다.</span></h2>
				</div>
			</div>
		</div>
		
		<!-- Contents Area -->
		<div class="contents_wrap">
			<div class="main_box">
				<div class="main_contents">
					<!-- 날씨 영역 -->
					<c:import var="xmlWeather" url="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000" />
					<x:parse var="weather" xml="${xmlWeather}"/>
					
					<div class="weather">
						<x:forEach var="weatherContents" select="$weather/rss/channel/item" varStatus="status">
							
							<h2 class="txt_c"><x:out select="category" /> 날씨</h2>
							<div class="weather_inner">
								<div class="weather_icon">
									<x:set var="wfEn" select="$weatherContents/description/body/data[1]/wfEn"/>
									
									<x:if select="'Clear'=$wfEn">
										<img class="weather_img" src="img/comm/Clear.png" alt="Clear.png" />
									</x:if>
									<x:if select="'Partly Cloudy'=$wfEn or 'Mostly Cloudy'=$wfEn or 'Cloudy'=$wfEn">
										<img class="weather_img" src="img/comm/Cloudy.png" alt="Cloudy.png" />
									</x:if>
									<x:if select="'Rain'=$wfEn">
										<img class="weather_img" src="img/comm/Rain.png" alt="Rain.png" />
									</x:if>
									<x:if select="'Snow'=$wfEn or 'Snow/Rain'=$wfEn">
										<img class="weather_img" src="img/comm/Snow.png" alt="Snow.png" />
									</x:if>
								</div>
								<div class="weather_info">
									<p>시간 <span><x:out select="description/body/data[1]/hour" />(24시 기준)</span></p>
									<p>온도 <span><x:out select="description/body/data[1]/temp" />℃</span></p>
									<p>습도 <span><x:out select="description/body/data[1]/reh" />%</span></p>
									<p>풍향 <span><x:out select="description/body/data[1]/wdKor" /></span></p>
									<p>강수확률 <span><x:out select="description/body/data[1]/pop" />%</span></p>
								</div>
							</div>
						</x:forEach>
					</div><!-- weather E -->
					
					<!-- 뉴스 영역 -->
					<c:import var="xmlNews" url="https://news.google.com/rss?hl=ko&gl=KR&ceid=KR:ko" />
					<x:parse var="news" xml="${xmlNews}"/>
					
					<div class="news">
						<table class="contents_tb wth100p" id="contTb">
							<colgroup>
								<col width="*">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">뉴스 제목</th>
								</tr>
							</thead>
							<tbody id="contentsTbBody">
								<x:forEach var="newsContents" select="$news/rss/channel/item" varStatus="status">
									<tr>
										<td class="left">
											<a href="<x:out select='link' />" target="_blank"> <x:out select="title" /></a>
										</td>	
							        </tr>
								</x:forEach>
							</tbody>
						</table>
					</div>
					
				</div><!-- main_contents E -->
			</div><!-- main_box E -->
		</div><!-- contents_wrap E -->
	</div><!-- cont_wrap E -->
	
<script type="text/javascript" src="/KocoFarmPro/js/module/main.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>