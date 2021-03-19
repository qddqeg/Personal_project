
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
			<i class="fas fa-paw"></i> <a href="main">PDL</a>
		</div>
		<form>
		<select name="f">
				<option ${(param.f == "title")?"selected":""} value="title">제목</option>
				<option ${(param.f == "writer_id")?"selected":""} value="writer_id">글쓴이</option>
		</select>
		<div class="search">
			
				<input class="sea_input" type="text" name="q" value="${param.q}" placeholder="검색어 입력" />
				<input class="but" type="submit" value="Search" />
			
		</div>
		</form>


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
			<table>

				<tr class="tr1">
					<td>번호</td>
					<td>제목</td>
					<td>작성내용</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
				<%-- 
		<%List<Notice> list =(List<Notice>)request.getAttribute("list");
      for(Notice nt : list){
    	  pageContext.setAttribute("n", nt);

   %>
   --%>
				<c:forEach var="n" items="${list}" varStatus="t">
					<tr>
						<td><a
							href="detail?id=${n.id}&p=${param.p}&f=${param.f}&q=${param.q}">${n.id}</a></td>
						<td><a
							href="detail?id=${n.id}&p=${param.p}&f=${param.f}&q=${param.q}">${n.title}</a></td>
						<td><a
							href="detail?id=${n.id}&p=${param.p}&f=${param.f}&q=${param.q}">${n.content}</a></td>
						<td><a
							href="detail?id=${n.id}&p=${param.p}&f=${param.f}&q=${param.q}">${n.writerId}</a></td>
						<td><a
							href="detail?id=${n.id}&p=${param.p}&f=${param.f}&q=${param.q}">
								<fmt:formatDate pattern="yyyy.MM.dd." value="${n.regDate}"></fmt:formatDate>
						</a></td>
						<td><a
							href="detail?id=${n.id}&p=${param.p}&f=${param.f}&q=${param.q}">
								<fmt:formatNumber type="number" pattern="###,###"
									value="${n.hit}"></fmt:formatNumber>
						</a></td>

					</tr>
				</c:forEach>
				<%--<%}%>--%>
			</table>

			<!-- startnum 변수 선언 및 값 할당 -->
			<c:set var="page" value="${empty param?1:param.p}"></c:set>
			<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
			<c:set var="lastNum"
				value="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>



			<!-- 현재 페이지 -->
			<div>
					<span>${empty param?1:param.p}</span>/${lastNum} pages
			</div>

			
			<!-- 페이지 이동 -->


			<!-- Prev 버튼-->
			<c:if test="${startNum > 1}">
				<a href="?p=${startNum-1}&f=&q=">Prev</a>
			</c:if>
			<c:if test="${startNum <= 1}">
				<a href="#" onclick="alert('첫번째 페이지입니다.');">Prev</a>
			</c:if>


			<div class>
			<c:forEach var="i" begin="0" end="4">
				<c:if test="${param.p == (startNum+i)}">
					<c:set var="style" value="font-weight: bold; color :red;"></c:set>
				</c:if>
				<c:if test="${param.p != (startNum+i)}">
					<c:set var="style" value="" />
				</c:if>
				<a style="${style}"
					href="?p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}</a>
			</c:forEach>
			</div>

			<!-- next 버튼-->
			<c:if test="${startNum+5 <= lastNum}">
				<a href="?p=${startNum+5}&t=&q=">Next</a>
			</c:if>
			<c:if test="${startNum+5 > lastNum}">
				<a href="#" onclick="alert('마지막 페이지입니다.');">Next</a>
			</c:if>

			<script src="js/jquery-3.1.1.min.js"></script>
			<script src="js/jq.js"></script>
		</div>
	</div>
	<hr>
	<div>
	<c:if test="${not empty sessionScope.ID}">
		<a href="/Personal_project/writing">글작성</a>
	</c:if>
	<c:if test="${empty sessionScope.ID}">
		
		<a href="#" onclick="login()">글작성</a>
	</c:if>
	
	</div>
	
	
	<script>
	
	function login() {
		alert('로그인부터하세요');
		location.href='/Personal_project/login'
	}
	
	</script>
</body>
</html>