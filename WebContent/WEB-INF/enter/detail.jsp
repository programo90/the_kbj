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
	<c:set var="dto" value="${requestScope.dto}"></c:set>
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
				<h2 class="con_title">글상세</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_box">
					<!--내용작성 start -->
					<div class="btns">
						<a href="enterList.do">목록으로</a>
						<a href="enterModify.do?bno=${dto.bno}">수정</a>
						<a href="enterDel.do?bno=${dto.bno}">삭제</a>
					</div>
					<div>
						<ul>
							<li>
								<label>글번호</label>
								<c:out value="${dto.bno}"></c:out>
								<input type="hidden" name="bno" id="bno" value="${dto.bno}"> 
							</li>
							<li>
								<label>카테고리</label>
								<c:out value="${dto.bctg}"></c:out>
							</li>
							<li>
								<label>제목</label>
								<c:out value="${dto.btitle}"></c:out>
							</li>
							<li>
								<label>내용</label>
								<c:out value="${dto.bcontent}"></c:out>
							</li>
							<li>
								<label>조회수</label>
								<c:out value="${dto.bviewcount}"></c:out>
							</li>
						</ul>
					</div>
					<div class="reply" id="replyResult"></div>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>