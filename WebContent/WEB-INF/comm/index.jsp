<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
<div id="wrap">
		<jsp:include page="header.jsp"></jsp:include>
	<div class="right">
		<section class="content_box">
           <div class="content_top">
               <p class="sponsor"><a href="#"><span class="glyphicon glyphicon-bell"></span>개인후원</a></p>
               <div class="searchbox">
                   <input type="text" value="search" class="search">
               </div>
           </div>                
           <div class="content">
               <div class="con_box">
                   <p class="">최신글</p>
                   <div class="con_board">
                       
                   </div>
               </div>
               <div class="con_box">
                   <p>조회수</p>
                   <div class="con_board"></div>
               </div>
           </div>
       </section>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>