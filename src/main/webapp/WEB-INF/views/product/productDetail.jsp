lines (20 sloc)  577 Bytes

<%@page import="com.mhj.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	<% ProductDTO productDTO = (ProductDTO)request.getAttribute("DTO"); %>
	
	<h3><%= productDTO.getProductName() %> </h3>
	<h3><%= productDTO.getProductDetail() %></h3>
	
	<hr>
	<h3>${requestScope.DTO.productName}</h3>
	<h3>${DTO.getProductDetail()}</h3>
	<h3>${DTO.productRating * DTO.productNum}</h3>
</body>
</html>