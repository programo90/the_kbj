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
<link rel="stylesheet" href="css/sports.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script>
		function insertBoard() {
			location.href="sportsInsert.do";
		};
		function loginBoard() {
			location.href="memberLogin.do";
		};
	</script>
</head>
<body>
	<c:set var="mno" value="${sessionScope.mno}"></c:set>
	<c:set var="mnick" value="${sessionScope.mnick}"></c:set>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="currpage" value="${requestScope.currpage}"></c:set>
	<c:set var="startblock" value="${requestScope.startblock}"></c:set>
	<c:set var="endblock" value="${requestScope.endblock}"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage}"></c:set>
	<c:set var="search" value="${requestScope.search}"></c:set>
	<c:set var="txtsearch" value="${requestScope.txtsearch}"></c:set>
	<c:set var="bview" value="${requestScope.bview }"></c:set>
	<jsp:include page="../comm/header.jsp"></jsp:include>
	<div class="right">
		<section class="content_box">
			<div class="content_top">
				<p class="sponsor">
				</p>
			</div>
			<div class="content">
				<h2 class="con_title">스포츠</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_spmenu_box">
					<ul class="board_menu">
						<li class="board_menu_li"><a href="sportsList.do">최신순</a></li>
						<li class="board_menu_li"><a href="sportsList.do?&search=${search}&txtsearch=${txtsearch}&bview=view">조회순</a></li>
						<li class="board_menu_li"><a href="sportsList.do?&search=${search}&txtsearch=${txtsearch}&bview=reply">댓글순</a></li>
					</ul>
					<form id="new">
						<c:choose>
						<c:when test="${sessionScope.mnick != null }">
							<input type="button" value="글쓰기" class="btn btn-info" id="btn_write" onclick="insertBoard()">
						</c:when>
						<c:when test="${sessionScope.mnick == null }">
							<input type="button" value="글쓰기" class="btn btn-info" id="btn_write" onclick="loginBoard()">
						</c:when>
					</c:choose>
					</form>
					
				</div>
				<div class="board_box">
					<!--내용작성 start -->
				<c:set var="list" value="${requestScope.list}"></c:set>
				<div id="sptoptopline"></div>
				<c:forEach var="item" items="${list}">
				<div id="spall">
				<div id="sp1"><p>no.${item.bno}</p></div>
				<div id="sp2"><img style="width:100%; height:95%" src="${item.bimg}" alt="이미지x"></div>
				<div id="sp3"><p><span class="label label-primary">${item.bctg}</span> <span class="label label-info"># ${item.btag}</span> <span class="glyphicon glyphicon-comment"><span>${item.brecount}</span></span><p><a href="sportsDetail.do?bno=${item.bno}"><h4>${item.btitle}</h4></a><span class='replydate'>${item.bwrdate}</span></div>
				<div id="sp4"><span>${item.mnick}</span></div>
				<div id="sp5"><span class="glyphicon glyphicon-eye-open"></span><span> ${item.bviewcount}</span></div>
				</div>
				</c:forEach>
				<br>
				<br>
				<!-- 페이징  -->
					<div style="text-align: center;">
						<nav class="pagination-sm" style="float: none">
							<ul class="pagination ">
								<c:if test="${startPage!=1 }">
									<li class="page-item"><a class="page-link"
											href="sportsList.do?curr=${currpage-1}&search=${search}&txtsearch=${txtsearch}&bview=${bview}">이전</a></li>
										</c:if>
										<c:forEach var="i" begin="${startblock}" end="${endblock}" step="1">
											<li class="page-item">
											<a class="page-link"href="sportsList.do?curr=${i}&search=${search}&txtsearch=${txtsearch}&bview=${bview}">${i}</a></li>
										</c:forEach>
											<c:if test="${endPage!=totalPage }">
												<li class="page-item"><a class="page-link"href="sportsList.do?curr=${i}&search=${search}&txtsearch=${txtsearch}&bview=${bview}">다음</a>
												</li>
											</c:if>
														</ul>
													</nav>
						
												</div>
					<div class="spsearch">
					<form method="get" action="sportsList.do">
						<select name="search">
							<option value="title">제목</option>
							<option value="mnick">작성자</option>
							<option value="bcontent">내용</option>
						</select>
						<input type="text" name="txtsearch" >
						<input class="btn btn-info" type="submit" value="검색">
					</form>
					</div>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>