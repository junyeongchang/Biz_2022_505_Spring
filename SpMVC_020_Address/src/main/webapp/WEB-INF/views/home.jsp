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
	<h1>반값습니다.</h1>
	<form method="post">
		<input type="hidden" value = '<c:out value="${addrVO.a_seq}" default="0"/>' name="a_seq"> 
		<input type="text" value="${addrVO.a_name}" name="a_name" placeholder="이름을 입력해주세요"> 
		<input type="text" value="${addrVO.a_tel}" name="a_tel" placeholder="전화번호를 입력해주세요"> 
		<input type="text" value="${addrVO.a_address}" name="a_address" placeholder="주소를 입력해주세요">
		<button>저장</button>
	</form>
	<h1>주소 리스트</h1>
	<table class="address-table">
		<thead>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ADDRESSES}" var="addr">
				<tr data-seq="${addr.a_seq}">
					<td><a href="${rootPath}/detail?seq=${addr.a_seq}">${addr.a_name}</a></td>
					<td>${addr.a_tel}</td>
					<td>${addr.a_address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>