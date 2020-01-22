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
<link rel="stylesheet" href="css/sports.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
				<c:set var="dto" value="${requestScope.dto}"></c:set>
			</div>

			<div class="content">
				<h2 class="con_title">스포츠</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_box">
					<!--내용작성 start -->
				<c:set var="dto" value="${requestScope.dto}"></c:set>
		<div class="board_menu_box">
					<div class="btns_detail">
			<c:if test="${sessionScope.mnick == requestScope.dto.mnick}">
					<a href="sportsModify.do?bno=${dto.bno}" class="btn btn-warning"><span> 수정</span></a>
					<a href="sportsDel.do?no=${dto.bno}" class="btn btn-danger"><span> 삭제</span></a>
			</c:if>
			<a href="sportsList.do" class="btn btn-default">목록으로</a>
					</div>
				</div>


				    <div id="sportsget">
                        <div id="sportnicname">
                            <div id="sprname"><span class="glyphicon glyphicon-eye-open"></span> <span>${dto.bviewcount}</span>
                             <span class="glyphicon glyphicon-comment"></span> <span>${dto.brecount}</span></div>
                              <p>${dto.mnick}</p>
                               <span class='replydate' >${dto.bwrdate}</span>
                            	</div>
                            <div id="sportstitle">
                            <span>no.${dto.bno}</span>　<span class="label label-primary">${dto.bctg}</span> <span class="label label-info">#${dto.btag}</span>
                            <h3>${dto.btitle}</h3>
                            </div>
                            <div id="spcontent">
                                <p>${dto.bcontent}</p>
                            </div>
                        </div>
                        <div id="sportsget">
                       <h3 class="reply_title">댓글</h3> <span>댓글수</span><span>${dto.brecount}</span>
					<form method="post" action="sportsRepinsert.do" name="replyform">
						<input type="hidden" class="form-control" id="bno" name="bno" value="${requestScope.dto.bno }"/>
						<input type="hidden" class="form-control" id="mno" name="mno" value="${sessionScope.mno}" />
						<input type="hidden" class="form-control" id="mnick" name="mnick" value="${sessionScope.mnick}" />
						<textarea rows="3" cols="101" name="rcontent"></textarea>
						<!-- <input type="button" onclick="replysend()" value="추가">  -->
						<div class="spbut">
						<c:choose>
		                  <c:when test="${sessionScope.mno != null }">
		                     <input' type="button" value="추가" class="btn btn-info" id="btn_write" onclick="replysend()">
		                  </c:when>
		                  <c:when test="${sessionScope.mno == null }">
		                     <input type="button" value="추가" class="btn btn-info" id="btn_write" onclick="loginBoard()">
		                  </c:when>
		               </c:choose>
		               </div>
					</form>
					<div class="reply" id="replyResult"></div>
					</div>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
	<script>
	function replysend(){
		if(document.replyform.rcontent.value!=""){
			document.replyform.submit();
		}
	}
    function loginBoard() {
       location.href="memberLogin.do";
    };

	function repsportsrmove(rno, mno, ds){
		console.log(rno+ds+mno);
		location.href="sportsRepdel.do?rno="+rno+"&mno="+mno+"&bno="+ds;
		
	}
	$(document).ready(function(){
		let bno=${dto.bno};
 		/* let Membermno=${sessionScope.dto.mno};	//로그인한mno */


 		let	mno= <%=session.getAttribute("mno") %>;
 		<%-- let	mnick=<%=session.getAttribute("mnick") %>; --%>

 		
        console.log('bno', bno);
        $.ajax({
			url:'repsportsdetail.do'
			, data:{'bno':bno}
			, dataType:'json'
			, method:'post'
			, success:function(data){
				
				
				$.each(data, function(index,item){
					let result="<div class='spreplyBox'>";
					result+="<div class='replymnick'>"+item.mnick+"</div>";
					result+="<div class='spreplydate'>"+item.rwrdate+"</div>";
					result+="<div>"+item.rcontent+"</div>";
					if(item.mno = mno){
						result+="<input #new type='button' value='삭제' class='replybtn' onclick='repsportsrmove("+item.rno+","+item.mno+","+${dto.bno}+")'>";
					}
					result+="</div>";
					$('#replyResult').append(result);
				}); 
			}
			, error:function(data,errcode){
				console.log('error', data);
				console.log('errcode', errcode);
			}
		});
	});
</script>
</body>
</html>