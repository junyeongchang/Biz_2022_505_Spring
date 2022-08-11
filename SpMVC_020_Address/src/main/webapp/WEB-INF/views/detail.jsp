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
</head>
<body>
	<h1>상세화면</h1>
	<h3>이름 : ${ADDRESS.a_name}</h3>
	<h3>전화번호 : ${ADDRESS.a_tel}</h3>
	<h3>주소 : ${ADDRESS.a_address}</h3>
	
	<a href="${rootPath}/update?seq=${ADDRESS.a_seq }">수정하기</a>
	<a href="${rootPath}/delete?seq=${ADDRESS.a_seq }">삭제하기</a>
	<a href="${rootPath}/">처음으로</a>
</body>
</html>