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
		<input type="hidden" name="bookNum" value="${DTO.bookNum}">
		<fieldset>
			<legend>이름</legend>
			<input type="text" name="bookName" value="${DTO.bookName}" placeholder="제품명 입력">
		</fieldset>
		<fieldset>
			<legend>상세 정보</legend>
			<textarea name="bookDetail" rows="10" cols="20">${DTO.bookDetail}</textarea>
		</fieldset>
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate" value="${DTO.bookRate}">
		</fieldset>
		<fieldset>
			<legend>판매 여부</legend>
			<label for="bs1">
				판매<input id="bs1" type="radio" ${DTO.bookSale eq 1 ? 'checked' :''} name="bookSale" value="${DTO.bookSale}">
			</label>
			<label for="bs2">
				판매 중지 <input id="bs2" type="radio" ${DTO.bookSale eq 0 ? 'checked' :''} name="bookSale" value="${DTO.bookSale}">
			</label>
		</fieldset>
		<fieldset>
			<select name="bookSale">
				<option ${DTO.bookSale eq 1 ? 'selected' :''} value="1">판매</option>
				<option ${DTO.bookSale eq 1 ? 'selected' :''} value="0">판매 중지</option>
			</select>
		</fieldset>
		<input type="submit" value="수정">
		<button type="submit">수정</button>
	</form>
</body>
</html>