
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/list/list.css">
<link
	href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Stencil+Text&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/9eb162ac0d.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar">
		<div class="navbar__logo">
			<i class="fas fa-paw"></i> <a href="">PDL</a>
		</div>

		<ul class="navbar__icons">
			<li><i class="fab fa-facebook"></i></li>
			<li><i class="fab fa-instagram"></i></li>
			<c:if test="${empty sessionScope.ID}">
				<li class="active"><a href="login">Login</a></li>
				<li><a href="signUp">Sign up</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.ID}">
				<li class="active"><a href="logout">Logout</a></li>
				<li><a href="signUp">Sign up</a></li>
			</c:if>
		</ul>
		<a href="#" class="navbar__toogleBtn"> <i class="fas fa-bars"></i>
		</a>
	</nav>
	<div class="inner">
		<nav class="left_nav">
			<div class="list_icon">
				<a href="list"><i class="fas fa-book-open"></i>
				<p>BOARD</p></a>
			</div>
		</nav>


		<div class="board">
			<div>
			<h2>글쓰기</h2>
			
			<input class="title_input" type="text" name="ti" placeholder="제목을 입력해 주세요" />
			</div>
			<textarea rows="40" cols="135" placeholder="내용을 입력해 주세요"></textarea>
			
		</div>
	</div>
	<hr>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/jq.js"></script>
</body>
</html>