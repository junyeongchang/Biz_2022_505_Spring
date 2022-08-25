<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>
<body>
	<h1>NOT BUCKET 자세히 보기</h1>
	<h3>제목 : ${NOTBUCKET.b_title}</h3>
	<h3>내용 : ${NOTBUCKET.b_content}</h3>
	<h3>추천수 : ${NOTBUCKET.b_rec }</h3>
	<div>
		<a href="${rootPath}/notbucket/recommend?seq=${NOTBUCKET.b_seq}">추천하기</a>
		<a href="${rootPath}/">처음으로</a>
	</div>
	
</body>
</html>