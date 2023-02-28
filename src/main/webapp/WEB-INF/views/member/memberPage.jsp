<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYPAGE</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
			<p class="fs-2" style="font-family: 'Impact'">MY PAGE</p>
		</div>
		<div class="row col-md-4 mx-auto my-5">
			<div class="row mx-auto text-center border-bottom border-dark pb-4">
				<p class="fs-5">이름 : ${DTO.name}</p>
				<p class="fs-5">전화 번호 : ${DTO.phone}</p>
				<p class="fs-5">E-mail : ${DTO.email}</p>
				<p class="fs-5">등급 : ${DTO.roleDTOs.roleName}</p>
			</div>
			<div class="row justify-content-center mx-auto">
				<a href="./update" class="btn btn-primary col-2 my-4">정보 수정</a>
			</div>
		</div>
	</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>