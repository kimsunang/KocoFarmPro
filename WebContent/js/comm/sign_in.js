$(function(){
	$("#signInBtn").click(function(){
		if(null == $("#userId").val() || "" == $("#userId").val()){
			alert("아이디를 입력 해 주세요.");
			$("#userId").focus();
			return false;
		}
		
		if(null == $("#userPw").val() || "" == $("#userPw").val()){
			alert("비밀번호를 입력 해 주세요.");
			$("#userPw").focus();
			return false;
		}
		
		$("#mode").val("signIn");
		$("#signInForm").submit();
		
		return false;
	});
});