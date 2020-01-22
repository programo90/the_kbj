<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<%
		int result=(Integer)request.getAttribute("result");
		
		if(result>0)
		{
			%>
			<script>
				alert('수정성공!!!!!');
				location.href="economyList.do";
			</script>
			<%
		}else{
			%>
				<script>
					alert('수정실패....');
					location.href="economyList.do";
				</script>
			<%
		}
	%>
</body>
</html>