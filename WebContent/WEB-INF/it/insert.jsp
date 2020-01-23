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
<script type="text/javascript" src="./se2/js/HuskyEZCreator.js" charset="utf-8"></script>

<script>
	function cancel() {
		history.back();
	};
	function select_tag_sel(ele) {
			//아래 [] 안에 btag로 지정할 값들을 나열해 주세요.
		  var it_option = ["pc", "mobile", "etc"];
		  var one_option = [];					
		  var eco_option = [];
		  var ent_option = ["TV","영화","스타"];
		  var spo_option = ["축구","해외축구","야구","해외야구","국내야구"];
		  var op_option = ["eco", "ent", "spo"];
		  
		  var target = document.getElementById("tag-sel");
		 
		  if(ele.value == "it") var option_list = it_option;
		  else if(ele.value == "one") var option_list = one_option;
		  else if(ele.value == "eco") var option_list = eco_option;
		  else if(ele.value == "ent") var option_list = ent_option;
		  else if(ele.value == "spo") var option_list = spo_option;
		  else if(ele.value == "op") var option_list = op_option;
		 
		  target.options.length = 0;
		 
		  for (i in option_list) {
		    var opt = document.createElement("option");
		    opt.value = option_list[i];
		    opt.innerHTML = option_list[i];
		    target.appendChild(opt);
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
					<div class="container-fluid" style="background-color: white" >
						<div class="row">
							<div class="col-md-12" id="con-row">
								<div class="row">
									<div class="col-md-12">
										<form role="form" action="itInsertresult.do" method="post"
											name="frm">
											<input type="hidden" class="form-control" id="mno" name="mno"
												value="${sessionScope.mno }" />
											<div class="form-group" id="mnick-box">
												<label for="mnick"> ${sessionScope.dto.mnick} </label> <input
													type="hidden" class="form-control" id="mnick" name="mnick"
													value="${sessionScope.dto.mnick}" />
											</div>
											<div class="form-group">
												<label for="mscore"> ${sessionScope.dto.mscore } </label> <input
													type="hidden" class="form-control" id="mscore"
													name="${sessionScope.dto.mscore }" value="mscore" />
											</div>
											<hr>
											<div class="form-group">
												<label for="ctg-sel">카테고리</label> <br>
												 <select id="ctg-sel" class="form-control" name="ctg-sel" onchange="select_tag_sel(this)">
													<option value="it" selected="selected">IT/과학</option>
													<option value="one">한줄게시판</option>
													<option value="eco">경제</option>
													<option value="ent">연예</option>
													<option value="spo">스포츠</option>
													<option value="op">오피니언</option>
												</select>
											</div>
											<div class="form-group">
												<label for="tag-sel">태그</label> <br> 
												<select id="tag-sel" name="tag-sel" class="form-control" >
													<option value="pc" selected="selected">PC</option>
													<option value="mobile">Mobile</option>
													<option value="etc">IT etc</option>
												</select>
											</div>
											<div class="form-group">
												<label for="btitle"> 제목 </label> <input type="text"
													class="form-control" id="btitle" name="btitle" required />
											</div>
											<div class="form-group">
												<label for="bcontent"> 내용 </label>
												<textarea class="form-control" id="bcontent" name="bcontent"
													cols="50" rows="15" required style="display:none"></textarea>
											</div>
											<div class="form-group">
												<label for="bimg"></label> <input type="hidden"
													class="form-control-file" id="bimg" name="bimg" value="" />
											</div>
											<div style="text-align: center;">
												<div class="checkbox" id="robot">
													<label> <input type="checkbox" name="checkrobot" id="checkrobot" />로봇이
														아닙니다.
													</label>
												</div>
											</div>
											<div style="text-align: center;" id="insert-button-box">
												<button type="button" class="btn btn-primary"
													id="submit-but" onclick="submitContents(this);">저장</button>
												<button type="button" class="btn btn-primary"
													id="cancle-but" onclick="cancel()">돌아가기</button>
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