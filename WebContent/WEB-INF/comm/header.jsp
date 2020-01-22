<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<header class="left">
            <h1 class="logo"><a href="main.do">THE KBJ</a></h1>
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
                    <li><a href="oneLineList.do"><span class="glyphicon glyphicon-random"></span> 한줄게시판</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-random"></span> 경제</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-random"></span> 연예</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-random"></span> 스포츠</a></li>
                    <li><a href="itList.do"><span class="glyphicon glyphicon-random"></span> IT/과학</a></li>
                    <li><a href="opinionlist.do"><span class="glyphicon glyphicon-random"></span> 오피니언</a></li>
                </ul>
            </nav>
        </header>
