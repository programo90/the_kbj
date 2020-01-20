<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 css 입니다. -->
<link rel="stylesheet" href="css/comm.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->
<link rel="stylesheet" href="css/Writing.css">
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
			<h2 class="con_title">새 글쓰기</h2>
			<!-- 각자카테고리명 텍스트만 바꿔주세요 -->
			<div class="board_box">
				<!--내용작성 start -->
				<form method="post" action="sportsInsertresult.do">
					<div class="new">
                            <div class="ca">
						        <select id="bctg" name="bctg" class="newca">
                                <option>　　카테고리를 선택해주세요</option>
                                <option value="[enter]">　　[연예]</option>
                                <option value="[it]">　　[아이티]</option>
                                <option value="[opinon]">　　[오피니언]</option>
                                <option value="[economi]">　　[경제]</option>
                                <option value="[sports]">　　[스포츠]</option>
                            </select>
							</div>
						   <div class="ca">
						<input type="text" name="btitle" id="btitle" class="newca" required="required">
						</div>
						</div>
					<input type="submit" value="전송"> 
					<input type="reset" value="취소">
				</form>
				
				<!--내용작성 end -->
			</div>
		</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>