<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
form.student.input {
	width: 80%;
	margin: 20px auto;
}

form.student.input div {
	display: flex;
}

form.student.input input, form.student.input button {
	flex: 1;
	padding: 16px 12px;
	margin: 5px;
}
</style>
<form method="post" class="student input">
	<div>
		<input name="st_num" value="${STUDENT.st_num }" />
	</div>
	<div>
		<input name="st_dept" value="${STUDENT.st_dept }" />
	</div>
	<div>
		<input name="st_tel" value="${STUDENT.st_tel }" />
	</div>
	<div>
		<input name="st_name" value="${STUDENT.st_name }" />
	</div>
	<div>
		<button>저장</button>
	</div>
</form>