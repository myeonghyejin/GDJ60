<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
			<p class="fs-2" style="font-family: 'Impact'">Login Page</p>
		</div>
	<div class="row col-md-4 mx-auto my-5">
		<form action="./login" method="post">
			<!-- Email input -->
			<div class="form-outline mb-4">
		    	<label class="form-label fw-bold fs-6" for="form2Example1">ID</label>
				<input type="text" id="form2Example1" class="form-control" name="id" />
			</div>
		
			<!-- Password input -->
			<div class="form-outline mb-4">
				<label class="form-label fw-bold fs-6" for="form2Example2">Password</label>
				<input type="password" id="form2Example2" class="form-control" name="pw" />
			</div>
			
 			
			<!-- 2 column grid layout for inline styling -->
			<div class="row mb-4">
				<div class="col d-flex justify-content-center">
			
				<!-- Checkbox -->
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
					<label class="form-check-label" for="form2Example31">ID 기억하기</label>
				</div>
			</div>
				<div class="col">
      				<!-- Simple link -->
					<a href="#!" style="text-decoration: none; color: black">ID/Password 찾기</a>
				</div>
			</div>
			
			<!-- Submit button -->
			<div class="row justify-content-center mx-auto">
 				<button type="submit" class="btn btn-primary col-2 btn-block mb-4">Sign in</button>
 			</div>
		</form>
	</div>
</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>