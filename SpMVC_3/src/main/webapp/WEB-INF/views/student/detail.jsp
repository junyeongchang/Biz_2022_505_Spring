<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<style>
table {
	width: 80%;
	margin: 20px auto;
}

th, td {
	padding: 12px;
	text-align: left;
}

th {
	background-color: #ddd;
	color: bluel
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생정보 자세히 보기</h1>
	<table>
		<tr>
			<th>학번</th>
			<th>${ST.stNum }</th>
			<th>이름</th>
			<th>${ST.stName }</th>
		</tr>
		<tr>
			<th>학과</th>
			<th>${ST.stDept }</th>
			<th>학년</th>
			<th>${ST.intGrade }</th>
		</tr>
		<tr>
			<th>전화번호</th>
			<th>${ST.stTel }</th>
			<th>주소</th>
			<th>${ST.stAddr }</th>
		</tr>
	</table>
</body>
</html>