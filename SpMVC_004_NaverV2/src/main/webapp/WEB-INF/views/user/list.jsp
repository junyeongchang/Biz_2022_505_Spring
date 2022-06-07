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
<title>나의 API App</title>
<link rel="stylesheet"
	href="${rootPath}/static/css/home.css?ver=2022-06-02-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=2022-06-02-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/modal.css?ver=2022-05-31-001">
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/input.js?ver=2022-05-31-008"></script>
<style>
section.ch-list-main{
	display: flex;
	flex-direction: column;
}
table.ch-booklist {
	width : 60%;
	margin: 15px 30px;
	border: 1px solid black;
	
}
.ch-btn-div {
	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<section class="ch-list-main">
		<table class="ch-booklist">
			<tr>
				<th>No.</th>
				<th>ISBN</th>
				<th>도서명</th>
				<th>출판사</th>
				<th>저자</th>
				<th>출판일자</th>
			</tr>
			<c:forEach items="${BOOKS}" var="BOOK">
				<tr>
					<td>1</td>
					<td>${BOOK.isbn}</td>
					<td>${BOOK.title}</td>
					<td>${BOOK.publisher}</td>
					<td>${BOOK.author}</td>
					<td>${BOOK.pubdate}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="ch-btn-div">
			<button class="ch-btn-black"><a href="${rootPath}/user/insert">도서정보추가</a></button>
		</div>
		<div> 1 2 3 4 5</div>
	</section>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>