<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>    
<style>
form.w3-container {
	width: 50%;
	margin:10px auto;
}

fieldset {
	padding:10px;
}
</style>
<form:form class="w3-container">
	<fieldset>
		<legend class="w3-center w3-text-black">회원가입</legend>
		
		<label class="w3-text-black">USER NAME</label>
		<input name="username" class="w3-input w3-border"/>

		<label class="w3-text-black">비밀번호</label>
		<input name="password"  class="w3-input w3-border"/>
		
		<label class="w3-text-black">비밀번호 확인</label>
		<input name="re_password"  class="w3-input w3-border"/>
		
		<label class="w3-text-black">E-mail</label>
		<input name="email"  class="w3-input w3-border"/>

		<label class="w3-text-black">실명</label>
		<input name="realname"  class="w3-input w3-border"/>
		
		<label class="w3-text-black">별명</label>
		<input name="nickname"  class="w3-input w3-border"/>
		
		<button class="w3-button w3-black w3-right w3-margin">회원가입</button>
	</fieldset>
</form:form>