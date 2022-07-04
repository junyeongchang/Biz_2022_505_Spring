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

form {
	width: 50%;
	text-align: center;
}

input {
	padding: 1rem;
	width: 100%;
}
</style>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<input name="m_seq" type="hidden" 
			value='<c:out value="${MEMO.m_seq}" default="0"/>' >
		<input name="m_memo" placeholder="메모를 입력하세요" value="${MEMO.m_memo}"> 
		<input name="file" type="file" accept="images/*">
		<button class="w3-button modal-close">메모기록</button>
	</form>
</body>
</html>