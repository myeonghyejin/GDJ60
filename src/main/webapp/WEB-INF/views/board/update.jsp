<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
<c:import url="../template/common_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	<!-- Title -->
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">${boardName} Update Page</p>
	</div>
	
	<!-- Contents -->
	<form action="./update" method = "post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${DTO.num}">
		<div class="row col-md-4 mx-auto my-5">
			<div class="fw-bold fs-5 col-12">
				<label for="writer" class="form-label">작성자</label>
				<input type="text" name="writer" class="form-control" id="writer" value="${DTO.writer}" readonly><br>
			</div>
			<div class="fw-bold fs-5 col-12">
				<label for="title" class="form-label">제목</label>
				<input type="text" name="title" class="form-control" id="title" value="${DTO.title}"><br>
			</div>			
			<div class="fw-bold fs-5 col-12">
				<label for="contents" class="form-label">내용</label>
				<textarea name="contents" class="form-control" id="contents" rows="3">${DTO.contents}</textarea><br>
			</div>
			<div id="fileList" class="my-5">	
				<button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
				
				<c:forEach items="${DTO.boardFileDTOs}" var="fileDTO">
					<div class="input-group mb-3 my-3">
						<div class="input-group-text">
							<input class="form-check-input mt-0 deleteCheck" type="checkbox" name="fileNum" value="${fileDTO.fileNum}" aria-label="Checkbox for following text input">
						</div>
						<input type="text" disabled value="${fileDTO.oriName}" class="form-control" aria-label="Text input with checkbox">
					</div>
				</c:forEach>
			</div>		
			<div class="row justify-content-center my-5">
				<button type="submit" class="btn btn-primary col-2">글쓰기</button>
			</div>
		</div>
   </form>
</div>
<script src="../resources/js/fileManager.js"></script>
<script>
	setMax(5);
	setCount('${DTO.boardFileDTOs.size()}');
	setParam("files")
	$('#contents').summernote();
</script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>