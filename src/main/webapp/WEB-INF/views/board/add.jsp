<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	<!-- Title -->
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">${boardName} Add Page</p>
	</div>
	
	<!-- Contents -->
	<form action="./add" method = "post" enctype="multipart/form-data">
		<div class="row col-md-4 mx-auto my-5">
			<div class="fw-bold fs-5 col-12">
				<label for="writer" class="form-label">작성자</label>
				<input type="text" name="writer" class="form-control" id="writer"><br>
			</div>
			<div class="fw-bold fs-5 col-12">
				<label for="title" class="form-label">제목</label>
				<input type="text" name="title" class="form-control" id="title" placeholder="제목 입력"><br>
			</div>			
			<div class="fw-bold fs-5 col-12">
				<label for="contents" class="form-label">내용</label>
				<textarea name="contents" class="form-control" id="contents" rows="3" placeholder="상세 정보 입력"></textarea><br>
			</div>
			<div id="fileList">
				<!-- <div class="fw-bold fs-5 col-12 mt-3">
					<label for="files" class="form-label">Image</label>
					<input type="file" class="form-control" id="files" name="files">
					<button type="button">X</button>
				</div> -->
				<button type="button" class="btn btn-outline-primary" id="fileAdd">ADD</button>
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
	setParam("files")
</script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>