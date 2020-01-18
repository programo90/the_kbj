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
						<li class="board_menu_li"><a href="">PC</a></li>
						<li class="board_menu_li"><a href="">Mobile</a></li>
						<li class="board_menu_li"><a href="">It etc.</a></li>
						<li class="board_menu_li"><a href="">과학 일반</a></li>
					</ul>
					<input type="button" value="글쓰기" class="btn_write">
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

												<div class="drow">
													<div class="col-md-3">
														<img alt="sample-img" src="exhibition18.jpg" />
														<div class="like-count">like 1</div>
														<div class="reple-count">reply 1</div>
													</div>
													<div class="col-md-9">
														<p>#1</p>
														<h3>제목입니다 제목은 두줄까지만 출력하도록 합니다.</h3>
														<p>작성자</p>
														<p>2020.01.16</p>
													</div>
												</div>
												<div class="drow">
													<div class="col-md-3">
														<img alt="sample-img" src="exhibition18.jpg" />
														<div class="like-count">like 1</div>
														<div class="reple-count">reply 1</div>
													</div>
													<div class="col-md-9">
														<p>#1</p>
														<h3>제목입니다 제목은 두줄까지만 출력하도록 합니다.</h3>
														<p>작성자</p>
														<p>2020.01.16</p>
													</div>
												</div>
											</div>
										</div>
										<nav class="pagination-sm">
											<ul class="pagination">
												<li class="page-item"><a class="page-link" href="#">이전</a>
												</li>
												<li class="page-item"><a class="page-link" href="#">1</a>
												</li>
												<li class="page-item"><a class="page-link" href="#">2</a>
												</li>
												<li class="page-item"><a class="page-link" href="#">3</a>
												</li>
												<li class="page-item"><a class="page-link" href="#">4</a>
												</li>
												<li class="page-item"><a class="page-link" href="#">5</a>
												</li>
												<li class="page-item"><a class="page-link" href="#">다음</a>
												</li>
											</ul>
										</nav>
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
</body>
</html>