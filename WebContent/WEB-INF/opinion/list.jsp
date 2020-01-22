<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 css 입니다. -->
<link rel="stylesheet" href="css/comm.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script>
	function insertBoard() {
		location.href = "opinioninsert.do";
	};
	function loginBoard() {
		location.href = "memberLogin.do";
	};
</script>
</head>
<body>
	<jsp:include page="../comm/header.jsp"></jsp:include>
	<div class="right">
		<section class="content_box">
			<div class="content_top">
				<p class="sponsor">
					<a href="#"><span class="glyphicon glyphicon-bell"></span>개인후원</a>
				</p>
				<div class="searchbox">
					<input type="text" value="search" class="search">
				</div>
			</div>
			<div class="content">
				<h2 class="con_title">오피니언</h2>
				<!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<ul class="board_menu">
						<li class="board_menu_li"><a href="opinionlist.do?btag=eco">최신순</a></li>
						<li class="board_menu_li"><a href="">댓글순</a></li>
						<li class="board_menu_li"><a href="">조회순</a></li>
						<li class="board_menu_li"><a href="">추천순</a></li>
					</ul>
					<c:choose>
						<c:when test="${sessionScope.dto.mnick != null }">
							<input type="button" value="글쓰기" class="btn_write" id="btn_write"
								onclick="insertBoard()">
						</c:when>
						<c:when test="${sessionScope.dto.mnick == null }">
							<input type="button" value="글쓰기" class="btn_write" id="btn_write"
								onclick="loginBoard()">
						</c:when>
					</c:choose>

				</div>
				<div class="board_box">
					<!--내용작성 start -->
					
					
					
					
					



					<c:set var="startPage" value="${requestScope.startPage }" />
					<c:set var="endPage" value="${requestScope.endPage }" />
					<c:set var="totalPage" value="${requestScope.totalPage }" />
					<c:set var="curr" value="${requestScope.curr }" />
					<c:set var="searchType" value="${requestScope.searchType }" />
					<c:set var="searchtxt" value="${requestScope.searchtxt }" />
					<c:set var="btag" value="${requestScope.btag }" />





					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<c:forEach var="item" items="${requestScope.list }">
									<div class="jumbotron">
										<h2>
											<a href="opiniondetail.do?bno=${item.bno}"><c:out value="${item.btitle}" /></a>
										</h2>
										<p>
											<a href="opiniondetail.do?bno=${item.bno}"><c:out value="${item.bcontent}" /></a>
										</p>

									</div>
								</c:forEach>

								<div class="row">
									<div class="col-md-3"></div>
									<div class="col-md-6">
										<div style="text-align: center;">
										<nav class="pagination-sm">
											<ul class="pagination">
											<c:if test="${startPage!=1 }">
												<li class="page-item"><a class="page-link" href="opinionlist.do?curr=${curr-1}&searchType=${searchType}&searchtxt=${searchtxt}&btag=${btag}">Previous</a>
												</li>
												</c:if>
												
												<c:forEach var="i" begin="${startPage }" end="${endPage }">
												<li class="page-item"><a class="page-link" href="opinionlist.do?curr=${i}&searchType=${searchType}&searchtxt=${searchtxt}&btag=${btag}">${i}</a>
												</li>
												</c:forEach>
												
												
												<c:if test="${endPage!=totalPage }">
												<li class="page-item"><a class="page-link" href="opinionlist.do?curr=${curr+1}&searchType=${searchType}&searchtxt=${searchtxt}&btag=${btag}">Next</a>
												</li>
												</c:if>
											</ul>
										</nav>
									</div>
									<div class="col-md-3"></div>
								</div>
								</div>
							</div>
						</div>
					</div>










					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>