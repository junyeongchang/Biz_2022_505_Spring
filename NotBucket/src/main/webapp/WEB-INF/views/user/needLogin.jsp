<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<table class="notbucket-table">
		<thead>
			<tr>
				<th>MY NOTBUCKET</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>로그인이 필요합니다.</td>
			</tr>
			<tr>
				<td><a href="${rootPath}/user/login">로그인한기</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>