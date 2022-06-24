<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<form method="post" class="w3-container">
	<div>
		<input name="isbn" id="isbn" placeholder="ISBN" value="${BOOK.isbn}" class="w3-input"
		<c:if test="${not empty BOOK.isbn }"> 
		readonly="readonly"
		</c:if>
		> 
		<input name="title" id="title" placeholder="도서명 입력 후 Enter" value="${BOOK.title}" class="w3-input">
	</div>
	<div>
		<input name="author" placeholder="저자" value="${BOOK.author}" class="w3-input"> 
		<input name="publisher" placeholder="출판사" value="${BOOK.publisher}" class="w3-input"> 
		<input name="pubdate" placeholder="출판일자" value="${BOOK.pubdate}"> 
		<input name="price" placeholder="가격" type="number" value="${BOOK.price}" class="w3-input">
	</div>
	<div>
		<input name="link" placeholder="자세히보기" value="${BOOK.link}" class="w3-input"> 
		<input name="image" placeholder="이미지경로" value="${BOOK.image}" class="w3-input">
	</div>
	<textarea rows="10" name = "description" value="${BOOK.description}" class="w3-input"></textarea>
	<button type="button" class="w3-button w3-indigo book-save">저장</button>
</form>
	