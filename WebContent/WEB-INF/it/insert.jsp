<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- 공통 css 입니다. -->
<link rel="stylesheet" href="css/comm.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->
<link rel="stylesheet" href="css/it/it.insert.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script>
	function cancel() {
		history.back();
	}
	function send() {
		if(document.frm.checkrobot.check!='checked'){
			document.frm.submit();
		}
	};
</script>
</head>
<body>
	<jsp:include page="../comm/header.jsp"></jsp:include>
	<div class="right">
		<br>
		<section class="content_box">
		<div class="content">
			<h2 class="con_title" style="margin: 30px">글쓰기</h2>
			<!-- 각자카테고리명 텍스트만 바꿔주세요 -->
			<div class="board_box">
				<!--내용작성 start -->
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12" id="con-row">
							<div class="row">
								<div class="col-md-12">
									<form role="form" action="itInsertresult.do" method="post" name="frm">
										<input type="hidden"
												class="form-control" id="mno" name="mno" value="2" />
										<div class="form-group" id="mnick-box">
											<label for="mnick"> login mnick </label> <input type="hidden"
												class="form-control" id="mnick" name="mnick" value="park2" />
										</div>
										<div class="form-group">
											<label for="mscore"> mscore </label> <input type="hidden"
												class="form-control" id="mscore" name="${sessionScope.mscore }"
												value="mscore" />
										</div>
										<hr>
										<div class="form-group">
											<label for="ctg-sel">카테고리</label> <br> <select
												id="ctg-sel" name="ctg-sel">
												<option value="it" selected="selected">IT/과학</option>
												<option value="one">한줄게시판</option>
												<option value="eco">경제</option>
												<option value="ent">연예</option>
												<option value="spo">스포츠</option>
												<option value="op">오피니언</option>
											</select>
										</div>
										<div class="form-group">
											<label for="tag-sel">태그</label> <br> <select
												id="tag-sel" name="tag-sel">
												<option value="pc" selected="selected">PC</option>
												<option value="mobile">Mobile</option>
												<option value="etc">IT etc</option>
											</select>
										</div>
										<div class="form-group">
											<label for="btitle"> 제목 </label> 
											<input type="text"
												class="form-control" id="btitle" name="btitle" required/>
										</div>
										<div class="form-group">

											<label for="bcontent"> 내용 </label>
											<textarea class="form-control" id="bcontent" name="bcontent"
												cols="50" rows="15" required></textarea>
										</div>
										<div class="form-group">
											<label for="bimg"> 사진첨부 </label> <input type="file"
												class="form-control-file" id="bimg" name="bimg"/>
										</div>
										<div style="text-align: center;">
											<div class="checkbox" id="robot">
												<label> <input type="checkbox" name="checkrobot"/>로봇이 아닙니다.
												</label>
											</div>
										</div>
										<div style="text-align: center;" id="insert-button-box">
											<button type="button" class="btn btn-primary" id="submit-but" onclick="send()">
												저장</button>
											<button type="button" class="btn btn-primary" id="cancle-but"
												onclick="cancel()">돌아가기</button>
										</div>
									</form>
								</div>
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