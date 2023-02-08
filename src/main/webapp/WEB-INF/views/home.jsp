<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- 절대 경로 -->
<a href="./product/list?num=1&num=2&num=3">ProductList</a>
<!-- 상대 경로 -->
<a href="/product/list">ProductList</a>
<!-- 절대 경로 -->
<a href="/bankbook/list">BankbookList</a>
<!-- 상대 경로 -->
<a href="./bankbook/list">BankbookList</a>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>