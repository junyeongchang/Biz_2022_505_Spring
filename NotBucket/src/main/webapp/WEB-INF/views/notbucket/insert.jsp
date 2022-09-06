<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<form method="POST">
	<input name="b_seq" type="hidden"
		value='<c:out value="${NOTBUCKET.b_seq}" default="0"/>' />
	<div>
		<input name="b_title" placeholder="제목" value="${NOTBUCKET.b_title}" />
	</div>
	<div>
		<textarea name="b_content"  rows="5" cols="20" placeholder="내용"></textarea>
	</div>
	<div>
		<input name="b_rec" type="hidden" value='<c:out value="${NOTBUCKET.b_rec}"/>' />
	</div>
	<div>
		<button class="button-save">저장</button>
	</div>
</form>