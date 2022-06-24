<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<style>
table.memo tr, td, th {
	border: 1px solid black;
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/resources/js/memolist.js?ver=2022-06-24-010"></script>
</head>
<body>
	<table class="memo">
		<tr>
			<th>개발자 Email(작성자)</th>
			<th>메모</th>
			<th>이미지</th>
			<th>날짜</th>
			<th>시간</th>
		</tr>
		<c:forEach items="${memoList}" var="memoVO">
			<tr data-seq="${memoVO.m_seq}">
				<td>${memoVO.m_author}</td>
				<td>${memoVO.m_memo}</td>
				<td>${memoVO.m_image}</td>
				<td>${memoVO.m_date}</td>
				<td>${memoVO.m_time}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="btn_box">
		<a href="${rootPath}/insert">추가</a>
	</div>
</body>
</html>