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
		if (document.frm.rcontent.value != "") {
			document.frm.submit();
		}
	};
	
	function blike(like_bno, like_mno) {
/* 		if(tf) {
			$.ajax({
				url:'itLikeCount.do'
				,data : {'bno':like_bno,'mno':like_mno}
				,dataType: 'json'
				,method : 'post'
				,success : function(data) {
					alert("like!");
					$('#like_result').html(data.blikecount);
				}
				,error : function(data) {
					console.log(data);
				}
			});	
		} else {
			alert("already done");
		} */
			$.ajax({
				url:'itLikeCount.do'
				,data : {'bno':like_bno,'mno':like_mno}
				,dataType: 'json'
				,method : 'post'
				,success : function(data) {
					if(data.blikecount==0) {
						alert("already done");	
					} else {
						alert("like!");
						$('#like_result').html(data.blikecount);	
					}
				}
				,error : function(data) {
					console.log(data);
				}
			});	
	};
	
	$(document).ready(function() {
		let no = ${requestScope.bdto.bno };
		var brecount = 0;
		$.ajax({
					url : 'itReplyList.do',
					data : {'num' : no },
					dataType : 'json',
					method : 'post',
					success : function(data) {
								$.each(data, function(index, item) {
									let result = '<div class="reply-con-box">';
									result += '<div class="row">';
									result += '<div class="col-md-12">';
									result += '<div class="row"><div class="col-md-12">'+ item.mnick;
									result += '</div></div>';
									result += '<div class="row"><div class="col-md-12">' + item.rwrdate + '</div></div>';
									if(${sessionScope.mno}==item.mno) {
										result += '<a style="float:right" href="itRepdel.do?rno=' + item.rno + '&bno=' + ${bdto.bno } +'">삭제</a>'; 
									}
									result += '</div>';
									result += '<div class="col-md-12">' + item.rcontent + '</div>';
									result += '</div>';
									result += '</div>'; 
									$('#view-reply').append(result);
										brecount += 1;
									});
									$('#brecount').append(brecount);
									$('#boardrecount').append(brecount);
					},
					error : function(data) {
							console.log(data);
					}
			});
	});
</script>
</head>
<body>
	<c:set var="dto" value="${requestScope.bdto }" />

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
					<div class="container-fluid" style="background-color: white">
						<div class="row">
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-12" id="detail-header">
										<div class="row">
											<div class="col-md-10">
												<div class="col-md-12">
													<p>
														<a href="#" style="font-size: 20px">${bdto.mnick }</a> <span
															class="glyphicon glyphicon-leaf" style="font-size: 12px">${bdto.mscore }</span>
													</p>
												</div>
												<div class="col-md-12">
													<p>${bdto.bwrdate }</p>
												</div>
											</div>
											<div class="col-md-1">
												<p>
													<span class="glyphicon glyphicon-eye-open"></span>
													${bdto.bviewcount }
												</p>
											</div>
											<div class="col-md-1">
												<p>
													<span class="glyphicon glyphicon-comment"></span> <span
														id="boardrecount"></span>
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
													<div class="col-md-12" style="font-size: 15px">
														<p># ${bdto.bno} <strong>${bdto.btag }</strong></p>
													</div>
												</div>
												<%-- <div class="row">
													<div class="col-md-2">
														<p># ${bdto.bno }</p>
													</div>
													<div class="col-md-10">
														<p>${bdto.btag }</p>
													</div>
												</div> --%>
												<div class="row">
													<div class="col-md-12" id="detail-btitle">
														<h3>${bdto.btitle }</h3>
													</div>
												</div>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-md-12">
												<%-- <div class="row">
													<div class="col-md-12">
														<img alt="${bdto.bimg }" src="${bdto.bimg }" />
													</div>
												</div> --%>
												<p>${bdto.bcontent }</p>
												
												<!------------------- like ----------------------->
												<div class="row">
													<div class="col-md-12" id="like-box">
													<c:set var="done_like" value="0"/>
													<%-- <c:forEach var="list" items="${sessionScope.likelist }">
														<c:if test="${list == bdto.bno }">
															<c:set var="done_like" value="1"/>		
														</c:if>
													</c:forEach> --%>
														<c:if test="${sessionScope.dto.mnick != null }">
															<form action="updateLike.do" method="post" id="ftm_like" onclick="blike(${bdto.bno },${sessionScope.dto.mno })">
																<input type="hidden" name="bno" id="like_bno" value="${bdto.bno }">
																<input type="hidden" name="mno" id='like_mno' value="${sessionScope.dto.mno }">
																<span class="glyphicon glyphicon-heart-empty" id="like_result">${bdto.blikecount}</span>
															</form>
															<%-- <c:choose>
																<c:when test="${done_like==1}">
																	<form action="updateLike.do" method="post" id="ftm_like" onclick="blike(${bdto.bno },${sessionScope.dto.mno },${false})">
																		<input type="hidden" name="bno" id="like_bno" value="${bdto.bno }">
																		<input type="hidden" name="mno" id='like_mno' value="${sessionScope.dto.mno }">
																	<span class="glyphicon glyphicon-heart-empty" id="like_result">${bdto.blikecount}</span>
																	</form>
																</c:when>
																<c:when test="${done_like==0}">
																	<form action="updateLike.do" method="post" id="ftm_like" onclick="blike(${bdto.bno },${sessionScope.dto.mno },${true})">
																		<input type="hidden" name="bno" id="like_bno" value="${bdto.bno }">
																		<input type="hidden" name="mno" id='like_mno' value="${sessionScope.dto.mno }">
																	<span class="glyphicon glyphicon-heart-empty" id="like_result">${bdto.blikecount}</span>
															</form>
																</c:when>
															</c:choose> --%>
														</c:if>
														<c:if test="${sessionScope.dto.mnick == null }">
															<span class="glyphicon glyphicon-heart-empty" id="like_result" onclick="needlike()">${bdto.blikecount}</span>
														</c:if>
													</div>
												</div>
												<!------------------- like ----------------------->
												<!-------------------  delete, modify------------- -->
												<c:if test="${sessionScope.dto.mnick == requestScope.bdto.mnick}">
													<div class="row">
													<div class="col-md-12" id="modify-box">
														<a href="itModify.do?bno=${bdto.bno}"><span
															class="glyphicon glyphicon-refresh"> Modify</span></a>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12" id="delete-box">
														<a href="itDel.do?bno=${bdto.bno}"><span
															class="glyphicon glyphicon-trash"> Delete</span></a>
													</div>
												</div>
												</c:if>
												<!-------------------  delete, modify end------------- -->
											</div>
										</div>
									</div>
								</div>

								<!------------------reply-------------------- -->
								<div class="reply-con">
									<div>
										댓글 <span id="brecount"></span>
									</div>
									<div id="view-reply">
										<!-- 추가되는 reply  -->
										<!-- 추가되는 reply 끝 -->

									</div>
									<div class="reply-login">login mnick</div>
									<form action="itRepinsert.do" method="post" name="frm"
										class="reply-frm">
										<c:choose>
											<c:when test="${sessionScope.dto.mnick != null }">
												<div>
													<textarea rows="2" cols="30" name="rcontent"
														class="reply-txtarea" placeholder="댓글 쓰기"></textarea>
													<input type="hidden" name="bno" value="${bdto.bno }">
													<input type="hidden" name="login-mno" value="${sessionScope.dto.mno}">
													<!-- sessionId 호출 -->
												</div>
												<div>
													<input type="button" onclick="send()" value="입력"><br>
												</div>
											</c:when>
											<c:when test="${sessionScope.dto.mnick == null }">
												<div>
													<textarea rows="2" cols="30" name="rcontent"
														class="reply-txtarea" placeholder="로그인 후 댓글작성이 가능합니다." readonly="readonly"></textarea>
													<input type="hidden" name="bno" value="${bdto.bno }">
													<input type="hidden" name="login-mno">
													<!-- sessionId 호출 -->
												</div>
											</c:when>
										</c:choose>
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
	<script>
	function needlike() {
		alert("need login");
	};
	</script>
</body>
</html>