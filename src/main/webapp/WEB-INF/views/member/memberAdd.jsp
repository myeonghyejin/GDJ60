<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER JOIN</title>
<c:import url="../template/common_css.jsp"></c:import>
<style>
	.redResult{
		color:deeppink
	}
	.blueResult{
		color:deepskyblue
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">Join Page</p>
	</div>
	<form action="./add" method="post" id="frm">
		<div class = "row col-md-4 mx-auto my-3">			
			<div class="col-12 my-2">
    			<label for="id" class="form-label fw-bold fs-6">ID</label>
    			<input type="text" name="id" class="form-control infos" id="id" placeholder="ID 입력">
				<div id="idResult" class="my-2"></div>
 			</div>
 			
			<div class="col-md-6 my-1">
    			<label for="pw" class="form-label fw-bold fs-6">Password</label>
    			<input type="password" name="pw" class="form-control" id="pw" placeholder="비밀번호 입력">
				<div id="pwResult" class="my-2"></div>
			</div>

			<div class="col-md-6 my-1">
    			<label for="pw" class="form-label fw-bold fs-6">Password</label>
    			<input type="password" name="pwCheck" class="form-control" id="pwCheck" placeholder="비밀번호 확인">
				<div id="pwCheckResult" class="my-2"></div>
			</div>
			
			<div class="col-12 my-2">
				<label for="name" class="form-label fw-bold fs-6">이름</label>
				<input type="text" name="name" class="form-control infos" id="name" placeholder="이름 입력">
				<div id="nameResult" class="my-2"></div>
			</div>
			
			<div class="col-12 my-2">
				<label for="phone" class="form-label fw-bold fs-6">전화 번호</label>
				<input type="tel" name="phone" class="form-control infos" id="phone" placeholder="하이픈(-) 포함하여 입력하세요">
				<div id="phoneResult" class="my-2"></div>
			</div>
			
			<div class="col-12 my-2">
				<label for="email" class="form-label fw-bold fs-6">E-mail</label>
				<input type="email" name="email" class="form-control infos" id="email" placeholder="이메일 입력">
				<div id="emailResult" class="my-2"></div>
			</div>
			
			<div class="row justify-content-center my-3">
				<button type="submit" class="btn btn-primary col-2" id="btn">등록</button>
			</div>
		</div>
	</form>
</div>
	<script src="../resources/js/memberAdd.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>