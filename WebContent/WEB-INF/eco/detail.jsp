<%@page import="com.thekbj.dto.TableDTO"%>
<%@page import="com.thekbj.dto.ReplyDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 css 입니다. -->
<link rel="stylesheet" href="css/comm.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->
<link rel="stylesheet" href="css/eco/repl.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script>
	$(document).ready(function(){
			let mno;
			let mnick;
			if(mno!=null){
				mno= <%=session.getAttribute("mno") %>
				mnick=<%=session.getAttribute("mnick") %>
			}
	});
	function memberLogin() {
		alert("로그인 후 작성가능합니다.");
		location.href="memberLogin.do";
	};
	function economyInsert() {
		location.href="economyRepinsert.do";
	};
</script>
</head>

<body>
	<c:set var="list" value="${requestScope.dto}"></c:set>
	<jsp:include page="../comm/header.jsp"></jsp:include>
	<div class="right">
		<section class="content_box">
			<div class="content_top">
				<!-- <p class="sponsor">
					<a href="#"><span class="glyphicon glyphicon-bell"></span>개인후원</a>
				</p>
				<div class="searchbox">
					<input type="text" value="search" class="search">
				</div>-->
			</div> 
			<div class="content">
				<h2 class="con_title">경제</h2>
				<!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				
				<!-- 내용작성 Start -->

				<%
					TableDTO dto = (TableDTO) request.getAttribute("dto");
				%>
				
				<div class="container-fluid">
					<div class="row" style="border-style: groove;">
						<div class="col-md-12">
							<div class="row">
								 <div class="col-md-12">
								 <br><span class="badge badge-pill badge-primary"><%=dto.getBctg()%></span>
									<br>
										<div align="center">
										<h2>
										<%=dto.getBtitle()%>
										</h2>
										<hr>
										</div>
										<br><br><br>
										<div align="center">
										<p>
										<%=dto.getBcontent()%>
										</p>
										</div>
									</div>
								</div>
							<br><br>
							<div style="float:right">
								<a class="btn" href="economyList.do">목록으로</a> 
								<a class="btn" href="economyDel.do?num=${dto.bno}">삭제</a> 
								<a class="btn" href="economyModify.do?num=${dto.bno}">수정</a>
							</div>
						</div>
					</div>
					
					<!-- 댓글 영역 -->
							<form method="post" id="frm2" action="economyRepinsert.do">
								    		<input type="hidden" name="bno" value="<%=dto.getBno()%>">
								    		<input type="hidden" name="mno" value="${sessionScope.mno}">
									        <div class="row repl">
												<div class="col-md-2 column1">
										<c:out value="${sessionScope.mnick}"></c:out>
									</div>
									<div class="col-md-8 column2">
										<input type="text" name="rcontent" placeholder="댓글을 작성해주세요.">
									</div>
									<div class="col-md-2">
										<c:choose>
											<c:when test="${sessionScope.dto.mnick != null }">
												<button type="button" onclick="document.getElementById('frm2').submit();" 
												class="active btn-primary replAddBtn1">
												댓글등록
												</button>
											</c:when>
											<c:when test="${sessionScope.dto.mnick == null }">
											<button type="button" onclick="memberLogin()" 
												class="active btn-primary replAddBtn1">
												댓글등록
												</button>
											</c:when>	
										</c:choose>
									</div>
								</div>
						</form>
							<c:forEach items="${requestScope.repl}" var="item" varStatus="i">					
								<div class="row repl">
									<div class="col-md-2 column1">
										<c:out value="${item.mnick}"></c:out>
									</div>
									<div class="col-md-8 column2">
										<c:out value="${item.rcontent}"></c:out>
									</div>
									<form method="post" id="frm1" action="economyRepdel.do">
						    			<input type="hidden" name="bno" value="${item.bno }">
						    			<input type="hidden" name="rno" value="${item.rno }">
						    			<input type="hidden" name="mno" value="${item.mno}">
							        	<button type="button" onclick="document.getElementById('frm1').submit();" class="active btn-primary replRemBtn" style="float:right">
										댓글삭제
										</button>
									</form>
								</div>
							</c:forEach>
								
								    	
					<br>	
					<!-- 댓글 영역 END-->
				</div>
			</div>
			<!--내용작성 end -->
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>