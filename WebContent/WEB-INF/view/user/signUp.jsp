<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>회원가입page</title>
	<link rel="stylesheet" href="${root}/css/user/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Stencil+Text&display=swap" rel="stylesheet">
   <script
      src="https://kit.fontawesome.com/9eb162ac0d.js"
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript" src="${root}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${root}/js/jq.js"></script>
    <script type="text/javascript" src="${root}/js/signUp.js" ></script>
</head>
<body>
<nav class="navbar">
            <div class="navbar__logo">
               <i class="fas fa-paw"></i>
               <a href="main">PDL</a>
            </div>
		<div class="search">
            <input class="sea_input" type="text" placeholder="검색어 입력">
            <button class="but">검색</button>
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
            <a href="#" class="navbar__toogleBtn">
               <i class="fas fa-bars"></i>
            </a>
         </nav>

         <div>
            <div>
               <div class="inner">
                  <div class="left_nav">
                  	<div class="list_icon">
                <a href=""><i class="fas fa-book-open"></i><p>BOARD</p></a>
                  </div>
					</div>
					</div>
					</div>
					
					

					<form id="joinform" name="joinform" action="signUp" method="post"
						onsubmit="return createFrom(this)">

						<h3 style="text-align: center;">회원가입 화면</h3>
						<div class="menu" style="border-bottom-width: 0px;">


							<div id="id"></div>
							<span> <input type="text" class="checkInfo" name="id"
								size="12" placeholder="ID" />
								<button type="button" onclick="idCheck(joinform, '${root}')">아이디
									중복</button>
							</span>
						</div>

						<div class="menu " style="border-bottom-width: 0px;">
							<div id="id"></div>
							<span> <input type="password" class="checkInfo"
								name="password" size="12" placeholder="PASSWORD" />
							</span>
						</div>

						<div class="menu " style="border-bottom-width: 0px;">
							<div id="id"></div>
							<span> <input type="password" class="checkInfo"
								name="passwordCheck" size="12" placeholder="PASSWORD CHECK" />
							</span>
						</div>

						<div class="menu " style="border-bottom-width: 0px;">
							<div id="id"></div>
							<span> <input type="text" class="checkInfo" name="name"
								size="12" placeholder="NAME" />
							</span>
						</div>


						<div class="menu" style="border-bottom-width: 0px;">
							<div id="id" style="margin-left: 10px,"></div>
							<span> <input type="email" name="email" size="25"
								placeholder="E-MAIL" />
							</span>
						</div>
						<div class="menu" style="text-align: center;">
							<span> <input type="submit" value="가입" /> <input
								type="reset" value="취소" />
							</span>
						</div>
					</form>
					
</body>
</html>