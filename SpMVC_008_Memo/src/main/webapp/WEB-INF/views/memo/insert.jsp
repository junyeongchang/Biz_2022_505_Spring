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
section.main {
	width: 70%;
	margin: 10px auto;
}

form#memoVO input, form#memoVO button {
	width: 90%;
}
img.ch-image {
	height: 300px;
	width: 300px;
}
</style>
</head>
<body>
	<section class="main">
		<form:form modelAttribute="memoVO" encType="multipart/form-data">
			<input name="m_seq" id="m_seq" placeholder="SEQ"
				value="${memoVO.m_seq}"
				<c:if test="${not empty memoVO.m_seq }">
			readonly="readonly"
		</c:if>>

			<form:input path="m_author" placeholder="개발자 Email" />
			<form:input path="m_memo" placeholder="메모내용" />
			<c:choose>
				<c:when test="${not empty memoVO.m_image}">
					<img class="ch-image" src="${rootPath}/upload/${memoVO.m_image}">
				</c:when>
			</c:choose>
			<input type="file" name="image"/>
			<button>보내기</button>
		</form:form>
	</section>
</body>
</html>