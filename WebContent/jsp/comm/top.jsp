<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/comm/common.css" />
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/comm/top.css" />
<script type="text/javascript" src="/KocoFarmPro/js/comm/jquery.js"></script>

<div id="wrap">
	<div class="top_wrap">
		<div class="top">
			<div class="gnb_wrap">
				<div class="gnb">
					<nav class="gnb_inner">
						<div class="logo">
							<a href="main.do"><img class="logo_img" /></a>
						</div>
						<div class="gnb_top">
							<ul class="gnb_top_ul">
								<c:choose>
									<c:when test="${not empty loginVO}">
										<li>${loginVO.korNm}님 환영 합니다.</li>
										<li><a href="signIn.do?mode=signOut">로그아웃</a></li>
									</c:when>
									<c:otherwise>
										<li>방문을 환영 합니다.</li>
										<li><a href="signIn.do?mode=signInPage">로그인</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
						<ul class="gnb">
							<li><a href="noticeList.do">공지사항</a></li>
							<li><a href="employees.do">인사 관리</a></li>
							<li><a href="approval.do">문서 결재</a></li>
							<li><a href="rentlist.do">대여 관리</a></li>
							<li><a href="schedule.do">일정 관리</a></li>
						</ul><!-- gnb E -->
					</nav><!-- gnb_inner E -->
				</div>
			</div>
		</div>
	</div>
