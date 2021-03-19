<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content=width=divice-width initial-scale="1">
   <link rel="stylesheet" href="css/login_style.css">
   <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Stencil+Text&display=swap" rel="stylesheet">
   <script
      src="https://kit.fontawesome.com/9eb162ac0d.js"
      crossorigin="anonymous"
    ></script>
   <script src="js/jquery-3.1.1.min.js"></script>
   <script src="js/jq.js"></script>
   <title>JSP Board</title>
</head>

<body>
      <nav class="navbar">
            <div class="navbar__logo">
               <i class="fas fa-paw"></i>
               <a href="main">PDl/a>
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
                  <div class="login_screen">
                  <form method="post" action="login">
                     <h3>로그인 화면</h3>
                     ${sessionScope.ID}
                     
                     <div>
                        <input type="text" class="form-control" placeholder="ID" name="userID" maxlength="20">
                     </div>
                     <div>
                        <input type="password" class="form-control" placeholder="PASSWORD" name="userPASS"
                           maxlength="20">
                     </div>
                     <input type="submit"value="Login">
                  </form>
                  </div>
               </div>
            </div>
         </div>
</body>

</html>