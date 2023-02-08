<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>BankBook Add Page</h1>
   <form action="./add" method = "post">
		이름
		<input type="text" name = "bookName" placeholder="제품명 입력"><br>
		상세 정보
		<textarea name="bookDetail" rows="" cols=""></textarea><br>
		이자율
		<input type="text" name="bookRate"><br>
		판매 여부
		<input type="number" name="bookSale"><br>
		<input type="submit" value="등록">
		<button type="submit">전송</button>
   </form>
</body>
</html>