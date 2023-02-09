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
		<fieldset>
			<legend>이름</legend>
			<input type="text" name = "bookName" placeholder="제품명 입력"><br>
		</fieldset>
		<fieldset>
			<legend>상세 정보</legend>
			<textarea name="bookDetail" rows="" cols=""></textarea><br>
			</fieldset>
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate"><br>
		</fieldset>
		<fieldset>
			<legend>판매 여부</legend>
			<label for="bs1">판매</label>
			<input id="bs1" type="radio" name="bookSale" value="1" checked><br>
			<label for="bs2">판매 중지</label>
			<input id="bs2" type="radio" name="bookSale" value="0"><br>
		</fieldset>
		<fieldset>
			<legend>판매 여부</legend>
			<select name="bookSale">
				<option value="1">판매</option>
				<option value="0">판매 중지</option>
			</select>
		</fieldset>
		<input type="submit" value="등록">
		<button type="submit">전송</button>
   </form>
</body>
</html>