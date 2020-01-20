<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int result=(Integer)request.getAttribute("result");

	if(result>0){
	%>
		<script>
			alert('삭제성공!');
			location.href="enterList.do";
			<%-- 이방식으로 하면 alert창이 안뜸<%reqponse.sedRedirect("list.do")%> --%>
		</script>
	<%
	}else{
	%>
		<script>
			alert('삭제실패!');
			location.href="enterList.do";
		</script>
	<%
	}
%>
</body>
</html>