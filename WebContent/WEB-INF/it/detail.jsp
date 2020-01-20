<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="css/comm.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->
<link rel="stylesheet" href="css/it/it.detail.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script>
function send() {
	if(document.frm.rcontent.value!=""){
		document.frm.submit();
	}
};

$(document).ready(function(){
	let no = ${dto.bno};
	var brecount =0;
	$.ajax({
		url:'replyList.do'
		,data:{'num':no}
		,dataType:'json'
		,method:'post'
		,success:function(data){
			$.each(data, function(index,item){			
				let result = '<div class="reply-con-box">';
				result += '<div class="row">';
				result += '<div class="col-md-12">';
				result += '<div class="row"><div class="col-md-12">'+item.mnick+'</div></div>';
				result += '<div class="row"><div class="col-md-12">'+item.rwrdate+'</div></div>';
				result += '<a href="itRepdel.do?rno='+item.rno+'&bno='+${dto.bno}+'">삭제</a>';
				result += '</div>';
				result += '<div class="col-md-12">'+item.rcontent+'</div>';
				result += '</div>';
				result += '</div>';
				
				$('#view-reply').append(result);
				brecount += 1;
			});
			
			$('#brecount').append(brecount);
			$('#boardrecount').append(brecount);
		}
		,error:function(data){
			console.log(data);
		}
	});
});
</script>
</head>
<body>
	<c:set var="dto" value="${requestScope.dto }" />

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
				<div class="board_box">
					<!--내용작성 start -->
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-12" id="detail-header">
										<div class="row">
											<div class="col-md-10">
												<div class="col-md-12">
													<p>
														<a href="#">${dto.mnick }</a> <span
															class="glyphicon glyphicon-leaf" style="font-size: 12px">${dto.mscore }</span>
													</p>
												</div>
												<div class="col-md-12">
													<p>${dto.bwrdate }</p>
												</div>
											</div>
											<div class="col-md-1">
												<p>
													<span class="glyphicon glyphicon-eye-open"></span>
													${dto.bviewcount }
												</p>
											</div>
											<div class="col-md-1">
												<p>
													<span class="glyphicon glyphicon-comment"></span>
													<span id="boardrecount"></span>
												</p>
											</div>
										</div>
										<div class="row"></div>
									</div>
								</div>
								<div class="row" id="content-row">
									<div class="col-md-12" id="content">
										<div class="row">
											<div class="col-md-12" id="detail-title">
												<div class="row">
													<div class="col-md-2">
														<p># ${dto.bno }</p>
													</div>
													<div class="col-md-10">
														<p>${dto.btag }</p>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12" id="detail-btitle">
														<h3>${dto.btitle }</h3>
													</div>
												</div>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-md-12">
												<div class="row">
													<div class="col-md-12">
														<img alt="${dto.bimg }" src="${dto.bimg }" />
													</div>
												</div>
												<p>${dto.bcontent }</p>
												<div class="row">
													<div class="col-md-12" id="like-box">
														<span class="glyphicon glyphicon-heart-empty">
															${dto.blikecount }</span>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12" id="modify-box">
														<a href="itModify.do?bno=${dto.bno}"><span class="glyphicon glyphicon-refresh"> Modify</span></a>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12" id="delete-box">
														<a href="itDel.do?bno=${dto.bno}"><span class="glyphicon glyphicon-trash"> Delete</span></a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!------------------reply-------------------- -->
								<div class="reply-con">
									<div>댓글 <span id="brecount"></span></div>
									<div id="view-reply">
										<!-- 추가되는 reply  -->
										<!-- 추가되는 reply 끝 -->
										
									</div>
									<div class="reply-login">login mnick</div>
									<form action="itRepinsert.do" method="post" name="frm"
										class="reply-frm">
										<div>
											<textarea rows="2" cols="30" name="rcontent"
												class="reply-txtarea" placeholder="댓글 쓰기"></textarea>
												<input type="hidden" name="bno" value="${dto.bno }"> 
												<input type="hidden" name="login-mno" value="2">	<!-- sessionId 호출 -->
										</div>
										<div>
											<input type="button" onclick="send()" value="입력"><br>
										</div>
									</form>
								</div>
							</div>
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