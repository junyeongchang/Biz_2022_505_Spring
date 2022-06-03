<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<h1>My Api</h1>
	<p>Naver API를 활용한 도서, 뉴스, 영화 정보 서비스</p>
</header>
<nav>
	<ul>
		<li><a href="${rootPath}/">Home</a></li>
		<li><a href="${rootPath}/user/list">도서정보</a></li>
		<li><a href="${rootPath}/news">오늘의 뉴스</a></li>
		<li><a href="${rootPath}/movies">영화정보</a></li>
		<li><a href="${rootPath}/naver">네이버체험하기</a></li>

		<%
		// 로그인을 하지 않았을때
		%>
		<c:if test="${ empty MEMBER}">
			<li><a href="${rootPath}/member/login">로그인</a></li>
			<li><a href="${rootPath}/member/join">회원가입</a></li>
		</c:if>

		<%
		// 로그인을 하였을때는 MEMBER 객체에 로그인한 사용자 정보가 담겨있다
		%>
		<c:if test="${not empty MEMBER}">
			<li><a href="${rootPath}/member/mypage">My Page</a></li>
			<li><a href="${rootPath}/member/logout">Logout</a></li>
		</c:if>
	</ul>
</nav>