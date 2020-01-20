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
				<h2 class="con_title">글수정</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_box">
					<!--내용작성 start -->
					<div>
						<form method="post" action="enterModifyresult.do">
							<ul>
								<li>
									<label>글번호</label>
									<c:out value="${dto.bno}"></c:out>
									<input type="hidden" name="bno" id="bno" value="${dto.bno}"> 
								</li>
								<li>
									<label>카테고리</label>
									<input type="text" name="bctg" id="bctg" value="${dto.bctg}">
								</li>
								<li>
									<label>제목</label>
									<input type="text" name="btitle" id="btitle" value="${dto.btitle}">
								</li>
								<li>
									<label>내용</label>
									<textarea rows="3" cols="20" name="bcontent" id="bcontent">${dto.bcontent}</textarea>
								</li>
								<li>
									<input type="submit" value="수정">
									<input type="reset" value="취소">
								</li>
							</ul>
						</form>
						<a href="enterList.do">목록으로</a>
					</div>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>