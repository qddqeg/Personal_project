<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- root 경로 -->
<c:set var="root" value="${pageContext.request.contextPath}" />
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main_style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Stencil+Text&display=swap"
	rel="stylesheet">
<title>Document</title>
<script src="https://kit.fontawesome.com/9eb162ac0d.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="header">
	 <h1>Pet Daily</h1>
	</div>
	<hr>
		<div class="right_menu">
		 <div class="button">
		 	<c:if test="${empty sessionScope.ID}">
				<a href="login">Login</a>
			</c:if>
			<c:if test="${not empty sessionScope.ID}">
				<a href="logout">Logout</a>
			</c:if>
		</div>
		<div class="button">
		 	<a href="signUp">Sign up</a>
		</div>
		<div class="button">
			<a href="list">BOARD</a>
		</div>
		
		<div class="link_icon">
			<a href="https://www.facebook.com/"><i class="fab fa-facebook"></i></a>
			<a href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
		</div>
		<div class="button">
		<a href="main"><i class="fas fa-cat"></i><i class="fas fa-dog"></i></a>
		</div>
		</div>
		<div>
			<c:forEach var="p" items="${plist}">
				<a href="view?pid=${p.pid}">
				<img src="${root}/${p.path}"/></a>
			</c:forEach>
		</div>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/jq.js"></script>
</body>
</html>