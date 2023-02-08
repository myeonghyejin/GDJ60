<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Update Page</h1>
	<form action="./update" method="post">
		이름
		<input type="text" name = "bookName" value="${DTO.bookName}" placeholder="제품명 입력"><br>
		상세 정보
		<textarea name="bookDetail" rows="10" cols="20">${DTO.bookDetail}</textarea><br>
		이자율
		<input type="text" name="bookRate" value=${DTO.bookRate}><br>
		판매 여부
		<input type="number" name="bookSale" value="${DTO.bookSale}"><br>
		<input type="submit" value="수정">
		<button type="submit">수정</button>
	</form>
</body>
</html>