<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Member Join Page</h3>
	<div class = "col-6">
		<form action="./join" method="post">
			ID
			<input type="text" name="id">
			Password
			<input type="password" name="pw">
			이름
			<input type="text" name="name">
			전화 번호
			<input type="tel" name="phone">
			E-mail
			<input type="email" name="email">
			
			<button type="submit">회원가입</button>
		</form>
	</div>
</body>
</html>