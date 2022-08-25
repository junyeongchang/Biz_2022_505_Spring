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
	padding: 5px;
	display: flex;
	flex-direction: row;
}

main.ch-main article {
	flex: 1;
	margin: 0 5px;
}



footer.ch-footer {
	height: 10%;
	background-color: black;
	color: white;
	text-align: center;
	padding: 0.9rem;
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/resources/js/alllist.js?ver=2022-08-25-001"></script>
<script src="${rootPath}/resources/js/mylist.js?ver=2022-08-25-001"></script>
<script src="${rootPath}/resources/js/ranklist.js?ver=2022-08-25-001"></script>
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
						<li><a href="${rootPath}/user/mypage">${USER.username}님 MyPage</a></li>
						<li><a href="${rootPath}/user/logout">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
		<main class="ch-main">
			<c:choose>
				<c:when test="${LAYOUT == 'JOIN' }">
					<%@ include file="/WEB-INF/views/user/join.jsp"%>
				</c:when>
				<c:when test="${LAYOUT == 'LOGIN' }">
					<%@ include file="/WEB-INF/views/user/login.jsp"%>
				</c:when>
				<c:when test="${LAYOUT == 'MYPAGE' }">
					<%@ include file="/WEB-INF/views/user/mypage.jsp" %>
				</c:when>
				<c:when test="${LAYOUT == 'INSERT' }">
					<%@ include file="/WEB-INF/views/notbucket/insert.jsp" %>
				</c:when>
				<c:otherwise>
					<article>
						<%@include file="/WEB-INF/views/notbucket/ranklist/ranklist.jsp"%>
					</article>
					<article>
						<%@include file="/WEB-INF/views/notbucket/list.jsp"%>
					</article>
					<article>
						<c:choose>
							<c:when test="${empty USER}">
								<%@include file="/WEB-INF/views/user/needLogin.jsp"%>
							</c:when>
							<c:otherwise>
								<%@include file="/WEB-INF/views/notbucket/mylist/mylist.jsp"%>
							</c:otherwise>
						</c:choose>
					</article>
				</c:otherwise>
			</c:choose>
		</main>
		<footer class="ch-footer">
			<address>CopyRight &copy; jychang11@naver.com</address>
		</footer>
	</div>
</body>
</html>