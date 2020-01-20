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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="css/oneLine/list.css">

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
			</div>
			<div class="content">
				<h2 class="con_title">한줄 게시판</h2><!-- 각자카테고리명 텍스트만 바꿔주세요 -->
				<div class="board_menu_box">
					<ul class="board_menu">
						<li class="board_menu_li"><a href="">최신순</a></li>
						<li class="board_menu_li"><a href="">댓글순</a></li>
						<li class="board_menu_li"><a href="">조회순</a></li>
						<li class="board_menu_li"><a href="">추천순</a></li>
					</ul>
					<input type="button" value="글쓰기" class="btn_write">
				</div>
				<div class="board_box">
					<!--내용작성 start -->
					<c:forEach var="list" items="${requestScope.list}">
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>${list.mnick }</h6>
                                    <h6>${list.bwrdate }</h6>
                                </div>
                                <div class="clear"></div>
                            </div>
                            
                            <div class="top_right">
                                <div class="glyphicon glyphicon-pencil pen"></div>
                                <div class="glyphicon glyphicon-trash trash"></div>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                        
                        <div class="board_middle">
                            <h5>${list.bcontent }</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>${list.blikecount }</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>${list.brecount }</h6>
                            </div>
                            
                            <div class="clear"></div>
                            
                            <div class="bottom_form">
                                <form method="post" action="subadd.do" name="frm">
                                    <input type="hidden" name="no" value="1">
                                    <div class="row">
                                      <div class="no-padding col-md-11 row_area">
                                          <textarea name="textarea" id="textarea" class="form-control form_area" rows="1" ></textarea>
                                      </div>
                                      <div class="no-padding col-md-1 row_submit">
                                          <button type="submit" class="btn btn-default form_submit" onclick="send()">제출</button>
                                      </div>
                                    </div>
                                </form>                                
                            </div>
                        </div>
                        
	                      <div class="reply_content">
	                      <c:forEach var="replist" items="${requestScope.replist}">
                        	<c:if test="${list.bno == replist.bno }">
	                            <div class="reply_profile">
	                                <p><img src="img/oneLine/01.png" alt="#"></p>
	                            </div>
	                            <div class="reply">
	                                <div class="reply_title">
	                                   <div class="reply_left">
	                                        <h5>${replist.mnick }</h5>
	                                        <h6>${replist.rwdate }</h6>
	                                        <div class="clear"></div>
	                                   </div>
	                                   
	                                   <div class="reply_right">
	                                   	   <div class="glyphicon glyphicon-pencil pen"></div>
	                                       <div class="glyphicon glyphicon-remove"></div>
	                                   </div>
	                                   <div class="clear"></div>
	                                </div>
	                                <p class="reply_write">${replist.rcontent }</p>
	                            </div>
	                            <div class="clear"></div>
	                            </c:if>
                          </c:forEach>
	                       </div>
                        </div>
	                    </c:forEach>    
                    </div>
				</div>
        </div>
        <!--내용작성 end -->

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){
	  
	  /* 댓글 토글 기능 */
	  $(".bottom_right1").click(function(){
	    $(this).parent().next().slideToggle();
	  });
	  
	  /* 게시글 가져오기 */
		/* $.ajax({
			url:"oneLineListResult.do"
			,method:"post"
			,dataType: "json"
			,data:{'no':no}
		,success:function(data)
		{
			$.each(data,function(index,item){
				let result = "<tr><td>"+item.subno+"</td>";
				result+= "<td>" + item.subtitle+"</td>";
				result+= "<td>" + item.writer+"</td>";
				result+="<td><input type='button' value='삭제' onclick=del("+item.subno+","+item.boardno+")>";
				result+= "<td></tr>";
				$('#result').append(result);
			});
		}
		,error:function(data)
		{
			console.log('error',data);
		}
		}); */
		
		
	  $(document).scroll(function(){
		  let a = $(document).height();
		  let b =  $(window).height(); 
		  let c = $(window).scrollTop();
		  
	  	  if(a == b+c)
	  	  {
	  		alert('스크롤 맨끝!');	  
	  	  }
	  });
	});
</script>
</body>
</html>