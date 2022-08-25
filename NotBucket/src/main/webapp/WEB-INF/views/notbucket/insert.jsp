<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<form method="POST">
	<input name="b_seq" type="hidden" value='<c:out value="${NOTBUCKET.b_seq}" default="0"/>' /> 
	<input name="b_title" placeholder="제목" value="${NOTBUCKET.b_title}" /> 
	<input name="b_content" placeholder="내용" type="text" value="${NOTBUCKET.b_content}" /> 
	<input name="b_rec" type="hidden" value='<c:out value="${NOTBUCKET.b_rec}"/>' /> 
	<button class="button-save">저장</button>
</form>