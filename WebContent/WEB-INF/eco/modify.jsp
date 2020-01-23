<%@page import="com.thekbj.dto.TableDTO"%>
<%
	TableDTO dto=(TableDTO)request.getAttribute("dto");
%>
<%@page import="com.thekbj.dto.TableDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 css 입니다. -->
<link rel="stylesheet" href="css/comm.css">
<!-- 각자 css는 여기다 추가해주시면 됩니다. -->
<link rel="stylesheet" href="css/eco/modify.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript" src="./se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script>
function cancel() {
	history.back();
};
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
				<!-- <p class="sponsor">
					<a href="#"><span class="glyphicon glyphicon-bell"></span>개인후원</a>
				</p>
				<div class="searchbox">
					<input type="text" value="search" class="search">
				</div> -->
			</div>
			<div class="content">
				<h2 class="con_title">경제</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<!-- <div class="board_menu_box">
					<ul class="board_menu">
						<li class="board_menu_li"><a href="">최신순</a></li>
						<li class="board_menu_li"><a href="">댓글순</a></li>
						<li class="board_menu_li"><a href="">조회순</a></li>
						<li class="board_menu_li"><a href="">추천순</a></li>
					</ul> -->
				</div>
				<!--내용작성 start -->

<script type="text/javascript">

	function checkFn(){
		
		var title = document.getElementById("btitle").value;
		var content = document.getElementById("bcontent").value;
		
		if(title==""){
			alert("제목을 입력해 주세요");
			document.getElementById("btitle").focus();
			return false;
		}
		
		if(content==""){
			alert("수정 할 내용을 입력해 주세요");
			document.getElementById("bcontent").focus();
			return false;
		}
		
		var f = document.getElementById("f");
		f.submit();
	}
</script>
</head>
<body>
	<form method="post" id="f" action="economyModifyresult.do">
				<input type="hidden" name="bno" id="bno" readonly value="<%=dto.getBno()%>">
						<ul class="write">
							<li>
								<label for="btitle">제목</label> 
								<input type="text" class="form-control" id="btitle" name="btitle"  required="required" value=<%=dto.getBtitle()%>>
							</li>
							<br>
						<li>
							<label for="bcontent">내용</label> 
							<textarea class="form-control" id="bcontent" name="bcontent"
													cols="50" rows="15" required="required" style="display:block;"><%=dto.getBcontent() %></textarea>
						</li>
						<br><br>
						<div style="text-align:center">
							<div class="checkbox" id="robot">
								<label> <input type="checkbox" name="checkrobot" id="checkrobot"/>로봇이아닙니다.
								</label>
							</div>
							<input type="hidden" id="bimg" name="bimg" value="${dto.bimg }">
						</div>
						<br>
						<div style="text-align: center;" id="modify-button-box">
							<button type="button" class="btn btn-primary" id="submit-but"
								onclick="submitContents(this);">수정완료</button>
							<button type="button" class="btn btn-primary" id="cancle-but"
								onclick="cancel()">돌아가기</button>
						</div>
					</ul>
				</form>
					<!--내용작성 end -->
	
					<br><a href="economyList.do">목록으로</a> 
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

	출처: https://jdkblog.tistory.com/39 [JDK's blog]
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