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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

header {
	width: 50%;
	margin-bottom: 2rem;
}

div.memo {
	width: 50%;
	text-align: justify;
}

div.content:hover {
	cursor: pointer;
	background-color: #ccc;
}

div.content{
	display: inline-block;
	padding: 1rem;
	margin: 0.3rem;
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/memo.js?20220627009"></script>
</head>
<body>
	<header>
		<h1>나만의 NFT 전시관</h1>
		<h1>${USERNAME}님반갑습니다.</h1>
		<a href="${rootPath}/memo/insert" class="w3-button modal-close">메모
			작성</a>
		<c:if test="${empty USERNAME}">
			<a href="${rootPath}/user/login" class="w3-button modal-close">로그인</a>
		</c:if>
		<c:if test="${not empty USERNAME }">
			<a href="${rootPath}/user/logout" class="w3-button modal-close">로그아웃</a>
		</c:if>
	</header>
	<div class="memo">
		<c:if test="${empty MEMOS}">
			<tr>
				<td colspan="4">메모가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
				<div class="w3-card-4 content" data-seq="${MEMO.m_seq}">
					<div>
						<img src="${rootPath}/upload/${MEMO.m_up_image}"
							art="${MEMO.m_image}" width="100px">
					</div>
				</div>
		</c:forEach>
	</div>

</body>
</html>