<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:set var="result" value="${requestScope.result }"/>
	
	<c:if test="${result > 0 }">
		<script>
			alert('리플을 정상적으로 달았습니다.');
			location.href="oneLineList.do";
		</script>
	</c:if>
	<c:if test="${result <= 0 }">
		<script>
			alert('오류 : 리플 Insert 실패');
			location.href="oneLineList.do";
		</script>
	</c:if>
</body>
</html>