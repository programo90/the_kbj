<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

</head> --%>
<carousel>

<div class="container" style="padding:0px 10px 15px 15px;">
<div class="col-md-1"></div>
<div class="col-md-8">
  <h4> columnlist</h4>
    
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
       <a href="opinionlist.do?btag=eco" class="crs"> <img src="http://localhost:9080/thekbj/img/opinion/cl1.png" alt="Los Angeles" style="width:32.5%; display:inline-block;"></a>
       <a href="opinionlist.do?btag=spo" class="crs"> <img src="http://localhost:9080/thekbj/img/opinion/cl2.png" alt="Chicago" style="width:32.5%; display:inline-block;"></a>
        <a href="opinionlist.do?btag=ent" class="crs"><img src="http://localhost:9080/thekbj/img/opinion/cl3.png" alt="Los Angeles" style="width:32.5%; display:inline-block;"></a>
        
      </div>

      <div class="item">
        <a href="opinionlist.do?btag=eco" class="crs"><img src="http://localhost:9080/thekbj/img/opinion/cl4.png" alt="Los Angeles" style="width:32%; display:inline-block;"></a>
        <a href="opinionlist.do?btag=spo" class="crs"><img src="http://localhost:9080/thekbj/img/opinion/cl5.png" alt="Chicago" style="width:32%; display:inline-block;"></a>
        <a href="opinionlist.do?btag=ent" class="crs"><img src="http://localhost:9080/thekbj/img/opinion/cl6.png" alt="Los Angeles" style="width:32%; display:inline-block;"></a>
      </div>
    
      <div class="item">
        <a href="opinionlist.do?btag=eco" class="crs"><img src="http://localhost:9080/thekbj/img/opinion/cl7.png" alt="Los Angeles" style="width:32%; display:inline-block;"></a>
        <a href="opinionlist.do?btag=ent" class="crs"><img src="http://localhost:9080/thekbj/img/opinion/cl8.png" alt="Chicago" style="width:32%; display:inline-block;"></a>
       <a href="opinionlist.do?btag=spo" class="crs"> <img src="http://localhost:9080/thekbj/img/opinion/cl9.png" alt="Los Angeles" style="width:32%; display:inline-block;"></a>
      </div>
    </div>

    <!-- Left and right controls -->
    
    
  </div>
  </div>
  <div class="col-md-2"></div>
</div>
</carousel>