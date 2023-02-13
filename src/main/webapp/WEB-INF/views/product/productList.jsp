<%@page import="com.mhj.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT</title>
	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container-fluid my-5">

	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">Product List</p>
	</div>
	
<%-- 	<% 
		List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list");
		for(ProductDTO productDTO:ar){
	%>
		<h3><%= productDTO.getProductName() %></h3>
		<h3><%= productDTO.getProductJumsu() %></h3>
	<%} %> --%>
	
	<div class="row col-md-4 mx-auto my-5">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품명</th>
					<th>평점</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${list}" var="DTO"> <!-- DTO는 page영역에 담김 -->
					<tr>
						<td><a href="./detail?productNum=${DTO.productNum}">${pageScope.DTO.productName}</a></td>
						<td>${DTO.productJumsu}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row justify-content-center">
			<a class="btn btn-outline-warning col-2" href="./productAdd">상품 등록</a>
		</div>
	</div>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>