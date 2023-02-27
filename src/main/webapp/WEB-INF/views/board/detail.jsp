<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<!-- 전체 -->
<div class="container-fluid my-5">

	<!-- Title -->
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">${boardName} Detail Page</p>
	</div>

	<!-- Contents -->
	<div class="row col-md-4 mx-auto my-5">
		<c:choose>
			<c:when test="${not empty DTO.num}">
				<div class="row mx-auto text-center border-bottom border-dark pb-4">
					<p class="fs-6">번호 ${DTO.num} | 작성자 ${DTO.writer} | 날짜 ${DTO.regDate} | 조회수 ${DTO.hit}</p>
				</div>
				<div class="row my-4">
					<p class="fs-4 fw-bold text-center">${DTO.title}</p>
					<p class="fs-5">${DTO.contents}</p>
				</div>
				<c:forEach items="${DTO.boardFileDTOs}" var="fileDTO">
					<div class="row justify-content-center mx-auto">
						 <a href="./fileDownload?fileNum=${fileDTO.fileNum}">${fileDTO.oriName}</a>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="row col-md-4 mx-auto text-center ">
					<p class="fs-2">존재하지 않는 페이지입니다.</p>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<!-- Buttons -->
<%-- 	<div class="row col-md-4 justify-content-center mx-auto">
		<c:if test="${boardName ne 'Notice'}">
			<a href="./reply?num=${DTO.num}" class="btn btn-primary col-3 mx-1">답글 달기</a>
		</c:if>
		<a href="./update?num=${DTO.num}" class="btn btn-primary col-2 mx-1">수정</a>
		<a href="./delete?num=${DTO.num}" class="btn btn-primary col-2 mx-1">삭제</a>
		<a href="./list" class="btn btn-primary col-2 mx-1">목록</a>
	</div> --%>
	
	<div class="row col-md-4 justify-content-center mx-auto">
		<form action="./update" id="frm">
			<input type="hidden" name="num" value="${DTO.num}">
			<button id="update" type="submit" class="btn btn-primary col-2 mx-1">수정</button>
			<button id="delete" type="button" class="btn btn-primary col-2 mx-1">삭제</button>
		</form>
	</div>

</div>

<c:import url="../template/common_js.jsp"></c:import>
<script type="text/javascript" src="../resources/js/boardForm.js"></script>
</body>
</html>