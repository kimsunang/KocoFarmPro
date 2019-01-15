<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${'signIn' eq module}">
		<c:choose>
			<c:when test="${0 < re}">
				<script>
					location.href=${myPage};
				</script>
			</c:when>
			<c:when test="${-1 == re}">
				<script>
					alert("아이디를 다시 확인 해 주세요.");
				 	location.href=${myPage};
				</script>
			</c:when>
			<c:otherwise>
				<script>
				 	alert("비밀번호를 다시 확인 해 주세요.");
				 	location.href=${myPage};
				 </script>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${0 < re}">
				 <script>
				 	alert("작업에 성공 했습니다.");
				 	location.href=${myPage};
				 </script>
			</c:when>
			<c:otherwise>
			${myPage}
				<script>
				 	alert("작업에 실패 했습니다.");
				 	location.href=${myPage};
				 </script>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>