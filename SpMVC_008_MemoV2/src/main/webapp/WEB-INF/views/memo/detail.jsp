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
	justify-content: center;
	align-items: center;
}

div.container {
	width: 50%;
	text-align: center;
}

div.w3-card-4 {
	display: inline-block;
	padding: 1rem;
}
</style>
</head>
<body>
	<div class="container">
		<div class="w3-card-4">
			<div>작성자 : ${MEMO.m_author}</div>
			<div>작성일자 : ${MEMO.m_date}</div>
			<div>작성시작 : ${MEMO.m_time}</div>
			<div>NFT메모 : ${MEMO.m_memo}</div>
			<div>
				NFT이미지 : <img src="${rootPath}/upload/${MEMO.m_up_image}"
					art="${MEMO.m_image}" width="100px">
			</div>
			<div>
				<a href="${rootPath}/memo/${MEMO.m_seq}/update" class="w3-button modal-close">수정</a> <a
					href="${rootPath}/memo/${MEMO.m_seq}/delete" class="w3-button modal-close">삭제</a> <a
					href="${rootPath}/" class="w3-button modal-close">홈으로</a>
			</div>
		</div>
	</div>
</body>
</html>