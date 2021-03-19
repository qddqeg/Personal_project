<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/list/detail.css">
<link
	href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Stencil+Text&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/9eb162ac0d.js"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar">
		<div class="navbar__logo">
			<i class="fas fa-paw"></i> <a href="main">PDL</a>
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
	<table border=1>
		<tr>
			<td>제목</td>
			<td colspan="3">${DTO.title}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td colspan="3"><fmt:formatDate pattern="yyyy.MM.dd. hh:mm"
					value="${DTO.regDate}" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${DTO.writerId}</td>

			<td>조회수</td>
			<td><fmt:formatNumber type="number" pattern="###,###"
					value="${DTO.hit}"></fmt:formatNumber></td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td colspan="3"><c:forTokens var="fileName" items="${DTO.files}"
					delims="," varStatus="t">
					<c:set var="style" value="" />

					<c:if test="${fn:endsWith(fileName,'.rar')}">
						<c:set var="style" value="font-weight: bold; color:red;" />
					</c:if>
					<a href="../../../upload/${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a>
					<c:if test="${!t.last}">
						
					</c:if>
				</c:forTokens></td>
		</tr>
		<tr>
			<td colspan="4" >${DTO.content}</td>
		</tr>

	</table>
	<!-- 목록 버튼 -->
	
	
	
	<form action="detail" method="post">

	<c:set var="cnt" value="${count}" />
	<c:if test="%{cnt==0}">
		<h3>댓글이 업수다</h3>
	</c:if>
	<c:if test="${cnt!=0}">
		<table border=1>
			<c:forEach var="cl" items="${comList}" varStatus="st">
				<tr>
					<th>${cl.writer}</th>
					<td>${cl.comment}</td>
					<td>${cl.regdate}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<textarea rows="10" cols="10" name="comment" placeholder="댓글을 입력하세요."></textarea>
		<input type="hidden" name="pageID" value="${param.id}">
		
			<input type="hidden" name="writer"
				value="${sessionScope.ID}">

				<c:if test="${not empty sessionScope.ID}">
						<input type="submit" value="등록" /> 
				</c:if> 
				<c:if test="${empty sessionScope.ID}">
						<input type="button" onclick="login()" value="등록" /> 
				</c:if> 
				
		<div class="right_menu">
		 <div class="button">
		 	<a href="list?p=${param.p}&f=${param.f}&q=${param.q}">목록</a>
		</div>
		<br>
		<br>
		<br>
		<br>
		<div class="button">
		<a href="main"><i class="fas fa-cat"></i><i class="fas fa-dog"></i></a>
		</div>
		</div>
	</form>
	</div>
</div>
	
	<script>
		function login() {
			alert('로그인부터하세요');
			location.href='/Personal_project/login'
			}
	</script>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/jqu2.js"></script>
	
</body>
</html>