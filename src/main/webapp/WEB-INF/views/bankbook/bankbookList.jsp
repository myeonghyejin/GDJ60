<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<h1 class=title>Bankbook List Page</h1>
	
	<div class="image">
		<img alt="" src="../resources/images/3.jpg">
	</div>
	
	<table class="t1" border="1">
		<thead>
			<tr>
				<th>상품명</th>
				<th>이자율</th>
				<th>판매 여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="DTO">
				<tr>
					<td><a href="./detail?bookNum=${DTO.bookNum}">${pageScope.DTO.bookName}</a></td>
					<td>${DTO.bookRate}</td>
					<td>
<%-- 					<c:if test="${DTO.bookSale eq 1}">판매 중</c:if>
						<c:if test="${DTO.bookSale ne 1}">판매 중지</c:if> --%>
						<c:choose>
							<c:when test="${DTO.bookSale eq 1}">판매 중</c:when>
							<c:otherwise>판매 중지</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href=./add>상품 등록</a>
	
</body>
</html>