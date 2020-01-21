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
<link rel="stylesheet" href="css/enter.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
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
	function enterInsert() {
		location.href="enterInsert.do";
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
	<jsp:include page="../comm/header.jsp"></jsp:include>
	<div class="right">
		<section class="content_box">
			<div class="content_top">
				<p class="sponsor">
					<a href="#"><span class="glyphicon glyphicon-bell"></span>개인후원</a>
				</p>
				<div class="searchbox">
					<!-- <input type="text" value="search" class="search"> -->
					<form method="get" action="enterList.do">
						<select name="search">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<!-- <option value="writer">작성자</option> -->
						</select>
						<input type="text" name="txtsearch" class="form-control input-sm">
						<input type="submit" value="검색" class="btn btn-default btn-sm">
					</form>
				</div>
			</div>
			<div class="content">
				<h2 class="con_title">연예</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<ul class="board_menu">
						<li class="board_menu_li"><button type="button" class="btn btn-link">최신순</button></li>
						<li class="board_menu_li"><button type="button" class="btn btn-link">댓글순</button></li>
						<li class="board_menu_li"><button type="button" class="btn btn-link">조회순</button></li>
						<li class="board_menu_li"><button type="button" class="btn btn-link">추천순</button></li>
					</ul>
					<div class="btns_list">
						<%-- <c:if test="${sessionScope.mno != null}">
							<a href="enterInsert.do" class="btn btn-primary">글쓰기</a>
						</c:if> --%>
						<c:choose>
						<c:when test="${sessionScope.dto.mnick != null }">
							<input type="button" value="글쓰기" class="btn_write" id="btn_write" onclick="enterInsert()">
						</c:when>
						<c:when test="${sessionScope.dto.mnick == null }">
							<input type="button" value="글쓰기" class="btn_write" id="btn_write" onclick="memberLogin()">
						</c:when>
					</c:choose>
					</div>
					<!-- <input type="button" value="글쓰기" class="btn_write"> -->
				</div>
				<div class="board_box">
					<!--내용작성 start -->
					
					<div>
						<!--if(list==null||list.size()==0) 이면 해당자료가 없습니다 추가하기  -->
						<c:if test=""></c:if>
						<c:set var="number" value="0"/>
						<c:forEach var="list" items="${requestScope.list}">
							<div class="list_one">
								<c:set var="number" value="${number+1}"></c:set>
								<span class="listnumber"><c:out value="${number}"></c:out></span>
								<span class="listtitle"><a href="enterDetail.do?bno=${list.bno}"><c:out value="${list.btitle}"></c:out></a></span>
								<span><c:out value="${list.bcontent}"></c:out></span>
								<span><c:out value="${list.bviewcount}"></c:out></span>
								<span><c:out value="${list.btag}"></c:out></span>
								<span><c:out value="${list.brecount}"></c:out></span>
								<span><c:out value="${list.blikecount}"></c:out></span>
								<span><c:out value="${list.bimg}"></c:out></span>
								<%-- <span><img src="img/${ }" alt=""/></span> --%>
								<span><c:out value="${list.mnick}"></c:out></span>
							</div>
						</c:forEach>
					</div>
					<div class="pageingBox">
						<c:if test="${startblock>1}">
							<a href="enterList.do?curr=${startblock-1}">훨이전</a>
						</c:if>
						<c:if test="${currpage!=1}">
							<a href="enterList.do?curr=${currpage-1}">이전</a>
						</c:if>
						<c:forEach var="i" begin="${startblock}" end="${endblock}" step="1">
							<c:if test="${currpage==i}">
								<c:out value="${i}"></c:out>
							</c:if>
							<c:if test="${currpage!=i}">
								<a href="enterList.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i}</a>
							</c:if>
						</c:forEach>
						<c:if test="${currpage!=totalpage}">
							<a href="enterList.do?curr=${currpage+1}">다음</a>
						</c:if>
						<c:if test="${endblock<totalpage}">
							<a href="enterList.do?curr=${endblock+1}">훨다음</a>
						</c:if>
					</div>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>