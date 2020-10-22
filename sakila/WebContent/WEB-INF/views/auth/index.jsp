<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Sakila Movie</h1>
	
	<div>
		<span>${LoginStaff.email}</span>관리자님 <!-- session.loginstaff -->
	</div>
	<div>
		<a href=${pageContext.request.contextPath}/auth/LogoutServlet>로그아웃</a>
	</div>
</body>
</html>
