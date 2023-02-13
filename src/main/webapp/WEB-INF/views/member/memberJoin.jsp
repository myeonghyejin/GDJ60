<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER JOIN</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">Member Join Page</p>
	</div>
	<form action="./memberJoin" method="post">
		<div class = "row col-md-4 mx-auto my-3">			
			<div class="col-md-6 my-1">
    			<label for="id" class="form-label fw-bold fs-6">ID</label>
    			<input type="text" class="form-control" id="id">
 			</div>
 			
			<div class="col-md-6 my-1">
    			<label for="pw" class="form-label fw-bold fs-6">Password</label>
    			<input type="password" class="form-control" id="pw">
			</div>
			
			<div class="col-12 my-2">
				<label for="name" class="form-label fw-bold fs-6">이름</label>
				<input type="text" class="form-control" id="name">
			</div>
			
			<div class="col-12 my-2">
				<label for="phone" class="form-label fw-bold fs-6">전화 번호</label>
				<input type="tel" class="form-control" id="phone" placeholder="하이픈(-) 포함하여 입력하세요.">
			</div>
			
			<div class="col-12 my-2">
				<label for="email" class="form-label fw-bold fs-6">E-mail</label>
				<input type="email" class="form-control" id="email">
			</div>
			
			<div class="row justify-content-center my-3">
				<button type="submit" class="btn btn-outline-warning col-2">등록</button>
			</div>
		</div>
	</form>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>