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
<script type="text/javascript" src="./se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script>
	function cancel() {
		history.back();
	}
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
						<form method="post" action="enterModifyresult.do">
							<ul class="enterboard_insertul">
								<li>
									<%-- <label>글번호</label>
									<c:out value="${dto.bno}"></c:out> --%>
									<input type="hidden" name="bno" id="bno" value="${dto.bno}"> 
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
								<li class="boardTitle">
									<label class="titlehidden">글제목</label>
									<input type="text" name="btitle" id="btitle" value="${dto.btitle}" class="form-control" required="required">
								</li>
								<li>
									<label class="titlehidden">내용</label>
									<textarea class="form-control" id="bcontent" name="bcontent"cols="50" rows="15" required style="display:none">${dto.bcontent}</textarea>
									<input type="hidden" class="form-control-file" id="bimg" name="bimg" value="${dto.bimg }" /><!-- list에 이미지 넣기위해 -->
									<%-- <textarea rows="3" cols="20" name="bcontent" id="bcontent" class="form-control">${dto.bcontent}</textarea> --%>
								</li>
								<!-- <li class="boardFile">
									<label for="bimg" class="titlehidden"> 사진첨부 </label>
									<input type="file" class="form-control-file" id="bimg" name="bimg" />
								</li> -->
								<li class="board_btn">
									<button type="button" class="btn btn-primary"
													id="submit-but" onclick="submitContents(this);">저장</button>
									<button type="button" class="btn btn-primary"
										id="cancle-but" onclick="cancel()">돌아가기</button>
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
		<script type="text/javascript">
var oEditors = [];

// 추가 글꼴 목록
//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "bcontent",
	sSkinURI: "se2/SmartEditor2Skin.html",	
	htParams : {
		bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
		fOnBeforeUnload : function(){
			//alert("완료!");
		}
	}, //boolean
	fOnAppLoad : function(){
		//예제 코드
		//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
	},
	fCreator: "createSEditor2"
});

function pasteHTML(filepath) {
	var sHTML = "<span><img style='width:100%' src='http://localhost:8080/thekbj/upLoadFolder/"+filepath+"' alt='imgurl'><\/span>";
	oEditors.getById["bcontent"].exec("PASTE_HTML", [sHTML]);
}
	
function submitContents(elClickedObj) {

	oEditors.getById["bcontent"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		try {
		elClickedObj.form.submit();
	} catch(e) {}

	
}

</script>
</body>
</html>