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
form.bbs_write {
	width: 80%;
	margin: 10px auto;
}

form.bbs_write h2, form.bbs_write input, form.bbs_write textarea {
	width: 90%;
	margin: 5px auto;
	padding: 8px;
}
</style>
</head>
<body>
	<form method="post" class="bbs_write" enctype="multipart/form-data">
		<h2>게시판 글쓰기</h2>
		<input name="b_date" value="${BBS.b_date}" type="date" hidden ="hidden">
		<input name="b_time" value="${BBS.b_time}" type="time" hidden ="hidden">
		<input name="b_writer" value="${BBS.b_writer}" placeholder="작성자" readonly="readonly">
		<input name="b_subject" placeholder="제목">
		<textarea rows="5" cols="20" name="b_content" placeholder="내용"></textarea>
		<input type="file" name="file" accept="image/*">
		<button>저장</button>
	</form>
	<% /* 
			file input box에 선택하는 파일 제한하기
			accept=".hwp" : 확장자가 hwp 인 파일만 선택할 수 있게
			accept=".jpg", accept=".png", accept=".gif" : 이밎 파일들 중에서  jpg, png, gif 확장자를 갖는 파일만
			
			accept="image/*" : 모든 이미지 파일
			accept="video/*" : 모든 동영상 파일
			accept="audio/*" : 모든 음성(음악) 파일
			accept="image/*", accept="video/*", accept="audio/*"  : 모든 이미지, 동영상, 음성 파일
	*/%>
</body>
</html>