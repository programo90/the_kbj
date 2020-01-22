<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 css 입니다. -->
<link rel="stylesheet"  href="css/comm.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->
<link rel="stylesheet"  href="css/eco/list.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
	type="text/css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"
	type="text/css">
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
		location.href="economyInsert.do";
	};
</script>
<SCRIPT LANGUAGE="JavaScript">
function Frameset(page) {
framecode = "<frameset rows='1*'>"
+ "<frame name=main src='" + page + "'>"
+ "</frameset>";

document.write(framecode);
document.close();
}
</script> 
</head>
<body>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="currpage" value="${requestScope.currpage}"></c:set>
	<c:set var="startblock" value="${requestScope.startblock}"></c:set>
	<c:set var="endblock" value="${requestScope.endblock}"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage}"></c:set>
	<c:set var="search" value="${requestScope.search}"></c:set>
	<c:set var="txtsearch" value="${requestScope.txtsearch}"></c:set>
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
				<h2 class="con_title">경제</h2>
				<!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<ul class="board_menu">
						<li class="board_menu_li"><a href="">최신순</a></li>
						<li class="board_menu_li"><a href="">댓글순</a></li>
						<li class="board_menu_li"><a href="">조회순</a></li>
						<li class="board_menu_li"><a href="">추천순</a></li>
					</ul>
				<div class="writer" align="right" >
				<c:choose>
					<c:when test="${sessionScope.dto.mnick != null }">
						<a class="btn btn-primary"  onclick="economyInsert()">글쓰기</a>
					</c:when>
					<c:when test="${sessionScope.dto.mnick == null }">
						<a class="btn btn-primary"  onclick="memberLogin()" >글쓰기</a>
					</c:when>
				</c:choose>
				</div>
					<!-- 이전버튼 -->
					<!-- <a href="economyInsert.do"><input type="button" value="글쓰기"
						class="btn_write"></a>-->
				</div>
				<div class="board_box">
					<!--내용작성 start -->
					<div class="container-fulid">
						<c:forEach var="list" items="${requestScope.list}">
						<div class="row  listsize" style="border-style: groove;">
							<div class="col-md-1 bctg"><br><br>
								<h4><span class="label label-primary">${list.bctg}</span></h4>
								<!-- <span><c:out value="${list.bno}"></c:out></span> 게시번호 -->
							</div>
							<div class="col-md-2 img">
								<img alt="sample-img" class="img-thumbnail" src="https://imgnews.pstatic.net/image/421/2020/01/22/0004422386_001_20200122120613440.jpg?type=w647" width="180" height="180"/>
							</div>
							<div class="col-md-8">
								<h3>
									<a href="economyDetail.do?num=${list.bno}"><c:out value="${list.btitle}"></c:out></a>
								</h3>
								<p>
								   <span><c:out value="${list.bcontent}"></c:out></span>
								</p>
							</div>
							<div class="col-md-1"><br><br>
								<span class="glyphicon glyphicon-eye-open"></span>
								<c:out value="${list.bviewcount}"></c:out>
							</div>
						</div>
						</c:forEach>
						<div class="row" >
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<nav class="pagination-sm">
									<ul class="pagination">
										<c:if test="${startblock>1}">
											<li class="page-item">
												<a href="economyList.do?curr=${startblock-1}">이전블락</a>
											</li>
										</c:if>
									
										<c:if test="${currpage!=1}">
											<li class="page-item">
												<a class="page-link" href="economyList.do?curr=${currpage-1}">이전</a>
											</li>
										</c:if>
											
									 	<c:forEach var="i" begin="${startblock}" end="${endblock}" step="1">
											<c:if test="${currpage==i}">
												<li class="page-item">
													<a class="page-link" href="economyList.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i}</a>
												</li>
											</c:if>
											<c:if test="${currpage!=i}">
												<li class="page-item">
													<a class="page-link" href="economyList.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i}</a>
												</li>
											</c:if>
										</c:forEach>
											
										<c:if test="${currpage!=totalpage}">
										<li class="page-item">
										<a class="page-link" href="economyList.do?curr=${currpage+1}">다음</a>
										</li>
										</c:if>
											
										<c:if test="${endblock<totalpage}">
										<li class="page-item">
											<a class="page-link" href="economyList.do?curr=${endblock+1}">훨다음</a>
										</li>
										</c:if>
									</ul>
								</nav>
							</div>
							<div class="col-md-3"></div>
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