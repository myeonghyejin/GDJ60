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
	<h1>Bankbook List Page</h1>
	
	<table>
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
					<td>${DTO.bookNum}</td>
					<td>${DTO.bookRate}</td>
					<td>${DTO.bookSale}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>