<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<table class="mynotbucket-table">
		<thead>
			<tr>
				<th><span>MY NOTBUCKET</span></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${MNOTBUCKETS}" var="NOTBUCKET">
				<tr data-seq = "${NOTBUCKET.b_seq}">
					<td>${NOTBUCKET.b_title}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/views/notbucket/mylist/pagination.jsp" %>
	<a href="${rootPath}/notbucket/insert">NOT BUCKET 추가하기</a>
</body>
</html>