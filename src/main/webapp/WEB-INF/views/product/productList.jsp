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
		
		<!-- Paging -->
		<div class="rowmx-auto">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
				
					<li class="page-item ${pager.page eq 1?'disabled':''}">
						<a class="page-link" href="./list?page=1&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					
					<li class="page-item ${pager.before?'disabled':''}">
						<a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
							<span aria-hidden="true">&lsaquo;</span>
						</a>
					</li>
					
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>
					
					<li class="page-item  ${pager.after eq false ? 'disabled' : ''}">
						<a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"  aria-label="Next">
							<span aria-hidden="true">&rsaquo;</span>
						</a>
	 				</li>
	 				
	 				<li class="page-item ${pager.page eq pager.totalPage?'disabled' : ''}">
						<a class="page-link" href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}"  aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
	 				</li>
	 				
				</ul>
			</nav>
		</div>
		
		<!-- 검색창 -->
		<form action="./list" method="get" class="row g-3">
			<div class="row justify-content-center mx-auto">
				<div class="col-auto">
					<label for="kind" class="visually-hidden">Email</label>
					<select class="form-select" name="kind" id="kind" aria-label="Default select example">
						<option value="title">상품명</option>
						<option value="contents">상품 내용</option>
					</select>
				</div>
				<div class="col-auto">
					<label for="search" class="visually-hidden">Search</label>
					<input type="text" class="form-control" name="search" id="search" placeholder="검색어를 입력하세요.">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-outline-primary mb-3">검색</button>
				</div>
			</div>
		</form>
		
		<!-- 상품 등록 버튼 -->
		<div class="row justify-content-center">
			<a class="btn btn-outline-warning col-2" href="./productAdd">상품 등록</a>
		</div>
	</div>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>