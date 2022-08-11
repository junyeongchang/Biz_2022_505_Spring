<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<header>
	<h1>주소록 2022</h1>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/list.js?ver=2022-07-20-004"></script>
<script src="${rootPath}/static/js/input.js?ver=2022-07-20-001"></script>
</header>
<nav>
	<ul>
		<li><a href="${rootPath}/">HOME</a></li>
		<li><a href="${rootPath}/about">About</a></li>
		<li>JOIN</li>
		<li>LOGIN</li>
	</ul>
</nav>