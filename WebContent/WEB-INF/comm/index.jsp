<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/comm.css">
<link rel="stylesheet" href="css/newmain.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
<div id="wrap">
      <c:set var="list" value="${requestScope.list}"></c:set>
      <jsp:include page="header.jsp"></jsp:include>
   <div class="right">
      <section class="content_box">
           <div class="content_top">
              <!--  <p class="sponsor"><a href="#"><span class="glyphicon glyphicon-bell"></span>개인후원</a></p> -->
               <div class="searchbox">
               <!-- <input type="text" value="search" class="search"> -->
               <!-- <form method="get" action="enterList.do">
                  <select name="search" class="form-control topsearch">
                     <option value="title">제목</option>
                     <option value="content">내용</option>
                     <option value="tag">태그</option>
                     <option value="writer">작성자</option>
                  </select>
                  <input type="text" name="txtsearch" class="form-control toptxt">
                  <input type="submit" value="검색" class="btn btn-info searchBtn">
               </form> -->
            </div>
           </div>                
           <div class="content">
               <div class="con_box">
                   <p class="texttttt">최신글</p>
                   <div class="main_board">
                      <c:forEach items="${requestScope.list}" var="item">
                         <div class="main">
                     <div class="main_bctg">${item.bctg }</div>
                     <div class="main_title">
                              <c:choose>
                                 <c:when test="${item.bctg=='it'}">
                                    <a href="itDetail.do?bno=${item.bno}">제목 ${item.btitle}</a>
                                 </c:when>
                                 <c:when test="${item.bctg=='연예'}">
                                    <a href="enterDetail.do?bno=${item.bno}">제목 ${item.btitle}</a>
                                 </c:when>
                                 <c:when test="${item.bctg=='op'}">
                                    <a href="opiniondetail.do?bno=${item.bno}">제목 ${item.btitle}</a>
                                 </c:when>
                                 <c:when test="${item.bctg=='[스포츠]'}">
                                    <a href="sportsDetail.do?bno=${item.bno}">제목 ${item.btitle}</a>
                                 </c:when>
                                 <c:when test="${item.bctg=='경제'}">
                                    <a href="economyDetail.do?bno=${item.bno}">제목 ${item.btitle}</a>
                                 </c:when>
                                 <c:otherwise>
                                    other
                                 </c:otherwise>
                              </c:choose>
                              </div>
                           <div class="main_view"><span class="glyphicon glyphicon-eye-open"></span> ${item.bviewcount}</div>
                           <div class="main_date">${item.bwrdate}</div>
                       </div>
                      </c:forEach>
                   </div>
               </div>
               <!-- <div class="con_box">
                   <p>조회수</p>
                   <div class="con_board"></div>
               </div> -->
           </div>
       </section>
   </div>
   <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>