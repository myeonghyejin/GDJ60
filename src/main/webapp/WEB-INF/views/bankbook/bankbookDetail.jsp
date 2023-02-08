<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Detail Page</h1>
	<c:choose>
		<c:when test="${not empty DTO.bookNum}">
			<h3>상품 번호 : ${DTO.bookNum}</h3>
			<h3>상품명 : ${DTO.bookName}</h3>
			<h3>상세 정보 : ${DTO.bookDetail}</h3>
			<h3>이자율 : ${DTO.bookRate}</h3>
			<h3>판매 여부 : ${DTO.bookSale}</h3>
			<a href="./delete?bookNum=${DTO.bookNum}">삭제</a>
		</c:when>
		<c:otherwise>
			<h3>존재하지 않는 상품입니다.</h3>
		</c:otherwise>
	</c:choose>
	<a href="./update?bookNum=${DTO.bookNum}">수정</a>
	<a href="./list">목록으로</a>
</body>
</html>