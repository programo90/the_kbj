<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<header class="left">
            <h1 class="logo"><a href="main.do" class="logoA">THE KBJ</a></h1>
            <div class="menuTop">
            <c:if test="${sessionScope.mnick == null}">
				<p class="menuTop_btn"><a href="memberLogin.do" class="menuTop_btn_a"><span class="glyphicon glyphicon-log-out"></span> 로그인</a></p>
                <p class="menuTop_btn"><a href="memberJoin.do" class="menuTop_btn_a"><span class="glyphicon glyphicon-user"></span> 회원가입</a></p>
			</c:if> 
            <c:if test="${sessionScope.mnick != null}">
				<p class="menuTop_btn"><a href="memberLogout.do" class="menuTop_btn_a"><span class="glyphicon glyphicon-log-in"></span> 로그아웃</a></p>
                <p class="menuTop_btn"><a href="#" class="menuTop_btn_a"><span class="glyphicon glyphicon-user"></span> ${sessionScope.mnick} </a></p>
			</c:if>
            </div>
            <nav>
                <ul>
                    <li class="menuli"><a href="oneLineList.do" class="menulia"><span class="glyphicon glyphicon-pencil"></span> 한줄게시판</a></li>
                    <li class="menuli"><a href="economyList.do" class="menulia"><span class="glyphicon glyphicon-globe"></span> 경제</a></li>
                    <li class="menuli"><a href="enterList.do" class="menulia"><span class="glyphicon glyphicon-film"></span> 연예</a></li>
                    <li class="menuli"><a href="sportsList.do" class="menulia"><span class="glyphicon glyphicon-tower"></span> 스포츠</a></li>
                    <li class="menuli"><a href="itList.do" class="menulia"><span class="glyphicon glyphicon-phone"></span> IT/과학</a></li>
                    <li class="menuli"><a href="opinionlist.do" class="menulia"><span class="glyphicon glyphicon-comment"></span> 오피니언</a></li>
                </ul>
            </nav>
        </header>
