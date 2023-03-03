<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<!-- 전체 -->
<div class="container-fluid my-5">

	<!-- Title -->
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">Bankbook Detail Page</p>
	</div>

	<!-- Contents -->
	<div class="row col-md-4 mx-auto my-5">
		<c:choose>
			<c:when test="${not empty DTO.bookNum}">
				<div class="row mx-auto border-bottom border-dark pb-4">
					<p class="fs-5 fw-bold">상품 번호</p>
					<p class="fs-5 border-bottom border-dark pb-4">${DTO.bookNum}</p>
					<p class="fs-5 fw-bold">상품명</p>
					<p class="fs-5 border-bottom border-dark pb-4">${DTO.bookName}</p>
					<p class="fs-5 fw-bold">상세 정보</p>
					<p class="fs-5 border-bottom border-dark pb-4">${DTO.bookDetail}</p>
					<p class="fs-5 fw-bold">이자율</p>
					<p class="fs-5 border-bottom border-dark pb-4">${DTO.bookRate}</p>
					<p class="fs-5 fw-bold">판매 여부</p>
					<c:if test="${DTO.bookSale eq 1}">
						<p class="fs-5">판매 중</p>
					</c:if>
					<c:if test="${DTO.bookSale eq 0}">
						<p class="fs-5">판매 중지</p>
					</c:if>
				</div>
				<c:if test="${not empty DTO.bankbookImgDTO}">
					<div class="row justify-content-center mx-auto">
						<img alt="" src="../resources/upload/bankbook/${DTO.bankbookImgDTO.fileName}">
					</div>
				</c:if>
			</c:when>
			<c:otherwise>
				<div class="row col-md-4 mx-auto text-center">
					<p class="fs-2">존재하지 않는 상품입니다.</p>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

<!-- Reply -->
<div class="row col-md-4 mx-auto my-5">
	<div class="mb-3">
	  <textarea class="form-control" rows="3" id="replyContents"></textarea>
	</div>
	<div class="mb-3">
		<button type="submit" class="btn btn-primary col-2 mx-1" id="replyAdd" data-book-num="${DTO.bookNum}">등록</button>
	</div>
</div>

	<!-- Buttons -->
<%-- 	<c:if test="${member.id eq DTO.writer}"> --%>
		<form action="./update" id="frm">
			<div class="row col-md-4 justify-content-center mx-auto">
				<a href="./delete?bookNum=${DTO.bookNum}" class="btn btn-outline-primary col-2 mx-1">삭제</a>
				<a href="./update?bookNum=${DTO.bookNum}" class="btn btn-outline-primary col-2 mx-1">수정</a>
			</div>
		</form>
<%-- 	</c:if> --%>
	<div class="row col-md-4 justify-content-center mx-auto my-2">
		<a href="./list" class="btn btn-primary col-2 mx-1">목록</a>
	</div>
</div>

<div class="row col-md-4 justify-content-center mx-auto" id="commentListResult">
</div>

<c:import url="../template/common_js.jsp"></c:import>
<script src="/resources/js/bankbookReply.js"></script>
</body>
</html>