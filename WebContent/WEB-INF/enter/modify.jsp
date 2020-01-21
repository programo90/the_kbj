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
<link rel="stylesheet" href="css/enter.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
	<c:set var="mno" value="${sessionScope.mno}"></c:set>
	<c:set var="mnick" value="${sessionScope.mnick}"></c:set>
	<c:set var="dto" value="${requestScope.dto}"></c:set>
	<jsp:include page="../comm/header.jsp"></jsp:include>
	<div class="right">
		<section class="content_box">
			<div class="content_top">
				<p class="sponsor">
					<a href="#"><span class="glyphicon glyphicon-bell"></span>개인후원</a>
				</p>
<!-- 				<div class="searchbox">
					<input type="text" value="search" class="search">
				</div>
 -->			</div>
			<div class="content">
				<h2 class="con_title">글수정</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<div class="btns_detail">
						<a href="enterList.do" class="btn btn-default">목록으로</a>
					</div>
				</div>
				<div class="board_box">
					<!--내용작성 start -->
					<div class="enterboard_insert">
						<form method="post" action="enterModifyresult.do">
							<ul class="enterboard_insertul">
								<li>
									<%-- <label>글번호</label>
									<c:out value="${dto.bno}"></c:out> --%>
									<input type="hidden" name="bno" id="bno" value="${dto.bno}"> 
								</li>
								<li>
									<label for="mnick" class="mnick"> ${sessionScope.mnick} </label>
									<input type="hidden" class="form-control" id="mnick" name="mnick"value="${sessionScope.mnick}" />
								</li>
								<li>
									<label class="titlehidden">카테고리</label>
									<select id="bctg" name="bctg" class="form-control" required="required">
		                                <option>카테고리를 선택해주세요</option>
		                                <option value="경제">경제</option>
		                                <option value="연예" selected="selected">연예</option>
		                                <option value="스포츠">스포츠</option>
		                                <option value="IT/과학">IT/과학</option>
		                                <option value="오피니언">오피니언</option>
		                            </select>	
								</li>
								<li>
									<label for="btag" class="titlehidden">태그</label> <br> 
									<select id="btag" name="btag" class="form-control">
										<option>태그를 선택해주세요</option>
<!-- 										<option value="#TV" selected="selected">TV</option>
										<option value="#영화">영화</option>
										<option value="#스타">스타</option> -->
										<c:choose>
											<c:when test="${requestScope.dto.btag == '#TV'}">
												<option value="#TV" selected="selected">TV</option>
												<option value="#영화">영화</option>
												<option value="#스타">스타</option>
											</c:when>
											<c:when test="${requestScope.dto.btag == '#영화'}">
												<option value="#TV">TV</option>
												<option value="#영화" selected="selected">영화</option>
												<option value="#스타">스타</option>
											</c:when>
											<c:when test="${requestScope.dto.btag == '#스타'}">
												<option value="#TV">TV</option>
												<option value="#영화">영화</option>
												<option value="#스타" selected="selected">스타</option>
											</c:when>
										</c:choose>
										
									</select>
								</li>
								<li>
									<label>글제목</label>
									<input type="text" name="btitle" id="btitle" value="${dto.btitle}">
								</li>
								<li>
									<label>내용</label>
									<textarea rows="3" cols="20" name="bcontent" id="bcontent">${dto.bcontent}</textarea>
								</li>
								<li>
									<label for="bimg"> 사진첨부 </label>
									<input type="file" class="form-control-file" id="bimg" name="bimg" />
								</li>
								<li>
									<input type="submit" value="수정">
									<input type="reset" value="취소">
								</li>
							</ul>
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