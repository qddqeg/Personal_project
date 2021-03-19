<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- root 경로 -->
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td rowspan=3><img src="${root}/${ph.path}" /></td>
			<td>${ph.pname}</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
	<br>
	<br>
	<form action="" method="post">
		<div class="comment">
			<input type="text" name="img_comment" />
			<input type ="submit" value="입력">
		
		</div>
		
	</form>
</body>
</html>