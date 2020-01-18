<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>It/과학</title>
<!-- 공통 css 입니다. -->
<link rel="stylesheet" href="css/comm.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->
<link rel="stylesheet" href="css/it.list.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
	<c:set var="startPage" value="${requestScope.startPage }" />
	<c:set var="endPage" value="${requestScope.endPage }" />
	<c:set var="totalPage" value="${requestScope.totalPage }" />
	<c:set var="curr" value="${requestScope.curr }" />
	<c:set var="searchType" value="${requestScope.searchType }" />
	<c:set var="searchtxt" value="${requestScope.searchtxt }" />
	<c:set var="btag" value="${requestScope.btag }" />


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
				<h2 class="con_title">IT 과학</h2>
				<!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<ul class="board_menu">
						<li class="board_menu_li"><a href="itList.do">전체보기</a></li>
						<li class="board_menu_li"><a href="itList.do?btag=pc">PC</a></li>
						<li class="board_menu_li"><a href="itList.do?btag=mobile">Mobile</a></li>
						<li class="board_menu_li"><a href="itList.do?btag=etc">It etc.</a></li>
					</ul>
					<input type="button" value="글쓰기" class="btn_write" id="btn_write">
				</div>
				<div class="board_box">
					<!--내용작성 start -->
					<div>
						<article>
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<div class="itdrow">
											<div class="col-md-12">
												<c:forEach var="item" items="${requestScope.list }">
													<div class="drow">
														<div class="col-md-3">
															<img alt="sample-img" src="${item.bimg }" />
															<div class="like-count">like ${item.blikecount}</div>
															<div class="reple-count">reply ${item.brecount }</div>
														</div>
														<div class="col-md-9">
															<p>#${item.bno }</p>
															<h3>${item.btitle }</h3>
															<p>작성자</p>
															<p>${item.bwrdate }</p>
														</div>
													</div>
												</c:forEach>
												<!------------------------- paging ------------------------->
												<div style="text-align: center;">
													<nav class="pagination-sm" style="float: none">
														<ul class="pagination ">
															<c:if test="${startPage!=1 }">
																<li class="page-item"><a class="page-link"
																	href="itList.do?curr=${curr-1}&searchType=${searchType}&searchtxt=${searchtxt}&btag=${btag}">이전</a></li>
															</c:if>
															<c:forEach var="i" begin="${startPage }"
																end="${endPage }">
																<li class="page-item"><a class="page-link"
																	href="itList.do?curr=${i}&searchType=${searchType}&searchtxt=${searchtxt}&btag=${btag}">${i}</a></li>
															</c:forEach>
															<c:if test="${endPage!=totalPage }">
																<li class="page-item"><a class="page-link"
																	href="itList.do?curr=${curr+1}&searchType=${searchType}&searchtxt=${searchtxt}&btag=${btag}">다음</a>
																</li>
															</c:if>
														</ul>
													</nav>
												</div>

												<!------------------------- search ------------------------->
												<div style="text-align: center;">
													<form action="itList.do" method="post">
														<select name="searchType" class="searchSel">
															<option value="btitle">제목</option>
															<option value="mnick">작성자</option>
															<option value="bcontent">내용</option>
														</select> <input type="text" name="searchtxt"> <input
															type="submit" value="검색">
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</article>
					</div>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$('#btn_write').click(function(){
			});
		});
	</script>
</body>
</html>