<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-striped">
	<c:forEach items="${list}" var="DTO">
		<tr>
			<td id="contents${DTO.num}"><textarea readonly="readonly">${DTO.contents}</textarea></td>
			<td>${DTO.writer}</td>
			<td>${DTO.regDate}</td>
			<td>
				<c:if test="${member.id eq DTO.writer}">
					<button class="btn btn-info upd" data-comment-num="${DTO.num}">수정</button>
				</c:if>
			</td>
			<td>
				<c:if test="${member.id eq DTO.writer}">
					<button class="btn btn-danger del" data-comment-num="${DTO.num}">삭제</button>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>

<!-- Paging -->
<div class="rowmx-auto">
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		
			<li class="page-item ${pager.page eq 1?'disabled':''}">
				<a class="page-link" href="#" aria-label="Previous" data-board-page="1">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			
			<li class="page-item ${pager.before?'disabled':''}">
				<a class="page-link" href="#" aria-label="Previous" data-board-page="${pager.startNum-1}">
					<span aria-hidden="true">&lsaquo;</span>
				</a>
			</li>
								
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link" href="#" data-board-page="${i}">${i}</a></li>
			</c:forEach>
			
			<li class="page-item ${pager.after eq false ? 'disabled' : ''}">
				<a class="page-link" href="#"  aria-label="Next" data-board-page="${pager.lastNum+1}">
					<span aria-hidden="true">&rsaquo;</span>
				</a>
				</li>
 				
 			<li class="page-item ${pager.page eq pager.totalPage?'disabled' : ''}">
				<a class="page-link" href="#"  aria-label="Next" data-board-page="${pager.totalPage}">
					<span aria-hidden="true">&raquo;</span>
				</a>
				</li>
				
		</ul>
	</nav>
</div>