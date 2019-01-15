<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/comm/top.jsp" flush="false" ></jsp:include>
<link rel="stylesheet" type="text/css" href="/KocoFarmPro/css/comm/sign_in.css" />

	<div class="cont_wrap">
		<!-- SubTitle Area -->
		<div class="sub_title">
			<div class="sub_title_top">
				<div class="sub_title_inner">
					<h2>Sign In <span>로그인 페이지 입니다.</span></h2>
					<ul class="sub_nav">
						<li>홈 > </li>
						<li class="on">로그인</li>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- Contents Area -->
		<div class="contents_wrap">
			<div class="sign_in_inner">
				<form action="signIn.do" id="signInForm" method="post">
					<div class="sign_in_div">
						<input type="hidden" name="mode" id="mode" value="${param.mode}" />
						<input type="text" name="userId" id="userId" placeholder="아이디를 입력 해 주세요." />
						<input type="password" name="userPw" id="userPw" placeholder="비밀번호를 입력 해 주세요." />
					</div>
				</form>
			
				<!-- btn -->
				<div class="sign_in_div">
					<input type="button" class="sign_in_btn" id="signInBtn" value="로그인" />
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/KocoFarmPro/js/comm/sign_in.js"></script>
<jsp:include page="/jsp/comm/bottom.jsp" flush="false" ></jsp:include>