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
	<table class="ranknotbucket-table w3-container">
		<thead>
			<tr>
				<th><span>추천수 많은 NOTBUCKET</span></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${RNOTBUCKETS}" var="NOTBUCKET">
				<tr data-seq = "${NOTBUCKET.b_seq}" class="ch-content">
					<td>${NOTBUCKET.b_title}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/views/notbucket/ranklist/pagination.jsp" %>
</body>
</html>