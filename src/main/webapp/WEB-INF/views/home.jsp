<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- 절대 경로 -->
<a href="./product/list?num=1&num=2&num=3" class="menu">ProductList</a>
<!-- 상대 경로 -->
<a href="/product/list" class="menu">ProductList</a>
<!-- 절대 경로 -->
<a href="/bankbook/list" class="menu">BankbookList</a>
<!-- 상대 경로 -->
<a href="./bankbook/list" class="menu">BankbookList</a><br>

<img alt="hyein hani minji" src="/resources/images/2.jpg">
<img alt="hyein hani" src="./resources/images/1.png">

<iframe width="560" height="315" src="https://www.youtube.com/embed/js1CtxSY38I" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>