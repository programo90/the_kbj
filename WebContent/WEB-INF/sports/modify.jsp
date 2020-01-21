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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
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
				<h2 class="con_title">스포츠</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<ul class="board_menu">
						<li class="board_menu_li"><a href="">최신순</a></li>
						<li class="board_menu_li"><a href="">댓글순</a></li>
						<li class="board_menu_li"><a href="">조회순</a></li>
						<li class="board_menu_li"><a href="">추천순</a></li>
					</ul>
					<a href="sportsInsert.do">글쓰기</a>
				</div>
				<div class="board_box">
					<!--내용작성 start -->
	<c:set var="dto" value="${requestScope.dto}"></c:set>
	<form method="post" action="sportsModifyresult.do">
	<ul>
	<li>
	<label for="bno">글번호</label>
	<input type="text" name="bno" id="bno" value="${dto.bno}" readonly="readonly">
	</li>
	<li>
	<label for="bctg">태그</label>
	<input type="text" name="bctg" id="bctg" value="${dto.bctg}">
	</li>
	<li>
	<label for="btitle">제목</label>
	<input type="text" name="btitle" id="btitle" value="${dto.btitle}">
	</li>
	<li>
	<input type="submit" value="전송">
	<input type="reset" value="취소"> 
	</li>
	</ul>
</form>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>