<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}/resources/css/reset.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
div.ch-main {
	display: flex;
	flex-direction: column;
	width: 100vw;
	height: 100vh;
}

header.ch-header {
	display: flex;
	flex-direction: row;
	height: 10%;
	background-color: black;
	color: white;
}

nav {
	display: flex;
	flex-direction: column;
	background-color: black;
	color: white;
}

nav ul {
	list-style: none;
	display: flex;
}

nav li {
	padding: 12px 16px;
}

nav li:hover {
	cursor: pointer;
	color: gray;
	font-weight: 900;
}

nav li:nth-of-type(2) {
	margin-left: auto;
}

main.ch-main {
	flex: 1;
}

footer.ch-footer {
	height: 10%;
	background-color: black;
	color: white;
	text-align: center;
	padding: 0.9rem;
}
</style>
</head>
<body>
	<div class="ch-main">
		<header class="ch-header">
			<div>NOT message</div>
			<div>확인 버튼</div>
		</header>
		<nav>
			<ul>
				<li><a href="${rootPath}/">HOME</a></li>
				<c:choose>
					<c:when test="${empty USER}">
						<li><a href="${rootPath}/user/login">로그인</a></li>
						<li><a href="${rootPath}/user/join">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li>로그아웃</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
		<main class="ch-main">
			<section>
				<div>
					<div>게시판 목록1</div>
					<div>게시판 목록2</div>
					<div>로그인 시 보이는 자기 게시판2</div>
				</div>
			</section>
		</main>
		<footer class="ch-footer">
			<address>CopyRight &copy; jychang11@naver.com</address>
		</footer>
	</div>
</body>
</html>