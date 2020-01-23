<%@page import="com.thekbj.dto.TableDTO"%>
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

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="./se2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script>
function cancel() {
	history.back();
};
</script>
</head>
<body>
	<c:set var="num" value="${requestScope.num}"></c:set>
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
				<!-- <p class="sponsor">
					<a href="#"><span class="glyphicon glyphicon-bell"></span>개인후원</a>
				</p> -->
				<!-- <div class="searchbox">
					<input type="text" value="search" class="search">
				</div> -->
			</div>
			<div class="content">
				<h2 class="con_title">경제</h2>
				<!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<!-- <ul class="board_menu">
						<li class="board_menu_li"><a href="">최신순</a></li>
						<li class="board_menu_li"><a href="">댓글순</a></li>
						<li class="board_menu_li"><a href="">조회순</a></li>
						<li class="board_menu_li"><a href="">추천순</a></li>
					</ul> -->
				</div>
				<!--내용작성 start -->
				<form method="post" action="economyInsertresult.do">
					<ul>
						<li>
							<label for="btcg">카테고리</label>
							<select id="bctg" name="bctg" class="form-control">
								<option value="금융">금융</option>
								<option value="산업">산업</option>
								<option value="부동산">부동산</option>
								<option value="생활경제">생활경제</option>
								<option value="경제일반">경제일반</option>
							</select>
						</li>
							<li>
								<label for="btitle">제목</label> 
								<input type="text" class="form-control" id="btitle" name="btitle"  required="required" placeholder="제목을 입력하세요">
							</li>
						<li>
							<label for="bcontent">내용</label> 
							<textarea class="form-control" id="bcontent" name="bcontent"
													cols="50" rows="15" required style="display:none"></textarea>
						</li>
						<br><br>
						<div style="text-align:center;">
							<div class="checkbox" id="robot">
								<label> <input type="checkbox" name="checkrobot" id="checkrobot"/>로봇이아닙니다.
								</label>
							</div>
							<input type="hidden" value="" id="bimg" name="bimg">
						</div>
						<br>
						<div style="text-align:center;" id="insert-button-box">
							<button type="button" class="btn btn-primary" id="submit-but"
								onclick="submitContents(this);">저장</button>
							<button type="button" class="btn btn-primary" id="cancle-but"
								onclick="cancel()">돌아가기</button>
						</div>
					</ul>
				</form>
				<br><br>
					<a href="economyList.do?num=${currpage}">목록으로</a>
				<!--내용작성 end -->
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
	var sHTML = "<span><img style='width:500px' align='center' src='http://localhost:8080/thekbj/upLoadFolder/"+filepath+"' alt='imgurl'><\/span>";
	var bimg = "http://localhost:8080/thekbj/upLoadFolder/"+filepath;
	document.getElementById('bimg').value = bimg;

	oEditors.getById["bcontent"].exec("PASTE_HTML", [sHTML]);
}
	
function submitContents(elClickedObj) {
	if (document.getElementById('checkrobot').checked) {
		oEditors.getById["bcontent"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
			try {
			elClickedObj.form.submit();
		} catch(e) {}
	} else {
		alert("로봇이신가요?");
	}
}
</script>
</body>
</html>