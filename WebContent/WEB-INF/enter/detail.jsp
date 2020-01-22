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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script>
	function replysend(){
		if(document.replyform.rcontent.value!=""){
			document.replyform.submit();
		}
	}
    function loginBoard() {
       location.href="memberLogin.do";
    };

	function repEnterrmove(rno, bno, mno){
		location.href="enterRepdel.do?rno="+rno+"&bno="+bno+"&mno="+mno;
	}
	$(document).ready(function(){
		let bno=${dto.bno};
 		/* let Membermno=${sessionScope.dto.mno};	//로그인한mno */


 		let	mno= <%=session.getAttribute("mno") %>;
 		<%-- let	mnick=<%=session.getAttribute("mnick") %>; --%>

 		let rec = 0;
        console.log('bno', bno);
        $.ajax({
			url:'repEnterdetail.do'
			, data:{'bno':bno}
			, dataType:'json'
			, method:'post'
			, success:function(data){
				
				$.each(data, function(index,item){
					console.log("여기22222");
					let result="<div class='replyBox'>";
					/* result+="<div>"+item.rno+"</div>"; */
					result+="<div class='replymnick'>"+item.mnick+"</div>";
					result+="<div class='replydate'>"+item.rwrdate+"</div>";
					result+="<div class='replycontent'>"+item.rcontent+"</div>";
					if(item.mno = mno){
						result+="<input type='button' value='삭제' class='replybtn' onclick='repEnterrmove("+item.rno+","+${dto.bno}+","+item.mno+")'>";
					}
					result+="</div>";
					$('#replyResult').append(result);
					rec = rec + 1;
				}); 
				$("#brecount").append(rec);
			}
			, error:function(data,errcode){
				console.log('error', data);
				console.log('errcode', errcode);
			}
			
		});
	});
</script>
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
			</div>
			<div class="content">
				<h2 class="con_title">글상세</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<div class="btns_detail">
						<c:if test="${sessionScope.mno != null}">
							<a href="enterModify.do?bno=${dto.bno}" class="btn btn-warning">수정</a>
							<a href="enterDel.do?bno=${dto.bno}" class="btn btn-danger">삭제</a>
						</c:if>
						<a href="enterList.do" class="btn btn-default">목록으로</a>
					</div>
				</div>
				<div class="board_box">
					<!--내용작성 start -->
					<div class="board">
						<div class="board_write_detail">
							<div class="write_info">
								<label for="mnick" class="mnick">${dto.mnick} </label>
								<input type="hidden" class="form-control" id="mnick" name="mnick"value="${sessionScope.mnick}" />
								<p class="date"><c:out value="${dto.bwrdate}"></c:out></p>
							</div>
							<div class="detail_count">
								<span class="glyphicon glyphicon-eye-open"></span>
								<c:out value="${dto.bviewcount}"></c:out>
								<span class="glyphicon glyphicon-heart-empty" id="like_result"></span>
								<c:out value="${dto.blikecount}"></c:out>
							</div>
						</div>
						<ul class="board_content">
							<%-- <li>
								<label class="titlehidden">카테고리</label>
								<c:out value="${dto.bctg}"></c:out>
							</li> --%>
							<li class="ent_tag">
								<label class="titlehidden">태그</label>
								<c:out value="${dto.btag}"></c:out>
							</li>
							<li class="board_title">
								<label class="titlehidden">제목</label>
								<c:out value="${dto.btitle}"></c:out>
							</li>
							<li>
								<label class="titlehidden">글번호</label>
								<input type="hidden" name="bno" id="bno" value="${dto.bno}"> 
							</li>
							<li>
								<label class="titlehidden">내용</label>
								
								<p>${dto.bcontent}</p>
								
							</li>
							<%-- <li>
								<label>작성자</label>
								<c:out value="${dto.mnick}"></c:out>
							</li> --%>
						</ul>
					</div>
					<h3 class="reply_title">댓글</h3><span id="brecount"></span>
					<form method="post" action="enterRepinsert.do" name="replyform">
						<input type="hidden" class="form-control" id="bno" name="bno" value="${requestScope.dto.bno }"/>
						<input type="hidden" class="form-control" id="mno" name="mno" value="${sessionScope.mno}" />
						<input type="hidden" class="form-control" id="mnick" name="mnick" value="${sessionScope.mnick}" />
						<textarea rows="3" cols="20" name="rcontent" class="form-control reptext"></textarea>
						<!-- <input type="button" onclick="replysend()" value="추가">  -->
						<c:choose>
		                  <c:when test="${sessionScope.mno != null }">
		                     <input type="button" value="추가" class="btn btn-info replyaddbtn" id="btn_write" onclick="replysend()">
		                  </c:when>
		                  <c:when test="${sessionScope.mno == null }">
		                     <input type="button" value="추가" class="btn btn-info replyaddbtn" id="btn_write" onclick="loginBoard()">
		                  </c:when>
		               </c:choose>
					</form>
					<div class="reply" id="replyResult"></div>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>