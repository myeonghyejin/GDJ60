<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
	<div class="container-fluid">
		<a href="../" class="navbar-brand"><img src="/resources/images/logo.png" alt=""></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item"><a class="nav-link" style="font-family: 'Impact'" href="/notice/list">NOTICE</a></li>
            <li class="nav-item"><a class="nav-link" style="font-family: 'Impact'" href="/product/list">PRODUCT</a></li>
            <li class="nav-item"><a class="nav-link" style="font-family: 'Impact'" href="/bankbook/list">BANKBOOK</a></li>
            <li class="nav-item"><a class="nav-link" style="font-family: 'Impact'" href="#">ETC</a></li>
        </ul>
	    <ul class="navbar-nav">
        	<c:if test="${empty member}">
	        	<li class="nav-item"><a class="nav-link" style="font-size: 11px" href="/member/login">LOGIN</a></li>
	            <li class="nav-item"><a class="nav-link" style="font-size: 11px" href="/member/memberAgree">JOIN</a></li>
        	</c:if>
        	<c:if test="${not empty member}">
	        	<li class="nav-item"><a class="nav-link" style="font-size: 11px" href="/member/myPage">MYPAGE</a></li>
	            <li class="nav-item"><a class="nav-link" style="font-size: 11px" href="/member/logout">LOGOUT</a></li>
			</c:if>
				<li class="nav-item"><a class="nav-link" style="font-size: 11px" href="#">KO</a></li>
				<li class="nav-item"><a class="nav-link" style="font-size: 11px" href="#">EN</a></li>
				<li class="nav-item"><a class="nav-link" style="font-size: 11px" href="#">JP</a></li>
				<li class="nav-item"><a class="nav-link" style="font-size: 11px" href="#">CN</a></li>
	    </ul>
	</div>
</nav>