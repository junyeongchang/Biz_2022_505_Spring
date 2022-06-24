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
<style>
img.ch-image {
	height: 300px;
	width: 300px;
}
</style>
</head>
<body>
<section>
		<div>
			<div>
			<c:choose>
				<c:when test="${not empty memoVO.m_image}">
					<img class="ch-image" src="${rootPath}/upload/${memoVO.m_image}">
				</c:when>
			</c:choose>
			</div>
			<div>
				<p>작성자 : ${memoVO.m_author}</p>
				<p>메모 : ${memoVO.m_memo}</p>
			</div>
		</div>
		<div>
			<a href="${rootPath}/" class="list">리스트</a> 
			<a href="${rootPath}/${memoVO.m_seq}/update" class="update">수정</a>
			<a href="${rootPath}/${memoVO.m_seq}/delete" class="delete">삭제</a>
		</div>
	</section>
</body>
</html>