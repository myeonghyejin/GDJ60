<%@page import="com.mhj.s1.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">Member Update Page</p>
	</div>
	<form action="./update" method="post">
		<div class="row col-md-4 mx-auto my-5">
			<%-- <input type="hidden" name="id" value="${member.id}"> --%>
			<div class="col-md-6 my-1">
    			<label for="id" class="form-label fw-bold fs-6">ID</label>
    			<input type="text" name="id" class="form-control" id="id" value="${member.id}" disabled>
 			</div>
			<div class="col-md-6 my-1">
    			<label for="pw" class="form-label fw-bold fs-6">Password</label>
    			<input type="password" name="pw" class="form-control" id="pw" value="${member.pw}" disabled>
			</div>
			<div class="col-12 my-2">
				<label for="name" class="form-label fw-bold fs-6">이름</label>
				<input type="text" name="name" class="form-control" id="name" value="${member.name}">
			</div>
			<div class="col-12 my-2">
				<label for="phone" class="form-label fw-bold fs-6">전화 번호</label>
				<input type="tel" name="phone" class="form-control" id="phone" value="${member.phone}">
			</div>
			<div class="col-12 my-2">
				<label for="email" class="form-label fw-bold fs-6">E-mail</label>
				<input type="email" name="email" class="form-control" id="email" value="${member.email}">
			</div>
			<div class="row justify-content-center my-3">
				<button type="submit" class="btn btn-outline-warning col-2">수정</button>
			</div>
		</div>
	</form>
</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>