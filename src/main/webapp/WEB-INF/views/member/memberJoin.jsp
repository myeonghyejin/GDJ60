<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h3>Member Join Page</h3>
	<div class = "col-6">
		<form action="./memberJoin" method="post">
			<p>ID
			<input type="text" name="id"></p>
			<p>Password
			<input type="password" name="pw"></p>
			<p>이름
			<input type="text" name="name"></p>
			<p>전화 번호
			<input type="tel" name="phone"></p>
			<p>E-mail
			<input type="email" name="email"></p>
			<p><button type="submit">등록</button></p>
		</form>
	</div>
</body>
</html>