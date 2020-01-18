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
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
					<!--내용작성 start -->
					<div class="board_box">
                        <div class="board_top">
                           <div class="top_left">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                                <div class="profile">
                                    <h6>아이디</h6>
                                    <h6>올린날짜, 시간</h6>
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
                            <h5>♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
</h5>
                        </div>
                        
                        <div class="board_bottom">
                            <div class="bottom_left1">
                                <div class="glyphicon glyphicon-thumbs-up"></div>
                                <h6>숫자</h6>
                            </div>
                            
                            <div class="bottom_right1">
                                <h6>댓글 숫자 갯수</h6>
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
                            <div class="reply_profile">
                                <p><img src="img/oneLine/01.png" alt="#"></p>
                            </div>
                            
                            <div class="reply">
                                <div class="reply_title">
                                   <div class="reply_left">
                                        <h5>아이디</h5>
                                        <h6>올린날짜, 시간</h6>
                                        <div class="clear"></div>
                                   </div>
                                   
                                   <div class="reply_right">
                                       <div class="glyphicon glyphicon-remove"></div>
                                   </div>
                                   <div class="clear"></div>
                                </div>
                                
                                <p class="reply_write">♧ 민주당, 이해찬·문희상 지역구 등 13곳 전략공천 지역구로.. 17일 최고위 회의에서 최종 결정.. 구체적으로 종로(정세균), 광진을(추미애), 용산(진영), 구로을(박영선), 부천 오정(원혜영), 고양정(김현미), 고양병(유은혜), 광명갑(백재현), 의정부갑(문희상), 용인정(표창원), 세종(이해찬), 양산을(서형수), 제주갑(강창일) 등 전략공천 대상
                                </p>
                            </div>
                            
                            <div class="clear"></div>
                        </div>
                            
                    </div>
					<!--내용작성 end -->
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>

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