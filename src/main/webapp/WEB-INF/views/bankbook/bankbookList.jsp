<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BANKBOOK</title>
	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container-fluid my-5">

	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">Bankbook List Page</p>
	</div>
	
	<div class="row col-md-4 mx-auto my-5">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품명</th>
					<th>이자율</th>
					<th>판매 여부</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${list}" var="DTO">
					<tr>
						<td><a href="./detail?bookNum=${DTO.bookNum}">${pageScope.DTO.bookName}</a></td>
						<td class="tdl_td">${DTO.bookRate}</td>
						<td class="tdl_td">
<%-- 						<c:if test="${DTO.bookSale eq 1}">판매 중</c:if>
							<c:if test="${DTO.bookSale ne 1}">판매 중지</c:if> --%>
							<c:choose>
								<c:when test="${DTO.bookSale eq 1}">판매 중</c:when>
								<c:otherwise>판매 중지</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="rowmx-auto">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
				
					<li class="page-item">
						<a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					
					<li class="page-item ${pager.before?'disabled':''}">
						<a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
							<span aria-hidden="true">&lsaquo;</span>
						</a>
					</li>
					
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
					</c:forEach>
					
					<li class="page-item  ${pager.after eq false ? 'disabled' : ''}">
						<a class="page-link" href="./list?page=${pager.lastNum+1}"  aria-label="Next">
							<span aria-hidden="true">&rsaquo;</span>
						</a>
	 				</li>
	 				
	 				<li class="page-item">
						<a class="page-link" href="./list?page=${pager.lastNum+1}"  aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
	 				</li>
	 				
				</ul>
			</nav>
		</div>
		
		<div class="row justify-content-center mx-auto">
			<a href=./add class="btn btn-outline-primary col-2">상품 등록</a>
		</div>
		
	</div>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>